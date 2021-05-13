	package Prog;

	public class DosHilos extends Thread{
	
		private Thread creador;
		
		public DosHilos(){
				creador=Thread.currentThread();
		}

		public void run(){
			for (int i=0; i<500; i++) printMsg(i); 
		}
		
		public void printMsg(int i)
		{
			Thread hiloActual=Thread.currentThread();
			if (hiloActual==creador)
			{
				System.out.println("Main - "+i);
			} else if(hiloActual.getName()=="First")
				System.out.println("Nuevo Thread 1 - "+i);
			else {
				System.out.println("Nuevo Thread 2 - "+i);
			}
		}
		
		public static void main(String args[])
		{
			DosHilos d=new DosHilos();
			DosHilos ddd=new DosHilos();
			Thread First =new Thread(d);
			First.setName("First");
			First.start();
			ddd.setPriority(MIN_PRIORITY);
			new Thread(ddd).start();
			Thread.currentThread().setPriority(MAX_PRIORITY);
		
			for (int i=0; i<500; i++) d.printMsg(i);
		}
	}


