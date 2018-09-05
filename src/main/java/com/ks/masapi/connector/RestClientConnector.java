package com.ks.masapi.connector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.cert.Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ks.masapi.model.InterestRate;
import com.ks.masapi.util.JsonHelper;

/**
 *  Connector to connect to REST API, will only check for 200 status
 */
@Component
public class RestClientConnector {
	private static final Logger logger = LoggerFactory.getLogger(RestClientConnector.class);
	
	/**
	 * Connect to the REST server to get the json content, InterestRate object will be returned
	 * 
	 * @param urlInput
	 * @return InterestRate
	 */
	public InterestRate connect(String urlInput) throws Exception{
		int responseCode = 0;
		InterestRate interestRate = null;
		try {
			URL url = new URL(urlInput);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Accept-Encoding", "gzip,deflate");
			conn.setRequestProperty("User-Agent", "Apps");
			// conn.setRequestProperty("Content-Language", "en-US");

			conn.setUseCaches(false);
			//conn.setDoInput(true);
			conn.setDoOutput(true);
			//print_https_cert(conn);
			
			responseCode = conn.getResponseCode();
			if (responseCode != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			// print out URL details
			/*
			logger.info("Connecting to %s\nConnection Method: '%s'\nResponse Code is: %d\n", urlInput, "GET", responseCode);
			logger.info("----[ URL DETAILS ]-----------------");
			logger.info("URL Protocol....: " + url.getProtocol());
			logger.info("URL Host........: " + url.getHost());
			logger.info("URL Port........: " + url.getPort());
			logger.info("URL Authority...: " + url.getAuthority());
			logger.info("URL Path........: " + url.getPath());
			logger.info("URL User Info...: " + url.getUserInfo());
			logger.info("URL Query Info..: " + url.getQuery());
			*/
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			StringBuffer sbf = new StringBuffer();
			String output;
			logger.info("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				sbf.append(output);
							}
			logger.info(sbf.toString());
			
			conn.disconnect();

			JsonHelper jsonHelper = new JsonHelper();
			interestRate = jsonHelper.convert(sbf.toString());

			logger.info("Output from interestRate .... \n");
			logger.info(interestRate.toString() + "\n");				
		} catch (Exception e) {
			logger.error("", e);
			throw e;
		}
		return interestRate;
	}	
	 
	
	/**
	 * for troubleshooting purpose on SSL if required
	 * 
	 * @param con
	 */
	private void print_https_cert(HttpsURLConnection con) {
		if (con != null) {
			try {
				logger.info("Response Code : " + con.getResponseCode());
				logger.info("Cipher Suite : " + con.getCipherSuite());
				logger.info("\n");
				Certificate[] certs = con.getServerCertificates();
				for (Certificate cert : certs) {
					logger.info("Cert Type : " + cert.getType());
					logger.info("Cert Hash Code : " + cert.hashCode());
					logger.info("Cert Public Key Algorithm : " + cert.getPublicKey().getAlgorithm());
					logger.info("Cert Public Key Format : " + cert.getPublicKey().getFormat());
					logger.info("\n");
				}
			} catch (SSLPeerUnverifiedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
