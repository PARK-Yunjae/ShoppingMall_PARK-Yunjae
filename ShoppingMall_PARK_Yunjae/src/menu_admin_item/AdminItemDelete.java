package menu_admin_item;

import _mall.MenuCommand;
import controller.MallController;
import util.Util;

public class AdminItemDelete implements MenuCommand{
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
		mallCont.getCgDAO().CategoryList();
		int size = mallCont.getCgDAO().getCgList().size();
		
		int cgidx = Util.getValue("선택", 1, size) - 1;
		if (cgidx == -2) {
			System.out.println("[관리자] 카테고리 선택 오류");
			return false;
		}
		
		String cgName = mallCont.getCgDAO().getCategoryName(cgidx);
		String itemName = Util.getValue("이름");
		int itemIdx = mallCont.getiDAO().ItemNameValue(cgName, itemName);
		
		if(itemIdx == -1) {
			System.out.println("[관리자] 아이템 이름이 존재하지 않습니다");
			return false;
		}
		
		int itemNum = mallCont.getiDAO().getItemList().get(itemIdx).getItemNum();
		// 아이템 리스트에서 아이템 삭제 - 아이템 위치
		mallCont.getiDAO().DeleteItem(itemIdx);
		// 카트 리스트에서 아이템 삭제 - 아이템 넘버
		mallCont.getcDAO().DeleteItem(itemNum);
		System.out.println("[관리자] %s 삭제 완료".formatted(itemName));
		return false;
	}
}
