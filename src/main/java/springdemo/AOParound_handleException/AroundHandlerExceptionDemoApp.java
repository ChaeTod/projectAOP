package springdemo.AOParound_handleException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springdemo.AOParound_handleException.DemoConfig;
import springdemo.AOParound_handleException.Service.TrafficFortuneService;

import java.util.logging.Logger;

public class AroundHandlerExceptionDemoApp {

    private static Logger logger = Logger.getLogger(AroundHandlerExceptionDemoApp.class.getName());

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        logger.info("Main Program: AroundDemoApp");

        logger.info("Calling getFortune");

        boolean tripWire = true;
        String data = trafficFortuneService.getFortune(tripWire);  // main app will never know about the exception, because it has been handled in around advice already

        logger.info("My fortune is: " + data);

        logger.info("Finished");

        // close the context
        context.close();
    }
}
