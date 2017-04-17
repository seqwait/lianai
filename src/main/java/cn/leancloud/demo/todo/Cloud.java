package cn.leancloud.demo.todo;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cn.leancloud.EngineFunction;
import cn.leancloud.EngineFunctionParam;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;

public class Cloud {

	private static final Logger logger = LogManager.getLogger(Cloud.class);

	@EngineFunction("hello")
	public static String hello() {
		logger.info("@EngineFunction==>hello");
		return "Hello world!";
	}

	@EngineFunction("list")
	public static List<Todo> getNotes(@EngineFunctionParam("offset") int offset)
			throws AVException {
		AVQuery<Todo> query = AVObject.getQuery(Todo.class);
		query.orderByDescending("createdAt");
		query.include("createdAt");
		query.skip(offset);
		try {
			return query.find();
		} catch (AVException e) {
			if (e.getCode() == 101) {
				// 该错误的信息为：{ code: 101, message: 'Class or object doesn\'t
				// exists.' }，说明 Todo 数据表还未创建，所以返回空的
				// Todo 列表。
				// 具体的错误代码详见：https://leancloud.cn/docs/error_code.html
				return new ArrayList<>();
			}
			throw e;
		}
	}
}
