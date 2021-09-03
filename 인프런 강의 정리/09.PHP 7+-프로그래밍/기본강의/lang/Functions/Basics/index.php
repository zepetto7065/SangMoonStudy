<?php

/**
 * Define Function
 */
function foo(){
    echo 'Hello world';
}

foo();

function foo4($arg1, $arg2, $arg3){
    var_dump($arg1, $arg2, $arg3);
}

$args = ['Hello, world', 'Who are you', 'Bye'];

foo4(...$args);