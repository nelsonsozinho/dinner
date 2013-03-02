package br.alone.dinner;


public class Filosofo implements Runnable {

	public static final int STATUS_PENSANDO = 1;
	public static final int STATUS_COMENDO = 2;
	public static final int STATUS_FAMINTO = 3;
	
	private int status;
	private int key;
	
	
	private Jantar jantar;
	
	public Filosofo(int key, Jantar jantar) {
		this.key = key;
		this.jantar = jantar;
	}	 
	
	@Override
	public void run() {
		System.out.println("Iniciando filosofo " + (key + 1) + "\n");
		while(true) {
			setStatus(STATUS_PENSANDO);
			pensar();
			this.jantar.getGarfo().pegar(this);
			comer();			
			this.jantar.getGarfo().liberar(this);			
		}
	}

	
	
	public void comer() {
		this.status = Filosofo.STATUS_COMENDO;
		try {
			System.out.println("Filosofo " + (key + 1) + " comendo \n");
			Thread.currentThread().sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void pensar() {
		this.status = Filosofo.STATUS_PENSANDO;
		try {
			System.out.println("Filosofo " + (key + 1) + " pensando \n");
			Thread.currentThread().sleep(5500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public void setStatus(int status) {
		this.status = status;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getStatus() {
		return status;
	}
	
	public int getKey() {
		return key;
	}
	
	
}
