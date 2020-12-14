package com.rando.controleur;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rando.dao.ItineraireRepository;
import com.rando.modele.Itineraire;



@Controller
public class JspItineraireControleur {
   
    @Autowired
    ItineraireRepository itineraireRepository;
   
    //@GetMapping("/itineraires") méthode similaire au @RequestMapping
    
    @RequestMapping(value = "/itineraires", method= RequestMethod.GET)
    public String getListeItineraires(Model model)
    {
        List<Itineraire> itineraires = new ArrayList<Itineraire>();
       
        itineraireRepository.findAll().forEach(itineraires::add);
       
        model.addAttribute("listeItineraires", itineraires);
       
        return "itineraires";
    }
}
