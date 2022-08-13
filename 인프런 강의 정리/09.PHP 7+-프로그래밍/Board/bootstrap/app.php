<?php

/**
 * Timezone
 */
date_default_timezone_set('Asia/Seoul');

/**
 * Error Handling
 */
ini_set('display_erros', 'Off');

/** 
 * Database Connection MySQLi
 * || exit 커넥션 실패시 강제 종료
 */
$GLOBALS['DB_CONNECTION'] = mysqli_connect(
    'localhost',
    'root',
    'root',
    'phpblog'
) || exit;
register_shutdown_function(function(){
    if(array_key_exists('DB_CONNECTION', $GLOBALS) && $GLOBALS['DB_CONNECTION']){
        mysqli_close($GLOBALS['DB_CONNECTION']);
    }
});

/**
 * Session
 */
ini_set('session.gc_maxlifetime', 1440);
session_get_cookie_params(1440);

session_start();

