package com.smartcity.mediators;

import org.apache.synapse.MessageContext; 
import org.apache.synapse.mediators.AbstractMediator;

public class UrlReplace extends AbstractMediator { 

	
	public boolean mediate(MessageContext context) { 

			
			var queryProperty=	context.getProperty("uri.var.q");
			if	(queryProperty == null) {
			
				context.setProperty("uri.var.q", "property bulunamadi");
				 return true;
			}
			
			var q = queryProperty.toString();
			var query =	q
						.replace("_GT", ">")
						.replace("_EQ", "==")
						.replace("_LT", "<")
						.replace("_LTE", "<=")
						.replace("_GTE", ">=")
						.replace("_NE", "!=");
			
			context.setProperty("uri.var.q", query);
		
			return true;
	}
}
