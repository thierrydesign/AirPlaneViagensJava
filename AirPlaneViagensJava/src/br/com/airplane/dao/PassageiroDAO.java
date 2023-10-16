package br.com.airplane.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.airplane.Factory.ConnectionFactory;
import br.com.airplane.model.Passageiro;

public class PassageiroDAO {
	
	public void save(Passageiro passageiro) {
		
		String sql = "INSERT INTO Passageiro(cpf, nome, rg, telefone) VALUES (?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnection();
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, passageiro.getCpf());
			pstm.setString(2, passageiro.getNome());
			pstm.setString(3, passageiro.getRg());
			pstm.setString(4, passageiro.getTelefone());
			
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void update(Passageiro passageiro) {
		
		String sql = "UPDATE passageiro SET nome = ?, telefone = ?" + 
		"WHERE idPassageiro = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionFactory.createConnection();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, passageiro.getNome());
			pstm.setString(2, passageiro.getTelefone());
			
			pstm.setInt(3, passageiro.getId());
			
			pstm.execute();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void deleteByID(int id) {
		
		String sql = "DELETE FROM passageiro WHERE idPassageiro = ?";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnection();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	

	public List<Passageiro> getPassageiro() throws SQLException{
		
		String sql = "SELECT * FROM Passageiro";
		
		List<Passageiro> Passageiro = new ArrayList<Passageiro>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnection();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				
				Passageiro passageiro = new Passageiro();
				
				passageiro.setId(rset.getInt("idPassageiro"));
				
				passageiro.setCpf(rset.getString("cpf"));
				
				passageiro.setNome(rset.getString("nome"));
				
				passageiro.setRg(rset.getString("rg"));
				
				passageiro.setTelefone(rset.getString("telefone"));
				
				passageiro.add(Passageiro);
				
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
				if(rset!=null) {
					rset.close();
				}
				
				if(pstm!=null); {
					pstm.close();
				}
				
				if(conn!=null);{
					conn.close();
				}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			return Passageiro;
		}
}