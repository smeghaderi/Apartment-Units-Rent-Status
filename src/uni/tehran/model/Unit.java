package uni.tehran.model;

import java.io.Serializable;

public class Unit implements Serializable {

    private long id;
    private long unitId;
    private String unitOwner;
    private String tenantName;
    private long rentCost;
    private long paymentAmount;
    private long balance;
    private boolean paymentMethode;

    public Unit() {
    }

    public Unit(long unitId, String unitOwner, String tenantName, long rentCost, long paymentAmount, boolean paymentMethode) {
        this.unitId = unitId;
        this.unitOwner = unitOwner;
        this.tenantName = tenantName;
        this.rentCost = rentCost;
        this.paymentAmount = paymentAmount;
        this.paymentMethode = paymentMethode;
    }

    public Unit(long unitId, String unitOwner, String tenantName, long rentCost, long paymentAmount, long balance) {
        this.unitId = unitId;
        this.unitOwner = unitOwner;
        this.tenantName = tenantName;
        this.rentCost = rentCost;
        this.paymentAmount = paymentAmount;
        this.balance = balance;
    }

    public Unit(long unitId) {
        this.unitId = unitId;
    }

    public Unit(long unitId, long paymentAmount) {
        this.unitId = unitId;
        this.paymentAmount = paymentAmount;
    }

    public long getId() {
        return id;
    }

    public Unit setId(long id) {
        this.id = id;
        return this;
    }

    public long getUnitId() {
        return unitId;
    }

    public Unit setUnitId(long unitId) {
        this.unitId = unitId;
        return this;
    }

    public String getUnitOwner() {
        return unitOwner;
    }

    public Unit setUnitOwner(String unitOwner) {
        this.unitOwner = unitOwner;
        return this;
    }

    public String getTenantName() {
        return tenantName;
    }

    public Unit setTenantName(String tenantName) {
        this.tenantName = tenantName;
        return this;
    }

    public long getRentCost() {
        return rentCost;
    }

    public Unit setRentCost(long rentCost) {
        this.rentCost = rentCost;
        return this;
    }

    public long getPaymentAmount() {
        return paymentAmount;
    }

    public Unit setPaymentAmount(long paymentAmount) {
        this.paymentAmount = paymentAmount;
        return this;
    }

    public long getBalance() {
        return balance;
    }

    public Unit setBalance(long balance) {
        this.balance = balance;
        return this;
    }

    public boolean isPaymentMethode() {
        return paymentMethode;
    }

    public Unit setPaymentMethode(boolean paymentMethode) {
        this.paymentMethode = paymentMethode;
        return this;
    }
}
