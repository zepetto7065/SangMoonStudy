<?php

function alert($msg){
    echo "<script>alert('{$msg}')</script>";
}

function move($url = false){
    echo "<script>";
    echo $url ? "location.replace('{$url}')" : "history.back();";
    echo "</script>";
    exit;
}

function access ($bool, $msg, $url = false){
    if(!$bool){
        alert($msg);
        move($url);
    }
}

// access(false, "안녕하세요", "http://naver.com"); //응용해서 사용가능

function print_pre($ele){
    //pre tag는 모든 공백을 그대로, 형태 그대로 출력해준다.
    //echo "<pre>"
    //print_r($_SERVER);
    //echo "</pre>"
    echo "<pre>";
    print_r($ele);
    echo "</pre>";
}

//한줄씩 보는 함수
function println($ele){
    echo "<p>{$ele}</p>";
}

function query($sql){
    $db = new PDO("mysql:host=127.0.0.1;dbname=20190428;charset=utf8","root","7065dltkdan");
    $res = $db->query($sql);    
    if(!$res){
        println($sql);
        print_pre($db->errorInfo());
    }
    $db = null;
    return $res;
}

function fetch($sql){
    return query($sql)->fetch(PDO::FETCH_OBJ);
}

function fetchAll($sql){
    return query($sql)->fetchAll(PDO::FETCH_OBJ);
}