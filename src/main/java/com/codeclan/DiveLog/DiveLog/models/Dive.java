package com.codeclan.DiveLog.DiveLog.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "dives")
public class Dive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dive_num")
    private int diveNum;

    @Column(name = "date")
    private Date date;

    @Column(name = "end_time")
    private Calendar endTime;

    @Column(name = "surface_interval")
    private int surfaceInterval;

    @Column(name = "max_depth")
    private int maxDepth;

    @Column(name = "average_depth")
    private int averageDepth;

    @Column(name = "place")
    private String place;

    @Column(name = "dive_site")
    private String diveSite;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "weather")
    private String weather;

    @Column(name = "air_temp")
    private int airTemp;

    @Column(name = "bottom_temp")
    private int bottomTemp;

    @Column(name = "surface_temp")
    private int surfaceTemp;

    @Column(name = "buddy")
    private String buddy;

    @Column(name = "boat")
    private String boat;

    @JsonIgnoreProperties({"dive"})

    //@JsonBackReference
    @OneToMany(mappedBy = "dive")
    private List<Cylinder> cylinders = new ArrayList<>();

    @Column(name = "weight")
    private double weight;

    @Column(name = "notes", length = 5000)
    private String notes;

    @Column(name = "sample_rate")
    private int sampleRate;

    @OneToMany(mappedBy = "dive")
    @JsonBackReference
    @Column(name = "profile")
    private List<SamplePoint> profile = new ArrayList<>();

    public Dive(int diveNum, Date date, Calendar endTime,
                int surfaceInterval, int maxDepth, int averageDepth,
                String place, String diveSite, Double latitude,
                Double longitude, String weather,
                int airTemp, int bottomTemp, int surfaceTemp, String buddy,
                String boat, double weight, String notes, int sampleRate) {
        this.diveNum = diveNum;
        this.date = date;
        this.endTime = endTime;
        this.surfaceInterval = surfaceInterval;
        this.maxDepth = maxDepth;
        this.averageDepth = averageDepth;
        this.place = place;
        this.diveSite = diveSite;
        this.latitude = latitude;
        this.longitude = longitude;
        this.weather = weather;
        this.airTemp = airTemp;
        this.bottomTemp = bottomTemp;
        this.surfaceTemp = surfaceTemp;
        this.buddy = buddy;
        this.boat = boat;
        this.cylinders = new ArrayList<>();
        this.weight = weight;
        this.notes = notes;
        this.sampleRate = sampleRate;
        this.profile = new ArrayList<>();
    }

    public Dive(){

    }

    public int getDiveNum() {
        return diveNum;
    }

    public void setDiveNum(int diveNum) {
        this.diveNum = diveNum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Calendar getEndTime() {
        return endTime;
    }

    public void setEndTime(Calendar endTime) {
        this.endTime = endTime;
    }

    public int getSurfaceInterval() {
        return surfaceInterval;
    }

    public void setSurfaceInterval(int surfaceInterval) {
        this.surfaceInterval = surfaceInterval;
    }

    public int getMaxDepth() {
        return maxDepth;
    }

    public void setMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
    }

    public int getAverageDepth() {
        return averageDepth;
    }

    public void setAverageDepth(int averageDepth) {
        this.averageDepth = averageDepth;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDiveSite() {
        return diveSite;
    }

    public void setDiveSite(String diveSite) {
        this.diveSite = diveSite;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public int getAirTemp() {
        return airTemp;
    }

    public void setAirTemp(int airTemp) {
        this.airTemp = airTemp;
    }

    public int getBottomTemp() {
        return bottomTemp;
    }

    public void setBottomTemp(int bottomTemp) {
        this.bottomTemp = bottomTemp;
    }

    public int getSurfaceTemp() {
        return surfaceTemp;
    }

    public void setSurfaceTemp(int surfaceTemp) {
        this.surfaceTemp = surfaceTemp;
    }

    public String getBuddy() {
        return buddy;
    }

    public void setBuddy(String buddy) {
        this.buddy = buddy;
    }

    public String getBoat() {
        return boat;
    }

    public void setBoat(String boat) {
        this.boat = boat;
    }

    public List<Cylinder> getCylinders() {
        return cylinders;
    }


    public void setCylinders(List<Cylinder> cylinders) {
        this.cylinders = cylinders;
    }

    public void addCylinder(Cylinder cylinder) {
        this.cylinders.add(cylinder);
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getSampleRate() {
        return sampleRate;
    }

    public void setSampleRate(int sampleRate) {
        this.sampleRate = sampleRate;
    }

    public List<SamplePoint> getProfile() {
        return profile;
    }

    public void addSamplePointToProfile(SamplePoint samplePoint) {
        this.profile.add(samplePoint);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
