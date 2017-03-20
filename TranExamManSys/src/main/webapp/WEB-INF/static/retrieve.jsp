<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>Submitted Student Information</h2>
<table>
    <tr>
        <td>Given Name</td>
        <td>${student.student_id_number}</td>
    </tr>
    <tr>
        <td>Father Name</td>
        <td>${student.given_name}</td>
    </tr>
</table>
</body>
</html>