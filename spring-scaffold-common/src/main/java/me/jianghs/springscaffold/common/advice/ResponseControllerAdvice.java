package me.jianghs.springscaffold.common.advice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.jianghs.springscaffold.common.entity.Result;
import me.jianghs.springscaffold.common.exception.BaseException;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @className: ResponseControllerAdvice
 * @description:
 * @author: jianghs430
 * @createDate: 2020/8/18 10:25
 * @version: 1.0
 */
@RestControllerAdvice(basePackages = {"me.jianghs.springscaffold.web.api"})
public class ResponseControllerAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return !methodParameter.getGenericParameterType().equals(Result.class);
    }

    @Override
    public Object beforeBodyWrite(Object data, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (methodParameter.getGenericParameterType().equals(String.class)) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                // 将数据包装在Result里后，再转换为json字符串响应给前端
                return objectMapper.writeValueAsString(new Result<>(data));
            } catch (JsonProcessingException e) {
                throw new BaseException("返回String类型错误");
            }
        }
        // 将原本的数据包装在Result里
        return new Result<>(data);
    }
}
