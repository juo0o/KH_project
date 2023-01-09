package kh.study.intranet.alarm.service;

import java.util.List;

import kh.study.intranet.alarm.vo.AlarmVO;

public interface AlarmService {

	void insertAlarm(AlarmVO alarmVO);
	
	List<AlarmVO> selectAlarm(AlarmVO alarmVO);
	
	void updateAlarm(AlarmVO alarmVO);
}
