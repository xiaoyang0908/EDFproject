package com.example.demo.taskInstance;

public class JobPros1 {
    private String name;

    private Integer duration;

    private Integer period;

    private String type;

    private Integer priority;

    private Integer deadline;

    private Integer separation;

    private Integer releaseTime=0;

    private Integer WCRT=0;

    private Integer computeTime = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getDeadline() {
        return deadline;
    }

    public void setDeadline(Integer deadline) {
        this.deadline = deadline;
    }

    public Integer getSeparation() {
        return separation;
    }

    public void setSeparation(Integer separation) {
        this.separation = separation;
    }

    public Integer getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Integer releaseTime) {
        this.releaseTime = releaseTime;
    }


    public Integer getWCRT() {
        return WCRT;
    }

    public void setWCRT(Integer WCRT) {
        this.WCRT = WCRT;
    }

    public Integer getComputeTime() {
        return computeTime;
    }

    public void setComputeTime(Integer computeTime) {
        this.computeTime = computeTime;
    }
}