package com.five.crm.domain;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Client.
 */
@Entity
@Table(name = "client")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "designation")
    private String designation;

    @Column(name = "contact")
    private String contact;

    @Column(name = "postec")
    private String postec;

    @Column(name = "email")
    private String email;

    @Column(name = "tel")
    private String tel;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "besoins")
    private String besoins;

    @Column(name = "remarques")
    private String remarques;

    @Column(name = "forum")
    private String forum;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Client id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return this.designation;
    }

    public Client designation(String designation) {
        this.setDesignation(designation);
        return this;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getContact() {
        return this.contact;
    }

    public Client contact(String contact) {
        this.setContact(contact);
        return this;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPostec() {
        return this.postec;
    }

    public Client postec(String postec) {
        this.setPostec(postec);
        return this;
    }

    public void setPostec(String postec) {
        this.postec = postec;
    }

    public String getEmail() {
        return this.email;
    }

    public Client email(String email) {
        this.setEmail(email);
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return this.tel;
    }

    public Client tel(String tel) {
        this.setTel(tel);
        return this;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public Client adresse(String adresse) {
        this.setAdresse(adresse);
        return this;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getBesoins() {
        return this.besoins;
    }

    public Client besoins(String besoins) {
        this.setBesoins(besoins);
        return this;
    }

    public void setBesoins(String besoins) {
        this.besoins = besoins;
    }

    public String getRemarques() {
        return this.remarques;
    }

    public Client remarques(String remarques) {
        this.setRemarques(remarques);
        return this;
    }

    public void setRemarques(String remarques) {
        this.remarques = remarques;
    }

    public String getForum() {
        return this.forum;
    }

    public Client forum(String forum) {
        this.setForum(forum);
        return this;
    }

    public void setForum(String forum) {
        this.forum = forum;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Client)) {
            return false;
        }
        return id != null && id.equals(((Client) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Client{" +
            "id=" + getId() +
            ", designation='" + getDesignation() + "'" +
            ", contact='" + getContact() + "'" +
            ", postec='" + getPostec() + "'" +
            ", email='" + getEmail() + "'" +
            ", tel='" + getTel() + "'" +
            ", adresse='" + getAdresse() + "'" +
            ", besoins='" + getBesoins() + "'" +
            ", remarques='" + getRemarques() + "'" +
            ", forum='" + getForum() + "'" +
            "}";
    }
}
