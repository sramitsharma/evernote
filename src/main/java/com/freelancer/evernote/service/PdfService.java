package com.freelancer.evernote.service;

import com.freelancer.evernote.model.CustomPDF;
import com.freelancer.evernote.repository.PdfRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PdfService {

    private PdfRepository pdfRepository;

    public PdfService(PdfRepository pdfRepository) {
        this.pdfRepository = pdfRepository;
    }

    public CustomPDF savePdf(CustomPDF customPDF) {
        return pdfRepository.save(customPDF);
    }

    public List<CustomPDF> getPdfList() {
        return pdfRepository.findAll();
    }
}
