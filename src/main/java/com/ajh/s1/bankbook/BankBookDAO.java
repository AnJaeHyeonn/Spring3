package com.ajh.s1.bankbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

public class BankBookDAO {

	@Autowired
	private DataSource dataSource;

	public BankBookDTO getSelect(BankBookDTO bankBookDTO) {

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		BankBookDTO bbDTO = null;

		try {

			String sql = "SELECT * FROM BANKBOOK WHERE BOOKNUMBER=?";

			con = dataSource.getConnection();

			st = con.prepareStatement(sql);
			st.setLong(1, bankBookDTO.getBookNumber());
			rs = st.executeQuery();

			if (rs.next()) {
				bbDTO = new BankBookDTO();

				bbDTO.setBookNumber(rs.getLong("bookNumber"));
				bbDTO.setBookName(rs.getString("bookName"));
				bbDTO.setBookRate(rs.getDouble("bookRate"));
				bbDTO.setBookSale(rs.getInt("bookSale"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}

		return bbDTO;

	}

	public ArrayList<BankBookDTO> getList() {

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		BankBookDTO bbDTO = null;

		ArrayList<BankBookDTO> ar = new ArrayList<BankBookDTO>();

		try {
			String sql = "SELECT * FROM BANKBOOK";

			con = con = dataSource.getConnection();
			st = con.prepareStatement(sql);
			rs = st.executeQuery();

			while (rs.next()) {
				bbDTO = new BankBookDTO();

				bbDTO.setBookNumber(rs.getLong("bookNumber"));
				bbDTO.setBookName(rs.getString("bookName"));
				bbDTO.setBookRate(rs.getDouble("bookRate"));
				bbDTO.setBookSale(rs.getInt("bookSale"));

				ar.add(bbDTO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}

		return ar;

	}

	public int setInsert(BankBookDTO bankBookDTO) {

		Connection con = null;
		PreparedStatement st = null;

		int result = 0;

		try {
			con = con = dataSource.getConnection();

			String sql = "INSERT INTO BANKBOOK VALUES(BANKBOOK_SEQ.NEXTVAL,?,?,?)";

			st = con.prepareStatement(sql);

			st.setString(1, bankBookDTO.getBookName());
			st.setDouble(2, bankBookDTO.getBookRate());
			st.setInt(3, bankBookDTO.getBookSale());

			result = st.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return result;
	}

}
