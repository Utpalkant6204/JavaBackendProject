package com.example.RandomDemo.DTO;

public class CriteriaDTO {

    private Long projectId = null;

    private Long employeeId = null;

    private Boolean sortByAsc;

    private PaginationDTO pagination;

    public CriteriaDTO() {
    }

    public CriteriaDTO(Long projectId, Long employeeId, Boolean sortByAsc, PaginationDTO pagination) {
        this.projectId = projectId;
        this.employeeId = employeeId;
        this.sortByAsc = sortByAsc;
        this.pagination = pagination;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Boolean getSortByAsc() {
        return sortByAsc;
    }

    public void setSortByAsc(Boolean sortByAsc) {
        this.sortByAsc = sortByAsc;
    }

    public PaginationDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationDTO pagination) {
        this.pagination = pagination;
    }
}
