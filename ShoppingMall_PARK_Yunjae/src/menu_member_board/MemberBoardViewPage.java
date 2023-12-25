package menu_member_board;

import _mall.MenuCommand;
import controller.MallController;
import util.Util;

public class MemberBoardViewPage implements MenuCommand {
	private MallController mallCont;

	@Override
	public void init() {
		mallCont = MallController.getInstance();
	}

	@Override
	public boolean update() {
		mallCont.setNextMenu("MemberBoard");
		if(mallCont.getbDAO().getbList().size() == 0) {
			System.out.println("[%s] 게시글이 존재하지 않습니다".formatted(mallCont.getId()));
			return false;
		}
		System.out.println("===[%s 게시글 보기]===".formatted(mallCont.getId()));
		mallCont.getbDAO().PageCalculate();
		mallCont.getbDAO().PrintBoard();
		int startRow = mallCont.getbDAO().getStartRow();
		int endRow = mallCont.getbDAO().getEndRow();
		int idx = Util.getValue("선택", startRow+1 , endRow);
		if(idx == -1) {
			System.out.println("[%s] 해당 페이지 글만 선택 가능합니다".formatted(mallCont.getId()));
			return false;
		}
		idx -= 1;
		mallCont.getbDAO().BoardViewPage(idx);
		int getHits = mallCont.getbDAO().getbList().get(idx).getHits();
		mallCont.getbDAO().getbList().get(idx).setHits(getHits+1);
		return false;
	}
}
