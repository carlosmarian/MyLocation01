package br.com.carlosmarian.mobile.mylocation.domain;

/**
 * Created by des on 05/10/16.
 */

public class LocationObject {

private long id = 0;
    private double latitude= 0.0;
    private double longitude= 0.0;
    private long timeStamp = 0;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
