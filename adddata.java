import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class adddata extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
        String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost/practice";
        String USER = "root";
        String PASS = "tarunsql18";
        response.setContentType("text/html");

        String item = request.getParameter("newItem");
        PrintWriter pw = response.getWriter();
        Connection conn = null; 

        try {
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            String query = "INSERT INTO todo VALUES (?)";
            PreparedStatement st = conn.prepareStatement(query);

            st.setString(1, item);

            st.executeUpdate();
            pw.println("Successfully Inserted!");

            conn.close();
        }
        catch (Exception e) {
            pw.println(e);
        }

        pw.close();
    }
}