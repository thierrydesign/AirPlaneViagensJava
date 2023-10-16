package br.com.airplane.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.airplane.Factory.ConnectionFactory;
import br.com.airplane.model.Usuario;

public class UsuarioDAO {

public Usuario save(Usuario usuario) {
		
		String sql = "INSERT INTO Usuario(login, nome, senha) VALUES (?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnection();
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, usuario.getLogin());
			pstm.setString(2, usuario.getNome());
			pstm.setString(3, usuario.getSenha());
			
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
		return usuario;
	}


public static void update(Usuario usuario) {
	
	String sql = "UPDATE usuario SET login = ?, senha = ?" + 
	"WHERE idUsuario = ?";
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	try {
		
		conn = ConnectionFactory.createConnection();
		
		pstm = conn.prepareStatement(sql);
		
		pstm.setString(1, usuario.getLogin());
		pstm.setString(2, usuario.getSenha());
		
		pstm.setInt(3, usuario.getId());
		
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
	
	String sql = "DELETE FROM usuario WHERE idUsuario = ?";
	
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

public List<Usuario> getUsuario(){
	
	String sql = "SELECT * FROM Usuario";
	
	List<Usuario> Usuario = new ArrayList<Usuario>();
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	ResultSet rset = null;
	
	try {
		conn = ConnectionFactory.createConnection();
		
		pstm = conn.prepareStatement(sql);
		
		rset = pstm.executeQuery();
		
		while (rset.next()) {
			
			Usuario usuario = new Usuario();
			
			usuario.setLogin(rset.getString("Login"));
			
			usuario.setNome(rset.getString("Nome"));
			
			usuario.setSenha(rset.getString("Senha"));
			
			usuario.add(Usuario);
			
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
		return Usuario;
	}
}
	

