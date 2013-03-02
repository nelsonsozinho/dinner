package br.alone.dinner;

public class Garfo {

	private boolean[] catched = new boolean[5];
	
	public synchronized void pegar(Filosofo f) {
		System.out.println("Filosofo " + (f.getKey() + 1) + " pegando o garfo");
		int key = f.getKey(); 
		while (catched[key] || catched[((key + 1)%5)]){
			System.out.println("Filosofo " + (f.getKey() + 1) + " faminto");
			f.setStatus(Filosofo.STATUS_FAMINTO);
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		catched[key] = true;
		catched[((key+1)%5)] = true;
		f.setStatus(Filosofo.STATUS_COMENDO);
	}
	
	public synchronized void liberar(Filosofo f) {
		System.out.println("Filosofo " + (f.getKey() + 1) + " liberando o garfo");
		int key = f.getKey();
		catched[key] = false;
		int aux = (key + 1) % 5;
		catched[aux] = false;
		notifyAll();
	}
}
