package cat.component;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BabysitterComponent {
    @Scheduled(cron="*/10 * * * * *")
    public void getbabysitter(){
        // System.out.println("cron schedule");
    }
    
}
