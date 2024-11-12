package spring_mvc_crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import spring_mvc_dao.EmployeeDao;
import spring_mvc_dto.EmployeeDto;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeDao employeeDao;
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(@ModelAttribute EmployeeDto employeeDto) {
		//System.out.println(employeeDto);
		employeeDao.insert(employeeDto);
		return "data inserted successfully";
	}
	
	@RequestMapping("/fetchbyid")
	@ResponseBody
	public ModelAndView fetchbyid(@RequestParam int id) {
		//System.out.println(id);
		EmployeeDto employeeDto=employeeDao.fetchbypk(id);
		ModelAndView view=new ModelAndView("fetchbyid.jsp");
		view.addObject("data",employeeDto);
		return view;
	}
	
	@RequestMapping("/deletebyid")
	@ResponseBody
	public String deletebyid(@RequestParam int id) {
	  String msg=employeeDao.deletebypk(id);
		return msg;
	}
	
	@RequestMapping("/deleteall")
	@ResponseBody
	public String delete() {
		String msg=employeeDao.delete();
		return msg;
	}
	
	@RequestMapping("/fetchall")
	@ResponseBody
	public ModelAndView fetchall() {
		List<EmployeeDto> list =employeeDao.fetchAll();
		System.out.println(list);
		ModelAndView view=new ModelAndView("fetchall.jsp");
		view.addObject("abc",list);
		return view;
		//System.out.println(list);
	}
	
}
