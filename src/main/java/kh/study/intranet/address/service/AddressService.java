package kh.study.intranet.address.service;

import java.util.List;

import kh.study.intranet.address.vo.AddressListVO;
import kh.study.intranet.address.vo.AddressVO;
import kh.study.intranet.emp.vo.EmpVO;

public interface AddressService {
	//공용 주소록 조회
	List<EmpVO> addressList();
	
	//개인 주소록 추가 
	void insertAddress(AddressListVO addressListVO);
	
	//개인주소록 목록 조회
	List<AddressListVO> insertAddressList(String bookOwnerId);
	
	//등록한 개인주소록 조회
	List<AddressVO> selectListPk(String listPk);
	
	//연락처 등록
	void regMyAddress(AddressVO addressVO);
	
	//주소록 안에서 등록한 연락처 조회
	AddressVO selectBookPk(String bookPk);
	
	//등록된 주소록내용 수정
	void updateAddress(AddressVO addressVO);
	
	//등록된 주소록내용 삭제
	void deleteAddress(AddressVO addressVO);
	
	//개인 주소록 자체를 삭제
	void deleteAddressList(String listPk);
	
	
	
}
