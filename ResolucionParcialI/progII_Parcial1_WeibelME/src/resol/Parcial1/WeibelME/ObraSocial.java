package resol.Parcial1.WeibelME;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

enum PlanCobertura {PMO, PMI, PME};

public class ObraSocial {
	
	HashMap <Integer,String> localidadCobertura = new HashMap<Integer,String>();
			
	private String razonSocial;
	private Domicilio domicilio;
    private ArrayList<Empleado> listaEmpleados;
    private ArrayList<Afiliado> listaAfiliados;
  
	
    public void mostrar(){
    	System.out.println("**********************************************************************************");
    	System.out.println("************************  BIENVENIDOS A "+ this.getRazonSocial().toUpperCase()+" **************************" );
    	System.out.print("**  Nos encontras en: ");
    	this.domicilio.mostrar(buscarLocalidad(this.domicilio.getLocalidad()));
    	System.out.println("**********************************************************************************");
    	System.out.println("** Se ofrecen los siguientes planes: "+ mostrarPlanes());
    	System.out.println("**********************************************************************************");
    	System.out.println("** Se presta cobertura en las siguientes localidades: ");    	
    	System.out.println(localidadCobertura);
    	this.mostrarEmpleados();
    	this.mostrarAfiliados();
    	System.out.println("**********************************************************************************");
    	System.out.println(" ");
    }
    
    
    private void mostrarEmpleados() {
    	System.out.println();
    	System.out.println("<<<<<<  LISTA DE EMPLEADOS >>>>>>");
    	if (this.listaEmpleados.isEmpty()) {System.out.println("No hay empleados registrados.");}
    	else {
    		 for(int i=0; i< this.listaEmpleados.size();i++)
    		 {
    			 this.listaEmpleados.get(i).mostrar();
    		 }
    	}
    }
    
    private void mostrarAfiliados() {
    	System.out.println();
    	System.out.println("<<<<<<  LISTA DE SOCIOS AFILIADOS >>>>>>");
       	if (this.listaAfiliados.isEmpty()) {System.out.println("No hay afiliados registrados.");}
    	else {
    		 for(int i=0; i< this.listaAfiliados.size();i++)
    		 {
    			 this.listaAfiliados.get(i).mostrar();
    		 }
    	}
    }
    
    private boolean sonFamilia(Afiliado unAfiliado, Afiliado otroAfiliado) {
    	if (    unAfiliado.getDomicilio().getCalle().equals(otroAfiliado.getDomicilio().getCalle()) &&
    			unAfiliado.getDomicilio().getNumero() == (otroAfiliado.getDomicilio().getNumero()) &&
    			unAfiliado.getDomicilio().getLocalidad() == (otroAfiliado.getDomicilio().getLocalidad()))
    		return true;
    		else return false;
    }
    
    public void detectarFiliacion() {
    	int i = 0;
    	for (int j = 1; j< this.listaAfiliados.size(); j++) {
    		if (sonFamilia(this.listaAfiliados.get(i),this.listaAfiliados.get(j))) 
    			System.out.println("Son familia: "+ this.listaAfiliados.get(0).getApellido()+", "+ this.listaAfiliados.get(0).getNombre() + " y "+ this.listaAfiliados.get(j).getApellido()+", "+ this.listaAfiliados.get(j).getNombre());
    			else System.out.println("No son familia: "+ this.listaAfiliados.get(0).getApellido()+", "+ this.listaAfiliados.get(0).getNombre()
				         + " y "+ this.listaAfiliados.get(j).getApellido()+", "+ this.listaAfiliados.get(j).getNombre());
    			 
    	}
    }
    
    //SI USARA UNA LISTA UNICA DE PERSONAS
    private void mostrarPersonas() {
   	
    }
    
   public void agregarEmpleado() {
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("[    PROCESO DE EMPLEAR     ]");
    	//String apellido, String nombre, int dni, String unaFecha, String calle, int nro, int localidad
    	System.out.print("Apellido: ");
		String ape = sc.nextLine();
    	System.out.print("Nombre: ");
		String nom = sc.nextLine();
    	System.out.print("DNI: ");
		String dni = sc.nextLine();
    	System.out.print("Fecha de nacimiento (dd/mm/yyyy): ");
		String fecNac = sc.nextLine();
    	System.out.println("DOMICILIO");
    	System.out.print("Calle: ");
		String calle = sc.nextLine();
		System.out.print("Nro: ");
		int nro = sc.nextInt();
		System.out.print("Codigo postal: ");
		int codPos = sc.nextInt();
		
		System.out.print("Seleccione un Cargo: "+ mostrarCargos()+" [A|E|D|F] ");
		String cargo = sc.nextLine();
		Cargo cargoElegido;
		
		if (cargo.equals("A")) cargoElegido = Cargo.Administrativo;
		else if (cargo.equals("E")) cargoElegido = Cargo.Especializado;
		else if (cargo.equals("D")) cargoElegido = Cargo.Directivo;
		else cargoElegido = Cargo.AgenteAfiliador;
		
		
		this.listaEmpleados.add(new Empleado(ape, nom, dni, fecNac, calle, nro, codPos,cargoElegido));
		System.out.println(" ");
    }
    
    public void agregarAfiliado() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println(" ");
    	System.out.println("[    PROCESO DE AFILIACI�N     ]");
    	//String apellido, String nombre, int dni, String unaFecha, String calle, int nro, int localidad
    	System.out.print("Apellido: ");
		String ape = sc.nextLine();
    	System.out.print("Nombre: ");
		String nom = sc.nextLine();
    	System.out.print("DNI: ");
		String dni = sc.nextLine();
    	System.out.print("Fecha de nacimiento (dd/mm/yyyy): ");
		String fecNac = sc.nextLine();
    	System.out.println("DOMICILIO");
    	System.out.print("Calle: ");
		String calle = sc.nextLine();
		System.out.print("Nro: ");
		int nro = sc.nextInt();
		System.out.print("Codigo postal: ");
		int codPos = sc.nextInt();
		
		System.out.print("Tiene alguna afecci�n previa? (Si/No): ");
		String afecPrevia = sc.nextLine();
		boolean afec;
		if (afecPrevia.equals("Si")) afec = true;
		else afec = false;
		
		
		System.out.print("Seleccione un Plan de cobertura: PMO / PMI / PME");
		String plan = sc.nextLine();
		PlanCobertura planElegido;
		if (plan.equals("PMO")) planElegido = PlanCobertura.PMO;
		else if (plan.equals("PMI")) planElegido = PlanCobertura.PMI;
		else planElegido = PlanCobertura.PME;

		System.out.println("De los siguientes agentes afiliadores:");
		mostrarAgentesAfiliadores();
		System.out.print("Seleccione su agente afiliador:");
		int agente = sc.nextInt();
		
	
		this.listaAfiliados.add(new Afiliado(ape, nom, dni, fecNac, calle, nro, codPos, afec, planElegido, obtenerEmpleadoxLegajo(agente)));
		
    }
    
   
    private void mostrarAgentesAfiliadores() {
    	for(int i = 0; i< this.listaEmpleados.size(); i++) {
    		if (this.listaEmpleados.get(i).getCargoReviste() == Cargo.AgenteAfiliador) {
    			this.listaEmpleados.get(i).mostrar();
    		}
    	}
    }
    
    
    

    private Empleado obtenerEmpleadoxLegajo(int nroLegajo) {
    	int indice = 0;
    	boolean encontrado = false;
    	while (indice < this.listaEmpleados.size() && !encontrado) {

    		if (this.listaEmpleados.get(indice).getNroLegajo() == nroLegajo) {
    			encontrado = true;
    		}
    		else indice++;
    	}

    	if (encontrado)
    	     return this.listaEmpleados.get(indice);
    	else return new Empleado();
    }
    
    
    private String mostrarPlanes() {
    	String listaPlanes= "";
    	PlanCobertura arrPlan[] = PlanCobertura.values();
        	
        for (PlanCobertura planCob : arrPlan)
        {       
            listaPlanes += " " + planCob.toString();
        }
        return listaPlanes;
    }
    
    private String mostrarCargos() {
    	String listaCargos= "";
    	Cargo arrCargo[] = Cargo.values();
        	
        for (Cargo car : arrCargo)
        {       
        	listaCargos += " " + car.toString();
        }
        return listaCargos;
    }
    
    public String buscarLocalidad(Integer codPostal) {
    	return localidadCobertura.get(codPostal);
    }
    
    public ObraSocial(String razonSocial, String calle, int numero, int localidad) {
		super();
		localidadCobertura.put(3000, "Santa Fe");
		localidadCobertura.put(3016, "Santo Tome");
		localidadCobertura.put(3018, "Recreo");
		this.razonSocial = razonSocial;
		
		this.domicilio = new Domicilio(calle, numero, localidad);
		this.listaEmpleados = new ArrayList<Empleado>(0);
		this.listaAfiliados = new ArrayList<Afiliado>(0);
		
		
	}
    
    public void agregarLocalidadCobertura(Integer codPostal, String localidad) {
    	this.localidadCobertura.put(codPostal, localidad);
    }

	
	protected String getRazonSocial() {
		return razonSocial;
	}
	protected void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	protected Domicilio getDomicilio() {
		return domicilio;
	}
	protected void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}
	protected ArrayList<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}
	protected void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}
	protected ArrayList<Afiliado> getListaAfiliados() {
		return listaAfiliados;
	}
	protected void setListaAfiliados(ArrayList<Afiliado> listaAfiliados) {
		this.listaAfiliados = listaAfiliados;
	}
    
    
    
	
}
