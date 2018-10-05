package pe.edu.unmsm.sistemas.appclinica.reserve.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RespuestaEspecialidades {

    @JsonProperty("data")
    private List<Especialidad> data;

    public List<Especialidad> getData() {
        return data;
    }

    public void setData(List<Especialidad> data) {
        this.data = data;
    }
}
