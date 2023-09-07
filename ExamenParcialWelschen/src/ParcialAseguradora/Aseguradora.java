package ParcialAseguradora;

import java.util.ArrayList;
import java.util.Scanner;

public class Aseguradora {
	private static Scanner input = new Scanner(System.in);
	private String razonSocial;
	private ArrayList<Cliente> listaCliente;
	private ArrayList<Vehiculo> listaVehiculo;
	private ArrayList<Poliza> listaPoliza;
	
	public Aseguradora() {
		super();
	}
	public Aseguradora(String razonSocial, ArrayList<Cliente> listaCliente, ArrayList<Vehiculo> listaVehiculo,
			ArrayList<Poliza> listaPoliza) {
		super();
		this.razonSocial = razonSocial;
		this.listaCliente =  new ArrayList<Cliente>();
		this.listaVehiculo =  new ArrayList<Vehiculo>();
		this.listaPoliza =  new ArrayList<Poliza>();
	}
	public void agregarCliente() {
		this.listaCliente.add(new Cliente());
	}
	public void agregarCliente(Cliente cliente) {
		this.listaCliente.add(cliente);
	}
	public void agregarVehiculo() {
		System.out.println("Ingrese 1 si quiere agregar un taxi o 2 si es autobus ");
		int tipo =input.nextInt();
		if (tipo==1) {
		this.listaVehiculo.add(new Taxi());
	
		}else if(tipo==2) {
			this.listaVehiculo.add(new Autobus());
		}else {
		System.out.println("El valor ingresado es incorrecto");	
		}
		}
	public void agregarTaxi(Taxi taxi) {
		this.listaVehiculo.add(taxi);
	}
	public void agregarAutobus(Autobus autobus) {
		this.listaVehiculo.add(autobus);
	}
	public void agregarPoliza(Poliza poliza) {
		listaPoliza.add(poliza);
	}
	public void agregarPoliza() {
			System.out.println("Ingrese el DNI de la persona");
			int dni = input.nextInt();
			Cliente cliente;
			if (buscarXDocumento(dni)==-1) {
				System.out.println("no se encontro");
				cliente = new Cliente();
				listaCliente.add(cliente);
				
			}else {
				cliente=listaCliente.get(buscarXDocumento(dni));
			}
			System.out.println("Ingrese matricula de vehiculo:");
			input.nextLine();
			String matr = input.nextLine();
			Vehiculo vehiculo;
			int indice= buscarVehiculoXMatricula(matr);
			if (indice==-1) {
				System.out.println("NO SE ENCONTRO, A CONTINUACION CARGAR NUEVO");
				System.out.println("Que desea cargar: 1)Taxi, 2)Autobus");
				int w=input.nextInt();
				switch(w) {
				case 1: 
					vehiculo= new Taxi();
					listaVehiculo.add(vehiculo);
					break;
				case 2: 
					vehiculo=new Autobus();
					listaVehiculo.add(vehiculo);
					break;
					default:
						System.out.println("opcion no valida, por defecto taxi.");
						vehiculo= new Taxi();
						listaVehiculo.add(vehiculo);
				}
			}else {
				vehiculo=listaVehiculo.get(indice);
			}
			Poliza poliza = new Poliza(vehiculo,cliente);
			listaPoliza.add(poliza);
		}
	public void mostrar() {
		System.out.println("Bienvenido a "+this.razonSocial+"\n");
	}
	public void mostrarCliente() {
		System.out.println("-------Lista de clientes---------");
		if (this.listaCliente.isEmpty()) {System.out.println("No hay clientes registrados.");}
    	else {
    		 for(int i=0; i< this.listaCliente.size();i++){
    			 this.listaCliente.get(i).mostrar();
    	}
    	}
	}
	public void mostrarPoliza() {
		System.out.println("-------Lista de polizas----------");
		if (this.listaPoliza.isEmpty()) {System.out.println("No hay polizas registradas.");}
    	else {
    		 for(int i=0; i< this.listaPoliza.size();i++){
    			 this.listaPoliza.get(i).mostrar();
    			 this.listaPoliza.get(i).mostrarCuota();
    			 
    		 }
    	}
    	}
	public void mostrarVehiculo() {
		System.out.println("-------Lista de vehiculos----------");
		if (this.listaVehiculo.isEmpty()) {System.out.println("No hay vehiculos registrados.");}
    	else {
    		 for(int i=0; i< this.listaVehiculo.size();i++){
    			 this.listaVehiculo.get(i).mostrar();
    		 }
    	}
	}
	public void mostrarVehiculoTipo() {
		System.out.println("Ingrese 1 para mostrar Taxis o 2 para mostrar Autobuses:");
		int opt=input.nextInt();
		if(opt==1) {
		for (int i=0;i<listaVehiculo.size();i++) {
			if(listaVehiculo.get(i) instanceof Taxi) {
				listaVehiculo.get(i).mostrar();
			}
		}
	}else if(opt==2) {
		for (int i=0;i<listaVehiculo.size();i++) {
			if(listaVehiculo.get(i) instanceof Autobus) {
				listaVehiculo.get(i).mostrar();
			}
		}
	}else {
		System.out.println("El valor ingresado es incorrecto");
	}
	}
	public void buscarVehiculoXMatriculaYMostrar() {
		System.out.println("Ingrese la matricula del vehiculo que desea buscar:");
		String mat=input.nextLine();
			for (Vehiculo vehiculo : listaVehiculo) {
	            if (vehiculo.getMatricula().equals(mat)) {
	                vehiculo.mostrar();
	            }
	        }
	        System.out.println("El vehiculo no se encuentra registrado \n");
	}
	public int buscarVehiculoXMatricula(String matricula) {
		for(int i=0;i<listaCliente.size();i++) {
			if(matricula.equals(listaVehiculo.get(i).getMatricula())) {
				return i;
			}
		}
		return -1;
	}
	public void buscarVehiculoXCobertura() {
		System.out.println("Ingrese filtro: 1)Total, 2)Contra Terceros, 3)Parcial");
		int o=input.nextInt();
		switch(o) {
		case 1:
			for(int i=0;i<listaPoliza.size();i++) {
				if(listaPoliza.get(i).getTipoCobertura().equals(TipoCobertura.Total)) {
					listaPoliza.get(i).getVehiculo().mostrar();
				}
			}
			break;
		case 2:
			for(int i=0;i<listaPoliza.size();i++) {
				if(listaPoliza.get(i).getTipoCobertura().equals(TipoCobertura.ContraTerceros)) {
					listaPoliza.get(i).getVehiculo().mostrar();
				}
			}
			break;
		case 3:
			for(int i=0;i<listaPoliza.size();i++) {
				if(listaPoliza.get(i).getTipoCobertura().equals(TipoCobertura.Parcial)) {
					listaPoliza.get(i).getVehiculo().mostrar();
				}
			}
			break;
		default:
			System.out.println("No ingreso opcion valida.");
		break;
		}
	}
	public void buscarClienteXDNIMostrar() {
		System.out.println("Ingrese el documento de la persona que desea buscar:");
		int doc=input.nextInt();
			for (Cliente cliente : listaCliente) {
	            if (cliente.getDni()==doc) {
	                cliente.mostrar();	
	            }
	        }
	        System.out.println("El cliente buscado no se encuentra registrado \n");
	}
	public int buscarXDocumento(int dni) {
		for(int i=0;i<listaCliente.size();i++) {
			if(dni==listaCliente.get(i).getDni()) {
				return i;
			}
		}
		return -1;
	}

	public void listarPolizaXCobertura() {
		System.out.println("Ingrese el tipo de cobertura: -- 1-Total 2-Contra Terceros 3- Parcial --");
		int cob=input.nextInt();
		String a="Total", b="ContraTerceros", c="Parcial";
		if(cob==1) {;
			for (Poliza poliza : listaPoliza) {
				if (poliza.getTipoCobertura().equals(TipoCobertura.Total)) {
					poliza.mostrar();
            }
        }
		}else if(cob==2) {
		for (Poliza poliza : listaPoliza) {
			if (poliza.getTipoCobertura().equals(TipoCobertura.ContraTerceros)) {
				poliza.mostrar();
        }
		}
		}else if(cob==3) {
		for (Poliza poliza : listaPoliza) {
			if (poliza.getTipoCobertura().equals(TipoCobertura.Parcial)) {
				poliza.mostrar();
        }
		}
		}else {
			System.out.println("El numero ingresado es incorrecto");
		}
	}
	public int buscarPolizaPorVehiculo(Vehiculo vehiculo){
		for(int i=0;i<listaPoliza.size();i++) {
			if(listaPoliza.get(i).getVehiculo().equals(vehiculo)) {
				return i;
			}
		}
		return -1;
	}
	public void pagarCuota() {
		System.out.println("Ingrese matricula de vehiculo: ");
		String matri=input.nextLine();
		int indiceVehiculo=buscarVehiculoXMatricula(matri);
		if (indiceVehiculo!=-1) {
			int indicePoliza=buscarPolizaPorVehiculo(listaVehiculo.get(indiceVehiculo));
			if (indicePoliza!=-1) {
				System.out.println("cuotas: ");
				listaPoliza.get(indicePoliza).mostrarCuota();
				int indiceProximaCuota=listaPoliza.get(indicePoliza).proxCuotaImpaga();
				System.out.println("Ingrese forma de pago (1)Efectivo, 2)Tansferencia, 3)Debito automatico");
				int opcion = input.nextInt();
				FormaPago fPago;
				switch (opcion) {
				case 1: 
					fPago=FormaPago.Efectivo;
					break;
				case 2:
					fPago=FormaPago.Transferencia;
					break;
				case 3:
					fPago=FormaPago.DebitoAutomatico;
					break;
					default:
						System.out.println("Numero ingresado incorrecto, se asigna Efectivo por defecto");
						fPago=FormaPago.Efectivo;
				}
				System.out.println("Ingrese fecha de pago: ");
				input.nextLine();
				String fecha=input.nextLine();
				listaPoliza.get(indicePoliza).cuotaPagada(indiceProximaCuota, fPago, fecha);
			}else {
				System.out.println("No se encontro poliza registrada a ese vehiculo!");
			}
		}else {
			System.out.println("No se encontro vehiculo con esa matricula!!");
		}
	}
	public void estadisticas() {
		mostrar();
		int totC=0;
		for(int i=0;i<listaCliente.size();i++) {
			totC=totC+1;
		}
		int totV=0;
		int totT=0;
		int totA=0;
		for(int i=0;i<listaVehiculo.size();i++) {
			totV=totV+1;
			if(listaVehiculo.get(i) instanceof Taxi) {
				totT=totT+1;
			}else if (listaVehiculo.get(i) instanceof Autobus) {
				totA=totA+1;
			}
		}
		System.out.println("El total de clientes registrados es: "+totC+", de vehiculos: "+totV
				+"\nde los cuales: "+ totT +" son taxis y "+totA+" autobuses");
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public ArrayList<Cliente> getListaCliente() {
		return listaCliente;
	}
	public void setListaCliente(ArrayList<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}
	public ArrayList<Vehiculo> getListaVehiculo() {
		return listaVehiculo;
	}
	public void setListaVehiculo(ArrayList<Vehiculo> listaVehiculo) {
		this.listaVehiculo = listaVehiculo;
	}
	public ArrayList<Poliza> getListaPoliza() {
		return listaPoliza;
	}
	public void setListaPoliza(ArrayList<Poliza> listaPoliza) {
		this.listaPoliza = listaPoliza;
	}	
}
