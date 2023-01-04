package hello.advanced.trace.hello.trace.threadloca;

import hello.advanced.trace.hello.trace.threadloca.code.FieldService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;


@Slf4j
public class FieldServiceTest {
    private FieldService fieldService = new FieldService();

    @Test
    void field() throws InterruptedException {
        log.info("main start");
        Runnable userA = () ->{
            fieldService.logic("userA");
        };

        Runnable userB = () ->{
            fieldService.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");
        
        threadA.start();
        sleep(100); //대기시간 1초 보다 짦으면 동시성 문제 발생
        threadB.start();

        sleep(3000); //메인 쓰레드 종료 대기
        log.info("main exit");
    }


    private void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
