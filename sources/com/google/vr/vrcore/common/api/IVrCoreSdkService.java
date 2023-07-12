package com.google.vr.vrcore.common.api;

import android.content.ComponentName;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.aidl.BaseProxy;
import com.google.android.aidl.BaseStub;
import com.google.android.aidl.Codecs;
import com.google.vr.vrcore.common.api.IDaydreamManager;
import com.google.vr.vrcore.logging.api.IVrCoreLoggingService;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface IVrCoreSdkService extends IInterface {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static abstract class Stub extends BaseStub implements IVrCoreSdkService {
        private static final String DESCRIPTOR = "com.google.vr.vrcore.common.api.IVrCoreSdkService";
        static final int TRANSACTION_getDaydreamManager = 2;
        static final int TRANSACTION_getLoggingService = 4;
        static final int TRANSACTION_initialize = 1;
        static final int TRANSACTION_setClientOptions = 3;

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public static class Proxy extends BaseProxy implements IVrCoreSdkService {
            Proxy(IBinder iBinder) {
                super(iBinder, Stub.DESCRIPTOR);
            }

            @Override // com.google.vr.vrcore.common.api.IVrCoreSdkService
            public IDaydreamManager getDaydreamManager() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken());
                IDaydreamManager asInterface = IDaydreamManager.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                return asInterface;
            }

            @Override // com.google.vr.vrcore.common.api.IVrCoreSdkService
            public IVrCoreLoggingService getLoggingService() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(4, obtainAndWriteInterfaceToken());
                IVrCoreLoggingService asInterface = IVrCoreLoggingService.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                return asInterface;
            }

            @Override // com.google.vr.vrcore.common.api.IVrCoreSdkService
            public boolean initialize(int i) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeInt(i);
                Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken);
                boolean createBoolean = Codecs.createBoolean(transactAndReadException);
                transactAndReadException.recycle();
                return createBoolean;
            }

            @Override // com.google.vr.vrcore.common.api.IVrCoreSdkService
            public boolean setClientOptions(ComponentName componentName, Bundle bundle) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                Codecs.writeParcelable(obtainAndWriteInterfaceToken, componentName);
                Codecs.writeParcelable(obtainAndWriteInterfaceToken, bundle);
                Parcel transactAndReadException = transactAndReadException(3, obtainAndWriteInterfaceToken);
                boolean createBoolean = Codecs.createBoolean(transactAndReadException);
                transactAndReadException.recycle();
                return createBoolean;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IVrCoreSdkService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface instanceof IVrCoreSdkService) {
                return (IVrCoreSdkService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (routeToSuperOrEnforceInterface(i, parcel, parcel2, i2)) {
                return true;
            }
            if (i == 1) {
                boolean initialize = initialize(parcel.readInt());
                parcel2.writeNoException();
                Codecs.writeBoolean(parcel2, initialize);
            } else if (i == 2) {
                IDaydreamManager daydreamManager = getDaydreamManager();
                parcel2.writeNoException();
                Codecs.writeStrongBinder(parcel2, daydreamManager);
            } else if (i == 3) {
                boolean clientOptions = setClientOptions((ComponentName) Codecs.createParcelable(parcel, ComponentName.CREATOR), (Bundle) Codecs.createParcelable(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                Codecs.writeBoolean(parcel2, clientOptions);
            } else if (i != 4) {
                return false;
            } else {
                IVrCoreLoggingService loggingService = getLoggingService();
                parcel2.writeNoException();
                Codecs.writeStrongBinder(parcel2, loggingService);
            }
            return true;
        }
    }

    IDaydreamManager getDaydreamManager() throws RemoteException;

    IVrCoreLoggingService getLoggingService() throws RemoteException;

    boolean initialize(int i) throws RemoteException;

    boolean setClientOptions(ComponentName componentName, Bundle bundle) throws RemoteException;
}
