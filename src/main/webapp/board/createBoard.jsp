<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="kr.or.ddit.db.user.model.UsersVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<style>
#p1 {
	color: red;
}
</style>

<title>Jsp</title>
<!-- Lib(Css,js) -->
<%@include file="/common/basicLib.jsp"%>

<script>
	$(document).ready(function(){
		$('#create').on('click',function(){
			if($('#boardName').val().length == 0){
				alert("생성할 게시판 이름을 써주세요");
			}else{
				$('#frm').submit();
			}
		});
	});

</script>
</head>

<body>
	<!--  header영역 -->
	<%@include file="/common/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<!--  left영역 -->
			<%@include file="/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">게시판 등록</h2>
						
						<form id="frm" class="form-horizontal" role="form" action="${pageContext.request.contextPath }/create_board" method="post">
							<!-- 값 넘기기 -->
							<input type="hidden" id="userId" name="userId" value="${USER_INFO.userId}">
						
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label"> 게시물 이름 : </label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="boardName" name="boardName"  /> 
								</div>
								<div>
									<select class="useYN" value="useYN" name="useYN">
										<option>Y</option>
										<option>N</option>
									</select>
										<button id="create" type="button">생성</button>
								</div>
							</div>
							</form>
							
							<c:forEach items="${boardAllList }" var="list">
								<form id="frm1" class="form-horizontal" role="form" action="${pageContext.request.contextPath }/create_board" method="post">
									
									<input type="hidden" id="board_id" name="board_id" value="${list.board_id}">
									<input type="hidden" id="userId" name="userId" value="${USER_INFO.userId}">
									
									<div class="form-group">
										<label for="userNm" class="col-sm-2 control-label"> 게시물 이름 : </label>
										<div class="col-sm-8">
											<input type="text" class="form-control" id="boardName" name="boardName" value="${list.board_name }" /> 
										</div>
										<div>
											<select class="useYN" value="useYN" name="useYN">
												<option>Y</option>
												<option>N</option>
											</select>
												<button id="update" type="submit">수정</button>
										</div>
									</div>
								</form>
							</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>