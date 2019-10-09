<?php

include "conf.php";

$user_data = ($_GET);

$input_data = obtain_user_data($user_data);

if (isset($input_data["username"]) && isset($input_data["password"]) && isset($input_data["name"]) && isset($input_data["surname"])) {
  $user_exists = is_a_valid_username($input_data["username"], $coffeerdb);
  if ($user_exists == 0) {
    $status_PHP = prepare_and_set_the_query($input_data, $coffeerdb);
  } else {
    $status_PHP = array(
      'err' => true,
      'msg' => 'Ya existe un usuario con ese username'
    );
  }
} else {
  $status_PHP = array(
    'err' => true,
    'msg' => "username='username'&password='password'&name='name'&surname='surname'"
  );
}

die(json_encode($status_PHP));

function obtain_user_data ($user_data) {
  isset($user_data["username"]) ? $user_data["username"] : $user_data["username"] = null;
  isset($user_data["password"]) ? $user_data["password"] : $user_data["password"] = null;
  isset($user_data["nick"]) ? $user_data["nick"] : $user_data["nick"] = null;
  isset($user_data["name"]) ? $user_data["name"] : $user_data["name"] = null;
  isset($user_data["surname"]) ? $user_data["surname"] : $user_data["surname"] = null;

  return $user_data;

}

function is_a_valid_username ($username, $coffeerdb) {
  $query_comprobar_username = 'SELECT COUNT(username) FROM users WHERE username=:username';
  $resultado = $coffeerdb -> prepare($query_comprobar_username);
  $resultado -> execute(array(':username' => $username));
  $user_exists = $resultado -> fetch(PDO::FETCH_NUM);
  return intval($user_exists[0]);
}

function prepare_and_set_the_query ($input_data, $coffeerdb) {
  $query_crear_usuario = "INSERT INTO users (username, password, nick, name, surname) VALUES (:username, :password, :nick, :name, :surname)";
  $resultado = $coffeerdb -> prepare($query_crear_usuario);
  $datos_query = array(
    ':username' => $input_data["username"],
    ':password' => hash('sha256', $input_data["password"]),
    ':nick' => $input_data["nick"],
    ':name' => $input_data["name"],
    ':surname' => $input_data["surname"]
  );
  $resultado -> execute($datos_query);
  if ($resultado === false) {
    $status_PHP = array(
      'err' => true,
      'msg' => 'No fue posible hacer la consulta'
    );
  } else {
    $status_PHP = array(
      'err' => false,
      'msg' => 'OK',
      'username' => $input_data["username"]
     );

     return $status_PHP;
  }

}

 ?>
