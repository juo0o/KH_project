package kh.study.intranet.board.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReplyVO  {
	private String replyNum;
	private String replyContent;
	private String boardNum;
	private String userId;
	private String replyRegDate;

}
