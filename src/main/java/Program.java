import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by Adeola.Ojo on 7/16/2016.
 */
@SpringBootApplication
@EnableScheduling
public class Program {

    public static void main(String[] args) {
        SpringApplication.run(Program.class);
    }

}
