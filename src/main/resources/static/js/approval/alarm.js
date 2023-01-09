let isExistAlarm = false;

let alarmAppSeq;


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
				
			if(result.length == 0)
				return;
				
			isExistAlarm = true;
			alarmAppSeq = result[0].appSeq;
		
//			const alarmModal = new bootstrap.Modal('#alarm');
//			alarmModal.show();
			
			$('#alarm').modal('show');
		},
		error: function() {
			alert('실패');
		}
	});
	//ajax end
}
setInterval(alarm, 5000);



function updateAlarm() {
	location.href='/approval/updateAlarm?appSeq='+alarmAppSeq;
}