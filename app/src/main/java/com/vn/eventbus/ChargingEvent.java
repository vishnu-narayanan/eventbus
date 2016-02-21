package com.vn.eventbus;

/**
 * Created by vn on 21/2/16.
 */
public class ChargingEvent {

    private String data;

    public ChargingEvent(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
