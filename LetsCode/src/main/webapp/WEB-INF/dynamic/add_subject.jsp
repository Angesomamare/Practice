
<%@include  file="header.jsp" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Subject</title>

<br><br><br><br>
<div class="container" style="align: center">
    <div class="row" >
        <div class="col-sm-12">
            <div class="panel panel-success">
                <div class="panel-heading">School of Patriots Header</div>
                <div class="panel-body">

                    <h1>Add Subject</h1>
                    <form:form action="addSubject" method="post" modelAttribute="subject">
                        <div class="form">
                            <label for="subject_name">Subject Name:</label>
                            <form:input type="text" class="form-control" id="subject_name" path="subject_name" placeholder="Subject name" cssStyle="width: auto"/>
                        </div><br>

                        <button type="submit" class="btn btn-primary">Add</button>
                    </form:form>
                </div>

<%@include  file="footer.jsp" %>