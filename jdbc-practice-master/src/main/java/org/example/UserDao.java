package org.example;

import java.sql.*;

public class UserDao {
    public void create(User user) throws SQLException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        String sql = "INSERT INTO USERS VALUES(?,?,?,?)";
        jdbcTemplate.executeUpdate(user, sql, new PreparedStatementSetter() {
            /**
             * 파라미터를 전달하는 쪽에서 세팅해주면 JdbcTemplate은 PreparedStatement를 실행만 하면 됨.
             * @param pstmt
             * @throws SQLException
             */
            @Override
            public void setter(PreparedStatement pstmt) throws SQLException {
                pstmt.setString(1, user.getId());
                pstmt.setString(2, user.getPassword());
                pstmt.setString(3, user.getName());
                pstmt.setString(4, user.getEmail());
            }
        });
    }

    public User findById(String id) throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        String sql = "SELECT * FROM USERS WHERE userId = ?";
        User user = (User)jdbcTemplate.executeQuery(id, sql, new PreparedStatementSetter() {
            @Override
            public void setter(PreparedStatement pstmt) throws SQLException {
                pstmt.setString(1, id);
            }
        }, new RowMapper() {
            @Override
            public Object map(ResultSet resultSet) throws SQLException {

                return new User(
                        resultSet.getString("userId"),
                        resultSet.getString("password"),
                        resultSet.getString("name"),
                        resultSet.getString("email")
                );
            }
        });
        return user;
    }
}
