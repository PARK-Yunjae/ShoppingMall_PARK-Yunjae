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

	// 회원 삭제 - 카트 목록도 삭제
	public void DeleteMember(int idx) {
		mList.remove(idx);
	}
	
	// 텍스트 파일 저장용 데이터 만들기
	public String DataToFile() {
		String data = "";
		if(mList.size() == 0) return data;
		for(Member m : mList) {
			data += m.DataToFile() + "\n";
		}
		data = data.substring(0, data.length()-1);
		return data;
	}
	
	// 텍스트파일에서 문자열 받아와서 데이터 넣기
	public void FileToData(String data) {
		String datas[] = data.split("\n");
		mList.clear();
		for(int i=0 ; i<datas.length ; i+=1) {
			String[] info = datas[i].split("/");
			mList.add(Member.CreateMember(info));
		}
	}
}
