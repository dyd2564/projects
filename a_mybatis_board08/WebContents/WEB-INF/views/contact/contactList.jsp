<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
	<h1>연락처</h1>
	<table class="table">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>연락처</th>
		</tr>
		<c:if test="${empty contactList}">
		<tr>
			<td colspan="3">
				<b>저장된 연락처가 없습니다.</b>
			</td>		
		</tr>
		</c:if>
		<c:if test="${not empty contactList}">
		<c:forEach items="${contactList}" var="c">
		<tr>
			<td>${c.cno }</td>
			<td>${c.userName }</td>
			<td>${c.phoneNumber }</td>
		</tr>
		</c:forEach>
		</c:if>
	</table>
	
	<div class="d-flex justify-content-between my-3">
		<h3>연락처 추가</h3>
		<div>
			<button class="btn btn-info addContactLiBtn">폼추가</button>
			<button class="btn btn-danger delContactLiBtn">폼삭제</button>
		</div>
	</div>
	<form class="contactForm" action="${contextPath}/contact/addContact" method="post">
		<ul class="list-group">
			<li class="list-group-item text-center">
				<div class="form-group row ">
					<label class="col-2">이름</label>
					<div class="col-10">
						<input type="text" class="form-control userName" name="contactList[0].userName">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-2">휴대폰 번호</label>
					<div class="col-10">
						<input type="text" class="form-control phoneNumber" name="contactList[0].phoneNumber">
					</div>
				</div>
			</li>
		</ul>
		<button class="bnt bnt-success">등록</button>
	</form>
	
</div>
<%@ include file="../layout/footer.jsp" %>

<script>
$(function(){
	let liNumber = 1; // 처음 인덱스 값 	
	
	$('.addContactLiBtn').on('click',function(){
		if(liNumber>=5){ 
			alert('더 이상 추가할 수 없음');
			return;
		}
		let contactLi = $('.contactForm li').eq(0).clone();
		contactLi.find('input').val(''); // input태그 모든값 삭제 
		let userNameInput = contactLi.find('.userName'); // userName Input 선택
		let phoneNumberInput = contactLi.find('.phoneNumber'); // phoneNumber Input 선택
		let u = userNameInput.attr("name").replace('0',liNumber); // userName name속성 변경 
		let p = phoneNumberInput.attr("name").replace('0',liNumber); // phoneNumber name 속성 변경
		userNameInput.attr("name",u); // 변경한 name속성 설정
		phoneNumberInput.attr("name",p); // 변경한 name속성 설정
		$('.contactForm ul').append(contactLi); // ul태그에 추가 
		liNumber++; // 인덱스번호 증가
	})
	
	$('.delContactLiBtn').on('click',function(){
		if(liNumber<=1){ // 폼이 하나만 있을 때 삭제할 수 없음
			alert('마지막 폼은 삭제할 수 없습니다.');
			return;
		}
		$('.contactForm li').eq(liNumber-1).remove(); // 마지막폼 삭제 
		liNumber--;  // 인덱스번호 감소
	});
});
</script>


