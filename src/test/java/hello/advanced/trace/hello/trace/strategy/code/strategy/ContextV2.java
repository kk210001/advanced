package hello.advanced.trace.hello.trace.strategy.code.strategy;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV2 {

    private Strategy strategy;


    public void execute(Strategy strategy) {
        long startTime = System.currentTimeMillis();

        strategy.call(); // 위임

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }
}
