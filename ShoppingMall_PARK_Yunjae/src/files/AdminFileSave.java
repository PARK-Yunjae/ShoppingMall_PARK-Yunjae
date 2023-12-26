package files;

import _mall.MenuCommand;
import controller.MallController;

public class AdminFileSave implements MenuCommand{
	private MallController mallCont;

	@Override
	public void init() {
		mallCont = MallController.getInstance();
	}
 
	@Override
	public boolean update() {
		mallCont.setNextMenu("AdminMain");
		
		String bData = mallCont.getbDAO().DataToFile();
		mallCont.getfDAO().FileSave("board.txt", bData);
		String cData = mallCont.getcDAO().DataToFile();
		mallCont.getfDAO().FileSave("cart.txt", cData);
		String iData = mallCont.getiDAO().DataToFile();
		mallCont.getfDAO().FileSave("item.txt", iData);
		String mData = mallCont.getmDAO().DataToFile();
		mallCont.getfDAO().FileSave("member.txt", mData);
		
		return false;
	}
}
