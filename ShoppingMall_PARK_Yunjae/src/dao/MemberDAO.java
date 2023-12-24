package dao;

import java.util.ArrayList;

import dto.Member;

public class MemberDAO {
	private ArrayList<Member> mList;
	private int memberNum = 1000;

	public ArrayList<Member> getmList() {
		return mList;
	}

	public MemberDAO() { // 처음 DAO 를 만들때 관리자 생성
		mList = new ArrayList<Member>();
		String[] info = { "" + (memberNum++), "admin", "admin", "관리자" };
		mList.add(Member.CreateMember(info));
	}

	// id 중복 확인
	public int idValue(String id) {
		for (int i = 0; i < mList.size(); i += 1) {
			if (mList.get(i).getId().equals(id)) {
				return i;
			}
		}

		return -1;
	}

	// pw 중복 확인
	public int pwValue(String pw) {
		for (int i = 0; i < mList.size(); i += 1) {
			if (mList.get(i).getPw().equals(pw)) {
				return i;
			}
		}

		return -1;
	}

	// 회원 가입
	public void CreateMember(String id, String pw, String name) {
		String[] info = { "" + (memberNum++), id, pw, name };
		mList.add(Member.CreateMember(info));
	}

	// 닉네임 변경
	public void UpdateNickName(String name, int idx) {
		mList.get(idx).setMemberName(name);
	}

	// 회원 출력
	public void MemberList() {
		if (mList.size() == 0) {
			System.out.println("회원이 없습니다");
			return;
		}
		System.out.println("[회원 목록]");
		for (int i = 0; i < mList.size(); i += 1) {
			System.out.println(mList.get(i));
		}
	}
	// 회원 삭제
	public void DeleteMember(int idx) {
		mList.remove(idx);
	}
}
