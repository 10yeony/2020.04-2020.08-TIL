package servlet.controller;

public class HandlerMapping {
	//Controller를 생성하는데 들어온 command 값에 따라 
	//Controller를 핸들링하면서 컴포넌트를 각각 다르게 매핑해서 만들겠다.
	private static HandlerMapping handler = new HandlerMapping();
	private HandlerMapping() {}
	public static HandlerMapping getInstance() {
		return handler;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		if(command.equals("subject")) {
			controller = new SubjectController();
			System.out.println("SubjectController Creating...");
		}else if(command.equals("company")) {
			controller = new CompanyController();
			System.out.println("CompanyController Creating...");
		}
		return controller;
	}
}
