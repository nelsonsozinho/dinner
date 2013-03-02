package br.alone.dinner;


public class Jantar {

	private Filosofo[] filosofos = new Filosofo[5];
	private Garfo garfo = new Garfo();
	
	public Jantar() {
		System.out.println("Iniciando o jantar");
		for(int i=0;i<5;i++) {
			Filosofo f = new Filosofo(i, this);
			filosofos[i] = f;
			new Thread(f).start();
		}
	}
	

	public void setFilosofos(Filosofo[] filosofos) {
		this.filosofos = filosofos;
	}

	public Garfo getGarfo() {
		return garfo;
	}
	
	
	public static void main(String...strings) {
		Jantar j = new Jantar();
		
	}
	
}
