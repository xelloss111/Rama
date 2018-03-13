package kr.co.board.ui;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import common.db.MyAppSqlConfig;
import kr.co.board.mapper.BoardMapper;

public class BoardUI {
	private Scanner sc = new Scanner(System.in);
	private BoardMapper mapper = null;
	
	public BoardUI() {
		SqlSession session = MyAppSqlConfig.getSessionInstance();
		mapper = session.getMapper(BoardMapper.class);
	}
	
	
	public void service() {
		BaseUI ui = null;
		while(true) {
			switch(menu()) {
			case 1: ui = new ListBoardUI(mapper); break;
			case 2: ui = new DetailBoardUI(mapper); break;
			case 3: ui = new WriteBoardUI(mapper); break;
			case 4: ui = new UpdateBoardUI(mapper); break;
			case 5: ui = new DeleteBoardUI(mapper); break;
			case 0: quit();
			}
			ui.service();
		}
	}
	
	public void quit() {
		System.out.println("게시판 프로그램 종료");
		System.exit(0);
	}
	
	
	public int menu() {
		System.out.println("==================================================");
		System.out.println("1. 전체 게시글 조회");
		System.out.println("2. 글번호 조회");
		System.out.println("3. 글등록");
		System.out.println("4. 글수정");
		System.out.println("5. 글삭제");
		System.out.println("0. 종료");
		System.out.println("==================================================");
		System.out.print("메뉴 : ");
		return Integer.parseInt(sc.nextLine());
	}
	
}
