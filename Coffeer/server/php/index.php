<?php

include "conf.php";

session_start();

if (isset($_SESSION["auth"]) && ($_SESSION["auth"] == 1)) {
  die(json_encode(array('err' => false, 'user' => $_SESSION["username"])));
} else {
  die(json_encode(array('err' => true, 'msg' => 'no auth')));
}

 ?>
