package menu_admin_category;

import java.util.ArrayList;

import _mall.MenuCommand;
import controller.MallController;
import util.Util;

public class AdminCategoryDelete implements MenuCommand {

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
		String cgName = Util.getValue("이름");
		int cgIdx = mallCont.getCgDAO().nameValue(cgName);
		if (cgIdx == -1) {
			System.out.println("[관리자] 카테고리가 존재하지 않습니다.");
			return false;
		}
		// 해당 카테고리 이름을 가진 아이템 넘버 전부 담아서 가져감
		ArrayList<Integer> iNumList = mallCont.getiDAO().CategoriToItemList(cgName);
		// 카테고리 삭제
		mallCont.getCgDAO().DeleteCategory(cgIdx);
		// 아이템 리스트에서 다 삭제
		mallCont.getiDAO().DeleteCategory(cgName);   
		// 카트에서도 삭제
		mallCont.getcDAO().DeleteCategory(iNumList);
		System.out.println("[관리자] 카테고리 %s 삭제 완료".formatted(cgName));
		return false;
	}
}
