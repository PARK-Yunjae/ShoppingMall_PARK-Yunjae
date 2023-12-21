package dto;

public class Board {
	private static int num;
	private int boardNum;
	private String title;
	private String id;
	private String date;
	private String contents;
	private int hits;
	
	public Board() {
		num = 1;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public String getTitle() {
		return title;
	}

	public String getId() {
		return id;
	}

	public String getDate() {
		return date;
	}

	public String getContents() {
		return contents;
	}

	public int getHits() {
		return hits;
	}

	private Board(String boardNum, String title, String id, String date, String contents, String hits) {
		super();
		this.boardNum = Integer.parseInt(boardNum);
		this.title = title;
		this.id = id;
		this.date = date;
		this.contents = contents;
		this.hits = Integer.parseInt(hits);
		num++;
	}
	
	public Board CreateBoard(String[] info) {
		if(info == null || info.length == 0) return null;
		
		return new Board(info[0], info[1], info[2], info[3], info[4], info[5]);
	}
}
