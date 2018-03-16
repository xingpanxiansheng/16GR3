SQL> show sga;

Total System Global Area 1486495744 bytes                                       
Fixed Size                  2175888 bytes                                       
Variable Size             872418416 bytes                                       
Database Buffers          603979776 bytes                                       
Redo Buffers                7921664 bytes                                       
SQL> select name from v$database;

NAME                                                                            
------------------                                                              
ORCL                                                                            

SQL> spool off;
