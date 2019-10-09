<?php

$dbdescription = 'mysql:dbname=coffeerdb;host=localhost;port=3306';

try {
	$coffeerdb = new PDO($dbdescription, 'coffeer', 'coffeer');
} catch (PDOException $e) {
	die('Fallo la conexion a la base de datos');
}

 ?>
