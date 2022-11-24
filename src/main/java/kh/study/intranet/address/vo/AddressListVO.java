package kh.study.intranet.address.vo;

import groovy.transform.ToString;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ToString
public class AddressListVO {
	private String listPk;
	private String bookOwnerId; //주소록 주인 ID
	private String bookName;
	
}
