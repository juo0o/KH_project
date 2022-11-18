function requestApproval(appSeq, appCateCode) {
	
	
	
	if(appCateCode == 'VACATION') {
		
		location.href='/approval/requestVacation';
		
	} else if(appCateCode == 'NOMAL') {
		
		location.href='/approval/requestNomal';
	} else if(appCateCode == 'ACCOUNTING') {
		
		location.href='/approval/requestAccounting';
	}
	
	
	
}






