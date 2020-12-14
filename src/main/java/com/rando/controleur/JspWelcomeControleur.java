package com.rando.controleur;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rando.dao.EtapeRepository;
import com.rando.modele.Etape;

@Controller
public class JspWelcomeControleur {
	
	@Autowired
    EtapeRepository etapeRepository;
   
    @RequestMapping(value = {"/", "accueil"}, method= RequestMethod.GET)
    public String getListeEtapes(Model model)
    {
    	List<Etape> etapes = new ArrayList<Etape>();
        
        etapeRepository.findAll().forEach(etapes::add);
       
        for(Etape e :etapes) {
        	System.out.println(e.toString());
        }
        model.addAttribute("listeEtapes", etapes);
       
        return "welcome";
    }

}
