package controller;

import java.util.HashMap;
import java.util.Map;

import _mall.MenuCommand;
import dao.FileDAO;
import files.AdminFileSave;
import menu_admin.*;
import menu_admin_item.*;
import menu_admin_member.*;
import menu_board.*;
import menu_mall.*;
import menu_member.*;
import menu_member_cart.*;
import menu_member_info.*;

public class MallController {

	private static MallController instance = new MallController();
	private Map<String, MenuCommand> mcMap;
	private String id;
	private String next;
	private MenuCommand mc;

	public static MallController getInstance() {
		return instance;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public void init() {
		id = "";
		next = "";
		mcMap = new HashMap<>();
		mcMap.put("MallMain", new _MailMain()); // 메인메뉴
		mcMap.put("MallJoin", new MallJoin()); // 회원가입
		mcMap.put("MallLogin", new MallLogin()); // 로그인
		mcMap.put("AdminMain", new _AdminMain()); // 관리자 메인메뉴
		mcMap.put("AdminMember", new AdminMember()); // 관리자 회원 메인
		mcMap.put("AdminMemberList", new AdminMemberList()); // 관리자 회원 목록
		mcMap.put("AdminMemberDelete", new AdminMemberDelete()); // 관리자 회원 삭제
		mcMap.put("AdminItem", new AdminItem()); // 관리자 아이템 메인
		mcMap.put("AdminItemAdd", new AdminItemAdd()); // 관리자 아이템 추가
		mcMap.put("AdminItemDelete", new AdminItemDelete()); // 관리자 아이템 삭제
		mcMap.put("AdminItemRevenue", new AdminItemRevenue()); // 관리자 아이템 총 매출
		mcMap.put("AdminBoard", new AdminBoard()); // 관리자 게시판 메인
		mcMap.put("BoardList", new BoardList()); // 게시글 목록
		mcMap.put("BoardDeletePage", new BoardDeletePage()); // 게시글 삭제(관리자는 전부, 사용자는 자기글만)
		mcMap.put("BoardBeforePage", new BoardBeforePage()); // 게시글 이전
		mcMap.put("BoardAfterPage", new BoardAfterPage());  // 게시글 이후
		mcMap.put("BoardViewPage", new BoardViewPage()); // 게시글 보기
		mcMap.put("BoardAddPage", new BoardAddPage()); // 게시글 작성
		mcMap.put("AdminFileSave", new AdminFileSave()); // 파일 저장
		mcMap.put("MemberMain", new _MemberMain()); // 사용자 메인
		mcMap.put("MemberShopping", new MemberShopping()); // 사용자 쇼핑
		mcMap.put("MemberCart", new MemberCart()); // 사용자 구매내역 메인
		mcMap.put("MemberCartBuy", new MemberCartBuy()); // 쇼핑하기
		mcMap.put("MemberCartClear", new MemberCartClear()); // 비우기
		mcMap.put("MemberBoard", new MemberBoard()); // 사용자 게시판 메인
		mcMap.put("MemberInfo", new MemberInfo()); // 사용자 나의 정보 메인
		mcMap.put("MemberInfoPwUpdate", new MemberInfoPwUpdate()); // 사용자 비밀번호 변경
		mcMap.put("MemberQuit", new MemberQuit()); // 회원 탈퇴
		
		mc = mcMap.get("MallMain");
		mc.init();

		FileDAO.getInstance(); // 불러오면 생성자에서 init실행
		update();
	}

	public void update() {
		while(true) {
			if (!mc.update()) {
				if (!next.equals("")) {
					mc = mcMap.get(next);
					mc.init();
				} else {
					return;
				}
			}
		}
	}
}
