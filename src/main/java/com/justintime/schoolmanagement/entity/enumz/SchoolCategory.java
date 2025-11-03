package com.justintime.schoolmanagement.entity.enumz;

public enum SchoolCategory {
    NURSERY_PRIMARY, SECONDARY, UNDER_GRADUATE;
    @Override
    public String toString() {
        return this.name();
    }
}
