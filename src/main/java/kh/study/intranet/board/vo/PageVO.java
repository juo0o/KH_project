package kh.study.intranet.board.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageVO extends SearchVO {

	private int nowPage; //현재 선택된 페이지
	private int totalDataCnt; //전체 데이터 수
	private int beginPage; //화면에 보이는 첫 페이지
	private int endPage; //화면에 보이는 마지막 페이지
	private int displayCnt; //한 페이지에 보여지는 게시글 수
	private int displayPageCnt; //한 화면에 보여지는 페이지 수
	private boolean prev; //이전 버튼의 유무
	private boolean next; //다음 버튼 유무
	private int startNum; //시작 row_num
	private int endNum;//마지막 row_num 
	
	
	//생성자
	public PageVO()	{
		nowPage = 1;
		displayCnt = 10; //한 페이지에 보여지는 게시글 수
		displayPageCnt = 10; //한 화면에 보여지는 페이지 수
	}
	
	public void setPageInfo() {
		
		//화면에 보이는 마지막 페이지 번호
		endPage = displayPageCnt * (int)Math.ceil(nowPage/(double)displayPageCnt);
		beginPage = endPage - displayPageCnt + 1;
		
		//전체 페이지 수
		int totalPageCnt = (int)Math.ceil(totalDataCnt/(double)displayCnt);
		
		//next 버튼의 유무
		if(endPage < totalPageCnt) {
			next = true;
		}
		else {
			next = false;
			endPage = totalPageCnt;
		}
	
		//prev 유무
		prev = beginPage == 1 ? false : true;
		
		startNum = (nowPage -1) * displayCnt + 1; // 예) 1페이지일 경우 (1-1)*10 +1; --> 1페이지 시작행은 1번째 게시물
												   // 예2) 2페이지일 경우 (2-1)*10 +1; --> 2페이지 시작행은 11번째 게시물
	
		endNum = nowPage * displayCnt; // endNum = 현재2페이지 * 한페이지당게시물수(10개) ---> 20번째게시물이 endNum
	}
	
}


