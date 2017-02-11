<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include  file="header.jsp" %>

<style>
    table, th, td {
        border: 1px solid black;
    }
    tr:first-child{
        font-weight: bold;
        border: 2px solid black;
        background-color: #C6C9C4;
    }

</style>

<br><br><br><br>

<div class="container" style="align: center">
    <div class="row" >
        <div class="col-sm-12">
            <div class="panel panel-success">
                <div class="panel-heading">School of Patriots Header</div>
                <div class="panel-body">
                    <h2>List of Teacher</h2>
                    <table style="width:100%">
                        <tr>
                            <th>Name</th>
                            <th>Father's Name</th>
                            <th>Grand Father</th>
                            <th>Gender</th>
                            <th>Age</th>
                            <th>Date of Birth</th>
                            <th>Address</th>
                            <th>Grade and Section</th>
                            <%--<th>Section</th>--%>
                            <th></th><th></th>
                        </tr>
                        <c:forEach items="${allTeachers}" var="teacher">
                            <tr>
                                <td>${teacher.given_name}</td>
                                <td>${teacher.father_name}</td>
                                <td>${teacher.grand_father_name}</td>
                                <td>${teacher.gender}</td>
                                <td>${teacher.age}</td>
                                <td>${teacher.date_of_birth}</td>
                                <td>${teacher.address}</td>
                                <td>${teacher.grade_level_section_assigned}</td>
                                <%--<td>${teacher.section}</td>--%>

                                <td><a href="<c:url value='/edit-${teacher.teacher_id}-teacher' />">edit</a></td>
                                <td><a href="<c:url value='/delete-${teacher.teacher_id}-teacher' />">delete</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <a href="<c:url value='/addTeacher' />">Add New Teacher</a>
</div>


<%@include  file="footer.jsp" %>