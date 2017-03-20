<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration Confirmation Page</title>
</head>
<body>
${success}
<br/>
<br/>
<%--<form action="/" >--%>
    <%--<input type="submit" value="Home"/>--%>
<%--</form>--%>
<%--<form action="addStudent" >--%>
    <%--<input type="submit" value="Add Student"/>--%>
<%--</form>--%>
<%--<form action="addTeacher" >--%>
    <%--<input type="submit" value="Add Teacher"/>--%>
<%--</form>--%>
<%--<form action="addSubject" >--%>
    <%--<input type="submit" value="Add Subject"/>--%>
<%--</form>--%>
<%--<form action="addGrade" >--%>
    <%--<input type="submit" value="Add Grade"/>--%>
<%--</form>--%>
<a href="<c:url value='/' />">Home</a><br><br>
<a href="<c:url value='/addStudent' />">Add Student</a><br><br>
<a href="<c:url value='/addTeacher' />">Add Teacher</a><br><br>
<a href="<c:url value='/addSubject' />">Add Subject</a><br><br>
<a href="<c:url value='/addGrade' />">Add Grade</a><br><br>
<a href="<c:url value='/allStudents' />">List Students</a>
</body>

</html>