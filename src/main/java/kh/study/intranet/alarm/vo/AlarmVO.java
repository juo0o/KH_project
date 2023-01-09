package kh.study.intranet.alarm.vo;

import groovy.transform.ToString;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ToString
public class AlarmVO {
	private String alarmStatus;
	private String userId;
	private String appSeq;
	private String toUserId;
}
