package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.creatDepartmentDao();
		
		System.out.println("=== TEST 1: Department findById ===");
		Department department = departmentDao.findbyId(3);
		System.out.println(department);
		
		
		System.out.println("\n=== TEST 2: seller findAll ===");
		List<Department> list = new ArrayList<>();
		list = departmentDao.findAll();
		
		for(Department obj: list) {
			System.out.println(obj);
		}
		
		
		System.out.println("\n=== TEST 3: Department Insert");
		department = new Department(null, "Office");
		departmentDao.insert(department);
		System.out.println("Inserted! New id = " + department.getId());

		
		System.out.println("\n=== TEST 4: Department Update ===");
		department = departmentDao.findbyId(4);
		department.setName("Lab");
		departmentDao.update(department);
		System.out.println("Update completed!");
		
		
		System.out.println("\n=== TEST 5: Department Delete ===");
		System.out.print("Enter id for delete: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete Completed!");
		
		
		sc.close();

	}

}
