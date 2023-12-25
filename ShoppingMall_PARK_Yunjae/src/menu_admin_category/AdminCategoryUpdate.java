package menu_admin_category;

import _mall.MenuCommand;
import controller.MallController;
import util.Util;

public class AdminCategoryUpdate implements MenuCommand {

	private MallController mallCont;

	@Override
	public void init() {
		mallCont = MallController.getInstance();
	}

	@Override
	public boolean update() {
		mallCont.setNextMenu("AdminCategory");
		if(mallCont.getCgDAO().getCgList().size() == 0) {
			System.out.println("[관리자] 카테고리가 존재하지 않습니다");
			return false;
		}
		String name = Util.getValue("이름");
		int cgIdx = mallCont.getCgDAO().nameValue(name);
		if (cgIdx == -1) {
			System.out.println("[관리자] 카테고리가 존재하지 않습니다");
			return false;
		}
		String newName = Util.getValue("변경할 이름 : ");
		// 카테고리 리스트 수정
		mallCont.getCgDAO().UpdateCategory(cgIdx, newName); 
		// 아이템 리스트 카테고리 이름 수정
		mallCont.getiDAO().UpdateCategory(name, newName);   
		System.out.println("[관리자] 카테고리 이름 변경 완료");
		return false;
	}
}
