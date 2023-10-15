package tcc.job.devs.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import tcc.job.devs.enums.ContractPreference;
import tcc.job.devs.enums.Gender;
import tcc.job.devs.enums.JobPreference;

@EqualsAndHashCode(callSuper = true)
@Table(name = "profiles")
@Entity
@Data
public class ProfileEntity extends EntityBase {

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "hobbies")
    private String hobbies;

    @Column(name = "last_role")
    private String lastRole;

    @Column(name = "last_company")
    private String lastCompany;

    @Column(name = "student")
    private Boolean student;

    @Enumerated(EnumType.STRING)
    @Column(name = "job_preference", nullable = false)
    private JobPreference jobPreference;

    @Enumerated(EnumType.STRING)
    @Column(name = "contract_preference")
    private ContractPreference contractPreference;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", updatable = false)
    @NotNull
    private UserEntity user;
}