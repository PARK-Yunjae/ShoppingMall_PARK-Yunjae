package controller;

import java.util.HashMap;
import java.util.Map;

import _mall.MenuCommand;
import menu_admin.*;
import menu_mall.*;
import menu_member.*;

public class MallController {

	private MallController() {
		//init();
	}

	private static MallController instance = new MallController();

	public static MallController getInstance() {
		return instance;
	}

	private Map<String, MenuCommand> mallList;

	public void init() {
		mallList = new HashMap<>();
		mallList.put("MallMain", new _MailMain());
		mallList.put("MallJoin", new MallJoin());
		mallList.put("MallLogin", new MallLogin());
		mallList.put("AdminMain", new _AdminMain());
		mallList.put("AdminBoard", new AdminBoard());
		mallList.put("AdminItem", new AdminItem());
		mallList.put("AdminMember", new AdminMember());
		mallList.put("MemberMain", new _MemberMain());
		mallList.put("MemberBoard", new MemberBoard());
		mallList.put("MemberCart", new MemberCart());
		mallList.put("MemberInfo", new MemberInfo());
		mallList.put("MemberItem", new MemberItem());
		mallList.put("MemberQuit", new MemberQuit());
		mallList.put("MemberShopping", new MemberShopping());
	}

	public MenuCommand setNext(String key) {
		return mallList.get(key);
	}
}
