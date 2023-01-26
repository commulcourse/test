<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@ include file="../layout/header.jsp" %>
        <h1>로그인 페이지</h1>
        <nav>
            <div class="s_box">
                <a href="/">로그인</a>&nbsp
                <a href="/joinForm">회원가입</a>
            </div>
            <div id="underline">
            </div>
        </nav>
        <div>
            <div class="innerbox">
                <table border="1">
                    <form action="/join" method="post">
                        <tr>
                            <th>유저네임</th>
                            <td><input type="text" value="${remember}" placeholder="Enter username" required></td>
                        </tr>
                        <tr>
                            <th>패스워드</th><br />
                            <td><input type="password" name="password" placeholder="Enter password" required></td>
                        </tr>
                </table>
            </div>
            <div class="b_box">
                <button type="submit" style="color:rgb(219, 53, 94)">로그인</button>
            </div>
            </form>
            <%@ include file="../layout/footer.jsp" %>