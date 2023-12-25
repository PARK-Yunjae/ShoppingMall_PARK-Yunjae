package menu_admin_item;

import _mall.MenuCommand;
import controller.MallController;
import util.Util;

public class AdminItemUpdate implements MenuCommand{
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
		
		String itemName = Util.getValue("이름");
		int itemIdx = mallCont.getiDAO().ItemNameValue(cgName, itemName);
		if(itemIdx == -1) {
			System.out.println("[관리자] 아이템이 존재하지 않습니다");
			return false;
		}
		String newItemName = Util.getValue("변경할이름");
		int newItemIdx = mallCont.getiDAO().ItemNameValue(cgName, newItemName);
		if(newItemIdx != -1) {
			System.out.println("[관리자] 아이템이름이 존재합니다");
			return false;
		}
		int price = Util.getValue("가격", 1, 100000);
		if(price == -1) {
			System.out.println("[관리자] 가격 설정 오류");
			return false;
		}
		// 아이템 목록에 이름 가격 수정
		mallCont.getiDAO().UpdateItem(cgName, itemName, price+"", itemIdx);
		System.out.println("[관리자] 아이템 이름 & 가격 수정 완료");
		return false;
	}
}
