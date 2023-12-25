package menu_admin_member;

import _mall.MenuCommand;
import controller.MallController;
import util.Util;

public class AdminMemberDelete implements MenuCommand {
	private MallController mallCont;

	@Override
	public void init() {
		mallCont = MallController.getInstance();
	}

	@Override
	public boolean update() {
		mallCont.setNextMenu("AdminMember");
		if(mallCont.getmDAO().getmList().size() == 0) {
			System.out.println("[관리자] 회원이 존재하지 않습니다");
			return false;
		}
		String id = Util.getValue("ID");
		int idIdx = mallCont.getmDAO().idValue(id);
		if (idIdx == -1) {
			System.out.println("[관리자] ID가 존재하지 않습니다");
			return false;
		}
		if(idIdx == 0) {
			System.out.println("[관리자] 관리자는 삭제 불가");
			return false;
		}
		// 맴버리스트에서 id 삭제
		mallCont.getmDAO().DeleteMember(idIdx);	
		// 카트에서도 id와 일치하는 값 삭제
		mallCont.getcDAO().DeleteMember(id);	
		// 게시판 글도 삭제
		mallCont.getbDAO().DeleteMember(id);	
		System.out.println("[관리자] %s 회원 삭제 완료".formatted(id));
		return false;
	}
}
