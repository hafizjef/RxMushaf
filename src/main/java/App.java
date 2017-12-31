import static spark.Spark.get;
import static spark.Spark.port;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import model.ImageModel;
import spark.servlet.SparkApplication;
import controller.ProcessImages;

public class App implements SparkApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	
    public static void main(String args[]) throws InterruptedException {
    	port(8888);
    	
    	get("/", (req, res) -> {
    		
    		
    		ImageModel img = new ImageModel(new File("data/test.jpg"));
    		
    		Observable.just(img)
    			.observeOn(Schedulers.computation())
    			.doOnComplete(() -> { logger.info("DONE");; })
    			.subscribe(ProcessImages::doProcess, e -> {
    				logger.error(e.getMessage());
    			});
    		
    		logger.error("APP STARTED");
    		return "Hello";
		});
    }

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
}
