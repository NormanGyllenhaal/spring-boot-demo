package site.lovecode.boot.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import site.lovecode.boot.util.ApiResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yang peng on 2016/9/30.
 */
@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ApiResponse<Object> defaultErrorHandler(HttpServletRequest req, Exception e) {
        ApiResponse<Object> apiResponse = new ApiResponse<>();
        apiResponse.setCode(500);
        apiResponse.setError("service error");
        return apiResponse;
    }
}
