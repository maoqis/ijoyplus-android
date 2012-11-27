package com.joy;

import android.os.Environment;

public class Constant {
	public static final String BASE_URL = "http://115.239.196.123/joyplus-service/index.php/"; // 正式数据库
	/*
	 * http://test.joyplus.tv/index.php/tops
	 * http://test.joyplus.tv/index.php/XXXXXX
	 */
	// "http://112.64.18.12/joyplus-service/index.php/"; //测试数据库
	// "http://112.65.239.202/joyplus-service/index.php/"; //测试数据库2
	// "http://115.239.196.123/joyplus-service/index.php/"; // 正式数据库
	public static final String WIKTIONARY_PAGE2 = "http://www.baidu.com";
	public static final String OUTPUTFILE = "sdcard/log.txt";
	public static String PATH = Environment.getExternalStorageDirectory()
			+ "/joy/image_cache/";
	public static String PATH_HEAD = Environment.getExternalStorageDirectory()
			+ "/joy/admin/";

	public static final String APPKEY = "ijoyplus_android_0001";

	public static final String TEMPMAIL = "vii";
	public static final String LOGINMAIL = "vii@163.com";
	public static final String LOGINPASSWORD = "vii";

	public static int TESTINDEX = 3;
	public static int TESTITEM = 4;
	public static int MAXITEM = 60;
	public static final String PROD_ID = "6672";
	public static final String USER_ID = "6315";

	public static int newHeight = 250;
	public static int newWidth = 230;

	// 我们的sina账号
	public static String SINA_CONSUMER_KEY = "1490285522";
	public static String SINA_CONSUMER_SECRET = "f9ebc3ca95991b6dfce2c1608687e92b";
	public static String TECENTAPPID = "100317415";
	/*
	 * <string name="SINA_CONSUMER_KEY">3069972161</string> <string
	 * name="SINA_CONSUMER_SECRET">eea5ede316c6a283c6bae57e52c9a877</string>
	 * <string name="mAppid">222222</string>
	 */
	// public static String SINA_CONSUMER_KEY = "3069972161";
	// public static String SINA_CONSUMER_SECRET =
	// "eea5ede316c6a283c6bae57e52c9a877";
	// public static String TECENTAPPID = "222222";

	public static String[][] m_ReturnErrorCode = {
			{ "10021", "HTTP method is not suported for this request" },
			{ "10006", "Source paramter (appkey) is missing or invalid" },
			{ "10001", "System error" }, { "20001", "Account not Found" },
			{ "20002", "Password is invalid" },
			{ "20003", "Username is invalid,It must be your email." },
			{ "20004", "Username can\'t be null" },
			{ "20005", "Password can\'t be null" },
			{ "20006", "Username exists." },
			{ "20008", "Session is expired, need relogin." },
			{ "20009", "Third part account type is invalid." },
			{ "20010", "Object not found" }, { "20011", "Param is invalid" },
			{ "20013", "Program is published." },
			{ "20014", "Url is invalid." },
			{ "20015", "Program is favority." },
			{ "20016", "Program is not favority." },
			{ "20017", "Person is liked by you." },
			{ "20018", "Nickname can not be null" },
			{ "20019", "Nickname is exsting." },
			{ "20020", "Keyword can\'t be null." } };
	public static String[][] m_ReturnOKCode = { { "00000", "Success" } };
}