package menu_member_cart;

import java.util.ArrayList;

import _mall.MenuCommand;
import controller.MallController;

public class MemberCartAllDelete implements MenuCommand{
	private MallController mallCont;

	@Override
	public void init() {
		mallCont = MallController.getInstance();
	}

	@Override
	public boolean update() {
		mallCont.setNextMenu("MemberCart");
		ArrayList<Integer> nameList = mallCont.getcDAO().getMyCartList(mallCont.getId());
		mallCont.getcDAO().MemberCartAllDelete(nameList);
		System.out.println("[%s] 장바구니 비우기 완료".formatted(mallCont.getId()));
		return false;
	}

}
