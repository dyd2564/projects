<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
	<div class="jumbotron">
		<h2>첨부파일 여러개 업로드</h2>
	</div>
	
	<form action="${contextPath}/board/write" method="post" enctype="multipart/form-data">
		<input type="text" name="title" class="form-control" placeholder="제목">
		<textarea rows="10" name="content" class="form-control"></textarea>
		<input type="text" name="writer" class="form-control" placeholder="작성자">
		<div class="fileForm">
			<div>
				<button type="button" class="btn btn-primary add">폼추가</button>
				<button type="button" class="btn btn-danger del">폼삭제</button>
			</div>
			<input type="file" name="attachFile" class="form-control attachFile">
		</div>
		<button class="btn btn-info">전송</button>
	</form>
</div>
<%@ include file="../layout/footer.jsp" %>

<script>
$(function(){
	
	let formCount = 1; 
	$('.fileForm .add').click(function(){
		if(formCount>=5){
			alert('최대 5개까지 추가할 수 있습니다.')
			return;
		}
		let fileFormTag = $('.fileForm .attachFile').eq(0).clone().val('');
		$('.fileForm').append(fileFormTag);
		formCount++;
	})
	
	$('.fileForm .del').click(function(){
		if(formCount <=1){
			alert('마지막폼은 삭제할 수 없습니다.');
			return;
		}
		$('.fileForm .attachFile').eq(formCount-1).remove();
		formCount--;
	})
})
</script>


