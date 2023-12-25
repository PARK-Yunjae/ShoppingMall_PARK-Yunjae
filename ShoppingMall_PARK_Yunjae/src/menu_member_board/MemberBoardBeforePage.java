package menu_member_board;

import _mall.MenuCommand;
import controller.MallController;

public class MemberBoardBeforePage implements MenuCommand {
	private MallController mallCont;

	@Override
	public void init() {
		mallCont = MallController.getInstance();
	}

	@Override
	public boolean update() {
		mallCont.setNextMenu("MemberBoard");
		int curPageNum = mallCont.getbDAO().getCurPageNum();
		if (curPageNum == 1) {
			System.out.println("이전페이지 없음");
			return false;
		}
		mallCont.getbDAO().setCurPageNum(curPageNum-1);
		return false;
	}
}

