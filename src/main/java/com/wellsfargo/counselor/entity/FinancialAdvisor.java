package com.wellsfargo.counselor.entity;

import ch.qos.logback.core.net.server.Client;
import jakarta.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "FINANCIAL_ADVISOR")
public class FinancialAdvisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "email")
    private String email;

    @Column(nullable = false, name = "password")
    private String password;

    @Column(nullable = false, name = "work_start_time")
    private LocalTime workStartTime;

    @Column(nullable = false, name = "work_end_time")
    private LocalTime workEndTime;

    // 一对多：集合List<Client>，修复类型报错
    @OneToMany(mappedBy = "advisor", cascade = CascadeType.ALL)
    private List<Client> clients;

    // JPA强制无参构造
    protected FinancialAdvisor() {}

    // 全参构造：初始化所有业务实例变量（不含id、集合）
    public FinancialAdvisor(String name, String email, String password,
                            LocalTime workStartTime, LocalTime workEndTime) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.workStartTime = workStartTime;
        this.workEndTime = workEndTime;
    }

    // ID仅Getter，无Setter
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public LocalTime getWorkStartTime() {
        return workStartTime;
    }
    public void setWorkStartTime(LocalTime workStartTime) {
        this.workStartTime = workStartTime;
    }

    public LocalTime getWorkEndTime() {
        return workEndTime;
    }
    public void setWorkEndTime(LocalTime workEndTime) {
        this.workEndTime = workEndTime;
    }

    public List<Client> getClients() {
        return clients;
    }
    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}