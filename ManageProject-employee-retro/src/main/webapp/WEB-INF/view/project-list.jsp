<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="../../../resources/static/css/list.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />


    <style>

        @import url(https://fonts.googleapis.com/css?family=Open+Sans:400italic,400,300,600);

        * {
            margin:0;
            padding:0;
            box-sizing:border-box;
            -webkit-box-sizing:border-box;
            -moz-box-sizing:border-box;
            -webkit-font-smoothing:antialiased;
            -moz-font-smoothing:antialiased;
            -o-font-smoothing:antialiased;
            font-smoothing:antialiased;
            text-rendering:optimizeLegibility;
        }
        body {
            background: #fafafa url(https://jackrugile.com/images/misc/noise-diagonal.png);
            color: #444;
            font: 100%/30px 'Helvetica Neue', helvetica, arial, sans-serif;
            text-shadow: 0 1px 0 #fff;
        }

        .container {
            max-width:400px;
            width:100%;
            margin:0 auto;
            position:relative;
        }

        #contact input[type="text"], #contact input[type="email"], #contact input[type="tel"], #contact input[type="url"], #contact textarea, #contact button[type="submit"] { font:400 12px/16px "Open Sans", Helvetica, Arial, sans-serif; }

        #contact {
            background:#F9F9F9;
            padding:25px;
            margin:50px 0;
        }

        #contact h3 {
            color: #F96;
            display: block;
            font-size: 30px;
            font-weight: 400;
        }

        #contact h4 {
            margin:5px 0 15px;
            display:block;
            font-size:13px;
        }

        fieldset {
            border: medium none !important;
            margin: 0 0 10px;
            min-width: 100%;
            padding: 0;
            width: 100%;
        }

        #contact input[type="text"], #contact input[type="email"], #contact input[type="tel"], #contact input[type="url"], #contact textarea {
            width:100%;
            border:1px solid #CCC;
            background:#FFF;
            margin:0 0 5px;
            padding:10px;
        }

        #contact input[type="text"]:hover, #contact input[type="email"]:hover, #contact input[type="tel"]:hover, #contact input[type="url"]:hover, #contact textarea:hover {
            -webkit-transition:border-color 0.3s ease-in-out;
            -moz-transition:border-color 0.3s ease-in-out;
            transition:border-color 0.3s ease-in-out;
            border:1px solid #AAA;
        }

        #contact textarea {
            height:100px;
            max-width:100%;
            resize:none;
        }

        #contact button[type="submit"] {
            cursor:pointer;
            width:100%;
            border:none;
            background:#0CF;
            color:#FFF;
            margin:0 0 5px;
            padding:10px;
            font-size:15px;
        }

        #contact button[type="submit"]:hover {
            background:#09C;
            -webkit-transition:background 0.3s ease-in-out;
            -moz-transition:background 0.3s ease-in-out;
            transition:background-color 0.3s ease-in-out;
        }

        .pagination {
            list-style: none;
            display: flex;
            justify-content: center;
            align-items: center;
            margin-top: 20px;
        }

        .pagination li {
            margin: 0 5px;
        }

        .pagination li a {
            text-decoration: none;
            padding: 5px 10px;
            border: 1px solid #ccc;
        }

        .pagination li.active a {
            background-color: #ccc;
            color: #fff;
        }
        #contact button[type="submit"]:active { box-shadow:inset 0 1px 3px rgba(0, 0, 0, 0.5); }

        #contact input:focus, #contact textarea:focus {
            outline:0;
            border:1px solid #999;
        }
        ::-webkit-input-placeholder {
            color:#888;
        }
        :-moz-placeholder {
            color:#888;
        }
        ::-moz-placeholder {
            color:#888;
        }
        :-ms-input-placeholder {
            color:#888;
        }
        strong {
            font-weight: bold;
        }

        em {
            font-style: italic;
        }

        table {
            background: #f5f5f5;
            border-collapse: separate;
            box-shadow: inset 0 1px 0 #fff;
            font-size: 12px;
            line-height: 24px;
            margin: 30px auto;
            text-align: left;
            width: 800px;
        }

        th {
            background: url(https://jackrugile.com/images/misc/noise-diagonal.png), linear-gradient(#777, #444);
            border-left: 1px solid #555;
            border-right: 1px solid #777;
            border-top: 1px solid #555;
            border-bottom: 1px solid #333;
            box-shadow: inset 0 1px 0 #999;
            color: #fff;
            font-weight: bold;
            padding: 10px 15px;
            position: relative;
            text-shadow: 0 1px 0 #000;
        }

        th:after {
            background: linear-gradient(rgba(255, 255, 255, 0), rgba(255, 255, 255, .08));
            content: '';
            display: block;
            height: 25%;
            left: 0;
            margin: 1px 0 0 0;
            position: absolute;
            top: 25%;
            width: 100%;
        }

        th:first-child {
            border-left: 1px solid #777;
            box-shadow: inset 1px 1px 0 #999;
        }

        th:last-child {
            box-shadow: inset -1px 1px 0 #999;
        }

        td {
            border-right: 1px solid #fff;
            border-left: 1px solid #e8e8e8;
            border-top: 1px solid #fff;
            border-bottom: 1px solid #e8e8e8;
            padding: 10px 15px;
            position: relative;
            transition: all 300ms;
        }

        td:first-child {
            box-shadow: inset 1px 0 0 #fff;
        }

        td:last-child {
            border-right: 1px solid #e8e8e8;
            box-shadow: inset -1px 0 0 #fff;
        }

        tr {
            background: url(https://jackrugile.com/images/misc/noise-diagonal.png);
        }

        tr:nth-child(odd) td {
            background: #f1f1f1 url(https://jackrugile.com/images/misc/noise-diagonal.png);
        }

        tr:last-of-type td {
            box-shadow: inset 0 -1px 0 #fff;
        }

        tr:last-of-type td:first-child {
            box-shadow: inset 1px -1px 0 #fff;
        }

        tr:last-of-type td:last-child {
            box-shadow: inset -1px -1px 0 #fff;
        }

        tbody:hover td {
            color: transparent;
            text-shadow: 0 0 3px #aaa;
        }

        tbody:hover tr:hover td {
            color: #444;
            text-shadow: 0 1px 0 #fff;
        }
        #description {
            width: 200%;
        }
    </style>
</head>
<body>
<div class="container">
    <form id="contact"  method="post" action="/api/project/createProject">
        <h1>Create Project</h1>
        <fieldset>
            <input placeholder="Name Project" type="text" tabindex="1" id="name"  name="name value="${project.} required autofocus>
        </fieldset>
        <fieldset>
            <input placeholder="Description" type="text" id="description" name="description" tabindex="5" required>
        </fieldset>
        <fieldset>
            <label>Start time</label>
            <input placeholder="Start time" type="date" tabindex="5" name="startDate" id="startDate" required>
        </fieldset>
        <fieldset>
            <label>End time</label>
            <input placeholder="End time" type="date" tabindex="5" name="endDate" id="endDate" required>
        </fieldset>
        <fieldset>
            <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">Submit</button>
        </fieldset>
    </form>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Name Project</th>
            <th>Description</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th scope="row">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${projectPage.content}" var="project">
            <tr>
                <td><strong>${project.id}</strong></td>
                <td><strong>${project.name}</strong></td>
                <td>${project.description}</td>
                <td>${project.startDate}</td>
                <td>${project.endDate}</td>

                <td>
                    <a href="/api/project/delete/${project.id}" class="btn btn-danger">Delete</a>
                    <a href="/api/project/update/${project.id}" class="btn btn-info">Update</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="pagination">
        <c:choose>
            <c:when test="${projectPage.totalPages <= 5}">
                <c:forEach var="i" begin="0" end="${projectPage.totalPages - 1}">
                    <li class="${i == currentPage ? 'active' : ''}"><a href="/api/project/listProject?page=${i}">${i}</a></li>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <c:choose>
                    <c:when test="${currentPage < 3}">
                        <c:forEach var="i" begin="0" end="4">
                            <li class="${i == currentPage ? 'active' : ''}"><a href="/api/project/listProject?page=${i}">${i}</a></li>
                        </c:forEach>
                    </c:when>
                    <c:when test="${currentPage >= 3 && currentPage <= projectPage.totalPages - 3}">
                        <c:forEach var="i" begin="${currentPage - 2}" end="${currentPage + 2}">
                            <li class="${i == currentPage ? 'active' : ''}"><a href="/api/project/listProjectpage=${i}">${i}</a></li>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <c:forEach var="i" begin="${projectPage.totalPages - 4}" end="${projectPage.totalPages - 1}">
                            <li class="${i == currentPage ? 'active' : ''}"><a href="/api/project/listProject?page=${i}">${i}</a></li>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </c:otherwise>
        </c:choose>
    </div>
</div>
</body>
</html>
