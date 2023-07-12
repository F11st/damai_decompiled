package com.xiaomi.clientreport.processor;

import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IEventProcessor extends c, d {
    String bytesToString(byte[] bArr);

    void setEventMap(HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> hashMap);

    byte[] stringToBytes(String str);
}
