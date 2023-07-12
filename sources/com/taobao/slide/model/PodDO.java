package com.taobao.slide.model;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class PodDO implements ValidDO, Serializable {
    private static final long serialVersionUID = 2842186678417063986L;
    public String control;
    public String extra;
    public String name;
    public Set<String> notified;
    public List<PeaDO> peas;
    public int pushType;
    public String ver;
    public int stat = 1;
    public int latestPeaIndex = -1;

    public void addNotify(String str) {
        if (this.notified == null) {
            this.notified = new HashSet();
        }
        this.notified.add(str);
    }

    public boolean isNotified(String str) {
        Set<String> set = this.notified;
        if (set == null) {
            return false;
        }
        return set.contains(str);
    }

    @Override // com.taobao.slide.model.ValidDO
    public boolean isValid() {
        List<PeaDO> list;
        return (TextUtils.isEmpty(this.name) || TextUtils.isEmpty(this.ver) || (list = this.peas) == null || list.isEmpty()) ? false : true;
    }

    public String toString() {
        Object[] objArr = new Object[5];
        objArr[0] = this.name;
        objArr[1] = this.ver;
        objArr[2] = this.control;
        objArr[3] = Boolean.valueOf(this.pushType == 1);
        objArr[4] = Integer.valueOf(this.stat);
        return String.format("{name:%s, ver:%s, control:%s, ispush:%s, stat:%s}", objArr);
    }
}
