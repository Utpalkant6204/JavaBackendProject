package com.example.RandomDemo.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchDTO {

    @JsonProperty("criteria")
    private CriteriaDTO criteria;

    public SearchDTO() {
    }

    public SearchDTO(CriteriaDTO criteria) {
        this.criteria = criteria;
    }

    public CriteriaDTO getCriteriaDTO() {
        return criteria;
    }

    public void setCriteriaDTO(CriteriaDTO criteria) {
        this.criteria = criteria;
    }
}
