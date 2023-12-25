메인 메뉴 - 실행시 초기값 : MallMain

1. 회원가입
2. 로그인
0. 종료

1. 회원가입 - id 중복검사 (1001부터) 비밀번호만 정규화? 해보기 닉네임 중복 허용
	비밀번호 패턴
	- 최소 4자 이상 20자 미만
	- 반드시 영단어 1개, 숫자 1개 이상이 포함되어야 합니다.
	1000/admin/admin/관리자
	멤버에 처음은 항상 이걸로 고정 - 메인 실행시 자동 가입

2. 로그인 - 관리자 로그인, 맴버 로그인메뉴 따로 있음, id값 controller가 저장
0. 종료 - 자동  파일 저장 기능 구현?


관리자 메뉴 - AdminMain

1. 회원관리 - 회원 목록, 회원 삭제, 회원 수정(닉네임)
2. 상품관리 - 카테고리 관리, 아이템 관리
	   - 카테고리 추가, 카테고리 수정, 카테고리 삭제, 카테고리 목록
	   - 아이템 추가, 아이템 수정, 아이템 삭제, 아이템 목록
3. 게시판관리 - 게시글 삭제, 게시글 목록 
4. 파일 저장 - 각각 dao에서 문자열 만들어서 따로 저장(board.txt, cart.txt, item.txt, member.txt)
5. 파일 로드 - 각각 텍스트 파일에서 문자열로 불러온 다음에 dao에 있는 리스트 클리어 하고 다시 새로 저장(board.txt, cart.txt, item.txt, member.txt)
0. 로그아웃 - id 값 "" 로 변경

사용자 메뉴 - MemberMain
1. 상품구매
2. 장바구니
3. 게시판
4. 나의정보
5. 회원탈퇴
0. 로그아웃 - id값 "" 로 변경


