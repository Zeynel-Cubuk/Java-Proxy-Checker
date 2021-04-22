package java_proje_packages;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.*;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HttpsURLConnection;

/*
 * Pattern : Düzen
 * Compile : Derleme
 * Match : Eşleştirme
 * Hız için ilk başta Pattern olayını yapıp sonra Compile ederiz ve ardından Match ederiz.
 * */

public class ProxyChecker {

	static  String regex = "(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}):(\\d{1,5})";
	static final Pattern pattern = Pattern.compile(regex);
	

	public static void main(String[] args) {
		// java ProxyChecker.java
		String site = "https://free-proxy-list.net/";
		ProxyChecker check = new ProxyChecker();
		check.siteConnector(site);
		
	}
	void siteConnector(String site) {
		try {
			
			String path_proxy = "C:\\Users\\Red\\Desktop\\proxies.txt";
			String path_content = "C:\\\\Users\\\\Red\\\\Desktop\\\\content.txt";
			
			File file_proxy = new File(path_proxy);
			FileWriter fw_proxy = new FileWriter(file_proxy,false);
			
			File file_content = new File(path_content);
			FileWriter fw_content = new FileWriter(file_content,false);
			
			URL url = new URL(site);
			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
			con.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.72 Safari/537.36"); 
			
			InputStreamReader isr = new InputStreamReader(con.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			
			String content ;
			
			while((content=br.readLine())!=null) {
					
				Matcher match = pattern.matcher(content);
				
				fw_content.write(content);
				
				if (match.find( )) {
				       System.out.println("[+] Found value: " + match.group(0));
				        TimeUnit.SECONDS.sleep(2);
				       
				       String data = match.group(0)+System.lineSeparator();
				       fw_proxy.write(data);
				       
				       
				       System.out.println("[!] Value added....");
				     }
					
					else {
						continue;
					}
				
				}
			
			
			fw_proxy.close();
			fw_content.close();
			
			
			}
			catch(Exception e) {
				System.out.println("Hata!"+e);
			}
	}
}