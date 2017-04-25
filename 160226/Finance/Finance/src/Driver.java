public class Driver {
	public static void main(String[] args)
	{
		new Enviroment();
	}
}

class Enviroment {
	
	private GUI 		window;
	private Connector 	conn;
	
	public Enviroment()
	{
		window = new GUI();
		conn = new Connector();	
	}
}
