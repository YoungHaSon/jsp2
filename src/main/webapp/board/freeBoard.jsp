<%@page import="kr.or.ddit.db.user.model.PageVo"%>
<%@page import="kr.or.ddit.db.user.model.UsersVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- core라이브러리를 쓸꺼니까! uri 잘 확인 -->
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
.textTr:hover {
	cursor: pointer;
}
</style>

<title>사용자 리스트</title>

<!-- LibLib(Css,js) -->
<%@include file="/common/basicLib.jsp"%>
<script>
	$(document).ready(function(){
		//사용자 tr 태그 이벤트 등록
		$(".textTr").on("click", function(){
			//해당 tr을 클릭했을때 어떤 userId인지 받아올라고 userId 획득 방법
			//$(this).find(".text").text();
			//$(this).data("userId");
			
			var a = $(this).children("td:nth-child(2)").text();
			if(a == "작성자에 의해 삭제된 게시글 입니다."){
				return false;
			}
			
			//사용자 Id를 값으로 설정해주고
			var textid = $(this).find(".text").text();
			$('#textid').val(textid);
			
			//#frm 을 이용하여 submit();
			$('#frm').submit();
		});
	});

</script>
</head>

<body>
	<!--  header영역 -->
	<%@include file="/common/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<%@include file="/common/left.jsp"%>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<div class="row">
					<div class="col-sm-8 blog-main">
		
					<h2 class="sub-header">${boardVo.board_name} &nbsp;게시판</h2>
				
						<!-- 사용자 상세조회 : userId필요 -->
						<form id="frm" action="${pageContext.request.contextPath }/text" method="get">
							<input type="hidden" id="textid" name="textid">
							<input type="hidden" id="userid" name="userid" value="${USER_INFO.userId}">
						</form>

						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>게시글 번호</th>
									<th>제목</th>
									<th>작성자 아이디</th>
									<th>작성일시</th>
								</tr>

								<!-- allText user들을 출력해주는! -->
								<c:forEach items="${textList }" var="text">
									<tr class="textTr">
										<td class="text">${text.text_id}</td>
										<c:choose>
											<c:when test="${text.col eq 'Y'}">
												<c:choose>
													<c:when test="${text.text_id2 > 0}">
													<td style="padding-left:${text.lv}9px"><span>ㄴ</span>${text.text_title}</td>
													</c:when>
													<c:otherwise>
														<td>${text.text_title}</td>
													</c:otherwise>
												</c:choose>
											</c:when>
											<c:otherwise>
												<td>작성자에 의해 삭제된 게시글 입니다.</td>
											</c:otherwise>
										</c:choose>
										
										<td>${text.userid }</td>
										<td>${text.text_date}</td>
									</tr>
								</c:forEach>
								
							</table>
						</div>
						
						<a href="${pageContext.request.contextPath}/createText?board_id=${board_id}&&userid=${userid}"class="btn btn-default pull-right">게시물 등록</a>
					
						<div class="text-center">
							<ul class="pagination">
								<!-- 클릭하면 첫 페이지로 -->
								<c:choose>
									<c:when test="${pageVo.page eq 1}">
										<li class="disabled"><span>«</span></li>
									</c:when>
								<c:otherwise>
								<li><a
									href=" ${pageContext.request.contextPath }/primaryBoard?board_id=${board_id}&page=1&pageSize=10">«</a>
								</li>
								</c:otherwise>
								</c:choose>
								
								<c:choose>
									<c:when test="${pageVo.page eq 1}">
										<li class="disabled"><span>&lt;</span></li>
									</c:when>
									<c:otherwise>
										<li><a
											href=" ${pageContext.request.contextPath }/primaryBoard?board_id=${board_id}&page=${pageVo.page-1}&pageSize=${pageVo.pageSize}">&lt; </a>
										</li>
									</c:otherwise>
								</c:choose>

								<c:forEach var="i" begin="1" end="${paginationSize }">
									<c:choose>
										<c:when test="${pageVo.page eq i}">
											<li class="active"><span>${i}</span></li>
										</c:when>
										<c:otherwise>
											<li><a
												href="${pageContext.request.contextPath }/primaryBoard?board_id=${board_id}&page=${i}&pageSize=${pageVo.pageSize}">${i}</a>
											</li>
										</c:otherwise>
									</c:choose>
								</c:forEach>

								<c:choose>
									<c:when test="${pageVo.page eq paginationSize }">
										<li class="disabled"><span>&gt;</span></li>
									</c:when>
									<c:otherwise>
										<li><a
											href=" ${pageContext.request.contextPath }/primaryBoard?board_id=${board_id}&page=${pageVo.page+1}&pageSize=${pageVo.pageSize}">&gt;</a>
										</li>
									</c:otherwise>
								</c:choose>
								<!-- 클릭하면 맨마지막 페이지로 -->
								<c:choose>
									<c:when test="${pageVo.page eq paginationSize }">
										<li class="disabled"><span>»</span></li>
									</c:when>
									<c:otherwise>
									<li><a
										href=" ${pageContext.request.contextPath }/primaryBoard?board_id=${board_id}&page=${paginationSize}&pageSize=${pageVo.pageSize}">»</a>
									</li>
									</c:otherwise>
								</c:choose>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
