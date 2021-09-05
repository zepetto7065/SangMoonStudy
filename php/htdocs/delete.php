<?php
    $db = new PDO("mysql:host=127.0.0.1;dbname=20190428;charset=utf8","root","7065dltkdan");
    $sql = "DELETE FROM board WHERE idx = '{$_GET['idx']}'";
    if($db->query($sql)){ 
        header("Location:./");
    }else{
        echo $sql;
        print_r($db->errorInfo());
    }

