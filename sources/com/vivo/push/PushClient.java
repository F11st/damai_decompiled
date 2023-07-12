package com.vivo.push;

import android.content.Context;
import com.vivo.push.b.C7418f;
import com.vivo.push.util.VivoPushException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class PushClient {
    public static final String DEFAULT_REQUEST_ID = "1";
    private static volatile PushClient sPushClient;

    private PushClient(Context context) {
        C7481e.a().a(context);
    }

    private void checkParam(String str) {
        if (str == null) {
            throw new IllegalArgumentException("PushManager String param should not be ".concat(String.valueOf(str)));
        }
    }

    public static synchronized PushClient getInstance(Context context) {
        PushClient pushClient;
        synchronized (PushClient.class) {
            if (sPushClient == null) {
                sPushClient = new PushClient(context.getApplicationContext());
            }
            pushClient = sPushClient;
        }
        return pushClient;
    }

    public void bindAlias(String str, IPushActionListener iPushActionListener) {
        checkParam(str);
        C7481e.a().a(str, iPushActionListener);
    }

    public void checkManifest() throws VivoPushException {
        C7481e.a().b();
    }

    public void delTopic(String str, IPushActionListener iPushActionListener) {
        ArrayList<String> arrayList = new ArrayList<>(1);
        arrayList.add(str);
        C7481e.a().b(arrayList, iPushActionListener);
    }

    public String getAlias() {
        return C7481e.a().j();
    }

    public String getRegId() {
        return C7481e.a().f();
    }

    public List<String> getTopics() {
        return C7481e.a().c();
    }

    public String getVersion() {
        return "3.4.0.0";
    }

    public void initialize() throws VivoPushException {
        checkManifest();
        C7481e.a().a(new C7418f());
    }

    public boolean isSupport() {
        return C7481e.a().d();
    }

    public void setSystemModel(boolean z) {
        C7481e.a().a(z);
    }

    public void setTopic(String str, IPushActionListener iPushActionListener) {
        ArrayList<String> arrayList = new ArrayList<>(1);
        arrayList.add(str);
        C7481e.a().a(arrayList, iPushActionListener);
    }

    public void turnOffPush(IPushActionListener iPushActionListener) {
        C7481e.a().b(iPushActionListener);
    }

    public void turnOnPush(IPushActionListener iPushActionListener) {
        C7481e.a().a(iPushActionListener);
    }

    public void unBindAlias(String str, IPushActionListener iPushActionListener) {
        checkParam(str);
        C7481e.a().b(str, iPushActionListener);
    }
}
