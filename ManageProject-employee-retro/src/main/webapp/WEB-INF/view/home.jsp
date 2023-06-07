
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib uri="jakarta.tags.core" prefix="c" %>--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
          integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />

    <title>Document</title>
    <style>
        .form-ctr {
            margin-top: 2%;
            width: 40%;
        }
        html {
            line-height: 1.15; /* 1 */
            -webkit-text-size-adjust: 100%; /* 2 */
        }
        body {
            margin: 0;
        }
        main {
            display: block;
        }
        h1 {
            font-size: 2em;
            margin: 0.67em 0;
        }
        hr {
            box-sizing: content-box; /* 1 */
            height: 0; /* 1 */
            overflow: visible; /* 2 */
        }
        pre {
            font-family: monospace, monospace; /* 1 */
            font-size: 1em; /* 2 */
        }
        a {
            background-color: transparent;
        }
        abbr[title] {
            border-bottom: none; /* 1 */
            text-decoration: underline; /* 2 */
            text-decoration: underline dotted; /* 2 */
        }
        b,
        strong {
            font-weight: bolder;
        }
        code,
        kbd,
        samp {
            font-family: monospace, monospace; /* 1 */
            font-size: 1em; /* 2 */
        }
        small {
            font-size: 80%;
        }
        sub,
        sup {
            font-size: 75%;
            line-height: 0;
            position: relative;
            vertical-align: baseline;
        }

        sub {
            bottom: -0.25em;
        }

        sup {
            top: -0.5em;
        }
        img {
            border-style: none;
        }
        button,
        input,
        optgroup,
        select,
        textarea {
            font-family: inherit; /* 1 */
            font-size: 100%; /* 1 */
            line-height: 1.15; /* 1 */
            margin: 0; /* 2 */
        }
        button,
        input {
            /* 1 */
            overflow: visible;
        }
        button,
        select {
            /* 1 */
            text-transform: none;
        }
        button,
        [type="button"],
        [type="reset"],
        [type="submit"] {
            -webkit-appearance: button;
        }
        button::-moz-focus-inner,
        [type="button"]::-moz-focus-inner,
        [type="reset"]::-moz-focus-inner,
        [type="submit"]::-moz-focus-inner {
            border-style: none;
            padding: 0;
        }
        button:-moz-focusring,
        [type="button"]:-moz-focusring,
        [type="reset"]:-moz-focusring,
        [type="submit"]:-moz-focusring {
            outline: 1px dotted ButtonText;
        }

        fieldset {
            padding: 0.35em 0.75em 0.625em;
        }

        legend {
            box-sizing: border-box; /* 1 */
            color: inherit; /* 2 */
            display: table; /* 1 */
            max-width: 100%; /* 1 */
            padding: 0; /* 3 */
            white-space: normal; /* 1 */
        }

        textarea {
            overflow: auto;
        }
        [type="checkbox"],
        [type="radio"] {
            box-sizing: border-box; /* 1 */
            padding: 0; /* 2 */
        }

        [type="number"]::-webkit-inner-spin-button,
        [type="number"]::-webkit-outer-spin-button {
            height: auto;
        }

        details {
            display: block;
        }

        summary {
            display: list-item;
        }

        template {
            display: none;
        }

        [hidden] {
            display: none;
        }
        * {
            box-sizing: border-box;
        }
        body {
            margin: 0;
            font-family: "Maven Pro", sans-serif;
        }

        .featured__controls ul li {
            list-style: none;
            font-size: 18px;
            color: #1c1c1c;
            display: inline-block;
            margin-right: 25px;
            position: relative;
            cursor: pointer;
        }

        .section-title h2 {
            color: #1c1c1c;
            font-weight: 700;
            position: relative;
        }

        .featured__item {
            margin-bottom: 50px;
        }

        img {
            vertical-align: middle;
            border-style: none;
        }

        .blog__item__text ul li {
            font-size: 16px;
            color: #b2b2b2;
            list-style: none;
            display: inline-block;
            margin-right: 15px;
        }

        .featured__item__text h6 a {
            color: #252525;
        }

        .featured__item__text h5 {
            color: #252525;
            font-weight: 700;
        }

        ul li a b {
            font-size: 14px;
            color: #252525;
            text-transform: uppercase;
            font-weight: 700;
            letter-spacing: 2px;
            -webkit-transition: all, 0.3s;
            -moz-transition: all, 0.3s;
            -ms-transition: all, 0.3s;
            -o-transition: all, 0.3s;
            transition: all, 0.3s;
            padding: 5px 0;
            display: block;
        }

        ul li {
            list-style: none;
            display: inline-block;
            margin-right: 50px;
            position: relative;
        }
        .footer {
            background: #f3f6fa;
            padding-top: 70px;
            padding-bottom: 0;
        }

        .footer__about {
            margin-bottom: 30px;
        }

        .footer__about ul li {
            font-size: 16px;
            color: #1c1c1c;
            line-height: 36px;
            list-style: none;
        }

        .footer__about__logo {
            margin-bottom: 15px;
        }

        .footer__about__logo a {
            display: inline-block;
        }

        .footer__widget {
            margin-bottom: 30px;
            overflow: hidden;
        }

        .footer__widget h6 {
            color: #1c1c1c;
            font-weight: 700;
            margin-bottom: 10px;
        }

        .footer__widget ul {
            width: 50%;
            float: left;
        }

        .footer__widget ul li {
            list-style: none;
        }

        .footer__widget ul li a {
            color: #1c1c1c;
            font-size: 14px;
            line-height: 32px;
        }

        .footer__widget p {
            font-size: 14px;
            color: #1c1c1c;
            margin-bottom: 30px;
        }

        .footer__widget form {
            position: relative;
            margin-bottom: 30px;
        }

        .footer__widget form input {
            width: 100%;
            font-size: 16px;
            padding-left: 20px;
            color: #1c1c1c;
            height: 46px;
            border: 1px solid #ededed;
        }

        .footer__widget form input::placeholder {
            color: #1c1c1c;
        }

        .footer__widget form button {
            position: absolute;
            right: 0;
            top: 0;
            padding: 0 26px;
            height: 100%;
        }

        .footer__widget .footer__widget__social a {
            display: inline-block;
            height: 41px;
            width: 41px;
            font-size: 16px;
            color: #404040;
            border: 1px solid #ededed;
            border-radius: 50%;
            line-height: 38px;
            text-align: center;
            background: #ffffff;
            -webkit-transition: all, 0.3s;
            -moz-transition: all, 0.3s;
            -ms-transition: all, 0.3s;
            -o-transition: all, 0.3s;
            transition: all, 0.3s;
            margin-right: 10px;
        }

        .footer__widget .footer__widget__social a:last-child {
            margin-right: 0;
        }

        .footer__widget .footer__widget__social a:hover {
            background: #7fad39;
            color: #ffffff;
            border-color: #ffffff;
        }

        .footer__copyright {
            border-top: 1px solid #ebebeb;
            padding: 15px 0;
            overflow: hidden;
            margin-top: 20px;
        }

        .footer__copyright__text {
            font-size: 14px;
            color: #1c1c1c;
            float: left;
            line-height: 25px;
        }

        .footer__copyright__payment {
            float: right;
        }

        a {
            text-decoration: none;
        }
        span {
            color: red;
        }

        header {
            margin-bottom: 2%;
        }

        .header-0 {
            background-color: black;
            color: white;
        }

        .header-1 {
            padding-top: 2%;
            margin-bottom: 1%;
        }

        .header-1-left {
            margin-left: 0;
        }

        .header-1 ul li {
            list-style: none;
            margin-left: 5%;
            display: inline-block;
        }

        .header-1 ul li a {
            text-decoration: none;
            color: white;
        }

        .header-1 ul li a span {
            height: 13px;
            width: 13px;
            background: wheat;
            font-size: 10px;
            color: red;
            line-height: 13px;
            text-align: center;
            font-weight: 700;
            display: inline-block;
            border-radius: 50%;
        }

        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
        }

        .header-3 ul li {
            list-style: none;
            display: inline-block;
            margin-right: 10%;
        }

        .header-3 ul li a {
            text-decoration: none;
            color: black;
        }

        .footer-0 ul li {
            list-style: none;
        }

        .footer-0 {
            width: 100%;
        }

        .footer-0 ul li a {
            text-decoration: none;
            color: black;
        }

        .blog img {
            width: 256px;
            height: 282px;
        }

        .blog a {
            color: black;
            text-decoration: none;
        }

        .blog a:hover {
            color: red;
            text-decoration: none;
        }

        .category ul {
            list-style-type: none;
            display: block;
            width: 100%;
        }

        .category ul li {
            width: 100%;
            border: 1px solid aqua;
            margin-bottom: 3%;
            text-align: center;
            padding: 5px;
        }

        .category ul li a {
            color: black;
            text-decoration: none;
        }

    </style>
</head>



<body >
<header>
    <div class="header-0">
        <div class="container">

            <div class="header-1">
                <div class="row">
                    <div class="col-lg-6 header-1-left">
                        <p class="">WELCOME TO OUR SHOP</p>
                    </div>
                    <div class="col-lg-6 header-1-right text-lg-end">
                        <ul>
                            <li><a href="#fps">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                     fill="currentColor" class="bi bi-person-fill" viewBox="0 0 16 16">
                                    <path
                                            d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"></path>
                                </svg>
                                Account
                            </a></li>
                            <li><a href="/cart">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                     fill="currentColor" class="bi bi-cart4" viewBox="0 0 16 16">
                                    <path
                                            d="M0 2.5A.5.5 0 0 1 .5 2H2a.5.5 0 0 1 .485.379L2.89 4H14.5a.5.5 0 0 1 .485.621l-1.5 6A.5.5 0 0 1 13 11H4a.5.5 0 0 1-.485-.379L1.61 3H.5a.5.5 0 0 1-.5-.5zM3.14 5l.5 2H5V5H3.14zM6 5v2h2V5H6zm3 0v2h2V5H9zm3 0v2h1.36l.5-2H12zm1.11 3H12v2h.61l.5-2zM11 8H9v2h2V8zM8 8H6v2h2V8zM5 8H3.89l.5 2H5V8zm0 5a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0zm9-1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0z"></path>
                                </svg>
                                Cart
                            </a></li>
                            <li><a href="#"></a></li>
                            <li><a href="/logout">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                     fill="currentColor" class="bi bi-box-arrow-in-right" viewBox="0 0 16 16">
                                    <path fill-rule="evenodd"
                                          d="M6 3.5a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-2a.5.5 0 0 0-1 0v2A1.5 1.5 0 0 0 6.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-8A1.5 1.5 0 0 0 5 3.5v2a.5.5 0 0 0 1 0v-2z"></path>
                                    <path fill-rule="evenodd"
                                          d="M11.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H1.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"></path>
                                </svg>
                                Log out
                            </a></li>

                        </ul>

                    </div>
                </div>

            </div>

        </div>
    </div>
    <div class="header-2">
        <div class="text-center">
            <img src="../images/phuler.png" alt="">
        </div>
    </div>
    <hr>

    <div class="header-3">
        <div class="container">
            <div class="row">
                <div class="col-lg-8">
                    <ul>
                        <li><a href="/api/users/listUser">Maneger User</a></li>
                        <li><a href="/api/project/listProject">Maneger Project</a></li>
                        <li><a href="/about">About</a></li>
                        <li><a href="/contact">Contacts</a></li>
                    </ul>
                </div>
                <div class="col-lg-4 text-lg-end">
                    <div class="search-bar">
                        <input type="text" name="" id="" class="btn btn-outline-secondary">
                        <button class="btn btn-outline-primary">Search</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

</header>

<hr>

<hr>
<footer class="footer spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-6 col-sm-6">
                <div class="footer__about">
                    <div class="footer__about__logo">
                        <a href="./index.html"><img src="../images/phuler.png" alt="" /></a>
                    </div>
                    <ul>
                        <li>Address: 60-49 Road 11378 New York</li>
                        <li>Phone: +65 11.188.888</li>
                        <li>Email: hello@colorlib.com</li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 col-sm-6 offset-lg-1">
                <div class="footer__widget">
                    <h6>Useful Links</h6>
                    <ul>
                        <li><a href="#">About Us</a></li>
                        <li><a href="#">About Our Shop</a></li>
                        <li><a href="#">Secure Shopping</a></li>
                        <li><a href="#">Delivery infomation</a></li>
                        <li><a href="#">Privacy Policy</a></li>
                        <li><a href="#">Our Sitemap</a></li>
                    </ul>
                    <ul>
                        <li><a href="#">Who We Are</a></li>
                        <li><a href="#">Our Services</a></li>
                        <li><a href="#">Projects</a></li>
                        <li><a href="#">Contact</a></li>
                        <li><a href="#">Innovation</a></li>
                        <li><a href="#">Testimonials</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-4 col-md-12">
                <div class="footer__widget">
                    <h6>Join Our Newsletter Now</h6>
                    <p>
                        Get E-mail updates about our latest shop and special offers.
                    </p>
                    <form action="#">
                        <input type="text" placeholder="Enter your mail" />
                        <button type="submit" class="site-btn">Subscribe</button>
                    </form>
                    <div class="footer__widget__social">
                        <a href="#"><i class="fab fa-facebook-square"></i></a>
                        <a href="#"><i class="fab fa-instagram-square"></i></a>
                        <a href="#"><i class="fab fa-twitter-square"></i></a>
                        <a href="#"><i class="fab fa-pinterest-square"></i></a>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="footer__copyright">
                    <div class="footer__copyright__text">
                        <p>
                            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                            Copyright &copy;
                            <script>
                                document.write(new Date().getFullYear());
                            </script>
                            All rights reserved | This template is made with
                            <i class="fa fa-heart" aria-hidden="true"></i> by
                            <a href="https://colorlib.com" target="_blank">Colorlib</a>
                            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        </p>
                    </div>
                    <div class="footer__copyright__payment">
                        <img src="../images/payment-item.png" alt="" />
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>



<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>
