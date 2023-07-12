package com.amap.api.services.route;

import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ElecConsumeInfo {
    private int a;
    private int b;
    private LatLonPoint c;
    private List<Integer> d = new ArrayList();

    public int getConsumeEnergy() {
        return this.a;
    }

    public List<Integer> getLeftEnergy() {
        return this.d;
    }

    public LatLonPoint getRunOutPoint() {
        return this.c;
    }

    public int getRunOutStepIndex() {
        return this.b;
    }

    public void setConsumeEnergy(int i) {
        this.a = i;
    }

    public void setLeftEnergy(List<Integer> list) {
        this.d = list;
    }

    public void setRunOutPoint(LatLonPoint latLonPoint) {
        this.c = latLonPoint;
    }

    public void setRunOutStepIndex(int i) {
        this.b = i;
    }
}
