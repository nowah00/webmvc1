package com.ssg.webmvc.todo.dao;

import com.ssg.webmvc.todo.domain.MemberVO;
import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
@Log4j2
public class MemberDAO {
    public MemberVO getWithPassword(String mid, String mpw) throws Exception {
        log.info("getWithPassword() 호출");
        String sql = "select * from t_member where mid=? and mpw=?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, mid);
        ps.setString(2, mpw);

        MemberVO memberVO;
        @Cleanup ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            memberVO = MemberVO.builder()
                    .mid(rs.getString("mid"))
                    .mpw(rs.getString("mpw"))
                    .mname(rs.getString("mname"))
                    .build();
            return memberVO;
        }
        return null;
    }
}
