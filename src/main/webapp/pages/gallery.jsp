<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Galeria - TruthCheck</title>

    <link rel="stylesheet" href="<%= request.getContextPath()%>/pages/css/root.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/pages/css/retractil.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/pages/css/gallery.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/pages/css/modal.css">
  </head>

  <body>
    <header>
      <div id="logo">
        <a href="/TruthCheckJava/home">
          <img src="/TruthCheckJava/images/logo.png" alt="~TC~" width="80">
        </a>
      </div>
      <div id="searchBar">
        <form action="">
          <input type="text" placeholder="Buscar">
          <input type="submit" value="">
        </form>
      </div>
      <div id="userIcon">
        <!-- Loged in/not logged in -->
        <a href="">

        </a>
        
      </div>
    </header>
    <main>

      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <footer>

      </footer>
    </main>

    <div style="position: relative;">

      <input type="checkbox" class="retractil-toggler" id="aside-toggle">
      <label for="aside-toggle"></label>
      <aside class="retractil">
        <form method="GET">

          <c:forEach var="type" items="${ResourceTypes}">
            <button formaction="/TruthCheckJava/gallery" name="${type.toString()}">
              ${type.getWebText()}
            </button>
          </c:forEach>

        </form>
      </aside>
    </div>

    <script>
      ${resources.toString()}
    </script>

  </body>

</html>