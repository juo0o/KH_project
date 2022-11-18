package kh.study.intranet.board.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardLikeVO  {
	private int likeNum;
	private int boardNum;
	private String userId;
}
