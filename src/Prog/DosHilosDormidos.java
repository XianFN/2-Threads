package Prog;

public class DosHilosDormidos extends Thread{
	private Thread creador;
	
	public DosHilosDormidos(){
			creador=currentThread();
	}

	public void run(){
		Thread hiloActual=Thread.currentThread();
		String nombre=hiloActual.getName();
		System.out.println("Justo antes de entrar en el bucle.");
		
		for (int i=0; i<10; i++){
			try{
				Thread.sleep(200);
			}catch (InterruptedException e){
				e.printStackTrace();
			}
			
			System.out.println("Nombre hilo:"+nombre);
		}
		System.out.println(nombre+" a punto de salir del bucle");
	}
	
	public static void main(String args[])
	{
		DosHilosDormidos d=new DosHilosDormidos();
		d.setName("Mi Hilo");
		d.start();
		try{
			Thread.sleep(700);
			//d.join();
		}catch (InterruptedException e){
			e.printStackTrace();
		}
		
		
		System.out.println("Ahora llamamos a run()");
		d.start();
	}
}
