package com.lianai.keywords;

import com.lianai.keywords.ac.ACMatcher;

public class Test {

	public static void main(String[] args) {

		Matcher matcher = new ACMatcher(
				"C:/WorkSpaces/Java/CoreWorkSpace/xh/war/WEB-INF/config/resource/dirtywords/dw1.txt",
				"UTF-8");
		long t = System.nanoTime();
		System.out.println(matcher.cover(
				"关于610头目劳教所，你以为fapiao，GCD，TIBET的哭泣的歌曲", '*'));
		System.out.println(System.nanoTime() - t);

	}

}
