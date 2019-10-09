<?php

include 'dbconnect.php';

$grito = $_GET["grito"];
$query = 'INSERT INTO gritos (grito) VALUES (:grito)';
$resultado = $coffeerdb -> prepare($query);
$resultado -> execute(array(':grito'=>$grito));

die(json_encode(array('err' => false, 'msg' => 'Añadido')));

 ?>
