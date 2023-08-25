app.controller('nhanvien-ctrl', function ($rootScope,$scope, $http) {

    const apiUser = "http://localhost:7777/apiUser/users/listUser";
    const apiUserSignUp = "http://localhost:7777/api/auth/signup";
    const apiRole = "http://localhost:7777/apiUser/getallRole";
    const apiproject = "http://localhost:7777/apiUser/getallproject";
    $scope.currentPage = 0; // Trang hiện tại
    $scope.pageSize = 10; // Số mục trên mỗi trang
    $scope.totalPages = 0; // Tổng số trang
    $scope.currentPageUsers = [];

    $scope.users = []; // Danh sách người dùng
    $scope.formUser = {};
    $scope.roles = [];
    $scope.projects = [];


    // Lấy danh sách người dùng
    $scope.getUsers = function () {
        $http.get(apiUser)
            .then(function (response) {
                $scope.users = response.data.content;
                console.log(response)
                $scope.totalPages = Math.ceil($scope.users.length / $scope.pageSize);
                $scope.setCurrentPage(0);
                console.log(response);
            })
            .catch(function (error) {
                console.log(error);
            });
    };

    $scope.onSave = function () {
        var formData = new FormData();
        formData.append('firstName', $scope.formUser.firstName);
        formData.append('lastName', $scope.formUser.lastName);
        formData.append('userName', $scope.formUser.userName);
        formData.append('password', $scope.formUser.password);
        formData.append('email', $scope.formUser.email);
        let req = {
            method: 'POST',
            url: apiUserSignUp,
            headers: {
                'Content-Type': undefined,
                // or  'Content-Type':'application/json'
            },
            data: formData
        }
        let timerInterval
        Swal.fire({
            title: 'Đang đăng kí  mới vui lòng chờ!',
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
        $http(req).then(response => {
            console.log("ddd " + response);
            $scope.message("đăng kí phẩm thành công");
        }).catch(error => {
            $scope.error('đăng kí thất bại');
        });
    };
    // Chuyển đến trang đầu tiên
    $scope.setCurrentPage = function(page) {
        $scope.currentPage = page;
        $scope.currentPageUsers = $scope.users.slice(page * $scope.pageSize, (page + 1) * $scope.pageSize);
    };

// Chuyển đến trang đầu tiên
    $scope.firstPage = function() {
        $scope.setCurrentPage(0);
    };

// Chuyển đến trang trước đó
    $scope.previousPage = function() {
        if ($scope.currentPage > 0) {
            $scope.setCurrentPage($scope.currentPage - 1);
        }
    };

// Chuyển đến trang tiếp theo
    $scope.nextPage = function() {
        if ($scope.currentPage < $scope.totalPages - 1) {
            $scope.setCurrentPage($scope.currentPage + 1);
        }
    };

// Chuyển đến trang cuối cùng
    $scope.lastPage = function() {
        $scope.setCurrentPage($scope.totalPages - 1);
    };

    $scope.getRole = function () {
        $http.get(apiRole)
            .then(function (response) {
                $scope.roles = response.data;
                console.log(response);
            })
            .catch(function (error) {
                console.log(error);
            });
    };

    $scope.getProject = function () {
        $http.get(apiproject)
            .then(function (response) {
                $scope.projects = response.data;
                console.log(response);
            })
            .catch(function (error) {
                console.log(error);
            });
    };

    $scope.getRole();
    $scope.getProject();
    $scope.getUsers();


});