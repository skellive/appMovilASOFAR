package ec.com.asofar.asofarinventory.DTO;

public class MarcasDTO {

    private Integer idMarcas;
    private String nombreMarcas;
    private String estado;

    public Integer getIdMarcas() {
        return idMarcas;
    }

    public void setIdMarcas(Integer idMarcas) {
        this.idMarcas = idMarcas;
    }

    public String getNombreMarcas() {
        return nombreMarcas;
    }

    public void setNombreMarcas(String nombreMarcas) {
        this.nombreMarcas = nombreMarcas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
