package menu_admin_board;

import _mall.MenuCommand;
import controller.MallController;
import util.Util;

public class AdminBoardDelete implements MenuCommand{
	private MallController mallCont;

	@Override
	public void init() {
		mallCont = MallController.getInstance();
	}

	@Override
	public boolean update() {
		mallCont.setNextMenu("AdminBoard");
		if(mallCont.getbDAO().getbList().size() == 0) {
			System.out.println("[관리자] 게시판에 글이 없습니다");
			return false;
		}
		while (true) {
			int curPageNum = mallCont.getbDAO().getCurPageNum();
			mallCont.getbDAO().PageCalculate();
			mallCont.getbDAO().PrintBoard();
			System.out.println("[1]이전");
			System.out.println("[2]이후");
			System.out.println("[3]삭제");
			System.out.println("[0]나가기");
			int sel = Util.getValue("선택", 0, 2);
			if(sel == 1) {
				if (curPageNum == 1) {
					System.out.println("이전페이지 없음");
					continue;
				}
				mallCont.getbDAO().setCurPageNum(curPageNum-1);
			}else if(sel == 2) {
				if (curPageNum == mallCont.getbDAO().getPageCount()) {
					System.out.println("이후페이지 없음");
					continue;
				}
				mallCont.getbDAO().setCurPageNum(curPageNum+1);
				
			}else if(sel == 3) {
				int startRow = mallCont.getbDAO().getStartRow();
				int endRow = mallCont.getbDAO().getEndRow();
				int bIdx = Util.getValue("게시글 선택", startRow, endRow);
				if(bIdx == -1) {
					continue;
				}
				String title = mallCont.getbDAO().getbList().get(bIdx).getTitle();
				System.out.println("[관리자] %s 게시글 삭제 완료".formatted(title));
				mallCont.getbDAO().DedeteBoard(bIdx);
			}
			else if(sel == 0) {
				break;
			}
		}
		return false;
	}
}