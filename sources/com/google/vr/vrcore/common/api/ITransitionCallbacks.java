package com.google.vr.vrcore.common.api;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.aidl.BaseProxy;
import com.google.android.aidl.BaseStub;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface ITransitionCallbacks extends IInterface {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static abstract class Stub extends BaseStub implements ITransitionCallbacks {
        private static final String DESCRIPTOR = "com.google.vr.vrcore.common.api.ITransitionCallbacks";
        static final int TRANSACTION_onTransitionComplete = 1;

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public static class Proxy extends BaseProxy implements ITransitionCallbacks {
            Proxy(IBinder iBinder) {
                super(iBinder, Stub.DESCRIPTOR);
            }

            @Override // com.google.vr.vrcore.common.api.ITransitionCallbacks
            public void onTransitionComplete() throws RemoteException {
                transactOneway(1, obtainAndWriteInterfaceToken());
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ITransitionCallbacks asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface instanceof ITransitionCallbacks) {
                return (ITransitionCallbacks) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (routeToSuperOrEnforceInterface(i, parcel, parcel2, i2)) {
                return true;
            }
            if (i == 1) {
                onTransitionComplete();
                return true;
            }
            return false;
        }
    }

    void onTransitionComplete() throws RemoteException;
}
