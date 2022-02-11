/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.RestAPI;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Recieves a JSON and tries to add all elements to the database
 */
@WebServlet(name = "post", urlPatterns = {"/post"})
public class post extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
    /*TODO Implement the resource post
        -The client sends a JSON with the resources to save
          -Structured like the JSON from GET method
          -Instead of id field it will have a user field
            -Wich contains userId
        -The id is generated on the server, as there is no id, name+username is used as a temporary  pk
          -This leads to a user not been able to create 2 resources of the same type with the same name
        -Any non saved resource on the POST request will be responded to the client, so he can update them
        
    */
    
  }

}

