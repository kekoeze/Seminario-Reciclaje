package ar.edu.unrn.seminario.api;

import ar.edu.unrn.seminario.dto.RolDTO;
import ar.edu.unrn.seminario.dto.UsuarioDTO;
import ar.edu.unrn.seminario.dto.ViviendaDTO;
import ar.edu.unrn.seminario.herramienta.Fecha;
import ar.edu.unrn.seminario.modelo.Direccion;
import ar.edu.unrn.seminario.modelo.Propietario;
import ar.edu.unrn.seminario.modelo.Rol;
import ar.edu.unrn.seminario.modelo.Vivienda;
import java.util.Calendar;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ModeloException.NotNullException;

public class MemoryApi implements IApi{

    private List<Vivienda> viviendas= new ArrayList<>();
    private List<Rol> roles= new ArrayList<>();

    //VIVIENDA
    
	@Override
    public void registrarVivienda(String nombre,String apellido,String dni,String calle,String numeroCalle,String barrio) throws NotNullException {
		Propietario propietario=new Propietario(nombre,apellido,dni);
		Direccion direccion=new Direccion(calle,numeroCalle,barrio);
        Vivienda vivienda= new Vivienda(propietario, direccion);
        
        viviendas.add(vivienda);
    }

  
    
	@Override
	public List<ViviendaDTO> obtenerViviendas() {
		List<ViviendaDTO> dtos = new ArrayList<>();
		for (Vivienda v : this.viviendas) {
			System.out.println("el dni:"+v.getPropietario().getDni());
			dtos.add(new ViviendaDTO(v.getPropietario(),v.getDireccion()));
		}
		return dtos;
	}
    /*@Override
    public void emilinarVivienda(String direccion) {

    }*/

 



    //USUARIOS
    @Override
    public void registrarUsuario(String username, String password, String email, String nombre, Integer rol) {

    }

    @Override
    public UsuarioDTO obtenerUsuario(String username) {
        return null;
    }

    @Override
    public void eliminarUsuario(String username) {

    }

    @Override
    public List<UsuarioDTO> obtenerUsuarios() {
        return null;
    }

    @Override
    public void activarUsuario(String username) {

    }

    @Override
    public void desactivarUsuario(String username) {

    }

    //ROLES
    @Override
    public List<RolDTO> obtenerRoles() {
        List<RolDTO> dtos = new ArrayList<>();
        for (Rol r : roles) {
            dtos.add(new RolDTO(r.getNombre(), r.estaActivo()));
        }
        return dtos;
    }

    @Override
    public List<RolDTO> obtenerRolesActivos() {
        return null;
    }

    @Override
    public void guardarRol(String nombre, boolean estado) {

        Rol rol= new Rol(nombre, estado);
        roles.add(rol);

    }

    @Override
    public RolDTO obtenerRolPorCodigo(Integer codigo) {
        return null;
    }

    @Override
    public void activarRol(Integer codigo) {

    }

    @Override
    public void desactivarRol(Integer codigo) {

    }



	@Override
	public ViviendaDTO obtenerVivienda() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void emilinarVivienda() {
		// TODO Auto-generated method stub
		
	}
}
