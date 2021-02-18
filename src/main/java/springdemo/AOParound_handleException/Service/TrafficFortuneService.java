package springdemo.AOParound_handleException.Service;

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

    public String getFortune(boolean tripWire) {

        if (tripWire){
            throw new RuntimeException("Major accident! Highway is closed!");
        }

        return getFortune(); // call out other getFortune() method #reuse
    }
}
