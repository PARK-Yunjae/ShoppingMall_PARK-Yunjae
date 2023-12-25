package files;

import java.util.ArrayList;

import _mall.MenuCommand;
import controller.MallController;

public class AdminFileLoad implements MenuCommand {
	private MallController mallCont;

	@Override
	public void init() {
		mallCont = MallController.getInstance();
	}

	@Override
	public boolean update() {
		mallCont.setNextMenu("AdminMain");

		String bData = mallCont.getfDAO().FileLoad("board.txt");
		mallCont.getbDAO().FileToData(bData);
		String cData = mallCont.getfDAO().FileLoad("cart.txt");
		mallCont.getcDAO().FileToData(cData);
		String iData = mallCont.getfDAO().FileLoad("item.txt");
		mallCont.getiDAO().FileToData(iData);
		String mData = mallCont.getfDAO().FileLoad("member.txt");
		mallCont.getmDAO().FileToData(mData);
		if (iData.length() != 0) {
			ArrayList<String> cgList = mallCont.getiDAO().getCategoryList();
			mallCont.getCgDAO().FileToData(cgList);
		}
		return false;
	}
}
