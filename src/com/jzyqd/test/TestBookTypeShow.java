package com.jzyqd.test;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.jzyqd.dao.IBookTypeDAO;
import com.jzyqd.dao.impl.BookTypeDAOImpl;
import com.jzyqd.entity.BookType;


public class TestBookTypeShow {
	public static void main(String[] args) {
		Map<BookType, List<BookType>> types = new Hashtable<BookType, List<BookType>>();
		
		IBookTypeDAO bookTypeDAO = new BookTypeDAOImpl();
		List<BookType> fuqins = bookTypeDAO.findByParentId(0);
		for (BookType fuqin : fuqins) {
			List<BookType> erzi = bookTypeDAO.findByParentId(fuqin.getBookTypeId());
			types.put(fuqin, erzi);
		}
		
		Set<BookType>  fqs  = types.keySet();
		for (BookType bookType : fqs) {
			System.out.println(bookType.getBookTypeId() + " " + bookType.getBookTypeName());
			System.out.println("=======");
			List<BookType> sons = types.get(bookType);
			for (BookType son : sons) {
				System.out.println(son);	
			}
			System.out.println("-----------------------------------------");
			
		}
		
		
		
		
		
		
	}
	
}
