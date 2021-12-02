package ec.com.asofar.asofarinventory.DTO;

import java.util.List;

public class ListLog {

    List<UsuarioDTO> usuario;
    String respuesta;

    public List<UsuarioDTO> getUsuario() {
        return usuario;
    }

    public void setUsuario(List<UsuarioDTO> usuario) {
        this.usuario = usuario;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
