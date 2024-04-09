package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.Sellerdao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Sellerdao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== Teste 1: seller findbyId ===");
		
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
		System.out.println("\n=== Teste 2: seller findbyId ===");
		Department department = new Department (2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Teste 3: seller findbyId ===");
		list = sellerDao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		//System.out.println("\n=== Teste 4: seller insert ===");
		//Seller newseller = new Seller(null, "Greg", "gregGmail", new Date(), 4000.0, department);
		//sellerDao.insert(newseller);
		//System.out.println("Inserted. New ID = " + newseller.getId());
		
		System.out.println("\n=== Teste 5: seller update ===");
		seller = sellerDao.findById(1);
		seller.setName("Marta Waine");
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		System.out.println("\n=== Teste 6: seller delete ===");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteByid(id);
		sc.close();
	}
}