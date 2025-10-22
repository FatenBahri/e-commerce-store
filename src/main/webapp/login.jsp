<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>COMMERCE</title>
    <link rel="stylesheet" type="text/css" href="designlog.css">
</head>
<body>
    <div class="login-container">
        <h2>Connexion</h2>
        <h3>Bienvenue !</h3>
        <form action="LoginServlet" method="post" class="login-form">
            <label for="username">Nom d'utilisateur :</label>
            <input type="text" id="username" name="username" required>

            <label for="password">Mot de passe :</label>
            <input type="password" id="password" name="password" required>

            <button id="btnlogin" type="submit">Se connecter</button>
        </form>
    </div>
</body>
</html>
