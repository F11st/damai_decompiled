package com.alibaba.wireless.security.jaq;

import android.content.Context;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class SecurityStorage {
    private Context a;

    public SecurityStorage(Context context) {
        if (context != null) {
            this.a = context.getApplicationContext();
        }
    }

    public String getString(String str) throws JAQException {
        try {
            return SecurityGuardManager.getInstance(this.a).getDynamicDataStoreComp().getString(str);
        } catch (SecException e) {
            e.printStackTrace();
            throw new JAQException(e.getErrorCode());
        }
    }

    public int putString(String str, String str2) throws JAQException {
        try {
            return SecurityGuardManager.getInstance(this.a).getDynamicDataStoreComp().putString(str, str2);
        } catch (SecException e) {
            e.printStackTrace();
            throw new JAQException(e.getErrorCode());
        }
    }

    public void removeString(String str) throws JAQException {
        try {
            SecurityGuardManager.getInstance(this.a).getDynamicDataStoreComp().removeString(str);
        } catch (SecException e) {
            e.printStackTrace();
            throw new JAQException(e.getErrorCode());
        }
    }
}
