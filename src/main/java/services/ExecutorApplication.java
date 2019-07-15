package services;

import org.apache.log4j.Logger;
import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class ExecutorApplication extends Application {

	private static final Logger LOG = Logger.getLogger(ExecutorApplication.class);
	
	public synchronized Restlet createInboundRoot() {
		
		LOG.info("start create inbound route");
		
		Router router = new Router(getContext());

		router.attach("/executor/{timeout}", ExecutorResource.class);

		return router;
	}
}
