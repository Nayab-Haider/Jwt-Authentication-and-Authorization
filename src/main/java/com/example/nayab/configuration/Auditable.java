package com.example.nayab.configuration;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U> {

    @JsonIgnore
    @CreatedBy
    protected U createdBy;

    @JsonIgnore
    @CreatedDate
    protected Date creationDate;

    @JsonIgnore
    @LastModifiedBy
    protected U lastModifiedBy;

    @JsonIgnore
    @LastModifiedDate
    protected Date lastModifiedDate;
}
