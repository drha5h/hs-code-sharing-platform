package platform.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CodeDto {
    private String code;

    private String date;

    private Long time;

    private Long views;

    private boolean timeRestricted;

    private boolean viewsRestricted;

    public CodeDto() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    @JsonIgnore
    public boolean isTimeRestricted() {
        return timeRestricted;
    }

    public void setTimeRestricted(boolean timeRestricted) {
        this.timeRestricted = timeRestricted;
    }

    @JsonIgnore
    public boolean isViewsRestricted() {
        return viewsRestricted;
    }

    public void setViewsRestricted(boolean viewsRestricted) {
        this.viewsRestricted = viewsRestricted;
    }
}