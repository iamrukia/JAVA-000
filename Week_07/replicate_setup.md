show master status;

CHANGE MASTER TO
    MASTER_HOST='localhost',  
    MASTER_PORT = 3306,
    MASTER_USER='repl',      
    MASTER_PASSWORD='123456',   
    MASTER_LOG_FILE='mysql-bin.000002',
    MASTER_LOG_POS=856,
    MASTER_PUBLIC_KEY_PATH='master_public_key.pem';
    
    
error connecting to master 'repl@localhost:3306' - retry-time: 60 retries: 18 message: Authentication plugin 'caching_sha2_password' reported error: Authentication requires secure connection.
     
start slave;
stop slave;     
     
mysql> SHOW GLOBAL VARIABLES LIKE 'caching_sha2_password_public_key_path';
+---------------------------------------+----------------+
| Variable_name                         | Value          |
+---------------------------------------+----------------+
| caching_sha2_password_public_key_path | public_key.pem |
+---------------------------------------+----------------+
1 row in set (0.00 sec)