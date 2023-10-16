package br.com.airplane.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.airplane.Factory.ConnectionFactory;
import br.com.airplane.model.Viagem;

public class ViagemDAO {
	
	public Viagem save(Viagem viagem) {
		
		String sql = "INSERT INTO Viagem(dataViagem, horaPartida, origem, destino) VALUES (?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnection();
			
			pstm = conn.prepareStatement(sql);
			pstm.setDate(1, new Date(viagem.getDataViagem().getTime()));
			pstm.setDate(2, new Date(viagem.getHoraPartida().getTime()));
			pstm.setString(3, viagem.getOrigem());
			pstm.setString(4, viagem.getDestino());
			
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
		return viagem;
	}
	
	
public static void update(Viagem viagem) {
	
	String sql = "UPDATE viagem SET origem = ?, destino = ?" + 
	"WHERE idViagem = ?";
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	try {
		
		conn = ConnectionFactory.createConnection();
		
		pstm = conn.prepareStatement(sql);
		
		pstm.setString(1, viagem.getOrigem());
		pstm.setString(2, viagem.getDestino());
		
		pstm.setInt(3, viagem.getId());
		
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
	
	String sql = "DELETE FROM viagem WHERE idViagem = ?";
	
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
	
	

public List<Viagem> getViagem(){
		
		String sql = "SELECT * FROM Viagem";
		
		List<Viagem> Viagens = new ArrayList<Viagem>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnection();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				
				Viagem viagem = new Viagem();
				
				viagem.setDataViagem(rset.getDate("DataViagem"));
				
				viagem.setHoraPartida(rset.getDate("HoraPartida"));
				
				viagem.setDestino(rset.getString("Destino"));
				
				viagem.setOrigem(rset.getString("Origem"));
				
				viagem.add(Viagens);
				
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
			return Viagens;
		}
	}
