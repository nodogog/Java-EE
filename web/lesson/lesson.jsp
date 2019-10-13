<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="sms/Lesson" method="post">
    <table cellspacing="0" cellpadding="0">
        <tr>
            <td>ლექციის სახელი</td>
            <td><input type="text" name="lessonName"></td>
        </tr>
        <tr>
            <td>ფასი</td>
            <td><input type="number" name="price"></td>
        </tr>
        <tr>
            <td>ლექტორი</td>
            <td><input type="text" name="lectureName"></td>
        </tr>
        <tr>
            <td>კრედიტების რაოდენობა</td>
            <td><input type="number" name="lessonCredit"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="submit">
            </td>
        </tr>
    </table>
</form>


<%--<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>--%>


<div style="margin: 20px;">
    <table cellpadding="10" cellspacing="10" border="1" style="border-collapse: collapse">
        <tr>
            <td>ID</td>
            <td>ლექციის სახელი</td>
            <td>ფასი</td>
            <td>ლექტორის სახელი</td>
            <td>კრედიტების რაოდენობა</td>
            <td>#</td>
        </tr>
        <c:forEach items="${lesson}" var="lessons">
            <tr>
                <td>${lessons.id}</td>
                <td>${lessons.lessonName}</td>
                <td>${lessons.price}</td>
                <td>${lessons.lectureName}</td>
                <td>${lessons.lessonCredit}</td>
                <td>
                    <a href="/sms/Lesson?action=add">add</a>
                    <a href="/sms/Lesson?action=edit&id=${lessons.id}">edit</a>
                    <a href="/sms/Lesson?action=delete&id=${lessons.id}">del</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>