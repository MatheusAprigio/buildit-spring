package br.com.buildit.error;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
public class CustomErrorView implements ErrorViewResolver {
    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
        ModelAndView modelAndView = new ModelAndView("errorPage");
        modelAndView.addObject("status", status.value());
        switch (status.value()) {
            case 404:
                modelAndView.addObject("error", "Ops! Página não encontrada.");
                modelAndView.addObject("message", "A url para a página '" + model.get("path") + "' não existe.");
                break;
            case 500:
                modelAndView.addObject("error", "Ops! Ocorreu um erro inesperado.");
                modelAndView.addObject("message", "Fique calmo, estamos tratando o problema :)");
                break;
            default:
                modelAndView.addObject("error", model.get("error"));
                modelAndView.addObject("message", model.get("message"));
                break;
        }
        return modelAndView;
    }
}
