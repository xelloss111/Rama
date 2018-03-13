package kr.co.board.main;

import kr.co.board.ui.BoardUI;

public class BoardMain {
	public static void main(String[] args) {
		try {
			BoardUI ui = new BoardUI();
			ui.service();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
