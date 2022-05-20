package br.ufc.mdcc.AdapterInterfaces;

import java.net.HttpURLConnection;
import java.net.URL;

public interface DataRequest {
	public HttpURLConnection connection(URL url);

}
