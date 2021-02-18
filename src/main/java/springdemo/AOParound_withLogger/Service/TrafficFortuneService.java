package springdemo.AOParound_withLogger.Service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {

    public String getFortune(){

        // simulate a delay
        try {
            TimeUnit.SECONDS.sleep(5); // sleep for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // return a fortune
        return "Expect heavy traffic this morning";

    }
}
