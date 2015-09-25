
public class Consumer implements Runnable
{
	private CubbyHole cubbyHole;
	
	Consumer(CubbyHole cubbyHole)
	{
		this.cubbyHole = cubbyHole;
	}
	
	public void run()
	{
		for(int i=1;i<=20;i++)
		{
			System.out.println(cubbyHole.get());
		}
	}
}