<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@include  file="header.jsp" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Grade and Section</title>


<div class="container" style="align: center">
    <div class="row" >
        <div class="col-sm-12">
            <div class="panel panel-success">
                <div class="panel-heading">School of Patriots Header</div>
                <div class="panel-body">


                    <h1>Add Grade</h1>

                    <form:form action="addGrade" method="post" modelAttribute="gradeSection">
                        <div class="row">
                            <div class="col-sm-3">
                                <div class="form" >

                                    <label for="grade">Grade Level:</label>
                                    <form:input type="text" class="form-control" id="grade" path="grade" placeholder="Grade Level" cssStyle="width: auto"/>
                                </div><br>
                            </div>
                            <div class="col-sm-3">
                                <div class="form">
                                    <label for="section">Section:</label>
                                    <form:input type="text" class="form-control" id="section" path="section" placeholder="Section" cssStyle="width: auto"/>
                                                </div><br>
                                            </div>

                                            <div class="col-sm-6"></div>

                                        </div>


                                        <br>

                                        <div class="form" >
                                            <button type="submit" class="btn btn-primary">Add </button>
                                        </div>
                                    </form:form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


<%@include  file="footer.jsp" %>