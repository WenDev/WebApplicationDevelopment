package site.wendev.qikebao.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import site.wendev.qikebao.common.Response;

/**
 * @author 江文
 * @since 2020/11/23 7:16 下午
 */
@Slf4j
@Aspect
@Component
public class ControllerExceptionAop {
    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    public void controllerPointCut() {}

    @Around("controllerPointCut()")
    public Response handleControllerException(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        Response response;

        try {
            response = (Response) pjp.proceed();
            long elapsedTime = System.currentTimeMillis() - startTime;
            log.info("Method [{}] use time: {}", pjp.getSignature(), elapsedTime);
        } catch (Throwable throwable) {
            long elapsedTime = System.currentTimeMillis() - startTime;
            log.error("Resolved [{}] exception in [{}]", throwable.toString(), pjp.getSignature());
            log.error("Exception use time: [{}]", elapsedTime);

            // 抛出，交给ControllerExceptionHandler处理
            throw throwable;
        }

        return response;
    }
}
