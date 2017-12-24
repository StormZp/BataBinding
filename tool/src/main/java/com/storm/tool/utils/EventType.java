package com.storm.tool.utils;

import android.os.Bundle;

/**
 * Created by kongqing on 2017/5/9.
 */

public class EventType {

    public EventType(String extra, Bundle extras, eventType type) {
        this.extra = extra;
        this.extras = extras;
        this.type = type;
    }

    public eventType getType() {
        return type;
    }

    public EventType setType(eventType type) {
        this.type = type;
        return this;
    }

    public String getExtra() {
        return extra;
    }

    public EventType setExtra(String extra) {
        this.extra = extra;
        return this;
    }

    public Bundle getExtras() {
        return extras;
    }

    public EventType setExtras(Bundle extras) {
        this.extras = extras;
        return this;
    }

    enum eventType {
        LISTTAB, LISTCLASS, SHOP
    }

    private Bundle extras;
    private String extra;
    private eventType type;
}
