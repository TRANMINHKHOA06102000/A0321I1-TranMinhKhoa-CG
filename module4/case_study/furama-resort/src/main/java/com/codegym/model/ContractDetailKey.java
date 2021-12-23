package com.codegym.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ContractDetailKey implements Serializable {
    private int contractId;
    private int attachServiceId;

    public ContractDetailKey() {
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public int getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(int attachServiceId) {
        this.attachServiceId = attachServiceId;
    }
}
