package com.google.vr.vrcore.common.api;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.aidl.BaseProxy;
import com.google.android.aidl.BaseStub;
import com.google.android.aidl.Codecs;
import com.google.vr.vrcore.common.api.IDaydreamListener;
import com.google.vr.vrcore.common.api.ITransitionCallbacks;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface IDaydreamManager extends IInterface {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static abstract class Stub extends BaseStub implements IDaydreamManager {
        private static final String DESCRIPTOR = "com.google.vr.vrcore.common.api.IDaydreamManager";
        static final int TRANSACTION_deprecatedLaunchInVr = 4;
        static final int TRANSACTION_exitFromVr = 10;
        static final int TRANSACTION_handleInsertionIntoHeadset = 11;
        static final int TRANSACTION_handleRemovalFromHeadset = 12;
        static final int TRANSACTION_launchInVr = 7;
        static final int TRANSACTION_launchVrHome = 8;
        static final int TRANSACTION_launchVrTransition = 9;
        static final int TRANSACTION_onExitingFromVr = 14;
        static final int TRANSACTION_prepareVr = 3;
        static final int TRANSACTION_prepareVr2 = 13;
        static final int TRANSACTION_registerDaydreamIntent = 5;
        static final int TRANSACTION_registerListener = 1;
        static final int TRANSACTION_unregisterDaydreamIntent = 6;
        static final int TRANSACTION_unregisterListener = 2;

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public static class Proxy extends BaseProxy implements IDaydreamManager {
            Proxy(IBinder iBinder) {
                super(iBinder, Stub.DESCRIPTOR);
            }

            @Override // com.google.vr.vrcore.common.api.IDaydreamManager
            public boolean deprecatedLaunchInVr(PendingIntent pendingIntent) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                Codecs.writeParcelable(obtainAndWriteInterfaceToken, pendingIntent);
                Parcel transactAndReadException = transactAndReadException(4, obtainAndWriteInterfaceToken);
                boolean createBoolean = Codecs.createBoolean(transactAndReadException);
                transactAndReadException.recycle();
                return createBoolean;
            }

            @Override // com.google.vr.vrcore.common.api.IDaydreamManager
            public boolean exitFromVr(PendingIntent pendingIntent) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                Codecs.writeParcelable(obtainAndWriteInterfaceToken, pendingIntent);
                Parcel transactAndReadException = transactAndReadException(10, obtainAndWriteInterfaceToken);
                boolean createBoolean = Codecs.createBoolean(transactAndReadException);
                transactAndReadException.recycle();
                return createBoolean;
            }

            @Override // com.google.vr.vrcore.common.api.IDaydreamManager
            public void handleInsertionIntoHeadset(byte[] bArr) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeByteArray(bArr);
                transactOneway(11, obtainAndWriteInterfaceToken);
            }

            @Override // com.google.vr.vrcore.common.api.IDaydreamManager
            public void handleRemovalFromHeadset() throws RemoteException {
                transactOneway(12, obtainAndWriteInterfaceToken());
            }

            @Override // com.google.vr.vrcore.common.api.IDaydreamManager
            public boolean launchInVr(PendingIntent pendingIntent, ComponentName componentName) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                Codecs.writeParcelable(obtainAndWriteInterfaceToken, pendingIntent);
                Codecs.writeParcelable(obtainAndWriteInterfaceToken, componentName);
                Parcel transactAndReadException = transactAndReadException(7, obtainAndWriteInterfaceToken);
                boolean createBoolean = Codecs.createBoolean(transactAndReadException);
                transactAndReadException.recycle();
                return createBoolean;
            }

            @Override // com.google.vr.vrcore.common.api.IDaydreamManager
            public boolean launchVrHome() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(8, obtainAndWriteInterfaceToken());
                boolean createBoolean = Codecs.createBoolean(transactAndReadException);
                transactAndReadException.recycle();
                return createBoolean;
            }

            @Override // com.google.vr.vrcore.common.api.IDaydreamManager
            public boolean launchVrTransition(ITransitionCallbacks iTransitionCallbacks) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                Codecs.writeStrongBinder(obtainAndWriteInterfaceToken, iTransitionCallbacks);
                Parcel transactAndReadException = transactAndReadException(9, obtainAndWriteInterfaceToken);
                boolean createBoolean = Codecs.createBoolean(transactAndReadException);
                transactAndReadException.recycle();
                return createBoolean;
            }

            @Override // com.google.vr.vrcore.common.api.IDaydreamManager
            public void onExitingFromVr() throws RemoteException {
                transactOneway(14, obtainAndWriteInterfaceToken());
            }

            @Override // com.google.vr.vrcore.common.api.IDaydreamManager
            public int prepareVr(ComponentName componentName, HeadTrackingState headTrackingState) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                Codecs.writeParcelable(obtainAndWriteInterfaceToken, componentName);
                Parcel transactAndReadException = transactAndReadException(3, obtainAndWriteInterfaceToken);
                int readInt = transactAndReadException.readInt();
                if (transactAndReadException.readInt() != 0) {
                    headTrackingState.readFromParcel(transactAndReadException);
                }
                transactAndReadException.recycle();
                return readInt;
            }

            @Override // com.google.vr.vrcore.common.api.IDaydreamManager
            public int prepareVr2(ComponentName componentName, int i, PendingIntent pendingIntent, HeadTrackingState headTrackingState) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                Codecs.writeParcelable(obtainAndWriteInterfaceToken, componentName);
                obtainAndWriteInterfaceToken.writeInt(i);
                Codecs.writeParcelable(obtainAndWriteInterfaceToken, pendingIntent);
                Parcel transactAndReadException = transactAndReadException(13, obtainAndWriteInterfaceToken);
                int readInt = transactAndReadException.readInt();
                if (transactAndReadException.readInt() != 0) {
                    headTrackingState.readFromParcel(transactAndReadException);
                }
                transactAndReadException.recycle();
                return readInt;
            }

            @Override // com.google.vr.vrcore.common.api.IDaydreamManager
            public void registerDaydreamIntent(PendingIntent pendingIntent) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                Codecs.writeParcelable(obtainAndWriteInterfaceToken, pendingIntent);
                transactOneway(5, obtainAndWriteInterfaceToken);
            }

            @Override // com.google.vr.vrcore.common.api.IDaydreamManager
            public boolean registerListener(ComponentName componentName, IDaydreamListener iDaydreamListener) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                Codecs.writeParcelable(obtainAndWriteInterfaceToken, componentName);
                Codecs.writeStrongBinder(obtainAndWriteInterfaceToken, iDaydreamListener);
                Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken);
                boolean createBoolean = Codecs.createBoolean(transactAndReadException);
                transactAndReadException.recycle();
                return createBoolean;
            }

            @Override // com.google.vr.vrcore.common.api.IDaydreamManager
            public void unregisterDaydreamIntent() throws RemoteException {
                transactOneway(6, obtainAndWriteInterfaceToken());
            }

            @Override // com.google.vr.vrcore.common.api.IDaydreamManager
            public boolean unregisterListener(ComponentName componentName) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                Codecs.writeParcelable(obtainAndWriteInterfaceToken, componentName);
                Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken);
                boolean createBoolean = Codecs.createBoolean(transactAndReadException);
                transactAndReadException.recycle();
                return createBoolean;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IDaydreamManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface instanceof IDaydreamManager) {
                return (IDaydreamManager) queryLocalInterface;
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
                    boolean registerListener = registerListener((ComponentName) Codecs.createParcelable(parcel, ComponentName.CREATOR), IDaydreamListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    Codecs.writeBoolean(parcel2, registerListener);
                    break;
                case 2:
                    boolean unregisterListener = unregisterListener((ComponentName) Codecs.createParcelable(parcel, ComponentName.CREATOR));
                    parcel2.writeNoException();
                    Codecs.writeBoolean(parcel2, unregisterListener);
                    break;
                case 3:
                    HeadTrackingState headTrackingState = new HeadTrackingState();
                    int prepareVr = prepareVr((ComponentName) Codecs.createParcelable(parcel, ComponentName.CREATOR), headTrackingState);
                    parcel2.writeNoException();
                    parcel2.writeInt(prepareVr);
                    Codecs.writeParcelableAsReturnValue(parcel2, headTrackingState);
                    break;
                case 4:
                    boolean deprecatedLaunchInVr = deprecatedLaunchInVr((PendingIntent) Codecs.createParcelable(parcel, PendingIntent.CREATOR));
                    parcel2.writeNoException();
                    Codecs.writeBoolean(parcel2, deprecatedLaunchInVr);
                    break;
                case 5:
                    registerDaydreamIntent((PendingIntent) Codecs.createParcelable(parcel, PendingIntent.CREATOR));
                    break;
                case 6:
                    unregisterDaydreamIntent();
                    break;
                case 7:
                    boolean launchInVr = launchInVr((PendingIntent) Codecs.createParcelable(parcel, PendingIntent.CREATOR), (ComponentName) Codecs.createParcelable(parcel, ComponentName.CREATOR));
                    parcel2.writeNoException();
                    Codecs.writeBoolean(parcel2, launchInVr);
                    break;
                case 8:
                    boolean launchVrHome = launchVrHome();
                    parcel2.writeNoException();
                    Codecs.writeBoolean(parcel2, launchVrHome);
                    break;
                case 9:
                    boolean launchVrTransition = launchVrTransition(ITransitionCallbacks.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    Codecs.writeBoolean(parcel2, launchVrTransition);
                    break;
                case 10:
                    boolean exitFromVr = exitFromVr((PendingIntent) Codecs.createParcelable(parcel, PendingIntent.CREATOR));
                    parcel2.writeNoException();
                    Codecs.writeBoolean(parcel2, exitFromVr);
                    break;
                case 11:
                    handleInsertionIntoHeadset(parcel.createByteArray());
                    break;
                case 12:
                    handleRemovalFromHeadset();
                    break;
                case 13:
                    HeadTrackingState headTrackingState2 = new HeadTrackingState();
                    int prepareVr2 = prepareVr2((ComponentName) Codecs.createParcelable(parcel, ComponentName.CREATOR), parcel.readInt(), (PendingIntent) Codecs.createParcelable(parcel, PendingIntent.CREATOR), headTrackingState2);
                    parcel2.writeNoException();
                    parcel2.writeInt(prepareVr2);
                    Codecs.writeParcelableAsReturnValue(parcel2, headTrackingState2);
                    break;
                case 14:
                    onExitingFromVr();
                    break;
                default:
                    return false;
            }
            return true;
        }
    }

    boolean deprecatedLaunchInVr(PendingIntent pendingIntent) throws RemoteException;

    boolean exitFromVr(PendingIntent pendingIntent) throws RemoteException;

    void handleInsertionIntoHeadset(byte[] bArr) throws RemoteException;

    void handleRemovalFromHeadset() throws RemoteException;

    boolean launchInVr(PendingIntent pendingIntent, ComponentName componentName) throws RemoteException;

    boolean launchVrHome() throws RemoteException;

    boolean launchVrTransition(ITransitionCallbacks iTransitionCallbacks) throws RemoteException;

    void onExitingFromVr() throws RemoteException;

    int prepareVr(ComponentName componentName, HeadTrackingState headTrackingState) throws RemoteException;

    int prepareVr2(ComponentName componentName, int i, PendingIntent pendingIntent, HeadTrackingState headTrackingState) throws RemoteException;

    void registerDaydreamIntent(PendingIntent pendingIntent) throws RemoteException;

    boolean registerListener(ComponentName componentName, IDaydreamListener iDaydreamListener) throws RemoteException;

    void unregisterDaydreamIntent() throws RemoteException;

    boolean unregisterListener(ComponentName componentName) throws RemoteException;
}
