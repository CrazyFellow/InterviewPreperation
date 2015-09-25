
public class PoolDemo
{
	public static void main(String args[])
	{
		CubbyHole cubbyHole = new CubbyHole();
		
		Thread producer1 = new Thread(new Producer(cubbyHole));
		Thread producer2 = new Thread(new Producer(cubbyHole));
		Thread consumer = new Thread(new Consumer(cubbyHole));
		
		producer1.start();
		producer2.start();
		consumer.start();
	}
}