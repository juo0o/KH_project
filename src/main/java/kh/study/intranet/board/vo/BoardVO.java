package kh.study.intranet.board.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardVO extends PageVO {
	private int boardNum;
	private String userId;
	private String boardTitle;
	private String boardContent;
	private String isSecret;
	private String secretPw;
	private int boardReadCnt;
	private String boardRegDate;
	private int replyCount;
	private int likeNum;
	
}
