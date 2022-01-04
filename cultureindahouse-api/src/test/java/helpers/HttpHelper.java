package helpers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.var;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.CategoryVO;

import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.lang.reflect.Type;

public class HttpHelper {


    public static <T> T get(String url, Class<T> type) throws IOException {

        Gson gson = new Gson();

        HttpGet request = new HttpGet(url);

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        String jsonFromResponse = EntityUtils.toString(response.getEntity());

        T fromJson = gson.fromJson(jsonFromResponse, type);

        return fromJson;

    }


    public static <T> T put(String url, Object body, Class<T> type) throws IOException {

        Gson gson = new Gson();

        HttpPut request = new HttpPut(url);


        if (body != null){
            request.setHeader("Content-Type", MediaType.APPLICATION_JSON);
            request.setEntity(new StringEntity(gson.toJson(body)));
        }

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        String jsonFromResponse = EntityUtils.toString(response.getEntity());

        T fromJson = gson.fromJson(jsonFromResponse, type);

        return fromJson;

    }

    public static void put(String url, Object body) throws IOException {

        Gson gson = new Gson();

        HttpPut request = new HttpPut(url);


        if (body != null){
            request.setHeader("Content-Type", MediaType.APPLICATION_JSON);
            request.setEntity(new StringEntity(gson.toJson(body)));
        }

        HttpClientBuilder.create().build().execute(request);

    }

    public static <T> T post(String url, Object body, Class<T> type) throws IOException {

        Gson gson = new Gson();

        HttpPost request = new HttpPost(url);


        if (body != null){
            request.setHeader("Content-Type", MediaType.APPLICATION_JSON);
            request.setEntity(new StringEntity(gson.toJson(body)));
        }

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        String jsonFromResponse = EntityUtils.toString(response.getEntity());

        T fromJson = gson.fromJson(jsonFromResponse, type);

        return fromJson;

    }


    public static void post(String url, Object body) throws IOException {

        Gson gson = new Gson();

        HttpPost request = new HttpPost(url);


        if (body != null){
            request.setHeader("Content-Type", MediaType.APPLICATION_JSON);
            request.setEntity(new StringEntity(gson.toJson(body)));
        }

        HttpClientBuilder.create().build().execute(request);


    }


    public static void delete(String url) throws IOException {

        HttpDelete request = new HttpDelete(url);

        HttpResponse response = HttpClientBuilder.create().build().execute(request);


    }


}
