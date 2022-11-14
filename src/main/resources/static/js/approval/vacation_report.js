//연차수 계싼

var startDate = document.querySelector('#startDate');
var endDate = document.querySelector('#endDate');
var vacationPeriod = document.querySelector('#vacationPeriod');



//      document.querySelector('#itemAmount').
endDate.addEventListener('change', function(event) {
	

	
	const date = getDateDiff(startDate.value, endDate.value);
	
	vacationPeriod.value = date;
	
});

	
	

	const getDateDiff = (d1, d2) => {
		const date1 = new Date(d1);
		const date2 = new Date(d2);

		const diffDate = date2.getTime() - date1.getTime();

		return Math.abs(diffDate / (1000 * 60 * 60 * 24)); // 밀리세컨 * 초 * 분 * 시 = 일
	}