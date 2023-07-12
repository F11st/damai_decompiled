package com.youku.live.dago.liveplayback.widget.model;

import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class RecordInfoWrapper implements Serializable {
    public String api;
    public Data data;
    public List<String> ret;
    public String v;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class Data implements Serializable {
        public RecordInfo data;
        public String msg;
        public int status;
    }
}
