
public class Producer implements Runnable
{
	private CubbyHole cubbyHole;
	
	Producer(CubbyHole cubbyHole)
	{
		this.cubbyHole = cubbyHole;
	}
	
	public void run()
	{
		for(int i=1;i<=10;i++)
		{
			cubbyHole.put(i);
		}
	}
}