package kh.study.intranet.board.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardVO  {
	private String boardNum;
	private String boardWriter;
	private String boardTitle;
	private String boardContent;
	private String isSecret;
	private String secretPw;
	private int boardReadCnt;
	private String replyNum;
	private String boardRegDate;
	
}
