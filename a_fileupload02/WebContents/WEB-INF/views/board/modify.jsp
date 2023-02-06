<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
	<div class="jumbotron">
		<h2>첨부파일 여러개 업로드</h2>
	</div>
	
	<form class="modBoardForm" action="${contextPath}/board/modify" method="post" enctype="multipart/form-data">
		<input type="hidden" name="bno" value="${b.bno}">
		<input type="text" name="title" class="form-control" placeholder="제목" value="${b.title}">
		<textarea rows="10" name="content" class="form-control">${b.content}</textarea>
		<input type="text" name="writer" class="form-control" placeholder="작성자" value="${b.writer}" readonly="readonly">
		<div class="fileForm">
			<div>
				<button type="button" class="btn btn-primary add">폼추가</button>
				<button type="button" class="btn btn-danger del">폼삭제</button>
			</div>
			<input type="file" name="attachFile" class="form-control attachFile">
		</div>
		<!-- 첨부파일이 있을 때  -->
		<c:if test="${not empty attachList }">
			<!-- 파일 다운로드 -->
			<c:forEach items="${attachList }" var="attach">
			<div class="media border p-3 my-2">
				<div class="media-body d-flex justify-content-between">
					<div>
						<img src="${contextPath}/resources/images/fileicon.png" style="width:20px">
						${attach.fileName}
					</div>
					<div>
						<label for="delCheck">삭제 : </label>
						<input type="checkbox" class="form-control delCheck" value="${attach.attachNo}" id="delCheck">					
					</div>
				</div>
			</div>
			</c:forEach>
			<!-- 이미지 미리보기 -->
			<h3>이미지 미리보기</h3>
			<c:forEach items="${attachList }" var="attach">
				<c:if test="${attach.fileType eq 'IMAGE'}">
					<div class="media border p-3 my-2">
						<div class="media-body d-flex justify-content-between">
							<img src="${contextPath}/imgDisplay?filePath=${attach.filePath}&fileName=${attach.fileName}" style="width:200px;">
							<p>${attach.fileName}</p>
						</div>
					</div>			
				</c:if>
			</c:forEach>
			
		</c:if>	
		
		<!-- 첨부파일이 없을 때  -->
		<c:if test="${empty attachList }">
			<div class="media border p-3 my-2">
				<div class="media-body">
					<b>등록된 첨부파일이 없습니다.</b>
				</div>
			</div>
		</c:if>
		<button class="btn btn-primary modBoardProc">수정하기</button>		
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
	
	let setDel = new Set();
	$('.delCheck').on('change',function(){
		let checkStatus = $(this).prop('checked');	
		if(checkStatus){ // 체크
			setDel.add($(this).val());
		} else { // 언체크
			setDel.delete($(this).val());
		}
		console.log(setDel);
	})
	$('.modBoardProc').on('click',function(e){
		e.preventDefault();
		let delFileList = Array.from(setDel).join();
		$('.modBoardForm').append('<input type="hidden" name="delFileList" value="'+delFileList+'">')
		$('.modBoardForm').submit();
	})
})
</script>


