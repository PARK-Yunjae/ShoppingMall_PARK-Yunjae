package dao;

import java.util.ArrayList;

import dto.Board;

public class BoardDAO {
	private ArrayList<Board> bList;
	private int count = 0; // 전체 게시글 수
	private int pageSize = 5; // 한 페이지에 보여줄 게시글 수
	private int curPageNum = 1; // 현재 페이지 번호
	private int pageCount = 0; // 전체 페이지 개수
	private int startRow = 0; // 현재 페이지의 게시글 시작 번호
	private int endRow = 0; // 현재 페이지의 게시글 마지막 번호

	public int getStartRow() {
		return startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public int getCurPageNum() {
		return curPageNum;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setCurPageNum(int curPageNum) {
		this.curPageNum = curPageNum;
	}

	public BoardDAO() {
		bList = new ArrayList<Board>();
	}

	public ArrayList<Board> getbList() {
		return bList;
	}

	// 회원 삭제 시 게시글 날리기
	public void DeleteMember(String id) {
		if (bList.size() == 0)
			return;

		for (int i = 0; i < bList.size(); i += 1) {
			if (bList.get(i).getId().equals(id)) {
				bList.remove(i);
				i--;
			}
		}
	}
	
	// 게시판 페이지 계산?
	public void PageCalculate() {
		count = bList.size();
		pageCount = count / pageSize;
		if (count % pageSize > 0)
			pageCount += 1;
		startRow = (curPageNum - 1) * pageSize;
		endRow = startRow + pageSize;
		if (endRow > count)
			endRow = count;
	}

	// 게시판 출력
	public void PrintBoard() {
		for (int i = startRow; i < endRow; i += 1) {
			bList.get(i).PrintBoard();
		}
	}
	
	// 게시글 하나 삭제
	public void DedeteBoard(int idx) {
		bList.remove(idx);
	}
	
	// 텍스트 파일 저장용 데이터 만들기
	public String DataToFile() {
		String data = "";
		if(bList.size() == 0) return data;
		for(Board b : bList) {
			data += b.DataToFile() + "\n";
		}
		data = data.substring(0, data.length()-1);
		return data;
	}
	
	// 텍스트파일에서 문자열 받아와서 데이터 넣기
	public void FileToData(String data) {
		String datas[] = data.split("\n");
		bList.clear();
		for(int i=0 ; i<datas.length ; i+=1) {
			Board b = new Board();
			String[] info = datas[i].split("/");
			b = b.CreateBoard(info);
			bList.add(b);
		}
	}
}
