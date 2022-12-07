//주소록 그룹 추가
function goAddress(){
	const bookName = document.querySelector('#groupName').value;
		
		
		if(bookName ==0 , bookName == ''){
			alert('이름을 입력해주세요');
			return;
		}
	
	 $.ajax({
               url: '/address/insertAddress', //요청경로
               type: 'post',
               data: {'bookName':bookName},
//               processData: false,
//               contentType: false,
//               cache: false,
				async: false,
               success: function(result) {
               		 alert('주소록을 추가했습니다.');
               		 //console.log(result);
               		 var add = document.querySelector('#addList');
               		 
               		 
               		 
               		 add.innerHTML = '';
               		 
               		 let str = '';
               		 
               		 for(let myAddress of result){
						str += `<div><ul><li><a href="/address/myAddress?listPk=${myAddress.listPk}">${myAddress.bookName}</a></li></ul></div>`	
							
							
						
					}
               	
					add.insertAdjacentHTML('beforeend',str)

               },
               error: function() {
                  
                  alert('주소록 이름이 중복됩니다');
         
                  
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
//               processData: false,
//               contentType: false,
//               cache: false,
				async: false,
               success: function(result) {
               		alert('삭제완료');
               		
               		
               		
               		location.href = '/address/myAddress?listPk=' + listPk;
               		 
               		
               		 
               		 
               	
               },
               error: function() {
                  
                  alert('실패');
         
                  
               }
            });
	
		
		
	}
	
	//console.log(bookPk);
	//console.log(listPk);
	
	
	
	
	
}	
//페이지이동시 검색기능 유지하는 함수
function movePage(nowPage){
	
	$("#nowPage").attr("value", nowPage)
	$("#searchButton").click();
	
}	
	
	
	
	
	

	

	
	
	
            
	
	
	
	
	
	
	



