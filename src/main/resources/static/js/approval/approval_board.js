
let selectBox = document.querySelector('#selectAppCate');

selectBox.addEventListener('change',function(){
	
	//if(selectBox.value == "전체"){
		//location.href="/approval/approvalBoard";
		//return;
	//}
	
	//ajax start
	$.ajax({
		url: '/approval/selectAppCate', //요청경로
		type: 'post',
		data: { 'appCateCode': document.querySelector("#selectAppCate").value}, //필요한 데이터
		success: function(result) {
			const appList = document.querySelector('#appList');
			appList.replaceChildren();
			
			
			let str = '';
			
			
			for(const appCateBoard of result){
				str += `<tr>`;
				if(appCateBoard.appCateCode == "VACATION") {
				str += `<td>${appCateBoard.vacationVO.vacationSeq}</td>`;
				} else if(appCateBoard.appCateCode == "NOMAL") {
				str += `<td>${appCateBoard.nomalVO.nomalSeq}</td>`;
				} else if(appCateBoard.appCateCode == "ACCOUNTING") {
				str += `<td>${appCateBoard.accountingVO.accountingSeq}</td>`;
				} else if(appCateBoard.appCateCode == "") {
				str += `<td>${appCateBoard.appSeq}</td>`;
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

//페이지이동시 검색기능 유지하는 함수
function movePage(nowPage){
	
	$("#nowPage").attr("value", nowPage)
	$("#searchButton").click();
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	





