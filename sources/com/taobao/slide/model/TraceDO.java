package com.taobao.slide.model;

import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TraceDO implements Serializable {
    public static final String KEY_DEVICE = "device";
    public Device device;
    public List<PodData> pods;
    public String ver = "-1";

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class Device implements Serializable {
        public String app_key;
        public String app_ver;
        public String did_hash;
        public String m_brand;
        public String m_model;
        public String m_vendor;
        public String os_ver;
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class PodData implements Serializable {
        public int byPush;
        public String name;
        public int selectedPea;
        public int subs;
        public String ver;
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class PodNames implements Serializable {
        public List<String> pods;
    }
}
