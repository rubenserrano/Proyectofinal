<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    </head>
   
        
     
    <body>
        <p>Nombre</p>
        <input type="text" id="nombre"><br>
        <p>Sueldo</p>
        <input type="text" id="sueldo"><br>
        <input type="button" id="boton-guardar" value="Guardar Usuario">
        <p>Oprimi el boton de abajo para buscar todos</p>
        <input type="button" value="Recobrar todos" id="boton-recobrar-todos">
        <div></div>
        <script>
        
     $("#boton-recobrar-todos").click(function(){   
  $.getJSON("http://localhost:8090/Unitec/servicios/usuario",function(result){
    $.each(result, function(i, campo){
      $("div").append("<li>"+campo.nombre + "</li> ");
    });
  });
});

$("#boton-guardar").click(function(){
    var nombre=$("#nombre").val();
    var sueldo=$("#sueldo").val();
    $.ajax({
        method:'GET',
        url:"http://localhost:8090/Unitec/servicios/usuario/"+nombre+"/"+sueldo,
        success:function(valor){
            alert(valor);
        },
        failure:function(e){
            alert(e);
        }
    });
});



        </script>
    </body>
</html>
