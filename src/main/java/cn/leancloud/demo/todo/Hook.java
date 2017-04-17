package cn.leancloud.demo.todo;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cn.leancloud.IMHook;
import cn.leancloud.IMHookType;

import com.alibaba.fastjson.JSON;

public class Hook {

	private static final Logger logger = LogManager.getLogger(Hook.class);

	@SuppressWarnings("unchecked")
	@IMHook(type = IMHookType.messageReceived)
	public static Map<String, Object> onMessageReceived(
			Map<String, Object> params) {
		System.out.println(params);
		logger.info("hook=>" + params);
		Map<String, Object> result = new HashMap<String, Object>();
		String content = (String) params.get("content");
		Map<String, Object> contentMap = (Map<String, Object>) JSON
				.parse(content);
		String text = (String) (contentMap.get("_lctext").toString());
		String processedContent = text.replace("XX中介", "**");
		result.put("content", processedContent);
		return result;
	}

}
