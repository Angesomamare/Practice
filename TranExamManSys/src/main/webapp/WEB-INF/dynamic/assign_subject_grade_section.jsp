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
                <div class="panel-body">

                    <form:form action="gradesubject" method="post" modelAttribute="gradeSectionSubjectRelation">
                        <div class="form">
                            <label for="gradeSection">Select Grade & Section to assign to:</label>
                            <form:select class="form-control" id="gradeSection" path="grade_section_id" cssStyle="width: auto">
                                <c:forEach var="gradeSection" items="${sectionGradeList}" varStatus="status">
                                    <option value = "${gradeSection.grade_section_id}"> ${gradeSection.grade}${gradeSection.section}</option>
                                </c:forEach>
                            </form:select>
                            <br>

                            <label for="subject">Select Subject:</label>
                            <form:select class="form-control" id="subject" path="subject_id" cssStyle="width: auto">
                                <c:forEach var="subject" items="${subjectlist}" varStatus="status">
                                    <option value = "${subject.subject_id}"> ${subject.subject_name}</option>
                                </c:forEach>
                            </form:select> <br>
                        <button type="submit" class="btn btn-primary">Assign</button>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>


<%@include  file="footer.jsp" %>