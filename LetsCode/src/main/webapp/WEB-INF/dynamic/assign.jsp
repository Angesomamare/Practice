

<%@include  file="header.jsp" %>

<br><br><br><br>

<div class="container" style="align: center">
    <div class="row" >
        <div class="col-sm-12">
            <div class="panel panel-success">
                <div class="panel-heading">School of Patriots Header</div>
                <div class="panel-body">

                    <form:form action="assignStudentOrTeacher" method="post" modelAttribute="studentGradeSectionRelation">

                        <div class="form">
                            <label for="studentOrTeacherId">Enter Id:</label>
                            <form:input type="text" class="form-control" id="studentOrTeacherId" path="student_id_number" placeholder="Id" cssStyle="width: auto"/>
                        </div>
                    <br>
                        <div class="form">
                            <label for="gradeSection">Select Grade & Section to assign to:</label>

                            <form:select class="form-control" id="gradeSection" path="grade_section_id" cssStyle="width: auto">
                                <c:forEach var="gradeSection" items="${sectionGradeList}" varStatus="status">
                                    <option value = "${gradeSection.grade_section_id}"> ${gradeSection.grade}${gradeSection.section}</option>
                                </c:forEach>
                            </form:select>
                            <br>


                        <br>
                            <button type="submit" class="btn btn-primary">Assign</button>

                        </div>
                    </form:form>

<%@include  file="footer.jsp" %>
