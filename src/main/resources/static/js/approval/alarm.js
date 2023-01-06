function alarm() {
	
	
	//ajax start
	$.ajax({
		url: '/approval/alarm', //요청경로
		type: 'post',
		data: {}, //필요한 데이터
		success: function(result) {
			
		
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
setInterval(alarm, 10000);