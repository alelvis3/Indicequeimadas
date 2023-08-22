package br.com.indicequeimadas.banco;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.indicequeimadas.arquivos.Arquivo;
import br.com.indicequeimadas.inicio.Principal;
import br.com.indicequeimadas.utilidades.jFileChooser;

public class DB {
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;

	/**

	*

	*	@param dbName String - BANCO DE DADOS QUE SERA CONECTADO

	*/

	public static void connect(String dbName) {

	if (Arquivo.Existe(new File(dbName))) {// VERIFICANDO SE EXISTE O ARQUIVO
	if (connection != null)

	return;// SE JA ESTIVER CONECTADO IRA RETORNAR

	try {// IRA TENTAR CONECTAR

	Class.forName("org.sqlite.JDBC");
	
	connection	=
			DriverManager.getConnection("jdbc:sqlite:" + dbName);

			} catch (SQLException e) { System.err.println(e.getMessage());
			} catch (ClassNotFoundException e) { e.printStackTrace();
			}

			} else {// SE NAO EXISTIR O ARQUIVO IRA SOLICITAR PARA SELEICONAR

			do {

			Principal.getVisualizar().bancoSelecionado
			= jFileChooser.FileChooserSave();

			}	while
			(!Principal.getVisualizar().bancoSelecionado.toUpperCase().endsW ith(".DB"));


			connect(Principal.getVisualizar().bancoSelecionado);

			}

			}

	/**
	 *
	 * 
	 * 
	 * @param strQuery String- COMANDO QUE SERA EXECUTADO.
	 * 
	 * @return ResultSet - TERA O RESULTADO DO COMANDO strQuery EM FORMA DE
	 *         ResultSet.
	 * 
	 */

	public static ResultSet query(String strQuery) {
		try {

			statement = connection.createStatement();
			resultSet = statement.executeQuery(strQuery);
			return resultSet;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

		return resultSet;

	}

	/**
	 *
	 * 
	 * 
	 * @param strQuery String - COMANDO QUE SERA EXECUTADO.
	 * 
	 * @return boolean - RETORNA SE FOI POSSIVEL EXECUTAR O COMANDO.
	 */

	public static boolean execQuery(String strQuery) {
		try {
			statement = connection.createStatement();

			statement.setQueryTimeout(10); // set timeout to 30 sec.

			statement.executeUpdate(strQuery);
			statement.close();
			return true;

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return false;
	}

}
