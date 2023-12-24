package menu_mall;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import _mall.MenuCommand;
import controller.MallController;
import util.Util;

public class MallJoin implements MenuCommand{

	private MallController mallCont;
	private String pwPattern = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{4,20}$";

	public MallJoin() {
		init();
	}
	
	@Override
	public void init() {
		mallCont = MallController.getInstance();
	}

	@Override
	public boolean update() {
		mallCont.setNextMenu("MallMain");
		String id = Util.getValue("ID");
		int idIdx = mallCont.getmDAO().idValue(id);
		if(idIdx != -1) {
			System.out.println("중복 ID가 존재합니다");
			return false;
		}
		String pw = Util.getValue("PW");
		Pattern p = Pattern.compile(pwPattern);
		Matcher m = p.matcher(pw);
		if(!m.matches()) {
			System.out.println("비밀번호는 4자 이상 20자 미만, 숫자 영단어가 포함되어야 합니다");
			return false;
		}
		String name = Util.getValue("닉네임");
		mallCont.getmDAO().CreateMember(id, pw, name);
		System.out.println("가입 완료");
		return false; 
	}

}
