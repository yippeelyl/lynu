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
		//简单易行
		SystemClock.sleep(3000);
		startMainActivity();		
		
		// 闪屏的核心代码
		/*
		 * new Handler().postDelayed(new Runnable() {
		 * 
		 * @Override public void run() { Intent intent = new
		 * Intent(SplashActivity.this, MainActivity.class); // 从启动动画ui跳转到主ui
		 * startActivity(intent); SplashActivity.this.finish(); // 结束启动动画界面 } },
		 * 4000); // 启动动画持续3秒钟
		 */

		// 方法一：开启一个子线程执行跳转任务
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				SystemClock.sleep(3000);
//				Intent intent = new Intent(SplashActivity.this,
//						MainActivity.class); // 从启动动画ui跳转到主ui
//				startActivity(intent);
//				SplashActivity.this.finish(); // 结束启动动画界面
//			}
//		});
		// 方法一：开启一个子线程执行跳转任务
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

		// 方法二：使用Handler发送延迟消息
		// new Handler(new Handler.Callback() {
		// @Override
		// public boolean handleMessage(Message msg) {
		// Intent intent = new Intent(SplashActivity.this,HomeActivity.class);
		// startActivity(intent);
		// return false;
		// }
		// }).sendEmptyMessageDelayed(0,2000);

		// 方法三：使用Java计时器
		// Timer timer = new Timer();
		// timer.schedule(new MyTask(),2000);//定时器延时执行任务的方法

		// 方法三：使用Java计时器
		// class MyTask extends TimerTask{
		// @Override
		// public void run() {
		// Intent intent = new Intent(SplashActivity.this,MainActivity.class);
		// startActivity(intent);
		// }
		// }
		ll_splash=(LinearLayout) findViewById(R.id.ll_splash);

		/**
		 * 第三种方法，利用动画实现
		 */
		// startAdimThree();
		/**
		 * 第四种方法，利用动画实现
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
     * 跳转到主界面 
     */  
    private void startMainActivity() {  
        startActivity(new Intent(SplashActivity.this, MainActivity.class));  
        finish();  
    }  
}
