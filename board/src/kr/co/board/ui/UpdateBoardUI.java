package kr.co.board.ui;

import kr.co.board.domain.Board;
import kr.co.board.mapper.BoardMapper;

public class UpdateBoardUI extends BaseUI {
	private BoardMapper mapper = null;

	public UpdateBoardUI(BoardMapper mapper) {
		super();
		this.mapper = mapper;
	}

	@Override
	public void service() {
		Board b = new Board();
		b.setTitle(getStr("변경할 제목 : "));
		b.setContent(getStr("변경할 내용 : "));
		int result = mapper.updateBoard(b);
		if (result != 0) System.out.println("게시글이 수정되었습니다.");
		else System.out.println("해당 번호의 게시글이 존재하지 않습니다.");
	}
}
