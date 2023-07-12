package com.ta.audid.device;

import android.content.Context;
import com.ut.device.UTDevice;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes7.dex */
public class AppUtdid {
    private static final AppUtdid mInstance = new AppUtdid();

    private AppUtdid() {
    }

    public static AppUtdid getInstance() {
        return mInstance;
    }

    @Deprecated
    public synchronized String getUtdid() {
        return com.ta.utdid2.device.AppUtdid.getInstance().getUtdidCache();
    }

    @Deprecated
    public synchronized String getUtdid(Context context) {
        return UTDevice.getUtdid(context);
    }
}
