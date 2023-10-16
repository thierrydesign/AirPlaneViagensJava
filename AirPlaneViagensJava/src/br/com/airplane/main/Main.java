package br.com.airplane.main;


import java.sql.SQLException;
import java.util.Date;

import br.com.airplane.dao.ViagemDAO;
import br.com.airplane.model.Passageiro;
import br.com.airplane.model.Usuario;
import br.com.airplane.model.Viagem;
import br.com.airplane.dao.PassageiroDAO;
import br.com.airplane.dao.UsuarioDAO;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		ViagemDAO viagemDao = new ViagemDAO();
		
		Viagem viagem = new Viagem();
		viagem.setDataViagem(new Date());
		viagem.setHoraPartida(new Date());
		viagem.setDestino("Alagoa Grande");
		viagem.setOrigem("João Pessoa");
		
		//viagemDao.save(viagem);
		
		Viagem v1 = new Viagem();
		v1.setOrigem("Rio de Janeiro");
		v1.setDestino("Alagoa Grande");
		v1.setId(4);
		
		//ViagemDAO.update(v1);
		
		//ViagemDAO.deleteByID(2);
		
		for(Viagem c : viagemDao.getViagem()) {
			System.out.println("Viagem: " + c.getOrigem());
		}
			
		
		
			
		//==========> PASSAGEIRO <==========
			
		PassageiroDAO passageiroDao = new PassageiroDAO();
			
		Passageiro passageiro = new Passageiro();
		passageiro.setCpf("111111111");
		passageiro.setNome("Thierry Guedes");
		passageiro.setRg("333333");
		passageiro.setTelefone("83991273411");
			
		//passageiroDao.save(passageiro);	
		
		Passageiro p1 = new Passageiro();
		p1.setNome("Thierry Lima");
		p1.setTelefone("83991273400");
		p1.setId(1);
		
		//PassageiroDAO.update(p1);
		
		
		//PassageiroDAO.deleteByID(1);
		
		
		for(Passageiro p : passageiroDao.getPassageiro()) {
			System.out.println("Passageiro: " + p.getNome());
		}
			
		
		
		
		//==========> USUARIO <==========
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		
		Usuario usuario = new Usuario();
		usuario.setLogin("livia");
		usuario.setNome("Livia Chaves");
		usuario.setSenha("1234567");
		
		//usuarioDao.save(usuario);
		
		Usuario u1 = new Usuario();
		u1.setLogin("livinha");
		u1.setSenha("12398");
		u1.setId(2);
		
		//UsuarioDAO.update(u1);
		
		//UsuarioDAO.deleteByID(2);
		
		for(Usuario u : usuarioDao.getUsuario()) {
			System.out.println("Usuario: " + u.getNome());
		}
		
	}

}
