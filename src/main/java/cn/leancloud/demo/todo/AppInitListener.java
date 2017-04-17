package cn.leancloud.demo.todo;

import java.io.File;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cn.leancloud.LeanEngine;

import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.internal.impl.JavaRequestSignImplementation;
import com.lianai.keywords.Matcher;
import com.lianai.keywords.ac.ACMatcher;
import com.lianai.keywords.utils.Util;

@WebListener
public class AppInitListener implements ServletContextListener {

	private static final Logger logger = LogManager
			.getLogger(AppInitListener.class);

	private String appId = System.getenv("LEANCLOUD_APP_ID");
	private String appKey = System.getenv("LEANCLOUD_APP_KEY");
	private String appMasterKey = System.getenv("LEANCLOUD_APP_MASTER_KEY");
	private Matcher matcher = null;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		logger.info("LeanEngine app init.");
		// 注册子类化
		AVObject.registerSubclass(Todo.class);
		// 初始化AVOSCloud，请保证在整个项目中间只初始化一次
		LeanEngine.initialize(appId, appKey, appMasterKey);
		// 在请求签名中使用masterKey以激活云代码的最高权限
		JavaRequestSignImplementation.instance().setUseMasterKey(true);
		// 打开 debug 日志
		AVOSCloud.setDebugLogEnabled(true);
		// 向云引擎注册云函数
		LeanEngine.register(Cloud.class);
		LeanEngine.register(Hook.class);
		if (System.getenv("LEANCLOUD_APP_ENV").equals("development")) {
			// 如果是开发环境，则设置 AVCloud.callFunction 和 AVCloud.rpcFunction 调用本地云函数实现
			// 如果需要本地开发时调用云端云函数实现，则注释掉下面语句。
			LeanEngine.setLocalEngineCallEnabled(true);
		}
		initMatcher();
	}

	private void initMatcher() {
		String path = new StringBuffer(Util.getPath(AppInitListener.class))
				.append(File.separator).append("dw1.txt").toString();
		matcher = new ACMatcher(path, "UTF-8");
		String res = matcher.cover("610洗脑班fff", '*');
		System.out.println(res);
	}
}
