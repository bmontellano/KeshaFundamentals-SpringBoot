package com.pluralsight.keshafundamentals.web;

import java.util.List;

import com.pluralsight.keshafundamentals.entity.Application;
import com.pluralsight.keshafundamentals.entity.Release;
import com.pluralsight.keshafundamentals.entity.Ticket;
import com.pluralsight.keshafundamentals.exception.ApplicationNotFoundException;
import com.pluralsight.keshafundamentals.service.ApplicationService;
import com.pluralsight.keshafundamentals.service.ReleaseService;
import com.pluralsight.keshafundamentals.service.TicketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

//NOTE - THYMELEAF WILL NOT WORK WITH @RestController. Find solution later
//Please uncomment below for Thymeleaf implementation

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
@Controller
public class TzaController {
    private ApplicationService applicationService;
    private TicketService ticketService;
    private ReleaseService releaseService;

    @Autowired
    public void setApplicationService(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @Autowired
    public void setTicketService(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Autowired
    public void setReleaseService(ReleaseService releaseService) {
        this.releaseService = releaseService;
    }

    @GetMapping("/applications")
    public String retrieveApplications(Model model){
        model.addAttribute("applications", applicationService.listApplications());
        return "applications";
    }

    @GetMapping("/tickets")
    public String getAllTickets(Model model){
        model.addAttribute("tickets", ticketService.listTickets());
        return "tickets";
    }

    @GetMapping("/releases")
    public String retrieveReleases(Model model){
        model.addAttribute("releases", releaseService.listReleases());
        return "releases";
    }
}


/*
@RestController
@RequestMapping("/tza")
public class TzaController {
    private ApplicationService applicationService;
    private TicketService ticketService;
    private ReleaseService releaseService;

    @Autowired
    public void setApplicationService(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @Autowired
    public void setTicketService(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Autowired
    public void setReleaseService(ReleaseService releaseService) {
        this.releaseService = releaseService;
    }

    @GetMapping("/applications")
    public ResponseEntity<List<Application>> getApplications() {
        List<Application> list = applicationService.listApplications();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/applications/{id}")
    public ResponseEntity<Application> getApplication(@PathVariable("id") long id){
        try {
            return new ResponseEntity<>(applicationService.findApplication(id), HttpStatus.OK);
        } catch (ApplicationNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Application not found. Probably id:" + id + " does not exist in the database.");
        }
    }

    @GetMapping("/tickets")
    public ResponseEntity<List<Ticket>> getTickets() {
        List<Ticket> list = ticketService.listTickets();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/releases")
    public ResponseEntity<List<Release>> getReleases() {
        List<Release> list = releaseService.listReleases();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
*/