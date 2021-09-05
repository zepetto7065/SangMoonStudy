<?php

    try{
        $db = new PDO("mysql:host=127.0.0.1;dbname=20190428;charset=utf8","root","7065dltkdan");
        $sql = "
            UPDATE `board` SET
            subject = '{$_POST['subject']}',
            writer = '{$_POST['writer']}',
            content = '{$_POST['content']}'
            WHERE idx = '{$_GET['idx']}';
        ";
        if($db->query($sql)){ //정상적으로 실행이 되면 1을 반환
            header("Location:./view?idx={$_GET['idx']}");
        }else{
            echo $sql;
            print_r($db->errorInfo());
        }
    }catch(Exception $e){
        echo "등록이 실패했습니다 : ".$e;
    }

