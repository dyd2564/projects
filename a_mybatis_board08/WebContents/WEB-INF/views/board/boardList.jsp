<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
	<h1>게시물 관리</h1>
	<table class="table">	
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>
				<button class="btn btn-danger selDel">선택삭제</button>
			</th>
		</tr>
		<c:if test="${empty boardList}">
		<tr>
			<td colspan="4"><b>게시물이 존재하지 않습니다.</b></td>
		</tr>
		</c:if>
		<c:if test="${not empty boardList}">
		<c:forEach items="${boardList}" var="b">
		<tr>
			<td>${b.bno}</td>
			<td>${b.title}</td>
			<td>${b.writer}</td>
			<td class="col-2">
				<input type="checkbox" class="form-control bno_ckbox" value="${b.bno}">		
			</td>
		</tr>
		</c:forEach>	
		</c:if>
	</table>
</div>
<%@ include file="../layout/footer.jsp" %>

<script>
$(function(){
	
	let bnoSet = new Set(); 
	$('.bno_ckbox').on('change',function(){
		let bno = $(this).val();
		let isChecked = $(this).prop('checked')
		if(isChecked){
			console.log(bno + "번 체크");
			bnoSet.add(bno);
		} else {
			console.log(bno + "번 체크 해제");
			bnoSet.delete(bno);
		}
		console.log(bnoSet);
	});
	
	$('.selDel').on('click',function(){
		console.log(bnoSet.size)
		if(bnoSet.size<=0){
			alert('삭제할 게시물을 선택하세요');
			return; 
		}
		let delForm = $('<form/>')
		// 변환 : Set -> 배열 -> 문자열 
		let bnoListStr = Array.from(bnoSet).join()
		delForm.attr('method','post')
			.attr('action','${contextPath}/board/delSelectedBoard?bnoList='+bnoListStr)
			.appendTo('body')
			.submit()
	})
	
});
</script>


