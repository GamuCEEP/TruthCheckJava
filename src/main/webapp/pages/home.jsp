<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>TruthCheck - The Role-Play Assistant</title>
  
  <link rel="stylesheet" href="<%= request.getContextPath() %>/pages/css/root.css">
  <link rel="stylesheet" href="<%= request.getContextPath() %>/pages/css/home.css">
  <link rel="stylesheet" href="<%= request.getContextPath() %>/pages/css/modal.css">
  
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Milonga&display=swap" rel="stylesheet">
  
</head>

<body>
  <header>
    <gamu-modal>
      <form class="modal" method="POST">
        <label id="welcome" >Bienvenido ${userName}</label>
        <button type="submit" formaction="/TruthCheckJava/library">Mi biblioteca</button>
        <button type="submit" formaction="/TruthCheckJava/gallery">Creaciones de la comunidad</button>
        <button type="submit" formaction="[partida]">Crear una partida</button>
        <button type="submit" formaction="/TruthCheckJava/logout">Cerrar sesi&oacute;n</button>
      </form>
    </gamu-modal>
  </header>
  <main>
    <div>
      <h1>TruthCheck</h1>
      <h2>The Role Play Assistant</h2>
    </div>
  </main>
</body>

</html>
