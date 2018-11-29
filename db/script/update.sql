-- ---------------------------- 下面的已经更新到大卖网线上 ----------------------------

-- 2018-10-25
alter table kdi.KDI_LOGISTIC add ENTRY_TYPE    tinyint not null comment '录入类型  0：未知 1:手动  2:自动';
--
ALTER TABLE `kdi`.`KDI_COMPANY` 
CHANGE COLUMN `MONTHCODE` `MONTH_CODE` VARCHAR(45) NULL DEFAULT NULL COMMENT '月结账号' ,
CHANGE COLUMN `SENDSITE` `SEND_SITE` VARCHAR(45) NULL DEFAULT NULL COMMENT '网点名称' ;

-- 2018-9-20
alter table kdi.KDI_COMPANY add IS_DEFAULT tinyint not null comment '是否默认';
alter table kdi.KDI_COMPANY add ORG_ID bigint not null comment '组织ID';
alter table kdi.KDI_LOGISTIC add ORG_ID bigint not null comment '组织ID';
alter table kdi.KDI_SENDER add ORG_ID bigint not null comment '组织ID';
