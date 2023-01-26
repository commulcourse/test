<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@ include file="../layout/header.jsp" %>

        <h1>회원정보 수정 페이지</h1>
        <div class="s_box">
            <a href="/updateForm/${principal.id}">회원정보수정</a>&nbsp
            <a href="/logout">로그아웃</a>
        </div>
        <hr />
        <div>
            <div class="innerbox">
                <table border="1">
                    <form action="/update" method="post">
                        <tr>
                            <th>유저네임</th>
                            <td><input type="text" value="username" placeholder="Enter username" required></td>
                        </tr>
                        <tr>
                            <th>패스워드</th>
                            <td><input type="password" name="password" placeholder="Enter password" required></td>
                        </tr>
                        <tr>
                            <th>이메일</th>
                            <td><input type="email" name="email" placeholder="Enter email" required></td>
                        </tr>
                </table>
            </div>
            <div class="b_box">
                <button type="submit" style="color:rgb(219, 53, 94)">수정완료</button>
            </div>
            </form>

            <%@ include file=" ../layout/footer.jsp" %>