package com.google.vr.vrcore.library.api;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.aidl.BaseProxy;
import com.google.android.aidl.BaseStub;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface IObjectWrapper extends IInterface {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static abstract class Stub extends BaseStub implements IObjectWrapper {
        private static final String DESCRIPTOR = "com.google.vr.vrcore.library.api.IObjectWrapper";

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public static class Proxy extends BaseProxy implements IObjectWrapper {
            Proxy(IBinder iBinder) {
                super(iBinder, Stub.DESCRIPTOR);
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IObjectWrapper asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface instanceof IObjectWrapper) {
                return (IObjectWrapper) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }
    }
}
