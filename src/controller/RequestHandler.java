package controller;

import domain.service.CountryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class RequestHandler {
    public CountryService getService() {
        return service;
    }

    public void setService(CountryService service) {
        this.service = service;
    }

    CountryService service;

    public abstract String handleRequest(HttpServletRequest request, HttpServletResponse response);
}
