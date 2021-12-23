package com.codegym.model;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ContractDetailKey contractDetailId;
    private int quantity;

    //    @ManyToOne(targetEntity = Contract.class)
//    @JoinColumn(name = "contractId", referencedColumnName = "contractId")
//    private Contract contract;
    @ManyToOne
    @MapsId("contractId")
    @JoinColumn(name = "contractId")
    private Contract contract;

    //    @ManyToOne(targetEntity = AttachService.class)
//    @JoinColumn(name = "attachServiceId",referencedColumnName = "attachServiceId")
//    private AttachService attachService;
    @ManyToOne
    @MapsId("attachServiceId")
    @JoinColumn(name = "attachServiceId")
    private AttachService attachService;

    public ContractDetail() {
    }

    public ContractDetailKey getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(ContractDetailKey contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
