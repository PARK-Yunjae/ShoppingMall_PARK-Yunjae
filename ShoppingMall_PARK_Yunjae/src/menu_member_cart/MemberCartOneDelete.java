package menu_member_cart;

import java.util.ArrayList;

import _mall.MenuCommand;
import controller.MallController;
import util.Util;

public class MemberCartOneDelete implements MenuCommand{
	private MallController mallCont;

	@Override
	public void init() {
		mallCont = MallController.getInstance();
	}

	@Override
	public boolean update() {
		mallCont.setNextMenu("MemberCart");
		ArrayList<Integer> nameList = mallCont.getcDAO().getMyCartList(mallCont.getId());
		int sel = Util.getValue("선택", 1, nameList.size())-1;
		
		if(sel == -2) {
			return false;
		}
		mallCont.getcDAO().MemberCartOneDelete(nameList.get(sel));
		System.out.println("[%s] 장바구니 1개 품목 삭제 완료".formatted(mallCont.getId()));
		
		return false;
	}

}
