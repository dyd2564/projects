<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
	<div>
		<ul>
			<li>이름 : 김철수, 휴대폰번호 : 01055557777</li>
			<li>이름 : 박철수, 휴대폰번호 : 01044448888</li>
			<li>이름 : 황철수, 휴대폰번호 : 01066669999</li>
		</ul>
	</div>
	
	<div>
		<button class="addForm">폼추가</button>
		<button class="delForm">폼삭제</button>	
	</div>
	<form method="post" class="contactForm">
		<div class="contactDiv">
			이름 : <input type="text" name="contactList[0].name" class="name"><br>
			휴대폰번호 : <input type="text" name="contactList[0].phoneNumber" class="phoneNumber">
		</div>
	</form>
	<button>전송</button>
</div>
<%@ include file="../layout/footer.jsp" %>
<script>
$(function(){
	let numberDiv = 1; 
	
	$('.addForm').on('click',function(){
		if(numberDiv>=6){
			alert('그만해')
			return;
		}
		let contactDiv = $('.contactDiv').eq(0).clone();
		let nameInput = contactDiv.find('.name')
		let phoneInput = contactDiv.find('.phoneNumber')
		let n = nameInput.attr('name').replace('0',numberDiv);
		let p = phoneInput.attr('name').replace('0',numberDiv);
		nameInput.attr('name',n);
		phoneInput.attr('name',p)
		$('.contactForm').append(contactDiv)
		numberDiv++;
	})
	$('.delForm').on('click',function(){
		if(numberDiv<=1){
			alert('그만해');
			return;
		}
		$('.contactDiv').eq(numberDiv-1).remove();
		numberDiv--;
	})
})	
</script>


