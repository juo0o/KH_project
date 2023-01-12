let isExistAlarm = false;


function alarm() {
	
	if(isExistAlarm) {
		return;
	}
	
	//ajax start
	$.ajax({
		url: '/approval/alarm', //요청경로
		type: 'post',
		data: {}, //필요한 데이터
		success: function(result) {
			
			if(result == null)
				return;
			if(result == 'N')
				return;
				
				
			isExistAlarm = true;
			
		
//			const alarmModal = new bootstrap.Modal('#alarm');
//			alarmModal.show();
			
			//document.querySelector("#alarmDiv").dis;
			$("#alarmDiv").css('visibility','visible');
			
//			$('#alarm').modal('show');
		},
		error: function() {
			alert('실패');
		}
	});
	//ajax end
}
setInterval(alarm, 5000);



function updateAlarm() {
	
	const empNum = document.querySelector("#EmpNum").value;
	
	location.href='/approval/updateAlarm?empNum='+empNum;
}




