 function showRoomInfoAjax(dateStr) {

 		var reservation;
      alert('ajax실행함수 실행 : ' + dateStr)
       		
         //alert(dateStr);
            $.ajax({
               url: '/reservation/selectReserve', //요청경로
               type: 'post',
               data: {  'reserveDate' : dateStr },
//               processData: false,
//               contentType: false,
//               cache: false,
				async: false,
               success: function(result) {
               		 //모달창띄운다
               		 
                 reservation = result;
	           	   
	           document.querySelector('select').value;   
	           	   
               
//               memberInfo.innerHTML ='';
              	//let str='';
              	 //str +=   `        `;

//               str +=  `        `
//               str +=  `        `
//               str +=  `        `
//               str +=   `        `
//               str +=   `        `
//               str +=   `        `  
//               str +=  `        `
//               str +=   `        `
//               str +=   `        `
//               str +=   `        `
//               str +=  `        `
//               str +=   `        `
//               str +=   `        `
//               str +=   `        `
//               str +=  `        `
//               str +=   `        `
//               str +=   `        `
//               str +=   `        `    
//               str +=  `        `
//               str +=   `        `
//               str +=   `        `
//               str +=   `        `
//               str +=   `        `
//
//
//                memberInfo.insertAdjacentHTML('afterbegin', str);
               },
               error: function() {
                  alert('ajax 실패');
         
               }
               
               
            });
            
      $('#createEventModal').modal('show');
      console.log(reservation);
      return reservation;
      
      
//          $('#createEventModal').modal('hide');
          
         
      }
      
function goReserve(formTag){
	
	//alert('aaa');
		var formTag = $("form[name=regReserve]").serialize();
		
		
	alert(formTag)
	
	$.ajax({
               url: '/reservation/regReservation', //요청경로
               type: 'post',
               data: formTag, //필요한 데이터
               
               success: function(result) {
           			alert('등록완료')
            
           		
           		
            
               			
               			
               			
               
               },
               error: function() {
                  alert('ajax 실패');
         
               }
               
               
            });
	
               $('#createEventModal').modal('hide');
			
	
	
}

      
      
      
      