package com.freelancer.evernote.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CUSTOM_PDF")
public class CustomPDF {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "PDF_ID", nullable = false)
    private String pdfId;

    @Column(name = "PDF_NAME", nullable = false)
    private String pdfName;

    @Lob
    @Column(name = "PDF_DATA", nullable = false)
    private byte[] pdfData;

    public CustomPDF(String pdfName, byte[] pdfData) {
        this.pdfName = pdfName;
        this.pdfData = pdfData;
    }
}
