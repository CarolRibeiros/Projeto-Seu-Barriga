package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import readers.Config;

public class DataBaseGenerator {

	public static void CreateTable(String nome) throws ClassNotFoundException, SQLException {
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:file:" + Config.getProperty("path.banco"), "sa", "");
		Statement stmt = conn.createStatement();
		String sql = "CREATE TABLE " + nome + " (URL varchar, " + "USER varchar(150), " + "EMAIL varchar(150), "
				+ "SENHA varchar(150), " + "NOME varchar(150), " + "TIPO_MOVIMENTA플O varchar(150), "
				+ "DESCRI플O varchar(150), " + "INTERESSADO varchar(150), " + "VALOR varchar(150), "
				+ "CONTA varchar(150) )," + "EMAIL_INVALIDO varchar()150," + "SENHA_INVALIDA varchar()150,";
		stmt.execute(sql);
	}

	public static void InsertTable(String name) throws ClassNotFoundException, SQLException {
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:file:" + Config.getProperty("path.banco"), "sa", "");
		Statement stmt = conn.createStatement();
		String sqlInsert = "INSERT INTO " + name + " (URL, USER, EMAIL, SENHA, NOME, TIPO_MOVIMENTA플O, "
				+ "DESCRI플O, INTERESSADO, VALOR, CONTA, EMAIL_INVALIDO, SENHA_INVALIDA) "
				+ "VALUES ('https://seubarriga.wcaquino.me/login', 'tester','tester@sempreit.com.br', "
				+ "'tester', 'Gasolina', 'Receita', 'Testes', 'Roberto', '150', 'Gasolina', 'testerinvalid@sempreit.com.br',"
				+ "'testerinvalid');";
		stmt.execute(sqlInsert);
	}

	public static String returnData(String table, String coluna) throws ClassNotFoundException, SQLException {
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:file:" + Config.getProperty("path.banco"), "sa", "");
		Statement stmt = conn.createStatement();
		String data = null;
		ResultSet resultSet = SelectTable(stmt, table);
		while (resultSet.next()) {
			data = resultSet.getString("URL");

		}

		stmt.close();
		conn.close();

		return data;
	}

	public static ResultSet SelectTable(Statement stmt, String name) throws ClassNotFoundException, SQLException {
		String sqlSelect = "SELECT * FROM " + name + ";";
		ResultSet resultSet = stmt.executeQuery(sqlSelect);
		return resultSet;
	}

	public static ResultSet resultSet() throws Exception {
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:file:" + Config.getProperty("path.banco"), "sa", "");
		Statement stmt = conn.createStatement();
		ResultSet resultSet = SelectTable(stmt, "BarrigaDB");

		return resultSet;
	}

	public static void main(String[] args) throws Exception {
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection(Config.getProperty("path.banco"), "sa", "");
		Statement stmt = conn.createStatement();

		CreateTable("BarrigaDB");
		InsertTable("BarrigaDB");
		ResultSet resultSet = SelectTable(stmt, "BarrigaDB");
		while (resultSet.next()) {
			System.out.println(resultSet.getString("URL"));
		}

		stmt.close();
		conn.close();
	}
}
