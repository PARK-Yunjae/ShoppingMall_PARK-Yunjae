package menu_member;

import java.util.ArrayList;

import _mall.MenuCommand;
import controller.MallController;
import util.Util;

public class MemberCart implements MenuCommand {
	private MallController mallCont;

	@Override
	public void init() {
		mallCont = MallController.getInstance();
	}

	@Override
	public boolean update() {
		mallCont.setNextMenu("MemberCart");
		if (mallCont.getCgDAO().getCgList().size() == 0 || mallCont.getiDAO().getItemList().size() == 0) {
			System.out.println("[%s] 상품이 존재하지 않습니다".formatted(mallCont.getId()));
			return false;
		}
		ArrayList<Integer> nameList = mallCont.getcDAO().getMyCartList(mallCont.getId());
		if(nameList.size() == 0 || mallCont.getcDAO().getcList().size() == 0) {
			System.out.println("[%s] 장바구니에 상품이 없습니다".formatted(mallCont.getId()));
			mallCont.setNextMenu("MemberMain");
			return false;
		}
		System.out.println("===[%s 장바구니]===".formatted(mallCont.getId()));
		System.out.println("[1] 1개 삭제");
		System.out.println("[2] 전체 삭제");
		System.out.println("[0] 뒤로 가기");
		int sel = Util.getValue("선택", 0, 2);

		if (sel == 1) {
			mallCont.setNextMenu("MemberCartOneDelete");
		} else if (sel == 2) {
			mallCont.setNextMenu("MemberCartAllDelete");
		} else if (sel == 0) {
			mallCont.setNextMenu("MemberMain");
		} else {
			return true;
		}

		return false;
	}

}
