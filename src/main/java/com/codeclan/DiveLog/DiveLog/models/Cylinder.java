package com.codeclan.DiveLog.DiveLog.models;

import com.codeclan.DiveLog.DiveLog.interfaces.IValveType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cylinders")
public class Cylinder implements IValveType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dive_id")
    @JsonBackReference
    private Dive dive;

    @OneToOne
    @JoinColumn(name = "regulator_id", referencedColumnName = "id")
    private Regulator regulator;

    @Column(name = "name")
    private String name;

    @Column(name = "date_of_last_test")
    private Date dateOfLastTest;

    @Column(name = "test_type")
    private String testType;

    @Column(name = "valve_type")
    @Enumerated(value = EnumType.STRING)
    private ValveType valveType;

    @Column(name = "volume")
    private int volume;

    @Column(name = "working_pressure")
    private int workingPressure;

    @Column(name = "twin_set")
    private Boolean twinSet;

    @Column(name = "bar_start")
    private int barStart;

    @Column(name = "bar_end")
    private int barEnd;

    @Column(name = "o2mix")
    private int o2mix;

    @Column(name = "notes")
    private String notes;

    public Cylinder(Dive dive, Regulator regulator, String name, Date dateOfLastTest, String testType,
                    ValveType valveType, int volume, int workingPressure, Boolean twinSet,
                    int barStart, int barEnd, int o2mix, String notes) {
        this.dive = dive;
        this.regulator = regulator;
        this.name = name;
        this.dateOfLastTest = dateOfLastTest;
        this.testType = testType;
        this.valveType = valveType;
        this.volume = volume;
        this.workingPressure = workingPressure;
        this.twinSet = twinSet;
        this.barStart = barStart;
        this.barEnd = barEnd;
        this.o2mix = o2mix;
        this.notes = notes;
    }

    public Cylinder() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Dive getDive() {
        return dive;
    }

    public void setDive(Dive dive) {
        this.dive = dive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfLastTest() {
        return dateOfLastTest;
    }

    public void setDateOfLastTest(Date dateOfLastTest) {
        this.dateOfLastTest = dateOfLastTest;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public ValveType getValveType() {
        return valveType;
    }

    public void setValveType(ValveType valveType) {
        this.valveType = valveType;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getWorkingPressure() {
        return workingPressure;
    }

    public void setWorkingPressure(int workingPressure) {
        this.workingPressure = workingPressure;
    }

    public Boolean getTwinSet() {
        return twinSet;
    }

    public void setTwinSet(Boolean twinSet) {
        this.twinSet = twinSet;
    }

    public int getBarStart() {
        return barStart;
    }

    public void setBarStart(int barStart) {
        this.barStart = barStart;
    }

    public int getBarEnd() {
        return barEnd;
    }

    public void setBarEnd(int barEnd) {
        this.barEnd = barEnd;
    }

    public int getO2mix() {
        return o2mix;
    }

    public void setO2mix(int o2mix) {
        this.o2mix = o2mix;
    }

    public Regulator getRegulator() {
        return regulator;
    }

    public void setRegulator(Regulator regulator) {
        this.regulator = regulator;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
