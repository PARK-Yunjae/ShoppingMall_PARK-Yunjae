package controller;

import java.util.HashMap;
import java.util.Map;

import _mall.MenuCommand;
import menu_admin.*;
import menu_mall.*;
import menu_member.*;

public class MallController {

	private static MallController instance = new MallController();

	public static MallController getInstance() {
		return instance;
	}
	
	public MallController() {
		init();
	}
	
	private Map<String, MenuCommand> mallCont;
	
	public void init() {
		mallCont = new HashMap<String, MenuCommand>();
		mallCont.put("MallMain", new _MailMain());
		mallCont.put("MallJoin", new MallJoin());
		mallCont.put("AdminMain", new _AdminMain());
		mallCont.put("AdminBoard", new AdminBoard());
		mallCont.put("AdminItem", new AdminItem());
		mallCont.put("AdminMember", new AdminMember());
		mallCont.put("MemberMain", new _MemberMain());
		mallCont.put("MemberBoard", new MemberBoard());
		mallCont.put("MemberCart", new MemberCart());
		mallCont.put("MemberInfo", new MemberInfo());
		mallCont.put("MemberItem", new MemberItem());
		mallCont.put("MemberQuit", new MemberQuit());
		mallCont.put("MemberShopping", new MemberShopping());
	}
	
	public MenuCommand setNext(String key) {
		return mallCont.get(key);
	}
}
