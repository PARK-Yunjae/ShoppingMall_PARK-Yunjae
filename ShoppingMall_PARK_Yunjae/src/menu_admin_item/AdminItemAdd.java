package menu_admin_item;

import _mall.MenuCommand;
import controller.MallController;
import util.Util;

public class AdminItemAdd implements MenuCommand {
	private MallController mallCont;

	@Override
	public void init() {
		mallCont = MallController.getInstance();
	}

	@Override
	public boolean update() {
		mallCont.setNextMenu("AdminItem");
		System.out.println("[카테고리 선택]");
		mallCont.getCgDAO().CategoryList();
		int size = mallCont.getCgDAO().getCgList().size();
		int cgidx = Util.getValue("선택", 1, size) - 1;
		String cgName = mallCont.getCgDAO().getCategoryName(cgidx);
		
		if (cgidx == -2) {
			return false;
		}
		
		String itemName = Util.getValue("이름");
		int itemIdx = mallCont.getiDAO().ItemNameValue(cgName, itemName);
		if(itemIdx != -1) {
			System.out.println("[관리자] 아이템 이름이 존재합니다");
			return false;
		}
		int price = Util.getValue("가격", 1, 100000);
		if(price == -1) {
			System.out.println("[관리자] 가격 설정 오류");
			return false;
		}
		mallCont.getiDAO().AddItem(cgName, itemName, price+"");
		return false;
	}
}
