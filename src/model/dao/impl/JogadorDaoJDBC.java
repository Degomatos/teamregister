package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.JogadorDao;
import model.entities.Jogador;

public class JogadorDaoJDBC implements JogadorDao{

	private Connection conn;
	
	public JogadorDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Jogador obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
							"INSERT INTO jogador "
							+"(Name, Modality, Height, Age, Position, Team) "
							+"VALUES "
							+"(?, ?, ?, ?, ?, ?)"
							);
			st.setString(1, obj.getName());
			st.setString(2, obj.getModality());
			st.setDouble(3, obj.getHeight());
			st.setInt(4, obj.getAge());
			st.setString(5, obj.getPosition());
			st.setString(6, obj.getTeam());
			
			st.executeUpdate();
			
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public List<Jogador> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM jogador ORDER BY Team");
			rs = st.executeQuery();
			List<Jogador> list = new ArrayList<>();
			
			while(rs.next()) {
				Jogador jogador = instantiateJogador(rs);
				list.add(jogador);
			}
			return list;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

//Methods
	private Jogador instantiateJogador(ResultSet rs) throws SQLException {
		Jogador jogador = new Jogador();
		jogador.setName(rs.getString("Name"));
		jogador.setHeight(rs.getDouble("Age"));
		jogador.setAge(rs.getInt("Age"));
		jogador.setPosition(rs.getString("Position"));
		jogador.setModality(rs.getString("Modality"));
		jogador.setTeam(rs.getString("Team"));
		return jogador;
	}

}
