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
@Table(name = "DAT_01A_SALES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dat01aSales.findAll", query = "SELECT d FROM Dat01aSales d")
    , @NamedQuery(name = "Dat01aSales.findBySalesDataId", query = "SELECT d FROM Dat01aSales d WHERE d.salesDataId = :salesDataId")
    , @NamedQuery(name = "Dat01aSales.findByFactor", query = "SELECT d FROM Dat01aSales d WHERE d.factor = :factor")
    , @NamedQuery(name = "Dat01aSales.findByFactorCategory", query = "SELECT d FROM Dat01aSales d WHERE d.factorCategory = :factorCategory")
    , @NamedQuery(name = "Dat01aSales.findByCategoryDesc", query = "SELECT d FROM Dat01aSales d WHERE d.categoryDesc = :categoryDesc")
    , @NamedQuery(name = "Dat01aSales.findByEntityId", query = "SELECT d FROM Dat01aSales d WHERE d.entityId = :entityId")
    , @NamedQuery(name = "Dat01aSales.findByJurisdiction", query = "SELECT d FROM Dat01aSales d WHERE d.jurisdiction = :jurisdiction")
    , @NamedQuery(name = "Dat01aSales.findByBegBal", query = "SELECT d FROM Dat01aSales d WHERE d.begBal = :begBal")
    , @NamedQuery(name = "Dat01aSales.findByEndBal", query = "SELECT d FROM Dat01aSales d WHERE d.endBal = :endBal")
    , @NamedQuery(name = "Dat01aSales.findBySourceSystem", query = "SELECT d FROM Dat01aSales d WHERE d.sourceSystem = :sourceSystem")
    , @NamedQuery(name = "Dat01aSales.findByAccountType", query = "SELECT d FROM Dat01aSales d WHERE d.accountType = :accountType")
    , @NamedQuery(name = "Dat01aSales.findByFiscalYearId", query = "SELECT d FROM Dat01aSales d WHERE d.fiscalYearId = :fiscalYearId")
    , @NamedQuery(name = "Dat01aSales.findByScenarioId", query = "SELECT d FROM Dat01aSales d WHERE d.scenarioId = :scenarioId")
    , @NamedQuery(name = "Dat01aSales.findByTenantId", query = "SELECT d FROM Dat01aSales d WHERE d.tenantId = :tenantId")
    , @NamedQuery(name = "Dat01aSales.findByUpdatedBy", query = "SELECT d FROM Dat01aSales d WHERE d.updatedBy = :updatedBy")
    , @NamedQuery(name = "Dat01aSales.findByUpdateDate", query = "SELECT d FROM Dat01aSales d WHERE d.updateDate = :updateDate")
    , @NamedQuery(name = "Dat01aSales.findByRemark", query = "SELECT d FROM Dat01aSales d WHERE d.remark = :remark")})
public class Dat01aSales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4000)
    @Column(name = "SALES_DATA_ID")
    private String salesDataId;
    @Size(max = 4000)
    @Column(name = "FACTOR")
    private String factor;
    @Size(max = 4000)
    @Column(name = "FACTOR_CATEGORY")
    private String factorCategory;
    @Size(max = 4000)
    @Column(name = "CATEGORY_DESC")
    private String categoryDesc;
    @Size(max = 4000)
    @Column(name = "ENTITY_ID")
    private String entityId;
    @Size(max = 4000)
    @Column(name = "JURISDICTION")
    private String jurisdiction;
    @Size(max = 4000)
    @Column(name = "BEG_BAL")
    private String begBal;
    @Size(max = 4000)
    @Column(name = "END_BAL")
    private String endBal;
    @Size(max = 4000)
    @Column(name = "SOURCE_SYSTEM")
    private String sourceSystem;
    @Size(max = 4000)
    @Column(name = "ACCOUNT_TYPE")
    private String accountType;
    @Size(max = 4000)
    @Column(name = "FISCAL_YEAR_ID")
    private String fiscalYearId;
    @Size(max = 4000)
    @Column(name = "SCENARIO_ID")
    private String scenarioId;
    @Size(max = 4000)
    @Column(name = "TENANT_ID")
    private String tenantId;
    @Size(max = 4000)
    @Column(name = "UPDATED_BY")
    private String updatedBy;
    @Size(max = 4000)
    @Column(name = "UPDATE_DATE")
    private String updateDate;
    @Size(max = 4000)
    @Column(name = "REMARK")
    private String remark;

    public Dat01aSales() {
    }

    public Dat01aSales(String salesDataId) {
        this.salesDataId = salesDataId;
    }

    public String getSalesDataId() {
        return salesDataId;
    }

    public void setSalesDataId(String salesDataId) {
        this.salesDataId = salesDataId;
    }

    public String getFactor() {
        return factor;
    }

    public void setFactor(String factor) {
        this.factor = factor;
    }

    public String getFactorCategory() {
        return factorCategory;
    }

    public void setFactorCategory(String factorCategory) {
        this.factorCategory = factorCategory;
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public String getBegBal() {
        return begBal;
    }

    public void setBegBal(String begBal) {
        this.begBal = begBal;
    }

    public String getEndBal() {
        return endBal;
    }

    public void setEndBal(String endBal) {
        this.endBal = endBal;
    }

    public String getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getFiscalYearId() {
        return fiscalYearId;
    }

    public void setFiscalYearId(String fiscalYearId) {
        this.fiscalYearId = fiscalYearId;
    }

    public String getScenarioId() {
        return scenarioId;
    }

    public void setScenarioId(String scenarioId) {
        this.scenarioId = scenarioId;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salesDataId != null ? salesDataId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dat01aSales)) {
            return false;
        }
        Dat01aSales other = (Dat01aSales) object;
        if ((this.salesDataId == null && other.salesDataId != null) || (this.salesDataId != null && !this.salesDataId.equals(other.salesDataId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.raj.micro.model.Dat01aSales[ salesDataId=" + salesDataId + " ]";
    }
    
}
