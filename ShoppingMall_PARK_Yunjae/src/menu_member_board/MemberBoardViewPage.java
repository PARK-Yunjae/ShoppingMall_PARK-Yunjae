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
		System.out.println("===[%d 게시글 보기]===".formatted(mallCont.getId()));
		int startRow = mallCont.getbDAO().getStartRow();
		int endRow = mallCont.getbDAO().getEndRow();
		int idx = Util.getValue("선택", startRow , endRow);
		if(idx == -1) {
			System.out.println("[%s] 해당 페이지 글만 선택 가능합니다");
			return false;
		}
		mallCont.getbDAO().BoardViewPage(idx);
		int getHits = mallCont.getbDAO().getbList().get(idx).getHits();
		mallCont.getbDAO().getbList().get(idx).setHits(getHits+1);
		return false;
	}
}
