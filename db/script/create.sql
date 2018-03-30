/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/4/14 13:12:40                           */
/*==============================================================*/


drop table if exists KDI_TRACE;

drop table if exists KDI_LOGISTIC;


/*==============================================================*/
/* Table: KDI_LOGISTIC                                          */
/*==============================================================*/
create table KDI_LOGISTIC
(
   ID                   bigint not null comment '物流订单ID',
   SHIPPER_CODE         varchar(10) not null comment '快递公司编码',
   LOGISTIC_CODE        varchar(30) not null comment '物流订单号',
   LOGISTIC_STATUS      varchar(3) not null default '0' comment '物流订单状态
            0-无轨迹
            1-已揽收
            2-在途中 201-到达派件城市 202-派件中 211-已放入快递柜或驿站
            3-已签收 311-已取出快递柜或驿站
            4-问题件 401-发货无信息 402-超时未签收 403-超时未更新 404-拒收(退件) 412-快递柜或驿站超时未取',
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
   primary key (ID),
   key AK_SHIPPER_LOGISTIC_CODE (SHIPPER_CODE, LOGISTIC_CODE),
   unique key AK_ORDER_ID (ORDER_ID)
);

alter table KDI_LOGISTIC comment '物流订单';

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

