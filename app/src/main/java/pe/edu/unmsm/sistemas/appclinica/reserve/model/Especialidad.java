package pe.edu.unmsm.sistemas.appclinica.reserve.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Especialidad implements Serializable {
    @JsonProperty("idEspecialidad")
    private String idEspecialidad;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("descripcion")
    private String descripcion;

    public String getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(String idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
