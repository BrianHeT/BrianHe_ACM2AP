class Propiedad {
    private String propiedad;
    private int tipo; 
    private int ubicacion; 
    private int size; 
    private boolean estado; 
    private double valor;

    public Propiedad(String propiedad, int tipo, int ubicacion, int size, boolean estado, double valor) {
        this.propiedad = propiedad;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.size = size;
        this.estado = estado;
        this.valor = valor;
    }

    public String getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(String propiedad) {
        this.propiedad = propiedad;
    }
    
    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo; 
    }
    
    public int getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(int ubicacion) {
        this.ubicacion = ubicacion; 
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size; 
    }

    public boolean estaDisponible() {
        return !estado; 
    }

    public void alquilar() {
        estado = true;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor; 
    }
    public static double valorTipo(int tipo) {
        switch (tipo) {
            case 0: return 1.1; 
            case 1: return 1.25; 
            case 2: return 1.5; 
            default: return 1; 
        }
    }

    public static double valorUbicacion(int ubicacion) {
        switch (ubicacion) {
            case 0: return 0.8; 
            case 1: return 1.1;  
            case 2: return 1.25; 
            default: return 1;  
        }
    }

    public static double valorSize(int size) {
        switch (size) {
            case 0: return 1; 
            case 1: return 1.2; 
            case 2: return 1.5; 
            default: return 1;  
        }
    }

	@Override
	public String toString() {
		return "Propiedad [propiedad=" + propiedad + ", tipo=" + tipo + ", ubicacion=" + ubicacion + ", size=" + size
				+ ", estado=" + estado + ", valor=" + valor + "]";
	}
}

