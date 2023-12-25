package menu_member_info;

import _mall.MenuCommand;
import controller.MallController;

public class MemberInfoList implements MenuCommand{
	private MallController mallCont;
	
	@Override
	public void init() {
		mallCont = MallController.getInstance();
	}

	@Override
	public boolean update() {
		mallCont.setNextMenu("MemberInfo");
		int idx = mallCont.getmDAO().idValue(mallCont.getId());
		System.out.println(mallCont.getmDAO().getmList().get(idx));
		mallCont.getcDAO().MyCartNum(mallCont.getId());	// 내 장바구니 개수
		mallCont.getbDAO().MyBoardNum(mallCont.getId()); // 내 게시글 수
		return false;
	}

}
