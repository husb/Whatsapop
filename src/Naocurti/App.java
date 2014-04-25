package Naocurti;

import java.sql.SQLException;

/**
 * 
 * @author husbeh@gmail.com
 * 
 */

public class App {

	public static void main(String[] args) throws SQLException {

		UsuarioDao e = new UsuarioDao();

		e.conectar();

		try {
			Usuario retorno = e.encontraUsuario(1);
			System.out.println("Retorno: " + retorno);
			System.out.println("Nome: " + retorno.getNome());

		

		} catch (Exception ex) {
			System.out.println("Informação não encontrada.");

		}

	}

}