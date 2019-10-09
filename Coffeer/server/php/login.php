<?php

include "conf.php";

session_start();

$auth = is_a_valid_user($_GET["username"], $_GET["password"], $coffeerdb);

$_SESSION["auth"] = $auth;

if ($_SESSION["auth"] == 1) {
  $user_data = obtain_user_data($_GET["username"], $coffeerdb);
  $_SESSION["username"] = $user_data["username"];
  $_SESSION["nick"] = $user_data["nick"];
  $_SESSION["name"] = $user_data["name"];
  $_SESSION["surname"] = $user_data["surname"];
  die(json_encode(array(
    "err" => false,
    "username" => $_SESSION["username"],
    "nick" => $_SESSION["nick"],
    "name" => $_SESSION["name"],
    "surname" => $_SESSION["surname"]
  )));
} else {
  die(json_encode(array("err" => true)));
}

function is_a_valid_user($username, $password, $coffeerdb) {
  $query_comprobar_usuario = 'SELECT COUNT(username) FROM users WHERE username=:username && password=:password';
  $resultado = $coffeerdb -> prepare($query_comprobar_usuario);

  $array_data = array(
    ':username' => $username,
    ':password' => hash('sha256', $password)
  );

  $resultado -> execute($array_data);
  $user_exists = $resultado -> fetch(PDO::FETCH_NUM);

  if (intval($user_exists[0]) == 1) {
    $user_exists = 1;
  } else {
    $user_exists = 0;
  }
  return $user_exists;
}

function obtain_user_data ($username, $coffeerdb) {

  $query_pedir_usuario = "SELECT username, nick, name, surname FROM users WHERE username=:username";

  $resultado = $coffeerdb -> prepare($query_pedir_usuario);
  $resultado -> execute(array(":username" => $username));

  $user_data = $resultado -> fetch(PDO::FETCH_ASSOC);

  return $user_data;
}

 ?>
