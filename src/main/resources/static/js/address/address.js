//주소록 그룹 추가
function goAddress(){
	const bookName = document.querySelector('#groupName').value;
		
		
		if(bookName ==0 , bookName == ''){
				Swal.fire({
      				  icon: 'success',
      				  title: '이름을 입력해주세요.',
      				  text: '',
      				});
			return;
		}
	 
	 $.ajax({
               url: '/address/insertAddress', //요청경로
               type: 'post',
               data: {'bookName':bookName},
			   async: false,
               success: function(result) {
               		 	Swal.fire({
	      				  icon: 'success',
	      				  title: '주소록을 추가했습니다.',
	      				  text: '',
	      				});
               		 
               		 var add = document.querySelector('#addList');
               		
               		 add.innerHTML = '';
               		 
               		 let str = '';
               		 
               		 for(let myAddress of result){
						
						str += `<div class="top">
									<ul>
										<li>
											<div class="row" style="margin-top: 3px;">
												<div class="col-4">
													<a href="/address/myAddress?listPk=${myAddress.listPk}">${myAddress.bookName}</a>
												</div>
												<div class="col-4" align="right">
													<input class="btn btn-outline-info" type="button" value="삭제" onclick="goDelete(this,'${myAddress.listPk}')">
												</div>
											 </div>
										</li>
									 </ul>
								</div>`	
							
					}
               	
						add.insertAdjacentHTML('beforeend',str)

               },
               
               error: function() {
                  		
                  		Swal.fire({
	      				  icon: 'success',
	      				  title: '중복된 그룹명이 존재합니다.',
	      				  text: '',
	      				});
               }
            });
	
}

//삭제 버튼 클릭시
function deleteBtn(bookPk,listPk){
	
	var result =  confirm('삭제하시겠습니까?');
	
	if(result){
		$.ajax({
               url: '/address/deleteAddress', //요청경로
               type: 'post',
               data: {'bookPk':bookPk,'listPk':listPk},
			   async: false,
               success: function(result) {
               		alert('삭제완료');
               		
               		location.href='/address/myAddress?listPk='+listPk;
               		
               },
               error: function() {
                  alert('실패');
               }
            });
	}
}	
//페이지이동시 검색기능 유지하는 함수
function movePage(nowPage){
	
	$("#nowPage").attr("value", nowPage)
	$("#searchButton").click();
	
}	

//개인 주소록 삭제	
function goDelete(selectedTag,listPk){
	
	const inputBtn = selectedTag.closest('.top');
		
	var result = confirm('삭제하시겠습니까?');
	
	if(result){
			$.ajax({
               url: '/address/deleteAddressList', //요청경로
               type: 'post',
               data: {'listPk':listPk},
			   async: false,
               success: function(result) {
               		alert('삭제완료');
               		
               		inputBtn.remove();
               		               		
            
               },
               error: function() {
                  alert('실패');
               }
            });
	
	}
}	
