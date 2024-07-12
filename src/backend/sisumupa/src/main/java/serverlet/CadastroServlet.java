package serverlet;

import util.DBconnection;
import model.Usuario;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/cadastro")
public class CadastroServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DBconnection.getConnection();
            String sql = "INSERT INTO usuarios (username, password) VALUES (?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            int rows = stmt.executeUpdate();

            if (rows > 0) {
                response.sendRedirect("login.html");
            } else {
                response.sendRedirect("cadastro.html?error=true");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Erro de banco de dados", e);
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
