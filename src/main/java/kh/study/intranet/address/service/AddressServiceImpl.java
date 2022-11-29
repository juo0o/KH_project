package kh.study.intranet.address.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.study.intranet.address.vo.AddressListVO;
import kh.study.intranet.address.vo.AddressVO;
import kh.study.intranet.emp.vo.EmpVO;

@Service("addressService")
public class AddressServiceImpl implements AddressService{

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<EmpVO> addressList() {
		
		return sqlSession.selectList("addressMapper.addressList");
	}

	@Override
	public void insertAddress(AddressListVO addressListVO) {
		sqlSession.insert("addressMapper.insertAddress",addressListVO);
		
	}

	@Override
	public List<AddressListVO> insertAddressList(String bookOwnerId) {
		
		return sqlSession.selectList("addressMapper.insertAddressList",bookOwnerId);
	}

	

	@Override
	public void regMyAddress(AddressVO addressVO) {
		sqlSession.insert("addressMapper.regMyAddress",addressVO);
		
	}

	@Override
	public List<AddressVO> selectListPk(String listPk) {
		
		System.out.println("!!!!!!!"+listPk);
		System.out.println("!!!!!!!"+listPk);
		System.out.println("!!!!!!!"+listPk);
		System.out.println("!!!!!!!"+listPk);
		return sqlSession.selectList("addressMapper.selectListPk",listPk);
	}
	
	
	
}
