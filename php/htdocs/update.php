<?php
    $db = new PDO("mysql:host=127.0.0.1;dbname=20190428;charset=utf8","root","7065dltkdan");
    $row = $db -> query("SELECT * FROM board WHERE idx = '{$_GET['idx']}'")->fetch(PDO::FETCH_OBJ); //fetch는 하나만 가져온다.
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시물 작성</title>
</head>
<body>
    <form action="./update_ok.php?idx=<?php echo $_GET['idx']?>" method="post">
        <fieldset>
            <legend>글작성</legend>
                <ul>
                    <li>
                        <label>
                            제목
                            <input type="text" name="subject" value="<?php echo $row->subject?>" />
                        </label>
                    </li>
                    <li>
                        <label>
                            작성자
                            <input type="text" name="writer" value="<?php echo $row->writer?>" />
                        </label>

                    </li>
                    <li>
                        <label>
                            내용
                            <input type="text" name="content" value="<?php echo $row->content?>" />
                        </label>
                    </li>
                </ul>
                <p>
                    <button type="button" onclick="history.back();">취소</button> 
                    <button type="submit">완료</button>
                </p>
        </fieldset>
    </form>
</body>
</html>