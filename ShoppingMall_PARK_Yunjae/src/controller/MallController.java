package controller;

import java.util.HashMap;
import java.util.Map;

import _mall.MenuCommand;
import dao.*;
import files.*;
import menu_admin.*;
import menu_admin_board.*;
import menu_admin_category.*;
import menu_admin_item.*;
import menu_admin_member.*;
import menu_mall.*;
import menu_member.*;
import menu_member_board.*;
import menu_member_cart.*;
import menu_member_info.*;

public class MallController {

	private static MallController instance = new MallController();
	private Map<String, MenuCommand> mallList;
	private MemberDAO mDAO;
	private CategoryDAO cgDAO;
	private ItemDAO iDAO;
	private CartDAO cDAO;
	private BoardDAO bDAO;
	private FileDAO fDAO;
	private String id;
	private String nextMenu = "MallMain";
	private String curMenu = "";

	public static MallController getInstance() {
		return instance;
	}

	public MemberDAO getmDAO() {
		return mDAO;
	}

	public CategoryDAO getCgDAO() {
		return cgDAO;
	}

	public ItemDAO getiDAO() {
		return iDAO;
	}

	public CartDAO getcDAO() {
		return cDAO;
	}

	public BoardDAO getbDAO() {
		return bDAO;
	}

	public FileDAO getfDAO() {
		return fDAO;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setNextMenu(String nextMenu) {
		this.nextMenu = nextMenu;
	}

	public void init() {
		mDAO = new MemberDAO();
		cgDAO = new CategoryDAO();
		iDAO = new ItemDAO();
		cDAO = new CartDAO(); 
		bDAO = new BoardDAO();
		fDAO = new FileDAO();
		id = "";
		mallList = new HashMap<>();
		mallList.put("MallMain", new _MailMain());
		mallList.put("MallJoin", new MallJoin());
		mallList.put("MallLogin", new MallLogin());
		mallList.put("AdminMain", new _AdminMain());
		mallList.put("AdminFileSave", new AdminFileSave());
		mallList.put("AdminFileLoad", new AdminFileLoad());
		mallList.put("AdminBoard", new AdminBoard());
		mallList.put("AdminBoardDelete", new AdminBoardDelete()); 
		mallList.put("AdminBoardList", new AdminBoardList());
		mallList.put("AdminProduct", new AdminProduct());
		mallList.put("AdminItem", new AdminItem());
		mallList.put("AdminItemAdd", new AdminItemAdd()); 
		mallList.put("AdminItemUpdate", new AdminItemUpdate());
		mallList.put("AdminItemDelete", new AdminItemDelete());
		mallList.put("AdminItemList", new AdminItemList());
		mallList.put("AdminCategory", new AdminCategori());
		mallList.put("AdminCategoryAdd", new AdminCategoryAdd());
		mallList.put("AdminCategoryUpdate", new AdminCategoryUpdate());
		mallList.put("AdminCategoryDelete", new AdminCategoryDelete());
		mallList.put("AdminCategoryList", new AdminCategoryList());
		mallList.put("AdminMember", new AdminMember());
		mallList.put("AdminMemberList", new AdminMemberList());
		mallList.put("AdminMemberUpdate", new AdminMemberUpdate());
		mallList.put("AdminMemberDelete", new AdminMemberDelete());
		mallList.put("MemberMain", new _MemberMain());
		mallList.put("MemberBoard", new MemberBoard());
		mallList.put("MemberBoardBeforePage", new MemberBoardBeforePage());
		mallList.put("MemberBoardAfterPage", new MemberBoardAfterPage());
		mallList.put("MemberBoardAddPage", new MemberBoardAddPage());
		mallList.put("MemberBoardViewPage", new MemberBoardViewPage());
		mallList.put("MemberBoardUpdatePage", new MemberBoardUpdatePage());
		mallList.put("MemberBoardDeletePage", new MemberBoardDeletePage());
		mallList.put("MemberBoard", new MemberBoard());
		mallList.put("MemberCart", new MemberCart());
		mallList.put("MemberCartAllDelete", new MemberCartAllDelete());
		mallList.put("MemberCartOneDelete", new MemberCartOneDelete());
		mallList.put("MemberInfo", new MemberInfo());
		mallList.put("MemberInfoList", new MemberInfoList());
		mallList.put("MemberInfoNameUpdate", new MemberInfoNameUpdate());
		mallList.put("MemberInfoPwUpdate", new MemberInfoPwUpdate());
		mallList.put("MemberQuit", new MemberQuit());
		mallList.put("MemberShopping", new MemberShopping());
	}

	public boolean changeMenu() {

		if (curMenu.equals(nextMenu))
			return true;

		curMenu = nextMenu;
		MenuCommand mc = mallList.get(curMenu);
		mc.init();

		while (mc.update()) {
		}

		if (nextMenu.equals(""))
			return false;
		return true;
	}
}
