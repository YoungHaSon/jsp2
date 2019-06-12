<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="kr.or.ddit.db.user.model.PageVo"%>
<%@page import="kr.or.ddit.db.user.model.UsersVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- core라이브러리를 쓸꺼니까! uri 잘 확인 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
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

<title>답글 등록</title>

<!-- LibLib(Css,js) -->
<%@include file="/common/basicLib.jsp"%>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="${pageContext.request.contextPath }/SE2/js/HuskyEZCreator.js"></script>


<script>
var oEditors = []; // 개발되어 있는 소스에 맞추느라, 전역변수로 사용하였지만, 지역변수로 사용해도 전혀 무관 함.

	$(document).ready(function(){
		$('#click').on('click',function(){
			//5개 이상 안 생성되게 조건문 걸어야
			if($('.file').length != 5){
				$('#result').append("<input type='file' class='file' name='profile'/>");
			}else{
				alert("더 이상 생성할수 없습니다.");
			}
		});
		
		// Editor Setting
		nhn.husky.EZCreator.createInIFrame({
			oAppRef : oEditors, // 전역변수 명과 동일해야 함.
			elPlaceHolder : "smarteditor", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
			sSkinURI : "${pageContext.request.contextPath }/SE2/SmartEditor2Skin.html", // Editor HTML
			fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
			htParams : {
				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseToolbar : true,
				// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseVerticalResizer : true,
				// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
				bUseModeChanger : true, 
			}
		});

		// 전송버튼 클릭이벤트
		$("#savebutton").click(function(){
			if(confirm("저장하시겠습니까?")) {
				// id가 smarteditor인 textarea에 에디터에서 대입
				oEditors.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);

				// 이부분에 에디터 validation 검증
				if(validation()) {
					$("#frm").submit();
				}
			}
		})
		
	});
	// 필수값 Check
	function validation(){
		var contents = $.trim(oEditors[0].getContents());
		if(contents === '<p>&nbsp;</p>' || contents === ''){ // 기본적으로 아무것도 입력하지 않아도 <p>&nbsp;</p> 값이 입력되어 있음. 
			alert("내용을 입력하세요.");
			oEditors.getById['smarteditor'].exec('FOCUS');
			return false;
		}
		return true;
	}
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
						<h2 class="sub-header">답글 작성</h2>
						
						<form id="frm" class="form-horizontal" role="form" action="${pageContext.request.contextPath }/reply" method="post" 
							enctype="multipart/form-data">
		
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">답글 제목&nbsp;&nbsp; :  </label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="title"	name="title" /> 
								</div>
							</div>
		
							<textarea name="smarteditor" id="smarteditor" rows="10" cols="100" style="width:766px; height:412px;"></textarea> 
							
							<div class="form-group">
								<div class="col-sm-10">
									<input type="button" id="savebutton" value="답글 등록" />
								</div>
							</div>
							
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">첨부파일&nbsp;&nbsp; :  </label>
								<div class="col-sm-8">
									<input type="file" class="file" name="profile"/>
									<div id="result"></div>
								</div>
								<div class="col-sm-2">
									<button id="click" type="button" class="btn btn-danger">추 가</button>
								</div>
							</div>
							
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
