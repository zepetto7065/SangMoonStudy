<?php

/**
 * Define Array
 */
$message1 = 'Hello world';
// $messages = [
//     'Hello, world',
//     'Who are you',
//     'Bye'
// ];

// $messages = array('Hello, world','Who are you','Bye');
$messages = [
    0 => 'hello world',
    'message' => 'who are you?'
];

/**
 * Destructuring
 */
// list(, $message) = $messages; //, 은 생략
[0 => $message] = $messages;
var_dump($message);

