package com.jafa.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jafa.domain.BoardVO;
import com.jafa.domain.Criteria;

@Repository
public class BoardDao {
		
	JdbcTemplate jdbcTemplate; 
	
	@Autowired
	public BoardDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	RowMapper<BoardVO> rowMapper =
			(rs, rowNum) -> BoardVO.builder() 
						.bno(rs.getLong("bno"))
						.title(rs.getString("title"))
						.content(rs.getString("content"))
						.writer(rs.getString("writer"))
						.writeDate(rs.getDate("writeDate"))
						.build();
	
	public List<BoardVO> list(Criteria criteria){
		String sql = "SELECT RN,BNO,TITLE,CONTENT,WRITER,WRITEDATE FROM";
		sql +=" (SELECT /*+INDEX_DESC(BOARD_PAGING PK_BOARD)*/ ";
		sql +=" ROWNUM AS RN, BNO, TITLE, CONTENT,WRITER,WRITEDATE        ";
		sql +=" FROM BOARD_PAGING WHERE ROWNUM <= ?) WHERE RN > ?";
		int minrow = (criteria.getPageNum()-1)*criteria.getAmount(); 
		int maxrow = criteria.getAmount()*criteria.getPageNum(); 
		return jdbcTemplate.query(sql, rowMapper,maxrow,minrow);
	}
	
	public int totalCount() {
		return jdbcTemplate.queryForObject(
				"select count(*) from board_paging", Integer.class);
	}
	
	public BoardVO detail(Long bno) {
		String sql = "select * from board_paging where bno=?";
		return jdbcTemplate.queryForObject(sql, rowMapper,bno);
	}
}
