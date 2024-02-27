package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTemplate {
    //pstmt를 밖에서 전달 받기 위해서는 Connection 객체를 바깥에서 알고 있어야 하기 때문에 pstmt를 받아서는 안되고, 세팅 부분만 인자로 받는 것.
    public void executeUpdate(User user, String sql, PreparedStatementSetter ps) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try{
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            ps.setter(pstmt);

            pstmt.execute();
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public Object executeQuery(String id, String sql, PreparedStatementSetter pss, RowMapper rowMapper) throws Exception{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pss.setter(pstmt);

            rs = pstmt.executeQuery();
            Object obj = null;
            if (rs.next()) {
                return rowMapper.map(rs);
            }
            return obj;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
