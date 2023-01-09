function requestApproval(appSeq, appCateCode) {
	
	
	
	
		
		location.href='/approval/appDocuments?appSeq=' + appSeq + '&appCateCode=' + appCateCode;
		
	
	
	
	
}

function approvalMark(firstApprovalEmp,appSeq,finalApprovalEmp) {
	
	
	//ajax start
	$.ajax({
		url: '/approval/approvalMark', //요청경로
		type: 'post',
		data: {'firstApprovalEmp':firstApprovalEmp,'appSeq':appSeq,'finalApprovalEmp':finalApprovalEmp}, //필요한 데이터
		success: function(result) {
			alert('결재승인 하시겠습니까?');
			const mark = document.querySelector('#approvalButton');
			mark.innerHTML ='';
			let str = '';
			
			str += ' <img src="/imgs/approval/thumb_d_B7B18BFBE0353B3F8C77E8006E453562.jpg" style="width: 85px;"> ';
			
			mark.insertAdjacentHTML('beforeend',str);
		},
		error: function() {
			alert('실패');
		}
	});
//ajax end
	
}

function approvalFinalMark(finalApprovalEmp,appSeq) {
	
	
	//ajax start
	$.ajax({
		url: '/approval/updateFinalApproval', //요청경로
		type: 'post',
		data: {'finalApprovalEmp':finalApprovalEmp,'appSeq':appSeq}, //필요한 데이터
		success: function(result) {
			alert('결재승인 하시겠습니까?');
			const mark = document.querySelector('#approvalButton2');
			mark.innerHTML ='';
			let str = '';
			
			str += ' <img src="/imgs/approval/thumb_d_B7B18BFBE0353B3F8C77E8006E453562.jpg" style="width: 80px;"> ';
			
			mark.insertAdjacentHTML('beforeend',str);
		},
		error: function() {
			alert('실패');
		}
	});
//ajax end
	
}








