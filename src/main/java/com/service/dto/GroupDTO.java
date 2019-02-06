package com.service.dto;

import com.domain.Authority;
import com.domain.Group;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;


/**
 * A DTO for the Group entity.
 */
public class GroupDTO implements Serializable {

    public GroupDTO() {
    }

    public GroupDTO(Group group) {
        this.id = group.getId();
        this.nom = group.getNom();
        this.authorities = group.getAuthorities();
    }

    private Long id;

    @NotNull
    private String nom;
    private Set<Authority> authorities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        GroupDTO groupDTO = (GroupDTO) o;
        if (groupDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), groupDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "GroupDTO{" +
            "id=" + getId() +
            ", nom='" + getNom() + "'" +
            ", authorities='" + getAuthorities() + "'" +
            "}";
    }
}
