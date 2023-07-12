package com.google.vr.vrcore.logging.api;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.aidl.BaseProxy;
import com.google.android.aidl.BaseStub;
import com.google.android.aidl.Codecs;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface IVrCoreLoggingService extends IInterface {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static abstract class Stub extends BaseStub implements IVrCoreLoggingService {
        private static final String DESCRIPTOR = "com.google.vr.vrcore.logging.api.IVrCoreLoggingService";
        static final int TRANSACTION_log = 2;
        static final int TRANSACTION_logBatched = 3;

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public static class Proxy extends BaseProxy implements IVrCoreLoggingService {
            Proxy(IBinder iBinder) {
                super(iBinder, Stub.DESCRIPTOR);
            }

            @Override // com.google.vr.vrcore.logging.api.IVrCoreLoggingService
            public void log(VREventParcelable vREventParcelable) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                Codecs.writeParcelable(obtainAndWriteInterfaceToken, vREventParcelable);
                transactOneway(2, obtainAndWriteInterfaceToken);
            }

            @Override // com.google.vr.vrcore.logging.api.IVrCoreLoggingService
            public void logBatched(VREventParcelable[] vREventParcelableArr) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeTypedArray(vREventParcelableArr, 0);
                transactOneway(3, obtainAndWriteInterfaceToken);
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IVrCoreLoggingService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface instanceof IVrCoreLoggingService) {
                return (IVrCoreLoggingService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (routeToSuperOrEnforceInterface(i, parcel, parcel2, i2)) {
                return true;
            }
            if (i == 2) {
                log((VREventParcelable) Codecs.createParcelable(parcel, VREventParcelable.CREATOR));
            } else if (i != 3) {
                return false;
            } else {
                logBatched((VREventParcelable[]) parcel.createTypedArray(VREventParcelable.CREATOR));
            }
            return true;
        }
    }

    void log(VREventParcelable vREventParcelable) throws RemoteException;

    void logBatched(VREventParcelable[] vREventParcelableArr) throws RemoteException;
}
