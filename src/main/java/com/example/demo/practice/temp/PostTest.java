package com.example.demo.practice.temp;

import com.example.demo.vo.RequestVo;
import com.example.demo.vo.ResponseVo;
import com.google.gson.Gson;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author Li JiaWei
 * @ClassName: PostTest
 * @Description:
 * @Date: 2021/12/23 9:38
 * @Version: 1.0
 */
public class PostTest {

    public static ResponseVo sendPostRequest(String url, MultiValueMap<String,String> params) {
        RestTemplate client = new RestTemplate();
        return null;
    }

    public static void main(String[] args) {
        String uri = "http://192.168.145.36:9999/userpost";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        RequestVo request = new RequestVo();
        request.setName("璐璐");
        Gson gson = new Gson();
        String s = gson.toJson(request);
        System.out.println(s);

        HttpEntity<String> requestString = new HttpEntity<>(s,httpHeaders);
//        ResponseEntity<String> responseEntity = restTemplate.postForEntity(uri, requestString, String.class);
//        String body = responseEntity.getBody();
//        ResponseVo responseVo = gson.fromJson(body,ResponseVo.class);
        ResponseVo responseVo = restTemplate.postForEntity(uri,requestString,ResponseVo.class).getBody();
        System.out.println();
        System.out.println(responseVo);
    }
}
