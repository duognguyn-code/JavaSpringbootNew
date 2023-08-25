app.controller('checkinandcheckout', function ($rootScope,$scope, $http) {

    const apiCheckin ="http://localhost:7777/api/time-keep/checkin/";
    const apiCheckOut ="http://localhost:7777/api/time-keep/checkout/";
    $scope.message = function (mes) {
        const Toast = Swal.mixin({
            toast: true,
            position: 'top-end',
            showConfirmButton: false,
            timer: 2000,
            timerProgressBar: true,
            didOpen: (toast) => {
                toast.addEventListener('mouseenter', Swal.stopTimer)
                toast.addEventListener('mouseleave', Swal.resumeTimer)
            }
        })
        Toast.fire({
            icon: 'success',
            title: mes,
        })
    }
    $scope.error = function (err) {
        const Toast = Swal.mixin({
            toast: true,
            position: 'top-end',
            showConfirmButton: false,
            timer: 1500,
            timerProgressBar: true,
            didOpen: (toast) => {
                toast.addEventListener('mouseenter', Swal.stopTimer)
                toast.addEventListener('mouseleave', Swal.resumeTimer)
            }
        })

        Toast.fire({
            icon: 'error',
            title: err,
        })
    }
    $scope.checkIn = function() {
        // Gửi yêu cầu check-in/check-out đến API
        let timerInterval
        Swal.fire({
            title: 'Đang checkin  vui lòng chờ!',
            html: 'Vui lòng chờ <b></b> milliseconds.',
            timer: 5500,
            timerProgressBar: true,
            didOpen: () => {
                Swal.showLoading()
                const b = Swal.getHtmlContainer().querySelector('b')
                timerInterval = setInterval(() => {
                    b.textContent = Swal.getTimerLeft()
                }, 100)
            },
            willClose: () => {
                clearInterval(timerInterval)
            }
        });
        $http.get(apiCheckin + $scope.code)
            .then(function(response) {
                // Xử lý phản hồi thành công
                var checkInOutResult = response.data;
                // Thực hiện các hành động phù hợp với kết quả check-in/check-out
                $scope.message("Checkin thành công");
                console.log(checkInOutResult);
            })
            .catch(function(error) {
                // Xử lý lỗi
                $scope.error('Checkin thất bại');
                console.log(error);
            });
    };
    $scope.checkOut = function() {
        // Gửi yêu cầu check-in/check-out đến API
        let timerInterval
        Swal.fire({
            title: 'Đang checkout  vui lòng chờ!',
            html: 'Vui lòng chờ <b></b> milliseconds.',
            timer: 5500,
            timerProgressBar: true,
            didOpen: () => {
                Swal.showLoading()
                const b = Swal.getHtmlContainer().querySelector('b')
                timerInterval = setInterval(() => {
                    b.textContent = Swal.getTimerLeft()
                }, 100)
            },
            willClose: () => {
                clearInterval(timerInterval)
            }
        });
        $http.get(apiCheckOut + $scope.code)
            .then(function(response) {
                // Xử lý phản hồi thành công
                var checkInOutResult = response.data;
                // Thực hiện các hành động phù hợp với kết quả check-in/check-out
                $scope.message("Checkout thành công");
                console.log(checkInOutResult);
            })
            .catch(function(error) {
                // Xử lý lỗi
                $scope.error('Checkout thất bại');
                console.log(error);
            });
    };

});