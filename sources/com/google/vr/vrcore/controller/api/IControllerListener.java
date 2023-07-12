package com.google.vr.vrcore.controller.api;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.aidl.BaseProxy;
import com.google.android.aidl.BaseStub;
import com.google.android.aidl.Codecs;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface IControllerListener extends IInterface {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static abstract class Stub extends BaseStub implements IControllerListener {
        private static final String DESCRIPTOR = "com.google.vr.vrcore.controller.api.IControllerListener";
        static final int TRANSACTION_getApiVersion = 1;
        static final int TRANSACTION_getOptions = 9;
        static final int TRANSACTION_onControllerEventPacket = 10;
        static final int TRANSACTION_onControllerEventPacket2 = 12;
        static final int TRANSACTION_onControllerRecentered = 11;
        static final int TRANSACTION_onControllerStateChanged = 2;

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public static class Proxy extends BaseProxy implements IControllerListener {
            Proxy(IBinder iBinder) {
                super(iBinder, Stub.DESCRIPTOR);
            }

            @Override // com.google.vr.vrcore.controller.api.IControllerListener
            public int getApiVersion() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken());
                int readInt = transactAndReadException.readInt();
                transactAndReadException.recycle();
                return readInt;
            }

            @Override // com.google.vr.vrcore.controller.api.IControllerListener
            public ControllerListenerOptions getOptions() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(9, obtainAndWriteInterfaceToken());
                ControllerListenerOptions controllerListenerOptions = (ControllerListenerOptions) Codecs.createParcelable(transactAndReadException, ControllerListenerOptions.CREATOR);
                transactAndReadException.recycle();
                return controllerListenerOptions;
            }

            @Override // com.google.vr.vrcore.controller.api.IControllerListener
            public void onControllerEventPacket(ControllerEventPacket controllerEventPacket) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                Codecs.writeParcelable(obtainAndWriteInterfaceToken, controllerEventPacket);
                transactOneway(10, obtainAndWriteInterfaceToken);
            }

            @Override // com.google.vr.vrcore.controller.api.IControllerListener
            public void onControllerEventPacket2(ControllerEventPacket2 controllerEventPacket2) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                Codecs.writeParcelable(obtainAndWriteInterfaceToken, controllerEventPacket2);
                transactOneway(12, obtainAndWriteInterfaceToken);
            }

            @Override // com.google.vr.vrcore.controller.api.IControllerListener
            public void onControllerRecentered(ControllerOrientationEvent controllerOrientationEvent) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                Codecs.writeParcelable(obtainAndWriteInterfaceToken, controllerOrientationEvent);
                transactOneway(11, obtainAndWriteInterfaceToken);
            }

            @Override // com.google.vr.vrcore.controller.api.IControllerListener
            public void onControllerStateChanged(int i, int i2) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeInt(i);
                obtainAndWriteInterfaceToken.writeInt(i2);
                transactOneway(2, obtainAndWriteInterfaceToken);
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IControllerListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface instanceof IControllerListener) {
                return (IControllerListener) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (routeToSuperOrEnforceInterface(i, parcel, parcel2, i2)) {
                return true;
            }
            if (i == 1) {
                int apiVersion = getApiVersion();
                parcel2.writeNoException();
                parcel2.writeInt(apiVersion);
            } else if (i != 2) {
                switch (i) {
                    case 9:
                        ControllerListenerOptions options = getOptions();
                        parcel2.writeNoException();
                        Codecs.writeParcelableAsReturnValue(parcel2, options);
                        break;
                    case 10:
                        onControllerEventPacket((ControllerEventPacket) Codecs.createParcelable(parcel, ControllerEventPacket.CREATOR));
                        break;
                    case 11:
                        onControllerRecentered((ControllerOrientationEvent) Codecs.createParcelable(parcel, ControllerOrientationEvent.CREATOR));
                        break;
                    case 12:
                        onControllerEventPacket2((ControllerEventPacket2) Codecs.createParcelable(parcel, ControllerEventPacket2.CREATOR));
                        break;
                    default:
                        return false;
                }
            } else {
                onControllerStateChanged(parcel.readInt(), parcel.readInt());
            }
            return true;
        }
    }

    int getApiVersion() throws RemoteException;

    ControllerListenerOptions getOptions() throws RemoteException;

    void onControllerEventPacket(ControllerEventPacket controllerEventPacket) throws RemoteException;

    void onControllerEventPacket2(ControllerEventPacket2 controllerEventPacket2) throws RemoteException;

    void onControllerRecentered(ControllerOrientationEvent controllerOrientationEvent) throws RemoteException;

    void onControllerStateChanged(int i, int i2) throws RemoteException;
}
