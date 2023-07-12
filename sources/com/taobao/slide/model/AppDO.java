package com.taobao.slide.model;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class AppDO implements ValidDO, Serializable {
    private static final long serialVersionUID = -5760492764522870317L;

    /* renamed from: app  reason: collision with root package name */
    public String f1032app;
    public String dig;
    private transient Map<String, PodDO> podMap = new HashMap();
    public List<PodDO> pods;
    public String version;

    public void buildPodMap() {
        List<PodDO> list = this.pods;
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.podMap == null) {
            this.podMap = new HashMap();
        }
        for (PodDO podDO : this.pods) {
            this.podMap.put(podDO.name, podDO);
        }
    }

    public Map<String, PodDO> getPodMap() {
        if (this.podMap == null) {
            this.podMap = new HashMap();
        }
        return this.podMap;
    }

    @Override // com.taobao.slide.model.ValidDO
    public boolean isValid() {
        List<PodDO> list;
        return (TextUtils.isEmpty(this.f1032app) || TextUtils.isEmpty(this.version) || (list = this.pods) == null || list.isEmpty()) ? false : true;
    }

    public String toString() {
        return String.format("{version:%s, digest:%s}", this.version, this.dig);
    }
}
