package com.globalin.view.controller;

/* VeiwResolver 클래스는 Controller가 리턴한 view 이름에 접두사와 접미사를
 * 결합하여 최종적으로 실행될 view 경로와 파일명을 완성하는 클래스
 */

public class ViewResolver {
	
	public String prefix;
	public String suffix;
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}	
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	public String getView(String viewName) {
		
		return prefix + viewName + suffix;
	}
	
}
