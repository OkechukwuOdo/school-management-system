package com.justintime.schoolmanagement.entity.enumz;

public enum PaymentStatus {
    PENDING, SUCCESSFUL, FAILED;
    @Override
    public String toString() {
        return this.name();
    }
}
