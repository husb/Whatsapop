package Naocurti;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * 
 * @author husbeh@gmail.com
 * 
 */
public class UsuarioDao {

	private static final String selectUsuario = "select * from usuarios where cod = ?";

	private Connection con = null;

	 public void conectar() {

         try {
             Class.forName("org.postgresql.Driver");
             String url = "jdbc:postgresql://localhost:5432/Estoque";
             String user = "postgres";
             String password = "senacrs";

                 con = DriverManager.getConnection(url, user, password);
         } catch (Exception e) {
                 System.out.println("Erro ao estabelecer conexao.");
                 e.printStackTrace();
         }

 }

	/**
	 * 
	 * Encontra o usuário dado o código. Retorna null se o código não for
	 * encontrado.
	 * 
	 * @param cod
	 *            é o código do usuário
	 * @return é null caso não encontrado.
	 * 
	 */
	public Usuario encontraUsuario(int cod) {

		// System.out.println("cod = " + cod);

		Usuario c = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.prepareStatement(selectUsuario);
			stmt.setInt(1, cod);
			rs = stmt.executeQuery();

			if (rs.next()) {
				int codi = rs.getInt("cod");
				String nome = rs.getString("nome");
				// System.out.println("NOME: " + nome);
				// String pass = rs.getString("senha");
				String pass = null;
				c = new Usuario(codi, nome, pass);
			}

		} catch (Exception e) {

			System.out.println("Informações não encontradas.");
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return c;
	}
}

	