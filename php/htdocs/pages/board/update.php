<?php
//'{$_GET['idx']}' -> '{$idx}' index에서 선언을 해주었기 떄문에 변경
    $row = fetch("SELECT * FROM board WHERE idx = '{$idx}'"); //fetch는 하나만 가져온다.
?>

<form action="" method="post">
    <fieldset>
        <legend>글작성</legend>
        <input type="hidden" name="action" value="update" />
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
