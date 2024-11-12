package spring_mvc_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import spring_mvc_dto.EmployeeDto;

@Component
public class EmployeeDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public void insert(EmployeeDto employeeDto) {
		entityTransaction.begin();
		entityManager.persist(employeeDto);
		entityTransaction.commit();
	}
	public EmployeeDto fetchbypk(int pk) {
		EmployeeDto employeeDto=entityManager.find(EmployeeDto.class, pk);
		System.out.println(employeeDto);
		if(employeeDto!=null) {
			return employeeDto;
		}else 
			return null;
	}
	public String deletebypk(int pk) {
		EmployeeDto employeeDto=entityManager.find(EmployeeDto.class, pk);
		if(employeeDto!=null) {
			entityTransaction.begin();
			entityManager.remove(employeeDto);
			entityTransaction.commit();
			return "data deleted";
		}else {
			return "no data found";
			
		}
	}
	public String delete() {
		//select variable from table name(entity/dto class name) variable
		 Query q=entityManager.createQuery("select a from EmployeeDto a");
		  List<EmployeeDto>list=q.getResultList();
		 if(list.isEmpty()) {
			 return "no data found";
		 }else {
			 for(EmployeeDto a : list) {
				 entityTransaction.begin();
				 entityManager.remove(a);
				 entityTransaction.commit();
			 }
			 return "data deleted successfully";
		 }
	}
	public List<EmployeeDto> fetchAll(){
		Query q=entityManager.createQuery("select a from EmployeeDto a");
		 List<EmployeeDto> list=q.getResultList();
		 return list;	
	}
		

}
