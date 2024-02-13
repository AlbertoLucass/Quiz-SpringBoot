package com.rocketseat.certification_nlw.modules.students.entities;

import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="certifications")
public class CertificationStudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 100)
    private String technology;
    
    @Column(length = 10)
    private  int grade;
    
    @JoinColumn(name = "student_id")
    private UUID studentID;
    
    @ManyToOne
    @JoinColumn(name = "student_id", updatable = false, insertable = false)
    private StudentEntity studentEntity;

    @OneToMany
    @JoinColumn(name = "answer_certification_id", updatable = false, insertable = false)
    List<AnswersCertificationsEntity> answersCertificationsEntities;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
