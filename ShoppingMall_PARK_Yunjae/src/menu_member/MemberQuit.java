package menu_member;

import _mall.MenuCommand;
import controller.MallController;

public class MemberQuit implements MenuCommand{

	private MallController mallCont;

	@Override
	public void init() {
		mallCont = MallController.getInstance();
	}

	@Override
	public boolean update() {
		mallCont.setNextMenu("MallMain");
		int idIdx = mallCont.getmDAO().idValue(mallCont.getId());
		// 맴버리스트에서 id 삭제
		mallCont.getmDAO().DeleteMember(idIdx);	
		// 카트에서도 id와 일치하는 값 삭제
		mallCont.getcDAO().DeleteMember(mallCont.getId());	
		// 게시판 글도 삭제
		mallCont.getbDAO().DeleteMember(mallCont.getId());	
		System.out.println("[%s] 회원 탈퇴 완료".formatted(mallCont.getId()));
		mallCont.setId("");
		return false;
	}
}
