<?php

include "conf.php";

$list_of_drinks = array(
  1 => 'beer',
  2 => 'coffee'
);

$input_data = ($_GET);

$drink_data = obtain_drink_data($input_data);

if (isset($drink_data["userID"]) && isset($drink_data["communityID"]) && isset($drink_data["drinkID"]) && isset($drink_data["score"])) {
  $status_PHP = prepare_and_set_the_query($drink_data, $coffeerdb);
} else {
  $status_PHP = array(
    'err' => true,
    'msg' => "userID='userID'&communityID='communityID'&drinkID='drinkID'&score='score'"
  );
}

die(json_encode($status_PHP));

function obtain_drink_data ($input_data) {
  isset($input_data["userID"]) ? $input_data["userID"] : $input_data["userID"] = null;
  isset($input_data["communityID"]) ? $input_data["communityID"] : $input_data["communityID"] = null;
  isset($input_data["drinkID"]) ? $input_data["drinkID"] : $input_data["drinkID"] = null;
  isset($input_data["score"]) ? $input_data["score"] : $input_data["name"] = null;

  return $input_data;
}

function prepare_and_set_the_query ($drink_data, $coffeerdb) {
  $query_add_drink = "UPDATE scores SET :drinkID = :drinkID + :score WHERE userID=:userID AND communityID=:communityID";
  $resultado = $coffeerdb -> prepare($query_add_drink);
  $datos_query = array(
    ':drinkID' => 'beerScore'//$list_of_drinks[$drink_data["drinkID"]] + 'Score',
    ':score' => $drink_data["score"],
    ':userID' => $drink_data["userID"],
    ':communityID' => $drink_data["communityID"]
  );
  die(json_encode($drink_data));
  $resultado -> execute($datos_query);
  if ($resultado === false) {
    $status_PHP = array(
      'err' => true,
      'msg' => 'No fue posible añadir la bebida'
     );
     die(json_encode($resultado -> errorInfo()));
  } else {
    $satus_PHP = array(
      'err' => false,
      'msg' => "Añadid@"
    );
  }

  return $status_PHP;
}

 ?>
