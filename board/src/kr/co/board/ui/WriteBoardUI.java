package kr.co.board.ui;

import kr.co.board.domain.Board;
import kr.co.board.mapper.BoardMapper;

public class WriteBoardUI extends BaseUI {
	private BoardMapper mapper = null;

	public WriteBoardUI(BoardMapper mapper) {
		super();
		this.mapper = mapper;
	}

	@Override
	public void service() {
		Board b = new Board();
		b.setTitle(getStr("제목 입력 : "));
		b.setWriter(getStr("글쓴이 입력 : "));
		b.setContent(getStr("내용 입력 : "));
		mapper.insertBoard(b);
		System.out.println("게시글이 등록되었습니다.");
	}
}
