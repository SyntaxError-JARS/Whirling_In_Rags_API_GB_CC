package com.revature.restaurant_application.web.servlets;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.restaurant_application.exceptions.ResourcePersistenceException;
import com.revature.restaurant_application.models.MenuData;
import com.revature.restaurant_application.services.MenuServices;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;



public class MenuServlet extends HttpServlet  {

    private final MenuServices menuServices;
    private final ObjectMapper mapper;

    public MenuServlet(MenuServices menuServices, ObjectMapper mapper) {
        this.menuServices = menuServices;
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
        if(req.getParameter("menuItem") != null){
            MenuData menuItem = menuServices.readByID("menuItem");
            String payload = mapper.writeValueAsString(menuItem);
            resp.getWriter().write(payload);
            return;
        }

        List<MenuData> menuItems = menuServices.readAll();
        String payload = mapper.writeValueAsString(menuItems);

        resp.getWriter().write(payload);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.addHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");
        resp.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        MenuData newMenuItem = mapper.readValue(req.getInputStream(), MenuData.class); // from JSON to Java Object (Pokemon)
        MenuData persistedMenuItem = menuServices.CreateMenuItem(newMenuItem);

        String payload = mapper.writeValueAsString(persistedMenuItem); // Mapping from Java Object (Pokemon) to JSON



        resp.getWriter().write("Persisted the provided pokemon as show below \n");
        resp.getWriter().write(payload);
        resp.setStatus(201);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.addHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");
        resp.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        //if(!checkAuth(req, resp)) return;

        MenuData menuItemUpdate = mapper.readValue(req.getInputStream(), MenuData.class);
        MenuData updatedMenuItem = menuServices.update(menuItemUpdate);


        String payload = mapper.writeValueAsString(updatedMenuItem);
        resp.getWriter().write(payload);

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.addHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");
        resp.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");

        //if(!checkAuth(req, resp)) return;
        if(req.getParameter("menuItem") == null){

            resp.getWriter().write("Sample output");
            resp.setStatus(401);
            return;
        }
        String menuItem = req.getParameter("menuItem");

        try {
            menuServices.delete(menuItem);
            resp.getWriter().write("Delete menu item from the database");
        } catch (ResourcePersistenceException e){
            resp.getWriter().write(e.getMessage());
            resp.setStatus(404);
        } catch (Exception e){
            resp.getWriter().write(e.getMessage());
            resp.setStatus(500);
        }
    }

}



