package com.ps.data;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.ps.models.Transaction;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class TransactionDaoImpl implements TransactionDaoInt {

    private DataSource dataSource;

    public TransactionDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Transaction> getAll() {
        return List.of();
    }

    @Override
    public Transaction getById(int id) {
        String query = "SELECT * FROM transactions WHERE transaction_id = ?";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(query);
        ) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return mapTransaction(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Transaction create(Transaction transaction) {
        String query = "INSERT INTO transactions (date,time,description,vendor,amount) " +
                       "VALUES (?,?,?,?,?)";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
        ) {

            statement.setDate(1, Date.valueOf(transaction.getDate()));
            statement.setTime(2, Time.valueOf(transaction.getTime()));
            statement.setString(3, transaction.getDescription());
            statement.setString(4, transaction.getVendor());
            statement.setDouble(5, transaction.getAmount());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int transactionId = generatedKeys.getInt(1);
                    return getById(transactionId);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(int id) {

    }

    protected Transaction mapTransaction(ResultSet resultSet) throws SQLException
    {
        int transactionId = resultSet.getInt("transaction_id");
        Date date = resultSet.getDate("date");
        Time time = resultSet.getTime("time");
        String description = resultSet.getString("description");
        String vendor = resultSet.getString("vendor");
        double amount = resultSet.getDouble("amount");

        Transaction transaction = new Transaction()
        {{
            setTransactionId(transactionId);
            setDate(date.toLocalDate());
            setTime(time.toLocalTime());
            setDescription(description);
            setVendor(vendor);
            setAmount(amount);
        }};

        return transaction;
    }
}
