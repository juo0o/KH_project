//댓글등록 클릭 시 실행
function regReply(replyVO) {
	const result = confirm('댓글을 등록하실건가요?');
	
	if(result){
	//ajax start
	$.ajax({
		url: '/reply/regReply', //요청경로
		type: 'post',
		data: {  'userId':userId
				 ,'replyContent':replyContent
				 , 'replyRegDate': replyRegDate}, //필요한 데이터
		success: function(result) {
			let str = '';
			str += '		<table class="table"       ';
			str += '			<tr>       ';
			str += `		    	<td scope="row" th:text="${result.userId}">`;
			str += '	        </tr>    		         ';
			str += '	        <tr>                ';
			str += `				<td scope="row" th:text="${result.replyContent}">`;
			str += '			</tr>';
			str += '			<tr>';
			str += `            	<td scope="row" th:text="${result.replyRegDate}">`;
			str += '            </tr>            ';
			str += '	  	</table>';

			const replyDiv = document.querySelector('#replyDiv');
			replyDiv.innerHTML = '';
			replyDiv.insertAdjacentHTML('beforeend', str);
		},
		error: function() {
			alert('실패');
		}
	});
	//ajax end
	
	}
}




