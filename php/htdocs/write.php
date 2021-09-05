
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시물 작성</title>
</head>
<body>
    <form action="./write_ok.php" method="post">
        <fieldset>
            <legend>글작성</legend>
                <ul>
                    <li>
                        <label>
                            제목
                            <input type="text" name="subject" />
                        </label>
                    </li>
                    <li>
                        <label>
                            작성자
                            <input type="text" name="writer" />
                        </label>

                    </li>
                    <li>
                        <label>
                            내용
                            <input type="text" name="content" />
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