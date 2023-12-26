package menu_member;

import java.util.ArrayList;

import _mall.MenuCommand;
import controller.MallController;
import dto.Cart;
import util.Util;

public class MemberShopping implements MenuCommand{
	private MallController mallCont;

	@Override
	public void init() {
		mallCont = MallController.getInstance();
	}

	@Override
	public boolean update() {
		mallCont.setNextMenu("MemberMain");
		if(mallCont.getCgDAO().getCgList().size() == 0) {
			System.out.println("[%s] 상품이 존재하지 않습니다".formatted(mallCont.getId()));
			return false;
		}
		mallCont.getCgDAO().CategoryList();
		int cgSize = mallCont.getCgDAO().getCgList().size();
		
		int cgidx = Util.getValue("선택", 1, cgSize) - 1;
		if (cgidx == -2) {
			System.out.println("[%s] 카테고리 선택 오류".formatted(mallCont.getId()));
			return false;
		}
		
		String cgName = mallCont.getCgDAO().getCategoryName(cgidx);
		ArrayList<Integer> cgToItemList = mallCont.getiDAO().ItemList(cgName); 
		int itemSel = Util.getValue("선택", 1, cgToItemList.size())-1;
		if(itemSel == -2) {
			System.out.println("[%s] 선택오류 메인화면으로 갑니다".formatted(mallCont.getId()));
			return false;
		}
		
		int cartNum = mallCont.getcDAO().cartNumValue(mallCont.getId(),cgToItemList.get(itemSel));
		if(cartNum != -1) {
			Cart info = mallCont.getcDAO().getcList().get(cartNum);
			info.setItemCnt(info.getItemCnt()+1);
			return false;
		}
		Cart cart = new Cart();
		String[] info = {mallCont.getId(),cgToItemList.get(itemSel)+"" , "1"};
		cart = cart.CreateCart(info);
		mallCont.getcDAO().getcList().add(cart);
		
		
		System.out.println("[%s] 장바구니 추가 완료".formatted(mallCont.getId()));
		return false;
	}

}
