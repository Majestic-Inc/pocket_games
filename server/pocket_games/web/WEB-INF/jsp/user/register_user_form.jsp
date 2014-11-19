<%-- 
    Document   : register_user_form
    Created on : 19.11.2014, 19:26:35
    Author     : azakharov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pocket Games | Регистрация пользователя</title>
    </head>
    <body>
        ${registration_error}
        <h1>Регистрация пользователя</h1>
        <table>
            <form action="register.htm" method="POST">
                <tr>
                    <td>* E-mail: </td>
                    <td><input name="mail" type="text" /></td>
                </tr>
                <tr>
                    <td>* Пароль: </td>
                    <td><input name="password" type="password" /></td>
                </tr>
                <tr>
                    <td>* Повторите пароль: </td>
                    <td><input name="repeatPassword" type="password" /></td>
                </tr>                                
                
                <tr>
                    <td>Имя: </td>
                    <td><input name="name" type="text" /></td>
                </tr>
                <tr>
                    <td>Фамилия: </td>
                    <td><input name="lastName" type="text" /></td>
                </tr>
                
                <tr>
                    <td></td>
                    <td><input value="Регистрация" type="submit" /></td>
                </tr>
            </form>
        </table>
    </body>
</html>
