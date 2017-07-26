/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retors.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author raj007
 */
@Entity
@Table(name = "MDT_02_ENTITY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mdt02Entity.findAll", query = "SELECT m FROM Mdt02Entity m")
    , @NamedQuery(name = "Mdt02Entity.findByEntityId", query = "SELECT m FROM Mdt02Entity m WHERE m.entityId = :entityId")
    , @NamedQuery(name = "Mdt02Entity.findByEin", query = "SELECT m FROM Mdt02Entity m WHERE m.ein = :ein")
    , @NamedQuery(name = "Mdt02Entity.findByEntityName", query = "SELECT m FROM Mdt02Entity m WHERE m.entityName = :entityName")
    , @NamedQuery(name = "Mdt02Entity.findByEntityType", query = "SELECT m FROM Mdt02Entity m WHERE m.entityType = :entityType")
    , @NamedQuery(name = "Mdt02Entity.findByExternalEntityYN", query = "SELECT m FROM Mdt02Entity m WHERE m.externalEntityYN = :externalEntityYN")
    , @NamedQuery(name = "Mdt02Entity.findByFiscalYearId", query = "SELECT m FROM Mdt02Entity m WHERE m.fiscalYearId = :fiscalYearId")
    , @NamedQuery(name = "Mdt02Entity.findByTenantId", query = "SELECT m FROM Mdt02Entity m WHERE m.tenantId = :tenantId")
    , @NamedQuery(name = "Mdt02Entity.findByUpdatedBy", query = "SELECT m FROM Mdt02Entity m WHERE m.updatedBy = :updatedBy")
    , @NamedQuery(name = "Mdt02Entity.findByUpdateDate", query = "SELECT m FROM Mdt02Entity m WHERE m.updateDate = :updateDate")})
public class Mdt02Entity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4000)
    @Column(name = "ENTITY_ID")
    private String entityId;
    @Size(max = 4000)
    @Column(name = "EIN")
    private String ein;
    @Size(max = 4000)
    @Column(name = "ENTITY_NAME")
    private String entityName;
    @Size(max = 4000)
    @Column(name = "ENTITY_TYPE")
    private String entityType;
    @Size(max = 5)
    @Column(name = "EXTERNAL_ENTITY_Y_N")
    private String externalEntityYN;
    @Size(max = 4000)
    @Column(name = "FISCAL_YEAR_ID")
    private String fiscalYearId;
    @Size(max = 4000)
    @Column(name = "TENANT_ID")
    private String tenantId;
    @Size(max = 4000)
    @Column(name = "UPDATED_BY")
    private String updatedBy;
    @Size(max = 4000)
    @Column(name = "UPDATE_DATE")
    private String updateDate;

    public Mdt02Entity() {
    }

    public Mdt02Entity(String entityId) {
        this.entityId = entityId;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getEin() {
        return ein;
    }

    public void setEin(String ein) {
        this.ein = ein;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getExternalEntityYN() {
        return externalEntityYN;
    }

    public void setExternalEntityYN(String externalEntityYN) {
        this.externalEntityYN = externalEntityYN;
    }

    public String getFiscalYearId() {
        return fiscalYearId;
    }

    public void setFiscalYearId(String fiscalYearId) {
        this.fiscalYearId = fiscalYearId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entityId != null ? entityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mdt02Entity)) {
            return false;
        }
        Mdt02Entity other = (Mdt02Entity) object;
        if ((this.entityId == null && other.entityId != null) || (this.entityId != null && !this.entityId.equals(other.entityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.raj.micro.model.Mdt02Entity[ entityId=" + entityId + " ]";
    }
    
}
