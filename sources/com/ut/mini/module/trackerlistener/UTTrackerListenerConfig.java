package com.ut.mini.module.trackerlistener;

import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UTTrackerListenerConfig implements Serializable {
    private List<String> close;
    private List<String> open;
    private String other;

    public List<String> getClose() {
        return this.close;
    }

    public List<String> getOpen() {
        return this.open;
    }

    public String getOther() {
        return this.other;
    }

    public void setClose(List<String> list) {
        this.close = list;
    }

    public void setOpen(List<String> list) {
        this.open = list;
    }

    public void setOther(String str) {
        this.other = str;
    }
}
