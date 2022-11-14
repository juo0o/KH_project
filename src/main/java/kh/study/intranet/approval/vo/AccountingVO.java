package kh.study.intranet.approval.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountingVO {
	private String accountingSeq;
	private String paymentRequestDate;
	private String accountingClient;
	private int accountNumber;
	private String account;
	private String businessRegistrationNumber;
	private int amount;
	private String accountingContent;
	private String accountingCategory;
	private String userId;
	private String appSeq;
}
