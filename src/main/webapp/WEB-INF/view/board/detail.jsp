<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@ include file="../layout/header.jsp" %>

        <h1>상품상세 페이지</h1>
        <hr />
        <table border="1">
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성일</th>
            </tr>
            <tr>
                <td>${board.id}</td>
                <td>${board.title}</td>
                <td>${board.createdAt}</td>
            </tr>
        </table>
        <c:if test="${principal != null}">
            <form action="/board/{id}" method="post">
                <input type="hidden" name="boardId" value="${board.id}">
                <select name="count">
                    <c:forEach begin="1" end="${board.qty}" var="num">
                        <option value="${num}">${num}</option>
                    </c:forEach>
                </select>
                <button type="submit">구매하기</button>
            </form>
        </c:if>


        <%@ include file="../layout/footer.jsp" %>