package com.revature.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DiscussionAspects {
	private static Logger LOG = Logger.getLogger(DiscussionAspects.class);

	@AfterReturning(pointcut="execution(* com.revature.service.DiscussionService.get*(..))", returning="retVal")
	public void logGetListSuccess(Object retVal) {
		LOG.info("Discussions were returned.");
	}
	
//	@AfterReturning(pointcut="execution(Discussion get*(..))", returning="retVal")
//	public void logGetSuccess(Object retVal) {
//		LOG.info("A Discussion was returned.");
//	}
//	
//	@AfterReturning(pointcut="execution(Discussion add*(..))", returning="retVal")
//	public void logAddSuccess(Object retVal) {
//		LOG.info("A new Discussion was added.");
//	}
}
