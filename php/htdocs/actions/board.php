<?php
$sql = "";
$url = "./";
extract($_POST); // $_POST 할당된 값(키)들을 하나의 변수들로 생성해준다. $_POST도 그대로 사용가능

switch($action){
    case 'insert' :
        $sql = "
        INSERT INTO `board` SET
        subject = '{$subject}',
        writer = '{$writer}',
        content = '{$content}',
        reg_date = now();
    ";
        break;
    case 'update' :
        $sql = "
            UPDATE `board` SET
            subject = '{$subject}',
            writer = '{$writer}',
            content = '{$content}'
            WHERE idx = '{$idx}';
        ";
        $url = "./?page=view&idx={$idx}";
        break;
    case 'delete' :
        $sql = "DELETE FROM board WHERE idx = '{$idx}'";
        break;
}
   
query($sql);

alert('완료되었습니다.');
move($url);