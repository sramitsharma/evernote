package com.freelancer.evernote.controller;

import com.freelancer.evernote.model.CustomPDF;
import com.freelancer.evernote.model.Person;
import com.freelancer.evernote.service.PdfService;
import com.freelancer.evernote.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class DataController {
    private Environment environment;
    private PersonService personService;
    private PdfService pdfService;

    public DataController(Environment environment, PersonService personService, PdfService pdfService) {
        this.environment = environment;
        this.personService = personService;
        this.pdfService = pdfService;
    }

    @GetMapping("/getPersonList")
    public List<Person> getPersons() {
        return personService.getPersonData();
    }

    @PostMapping("/savePerson")
    public Person savePerson(@RequestParam String personName) {
        Person personToSave = new Person(personName);
        return personService.savePerson(personToSave);
    }

    @GetMapping("/getPdfList")
    public List<CustomPDF> getPdfList() {
        return pdfService.getPdfList();
    }

    @PostMapping("/savePdf")
    public CustomPDF savePdf(@RequestParam MultipartFile pdfFile) throws IOException {
        CustomPDF pdf = new CustomPDF();
        pdf.setPdfName(pdfFile.getOriginalFilename());
        pdf.setPdfData(pdfFile.getBytes());
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(pdf.getPdfId())
                .toUriString();
        return pdfService.savePdf(pdf);
    }
}
