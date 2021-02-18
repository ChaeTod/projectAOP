package springdemo.AOParound;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springdemo.AOParound.Service.TrafficFortuneService;

public class AroundDemoApp {
    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("Main Program: AroundDemoApp");

        System.out.printf("Calling getFortune");

        String data = trafficFortuneService.getFortune();

        System.out.println("My fortune is: " + data);

        System.out.println("Finished");

        // close the context
        context.close();
    }
}
