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
						str += `<div><a>${myAddress.bookName}</a></div>`	
					}
               	
					add.insertAdjacentHTML('beforeend',str)

               },
               error: function() {
                  
                  alert('주소록 이름이 중복됩니다');
         
                  
               }
            });
	
	
	
	
}

