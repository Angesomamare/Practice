<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include  file="header.jsp" %>

<style>
    th, td {
        border: 1.5px solid black;
        background-color: #C6C9C4;
    }
    tr {
        font-weight: bold;
        border: 1.5px solid black;
        background-color: #C6C9C4;
    }

    table {
        font-weight: bold;
        border: 2.5px solid black;
    }

</style>

<br><br><br><br>

<div class="container" style="align: center">
    <div class="row" >
        <div class="col-sm-12">
            <div class="generic-container">
                <%--<%@include file="authheader.jsp" %>--%>
                <div class="panel panel-success">
                    <!-- Default panel contents -->
                    <div class="panel-heading"><span class="lead"><strong>List of Students </strong> </span></div>
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>Student ID</th>
                            <th>Given Name</th>
                            <th>Father's Name</th>
                            <th>Grand Father's Name</th>
                            <th>Gender</th>
                            <th>Age</th>
                            <th>Date of Birth</th>
                            <th>Address</th>
                            <th>Grade</th>
                            <th>Section</th>

                            <th></th>
                            <th></th>

                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${allStudents}" var="student">
                            <tr>
                                <td>${student.student_id_number}</td>
                                <td>${student.given_name}</td>
                                <td>${student.father_name}</td>
                                <td>${student.grand_father_name}</td>
                                <td>${student.gender}</td>
                                <td>${student.age}</td>
                                <td>${student.date_of_birth}</td>
                                <td>${student.address}</td>
                                <td>${student.grade_level}</td>
                                <td>${student.section}</td>


                                    <td><a href="<c:url value='/edit-student-${student.student_id_number}' />"
                                           class="btn btn-success custom-width">Edit</a></td>

                                    <td><a href="<c:url value='/delete-student-${student.student_id_number}' />"
                                           class="btn btn-danger custom-width">Delete</a></td>

                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>

                    <div class="well">
                        <a href="<c:url value='/addStudent' />" class="btn btn-success custom-width">
                            <strong> Add New Student </strong> </a>
                    </div>
            </div>
        </div>
     </div>
 </div>

<%@include  file="footer.jsp" %>