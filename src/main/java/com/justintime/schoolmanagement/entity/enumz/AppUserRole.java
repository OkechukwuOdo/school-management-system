package com.justintime.schoolmanagement.entity.enumz;

public enum AppUserRole {
//    STUDENT,STAFF,ADMIN,SUPPER_ADMIN;
    STUDENT,
    STAFF,
    TEACHER,
    PARENT,
    SUPPER_ADMIN,
    ADMIN;

    @Override
    public String toString() {
        return this.name();
    }
}
