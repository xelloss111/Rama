package kr.co.board.ui;

import kr.co.board.mapper.BoardMapper;

public class DeleteBoardUI extends BaseUI {
	private BoardMapper mapper = null;

	public DeleteBoardUI(BoardMapper mapper) {
		super();
		this.mapper = mapper;
	}

	@Override
	public void service() {
		int result = mapper.deleteBoard(getInt("삭제할 글번호 : "));
		if (result != 0) System.out.println("게시글이 삭제되었습니다.");
		else System.out.println("해당 번호의 게시글이 존재하지 않습니다.");
	}
}
