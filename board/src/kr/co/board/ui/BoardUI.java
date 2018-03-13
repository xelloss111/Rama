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
		System.out.println("�Խ��� ���α׷� ����");
		System.exit(0);
	}
	
	
	public int menu() {
		System.out.println("==================================================");
		System.out.println("1. ��ü �Խñ� ��ȸ");
		System.out.println("2. �۹�ȣ ��ȸ");
		System.out.println("3. �۵��");
		System.out.println("4. �ۼ���");
		System.out.println("5. �ۻ���");
		System.out.println("0. ����");
		System.out.println("==================================================");
		System.out.print("�޴� : ");
		return Integer.parseInt(sc.nextLine());
	}
	
}
