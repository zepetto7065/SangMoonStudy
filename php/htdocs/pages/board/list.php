<?php
    $rows =  fetchAll("SELECT * FROM board");
?>

<ul>
    <?php foreach ($rows as $row):?>
        <li>
            <?php echo $row->idx ?> /
            <a href ="./?page=view&amp;idx=<?php echo $row->idx?>"><?php echo $row->subject ?></a> /
            <?php echo $row->writer ?> /
            <?php echo $row->reg_date ?>
        </li>
    <?php endforeach ?>    
</ul>
<p>
    <a href="./?page=write">글작성</a>
</p>
