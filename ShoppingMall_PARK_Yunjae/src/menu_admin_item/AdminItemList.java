package menu_admin_item;

import _mall.MenuCommand;
import controller.MallController;
import util.Util;

public class AdminItemList implements MenuCommand{
	private MallController mallCont;

	@Override
	public void init() {
		mallCont = MallController.getInstance();
	}

	@Override
	public boolean update() {
		mallCont.setNextMenu("AdminItem");
		if(mallCont.getCgDAO().getCgList().size() == 0) {
			System.out.println("[관리자] 카테고리를 먼저 추가해 주세요");
			return false;
		}
		if(mallCont.getiDAO().getItemList().size() == 0) {
			System.out.println("[관리자] 아이템이 존재하지 않습니다");
			return false;
		}
		System.out.println("[카테고리 선택]");
		mallCont.getCgDAO().CategoryList();
		int size = mallCont.getCgDAO().getCgList().size();
		int cgidx = Util.getValue("선택", 1, size) - 1;
		String cgName = mallCont.getCgDAO().getCategoryName(cgidx);
		
		if (cgidx == -2) {
			System.out.println("[관리자] 카테고리 선택 오류");
			return false;
		}
		// 카테고리 기준으로 아이템 리스트 보기
		mallCont.getiDAO().ItemList(cgName);
		
		return false;
	}
}
