<%--<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<jsp:include page="/header.jsp"></jsp:include>

<form action="/sms/Students" method="post">
    <table cellspacing="0" cellpadding="0">
        <tr>
            <td>სახელი: </td>
            <td><input type="text" name="firstname"></td>
        </tr>
        <tr>
            <td>გვარი: </td>
            <td><input type="text" name="lastname"></td>
        </tr>
        <tr>
            <td>დაბ. თარიღი: </td>
            <td><input type="text" name="birthdate"></td>
        </tr>
        <tr>
            <td>სქესი: </td>
            <td><input type="text" name="gender"></td>
        </tr>
        <tr>
            <td>ლექცია: </td>
            <td><input type="text" name="lecture"></td>
        </tr>
        <tr>
            <td>სტატუსი: </td>
            <td>
                <select name="status">
                    <c:forEach items="${statusList}" var="status">
                        <option value="${status.value}">${status.value}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>პ. ნომერი: </td>
            <td><input type="text" name="pn"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="submit">
            </td>
        </tr>
    </table>
</form>


<jsp:include page="/footer.jsp"></jsp:include><%@ page contentType="text/html;charset=UTF-8" %>

<jsp:include page="../header.jsp"></jsp:include>

<div style="margin: 20px;">
    <table cellpadding="10" cellspacing="10" border="1" style="border-collapse: collapse">
        <tr>
            <td>ID</td>
            <td>First Name</td>
            <td>Last Name</td>
            <td>Birth Date</td>
            <td>Gender</td>
            <td>Private Number</td>
            <td>Status</td>
            <td>Lecture Name</td>
            <td>Lecture State</td>
            <td>#</td>
        </tr>
        <c:forEach items="${students}" var="student">
            <tr>
                <td>${student.id}</td>
                <td>${student.firstName}</td>
                <td>${student.lastName}</td>
                <td>${student.birthDate}</td>
                <td>${student.gender}</td>
                <td>${student.pn}</td>
                <td>${student.status}</td>
                <td>${student.lecture.lectureName}</td>
                <td>${student.lecture.state}</td>
                <td>
                    <a href="/sms/Students?action=add">add</a>
                    <a href="/sms/Students?action=delete&id=${student.id}">del</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<jsp:include page="../footer.jsp"></jsp:include>