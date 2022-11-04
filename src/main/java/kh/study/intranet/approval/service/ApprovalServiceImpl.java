package kh.study.intranet.approval.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("approvalService")
public class ApprovalServiceImpl implements ApprovalService{

	@Autowired
	private SqlSessionTemplate sqlSession;
}
