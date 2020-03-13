package controller;

import domain.service.CountryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;

public class ControllerFactory {
    public RequestHandler getHandler(HttpServletRequest request, HttpServletResponse response, CountryService service) {
        String command = request.getParameter("command");
        RequestHandler handler = null;
        try {
            Class handlerClass = Class.forName("controller." + command + "Handler");
            Object handlerObject = handlerClass.getConstructor().newInstance();
            handler = (RequestHandler) handlerObject;
            handler.setService(service);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw  new RuntimeException("The requested page could not be found");
        }
        return handler;
    }
}
