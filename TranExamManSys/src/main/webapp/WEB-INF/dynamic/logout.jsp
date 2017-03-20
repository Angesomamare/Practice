
<%@include  file="header.jsp" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Logout</title>
<br><br><br><br>
<div class="container" style="align: center">
    <div class="row" >
        <div class="col-sm-12">
            <div class="panel panel-success">
                <div class="panel-heading">Logout from your account</div>
                <div class="panel-body">

                    <form action="logout" method="post">
                        <br>
                        <button type="submit" class="btn btn-primary">Logout</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include  file="footer.jsp" %>