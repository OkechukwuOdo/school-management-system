package com.justintime.schoolmanagement.entity.enumz;

public enum StaffType {
    ACADEMIC,NON_ACADEMIC;
    @Override
    public String toString() {
        return this.name();
    }
}
