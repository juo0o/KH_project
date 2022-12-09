package kh.study.intranet.address.vo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddressListVO {
	private String listPk;
	private String bookOwnerId; //주소록 주인 ID
	private String bookName;
}
