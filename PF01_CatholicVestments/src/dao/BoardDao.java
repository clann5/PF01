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
		System.out.println("ss 호출전");
		
		System.out.println(" factory : " + factory);
		

		SqlSession ss = factory.openSession();
		System.out.println("ss 호출후");
		List<BoardDto> list = ss.selectList("mybatis.mapper.board.selectBoardList");
		ss.close();
		System.out.println("ClannLog: Dao.SelectBoardList 호출");
		return list;
	}
	
	// 2.selectBoardByNo
	public BoardDto selectBoardByNo() {
		SqlSession ss = factory.openSession();
		BoardDto boardDto = ss.selectOne("mybatis.mapper.board.selectBoardByNo");
		ss.close();
		System.out.println("ClannLog: Dao.SelectBoardByNo 호출");
		return boardDto;
	}
	
	// 3.insertBoard
	public int insertBoard() {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert("mybatis.mapper.board.insertBoard");
		if (result > 0) {
			ss.commit();
			System.out.println("ClannLog: Dao.insertoard 성공");
		} else {
			System.out.println("ClannLog: Dao.insertoard 실패");
		}
		return result;
	}
	
	// 4. updateBoard
	
	// 5. deleteBoard
}
