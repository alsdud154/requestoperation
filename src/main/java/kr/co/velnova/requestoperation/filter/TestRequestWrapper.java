package kr.co.velnova.requestoperation.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/*
* HttpServletRequestWrapper를 사용
* HttpServletRequest의 parameter 기능 재정의 및 추가
* @Override는 HttpServletRequest의 제공되는 함수를 선언한 Map으로 재정의 함
* */
public class TestRequestWrapper extends HttpServletRequestWrapper {

    // request parameterMap에 데이터를 조작하기 위해 Map 선언
    private final Map<String, String[]> parameterMap;

    public TestRequestWrapper(HttpServletRequest request) {
        super(request);
        // 생성자를 통해 request parameterMap 값을 선언한 Map으로 복사
        parameterMap = new HashMap<>(request.getParameterMap());

    }

    // request에는 setParameter가 없지만 새로운 함수를 선언하여 조작 가능
    public void setParameter(String key, String value){
        parameterMap.put(key, new String[]{value});
    }

    @Override
    public String getParameter(String name) {
        String[] values = getParameterValues(name);

        if (values != null && values.length > 0){
            return values[0];
        }

        return null;
    }


    @Override
    public Map<String, String[]> getParameterMap() {
        return parameterMap;
    }

    @Override
    public Enumeration<String> getParameterNames() {
        return Collections.enumeration(parameterMap.keySet());
    }

    @Override
    public String[] getParameterValues(String name) {
        return (String[]) parameterMap.get(name);
    }

}