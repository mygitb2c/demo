<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.etc.entity.Article"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ShowArticle</title>
<link rel="stylesheet" type="text/css" href="/springfourmvc/bootstrap/css/bootstrap.css" />
<style type="text/css">
.edi{
	border:2px solid lightblue;
}
</style>
<script src="/springfourmvc/bootstrap/js/jquery-2.1.0.js"
	type="text/javascript" charset="utf-8"></script>
<script src="/springfourmvc/bootstrap/js/bootstrap.js"
	type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	$(function() {
		page=1;
		pageSize=10;
		key="";
		total=0;
	
		$.get("Article",{"page":1,"pageSize":5,"key":""},function(pd,states){
			showArt(pd);
			
		})
		function showArt(pd){
			$("tbody tr").remove();
			$.each(pd.data,function(index,art){
				$("tbody").append("<tr><td >"+art.ARTICLEID+"</td><td>"+art.ARTICLETITLE+"</td>"+
						"<td>"+art.ARTICLEAUTHOR+"</td>"+
						"<td>"+art.ARTICLECONTENT+"</td>"+
						"<td>"+art.ARTICLEDATE+"</td>"+
						"<td><button class='btn btn-primary updbtn'>修改</button>"+
						"<button class='btn btn-danger delbtn'>删除</button></td></tr>")
			})
			page=pd.page;
			pageSize=pd.pageSize;
			total=pd.total;
		}
		
		$(document).on("click", ".updbtn", function() {
			if ($(this).text() == "修改") {
				if($(".active").length>0&&!confirm("点击 ‘是’，关闭其他正在执行的操作，执行修改")){
					return;
				}
				$(".addtr").remove();
				$("tr td").removeClass("active");
				$("tr td").prop("contenteditable", false);
				$(this).parents("tr").find("td").prop("contenteditable", true);
				$(this).parents("tr").find("td").eq(0).prop("contenteditable", false);
				$(this).parents("tr").find("td").eq(4).prop("contenteditable", false);
				$(this).parent("td").prop("contenteditable", false);
				$("td[contenteditable=true]").addClass("active");
				
				$(this).text("完成");
			} else {
				var $id=$(this).parents("tr").find("td").eq(0).text();
				var $title=$(this).parents("tr").find("td").eq(1).text();
				var $author=$(this).parents("tr").find("td").eq(2).text();
				var $content=$(this).parents("tr").find("td").eq(3).text();
				
				$.post("updateArticle",{"ARTICLEID":$id,"ARTICLETITLE":$title,"ARTICLEAUTHOR":$author,"ARTICLECONTENT":$content,"page":page,"pageSize":pageSize,"key":key},function(pd,state){
					showArt(pd);
				})
			}

		})
		
		$(document).on("click",".delbtn",function(){
			var flag=confirm("确定要删除 <"+$(this).parents("tr").find("td").eq(1).text()+"> 吗？");
			if(flag){
				var $id=$(this).parents("tr").find("td").eq(0).text();
				$.get("deleteArticle",{"ARTICLEID":$id,"page":page,"pageSize":pageSize,"key":key},function(pd,states){
					showArt(pd);
					
				})
				
				
			}
		})
		
		
		$("#key").keyup(function(){
			key=$(this).val();
			$.post("show",{"page":1,"pageSize":5,"key":$(this).val()},function(pd,states){
				showArt(pd)	
			})
		})
		
		$("#allinfo").click(function(){
			$.post("show",{"page":1,"pageSize":5,"key":""},function(pd,states){
				showArt(pd);
				$("#key").val("");
				key="";
			})
			
		})
		
		$("#adda").click(function(){
			if($(".active").length>0&&!confirm("点击 ‘是’，关闭其他正在执行的操作，执行新增")){
				return;
			}
			$(".active").parents("tr").find("td").eq(5).find(".updbtn").text("修改");
			$(".active").prop("contenteditable",false);
			$(".active").removeClass("active");
			$(".addtr").remove();
			$("tbody").html("<tr class='addtr'><td class='active artid'></td><td class='active arttitle'></td>"+
			"<td class='active artauthor'></td><td class='active artcontent'></td><td>由系统生成</td>"+
			"<td><button class='btn btn-primary addbtn'>完成</button>"+
			"<button class='btn btn-danger cenclebtn'>取消</button></td></tr>"+$("tbody").html());
			$(".active").prop("contenteditable",true);
		})
		
		$(document).on("click",".cenclebtn",function(){
			var flag=confirm("是否要取消 [新增] 动作？");
			if(flag){
				$(this).parents("tr").remove();
			}
		})
		
		$(document).on("click",".addbtn",function(){
			if($(".arttitle").text().length>0&&$(".artauthor").text().length>0&&$(".artcontent").text().length>0){
			$.post("addArticle",{"ARTICLEID":$(".artid").text(),"ARTICLETITLE":$(".arttitle").text(),"ARTICLEAUTHOR":$(".artauthor").text(),"ARTICLECONTENT":$(".artcontent").text(),"page":page,"pageSize":pageSize,"key":$("#key").val()},function(pd,states){
				showArt(pd);
			})}else{
				alert("不要留空");
			}
		})
		
	

	})
</script>
</head>
<body>

	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<nav class="navbar navbar-default" role="navigation">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span><span
							class="icon-bar"></span><span class="icon-bar"></span><span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" id="allinfo">显示全部</a>
				</div>
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li ><a href="#">Link</a></li>
						<li><a href="#">Link</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Dropdown<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								
								<li><a href="#">编辑</a></li>
								<li><a href="#">Something </a></li>
								<li class="divider"></li>
								<li><a href="#">Separated link</a></li>
								<li class="divider"></li>
								<li><a href="#">One more </a></li>
							</ul></li>
					</ul>
					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input type="text" class="form-control" id="key" />
						</div>
						<button type="button" class="btn btn-default" id="adda">新增</button>
						
					</form>
					
				</div>

				</nav>
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-12 column">
				<table class="table table-bordered">
					<thead >
						<tr text-center="center">
							<td>文章编号</td>
							<td>文章标题</td>
							<td>文章作者</td>
							<td>文章内容</td>
							<td>发布时间</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>