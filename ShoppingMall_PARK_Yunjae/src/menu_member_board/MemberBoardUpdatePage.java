package menu_member_board;

import _mall.MenuCommand;
import controller.MallController;
import dto.Board;
import util.Util;

public class MemberBoardUpdatePage implements MenuCommand {
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
		System.out.println("===[%s 글 수정]===".formatted(mallCont.getId()));
		int startRow = mallCont.getbDAO().getStartRow();
		int endRow = mallCont.getbDAO().getEndRow();
		int idx = Util.getValue("선택", startRow+1 , endRow);
		if(idx == -1) {
			System.out.println("[%s] 해당 페이지 글만 선택 가능합니다");
			return false;
		}
		idx -= 1;
		idx = mallCont.getbDAO().getMyBoardIdx(idx, mallCont.getId());
		if(idx == -1) {
			System.out.println("[%s] 내가 작성한 글이 아닙니다");
			return false;
		}
		String title = Util.getValue("새 제목");
		String contents = Util.getValue("새 내용");
		Board b = mallCont.getbDAO().getbList().get(idx);
		String[] info = {b.getBoardNum()+"", title, b.getId(), b.getDate(), contents, b.getHits()+""};
		mallCont.getbDAO().getbList().set(idx, b.CreateBoard(info));
		System.out.println("[%d] 글 수정 완료".formatted(b.getBoardNum()));
		return false;
	}
}

