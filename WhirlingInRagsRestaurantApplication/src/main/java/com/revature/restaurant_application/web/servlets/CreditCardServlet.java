package com.revature.restaurant_application.web.servlets;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.restaurant_application.exceptions.ResourcePersistenceException;
import com.revature.restaurant_application.models.CreditCardData;
import com.revature.restaurant_application.services.CreditCardServices;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;



public class CreditCardServlet extends HttpServlet  {

    private final CreditCardServices creditCardServices;
    private final ObjectMapper mapper;

    public CreditCardServlet(CreditCardServices creditCardServices, ObjectMapper mapper) {
        this.creditCardServices = creditCardServices;
        this.mapper = mapper;
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doOptions(req, resp);
        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.addHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");
        resp.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.addHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");
        resp.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        if(req.getParameter("pokemonName") != null){
            CreditCardData creditCard = creditCardServices.readByID(req.getParameter("creditCard"));
            String payload = mapper.writeValueAsString(creditCard);
            resp.getWriter().write(payload);
            return;
        }

        List<CreditCardData> creditCardData = creditCardServices.readAll();
        String payload = mapper.writeValueAsString(creditCardData);

        resp.getWriter().write(payload);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.addHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");
        resp.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        CreditCardData newCreditCard = mapper.readValue(req.getInputStream(), CreditCardData.class); // from JSON to Java Object (Pokemon)
        CreditCardData persistedCreditCard = creditCardServices.CreateCreditCard(newCreditCard);

        String payload = mapper.writeValueAsString(persistedCreditCard); // Mapping from Java Object (Pokemon) to JSON



        resp.getWriter().write("Sample output \n");
        resp.getWriter().write(payload);
        resp.setStatus(201);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.addHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");
        resp.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        //if(!checkAuth(req, resp)) return;

        CreditCardData creditCardUpdate = mapper.readValue(req.getInputStream(), CreditCardData.class);
        CreditCardData updatedCreditCard = creditCardServices.update(creditCardUpdate);


        String payload = mapper.writeValueAsString(updatedCreditCard);
        resp.getWriter().write(payload);

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.addHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");
        resp.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
//TODO: implement checkAuth
        //if(!checkAuth(req, resp)) return;
        if(req.getParameter("username") == null){

            resp.getWriter().write("Sample output");
            resp.setStatus(401);
            return;
        }

        try {
            creditCardServices.delete("username");
            resp.getWriter().write("Delete credit card from the database");
        } catch (ResourcePersistenceException e){
            resp.getWriter().write(e.getMessage());
            resp.setStatus(404);
        }
    }

}
