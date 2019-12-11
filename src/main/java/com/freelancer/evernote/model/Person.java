package com.freelancer.evernote.model;

import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PERSON")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PERSON_ID", nullable = false)
    private Long personId;

    @Column(name = "PERSON_NAME", nullable = false)
    private String personName;

    public Person(String personName) {
        this.personName = personName;
    }
}
