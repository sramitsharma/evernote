package com.freelancer.evernote.repository;

import com.freelancer.evernote.model.CustomPDF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PdfRepository extends JpaRepository<CustomPDF, Long> {
}
