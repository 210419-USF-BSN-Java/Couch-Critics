package com.revature.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.jboss.logging.Logger;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import com.revature.model.Users;

@Component
@Aspect
@EnableAspectJAutoProxy
public class ServiceAspects {
	private static Logger LOG = Logger.getLogger(ServiceAspects.class);
	
	@AfterThrowing(pointcut="execution(* com.revature.service.*.*(..))", throwing="ex")
	public void logServiceException(JoinPoint jp,Exception ex) {
		LOG.error(jp.getSignature() + " threw " + ex.getClass());
		//System.out.println("There was an ex");
	}
	
	@AfterThrowing(pointcut="execution(* com.revature.controller.*.*(..))", throwing="ex")
	public void logControllerException(JoinPoint jp,Exception ex) {
		LOG.error(jp.getSignature() + " threw " + ex.getClass());
		//System.out.println("There was an ex");
	}
	
	@Before("execution(* com.revature.controller.*.*(..))")
	public void logBeforeService(JoinPoint jp) {
		LOG.info(jp.getTarget() + " called " + jp.getSignature());
		//System.out.println("Print before");
	}
	
	@AfterReturning(pointcut="execution(* com.revature.service.*.get*(..))", returning="retVal")
	public void logGetReviews(Object retVal) {
		LOG.info(retVal.getClass() + " was returned.");
		//System.out.println("After returning");
	}
	
	//Users

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
		LOG.info("User " + u.getUsername() + " was added.");
	}
	
	@AfterReturning(pointcut="execution(* com.revature.service.UsersService.update*(..))", returning="retVal")
	public void logUpdateUser(Users retVal) {
		Users u = retVal;
		LOG.info("User " + u.getUsername() + " was updated.");
	}
	
	//Reviews
	
//	@AfterReturning(pointcut="execution(* com.revature.service.ReviewService.get*(..))", returning="retVal")
//	public void logGetReviews(Object retVal) {
//		LOG.info("Reviews were returned.");
//	}
	
	@AfterReturning(pointcut="execution(* com.revature.service.ReviewService.add*(..))", returning="retVal")
	public void logAddReview(Object retVal) {
		LOG.info("A new Review was added.");
	}
	
	@AfterReturning(pointcut="execution(* com.revature.service.ReviewService.delete*(..))", returning="retVal")
	public void logDeleteReview(Object retVal) {
		LOG.info("A new Review was deleted.");
	}
	
	//Discussion
	
//	@AfterReturning(pointcut="execution(* com.revature.service.DiscussionService.get*(..))", returning="retVal")
//	public void logGetDiscussion(Object retVal) {
//		LOG.info("Discussions were returned.");
//	}
	
	@AfterReturning(pointcut="execution(* com.revature.service.DiscussionService.add*(..))", returning="retVal")
	public void logAddDiscussion(Object retVal) {
		LOG.info("A new Discussion was added.");
	}
	
}
