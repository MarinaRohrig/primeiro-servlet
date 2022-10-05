package br.com.futurodev.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class PrimeiroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Define o tipo do conteúdo de response, no caso um text ou html
        resp.setContentType("text/html");

        // Captura o writer para escrever
        PrintWriter writer = resp.getWriter();

        // captura os parametros passados

        String nome = req.getParameter("nome");
        String idade = req.getParameter("idade");


        writer.println("<h3>Nosso primeiro servlet! </h3>");
        writer.println("<h4>Olá " + nome + " você tem " + idade + " anos de vida!</h4>");

        Integer intIdade = Integer.parseInt(idade);

        // imprime resposta
        if (intIdade < 0) {
            writer.println("<h4> Não nasceu ainda né? xD </h4>");
            //inválido
        } else if (intIdade <= 14) {
            writer.println("<h4> Você é uma criança! </h4>");
            //criança
        } else if (intIdade > 14 && Double.parseDouble(idade) <= 18) {
            writer.println("<h4> Você é um adolescente!</h4>");
            //adolescente
        } else if (intIdade > 18 && Double.parseDouble(idade) <= 64) {
            writer.println("<h4> Você é um adulto!</h4>");
            //adulto
        } else {
            writer.println("<h4> Você é um idoso!</h4>");
            //idoso
        }


    }
}
