ALTER TABLE `kdi`.`KDI_COMPANY` 
CHANGE COLUMN `MONTHCODE` `MONTH_CODE` VARCHAR(45) NULL DEFAULT NULL COMMENT '月结账号' ,
CHANGE COLUMN `SENDSITE` `SEND_SITE` VARCHAR(45) NULL DEFAULT NULL COMMENT '网点名称' ;

-- 2018年9月20日 更新到大卖网线上
alter table kdi.KDI_COMPANY add IS_DEFAULT tinyint not null comment '是否默认';
alter table kdi.KDI_COMPANY add ORG_ID bigint not null comment '组织ID';
alter table kdi.KDI_LOGISTIC add ORG_ID bigint not null comment '组织ID';
alter table kdi.KDI_SENDER add ORG_ID bigint not null comment '组织ID';