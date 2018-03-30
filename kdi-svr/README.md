# kdi-svr

[TOC]

## 1. 部署

- 本机

```sh
cd ~/workspaces/02/kdi/kdi-svr
./deploy/deploy-???.sh
```

## 2. 配置中心

- 在git服务器中加入 kdi-svr-prod.yml 文件的内容

## 3. 创建并启动容器

启动时注意映射端口号

```sh
docker run -d --net=host --name kdi-svr-a -v /usr/local/kdi-svr/a:/usr/local/myservice --restart=always nnzbz/spring-boot-app
```