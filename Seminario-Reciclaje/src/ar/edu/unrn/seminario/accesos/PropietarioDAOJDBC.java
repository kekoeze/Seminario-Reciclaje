package ar.edu.unrn.seminario.accesos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unrn.seminario.modelo.Propietario;
import ar.edu.unrn.seminario.modelo.Rol;
import ar.edu.unrn.seminario.modelo.Usuario;

public class PropietarioDAOJDBC implements PropietarioDao{
	public void create(Propietario propietario) {
		try {

			Connection conn = ConnectionManager.getConnection();
			PreparedStatement statement = conn
					.prepareStatement("INSERT INTO Propietario(nombre, apellido, dni) "
							+ "VALUES (?, ?, ?)");
		

			statement.setString(1, propietario.getNombre());
			statement.setString(2, propietario.getApellido());
			statement.setString(3, propietario.getDni());
			
			
			
			int cantidad = statement.executeUpdate();
			if (cantidad > 0) {
				// System.out.println("Modificando " + cantidad + " registros");
			} else {
				System.out.println("Error al actualizar");
				// TODO: disparar Exception propia
			}

		} catch (SQLException e) {
			System.out.println("Error al procesar consulta");
			e.printStackTrace();
			// TODO: disparar Exception propia
		} catch (Exception e) {
			System.out.println("Error al insertar un usuario");
			// TODO: disparar Exception propia
		} finally {
			ConnectionManager.disconnect();
		}

	}

	@Override
	public void update(Propietario propietario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Propietario propietario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Propietario find(int dni) {
		Propietario propietario = null;
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement statement = conn.prepareStatement(
					"SELECT propietario.dni,  propietario.nombre,propietario.apellido, direccion.calle  ,direccion.numero,direccion.barrio "
							+ " FROM usuarios propietario JOIN  direccion ON (u.rol = r.codigo) " + " WHERE propietario.dni = ?");

			statement.setString(1, username);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				Rol rol = new Rol(rs.getInt("codigo_rol"), rs.getString("nombre_rol"));
				usuario = new Usuario(rs.getString("usuario"), rs.getString("contrasena"), rs.getString("nombre"),
						rs.getString("email"), rol);
			}

		} catch (SQLException e) {
			System.out.println("Error al procesar consulta");
			// TODO: disparar Exception propia
			// throw new AppException(e, e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			// TODO: disparar Exception propia
			// throw new AppException(e, e.getCause().getMessage(), e.getMessage());
		} finally {
			ConnectionManager.disconnect();
		}

		return usuario;
	}

	@Override
	public List<Propietario> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
