package kh.study.intranet.address.service;

import java.util.List;

import kh.study.intranet.address.vo.AddressListVO;
import kh.study.intranet.address.vo.AddressVO;
import kh.study.intranet.emp.vo.EmpVO;

public interface AddressService {
	//공용 주소록 조회
	List<EmpVO> addressList();
	
	void insertAddress(AddressListVO addressListVO);
	
	List<AddressListVO> insertAddressList(String bookOwnerId);
	
	List<AddressVO> selectListPk(String listPk);
	
	void regMyAddress(AddressVO addressVO);
	
	AddressVO selectBookPk(String bookPk);
	
	void updateAddress(AddressVO addressVO);
	
	void deleteAddress(AddressVO addressVO);
	
	//다음에 들어갈 List_pk 조회
	String selectNextListPk();
	
	
	
}
