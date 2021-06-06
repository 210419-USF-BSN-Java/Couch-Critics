package com.revature.aspect;

import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import com.revature.model.Role;
import com.revature.model.Users;

@Component
@Aspect
@EnableAspectJAutoProxy
public class ServiceAspects {
	//final static Logger LOG = Logger.getLogger(ServiceAspects.class);
	final static Logger LOG = LogManager.getLogger(ServiceAspects.class);
	final static Level aopInfo = Level.forName("AOPINFO", 450);
	final static Level aopError = Level.forName("AOPERROR", 350);
	
	@AfterThrowing(pointcut="execution(* com.revature.service.*.*(..))", throwing="ex")
	public void logServiceException(JoinPoint jp,Throwable ex) {
		String message = new String(jp.getSignature() + " threw " + ex.getClass());
		LOG.log(aopError, message);
		//System.out.println("There was an ex");
	}
	
	@AfterThrowing(pointcut="execution(* com.revature.controller.*.*(..))", throwing="ex")
	public void logControllerException(JoinPoint jp,Exception ex) {
		String message = new String(jp.getSignature() + " threw " + ex.getClass());
		LOG.log(aopError, message);
		//System.out.println("There was an ex");
	}
	
	@Before("execution(* com.revature.controller.*.*(..))")
	public void logBeforeService(JoinPoint jp) {
		String message = new String(jp.getTarget() + " called " + jp.getSignature());
		LOG.log(aopInfo, message);
		//System.out.println("Print before");
	}
	
	@AfterReturning(pointcut="execution(* com.revature.controller.*.get*(..))", returning="retVal")
	public void logGetControllers(Object retVal) {
		String message = new String(retVal.getClass() + " was returned.");
		LOG.log(aopInfo, message);
		//System.out.println("After returning");
	}
	
	@AfterReturning(pointcut="execution(* com.revature.service.*.get*(..))", returning="retVal")
	public void logGetServices(Object retVal) {
		try {
			String message = new String(retVal.getClass() + " was returned.");
			LOG.log(aopInfo, message);
		} catch(Exception e) {
		}
		
	}


//	@AfterReturning(pointcut="execution(* com.revature.service.UsersService.get*(..))", returning="retVal")
//	public void logGetUser(Object retVal) {
////		Would have to add more specific point cut for returning List of Objects
////		Users u = (Users)retVal;
////		LOG.info("User " + u.getuName() + " was returned.");
//		LOG.info("User was returned.");
//	}
	
	@AfterReturning(pointcut="execution(* com.revature.service.UsersService.regist*(..))", returning="retVal")
	public void logAddUser(Users retVal) {
		Users u = retVal;
		String message = new String("User " + u.getUsername() + " was added.");
		LOG.log(aopInfo, message);
	}
	
	@AfterReturning(pointcut="execution(* com.revature.service.UsersService.update*(..))", returning="retVal")
	public void logUpdateUser(Users retVal) {
		Users u = retVal;
		String message = new String("User " + u.getUsername() + " was updated.");
		LOG.log(aopInfo, message);
  }

	
//	@AfterReturning(pointcut="execution(* com.revature.service.ReviewService.get*(..))", returning="retVal")
//	public void logGetReviews(Object retVal) {
//		LOG.info("Reviews were returned.");
//	}
	
	@AfterReturning(pointcut="execution(* com.revature.service.ReviewService.add*(..))", returning="retVal")
	public void logAddReview(Object retVal) {
		String message = new String("A new Review was added.");
		LOG.log(aopInfo, message);
	}
	
	@AfterReturning(pointcut="execution(* com.revature.service.ReviewService.delete*(..))", returning="retVal")
	public void logDeleteReview(Object retVal) {
		String message = new String("A new Review was deleted.");
		LOG.log(aopInfo, message);
	}
	
	//Discussion
	
//	@AfterReturning(pointcut="execution(* com.revature.service.DiscussionService.get*(..))", returning="retVal")
//	public void logGetDiscussion(Object retVal) {
//		LOG.info("Discussions were returned.");
//	}
	
	@AfterReturning(pointcut="execution(* com.revature.service.DiscussionService.add*(..))", returning="retVal")
	public void logAddDiscussion(Object retVal) {
		String message = new String("A new Discussion was added.");
		LOG.log(aopInfo, message);
	}
	
}
