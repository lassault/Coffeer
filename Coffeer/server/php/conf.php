<?php

include "dbconnect.php";
header("Content-type: application/json");

$list_of_drinks = array(
  1 => 'beer',
  2 => 'coffee'
);

//Diferenciar peticiones de la app a peticiones via navegador, ¿añadir un flag enviado desde la app en las peticiones?
//Posible solucion, mandar un hash o firma digital desde el movil para diferenciar el origen de la peticion

 ?>
