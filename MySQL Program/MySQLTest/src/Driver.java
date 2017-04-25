public class Driver{
	public static void main(String[] args){
		new Environment();
	}
}

class Environment
{
	private Connector 	connector;
	private Model 		model;
	private Data 		data;
	
	public Environment() 
	{
		data = new Data();
		model = new Model(data);
		connector = new Connector(data);
		
		//connector.login();
	}
}