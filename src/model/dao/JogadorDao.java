package model.dao;

import java.util.List;

import model.entities.Jogador;

public interface JogadorDao {

	void insert(Jogador obj);
	List<Jogador> findAll();
}
