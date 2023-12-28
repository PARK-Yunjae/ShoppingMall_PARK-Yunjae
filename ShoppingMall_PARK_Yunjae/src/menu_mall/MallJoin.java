package menu_mall;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import _mall.MenuCommand;
import controller.MallController;
import dao.MemberDAO;
import dto.Member;
import util.Util;

public class MallJoin implements MenuCommand{

	private MallController cont = MallController.getInstance();;
	private String pwPattern = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{4,20}$";

	@Override
	public boolean update() {
		MemberDAO mDAO = MemberDAO.getInstance();
		
		cont.setNext("MallMain");
		System.out.println("===[회원가입]===");
		String id = Util.getValue("ID : ");
		int idIdx = mDAO.idValue(id);
		if(idIdx != -1) {
			System.out.println("중복 ID가 존재합니다");
			return false;
		}
		String pw = Util.getValue("PW : ");
		Pattern p = Pattern.compile(pwPattern);
		Matcher m = p.matcher(pw);
		if(!m.matches()) {
			System.out.println("비밀번호는 4자 이상 20자 미만, 숫자 영단어가 포함되어야 합니다");
			return false;
		}
		String name = Util.getValue("이름 : ");
		mDAO.getmList().add(new Member(id, pw, name));
		System.out.println("가입 완료");
		return false; 
	}

}
