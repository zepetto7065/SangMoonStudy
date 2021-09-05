<?php
    // $_POST = ['subject' => '...' ,...]
    // echo "<p>{$_POST['subject']}</p>";
    // echo "<p>{$_POST['writer']}</p>";
    // echo "<p>{$_POST['content']}</p>";
    // $_POST = ['subject' => '...' ,...]
    // echo "<p>{$_GET['subject']}</p>";
    // echo "<p>{$_GET['writer']}</p>";
    // echo "<p>{$_GET['content']}</p>";
    try{
        $db = new PDO("mysql:host=127.0.0.1;dbname=20190428;charset=utf8","root","7065dltkdan");
        $sql = "
            INSERT INTO `board` SET
            subject = '{$_POST['subject']}',
            writer = '{$_POST['writer']}',
            content = '{$_POST['content']}',
            reg_date = now();
        ";
        if($db->query($sql)){ //정상적으로 실행이 되면 1을 반환
            $idx = $db -> lastInsertId(); 
            header("Location:./view.php?idx={$idx}");
        }else{
            echo $sql;
            print_r($db->errorInfo());
        }
    }catch(Exception $e){
        echo "등록이 실패했습니다 : ".$e;
    }


//     $sql = "
//     INSERT INTO `board`
//                 (
//                     `idx`    
//                 ,   `subject`
//                 ,   `writer`
//                 ,   `content`
//                 ,   `reg_date`
//                 )
//           VALUES
//                 (
//                     NULL
//                 ,   '{$_POST['subject']}'
//                 ,   '{$_POST['writert']}'
//                 ,   '{$_POST['content']}'
//                 ,    now()
//                 )
// ";