/*
 * 결과페이지 이름과 
 * 이동방식(forward | redirect)에 대한 정보를 담고 있는 객체
 * ModelAndView (Spring MVC 라이브러리에서 이름을 따옴.)
 */
package servlet.controller;

public class ModelAndView {
	private String path;
	private boolean isRedirect; //기본값 false인 걸 고려해서 기본 이동 방식은 forward
	
	public ModelAndView() {}
	public ModelAndView(String path) { //forward
		this.path = path;
	}
	public ModelAndView(String path, boolean isRedirect) { //redirect
		this.path = path;
		this.isRedirect = isRedirect;
	}
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		//데이터 타입이 boolean일 때는 앞에 get 안 붙음. is 붙음.
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
}
