<?php

$messages = [
    'name' => 'php',
    'categoryId' => 0,
    'messages' => [
        'Hello, world',
        'Who are you'   
    ]
];

foreach($messages as $key => $value){
    echo $value . PHP_EOL;
}