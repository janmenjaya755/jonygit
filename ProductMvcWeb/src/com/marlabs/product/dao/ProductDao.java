package com.marlabs.product.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.marlabs.product.model.Product;

public class ProductDao {
	private final String sql = "insert into  product(pid,pname)values(?,?)";

	public int save(Product product) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		int result = 0;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "janny@555");
			preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setInt(1, product.getPid());
			preparedstatement.setString(2, product.getPname());
			result = preparedstatement.executeUpdate();

		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}

		return result;
	}

}
