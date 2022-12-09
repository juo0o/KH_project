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
		
	
		events: function(info, successCallback, failureCallback) {
			//ajax start
			$.ajax({
				type: 'POST'
				 ,cache: false
				, url: '/reservation/selectAjax'
				, dataType: 'json'
				, processData: false
				, contentType: false			
				, success: function(result) {
					var events = [];
					
					
					for(var date of result.reservedList){
	                              
                          events.push({
                             title : date.roomName + " " + date.reserveName,
                             start : date.reserveDate +"T"+  date.startTime  ,
                             end : date.reserveDate +"T"+ date.endTime  ,
                             
                          })
                       }
                                             				
					successCallback(events);
	
				},
			});
		}
	});
	calendar.render();
		

});
 	
        	
        	