<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@include  file="header.jsp" %>

<br><br><br><br>

<div class="container" style="align: center">
    <div class="row" >
        <div class="col-sm-12">
            <div class="panel panel-success">
                <div class="panel-heading">School of Patriots Header</div>
                <h2>Assign Teacher:</h2>
                <div class="panel-body">

                    <form:form action="assignTeacher" method="post" modelAttribute="teacherGradeSectionSubjectRelation">
                    <%--<form action="assignTeacher" method="post">--%>
                        <div class="form">
                            <label for="teacher">Select Teacher to assign</label>

                            <form:select class="form-control" id="teacher" path="teacher_id" cssStyle="width: auto">
                                <option value = None> Select---Teacher</option>
                                <c:forEach var="teacher" items="${teachersList}" varStatus="status">
                                    <option value = "${teacher.teacher_id}"> ${teacher.given_name}</option>
                                </c:forEach>
                            </form:select>
                            <br>

                            <label for="gradeSection">Select Grade & Section to assign to:</label>
                            <form:select class="form-control" id="gradeSection" path="grade_section_id" cssStyle="width: auto">
                                <option value = None> Select---Section</option>
                                <c:forEach var="gradeSection" items="${gradeSectionList}" varStatus="status">
                                    <option value = "${gradeSection.grade_section_id}"> ${gradeSection.grade}${gradeSection.section}</option>
                                </c:forEach>
                            </form:select>
                            <br>

                            <label for="subject">Select Subject:</label>
                            <form:select class="form-control" id="subject" path="subject_id" cssStyle="width: auto">
                                <option value = None> Select---Subject</option>
                                <c:forEach var="subject" items="${subjectsList}" varStatus="status">
                                    <option value = "${subject.subject_id}"> ${subject.subject_name}</option>
                                </c:forEach>
                            </form:select>

                        </div>
                        <button type="submit" class="btn btn-primary">Assign</button>
                    <%--</form>--%>
                    </form:form>



<%@include  file="footer.jsp" %>