<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<style>
    h3 {
        display: inline-block;
        padding: 10px;
        background: #BEFF33;
        border-top-left-radius: 10px;
        border-top-right-radius: 10px;}






</style>
<%@include file="main.css"%>
<%--<%@include  file="header.jsp" %>--%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%--<div class="container">--%>
    <%--<br>--%>
    <%--<div id="myCarousel" class="carousel slide" data-ride="carousel">--%>
        <%--<!-- Indicators -->--%>
        <%--<ol class="carousel-indicators">--%>
            <%--<li data-target="#myCarousel" data-slide-to="0" class="active"></li>--%>
            <%--<li data-target="#myCarousel" data-slide-to="1"></li>--%>
            <%--<li data-target="#myCarousel" data-slide-to="2"></li>--%>
            <%--<li data-target="#myCarousel" data-slide-to="3"></li>--%>
            <%--&lt;%&ndash;<li data-target="#myCarousel" data-slide-to="4"></li>&ndash;%&gt;--%>
        <%--</ol>--%>

        <%--<!-- Wrapper for slides -->--%>
        <%--<div class="carousel-inner" role="listbox">--%>
            <%--<div class="item active">--%>
                <%--<img src="/images/number.jpg" data-color="tomato" alt="First Image" height="100"/>--%>
                <%--<div class="carousel-caption">--%>
                    <%--<h3>First Image</h3>--%>
                <%--</div>--%>
            <%--</div>--%>

            <%--<div class="item">--%>
                <%--<img src="/images/book.jpg" data-color="lightgreen" alt="Second Image" height="30"/>--%>
                <%--<div class="carousel-caption">--%>
                    <%--<h3>Second Image</h3>--%>
                <%--</div>--%>
            <%--</div>--%>

            <%--<div class="item">--%>
                <%--&lt;%&ndash;<img src="/images/gradle_logo.png" alt = "Yellow" width="500" height="10" />&ndash;%&gt;--%>
                <%--<img src="/images/images.png" data-color="violet" alt="Third Image" width="1100" height="100"/>--%>
                    <%--<div class="carousel-caption">--%>
                        <%--<h3>Third Image</h3>--%>
                    <%--</div>--%>
            <%--</div>--%>

            <%--<div class="item">--%>
                <%--<img src="/images/tech.jpg" data-color="firebrick" alt="Fourth Image" width="1100" />--%>
                <%--<div class="carousel-caption">--%>
                    <%--<h3>Fourth Image</h3>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>

        <%--<!-- Left and right controls -->--%>
        <%--<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">--%>
            <%--<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>--%>
            <%--<span class="sr-only">Previous</span>--%>
        <%--</a>--%>
        <%--<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">--%>
            <%--<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>--%>
            <%--<span class="sr-only">Next</span>--%>
        <%--</a>--%>
    <%--</div>--%>
<%--</div>--%>
<div id="carousel-example" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
        <li data-target="#carousel-example" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example" data-slide-to="1"></li>
        <li data-target="#carousel-example" data-slide-to="2"></li>
        <li data-target="#carousel-example" data-slide-to="3"></li>
    </ol>

    <div class="carousel-inner">
        <div class="item active">
            <a href="#"><img src="/images/book.jpg"/></a>
            <div class="carousel-caption">
                <h3>First Image</h3>
                <p>My School</p>
            </div>
        </div>
        <div class="item">
            <a href="#"><img src="/images/heading.jpg" width="1350"/></a>
            <div class="carousel-caption">
                <h3>Second Image</h3>
                <p>My School</p>
            </div>
        </div>
        <div class="item">
            <a href="#"><img src="/images/number.jpg"/></a>
            <div class="carousel-caption">
                <h3>Third Image</h3>
                <p>My School</p>
            </div>
        </div>
        <div class="item">
            <a href="#"><img src="/images/images.png" width="1400"/></a>
            <div class="carousel-caption">
                <h3>Fourth Image</h3>
                <p>My School</p>
            </div>
        </div>
    </div>

    <a class="left carousel-control" href="#carousel-example" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left"></span>
    </a>
    <a class="right carousel-control" href="#carousel-example" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right"></span>
    </a>
</div>
<%@include  file="footer.jsp" %>