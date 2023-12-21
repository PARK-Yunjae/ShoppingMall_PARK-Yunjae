package dto;

public class Member {
	private int memberNum;
	private String id;
	private String pw;
	private String memberName;
	
	public Member() {}
	
	public int getMemberNum() {
		return memberNum;
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getMemberName() {
		return memberName;
	}

	public Member(String id, String pw, String memberName) {
		super();
		this.id = id;
		this.pw = pw;
		this.memberName = memberName;
	}

	private Member(String number, String id, String pw, String memberName) {
		this.memberNum = Integer.parseInt(number);
		this.id = id;
		this.pw = pw;
		this.memberName = memberName;
	}
	
	public Member CreateMember(String[] info) {
		if(info == null || info.length == 0) return null;
		
		return new Member(info[0], info[1], info[2], info[3]);
	}
}
