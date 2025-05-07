package Models;

public class ClientSesion {
	private static ClientSesion instance;
	private Person client;
	
	private ClientSesion() {}
	
	public static ClientSesion getInstance() {
		if(instance != null) {
			instance = new ClientSesion();
		}
		
		return instance;
	}
	
	public void setClient(Person client) {
		this.client = client;
	}
	
	public Person getClient() {
		return client;
	}
	
	public void closeSesion() {
		instance = null;
	}

}
