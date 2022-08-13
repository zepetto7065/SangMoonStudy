<?php
$message = 'Hello, world';

function foo(){
    // global $message;
    $mesasge = $GLOBALS['message']; // php 내부적 정의 글로벌 배열 
    echo $message;
}

foo();

function foo2(){
    static $count = 0;
    return ++$count;
}

// echo foo2();
// echo foo2();

/**
 * Clouser
 */
function foo3($arg){
    return function () use($arg){ // 밖에 있는 것을 가져온다.
        $arg = 'Who are you?';
        return $arg;
    };
}

$func = foo3('Hello world');
echo $func();