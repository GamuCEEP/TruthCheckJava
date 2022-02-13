<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Bienvenida - TruthCheck</title>

  <link rel="stylesheet" href="<%= request.getContextPath() %>/pages/css/root.css">
  <link rel="stylesheet" href="<%= request.getContextPath() %>/pages/css/home.css">
  <link rel="stylesheet" href="<%= request.getContextPath() %>/pages/css/modal.css">

  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Milonga&display=swap" rel="stylesheet">
  
  <script src="<%= request.getContextPath() %>/pages/js/root.js"></script>
</head>

<body>

  <header>

    <nav>
        <form method="POST" class="modal">
          <label>Log In</label>
          <input type="text" required name="user" placeholder="Usuario">
          <span>
            <input type="password" required name="password" placeholder="Contraseña">
            <input type="checkbox" hidden id="togglePasswordVisibility">
            <label for="togglePasswordVisibility"></label>
          </span>
          <script>
            ;(()=>{
              window.addEventListener('load', ()=>{
                const passwordInput = $('input[type="password"]')
                const passwordToggle = $('#togglePasswordVisibility')
                passwordToggle.addEventListener('change', ()=>{
                  passwordInput.type = passwordToggle.checked ? 'text' : 'password'
                })
              })
            })()
          </script>
          <div>
            <input type="submit" formaction="/TruthCheckJava/register" value="Registrarse">
            <input type="submit" formaction="/TruthCheckJava/login" value="Entrar">
          </div>
          <a href="/TruthCheckJava/gallery">
            Solo quiero ver
          </a>
        </form>
    </nav>

  </header>
  <main>
    <div>
      <h1>TruthCheck</h1>
      <h2>The Role Play Assistant</h2>
    </div>
  </main>



</body>

</html>