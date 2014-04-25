package Naocurti;

public class Usuario {


	private int cod;
	private String nome;
	private String senha;

	public Usuario() {}

	public Usuario(int cod, String nome, String senha) {
		super();
		this.cod = cod;
		this.nome = nome;
		this.senha = senha;
	}

	public int getCod() {
		return cod;
	}

	public String getNome() {
		return nome;
	}
	public String getSenha() {
		return senha;
	}

	public String toString() {
		return "Usuario [cod=" + cod + ", nome=" + nome + ", senha=" + senha + "]";
	}

}

