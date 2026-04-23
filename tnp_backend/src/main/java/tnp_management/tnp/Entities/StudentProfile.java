package tnp_management.tnp.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="student_profile",
        indexes = {
                @Index(name = "idx_user_id", columnList = "user_id"),
                @Index(name = "idx_enrollment", columnList = "student_enrollment_no"),
                @Index(name = "idx_branch", columnList = "student_branch"),
                @Index(name = "idx_passout_year", columnList = "student_passoutyear"),
                @Index(name = "idx_placed", columnList = "isPlaced"),
                @Index(name = "idx_verified", columnList = "isVerified"),
                @Index(name = "idx_branch_year", columnList = "student_branch, student_passoutyear")
        },
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_enrollment", columnNames = "student_enrollment_no")
        })
public class StudentProfile {

    @Id
    private Long id ;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name="user_id")
    private User user;

    @Column(name="student_name" , nullable = false)
    private String fullName;

    @Column(name="student_cgpa" , nullable = false)
    private Double cgpa;

    @Column(name="student_branch" , nullable = false)
    private String branch;

    @Column(name="student_enrollment_no" , nullable = false)
    private String studentEnrollmentNo ;

    @Column(name="student_passoutyear" , nullable = false)
    private Integer passoutYear;

    @Column(name="students_skills" , nullable = false)
    private String skills;

    @Column(name="resumeUrl" , nullable = false)
    private String resumeUrl;

    @Column(name="tentMarksheetUrl" , nullable = false)
    private String tenthMarksheetUrl;

    @Column(name="twelfthMarksheetUrl" , nullable = false)
    private String twelfthMarksheetUrl;

    @Column(name="lastSemesterMarkSheetUrl" , nullable = false)
    private String  lastSemesterMarkSheetUrl;

    @Column(name="student_contact_number" , nullable = false)
    private String phoneNumber;

    private boolean isPlaced = false ;

    private boolean isVerified = false;


    @OneToOne(mappedBy = "studentProfile" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private PlacedStudent placedStudent;



}
