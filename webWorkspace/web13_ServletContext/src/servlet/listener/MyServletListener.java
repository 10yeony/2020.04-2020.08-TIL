package servlet.listener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//글로벌한 차원의 초기화
public class MyServletListener implements ServletContextListener {
	private ServletContext context;
	
	//DD 읽고 - ServletContext 생성 - ServletContextEvent 발생 - 리스너 감지 - 호출
	//결론적으로 가장 최초에 호출되는 메소드...
	//컨테이너 차원의 초기화.... 로직은 여기에서 작성....
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("contextInitialized....");
		//1. sce에서 ServletContext 하나 받아온다.
		context = sce.getServletContext();
		
		//2. DD파일에 설정된 정보를 읽어온다.
		String filePath = context.getInitParameter("vipFile");
		System.out.println("filePath :: "+filePath); //경로 제대로 받아왔는지 확인
		
		//3.filePath에 들어있는 파일의 내용을 읽어들임....getResourceAsStream()
		InputStream is = null;
		BufferedReader br = null;
		try {
			System.out.println("getResourceAsStream() call....");
			is = context.getResourceAsStream(filePath);
			br = new BufferedReader(new InputStreamReader(is));
			String line = null;
			System.out.println("파일의 내용을 읽어들입니다....");
			while((line = br.readLine()) !=null) System.out.println(line);
		}catch(IOException e){
			System.out.println("파일을 읽어오지 못했습니다.");
		}
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextDestroyed....");
	}

}
