
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
--2019-3-01
/*==============================================================*/
/* Table: KDI_TEMPLATE                                          */
/*==============================================================*/
create table KDI_TEMPLATE
(
   ID                   bigint not null comment '模板ID',
   COMPANY_ID           bigint not null comment '快递公司ID',
   TEMPLATE_DIC_ID      bigint not null comment '模板字典ID',
   IS_DEFAULT           bool not null comment '是否默认',
   primary key (ID)
);

alter table KDI_TEMPLATE comment '电子面单模板';

/*==============================================================*/
/* Table: KDI_TEMPLATE_DIC                                      */
/*==============================================================*/
create table KDI_TEMPLATE_DIC
(
   ID                   bigint not null comment '模板字典ID',
   COMPANY_DIC_ID       bigint not null comment '快递公司字典ID',
   NAME                 varchar(20) not null comment '模板名称',
   IMG_PATH             varchar(100) not null comment '模板图片路径',
   PATH                 varchar(100) not null comment '模板路径',
   REMARK               varchar(50),
   primary key (ID)
);

alter table KDI_TEMPLATE_DIC comment '模板字典';
-- ---------------------------- 上面的已经更新到大卖网线上 ----------------------------
