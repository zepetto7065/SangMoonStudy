<?php
    $row = fetch("SELECT * FROM board WHERE idx = '{$idx}'");
?>
<form action = "" method = "post" name="deleteFrm"> 
    <input type="hidden" name="action" value="delete" />
</form>
<ul>
    <li><?php echo $row->idx ?></li>
    <li><?php echo $row->subject ?></li>
    <li><?php echo $row->writer ?></li>
    <li><?php echo $row->reg_date ?></li>
    <li><?php echo $row->content ?></li> 
</ul>
<p>
    <a href="./">글목록</a>
    <a href="./?page=update&amp;idx=<?php echo $idx ?>">글수정</a>
    <a href="#" onclick="document.forms[0].submit();">글삭제</a> <!-- document.deleteFrm으로도 가능 -->
    <a href="./?page=write">글작성</a>
</p>
