package com.marjorye.sima.models;

import java.io.Serializable;

public class GradeId implements Serializable {

    private long student_id;
    private long class_id;
    private long subject_id;

    public GradeId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GradeId gradeId = (GradeId) o;

        if (student_id != gradeId.student_id) return false;
        if (class_id != gradeId.class_id) return false;
        return subject_id == gradeId.subject_id;
    }

    @Override
    public int hashCode() {
        int result = (int) (student_id ^ (student_id >>> 32));
        result = 31 * result + (int) (class_id ^ (class_id >>> 32));
        result = 31 * result + (int) (subject_id ^ (subject_id >>> 32));
        return result;
    }
}
