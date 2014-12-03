package cn.flower.tick.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

public class HttpClientUtil {

	/**
	 * 发送POST 请求
	 * @param uri
	 * @param header
	 * @return
	 */
	public static String sendPostRequest(URI uri, Map<String, String> params) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpClientContext context = HttpClientContext.create();
		HttpPost httpPost = getHttpPost(uri, params);
		CloseableHttpResponse response = null;
		String responseContent = null;
		try {
			response = httpClient.execute(httpPost, context);
			HttpEntity entity = handleResponse(response);
			responseContent = getContent(entity);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(response != null)
					response.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		return responseContent;
	}
	
	/**
	 * 创建HttpPost对象，用于Post请求
	 * @param uri
	 * @param params
	 * @return
	 */
	private static HttpPost getHttpPost(URI uri, Map<String, String> params) {
		HttpPost httpPost = new HttpPost(uri);
		UrlEncodedFormEntity entity = null;
		try {
			entity = new UrlEncodedFormEntity(map2NameValuePair(params));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	
		httpPost.setEntity(entity);
		return httpPost;
	}
	
	/**
	 * 请求参数
	 * @param parameters
	 * @return
	 */
	private static List<NameValuePair> map2NameValuePair(Map<String, String> parameters) {
		Set<Entry<String, String>> entrySet = parameters.entrySet();
		List<NameValuePair> pairs = new ArrayList<NameValuePair>(); 
		for(Entry<String, String> entry : entrySet) {
			pairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}
		return pairs;
	}
	
	private HttpUriRequest getHttpUriRequest(URI uri, Map<String, String> params) {
		/*
		 * HttpUriRequest request = RequestBuilder.post().setUri(uri);
		 * 
		 * return request;
		 */
		return null;
	}

	/**
	 * 处理响应信息
	 * @param response
	 * @return
	 * @throws IOException
	 */
	private static HttpEntity handleResponse(final HttpResponse response)
			throws IOException {
		StatusLine statusLine = response.getStatusLine();
		HttpEntity entity = response.getEntity();
		if (statusLine.getStatusCode() >= 300) {
			throw new HttpResponseException(statusLine.getStatusCode(),
					statusLine.getReasonPhrase());
		}
		if (entity == null) {
			throw new ClientProtocolException("Response contains no content");
		}
		return entity;
	}

	/**
	 * 获取HttpEntity中的内容；
	 * @param entity
	 * @return
	 */
	private static String getContent(HttpEntity entity) {
		String responseContent = null;
		if (entity != null) {
			try {
				responseContent = inputStream2String(entity.getContent());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return responseContent;
	}
	
	/**
	 * 将输入流转成字符串
	 * @param is
	 * @return
	 */
	private static String inputStream2String(InputStream is) {
		if(is == null) 
			return null;
		BufferedReader reader  = new BufferedReader(new InputStreamReader(is));
		String line = null;
		StringBuffer buffer = new StringBuffer();
		try {
			while ((line = reader.readLine()) != null ) {
				buffer.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		URI uri = null;
		try {
			uri = new URI("http://127.0.0.1:8080/tick-web/user/login/user");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("password", "1234");
		
		String msg  = HttpClientUtil.sendPostRequest(uri, map);
		System.out.println(msg);
		 String msgs  = new String(msg.getBytes("utf-8"), "utf-8");
		System.out.println(msgs);
	}
}
