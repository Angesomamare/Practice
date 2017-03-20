

<%@include  file="header.jsp" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Teacher</title>

<br><br><br><br>


<div class="container" style="align: center">
    <div class="row" >
        <div class="col-sm-12">
            <div class="panel panel-success">
                <div class="panel-heading">School of Patriots Header</div>
                <div class="panel-body">


                    <h1>Add Teacher</h1>

                    <form:form action="addTeacher" method="post" modelAttribute="teacher">
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
                                    <label for="grade_level_section_assigned">Section & Grade:</label>
                                    <form:input type="text" class="form-control" id="grade_level_section_assigned" path="grade_level_section_assigned" placeholder="Grade and section" cssStyle="width: auto"/>
                                </div><br>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-12">
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
                            <button type="submit" class="btn btn-primary">Add Teacher</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>


<%@include  file="footer.jsp" %>