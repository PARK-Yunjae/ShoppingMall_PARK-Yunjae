package menu_member;

import _mall.MenuCommand;
import controller.MallController;
import util.Util;

public class MemberBoard implements MenuCommand {
	private MallController mallCont;

	@Override
	public void init() {
		mallCont = MallController.getInstance();
	}

	@Override
	public boolean update() {
		mallCont.setNextMenu("MemberBoard");
		mallCont.getbDAO().PageCalculate();
		mallCont.getbDAO().PrintBoard();
		System.out.println("[1]이전");
		System.out.println("[2]이후");
		System.out.println("[3]게시글보기");
		System.out.println("[4]글쓰기");
		System.out.println("[5]수정");
		System.out.println("[6]삭제");
		System.out.println("[0]뒤로가기");
		int sel = Util.getValue("선택", 0, 6);
		if (sel == 1) {
			mallCont.setNextMenu("MemberBoardBeforePage");
		} else if (sel == 2) {
			mallCont.setNextMenu("MemberBoardAfterPage");
		} else if (sel == 3) {
			mallCont.setNextMenu("MemberBoardViewPage");
		} else if (sel == 4) {
			mallCont.setNextMenu("MemberBoardAddPage");
		} else if (sel == 5) {
			mallCont.setNextMenu("MemberBoardUpdatePage");
		} else if (sel == 6) {
			mallCont.setNextMenu("MemberBoardDeletePage");
		} else if (sel == 0) {
			mallCont.setNextMenu("MemberMain");
		} else {
			return true;
		}

		return false;
	}

}
