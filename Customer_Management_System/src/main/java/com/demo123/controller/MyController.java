package com.demo123.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo123.dao.UserDAO;
import com.demo123.dto.User;

@Controller
public class MyController {
	@RequestMapping(value = "/ulogind",method = RequestMethod.GET)
	public String redlogin()
	{
		return "ulogin";
	}
	
	@RequestMapping(value = "/logout",method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse responses)
	{

		
		HttpSession session = request.getSession();
		session.invalidate();
		return "ulogin";
	}
	
	@RequestMapping(value = "/home",method = RequestMethod.GET)
	public ModelAndView Home()
	{
		ModelAndView mv = new ModelAndView();
		
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		UserDAO ud=(UserDAO) ctx.getBean("udao");
		  List<User> l2=ud.UserList();
		     System.out.println(l2.isEmpty());
		     if(!l2.isEmpty())
		     {
		    	 
		 		mv.setViewName("ahome");
		 		mv.addObject("users", l2);

		 		
		     }
		
			
		     return mv;
	}
	
	
	@RequestMapping(value = "/alogind",method = RequestMethod.GET)
	public String redalogin()
	{
		return "alogin";
	}
	@RequestMapping(value="/signup", method=RequestMethod.POST)  
    public String usignUp(User ref,HttpServletRequest request, HttpServletResponse response) {  
		

		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		UserDAO ud=(UserDAO) ctx.getBean("udao");
		if(ud.saveUser(ref))
		{
			return "ulogin";
		}
		else {
			return "uregistererror";
		}
     }
	
	

	@RequestMapping(value = "/alogin", method=RequestMethod.POST)
	public ModelAndView alogin(@RequestParam(name = "username") String username,@RequestParam(name = "password") String password
			,HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mv = new ModelAndView();

		String s=null;
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		UserDAO ud=(UserDAO) ctx.getBean("udao");
		
		
			if(username.equals("admin@gmail.com") && password.equals("admin"))
			{
			     List<User> l2=ud.UserList();
			     System.out.println(l2.isEmpty());
			     if(!l2.isEmpty())
			     {
			    	 
			 		mv.setViewName("ahome");
			 		mv.addObject("users", l2);

			 		
			     }
			
				
			     return mv;
			
			}
			else {
				mv.setViewName("alogin");
				return mv;
			}
		}
		
	
	
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String ulogin(@RequestParam(name = "username") String username,@RequestParam(name = "password") String password
			,HttpServletRequest request, HttpServletResponse response)
	{
		String s=null;
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		UserDAO ud=(UserDAO) ctx.getBean("udao");
		
		User u= new User();
		u.setUsername(username);
		u.setPassword(password);
		List<User> l=ud.checkUser(u);
		if(!l.isEmpty())
		{
			
				HttpSession session = request.getSession();
				session.setAttribute("username",l.get(0).getUsername());
				session.setAttribute("name", l.get(0).getName());
				session.setAttribute("mobile", l.get(0).getMobile());
				session.setAttribute("city", l.get(0).getCity());
				session.setAttribute("age", l.get(0).getAge());
				return "uhome";
			
			
		}
		else {
			
			return "ulogin";
		}
	
	}
	
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)  
    public ModelAndView delete(@RequestParam(name = "uid") long id
    		,HttpServletRequest request, HttpServletResponse response) {  
		

		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		UserDAO ud=(UserDAO) ctx.getBean("udao");
		ModelAndView mv = new ModelAndView();
		if(ud.deleteUser(id))
		{
			  List<User> l2=ud.UserList();
			     System.out.println(l2.isEmpty());
			     if(!l2.isEmpty())
			     {
			    	 
			 		mv.setViewName("ahome");
			 		mv.addObject("users", l2);

			 		
			     }
			
				
			     return mv;
		}
		else {
		    mv.setViewName("ahomedeleteerror");
		    return mv;
		}
     }
	
	
	@RequestMapping(value="/update", method=RequestMethod.POST)  
    public ModelAndView update(User ref
    		,HttpServletRequest request, HttpServletResponse response) {  
		

		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		UserDAO ud=(UserDAO) ctx.getBean("udao");
		ModelAndView mv = new ModelAndView();
		if(ud.updateUser(ref))
		{
			  List<User> l2=ud.UserList();
			     System.out.println(l2.isEmpty());
			     if(!l2.isEmpty())
			     {
			    	 
			 		mv.setViewName("ahome");
			 		mv.addObject("users", l2);

			 		
			     }
			
				
			     return mv;
		}
		else {
		    mv.setViewName("ahomedeleteerror");
		    return mv;
		}
     }
	
	
	@RequestMapping(value="/searchuser" , method=RequestMethod.POST)
	public ModelAndView search(@RequestParam(name = "name") String name,
			HttpServletRequest request, HttpServletResponse response)
	{

		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		UserDAO ud=(UserDAO) ctx.getBean("udao");
		ModelAndView mv = new ModelAndView();
		List<User> l=ud.searchUser(name);

	     List<User> l2=ud.UserList();
		if(!l.isEmpty())
		{	
			mv.setViewName("ahomesucces");
 		    mv.addObject("usearchresult", l);
 		    mv.addObject("users",l2);
		}
		else
		{
			    mv.setViewName("ahome");
			  
			}
		
	return mv;
	}
}
