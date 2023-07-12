package com.taobao.android.dinamicx.videoc.expose.core.listener;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface OnValidateExposeDataListener<ExposeKey, ExposeData> {
    boolean onValidateExposeData(ExposeKey exposekey, ExposeData exposedata, String str, Map<ExposeKey, ExposeData> map);
}
