<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">


<%@include  file="header.jsp" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<br><br><br><br>

<title>Search</title>

<div class="container" style="align: center">
    <div class="row" >
        <div class="col-sm-12">
            <div class="panel panel-success">
                <div class="panel-heading">Add Student</div>
                <div class="panel-body">

                    <h1>Search for Student or Teacher</h1>

                    <form action="search" method="post">
                        Enter Student Id Number: <input type="text" id="txt" name="student_id_number">
                        <input type="reset"/>
                        <input type="submit" value="Search" />
                    </form>
                    <br>
                    You entered: ${inputSearch}
                    <br><br>
                    Found Result: <br><br>
                    <c:forEach items="${searchResult}" var="foundStudents">
                    <p>Found Student: ${foundStudents.student_id_number} &nbsp ${foundStudents.given_name} &nbsp ${foundStudents.father_name}
                        &nbsp ${foundStudents.grade_level}${foundStudents.section}</p>
                    </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>