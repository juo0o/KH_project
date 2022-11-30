//==============회원정보 변경하고 화면 다시뿌려줌==================
function regNewUser() {
	let form = $('#regNewEmp')[0];
	
		$.ajax({
			url: '/admin/regNewEmp', //요청경로
			type: 'post',
			data: new FormData(form), //필요한 데이터
			
			processData: false,
			contentType: false,
			cache: false,
			success: function(result) {
			// 회원정보 만들어줌
//			let userInfoPage = document.querySelector('#userInfo');
//			userInfoPage.innerHTML ='';
//			let str='';
//                                                                                                                                 
//			userInfoPage.insertAdjacentHTML('afterbegin', str);       
			                                                                                        
			},                                                                                                                                                  
			error: function() {         
				Swal.fire({
				  icon: 'error',
				  title: '변경실패',
				  text: '',
				});                                                                                                                         
				return;
			}
		});
		
		Swal.fire({
			  icon: 'success',
			  title: '사원등록성공',
			  text: '',
			}).then((result) => {
//		       location.href="/user/updateUserForm";
				$('#regEmpModal').modal('hide');
		        }); 
}
			
function regDept() {
	let form = $('#regDept')[0];
	
		$.ajax({
			url: '/admin/regDept', //요청경로
			type: 'post',
			data: new FormData(form), //필요한 데이터
			
			processData: false,
			contentType: false,
			cache: false,
			success: function(result) {
			// 회원정보 만들어줌
//			let userInfoPage = document.querySelector('#userInfo');
//			userInfoPage.innerHTML ='';
//			let str='';
//			userInfoPage.insertAdjacentHTML('afterbegin', str);       
			                                                                                        
			},                                                                                                                                                  
			error: function() {         
				Swal.fire({
				  icon: 'error',
				  title: '변경실패',
				  text: '',
				});                                                                                                                         
				return;
			}
		});
		
		Swal.fire({
			  icon: 'success',
			  title: '부서등록성공',
			  text: '',
			}).then((result) => {
//		       location.href="/user/updateUserForm";
				$('#regDeptModal').modal('hide');
		        }); 
}


//페이지이동시 검색기능 유지하는 함수
function movePage(nowPage){
	
	$("#nowPage").attr("value", nowPage)
	$("#searchButton").click();
	
}