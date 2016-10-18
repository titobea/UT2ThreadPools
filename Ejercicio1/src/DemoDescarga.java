import java.util.Random;
import java.util.concurrent.*;


public class DemoDescarga {
	public static void main(String[] args) {
		// Completa una lista de al menos 10 URLS de descarga
	    String urlsArchivos[] = {"http://sunsite.rediris.es/mirror/ubuntu-releases/16.10/ubuntu-16.10-desktop-amd64.iso",
	    						 "http://sunsite.rediris.es/mirror/FreeBSD/ISO-IMAGES-amd64/8.2/FreeBSD-8.2-RELEASE-amd64-dvd1.iso.xz",
	    		                 "http://sunsite.rediris.es/mirror/archlinux/iso/2016.10.01/archlinux-2016.10.01-dual.iso",
	    		                 "http://sunsite.rediris.es/mirror/Lliurex/releases/14.06_64bits/releases/lliurex-escriptori-amd64_1406_20140826.iso",
	    		                 "http://sunsite.rediris.es/mirror/CentOS/7.2.1511/isos/x86_64/CentOS-7-x86_64-Everything-1511.iso", 
	    		                 "http://sunsite.rediris.es/mirror/ubuntu-releases/16.10/ubuntu-16.10-desktop-amd64.iso",
	    						 "http://sunsite.rediris.es/mirror/FreeBSD/ISO-IMAGES-amd64/8.2/FreeBSD-8.2-RELEASE-amd64-dvd1.iso.xz",
	    		                 "http://sunsite.rediris.es/mirror/archlinux/iso/2016.10.01/archlinux-2016.10.01-dual.iso",
	    		                 "http://sunsite.rediris.es/mirror/Lliurex/releases/14.06_64bits/releases/lliurex-escriptori-amd64_1406_20140826.iso",
	    		                 "http://sunsite.rediris.es/mirror/CentOS/7.2.1511/isos/x86_64/CentOS-7-x86_64-Everything-1511.iso" 
	    		                };
	    
	    // TODO: crear el ExecuteService. El thread pool debe ser fijo (2 threads).
	    ExecutorService threadPool = Executors.newFixedThreadPool(2);
	    // TODO: crear el CompletionService
	    CompletionService<String> pool = new ExecutorCompletionService<String>(threadPool);
	    
	    // TODO: iterar y añadir los callables parametrizados con urlsArchivos y un tiempo
	    // variable de 10 a 20 segundos.
	    Random rand = new Random();
	    for(int i = 0; i < urlsArchivos.length; i++){
	    	pool.submit(new DescargaCallable(urlsArchivos[i],rand.nextInt(11) + 10));
	    	}
	    
	    // TODO: imprimir los resultados a medida que los recibimos.
	    for(int i = 0; i < urlsArchivos.length; i++){	
	    	
			try {				
				String result = pool.take().get();
				// TODO: Imprimir el estado del thread pool después de recibir un archivo (toString)
				System.out.println(threadPool.toString());
				System.out.println(result);
			} catch (InterruptedException e) {		
				e.printStackTrace();
			} catch (ExecutionException e) {				
				e.printStackTrace();
			}	    	   
	    }
  
	    
	    // TODO: parar el thread pool de forma ordenada.
	    threadPool.shutdown();
		
	}

}
