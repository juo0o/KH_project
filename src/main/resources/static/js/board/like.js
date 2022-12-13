//상세게시글 좋아요 클릭시
function likeUp() {
	var frm_read = $('#frm_read');
	var boardNum = $('#boardNum', frm_read).val();
	console.log("boardNum, userId : " + boardNum + "," + userId);
	//ajax start
	$.ajax({
		url: '/board/updateBoardLike',
		type: 'post',
		data: 'boardNum=' + boardNum,
		success: function(data) {
			var msg = '';
			var like_img = '';
			msg += data.msg;
			alert(msg);

			if (data.like_check == 0) {
				like_img = "./images/dislike.png";
			} else {
				like_img = "./images/like.png";
			}
			$('#like_img', frm_read).attr('src', like_img);
			$('#like_cnt').html(data.like_cnt);
			$('#like_check').html(data.like_check);
		},
		error: function(request, status, error) {
			alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
		}
	});
	//ajax end
}




//댓글 목록에서 글수정 버튼 클릭 시 실행...
function updateReply(updateBtn){
	if(updateBtn.innerText == '댓글수정'){
		const contentSpan = updateBtn.closest('.replyDiv').querySelector('.replyContent_span');
		const origin_content = contentSpan.innerText;
		contentSpan.innerText = '';
		
		str = '';
		str += `<textarea name="replyContent" class="form-control" rows="3" style="resize: none;">${origin_content}</textarea>`;
		contentSpan.insertAdjacentHTML('afterBegin', str);
		updateBtn.innerText = '수정완료';
	}
	else{
		updateBtn.closest('form').submit();
		
		
	}
}

//게시글삭제
function deleteBoard(boardNum){
	 Swal.fire({
          title: '삭제하시겠습니까?',
          icon: 'warning',
          showCancelButton: true,
          confirmButtonColor: '#3085d6',
          cancelButtonColor: '#d33',
          confirmButtonText: '삭제',
          cancelButtonText: '취소'
        }).then((result) => {
          if (result.isConfirmed) {
				location.href='/board/deleteBoard?boardNum=' + boardNum;
          };
        })
}










