package com.alient.oneservice.userinfo;

import android.content.Context;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface LoginProvider {
    boolean checkSessionValid();

    void notifyLogin(Context context, YYLoginListener yYLoginListener);
}
