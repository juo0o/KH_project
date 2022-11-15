
let selectBox = document.querySelector('#selectAppCate');

selectBox.addEventListener('change',function(){
	
	alert(selectBox.value);
	if(selectBox.value == "전체"){
		location.href="/approval/approvalBoard";
		return;
	}
	
	//ajax start
	$.ajax({
		url: '/approval/selectAppCate', //요청경로
		type: 'post',
		data: { 'appCate': document.querySelector("#selectAppCate").value}, //필요한 데이터
		success: function(result) {
			const appList = document.querySelector('#appList');
			appList.replaceChildren();
			
			let str = '';
			for(const appCateBoard of result){
				str += `<tr>`;
				if(appCateBoard.appCate == "연차신청서") {
				str += `<td>${appCateBoard.vacationVO.vacationSeq}</td>`;
				} else if(appCateBoard.appCate == "일반품의서") {
				str += `<td>${appCateBoard.nomalVO.nomalSeq}</td>`;
				} else if(appCateBoard.appCate == "회계품의서") {
				str += `<td>${appCateBoard.accountingVO.accountingSeq}</td>`;
				}
				str +=`<td>${appCateBoard.empVO.empName}</td>`;
				str +=`<td>${appCateBoard.title}</td>`;
				str +=`<td>${appCateBoard.empVO.deptName}</td>`;
				str +=`<td>${appCateBoard.appWriteDate}</td>`;
				str += `</tr>`;
			}
		
			console.log(str);
			appList.insertAdjacentHTML('afterbegin', str);
		
		},
		error: function() {
			alert('실패');
		}
	});
	//ajax end
});
