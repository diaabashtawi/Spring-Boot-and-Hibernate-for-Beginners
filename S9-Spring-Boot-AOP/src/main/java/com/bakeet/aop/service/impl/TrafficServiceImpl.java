package com.bakeet.aop.service.impl;

import com.bakeet.aop.service.TrafficService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


@Service
public class TrafficServiceImpl implements TrafficService {

    @Override
    public String getTraffic(boolean exceptionThrown) {
        if (exceptionThrown){
            throw new RuntimeException("Exception thrown High Traffic on API call");
        }
        return getTraffic();
    }

    @Override
    public String getTraffic() {
        try{
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        return "Expect heavy traffic on your API ";
    }
}
