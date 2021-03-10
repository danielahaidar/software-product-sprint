package com.google.sps.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    ArrayList<String> facts = new ArrayList<>();
    facts.add("I have one dog named Spike.");
    facts.add("I don't have siblings.");
    facts.add("I love to travel.");

    String json = convertToJson(facts);

    response.setContentType("text/html;");
    response.getWriter().println(json);
  }

  /**
   * Converts a ServerStats instance into a JSON string using manual String concatentation.
   */
  private String convertToJson(ArrayList arr) {
    String json = "{";
    json += "\"fact0\": ";
    json += "\"" + arr.get(0) + "\"";
    json += ", ";
    json += "\"fact1\": ";
    json += "\"" + arr.get(1) + "\"";
    json += ", ";
    json += "\"fact2\": ";
    json += "\"" + arr.get(2) + "\"";
    json += "}";
    return json;
  }


}
