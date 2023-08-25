app.controller('duan-ctrl', function ($rootScope,$scope, $http) {

    const apiProject= "http://localhost:7777/apiProject/projects";

    $scope.currentPage = 0; // Trang hiện tại
    $scope.pageSize = 10; // Số mục trên mỗi trang
    $scope.totalPages = 0; // Tổng số trang
    $scope.currentPageProjects = [];

    $scope.projects = []; // Danh sách người dùng

    $scope.getProjects = function () {
        $http.get(apiProject)
            .then(function (response) {
                $scope.projects = response.data.content;
                console.log(response)
                $scope.totalPages = Math.ceil($scope.projects.length / $scope.pageSize);
                $scope.setCurrentPage(0);
            })
            .catch(function (error) {
                console.log(error);
            });
    };
    // Chuyển đến trang đầu tiên
    $scope.setCurrentPage = function(page) {
        $scope.currentPage = page;
        $scope.currentPageProjects = $scope.projects.slice(page * $scope.pageSize, (page + 1) * $scope.pageSize);
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
    $scope.getProjects();

});