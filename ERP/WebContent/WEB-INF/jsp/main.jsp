<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.6.6/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.6.6/themes/icon.css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.6.6/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.6.6/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.6.6/locale/easyui-lang-zh_CN.js"></script>
	
<script type="text/javascript">
$(function(){
	$("#tree").tree({
		url:"${pageContext.request.contextPath}/authInfo/findAllAuth.do",
		lines:true,
		onLoadSuccess:function(){
			$('#tree').tree("collapseAll")

		},
		onClick:function(node){
			 if(node.id==54){
				$.messager.confirm("推出提示","您确定要退出吗？",function(f){
					
					if(f){
						logout();
					}
					
				})
			
			} 
			
			if(node.attributes.url!=""){
				
				openDome(node);
			}
			
		}
		
	});

});
function openDome(node){
	if($("#tabs").tabs("exists",node.text)){
		$("#tabs").tabs("select",node.text);
	}else{
		var content="<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%'src=${pageContext.request.contextPath}/html/"+node.attributes.url+"></iframe>";
		$("#tabs").tabs("add",{
			title:node.text,
			iconCls:node.iconCls,
			content:content,
			closable:true
			
		});
		
		
	}
	
	
}

 function logout(){
	$.ajax({
		url:"${pageContext.request.contextPath}/userInfo/exitCurrentUserInfo.do",
		type:"post",
		dataType:"json",
		success:function(result){
			if(result.msg){
				window.location.href="${pageContext.request.contextPath}/login.jsp"
			}
			
			
		}
		
		
		
	});
	
} 

</script>

</head>
<body>

<body class="easyui-layout">
	<!-- 頂部布局Star -->
	<div region="north" style="height: 68px;">
		<div style="padding: 0px; margin: 0px; background-color: #E0ECFF;">
			<table>
				<tr>
					<td><img alt="北邮在线"
						 src="${pageContext.request.contextPath}/images/mainlogo.png"></td>
					<td valign="bottom">欢迎：${currentUserInfo.uname }&nbsp;&nbsp;『${currentUserInfo.roleName }』</td>
				</tr>
			</table>
		</div>


	</div>
	<!-- 頂部布局end -->
	
	
	<!--导航菜单布局Star  -->
	<div region="west" style="width: 160px; padding: 5px;" title="导航菜单" split="true">
		
		<ul id="tree" class="easyui-tree"></ul>
		
		
		</div>
	<!--导航菜单布局end  -->
	
	
	<!-- 中间详情页面布局Star -->
	<div region="center">
	<div class="easyui-tabs" fit="true" border="false" id="tabs">
		<div title="首页" data-options="iconCls:'icon-home'">
			<div align="center" style="padding-top: 100px;">
				<font color="red" size="10">欢迎使用</font>
			</div>
		</div>
	</div>
	</div>
	<!-- 中间详情页面布局end -->
	
	
	<!-- 底部页面布局Star -->
	<div region="south" style="height: 25px; padding: 5px;" align="center">
		版权所有 北邮在线<a href="http://www.xianyazhuo.com" target="_blank">http://www.xianyazhuo.com</a>
	</div>
	<!-- 底部页面布局end -->
</body>

</body>
</html>