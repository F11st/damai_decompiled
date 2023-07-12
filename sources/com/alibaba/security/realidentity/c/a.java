package com.alibaba.security.realidentity.c;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.a.g;
import java.net.InetAddress;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class a extends AsyncTask<String, Void, Map<String, Boolean>> {
    private static final String a = a.class.getSimpleName();
    private final InterfaceC0171a b;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.realidentity.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0171a {
        void a(Map<String, Boolean> map);
    }

    public a(InterfaceC0171a interfaceC0171a) {
        this.b = interfaceC0171a;
    }

    private static Map<String, Boolean> a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String host = URI.create(str).getHost();
                if (!TextUtils.isEmpty(host)) {
                    InetAddress[] allByName = InetAddress.getAllByName(host);
                    HashMap hashMap = new HashMap();
                    for (InetAddress inetAddress : allByName) {
                        hashMap.put(inetAddress.getHostAddress(), Boolean.valueOf(inetAddress.isReachable(100)));
                    }
                    return hashMap;
                }
            }
            return null;
        } catch (Throwable th) {
            g.a.a.a(TrackLog.createSimpleSdk(a, "getIpAddress", th.getMessage()));
            return null;
        }
    }

    @Override // android.os.AsyncTask
    protected /* synthetic */ Map<String, Boolean> doInBackground(String[] strArr) {
        String[] strArr2 = strArr;
        if (strArr2 == null || strArr2.length <= 0) {
            return null;
        }
        return a(strArr2[0]);
    }

    @Override // android.os.AsyncTask
    protected /* synthetic */ void onPostExecute(Map<String, Boolean> map) {
        Map<String, Boolean> map2 = map;
        super.onPostExecute(map2);
        this.b.a(map2);
    }

    private static Map<String, Boolean> a(String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        return a(strArr[0]);
    }

    private void a(Map<String, Boolean> map) {
        super.onPostExecute(map);
        this.b.a(map);
    }
}
