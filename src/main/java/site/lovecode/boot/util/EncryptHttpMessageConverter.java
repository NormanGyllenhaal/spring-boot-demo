package site.lovecode.boot.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.google.common.io.CharStreams;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.*;
import java.lang.reflect.Type;

import static java.lang.System.out;


/**
 * Created by yang peng on 2016/9/30.
 */
public class EncryptHttpMessageConverter extends FastJsonHttpMessageConverter {

    @Override
    public Object read(Type type, Class<?> contextClass, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        String json = decryptJson(inputMessage);
        return JSON.parseObject(json, type, getFastJsonConfig().getFeatures());
    }



    @Override
    protected Object readInternal(Class<? extends Object> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        String json = decryptJson(inputMessage);
        return JSON.parseObject(json,clazz,getFastJsonConfig().getFeatures());
    }


    @Override
    protected void writeInternal(Object obj, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        HttpHeaders headers = outputMessage.getHeaders();
        headers.setContentType(MediaType.TEXT_HTML);
        ByteArrayOutputStream outnew = new ByteArrayOutputStream();
        String json = JSON.toJSONString(obj);
        String encrypt = DesUtil.encrypt(json);
        OutputStream out = outputMessage.getBody();
        outnew.write(encrypt.getBytes());
        outnew.writeTo(out);
        outnew.close();
    }


    private String decryptJson(HttpInputMessage inputMessage)  throws IOException, HttpMessageNotReadableException  {
        InputStream in = inputMessage.getBody();
        String text = CharStreams.toString(new InputStreamReader(in, "UTF-8"));
        JSONObject jsonObject = JSON.parseObject(text);
        String json = DesUtil.decrypt(jsonObject.getString("json"));
        out.println("解析json-----------------"+json);
        return json;
    }
}
