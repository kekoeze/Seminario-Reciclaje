package ar.edu.unrn.seminario.accesos;

import java.util.List;

import ar.edu.unrn.seminario.modelo.Propietario;


public interface PropietarioDao {

	void create(Propietario propietario);

	void update(Propietario propietario);

	void remove(Long id);

	void remove(Propietario propietario);

	Propietario find(int dni);

	List<Propietario> findAll();
}
