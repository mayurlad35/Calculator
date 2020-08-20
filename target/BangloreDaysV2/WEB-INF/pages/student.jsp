<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<c:forEach var="student" items="${studentList}" >
    ${student.name}<br>
    ${student.age}<br>
    ${student.email}<br>
    ---------------------------------------<br>
</c:forEach>

</body>
</html>