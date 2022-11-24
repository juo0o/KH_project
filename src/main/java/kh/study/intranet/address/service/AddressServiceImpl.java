package kh.study.intranet.address.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.study.intranet.address.vo.AddressVO;

@Service("addressService")
public class AddressServiceImpl implements AddressService{

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<AddressVO> addressList() {
		
		return sqlSession.selectList("addressMapper.addressList");
	}
	
	
	
}
