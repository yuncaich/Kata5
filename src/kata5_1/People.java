package kata5_1;

public class People {
    String Nombre;
    String Apellidos;
    String departamento;
    public People(String nombre, String apellidos, String d) {
        this.Nombre = nombre;
        this.Apellidos = apellidos;
        this.departamento = d;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public String getDepartamento() {
        return departamento;
    }
        
    
}
    

