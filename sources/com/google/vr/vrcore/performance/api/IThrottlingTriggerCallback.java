package com.google.vr.vrcore.performance.api;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.aidl.BaseProxy;
import com.google.android.aidl.BaseStub;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface IThrottlingTriggerCallback extends IInterface {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static abstract class Stub extends BaseStub implements IThrottlingTriggerCallback {
        private static final String DESCRIPTOR = "com.google.vr.vrcore.performance.api.IThrottlingTriggerCallback";
        static final int TRANSACTION_onTriggerActivated = 1;

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public static class Proxy extends BaseProxy implements IThrottlingTriggerCallback {
            Proxy(IBinder iBinder) {
                super(iBinder, Stub.DESCRIPTOR);
            }

            @Override // com.google.vr.vrcore.performance.api.IThrottlingTriggerCallback
            public void onTriggerActivated(float f, long j) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeFloat(f);
                obtainAndWriteInterfaceToken.writeLong(j);
                transactOneway(1, obtainAndWriteInterfaceToken);
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IThrottlingTriggerCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface instanceof IThrottlingTriggerCallback) {
                return (IThrottlingTriggerCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (routeToSuperOrEnforceInterface(i, parcel, parcel2, i2)) {
                return true;
            }
            if (i == 1) {
                onTriggerActivated(parcel.readFloat(), parcel.readLong());
                return true;
            }
            return false;
        }
    }

    void onTriggerActivated(float f, long j) throws RemoteException;
}
