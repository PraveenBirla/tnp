package tnp_management.tnp.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="registration",
 indexes = {
         @Index(name = "idx_student_id", columnList = "student_id"),
         @Index(name = "idx_drive_id", columnList = "drive_id"),
         @Index(name = "idx_status", columnList = "status"),
         @Index(name = "idx_student_drive", columnList = "student_id, drive_id")
 })
public class DriveRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private StudentProfile student;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "drive_id")
    private PlacementDrive placementDrive;

    @Column(nullable = false)
    private LocalDateTime  registeredAt;

    @Column(nullable = false)
    private String status;

    private String remarks;


}