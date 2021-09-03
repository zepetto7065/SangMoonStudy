<?php


$message = 'Hello world';
$userCount = 0;
$pi = 3.14;
$is_visited = false;
$temp = null;

// ''과는 다른 결과를 가져옴
echo "The message is {$message}";

/**
 * Hear Doc , Now Doc
 */
echo <<<HTML
<html>
    <head>
        <title>$message</title>
    </head>
</html>
HTML; //붙여써야함, 잘안쓴다.

/**
 * free
 */
unset($message);
echo $message; 