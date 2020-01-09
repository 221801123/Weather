package com.xier.util;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
/**
 * Http工具类
 * @author Wu yongyi
 * 2019-12-23
 */
public final class HttpUtil {

	/**
	 * Post请求
	 * @param serviceUrl
	 * @param inMsg
	 * @return
	 * @throws Exception
	 */
	public static String httpPost(String serviceUrl,String inMsg) throws Exception{
		HttpClientParams clientParam=new HttpClientParams();
		clientParam.setConnectionManagerTimeout(500000);
		clientParam.setSoTimeout(500000);
		clientParam.setConnectionManagerClass(MultiThreadedHttpConnectionManager.class);
		clientParam.setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"UTF-8");
		HttpClient client=new HttpClient();
		client.setParams(clientParam);
		PostMethod method=new PostMethod(serviceUrl);
		method.releaseConnection();
		method.addRequestHeader("Content-Type","application/json;charset=UTF-8");
		method.setRequestBody(inMsg);
		client.executeMethod(method);
		byte[] responseBytes=readResponseStream(method);
		if(responseBytes!=null){
			return new String(responseBytes);
		}
		return null;
	}
	/**
	 * Get请求
	 * @param serviceUrl
	 * @return
	 * @throws Exception
	 */
	public static String httpGet(String serviceUrl) throws Exception{
		HttpClientParams clientParam=new HttpClientParams();
		clientParam.setConnectionManagerTimeout(500000);
		clientParam.setSoTimeout(500000);
		clientParam.setConnectionManagerClass(MultiThreadedHttpConnectionManager.class);
		clientParam.setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"UTF-8");
		HttpClient client=new HttpClient();
		client.setParams(clientParam);
		GetMethod method=new GetMethod(serviceUrl);
		method.releaseConnection();
		method.addRequestHeader("Content-Type","application/json;charset=UTF-8");
		client.executeMethod(method);
		byte[] responseBytes=readResponseStream(method);
		if(responseBytes!=null){
			return new String(responseBytes);
		}
		return null;
	}
	
	public static byte[] readResponseStream(HttpMethodBase method) throws Exception{
		ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
		InputStream is = method.getResponseBodyAsStream();
		byte[] buffer = new byte[4096];
		while (true) {
			int size = is.read(buffer);
			if (size <= 0) {
				break;
			}
			arrayOutputStream.write(buffer, 0, size);
		}
		return arrayOutputStream.toByteArray();
	}
	
	private static void trustAllHttpsCertificates() throws Exception {
		HttpsURLConnection.setDefaultHostnameVerifier(new HttpUtil().new NullHostNameVerifier());
        SSLContext sc = SSLContext.getInstance("TLS");//SSL
        sc.init(null, trustAllCerts, new SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	}
	
    private static TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            // TODO Auto-generated method stub
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            // TODO Auto-generated method stub
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            // TODO Auto-generated method stub
            return null;
        }
    } };
    
    public class NullHostNameVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String urlHostName, SSLSession session) {
//        	logger.info("Warning: URL Host: " + urlHostName + " vs. " + session.getPeerHost());
            return true;
        }
    }
}
