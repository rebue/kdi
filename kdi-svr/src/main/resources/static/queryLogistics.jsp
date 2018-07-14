<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>大卖网络</title>
<meta name="wap-font-scale" content="no">
<meta name="viewport"
	content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<link rel="stylesheet" type="text/css"
	href="${ctx }/css/wechat/mui.min.css">
<link rel="stylesheet" type="text/css"
	href="${ctx }/css/wechat/wboly_mobile.css">
<link rel="stylesheet" type="text/css"
	href="${ctx }/css/wechat/operation.css" />
<link rel="stylesheet" type="text/css"
	href="${ctx }/css/wechat/webuploader.css" />
<link rel="stylesheet"
	href="http://www.kdniao.com/OutDemo/KDNWidget/KDNWidget.css" />
<script src="${ctx }/js/wechat/mui.min.js"></script>
<script src="${ctx }/js/wechat/jquery.min.js" type="text/javascript"></script>
<script src="${ctx }/js/wechat/webuploader.html5only.min.js"
	type="text/javascript"></script>
<script src="${ctx }/js/util/commonUtil.js"></script>
<script src="http://www.kdniao.com/OutDemo/KDNWidget/KDNWidget.js"></script>
</head>

<body>
	<header class="mui-bar mui-bar-nav">
		<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
		<h4 class="mui-title">查看物流信息</h4>
	</header>
	<script>
		window.onload = function() {
			var logisticCode = "${logisticCode}";
			logisticCode = logisticCode == "null" ? "" : logisticCode;
			KDNWidget.run({
				serviceType : "A",
				expCode : "${shipperCode}",
				expNo : logisticCode,
			})
		}
	</script>
</body>
</html>