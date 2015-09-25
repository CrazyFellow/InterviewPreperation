// Common Class between producer and consumer
public class CubbyHole
{
	private int value;
	private boolean available = false;
	
	//Aquiring lock is must while reading or writing object state [An important exception: final fields].
	
	//This will avoid multiple threads modifying object state same time [avoiding data   corrution].
	
	/**
	  1) First, it is not possible for two invocations of synchronized methods on the same object to interleave. When one thread is executing a synchronized method for an object, all other threads that invoke synchronized methods for the same object block (suspend execution) until the first thread is done with the object.
	
      2) Second, when a synchronized method exits, it automatically establishes a happens-before relationship with any subsequent invocation of a synchronized method for the same object. This guarantees that changes to the state of the object are visible to all threads.
	**/
	public synchronized int get()
	{	
	        //While loop will help thread to go back to wait state if thread get's wrong notification because of notifyAll call.
			
			/*As in the one argument version, interrupts and spurious wakeups are possible, and this method should always be used in a loop:

                 synchronized (obj) 
				 {
                   while (<condition does not hold>)
                   obj.wait();
                   ... // Perform action appropriate to condition
                 }
			*/
			while(available == false)
			{
				try
				{
				   wait();
				}
				catch(InterruptedException e)
			    {
					
				}
			}
			
			available = false;
			//though this call is meant for consumer notification but it's not gurenteed [if there are any producers waiting].
			notifyAll();
			return value;
	}
	
	
	public synchronized void put(int value)
	{
			while(available == true)
			{
				try
				{
					wait();
				}
				catch(InterruptedException e)
				{
					
				}
			}
			
			available = true;
			this.value = value;
			notifyAll();
	}
}