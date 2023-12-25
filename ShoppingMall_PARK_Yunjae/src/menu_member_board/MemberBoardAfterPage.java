package menu_member_board;

import _mall.MenuCommand;
import controller.MallController;

public class MemberBoardAfterPage implements MenuCommand {
	private MallController mallCont;

	@Override
	public void init() {
		mallCont = MallController.getInstance();
	}

	@Override
	public boolean update() {
		mallCont.setNextMenu("MemberBoard");
		int curPageNum = mallCont.getbDAO().getCurPageNum();
		if (curPageNum == mallCont.getbDAO().getPageCount()) {
			System.out.println("이후페이지 없음");
			return false;
		}
		mallCont.getbDAO().setCurPageNum(curPageNum+1);
		return false;
	}
}

