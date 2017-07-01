package ua.bulovackiy.connection;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for getting connection to http://www.rollshop.co.il/test.php
 * and sending POST request.
 *
 * @author Evgeniy Bulovackiy
 * @version 1.0
 */

public class TestPhp {
    private HttpClient client = new DefaultHttpClient();
    private String url = "http://www.rollshop.co.il/test.php";
    private HttpPost post = new HttpPost(url);
    private List<NameValuePair> pairs = new ArrayList<>();
    private HttpResponse response;
    private Document document;
    private String body;

    public String post(String value) {
        try {
            pairs.add(new BasicNameValuePair("code", value));
            post.setEntity(new UrlEncodedFormEntity(pairs));
            response = client.execute(post);
            document = Jsoup.parse(EntityUtils.toString(response.getEntity()));
            body = document.body().text();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return body;
    }
}
