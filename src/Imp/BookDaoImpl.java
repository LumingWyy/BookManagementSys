package Imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.BaseDao;
import Dao.BookDao;
import Entity.Book;

public class BookDaoImpl extends BaseDao implements BookDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public int addBook(Book book) {
		int num = 0;
		String sql = "insert into book(id,name,author,borrowerid) values(?,?,?,?)";
		try {
			num = executeUpdate(sql, book.getId(), book.getName(), book.getAuthor(), book.getBorrowerId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public int delBook(int id) {
		int num = 0;
		String sql = "delete from book where id=?";
		try {
			num = executeUpdate(sql, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public int updateBook(Book book) {
		int num = 0;
		String sql = "update book set name=?,author=?,borrowerid=? where id=?";
		try {
			num = executeUpdate(sql, book.getName(), book.getAuthor(), book.getBorrowerId(),book.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public Book findBookById(int id) {
		Book book = null;
		String sql = "select * from book where id=?";
		rs = executeQuery(sql, id);
		try {
			if (rs.next()) {
				book = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public List<Book> getAllBook() {
		List<Book> ulist = new ArrayList<Book>();
		String sql = "select * from book";
		rs = executeQuery(sql);
		try {
			while (rs.next()) {
				Book book = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				ulist.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ulist;
	}

	@Override
	public List<Book> findBookByName(String name) {
		List<Book> ulist = new ArrayList<Book>();
		String sql = "select * from book where name=?";
		rs = executeQuery(sql, name);
		try {
			while (rs.next()) {
				Book book = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				ulist.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ulist;
	}

}
