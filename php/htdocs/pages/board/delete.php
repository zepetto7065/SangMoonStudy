<?php
    $sql = "DELETE FROM board WHERE idx = '{$_GET['idx']}'";
    if($db->query($sql)){ 
        header("Location:./");
    }else{
        echo $sql;
        print_r($db->errorInfo());
    }

