package menu_admin_item;

import _mall.MenuCommand;
import controller.MallController;

public class AdminItemRevenue implements MenuCommand {
	private MallController cont;

	@Override
	public void init() {
		cont = MallController.getInstance();
	}

	@Override
	public boolean update() {
		cont.setNext("AdminItem");
		
		return false;
	}
}
