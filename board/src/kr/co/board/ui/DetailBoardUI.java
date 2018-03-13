package kr.co.board.ui;

import java.text.SimpleDateFormat;

import kr.co.board.domain.Board;
import kr.co.board.mapper.BoardMapper;

public class DetailBoardUI extends BaseUI {
	private BoardMapper mapper = null;

	public DetailBoardUI(BoardMapper mapper) {
		super();
		this.mapper = mapper;
	}

	@Override
	public void service() {
		int no = getInt("조회할 글번호 : ");
		mapper.updateBoardViewCnt(no);
		Board b = mapper.selectBoardByNo(no);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (b != null) {
			System.out.println("글번호 : " + b.getNo());
			System.out.println("제목 : " + b.getTitle());
			System.out.println("글쓴이 : " + b.getWriter());
			System.out.println("내용 : " + b.getContent());
			System.out.println("등록일시 : " + sdf.format(b.getRegDate()));
			System.out.println("조회수 : " + b.getViewCnt());
		} else System.out.println("해당 번호의 게시글이 존재하지 않습니다.");
	}
	
	
}
