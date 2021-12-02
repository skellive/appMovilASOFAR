package ec.com.asofar.asofarinventory.DTO;

public class MedidasDTO {

    private Integer idMedidas;
    private String nombreMedida;
    private String estado;

    public Integer getIdMedidas() {
        return idMedidas;
    }

    public void setIdMedidas(Integer idMedidas) {
        this.idMedidas = idMedidas;
    }

    public String getNombreMedida() {
        return nombreMedida;
    }

    public void setNombreMedida(String nombreMedida) {
        this.nombreMedida = nombreMedida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
