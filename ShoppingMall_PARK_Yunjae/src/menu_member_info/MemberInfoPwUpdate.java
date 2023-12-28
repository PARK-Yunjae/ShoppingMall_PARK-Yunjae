package menu_member_info;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import _mall.MenuCommand;
import controller.MallController;
import dao.MemberDAO;
import util.Util;

public class MemberInfoPwUpdate  implements MenuCommand{
	private MallController cont = MallController.getInstance();
	private String pwPattern = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{4,20}$";

	@Override
	public boolean update() {
		MemberDAO mDAO = MemberDAO.getInstance();
		
		cont.setNext("MemberMain");
		String pw = Util.getValue("PW : ");
		int idIdx = mDAO.idValue(cont.getId());
		int pwIdx = mDAO.pwValue(pw);
		if(pwIdx != idIdx) {
			System.out.println("[%s] 비밀번호가 틀렸습니다".formatted(cont.getId()));
			return false;
		}
		String newPw = Util.getValue("새PW : "); 
		Pattern p = Pattern.compile(pwPattern);
		Matcher m = p.matcher(newPw);
		if(!m.matches()) {
			System.out.println("비밀번호는 4자 이상 20자 미만, 숫자 영단어가 포함되어야 합니다");
			return false;
		}
		if(pw.equals(newPw)) {
			System.out.println("[%s] 같은 비밀번호는 변경이 안됩니다".formatted(cont.getId()));
			return false;
		}
		mDAO.getmList().get(idIdx).setPw(newPw);;
		System.out.println("[%s] 비밀번호 변경 완료".formatted(cont.getId()));
		return false;
	}
}
