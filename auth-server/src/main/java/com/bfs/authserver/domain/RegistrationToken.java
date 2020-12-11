package com.bfs.authserver.domain;
import lombok.*;
import java.util.Set;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "registrationToken", schema = "project2")
public class RegistrationToken implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "token")
    private String token;

    @Column(name = "validDuration")
    private String validDuration;

    @Column(name = "email")
    private String email;

    @Column(name = "createdBy")
    private String createdBy;

    @Column(name = "status")
    private boolean isUsed;


}
