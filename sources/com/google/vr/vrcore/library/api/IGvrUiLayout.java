package com.google.vr.vrcore.library.api;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.aidl.BaseProxy;
import com.google.android.aidl.BaseStub;
import com.google.android.aidl.Codecs;
import com.google.vr.vrcore.library.api.IObjectWrapper;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface IGvrUiLayout extends IInterface {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static abstract class Stub extends BaseStub implements IGvrUiLayout {
        private static final String DESCRIPTOR = "com.google.vr.vrcore.library.api.IGvrUiLayout";
        static final int TRANSACTION_getRootView = 2;
        static final int TRANSACTION_isEnabled = 4;
        static final int TRANSACTION_setCloseButtonListener = 5;
        static final int TRANSACTION_setEnabled = 3;
        static final int TRANSACTION_setSettingsButtonEnabled = 8;
        static final int TRANSACTION_setSettingsButtonListener = 9;
        static final int TRANSACTION_setTransitionViewEnabled = 6;
        static final int TRANSACTION_setTransitionViewListener = 7;
        static final int TRANSACTION_setViewerName = 10;

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public static class Proxy extends BaseProxy implements IGvrUiLayout {
            Proxy(IBinder iBinder) {
                super(iBinder, Stub.DESCRIPTOR);
            }

            @Override // com.google.vr.vrcore.library.api.IGvrUiLayout
            public IObjectWrapper getRootView() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken());
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                return asInterface;
            }

            @Override // com.google.vr.vrcore.library.api.IGvrUiLayout
            public boolean isEnabled() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(4, obtainAndWriteInterfaceToken());
                boolean createBoolean = Codecs.createBoolean(transactAndReadException);
                transactAndReadException.recycle();
                return createBoolean;
            }

            @Override // com.google.vr.vrcore.library.api.IGvrUiLayout
            public void setCloseButtonListener(IObjectWrapper iObjectWrapper) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                Codecs.writeStrongBinder(obtainAndWriteInterfaceToken, iObjectWrapper);
                transactAndReadExceptionReturnVoid(5, obtainAndWriteInterfaceToken);
            }

            @Override // com.google.vr.vrcore.library.api.IGvrUiLayout
            public void setEnabled(boolean z) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                Codecs.writeBoolean(obtainAndWriteInterfaceToken, z);
                transactAndReadExceptionReturnVoid(3, obtainAndWriteInterfaceToken);
            }

            @Override // com.google.vr.vrcore.library.api.IGvrUiLayout
            public void setSettingsButtonEnabled(boolean z) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                Codecs.writeBoolean(obtainAndWriteInterfaceToken, z);
                transactAndReadExceptionReturnVoid(8, obtainAndWriteInterfaceToken);
            }

            @Override // com.google.vr.vrcore.library.api.IGvrUiLayout
            public void setSettingsButtonListener(IObjectWrapper iObjectWrapper) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                Codecs.writeStrongBinder(obtainAndWriteInterfaceToken, iObjectWrapper);
                transactAndReadExceptionReturnVoid(9, obtainAndWriteInterfaceToken);
            }

            @Override // com.google.vr.vrcore.library.api.IGvrUiLayout
            public void setTransitionViewEnabled(boolean z) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                Codecs.writeBoolean(obtainAndWriteInterfaceToken, z);
                transactAndReadExceptionReturnVoid(6, obtainAndWriteInterfaceToken);
            }

            @Override // com.google.vr.vrcore.library.api.IGvrUiLayout
            public void setTransitionViewListener(IObjectWrapper iObjectWrapper) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                Codecs.writeStrongBinder(obtainAndWriteInterfaceToken, iObjectWrapper);
                transactAndReadExceptionReturnVoid(7, obtainAndWriteInterfaceToken);
            }

            @Override // com.google.vr.vrcore.library.api.IGvrUiLayout
            public void setViewerName(String str) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeString(str);
                transactAndReadExceptionReturnVoid(10, obtainAndWriteInterfaceToken);
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IGvrUiLayout asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface instanceof IGvrUiLayout) {
                return (IGvrUiLayout) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (routeToSuperOrEnforceInterface(i, parcel, parcel2, i2)) {
                return true;
            }
            switch (i) {
                case 2:
                    IObjectWrapper rootView = getRootView();
                    parcel2.writeNoException();
                    Codecs.writeStrongBinder(parcel2, rootView);
                    break;
                case 3:
                    setEnabled(Codecs.createBoolean(parcel));
                    parcel2.writeNoException();
                    break;
                case 4:
                    boolean isEnabled = isEnabled();
                    parcel2.writeNoException();
                    Codecs.writeBoolean(parcel2, isEnabled);
                    break;
                case 5:
                    setCloseButtonListener(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    break;
                case 6:
                    setTransitionViewEnabled(Codecs.createBoolean(parcel));
                    parcel2.writeNoException();
                    break;
                case 7:
                    setTransitionViewListener(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    break;
                case 8:
                    setSettingsButtonEnabled(Codecs.createBoolean(parcel));
                    parcel2.writeNoException();
                    break;
                case 9:
                    setSettingsButtonListener(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    break;
                case 10:
                    setViewerName(parcel.readString());
                    parcel2.writeNoException();
                    break;
                default:
                    return false;
            }
            return true;
        }
    }

    IObjectWrapper getRootView() throws RemoteException;

    boolean isEnabled() throws RemoteException;

    void setCloseButtonListener(IObjectWrapper iObjectWrapper) throws RemoteException;

    void setEnabled(boolean z) throws RemoteException;

    void setSettingsButtonEnabled(boolean z) throws RemoteException;

    void setSettingsButtonListener(IObjectWrapper iObjectWrapper) throws RemoteException;

    void setTransitionViewEnabled(boolean z) throws RemoteException;

    void setTransitionViewListener(IObjectWrapper iObjectWrapper) throws RemoteException;

    void setViewerName(String str) throws RemoteException;
}
