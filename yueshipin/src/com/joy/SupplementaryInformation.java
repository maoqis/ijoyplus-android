package com.joy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.joy.Service.DownLoadService;
import com.joy.Service.Return.ReturnValue;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mobclick.android.MobclickAgent;

public class SupplementaryInformation extends Activity {
	App app;
	Button finish;
	EditText imformation_name,imformation_email,imformation_password;
	Context context;
	Intent in;
	private DownLoadService DOWNLOADSERVICE;
	@Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.supplementaryinformation);
        context = this;
        app = (App) getApplicationContext();
        finish = (Button) findViewById(R.id.finish);
        imformation_name = (EditText) findViewById(R.id.imformation_name);
        imformation_email = (EditText) findViewById(R.id.imformation_email);
        imformation_password = (EditText) findViewById(R.id.imformation_password);
        
        // veteranyu add
     		DOWNLOADSERVICE = app.getService();

     		// *************************************************************************
        finish.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int isFinish = 1;
				String name,email,password;
				String error = getString(R.string.error);
				/*
				if (!isName(imformation_name.getText().toString().trim())) {
					error += " "+getString(R.string.imformation_nameerror);
					isFinish = 0;
				}
				if (!isEmail(imformation_email.getText().toString().trim())) {
					error += " "+getString(R.string.emailerror);
					isFinish = 0;
					}
				if (imformation_password.getText().toString().trim().length()<6) {
					error += " "+getString(R.string.passworderror);
					isFinish = 0;
				}
				*/
				switch(isFinish)
				{
				case 0:
					Toast.makeText(context, error, Toast.LENGTH_SHORT).show();
					break;
				case 1:
					//新浪token
					if (app.getlogin_where().equals(getString(R.string.sinawb))) {
						app.setAccessToken(getIntent().getStringExtra("token"));
						app.setExpires_in(getIntent().getStringExtra("expires_in"));
						app.SaveAccessToken();
						app.SaveExpires_in();
						System.out.println("getIntent().getStringExtra(\"token\")====>"+getIntent().getStringExtra("token"));
						System.out.println("getIntent().getStringExtra(\"expires_in\")====>"+getIntent().getStringExtra("expires_in"));
						name = getIntent().getStringExtra("token");
						email = name +"@sina.com";
						password = name;
						 // veteranyu add
						ReturnValue m_ReturnValue = DOWNLOADSERVICE.AccountRegister(email, password, name);
						if(m_ReturnValue.res_code.trim().equalsIgnoreCase("00000")){
							//1. save to local
							app.SaveIjoyID(imformation_email.getText().toString().trim(),imformation_password.getText().toString());
							//2.绑定第三方账号 account/bindAccount
							 DOWNLOADSERVICE.AccountBindAccount(name, "1");
							Toast.makeText(context, m_ReturnValue.res_code, Toast.LENGTH_SHORT).show();
						}
						else{
							Toast.makeText(context, m_ReturnValue.res_desc, Toast.LENGTH_SHORT).show();
							return;
						}
					}
					//QqTOKEN
					else if (app.getlogin_where().equals(getString(R.string.tencent))) 
					{
						name = app.GetOpenID();
						email = name +"@qq.com";
						password = name;
						app.setQQ_Token(getIntent().getStringExtra("token"));
						app.SaveQQAccessToken();
//						app.GetQQAccessToken();
//						System.out.println("token:"+app.getQQ_Token());
						//1. save to local
						app.SaveIjoyID(imformation_email.getText().toString().trim(),imformation_password.getText().toString());
						//2.绑定第三方账号 account/bindAccount
						 DOWNLOADSERVICE.AccountBindAccount(name, "1");
					}
					Intent intent = new Intent();
					if (app.getwhere_gologin()==1) {
						
					}
					else
					{
						app.setActivitytype("1");
						intent.setClass(context, Darentuijian.class);
						startActivity(intent);
					}
					finish();
					break;
				}
			}
		});
	}
	
	
	/*正则表达*/
	public static boolean isEmail(String strEmail) {

		String strPattern = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";

		Pattern p = Pattern.compile(strPattern);

		Matcher m = p.matcher(strEmail);

		return m.matches();

		}
	public static boolean isName(String strName) {

		String strPattern = "^[\\u4e00-\\u9fa5\\w\\d_]{1,16}$";

		Pattern p = Pattern.compile(strPattern);

		Matcher m = p.matcher(strName);

		return m.matches();

		}
	
	public boolean onKeyDown(int keyCode, KeyEvent event)  {
    	switch(keyCode){
        case KeyEvent.KEYCODE_BACK:
        	break;
    	}
        return true;
    }
	public void onResume() { 
		super.onResume();
		MobclickAgent.onResume(this); 
	} 
	public void onPause() { 
		super.onPause(); 
		MobclickAgent.onPause(this); 
	}
}