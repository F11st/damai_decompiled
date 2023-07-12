package com.taobao.slide.stat;

import java.io.Serializable;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class BizStatData implements Serializable {
    public String appSnapshotVersion;
    public String bizId;
    public int code;
    public String digest;
    public String etag;
    public HashMap<String, String> extDimen = new HashMap<>();
    public HashMap<String, Double> extMeasure = new HashMap<>();
    public String message;
    public String module;
    public String monitorPoint;
    public String podver;
    public int stat;
}
