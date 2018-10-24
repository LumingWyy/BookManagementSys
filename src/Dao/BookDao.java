package Dao;

import java.util.List;

import Entity.Book;

public interface BookDao {
		public int addBook(Book b);

		public int delBook(int id);

		public int updateBook(Book b);

		public Book findBookById(int id);
		
		public List<Book> findBookByName(String name);
		
		public List<Book> getAllBook();

	}

