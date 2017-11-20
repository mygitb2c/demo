<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="/springfourmvc/bootstrap/css/bootstrap.css" />
<script src="/springfourmvc/bootstrap/js/jquery-2.1.0.js" type="text/javascript"
	charset="utf-8"></script>
<script src="/springfourmvc/bootstrap/js/bootstrap.js" type="text/javascript"
	charset="utf-8"></script>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<form role="form" action="addArticle" method="post">
					<div class="form-group">
						<label for="exampleInputEmail1">Article Id</label><input
							type="text" class="form-control" id="exampleInputEmail1"
							name="ARTICLEID" />
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Article Title</label><input
							type="text" class="form-control" id="exampleInputPassword1"
							name="ARTICLETITLE" />
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>