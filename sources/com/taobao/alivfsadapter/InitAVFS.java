package com.taobao.alivfsadapter;

import android.app.Application;
import java.io.Serializable;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class InitAVFS implements Serializable {
    public void init(Application application, HashMap<String, Object> hashMap) {
        AVFSAdapterManager.g().c(application);
    }
}
