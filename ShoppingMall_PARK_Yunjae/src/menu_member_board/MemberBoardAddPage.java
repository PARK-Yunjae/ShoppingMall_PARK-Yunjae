package menu_member_board;

import _mall.MenuCommand;
import controller.MallController;
import dto.Board;
import util.Util;

public class MemberBoardAddPage implements MenuCommand {
	private MallController mallCont;

	@Override
	public void init() {
		mallCont = MallController.getInstance();
	}

	@Override
	public boolean update() {
		mallCont.setNextMenu("MemberBoard");
		System.out.println("===[%s 글쓰기]===".formatted(mallCont.getId()));
		String title = Util.strValue("제목");
		String id = mallCont.getId();
		String contents = Util.strValue("내용");
		mallCont.getbDAO().getbList().add(new Board(title, id, contents));
		System.out.println("[%s] 글쓰기 완료".formatted(mallCont.getId()));
		return false;
	}
}
