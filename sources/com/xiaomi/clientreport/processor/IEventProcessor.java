package com.xiaomi.clientreport.processor;

import com.xiaomi.clientreport.data.C7537a;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IEventProcessor extends InterfaceC7550c, InterfaceC7551d {
    String bytesToString(byte[] bArr);

    void setEventMap(HashMap<String, ArrayList<C7537a>> hashMap);

    byte[] stringToBytes(String str);
}
