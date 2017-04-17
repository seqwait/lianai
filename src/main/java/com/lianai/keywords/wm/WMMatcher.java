package com.lianai.keywords.wm;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lianai.keywords.AbstractMatcher;
import com.lianai.keywords.Result;
import com.lianai.keywords.config.ConfigWrapper;
/**
 * WM94
 * 
 * @author RUIZ
 */
public class WMMatcher extends AbstractMatcher {

	private Map<String, List<String>> patternMap;

	public WMMatcher(ConfigWrapper config) {
		apply(config);
	}

	public WMMatcher(Collection<String> keywords, int blockSize) {
		this.patternMap = genPatternMap(keywords, blockSize);
	}

	private Map<String, List<String>> genPatternMap(
			Collection<String> keywords, int blockSize) {
		Map<String, List<String>> patternMap = new HashMap<String, List<String>>();
		for (String keyword : keywords) {
			if (blockSize < keyword.length()) {

			}
		}
		return patternMap;
	}

	@Override
	public List<Result> match(String target) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result matchOnce(String target) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String cover(String target, char cover) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean test(String target) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void apply(ConfigWrapper config) {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

}
