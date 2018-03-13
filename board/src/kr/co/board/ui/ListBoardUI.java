package kr.co.board.ui;

import java.text.SimpleDateFormat;
import java.util.List;

import kr.co.board.domain.Board;
import kr.co.board.mapper.BoardMapper;

public class ListBoardUI extends BaseUI {
	private BoardMapper mapper = null;

	public ListBoardUI(BoardMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public void service() {
		List<Board> list = mapper.selectBoard();
		System.out.println("==================================================");
		System.out.printf("총 %d개\n", list.size());
		System.out.println("==================================================");
		System.out.printf("번호\t제목\t글쓴이\t등록일\t조회수\n");
		System.out.println("==================================================");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < list.size(); i++) {
			Board b = list.get(i);
			System.out.printf("%d\t%s\t%s\t%s\t%d\n",
					b.getNo(), b.getTitle(), b.getWriter(),
					sdf.format(b.getRegDate()), b.getViewCnt());
		}
		if(list.isEmpty()) System.out.println("게시글이 존재하지 않습니다.");
	}
}
