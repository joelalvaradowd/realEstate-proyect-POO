/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author User
 */
public abstract class Usuario {

    private String user;
    private String password;
    private String cedula;
    private String nombre;
    private String correo;

    public Usuario(String user, String password, String cedula, String nombre, String correo) {
        this.nombre = nombre;
        this.password = password;
        this.cedula = cedula;
        this.user = user;
        this.correo = correo;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    @Override
    public boolean equals(Object o){
        if(o!=null && o instanceof Usuario){
            Usuario u = (Usuario) o;
            if(user.equals(u.user) && password.equals(u.password)) return true;
        }
        return false;
    }
    
    public abstract void mostrarMenu();

    @Override
    public String toString() {
        return "Usuario{" + "user=" + user + ", password=" + password + ", cedula=" + cedula + ", nombre=" + nombre + ", correo=" + correo + '}';
    }
      

}
