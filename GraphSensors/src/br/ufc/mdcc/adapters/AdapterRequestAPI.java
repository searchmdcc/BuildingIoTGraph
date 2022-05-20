package br.ufc.mdcc.adapters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import br.ufc.mdcc.AdapterInterfaces.DataRequest;

public class AdapterRequestAPI implements DataRequest {
	HttpURLConnection con = null;
	@Override
	public HttpURLConnection connection(URL url) {
		try {
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.connect();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
			
	public void desconectar(HttpURLConnection con) {
		if (con != null) {
			con.disconnect();
		}
		
	}
	public static String getJson(URL url) {
		if (url == null)
			throw new RuntimeException("URL é null");

		String html = null;
		StringBuilder sB = new StringBuilder();
		try (BufferedReader bR = new BufferedReader(new InputStreamReader(url.openStream()))) {
			while ((html = bR.readLine()) != null)
				sB.append(html);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sB.toString();
	}


}
