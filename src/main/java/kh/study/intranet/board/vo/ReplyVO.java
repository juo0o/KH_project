package kh.study.intranet.board.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReplyVO  {
	private int replyNum;
	private String replyContent;
	private int boardNum;
	private String userId;
	private String replyRegDate;
	private String empName;
	private String empPosition;

}
