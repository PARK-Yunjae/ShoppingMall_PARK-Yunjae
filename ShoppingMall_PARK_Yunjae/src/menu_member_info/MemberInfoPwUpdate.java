package menu_member_info;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import _mall.MenuCommand;
import controller.MallController;
import util.Util;

public class MemberInfoPwUpdate  implements MenuCommand{
	private MallController mallCont;
	private String pwPattern = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{4,20}$";

	@Override
	public void init() {
		mallCont = MallController.getInstance();
	}

	@Override
	public boolean update() {
		mallCont.setNextMenu("MemberInfo");
		String newPw = Util.getValue("새비밀번호");
		Pattern p = Pattern.compile(pwPattern);
		Matcher m = p.matcher(newPw);
		if(!m.matches()) {
			System.out.println("비밀번호는 4자 이상 20자 미만, 숫자 영단어가 포함되어야 합니다");
			return false;
		}
		int idx = mallCont.getmDAO().idValue(mallCont.getId());
		mallCont.getmDAO().getmList().get(idx).setPw(newPw);;
		System.out.println("[%s] 비밀번호 변경 완료".formatted(mallCont.getId()));
		return false;
	}
}
