document.addEventListener('DOMContentLoaded', function() {
	var calendarEl = document.getElementById('calendar');
	
	var calendar = new FullCalendar.Calendar(calendarEl, {
		locale: 'ko',
		headerToolbar: {
			left: 'prev,next today',
			center: 'title',
			right: 'dayGridMonth,timeGridWeek,timeGridDay'
		},
		initialView: 'timeGridWeek',
		height: '550px',
		expandRows: true,
		/*events:[
			  {
				  title : 'aaa',
				  start : '2022-11-17',
				  end : '2022-11-17',
				  display: 'background',
				  backgroundColor: "#EB5353"
			  },
			  {
				  title : 'bbb',
				  start : '2022-11-18',
				  end : '2022-11-18',
				  display: 'background',
				  backgroundColor: "#EB5353"
			  }
		  ],*/
	
	
		events: function(info, successCallback, failureCallback) {
			//ajax start
			$.ajax({
				type: 'POST'
				 ,cache: false
				, url: '/reservation/selectAjax'
				, dataType: 'json'
				, processData: false
				, contentType: false
				//, cache: false
				//,data: {}, //필요한 데이터
				, success: function(result) {
					var events = [];
					console.log(result);
					
					for(var date of result.reservedList){
	                              
                          events.push({
                             title : date.roomName + " " + date.reserveName,
                             start : date.reserveDate +"T"+  date.startTime  ,
                             end : date.reserveDate +"T"+ date.endTime  ,
                             
                          })
                       }
                       
                       console.log(events);
					/*for (var reserve of resultMap.reserveList) {
						events.push({
							title: 'reserve.roomName',
							start: reserve.reserveDate,
							end: reserve.reserveDate,
							//display: 'background',
							//backgroundColor: "#EB5353"
						})
					}*/
					/*events:[
						{
							title: 'wns0901',
							start: resultMap.reserve_date + resultMap.start.reserve_time,
							end: resultMap.reserve_date+resultMap.end.reserve_time
							//display: 'background',
							//backgroundColor: "#EB5353"
						}
					]*/
					
					/*events.push({
							title : 'aaa',
							start : '',
							end : reserve,
							display: 'background',
							backgroundColor: "#EB5353"
							
							
							
					})*/
					successCallback(events);
	
				},
			});
		}
	});
	calendar.render();
	
	
//	fc-daygrid-day-frame fc-scrollgrid-sync-inner
//	$('.fc-daygrid-day-frame').css("height","10px");
//	$('.fc-daygrid-day-frame').css("word-break","break-all");
});
 
	
	
	
 
 
 
 /*----------------------------------------------------------------------------*/
 
 
 
 //회의실 예약현황 조회하고 ajax
 /*
 $.ajax({
    		url: '/reservation/selectAjax',
    		type: 'post',
    		dataType: 'json',
    		data : {},
    		success: function(result){
    			//alert('aaa');
    			
    			
    			
    			
    			var list = result;
    			console.log(list);
    			
     			var calendarEl = document.getElementById('calendar');
    			
    			
    			var events = list.map(function(item) {
    				//console.log(item);
    				
    				
    				
    				return {
						title : item.roomCode,
						start : item.reserveDate
					}
    			});
						
    			
				var calendar = new FullCalendar.Calendar(calendarEl, {
						
						
						events : events,
						eventTimeFormat: { // like '14:30:00'
					    
					  },
					
					
					
					
					locale : 'ko',
		        	
		        	headerToolbar: {
		                left: 'prev,next today',
		                center: 'title',
		                right: 'dayGridMonth,timeGridWeek,timeGridDay'
		              },
		         	
		          initialView: 'dayGridWeek',
		          
		          height: '550px',
		          
		          expandRows: true ,
							
					
					
				});
				calendar.render();
    		},
    	});
 
*/					
					
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
        	
        	