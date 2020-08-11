/*
 * 서블릿 필드값 count값을 영구적으로 보관할 수 있는 방법을 지금으로서는 없다...
 * 왜냐하면 서버가 stop되는 순간 destroy() callback 함수가 자동으로 호출되어지고,
 * 서블릿 인스턴스를 메모리에서 unbound 시켜버리기 때문이다.
 * 
 * 서버가 내려가더라도 서비스를 수행한 후 필드에 저장시킨 값을 영구적으로 보관하려면
 * 1) DB
 * 2) File --- v (지금 디비 연결은 벅차니까 파일에 연결을 사용해보겠음)
 * 
 * 이때 서블릿 라이프싸이클 메소드가 중요하게 사용되어진다.
 * 1) 해당 필드값을 파일로 출력
 * 2) 파일에 저장된 값을 불러(읽어들임)와야 한다.
 * 
 * init() --- 2)
 * destroy() --- 1)
 */
package servlet.life;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ServletLifecycleTest3 extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private int count = 0; //필드...
	private String path = "c:\\filestore\\life\\count.txt";
	
    public ServletLifecycleTest3() {
    	System.out.println("1. serviceLifecycleTest1 생성자....call..by container");
    }
    
    public void init() throws ServletException{
    	System.out.println("2. init......call..by container");
    	//서버가 다시 시작될 때 init()에서 파일에 저장된 내용을 읽어서... 필드 count에 다시 할당.
    	//0이 아닌 해당 숫자 이후부터 카운팅 진행된다...
    	try {
    		BufferedReader br = new BufferedReader(new FileReader(path));
    		String str = br.readLine();
    		count = Integer.parseInt(str);
    		
    		System.out.println("count.txt 파일의 내용을 읽어들임..... count :: "+count);
    		br.close();
    	}catch(IOException e) {
    		System.out.println("파일을 읽어들이는데 실패했습니다..");
    	}
    }
    
    public void destroy() {
    	System.out.println("4. destroy.....call...by container");
    	
    	//필드에 저장된 값을 파일로 뿌리고.... 서버가 내려질 것이다...
    	File file = new File(path);
    	//출력용 파일이 출력 스트림에서 자동적으로 생성되려면 그전에 반드시 디렉토리는 먼저 만들어져 있어야 한다.
    	file.getParentFile().mkdirs(); // 파일을 제외한 디렉토리를 만들어준다.
    	//getParentFile() => c:\\filestore\\life 을 가져옴.
    	//mkdir() 디렉토리 하나밖에 없을 때 / mkdirs() 디렉토리가 여러개일 때. 하나밖에 없을 때도 가능
    	//getParentFile()을 디렉토리로 만들어줌! 그러면 컴퓨터가 인식함.
    	try {
    		//new PrintWriter(new FileWriter(file,true),true)
    		//파일에 뿌릴 때 첫번째 true를 안 써주면 override된다. 첫번째 true는 append! 이어쓰기!
    		//파일에 뿌릴 때 두번째 true는 autoflush
    		PrintWriter pw = new PrintWriter(new FileWriter(file));
    		pw.println(count);
    		pw.close();
    		System.out.println(path+" count 값 :: "+count+" 파일에 영구적으로 저장됨...");
    	}catch(IOException e) {
    		
    	}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("3. service.......call..by container");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><body bgcolor='yellow'>");
		out.println("<h3>LifeCycle CallBack Method...</h3>");
		out.println("<b>Count :: </b>"+ ++count);
		out.println("</body></html>");
		
		out.close();
	}

}
