import javax.comm.*;
import java.io.*;
import java.util.Timer;
import java.util.TimerTask;

public class  PortConnection extends TimerTask //implements SerialPortEventListener
{
	private CommPortIdentifier portId;
    private SerialPort sPort;

    private OutputStream os;
    private InputStream is;
    
	private String portName;
	private int baudRate;
	private int dataBits;
	private int stopBits;
	private int parity;

	private String response;

	public PortConnection()
	{
		portName="COM1";
		baudRate=9600;
		dataBits=8;
		stopBits=1;
		parity=0;

		portId=null;
		sPort=null;

		response=null;
	}
public void run()
{
	openConnection("");
}
	public void openConnection(String data)
	{
		//response=null;
		System.out.println("at pc:"+data);

		try
		{
			System.out.println(":::::::::::::::::::::::::::::");
			//identifying the COM1 port which throws NoSuchPortException
			portId=CommPortIdentifier.getPortIdentifier(portName);

			//connecting to port COM1 which throws PortInUseException
			sPort = (SerialPort)portId.open("robo", 1);

			//setting the parameters to the serial port as 9600, 8, 1, 0
			sPort.setSerialPortParams(baudRate, dataBits, stopBits, parity);
			//creating output stream used to pass request of reading, writing, status.....etc. throws IOException
			os=sPort.getOutputStream();
			sPort.notifyOnDataAvailable(true);
			System.out.println("got it....");
			//sending the data to the port
			os.write(data.getBytes());
			
			is=sPort.getInputStream();
			
			int i=0;
		
			if((i=is.read())!=-1)
			{
				System.out.println("iiii:::"+i);
			}
			
			FileOutputStream fos=new FileOutputStream("D:/robo/def/src/data.txt");
			fos.write((char)i);
			
			System.out.println("data send from keyboard::"+(char)i);
			closeConnection();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			if(sPort!=null)	sPort.close();
		}

	}


	public void closeConnection()
    {
        if(sPort != null)
        {
            try
            {
				//closing the streams created on serial port com1
                os.close();
//              is.close();
            }
            catch(IOException ioe)
            {
                System.err.println("Error in Closing Streams : "+ioe.getMessage());
            }
			try
			{
				//closing the serial port com1
	            sPort.close();
			}
			catch(Exception e)
			{
                System.err.println("Error in Closing Serial Post: "+e.getMessage());
			}
		}
        
    }

	public void serialEvent()
    {
		//String buffer to hold the response from port
		StringBuffer sb=new StringBuffer();
		int i=0;

		try
		{
			while((i=is.read())!=-1)
			{
				//appending char by char to string buffer
				sb.append((char)i);
			}
		}
		catch(Exception e)
		{
			response=e.getMessage();
		}
		//storing all the string in response object
		response=sb.toString();
		System.out.println("response :::"+response);
	}
public static void main(String aa[])
{
	PortConnection p=new PortConnection();
	Timer t=new Timer();
	t.schedule(p, 1000,1000);
}
}