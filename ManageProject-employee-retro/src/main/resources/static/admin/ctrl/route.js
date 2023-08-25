var app = angular.module("Myapp",["ngRoute"]);
app.config(function($routeProvider){
    $routeProvider
        .when("/checkin", {
            templateUrl: "/admin/adminUser/checkIn.html",
            controller: "checkinandcheckout"
        })
        .when("/checkout", {
            templateUrl: "/admin/adminUser/Checkout.html",
            controller: "checkinandcheckout"
        })
        .when("/QLduan", {
            templateUrl: "/admin/adminUser/projet-list.html",
            controller: "duan-ctrl"
        })
        .when("/Qlnhanvien", {
            templateUrl: "/admin/adminUser/user-list.html",
            controller: "nhanvien-ctrl"
        })
})