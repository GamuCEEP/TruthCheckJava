<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>TruthCheck - The Role-Play Assistant</title>
  
  <link rel="stylesheet" href="<%= request.getContextPath() %>/root.css">
  <link rel="stylesheet" href="<%= request.getContextPath() %>/pages/home.css">
  <link rel="stylesheet" href="<%= request.getContextPath() %>/components/gamu-modal.css">
  
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Milonga&display=swap" rel="stylesheet">
  
  <script>
    ;(()=>{
      window.addEventListener('load', ()=>{
        const label = document.querySelector('#welcome')
        label.innerText = 'Bienvenido ' + document.cookie.split(';')
      })
    })
  </script>
</head>

<body>
  <header>
    <gamu-modal>
      <form class="modal" method="POST">
        <label id="welcome" >Bienvenido</label>
        <button type="submit" formaction="[biblioteca]">Mi biblioteca</button>
        <button type="submit" formaction="gallery.jsp">Creaciones de la comunidad</button>
        <button type="submit" formaction="[partida]">Crear una partida</button>
        <button type="submit" formaction="/TruthCheckJava/logout">Cerrar sesión</button>
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
