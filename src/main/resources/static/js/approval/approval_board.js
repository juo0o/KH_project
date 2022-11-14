//appCate 섹렉트박스 클릭시
function selectCate() {
	let selectAppCate = document.querySelector('#selectAppCate');
	
	//ajax start
	$.ajax({
		url: '/cart/cartList', //요청경로
		type: 'post',
		data: { 'itemCode': document.querySelector("#itemCode").value
		, 'cartAmount': document.querySelector("#cartAmount").value }, //필요한 데이터
		success: function(result) {
			
			const modal = new bootstrap.Modal('#regCartItem');
			modal.show();
			
		//	if(result) {
		//		location.href='/cart/cartListPage';
		//		}
		},
		error: function() {
			alert('실패');
		}
	});
	//ajax end
}
