package platform.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "codes")
public class Code {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", insertable = false, updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String code;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "time_available", nullable = true)
    private LocalDateTime timeAvailable;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "views_available", nullable = true)
    private Long viewsAvailable;

    public Code() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime date) {
        this.createdAt = date;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getViews() {
        return viewsAvailable;
    }

    public void setViews(Long views) {
        this.viewsAvailable = views;
    }

    public LocalDateTime getTime() {
        return timeAvailable;
    }

    public void setTime(LocalDateTime time) {
        this.timeAvailable = time;
    }
}