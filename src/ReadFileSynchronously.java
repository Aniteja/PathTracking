import java.io.File;
import java.lang.String;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;



public class ReadFileSynchronously extends TimerTask {

	
	File f=null;
	static String filevalue="";
	public void run() {
		// TODO Auto-generated method stub
		filevalue=new ReadFileSynchronously().mylogic();
		System.out.println("file value is ::"+filevalue);
			}
	public  String mylogic()
	{
		int i=0;
		f=new File("D:/robo/def/src/data.txt");
		try {
			FileInputStream fis=new FileInputStream(f);
			
			if((i=fis.read())!=-1)
			{
				//filevalue+=(char)i;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  " "+(char)i;
	}
public static void main(String robo[])
{
	ReadFileSynchronously mytask=new ReadFileSynchronously();
	Timer t=new Timer();
	t.schedule(mytask,1000,1000);
	
}
}
