package com.kubacki.controllers;

import com.kubacki.domain.Przedmiot;
import com.kubacki.domain.TypZajec;
import com.kubacki.domain.Zajecia;
import com.kubacki.services.PrzedmiotService;
import com.kubacki.services.TypZajecService;
import com.kubacki.services.ZajeciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by KUBACM on 2017-07-15.
 */
@Controller
public class IndexController {


    private PrzedmiotService przedmiotService;
    private ZajeciaService zajeciaService;
    private TypZajecService typZajecService;

    @Autowired
    public void setPrzedmiotService(PrzedmiotService przedmiotService){
        this.przedmiotService = przedmiotService;
    }

    @Autowired
    public void setZajeciaService(ZajeciaService zajeciaService){
        this.zajeciaService = zajeciaService;
    }

    @Autowired
    public void setTypZajecService(TypZajecService typZajecService){
        this.typZajecService = typZajecService;
    }

    @RequestMapping("/")
    String index(Model model)
    {
        model.addAttribute("przedmioty", przedmiotService.listAll());
        model.addAttribute("zajecia", zajeciaService.listAll());
        model.addAttribute("typyZajec", typZajecService.listAll());
        return "index";
    }

    @RequestMapping(value = "przedmiot", method = RequestMethod.POST)
    public String savePrzedmiot(Przedmiot przedmiot){
        przedmiotService.saveOrUpdate(przedmiot);
        return "redirect:/";
    }

    @RequestMapping(value = "zajecia", method = RequestMethod.POST)
    public String saveZajecia(Zajecia zajecia){
        zajeciaService.saveOrUpdate(zajecia);
        return "redirect:/";
    }




}
