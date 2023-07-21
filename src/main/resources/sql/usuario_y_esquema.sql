create schema if not exists `bec;

CREATE USER if not exists 'pwadmin'@'localhost' identified by 'ADMIN_PW_PWD';
grant all on jbedujbiis.* to 'pwadmin'@'localhost' ;


flush privileges;
