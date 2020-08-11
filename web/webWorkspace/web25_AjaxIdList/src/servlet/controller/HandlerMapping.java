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
		if(command.equals("find.do")) {
			controller = new FindController();
			System.out.println("FindController 생성됨....");
		}else if(command.equals("idList.do")) {
			controller = new IdListController();
			System.out.println("IdListController 생성됨...");
		}else if(command.equals("idCheck.do")) {
			controller = new IdCheckController();
			System.out.println("IdCheckController 생성됨...");
		}
		return controller;
	}
}
