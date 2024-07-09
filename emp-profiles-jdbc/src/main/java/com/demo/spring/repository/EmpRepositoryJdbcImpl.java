package com.demo.spring.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.entity.Emp;

@Repository
public class EmpRepositoryJdbcImpl implements EmpRepository {

	private String insert_one = "insert into emp(empno, name,address,salary) values(?,?,?,?)";

	private String select_one = "select * from emp where empno=";

	@Autowired
	JdbcTemplate jt;

	@Override
	public String save(Emp e) {

		int count = jt.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pst = con.prepareStatement(insert_one);
				pst.setInt(1, e.getEmpId());
				pst.setString(2, e.getName());
				pst.setString(3, e.getCity());
				pst.setDouble(4, e.getSalary());
				return pst;
			}
		});

		return "Rows Inserted " + count;
	}

	@Override
	public Emp findById(int id) {
		
		Emp e=jt.queryForObject(select_one+id, new RowMapper<Emp>() {
			@Override
			public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return new Emp(rs.getInt("empno"), rs.getString("name"), rs.getString("address"),
						rs.getDouble("salary"));
			}
		});
		/*Emp e=jt.query(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pst = con.prepareStatement(select_one);
				pst.setInt(1, id);
				return pst;

			}
		}, new ResultSetExtractor<Emp>() {
			@Override
			public Emp extractData(ResultSet rs) throws SQLException, DataAccessException {

				return new Emp(rs.getInt("empno"), rs.getString("name"), rs.getString("address"),
						rs.getDouble("salary"));
			}
		});*/
		return e;
	}

	@Override
	public List<Emp> findAllEmps() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public int addMany(List<Emp> empList) {
		int count=0;
		for(Emp e:empList) {
			int row = jt.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement pst = con.prepareStatement(insert_one);
					pst.setInt(1, e.getEmpId());
					pst.setString(2, e.getName());
					pst.setString(3, e.getCity());
					pst.setDouble(4, e.getSalary());
					return pst;
				}
			});
			count=count+row;
		}
		return count;
	}

}
