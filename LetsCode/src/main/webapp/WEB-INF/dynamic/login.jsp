
<%@include  file="header.jsp" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<title>Login</title>
<br><br><br><br>
<div class="container" style="align: center">
    <div class="row" >
        <div class="col-sm-12">
            <div class="panel panel-success">
                <div class="panel-heading">Login to your account</div>
                <div class="panel-body">

                    <form action="authorizeLogin" method="post">
                            <label for="userName">User Name:</label>
                            <input type="text" class="form-control" id="userName" name="user_name" placeholder="Type your user name" cssStyle="width: auto"/>
                        <br>
                            <label for="password">Password: </label>
                            <input type="password" class="form-control" id="password" name="password" placeholder="Type your password" cssStyle="width: auto"/>
                                ${success}
                        <br>
                            <button type="submit" class="btn btn-primary">Login</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include  file="footer.jsp" %>