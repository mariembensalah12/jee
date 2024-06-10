<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login</title>
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;700&display=swap" rel="stylesheet">
  <style>
    body, html {
      margin: 0;
      padding: 0;
      font-family: 'Inter', sans-serif;
      background-color: #f0f2f5;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100%;
      overflow: hidden;
    }

    .login-container {
      width: 100%;
      max-width: 360px;
      background: #ffffff;
      padding: 2rem;
      border-radius: 12px;
      box-shadow: 0 6px 20px rgba(0, 0, 0, 0.1);
      text-align: center;
      animation: fadeIn 0.5s ease-in-out;
    }

    @keyframes fadeIn {
      from {
        opacity: 0;
        transform: translateY(-20px);
      }
      to {
        opacity: 1;
        transform: translateY(0);
      }
    }

    .login-container h2 {
      font-size: 1.75rem;
      margin-bottom: 1.5rem;
      color: #333;
    }

    .form-group {
      margin-bottom: 1.5rem;
      text-align: left;
    }

    .form-group label {
      display: block;
      margin-bottom: 0.5rem;
      font-size: 0.875rem;
      color: #555;
    }

    .form-group input,
    .form-group select {
      width: 100%;
      padding: 0.75rem;
      border: 1px solid #d1d1d1;
      border-radius: 8px;
      font-size: 1rem;
      color: #333;
      transition: border-color 0.3s ease;
    }

    .form-group input:focus,
    .form-group select:focus {
      border-color: #007bff;
      outline: none;
    }

    .form-group select {
      appearance: none;
      background: url('data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMTYiIGhlaWdodD0iMTYiIHZpZXdCb3g9IjAgMCAxNiAxNiIgZmlsbD0ibm9uZSIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KPHBhdGggZD0iTTQgNkw4IDExTDEyIDZIMTRMMTAgMThINkwxIDZINkwiIGZpbGw9IiM3OTc5NzkzIi8+Cjwvc3ZnPg==') no-repeat right 0.75rem center/12px 12px;
    }

    .form-group input[type="submit"] {
      background-color: #007bff;
      color: #fff;
      border: none;
      cursor: pointer;
      font-size: 1rem;
      font-weight: 600;
      transition: background-color 0.3s ease;
      text-transform: uppercase;
      margin-top: 1rem;
    }

    .form-group input[type="submit"]:hover {
      background-color: #0056b3;
    }

    .form-group select:invalid {
      color: #999;
    }
  </style>
</head>
<body>
  <div class="login-container">
    <h2>Connexion</h2>
    <form action="loginServlet" method="post">
      <div class="form-group">
        <label for="username">Nom d'utilisateur</label>
        <input type="text" id="username" name="username" placeholder="Nom d'utilisateur" required>
      </div>
      <div class="form-group">
        <label for="password">Mot de passe</label>
        <input type="password" id="password" name="password" placeholder="Mot de passe" required>
      </div>
      <div class="form-group">
        <label for="role">Rôle</label>
        <select id="role" name="role" required>
          <option value="" disabled selected>Choisir le rôle</option>
          <option value="enseignant">Enseignant</option>
          <option value="agent">Agent</option>
          <option value="admin">Administrateur</option>
        </select>
      </div>
      <div class="form-group">
        <input type="submit" value="Connexion">
      </div>
    </form>
  </div>
</body>
</html>
