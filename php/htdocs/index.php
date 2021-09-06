<?php
    include_once('./core/lib.php');
    include_once('./core/config.php');

    if(isset($_POST['action'])){
        include_once('./actions/board.php');
        exit;
    }

    include_once("./pages/template/header.php");
    include_once("./pages/board/{$page}.php"); 
    include_once("./pages/template/footer.php");
