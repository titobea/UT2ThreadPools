import java.util.concurrent.Callable;

public class DescargaCallable implements Callable<String> {
	String archivo;
	int tiempoDescarga;
	
	public DescargaCallable(String archivo, int tiempoDescarga) {
		super();
		this.archivo = archivo;
		this.tiempoDescarga = tiempoDescarga;
	}
	
	@Override
	public String call() throws Exception {
		// TODO: esperar
		
		// TODO: devolver mensaje "Archivo X descargado en T segundos"
		return "";
	}

}
