<%@include  file="header.jsp" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add phone number</title>

<br><br><br><br>
<div class="container" style="align: center">
    <div class="row" >
        <div class="col-sm-12">
            <div class="panel panel-success">
                <div class="panel-heading">School of Patriots Header</div>
                <div class="panel-body">

                    <h1>Add Phone</h1>
                    <form:form action="addPhone" method="post" modelAttribute="phonemodel">
                        <div class="form">
                            <label for="phone">Phone number:</label>
                            <form:input type="text" class="form-control" id="phone" path="phone" placeholder=" your Phone Number" cssStyle="width: auto"/>
                        </div><br>

                        <button type="submit" class="btn btn-primary">Add</button>
                    </form:form>
                </div>

<%@include  file="footer.jsp" %>