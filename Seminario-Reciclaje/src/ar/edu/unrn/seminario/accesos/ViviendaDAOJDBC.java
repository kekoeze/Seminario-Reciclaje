package ar.edu.unrn.seminario.accesos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ar.edu.unrn.seminario.modelo.Direccion;
import ar.edu.unrn.seminario.modelo.Propietario;

public class ViviendaDAOJDBC {

	public void create(Propietario propietario,Direccion direccion) {
		int ultimoValor=0;
		try {

			Connection conn = ConnectionManager.getConnection();
			PreparedStatement statement = conn
					.prepareStatement("INSERT INTO Vivienda(idDireccion,dniPropietario) "
							+ "VALUES (?, ?)");
			ResultSet rst = statement.executeQuery("SELECT MAX(id) AS id FROM Direccion");
			if(rst.next()){
		        ultimoValor = rst.getInt("id");
		    }
			
			statement.setString(2,propietario.getDni());
			statement.setInt(1,ultimoValor);
			
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
}
