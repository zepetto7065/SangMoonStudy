<?php

$args = include 'HelloWorld.php';
// include_once 'Helloworld.php'; //한번만 중복 허용 x

// require 'Helloworld.php'; //파일이 없으면 컴파일 에러
// require_once 'HelloWorld.php';

// var_dump($message);
// foo();
var_dump($args);