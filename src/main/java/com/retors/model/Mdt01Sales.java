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
@Table(name = "MDT_01_SALES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mdt01Sales.findAll", query = "SELECT m FROM Mdt01Sales m")
    , @NamedQuery(name = "Mdt01Sales.findBySalesCategoryId", query = "SELECT m FROM Mdt01Sales m WHERE m.salesCategoryId = :salesCategoryId")
    , @NamedQuery(name = "Mdt01Sales.findByFactorName", query = "SELECT m FROM Mdt01Sales m WHERE m.factorName = :factorName")
    , @NamedQuery(name = "Mdt01Sales.findByFactorCatDesc", query = "SELECT m FROM Mdt01Sales m WHERE m.factorCatDesc = :factorCatDesc")
    , @NamedQuery(name = "Mdt01Sales.findByFiscalYearId", query = "SELECT m FROM Mdt01Sales m WHERE m.fiscalYearId = :fiscalYearId")
    , @NamedQuery(name = "Mdt01Sales.findByTenantId", query = "SELECT m FROM Mdt01Sales m WHERE m.tenantId = :tenantId")
    , @NamedQuery(name = "Mdt01Sales.findByUpdatedBy", query = "SELECT m FROM Mdt01Sales m WHERE m.updatedBy = :updatedBy")
    , @NamedQuery(name = "Mdt01Sales.findByUpdateDate", query = "SELECT m FROM Mdt01Sales m WHERE m.updateDate = :updateDate")})
public class Mdt01Sales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4000)
    @Column(name = "SALES_CATEGORY_ID")
    private String salesCategoryId;
    @Size(max = 4000)
    @Column(name = "FACTOR_NAME")
    private String factorName;
    @Size(max = 4000)
    @Column(name = "FACTOR_CAT_DESC")
    private String factorCatDesc;
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

    public Mdt01Sales() {
    }

    public Mdt01Sales(String salesCategoryId) {
        this.salesCategoryId = salesCategoryId;
    }

    public String getSalesCategoryId() {
        return salesCategoryId;
    }

    public void setSalesCategoryId(String salesCategoryId) {
        this.salesCategoryId = salesCategoryId;
    }

    public String getFactorName() {
        return factorName;
    }

    public void setFactorName(String factorName) {
        this.factorName = factorName;
    }

    public String getFactorCatDesc() {
        return factorCatDesc;
    }

    public void setFactorCatDesc(String factorCatDesc) {
        this.factorCatDesc = factorCatDesc;
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
        hash += (salesCategoryId != null ? salesCategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mdt01Sales)) {
            return false;
        }
        Mdt01Sales other = (Mdt01Sales) object;
        if ((this.salesCategoryId == null && other.salesCategoryId != null) || (this.salesCategoryId != null && !this.salesCategoryId.equals(other.salesCategoryId))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "Mdt01Sales [salesCategoryId=" + salesCategoryId + ", factorName=" + factorName + ", factorCatDesc="
				+ factorCatDesc + ", fiscalYearId=" + fiscalYearId + ", tenantId=" + tenantId + ", updatedBy="
				+ updatedBy + ", updateDate=" + updateDate + "]";
	}

   
    
}
