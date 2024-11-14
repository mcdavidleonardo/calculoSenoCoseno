package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calcular")
public class CalculoSenoCoseno extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //El servidor responde en forma de HTML
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        //Se crea la plantilla HTML
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Resultados de Cálculo Seno y Coseno</title>");
        out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container mt-5\">");
        out.println("<h3 class=\"text-center mb-4\">Resultados de Cálculo del Seno y Coseno</h3>");
        out.println("<table class=\"table table-bordered table-striped table-hover\">");
        out.println("<thead class=\"thead-dark\">");
        out.println("<tr>");
        out.println("<th>Ángulo</th>");
        out.println("<th>Seno</th>");
        out.println("<th>Coseno</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");

        //Lógica para calcular el seno y coseno
        //Primero se debe convertir los grados a radianes
        for (int angulo = 0; angulo <= 360; angulo += 15) {
            double radianes = Math.toRadians(angulo);
            double seno = Math.sin(radianes);
            double coseno = Math.cos(radianes);
            out.printf("<tr><td>%d°</td><td>%.4f</td><td>%.4f</td></tr>%n", angulo, seno, coseno);
        }

        out.println("</tbody>");
        out.println("</table>");
        out.println("</div>");
        out.println("<script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"></script>");
        out.println("<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js\"></script>");
        out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>");
        out.println("</body>");
        out.println("</html>");
    }
}
