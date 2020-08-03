package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


import dto.BoardDto;
import mybatis.config.DBService;

public class BoardDao {
	private SqlSessionFactory factory;
	
	private BoardDao() {
		factory = DBService.getInstance().getFactory();
	}
	
	private static BoardDao boardDao = new BoardDao();
	public static BoardDao getInstance() {
		return boardDao;
	}
	
	// 기능
	// 1.selectBoardList
	public List<BoardDto> selectBoardList(){
		SqlSession ss = factory.openSession();
		List<BoardDto> list = ss.selectList("mybatis.mapper.board.selectBoardList");
		ss.close();
		System.out.println("ClannLog: Dao.SelectBoardList 호출");
		return list;
	}
	
	// 2.selectBoardByNo
	public BoardDto selectBoardByNo(int no) {
		SqlSession ss = factory.openSession();
		BoardDto boardDto = ss.selectOne("mybatis.mapper.board.selectBoardByNo", no);
		ss.close();
		System.out.println("ClannLog: Dao.SelectBoardByNo 호출");
		return boardDto;
	}
	
	// 3.insertBoard
	public int insertBoard(BoardDto boardDto) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert("mybatis.mapper.board.insertBoard", boardDto);
		if (result > 0) {
			ss.commit();
			System.out.println("ClannLog: Dao.insertBoard 성공");
		} else {
			System.out.println("ClannLog: Dao.insertBoard 실패");
		}
		ss.close();
		return result;
	}
	
	// 4. updateBoard
	public int updateBoard(BoardDto boardDto) {
		SqlSession ss = factory.openSession(false);
		int result = ss.update("mybatis.mapper.board.updateBoard", boardDto);
		if (result > 0) {
			ss.commit();
			System.out.println("ClannLog: Dao.updateBoard 성공");
		} else {
			System.out.println("ClannLog: Dao.updateBoard 실패");
		}
		ss.close();
		return result;
	}
	
	// 5. deleteBoard
	public int deleteBoard(int no) {
		SqlSession ss = factory.openSession(false);
		int result = ss.delete("mybatis.mapper.board.deleteBoard", no);
		if (result > 0) {
			ss.commit();
			System.out.println("ClannLog: Dao.deleteBoard 성공");
		} else {
			System.out.println("ClannLog: Dao.deleteBoard 실패");
		}
		ss.close();
		return result;
	}

	// 6. 조회수증가(조회수변경)
	public int updateHit(int no) {
		SqlSession ss = factory.openSession(false);
		int result = ss.update("mybatis.mapper.board.updateHit", no);
		if (result > 0) {
			ss.commit();
			System.out.println("ClannLog: Dao.updateHit 성공");
		} else {
			System.out.println("ClannLog: Dao.updateHit 실패");
		}
		ss.close();
		return result;
	}
	
}
