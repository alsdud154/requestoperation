package kr.co.velnova.requestoperation.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/*
* Filter를 사용하여 HttpServletRequest 조작
* */
@Component
public final class TestFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        TestRequestWrapper testRequestWrapper = new TestRequestWrapper((HttpServletRequest) request);

        testRequestWrapper.setParameter("lang", "ko");
        testRequestWrapper.setParameter("name", "velnova");

        chain.doFilter(testRequestWrapper, response);
    }

    public void destroy() {
    }

    public void init(FilterConfig filterConfig) {
    }
}

