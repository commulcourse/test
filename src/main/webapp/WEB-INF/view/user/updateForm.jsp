<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@ include file="../layout/header.jsp" %>

        <div class ="gray-box">
           <h1>회원가입 페이지</h1>
        </div>
        <hr />
        <%-- 회원가입이 제대로 된경우 form action="/join"으로 이동한다 --%>
         <form action="/update" method="post">
            <input type="text" name="username" placeholder="Enter username" required><br />
            <input type="password" name="password" placeholder="Enter password" required><br />
            <input type="email" name="email" placeholder="Enter email" required><br />
            <button type="submit">회원가입</button>
        </form>

        <%@ include file="../layout/footer.jsp" %>