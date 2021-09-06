<?php

    // $param = isset($_GET['param']) ? explode('/', $_GET['param']) : [];
    // print_pre(explode("a", "amdmdkdma amdkakd an"));
    // exit;

    $page = $_GET['page'] ?? 'list';
    $idx = $_GET['idx'] ?? NULL;

    $titles = [
        'list' => '게시물 목록',
        'view' => '게시물 조회',
        'update' => '게시물 수정',
        'write' => '게시물 작성'
    ];

?>