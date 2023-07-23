<html>
    <head>
        <title>Login Page</title>
    </head>
    <body>
        <div class="container">
            <h1>Log in</h1>
            <pre>${errorMessage}</pre>
            <form method="post">
            <%-- not secure because name and password show in url.Improve by use method post in form--%>
                Name: <input type="text" name="name">
                Password: <input type="password" name="password">
                <input type="submit">
            </form>
        </div>
    </body>
</html>