/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/9/20 15:27:48                           */
/*==============================================================*/


drop table if exists KDI_COMPANY;

drop table if exists KDI_LOGISTIC;

drop table if exists KDI_SENDER;

drop table if exists KDI_TRACE;

/*==============================================================*/
/* Table: KDI_COMPANY                                           */
/*==============================================================*/
create table KDI_COMPANY
(
   ID                   bigint not null comment '快递公司信息ID',
   COMPANY_NAME         varchar(50) not null comment '快递公司名称',
   COMPANY_ACCOUNT      varchar(50) not null comment '快递公司账号',
   COMPANY_PWD          varchar(50) not null comment '快递公司密码',
   COMPANY_CODE         varchar(50) not null comment '快递公司编号',
   PAY_TYPE             tinyint not null comment '支付类型
            运费支付方式:
            1-现付
            2-到付
            3-月结
            4-第三方付',
   ENTRY_TIME           datetime not null comment '录入时间',
   ORG_ID               bigint not null comment '组织ID',
   IS_DEFAULT           bool not null comment '是否为默认公司（true：默认  false：不是默认）',
   MONTH_CODE           varchar(45) comment '月结账号',
   SEND_SITE            varchar(45) comment '网点',
   primary key (ID)
);

alter table KDI_COMPANY comment '快递公司信息';

/*==============================================================*/
/* Table: KDI_LOGISTIC                                          */
/*==============================================================*/
create table KDI_LOGISTIC
(
   ID                   bigint not null comment '物流订单ID',
   SHIPPER_ID           bigint not null comment '快递公司ID',
   SHIPPER_CODE         varchar(20) not null comment '快递公司编码',
   SHIPPER_NAME         varchar(100) not null comment '快递公司名称',
   LOGISTIC_CODE        varchar(30) not null comment '物流订单号',
   LOGISTIC_STATUS      varchar(3) not null default '0' comment '物流订单状态
            0-无轨迹
            1-已揽收
            2-在途中 201-到达派件城市 202-派件中 211-已放入快递柜或驿站
            3-已签收 311-已取出快递柜或驿站
            4-问题件 401-发货无信息 402-超时未签收 403-超时未更新 404-拒收(退件) 412-快递柜或驿站超时未取',
   ORDER_TIME           datetime not null comment '下单时间',
   UPDATE_TIME          datetime not null comment '更新时间',
   ESTIMATED_ARRIVAL_TIME datetime comment '预计到达时间',
   CITY                 varchar(20) comment '所在城市',
   PAY_TYPE             tinyint comment '支付类型
            运费支付方式:
            1-现付
            2-到付
            3-月结
            4-第三方付',
   EXP_TYPE             tinyint comment '快递类型
            1-标准快件
            
            详细快递类型参考《快递公司快递业务类型.xlsx》',
   ORDER_ID             bigint not null comment '订单ID',
   ORDER_TITLE          varchar(100) comment '订单标题',
   ORDER_DETAIL         varchar(300) comment '订单详情',
   SENDER_NAME          varchar(30) comment '发件人名称',
   SENDER_TEL           varchar(20) comment '发件人电话',
   SENDER_MOBILE        varchar(20) comment '发件人手机',
   SENDER_PROVINCE      varchar(20) comment '发件省',
   SENDER_CITY          varchar(20) comment '发件市',
   SENDER_EXP_AREA      varchar(20) comment '发件区',
   SENDER_ADDRESS       varchar(300) comment '发件人详细地址',
   SENDER_POST_CODE     char(6) comment '发件地邮编',
   RECEIVER_NAME        varchar(30) comment '收件人名称',
   RECEIVER_TEL         varchar(20) comment '收件人电话',
   RECEIVER_MOBILE      varchar(20) comment '收件人手机',
   RECEIVER_PROVINCE    varchar(20) comment '收件省',
   RECEIVER_CITY        varchar(20) comment '收件市',
   RECEIVER_EXP_AREA    varchar(20) comment '收件区',
   RECEIVER_ADDRESS     varchar(300) comment '收件人详细地址',
   RECEIVER_POST_CODE   char(6) comment '收件地邮编',
   PRINT_PAGE           text comment '打印页面',
   ORG_ID               bigint not null comment '组织id',
   primary key (ID),
   key AK_SHIPPER_LOGISTIC_CODE (SHIPPER_ID, LOGISTIC_CODE),
   unique key AK_ORDER_ID (ORDER_ID)
);

alter table KDI_LOGISTIC comment '物流订单';

/*==============================================================*/
/* Table: KDI_SENDER                                            */
/*==============================================================*/
create table KDI_SENDER
(
   ID                   bigint not null comment '发件人信息ID',
   SENDER_NAME          varchar(30) not null comment '发件人名称',
   SENDER_TEL           varchar(20) comment '发件人电话',
   SENDER_MOBILE        varchar(20) comment '发件人手机',
   SENDER_PROVINCE      varchar(20) not null comment '发件省',
   SENDER_CITY          varchar(20) not null comment '发件市',
   SENDER_EXP_AREA      varchar(20) not null comment '发件区',
   SENDER_ADDRESS       varchar(300) not null comment '发件人详细地址',
   SENDER_POST_CODE     char(6) not null comment '发件地邮编',
   IS_DEFAULT           bool not null comment '是否为默认发件人（true：默认  false：不是默认）',
   ENTRY_TIME           datetime not null comment '录入时间',
   ORG_ID               bigint not null comment '组织id',
   primary key (ID)
);

alter table KDI_SENDER comment '发件人信息';

/*==============================================================*/
/* Table: KDI_TRACE                                             */
/*==============================================================*/
create table KDI_TRACE
(
   ID                   bigint not null comment '物流轨迹ID',
   LOGISTIC_ID          bigint not null comment '物流ID',
   TRACE_DESC           varchar(100) not null comment '轨迹描述',
   HAPPEN_TIME          datetime not null comment '发生时间',
   LOGISTIC_STATUS      varchar(3) comment '物流状态
            1-已揽收
            2-在途中 201-到达派件城市 202-派件中 211-已放入快递柜或 驿站
            3-已签收 311-已取出快递柜或 驿站
            4-问题件 401-发货无信息 402-超时未签收 403-超时未更新 404-拒收(退件) 412-快递柜或驿站超 时未取',
   CITY                 varchar(20) comment '所在城市',
   primary key (ID)
);

alter table KDI_TRACE comment '物流轨迹';

alter table KDI_TRACE add constraint FK_Relationship_1 foreign key (LOGISTIC_ID)
      references KDI_LOGISTIC (ID) on delete restrict on update restrict;

