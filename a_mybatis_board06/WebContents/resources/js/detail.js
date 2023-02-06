console.log('detail.js');


$(function(){

	let typeValue = getSearchParam('type');
	let keywordValue = getSearchParam('keyword');
	
	$('.list').on('click',function(){
		let detailForm = $('<form>');
		detailForm.empty();
		detailForm.attr('method','get')
			.attr('action',`${contextPath}/board/list`)
			.append(getInputHiddenTag("page",getSearchParam('page')))
		
		if(typeValue !=null && keywordValue != null){
			detailForm.append(getInputHiddenTag('type',typeValue))
				.append(getInputHiddenTag('keyword',keywordValue))
		}
		
		detailForm.appendTo('body')
			.submit();
	});
});