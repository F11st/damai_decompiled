package com.google.vr.vrcore.common.api;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.aidl.BaseProxy;
import com.google.android.aidl.BaseStub;
import com.google.android.aidl.Codecs;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface IDaydreamListener extends IInterface {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static abstract class Stub extends BaseStub implements IDaydreamListener {
        private static final String DESCRIPTOR = "com.google.vr.vrcore.common.api.IDaydreamListener";
        static final int TRANSACTION_applyFade = 3;
        static final int TRANSACTION_deprecated_setLensOffsets = 8;
        static final int TRANSACTION_dumpDebugData = 5;
        static final int TRANSACTION_getTargetApiVersion = 1;
        static final int TRANSACTION_invokeCloseAction = 7;
        static final int TRANSACTION_recenterHeadTracking = 4;
        static final int TRANSACTION_requestStopTracking = 2;
        static final int TRANSACTION_resumeHeadTracking = 6;
        static final int TRANSACTION_setLensOffset = 9;

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public static class Proxy extends BaseProxy implements IDaydreamListener {
            Proxy(IBinder iBinder) {
                super(iBinder, Stub.DESCRIPTOR);
            }

            @Override // com.google.vr.vrcore.common.api.IDaydreamListener
            public void applyFade(int i, long j) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeInt(i);
                obtainAndWriteInterfaceToken.writeLong(j);
                transactOneway(3, obtainAndWriteInterfaceToken);
            }

            @Override // com.google.vr.vrcore.common.api.IDaydreamListener
            public void deprecated_setLensOffsets(float f, float f2, float f3, float f4) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeFloat(f);
                obtainAndWriteInterfaceToken.writeFloat(f2);
                obtainAndWriteInterfaceToken.writeFloat(f3);
                obtainAndWriteInterfaceToken.writeFloat(f4);
                transactOneway(8, obtainAndWriteInterfaceToken);
            }

            @Override // com.google.vr.vrcore.common.api.IDaydreamListener
            public void dumpDebugData() throws RemoteException {
                transactOneway(5, obtainAndWriteInterfaceToken());
            }

            @Override // com.google.vr.vrcore.common.api.IDaydreamListener
            public int getTargetApiVersion() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken());
                int readInt = transactAndReadException.readInt();
                transactAndReadException.recycle();
                return readInt;
            }

            @Override // com.google.vr.vrcore.common.api.IDaydreamListener
            public void invokeCloseAction() throws RemoteException {
                transactOneway(7, obtainAndWriteInterfaceToken());
            }

            @Override // com.google.vr.vrcore.common.api.IDaydreamListener
            public void recenterHeadTracking() throws RemoteException {
                transactOneway(4, obtainAndWriteInterfaceToken());
            }

            @Override // com.google.vr.vrcore.common.api.IDaydreamListener
            public HeadTrackingState requestStopTracking() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken());
                HeadTrackingState headTrackingState = (HeadTrackingState) Codecs.createParcelable(transactAndReadException, HeadTrackingState.CREATOR);
                transactAndReadException.recycle();
                return headTrackingState;
            }

            @Override // com.google.vr.vrcore.common.api.IDaydreamListener
            public void resumeHeadTracking(HeadTrackingState headTrackingState) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                Codecs.writeParcelable(obtainAndWriteInterfaceToken, headTrackingState);
                transactOneway(6, obtainAndWriteInterfaceToken);
            }

            @Override // com.google.vr.vrcore.common.api.IDaydreamListener
            public void setLensOffset(float f, float f2, float f3) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeFloat(f);
                obtainAndWriteInterfaceToken.writeFloat(f2);
                obtainAndWriteInterfaceToken.writeFloat(f3);
                transactOneway(9, obtainAndWriteInterfaceToken);
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IDaydreamListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface instanceof IDaydreamListener) {
                return (IDaydreamListener) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (routeToSuperOrEnforceInterface(i, parcel, parcel2, i2)) {
                return true;
            }
            switch (i) {
                case 1:
                    int targetApiVersion = getTargetApiVersion();
                    parcel2.writeNoException();
                    parcel2.writeInt(targetApiVersion);
                    break;
                case 2:
                    HeadTrackingState requestStopTracking = requestStopTracking();
                    parcel2.writeNoException();
                    Codecs.writeParcelableAsReturnValue(parcel2, requestStopTracking);
                    break;
                case 3:
                    applyFade(parcel.readInt(), parcel.readLong());
                    break;
                case 4:
                    recenterHeadTracking();
                    break;
                case 5:
                    dumpDebugData();
                    break;
                case 6:
                    resumeHeadTracking((HeadTrackingState) Codecs.createParcelable(parcel, HeadTrackingState.CREATOR));
                    break;
                case 7:
                    invokeCloseAction();
                    break;
                case 8:
                    deprecated_setLensOffsets(parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat());
                    break;
                case 9:
                    setLensOffset(parcel.readFloat(), parcel.readFloat(), parcel.readFloat());
                    break;
                default:
                    return false;
            }
            return true;
        }
    }

    void applyFade(int i, long j) throws RemoteException;

    void deprecated_setLensOffsets(float f, float f2, float f3, float f4) throws RemoteException;

    void dumpDebugData() throws RemoteException;

    int getTargetApiVersion() throws RemoteException;

    void invokeCloseAction() throws RemoteException;

    void recenterHeadTracking() throws RemoteException;

    HeadTrackingState requestStopTracking() throws RemoteException;

    void resumeHeadTracking(HeadTrackingState headTrackingState) throws RemoteException;

    void setLensOffset(float f, float f2, float f3) throws RemoteException;
}
