package kr.co.board.mapper;

import java.util.List;
import kr.co.board.domain.Board;

public interface BoardMapper {
	List<Board> selectBoard();
	Board selectBoardByNo(int no);
	void insertBoard(Board board);
	int updateBoard(Board board);
	int deleteBoard(int no);
	void updateBoardViewCnt(int no);
}
