package com.example.splash;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.provider.ContactsContract.Contacts.Entity;
import android.app.Activity;
import android.content.Intent;
import android.graphics.LinearGradient;
import android.view.Menu;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class SplashActivity extends Activity {
	LinearLayout ll_splash;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		//������
		SystemClock.sleep(3000);
		startMainActivity();		
		
		// �����ĺ��Ĵ���
		/*
		 * new Handler().postDelayed(new Runnable() {
		 * 
		 * @Override public void run() { Intent intent = new
		 * Intent(SplashActivity.this, MainActivity.class); // ����������ui��ת����ui
		 * startActivity(intent); SplashActivity.this.finish(); // ���������������� } },
		 * 4000); // ������������3����
		 */

		// ����һ������һ�����߳�ִ����ת����
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				SystemClock.sleep(3000);
//				Intent intent = new Intent(SplashActivity.this,
//						MainActivity.class); // ����������ui��ת����ui
//				startActivity(intent);
//				SplashActivity.this.finish(); // ����������������
//			}
//		});
		// ����һ������һ�����߳�ִ����ת����
		// new Thread(){
		// @Override
		// public void run() {
		// super.run();
		// try {
		// Thread.sleep(2000);
		// Intent intent = new Intent(SplashActivity.this,HomeActivity.class);
		// startActivity(intent);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// }
		// }.start();

		// ��������ʹ��Handler�����ӳ���Ϣ
		// new Handler(new Handler.Callback() {
		// @Override
		// public boolean handleMessage(Message msg) {
		// Intent intent = new Intent(SplashActivity.this,HomeActivity.class);
		// startActivity(intent);
		// return false;
		// }
		// }).sendEmptyMessageDelayed(0,2000);

		// ��������ʹ��Java��ʱ��
		// Timer timer = new Timer();
		// timer.schedule(new MyTask(),2000);//��ʱ����ʱִ������ķ���

		// ��������ʹ��Java��ʱ��
		// class MyTask extends TimerTask{
		// @Override
		// public void run() {
		// Intent intent = new Intent(SplashActivity.this,MainActivity.class);
		// startActivity(intent);
		// }
		// }
		ll_splash=(LinearLayout) findViewById(R.id.ll_splash);

		/**
		 * �����ַ��������ö���ʵ��
		 */
		// startAdimThree();
		/**
		 * �����ַ��������ö���ʵ��
		 */
//		StartAniFour();
	}

	private void StartAniFour() {
	     AlphaAnimation start = new AlphaAnimation(0.0f, 1.0f);  
	        start.setDuration(4000);  
	        // findViewById(R.id.splash).startAnimation(start);  
	        start.setAnimationListener(new Animation.AnimationListener() {  
	            @Override  
	            public void onAnimationStart(Animation animation) { 	  
	            } 	  
	            @Override  
	            public void onAnimationEnd(Animation animation) {  
	                startMainActivity();  
	            }  
	            @Override  
	            public void onAnimationRepeat(Animation animation) {  
	  
	            }  
	        });  
	        ll_splash.startAnimation(start); 
	}
	  /** 
     * ��ת�������� 
     */  
    private void startMainActivity() {  
        startActivity(new Intent(SplashActivity.this, MainActivity.class));  
        finish();  
    }  
}
