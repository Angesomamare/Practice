<%@include file = "header.jsp"%>

<title>About Us</title>
<center><h3>About US</h3></center>
<style>
    p{
        text-indent: 100px;
    }
</style>


<%--<p><em>${about_us}</em></p>--%>

<div class="container" style="align: center">
    <div class="row" >
        <div class="col-sm-12">
            <div class="panel panel-success">
                <div class="panel-heading">School of Patriots Header</div>
                <div class="panel-body">

                    ${about_us}
                    <br><br>
                    ${com}
                    <br><br>
                    ${size}
                </div>




<%@include file="footer.jsp"%>