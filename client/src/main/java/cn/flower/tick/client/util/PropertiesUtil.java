package cn.flower.tick.client.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;


/**
 * 操作Properties 文件 
 * @FileName PropertiesUtil.java
 * @author ChenCheng
 */
public class PropertiesUtil {
	private PropertiesUtil(){};
	/**
	 * 获取磁盘文件路径;
	 * @param propertiesFilePath 
	 * @param encoding URL 使用指定的编码机制对 application/x-www-form-urlencoded 字符串解码所用的编码方式;
	 * @return 返回PropertiesFilePaht 路径
	 */
	private static String getPath(String filePath,String encoding){
		/*@SuppressWarnings("rawtypes")
		Class clazz = PropertiesUtil.class;	
		URL url = clazz.getClassLoader().getResource(filePath);
		if(url == null)
			throw new RuntimeException("属性文件：\""+filePath+"\"未找到;");
		String path = url.getPath();
		try {
			path = URLDecoder.decode(path, encoding);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		return path;*/
		File file = new File("session.properties");
		String path = null;
		try {
			path = file.getCanonicalPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
		
	/**
	 * 加载Properties 文件;若文件不存在则抛出IOException;
	 * @param propertiesFilePath   CLASSPATH 下文件路径 
	 * @return  返回Properties 对象;
	 * @throws ClassNotFoundException 
	 */
	public  static Properties loadPropertiesFile(String propertiesFilePath) {
		String path = getPath(propertiesFilePath,"UTF-8");
		return loadPropertiesFile(new File(path));
	}
	
	
	private  static Properties loadPropertiesFile(File propertiesFile) {
		InputStream is = null;
		try {
			is = new FileInputStream(propertiesFile);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		Properties prop = new Properties();
		try {
			prop.load(is);
		} catch (IOException ie) {
			throw new RuntimeException(ie);
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return prop;
	}
	
	public static String getValue(String key) {
		
		Properties props = loadPropertiesFile("session.properties");
		if(props.containsKey(key)){
			return props.getProperty(key);			
		}
		return null;
	}
	
	public static void storePropertiesFile(String sessionId, String loginTime, String username) {
		Properties props = new Properties();
		props.setProperty("JSESSIONID", sessionId);
		props.setProperty("loginTime", loginTime);
		props.setProperty("username", username);
		OutputStream os = null;
		try {
			os = new FileOutputStream(getPath("session.properties", "UTF-8"));
			props.store(os, "cc001116@126.com");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}  

			}
		}
	}
}
