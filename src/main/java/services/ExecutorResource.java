package services;

import org.apache.log4j.Logger;
import org.restlet.data.Status;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import java.util.Date;
import java.util.concurrent.*;

public class ExecutorResource extends ServerResource {

    private static final Logger LOG = Logger.getLogger(ExecutorResource.class);
    private CompletableFuture<Void> future;

    @Get
    public String represent() {
        long startTime = new Date().getTime();
        try {
            String sTimeout = getAttribute("timeout");
            Long timeout = Long.valueOf(sTimeout);
            ExecutorService executor = Executors.newCachedThreadPool();
            Callable<Void> task = new Callable<Void>() {
                @Override
                public Void call() throws Exception {
                    while(true);
                }
            };
            Future<Void> futureResult = executor.submit(task);
            Void result = futureResult.get(timeout, TimeUnit.SECONDS);
            future.complete(result);
            setStatus(Status.SUCCESS_OK);
            long finishTime = new Date().getTime();
            long totalTime = finishTime - startTime;
            return "OK - Total Time: " + totalTime + " ms";
        } catch (Exception e) {
            e.printStackTrace();
            setStatus(Status.SERVER_ERROR_INTERNAL);
        }
        long finishTime = new Date().getTime();
        long totalTime = finishTime - startTime;
        return "ERROR - Total Time: " + totalTime + " ms";
    }

}
