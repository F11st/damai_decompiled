package com.taobao.orange.aidl;

import android.os.RemoteException;
import com.taobao.orange.OBaseListener;
import com.taobao.orange.OConfigListener;
import com.taobao.orange.OrangeConfigListener;
import com.taobao.orange.OrangeConfigListenerV1;
import com.taobao.orange.aidl.ParcelableConfigListener;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class OrangeConfigListenerStub extends ParcelableConfigListener.Stub {
    private boolean append;
    private OBaseListener mListener;

    public OrangeConfigListenerStub(OBaseListener oBaseListener) {
        this.append = true;
        this.mListener = oBaseListener;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.mListener.equals(((OrangeConfigListenerStub) obj).mListener);
    }

    public int hashCode() {
        return this.mListener.hashCode();
    }

    public boolean isAppend() {
        return this.append;
    }

    @Override // com.taobao.orange.aidl.ParcelableConfigListener
    public void onConfigUpdate(String str, Map map) throws RemoteException {
        OBaseListener oBaseListener = this.mListener;
        if (oBaseListener instanceof OrangeConfigListener) {
            ((OrangeConfigListener) oBaseListener).onConfigUpdate(str);
        } else if (oBaseListener instanceof OrangeConfigListenerV1) {
            ((OrangeConfigListenerV1) this.mListener).onConfigUpdate(str, Boolean.parseBoolean((String) ((HashMap) map).get("fromCache")));
        } else if (oBaseListener instanceof OConfigListener) {
            ((OConfigListener) oBaseListener).onConfigUpdate(str, (HashMap) map);
        }
    }

    public OrangeConfigListenerStub(OBaseListener oBaseListener, boolean z) {
        this.append = true;
        this.append = z;
        this.mListener = oBaseListener;
    }
}
