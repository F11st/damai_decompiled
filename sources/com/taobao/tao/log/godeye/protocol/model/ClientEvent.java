package com.taobao.tao.log.godeye.protocol.model;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ClientEvent {
    private String event;
    private Long timestamp;
    private Object value;

    public ClientEvent() {
    }

    public String getEvent() {
        return this.event;
    }

    public Long getTimestamp() {
        return this.timestamp;
    }

    public Object getValue() {
        return this.value;
    }

    public void setEvent(String str) {
        this.event = str;
    }

    public void setTimestamp(Long l) {
        this.timestamp = l;
    }

    public void setValue(Object obj) {
        this.value = obj;
    }

    public ClientEvent(Long l, String str, Object obj) {
        this.timestamp = l;
        this.event = str;
        this.value = obj;
    }
}
