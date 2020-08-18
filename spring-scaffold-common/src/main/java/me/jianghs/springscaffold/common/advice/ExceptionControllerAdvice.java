package me.jianghs.springscaffold.common.advice;

import me.jianghs.springscaffold.common.entity.Result;
import me.jianghs.springscaffold.common.enums.ResultCode;
import me.jianghs.springscaffold.common.exception.BaseException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author jianghongsen
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<String> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 然后提取错误提示信息进行返回
        return new Result<>(ResultCode.VALIDATE_FAILED, objectError.getDefaultMessage());

    }

    @ExceptionHandler(BaseException.class)
    public Result<String> BaseExceptionHandler(BaseException e) {
        return new Result<>(ResultCode.FAILED, e.getMsg());
    }
}
