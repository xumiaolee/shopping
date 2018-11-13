package com.study.shopping.product.model;

import java.sql.*;

public class GetProductResponse {
    private Product product;

    public GetProductResponse() throws SQLException {
        final String DB_PATH = "jdbc:sqlite:resources/shopping.db";
        String query = "SELECT * FROM `PRODUCT` WHERE id = 1";

        Connection connection = DriverManager.getConnection(DB_PATH);
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);

        this.product = new Product(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getInt("price"));
        ;
    }

    public GetProductResponse(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
