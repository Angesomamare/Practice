
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">



<%@include  file="header.jsp" %>


<%--<%@include  file="home.jsp" %>--%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%--<br><br><br><br>--%>
<br></<br>
<%--<img src="/images/gradle_logo.png" align="right" width="1400" height="200" />--%>
<%--<img src="/images/book.jpg"/>--%>

<title>Add Student</title>

        <div class="container" style="align: center">
            <div class="row" >
                <div class="col-sm-12">
                    <div class="panel panel-success">
                        <div class="panel-heading">Add Student</div>
                        <div class="panel-body">

                            <h1>Add Student</h1>

                            <form:form action="addStudent" method="post" modelAttribute="student">
                                <div class="row">
                                    <div class="col-sm-3">
                                        <div class="form" >
                                            <label for="given_name">Given Name:</label>
                                            <form:input type="text" class="form-control" id="given_name" path="given_name" placeholder="Given name" cssStyle="width: auto"/>
                                        </div><br>
                                    </div>
                                    <div class="col-sm-3">
                                        <div class="form">
                                            <label for="father_name">Father Name:</label>
                                            <form:input type="text" class="form-control" id="father_name" path="father_name" placeholder="Father's name" cssStyle="width: auto"/>
                                        </div><br>
                                    </div>
                                    <div class="col-sm-3">
                                        <div class="form">
                                            <label for="grand_father_name">Grand Father Name:</label>
                                            <form:input type="text" class="form-control" id="grand_father_name" path="grand_father_name" placeholder="Grand Father's name" cssStyle="width: auto"/>
                                        </div><br>
                                    </div>
                                    <div class="col-sm-3"></div>

                                </div>


                                <div class="row">
                                    <div class="col-sm-3">
                                        <div class="form" >
                                            <label for="age">Age:</label>
                                            <form:input type="text" class="form-control" id="age" path="age" placeholder="Age" cssStyle="width: auto"/>
                                        </div><br>
                                    </div>
                                    <div class="col-sm-3">

                                        <div class="form" >
                                            <label for="date_of_birth">DOB:</label>
                                            <form:input type="date" class="form-control" id="date_of_birth" path="date_of_birth" cssStyle="width: auto"/>
                                        </div><br>
                                    </div>
                                    <div class="col-sm-3">

                                        <div class="form">
                                            <label for="address">Address:</label>
                                            <form:input type="text" class="form-control" id="address" path="address" placeholder="Address" cssStyle="width: auto"/>
                                        </div><br>
                                    </div>

                                    <div class="col-sm-3">
                                        <div class="form" >
                                            <label for="grade_level">Grade:</label>
                                            <form:input type="text" class="form-control" id="grade_level" path="grade_level" placeholder="Grade Level" cssStyle="width: auto"/>
                                        </div><br>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <div class="form" >
                                            <label for="section">Section :</label>
                                            <form:input type="text" class="form-control" id="section" path="section" placeholder="Section" cssStyle="width: auto"/>
                                        </div><br>
                                    </div>
                                    <div class="col-sm-3">
                                        <div class="form" >

                                            <label for="student_id_number">Student Identification Number :</label>
                                            <c:choose>
                                                <c:when test="${edit}">
                                                    <form:input type="text" path="student_id_number" id="student_id_number"  class="form-control input-sm" disabled="false"/>
                                                </c:when>
                                                <c:otherwise>
                                                    <form:input type="text" path="student_id_number" id="student_id_number" class="form-control input-sm" placeholder="Student Identification Number" />
                                                    <div class="has-error">
                                                        <form:errors path="student_id_number" class="help-inline"/>
                                                    </div>
                                                </c:otherwise>
                                            </c:choose>

                                            <%----%>
                                            <%--<label for="student_id_number">Student Identification Number :</label>--%>
                                            <%--<form:input type="text" class="form-control" id="student_id_number" path="student_id_number" placeholder="Student Identification Number" cssStyle="width: auto"/>--%>
                                        </div><br>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="form" >
                                            <label class="radio inline control-label" for="gender">Gender: </label>

                                            <style>
                                                input[type="radio"]{
                                                    margin: 0 10px 0 10px;
                                                }
                                            </style>

                                            <label class="radio-inline"><form:radiobutton id="gender" path="gender"  value="M"/> Male</label>
                                            <label class="radio-inline"><form:radiobutton id="gender" path="gender"  value="F"/> Female</label>
                                        </div>
                                    </div>
                                </div>

                                <br>

                                <div class="form" >

                                    <c:choose>
                                        <c:when test="${edit}">
                                            <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/allStudents' />">Cancel</a>
                                        </c:when>
                                        <c:otherwise>
                                            <input type="submit" value="Add Student" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/allStudents' />">Cancel</a>
                                        </c:otherwise>
                                    </c:choose>

                                    <%--<button type="submit" class="btn btn-primary">Add Student</button>--%>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
<%--<img src="<c:url value="/imgages/gradle_logo.png"/>"/>--%>
<%--<img src="${pageContext.request.contextPath}Images/imgages/gradle_logo.png"/>--%>



<%--&lt;%&ndash;<img src="<c:url value="Image/resources/img/gradle_logo.png"/>"/>&ndash;%&gt;--%>
<%--<img src="${pageContext.request.contextPath}/img/gradle_logo.png"/>--%>

<%@include  file="footer.jsp" %>