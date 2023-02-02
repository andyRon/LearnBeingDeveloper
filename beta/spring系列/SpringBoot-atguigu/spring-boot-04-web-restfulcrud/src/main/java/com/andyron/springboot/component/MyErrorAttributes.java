package com.andyron.springboot.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * 给容器中加入自定义的ErrorAttributes
 *
 * @author Andy Ron
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    // 返回值的map就是页面和json能获取的所有字段
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("company", "andyron");

        // 我们的异常处理器携带的数据
        Object ext = webRequest.getAttribute("ext", 0);
        map.put("ext", ext);
        return map;
    }


}
