package resol.Parcial1.WeibelM;

import java.util.ArrayList;
import java.util.HashMap;



public class ObraSocial {
	
	static HashMap <Integer,String> localidadCobertura = new HashMap<Integer,String>();
	enum Cobertura {PMO, PMI, PME};
	
	private String razonSocial;
	private Domicilio domicilioOS;
	
	//Opción 2_b: manejo una lista para empleados y una lista para afiliados.
	private ArrayList<Empleado> listadoEmpleados;
	private ArrayList<Afiliado> listadoAfiliados;
	
	

	
	
	public ObraSocial(HashMap<Integer, String> localidadCobertura, String razonSocial, Domicilio domicilioOS) {
		super();
		localidadCobertura.put(3000, "Santa Fe");
		localidadCobertura.put(3016, "Santo Tome");
		localidadCobertura.put(3018, "Recreo");
		this.razonSocial = razonSocial;
		this.domicilioOS = domicilioOS;
		
		this.listadoAfiliados = new ArrayList<Afiliado>(0);
		this.listadoEmpleados = new ArrayList<Empleado>(0);
	}
	
	
	public ObraSocial() {
		localidadCobertura.put(3000, "Santa Fe");
		localidadCobertura.put(3016, "Santo Tome");
		localidadCobertura.put(3018, "Recreo");
		this.listadoAfiliados = new ArrayList<Afiliado>(0);
		this.listadoEmpleados = new ArrayList<Empleado>(0);
	}
	
	public ObraSocial(Domicilio unDomi) {
		localidadCobertura.put(3000, "Santa Fe");
		localidadCobertura.put(3016, "Santo Tome");
		localidadCobertura.put(3018, "Recreo");
		
		this.setDomicilioOS(unDomi);
		this.listadoAfiliados = new ArrayList<Afiliado>(0);
		this.listadoEmpleados = new ArrayList<Empleado>(0);
	}
	
	
	public void emplear(Empleado unEmpleado) {
		this.listadoEmpleados.add(unEmpleado);
	}
	
	private void mostrarEmpleados() {
		for(int i=0; i< this.listadoEmpleados.size();i++) {
			this.listadoEmpleados.get(i).mostrar();
		}
	}
	
    public String mostrarPlanes() {
    	String listaPlanes= "";
    	Cobertura arrPlan[] = Cobertura.values();
        	
        for (Cobertura planCob : arrPlan)
        {       
            listaPlanes += " " + planCob.toString();
        }
        return listaPlanes;
    }
	
	public void mostrar() {
		
		System.out.println("BIENVENIDOS A " + this.getRazonSocial());
		System.out.print("Sito en ");
		this.getDomicilioOS().mostrar();
		System.out.println("Estamos presentes en: " + localidadCobertura);
		System.out.println("Brindamos los siguientes planes de cobertura: " + mostrarPlanes());
		
		System.out.println("............. MI MISTA DE EMPLEADOS: .....................");
		this.mostrarEmpleados();
	}
	
	protected HashMap<Integer, String> getLocalidadCobertura() {
		return localidadCobertura;
	}
	protected void setLocalidadCobertura(HashMap<Integer, String> localidadCobertura) {
		this.localidadCobertura = localidadCobertura;
	}
	protected String getRazonSocial() {
		return razonSocial;
	}
	protected void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	protected Domicilio getDomicilioOS() {
		return domicilioOS;
	}
	protected void setDomicilioOS(Domicilio domicilioOS) {
		this.domicilioOS = domicilioOS;
	}
	
	
	

}
