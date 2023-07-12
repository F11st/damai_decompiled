package com.google.vr.vrcore.library.api;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.aidl.BaseProxy;
import com.google.android.aidl.BaseStub;
import com.google.android.aidl.Codecs;
import com.google.vr.vrcore.library.api.IGvrUiLayout;
import com.google.vr.vrcore.library.api.IObjectWrapper;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface IGvrLayout extends IInterface {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static abstract class Stub extends BaseStub implements IGvrLayout {
        private static final String DESCRIPTOR = "com.google.vr.vrcore.library.api.IGvrLayout";
        static final int TRANSACTION_enableAsyncReprojection = 9;
        static final int TRANSACTION_enableCardboardTriggerEmulation = 10;
        static final int TRANSACTION_getNativeGvrContext = 2;
        static final int TRANSACTION_getRootView = 3;
        static final int TRANSACTION_getUiLayout = 4;
        static final int TRANSACTION_onBackPressed = 12;
        static final int TRANSACTION_onPause = 5;
        static final int TRANSACTION_onResume = 6;
        static final int TRANSACTION_setPresentationView = 8;
        static final int TRANSACTION_setReentryIntent = 13;
        static final int TRANSACTION_setStereoModeEnabled = 11;
        static final int TRANSACTION_shutdown = 7;

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public static class Proxy extends BaseProxy implements IGvrLayout {
            Proxy(IBinder iBinder) {
                super(iBinder, Stub.DESCRIPTOR);
            }

            @Override // com.google.vr.vrcore.library.api.IGvrLayout
            public boolean enableAsyncReprojection(int i) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeInt(i);
                Parcel transactAndReadException = transactAndReadException(9, obtainAndWriteInterfaceToken);
                boolean createBoolean = Codecs.createBoolean(transactAndReadException);
                transactAndReadException.recycle();
                return createBoolean;
            }

            @Override // com.google.vr.vrcore.library.api.IGvrLayout
            public boolean enableCardboardTriggerEmulation(IObjectWrapper iObjectWrapper) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                Codecs.writeStrongBinder(obtainAndWriteInterfaceToken, iObjectWrapper);
                Parcel transactAndReadException = transactAndReadException(10, obtainAndWriteInterfaceToken);
                boolean createBoolean = Codecs.createBoolean(transactAndReadException);
                transactAndReadException.recycle();
                return createBoolean;
            }

            @Override // com.google.vr.vrcore.library.api.IGvrLayout
            public long getNativeGvrContext() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken());
                long readLong = transactAndReadException.readLong();
                transactAndReadException.recycle();
                return readLong;
            }

            @Override // com.google.vr.vrcore.library.api.IGvrLayout
            public IObjectWrapper getRootView() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(3, obtainAndWriteInterfaceToken());
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                return asInterface;
            }

            @Override // com.google.vr.vrcore.library.api.IGvrLayout
            public IGvrUiLayout getUiLayout() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(4, obtainAndWriteInterfaceToken());
                IGvrUiLayout asInterface = IGvrUiLayout.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                return asInterface;
            }

            @Override // com.google.vr.vrcore.library.api.IGvrLayout
            public void onBackPressed() throws RemoteException {
                transactAndReadExceptionReturnVoid(12, obtainAndWriteInterfaceToken());
            }

            @Override // com.google.vr.vrcore.library.api.IGvrLayout
            public void onPause() throws RemoteException {
                transactAndReadExceptionReturnVoid(5, obtainAndWriteInterfaceToken());
            }

            @Override // com.google.vr.vrcore.library.api.IGvrLayout
            public void onResume() throws RemoteException {
                transactAndReadExceptionReturnVoid(6, obtainAndWriteInterfaceToken());
            }

            @Override // com.google.vr.vrcore.library.api.IGvrLayout
            public void setPresentationView(IObjectWrapper iObjectWrapper) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                Codecs.writeStrongBinder(obtainAndWriteInterfaceToken, iObjectWrapper);
                transactAndReadExceptionReturnVoid(8, obtainAndWriteInterfaceToken);
            }

            @Override // com.google.vr.vrcore.library.api.IGvrLayout
            public void setReentryIntent(IObjectWrapper iObjectWrapper) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                Codecs.writeStrongBinder(obtainAndWriteInterfaceToken, iObjectWrapper);
                transactAndReadExceptionReturnVoid(13, obtainAndWriteInterfaceToken);
            }

            @Override // com.google.vr.vrcore.library.api.IGvrLayout
            public void setStereoModeEnabled(boolean z) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                Codecs.writeBoolean(obtainAndWriteInterfaceToken, z);
                transactAndReadExceptionReturnVoid(11, obtainAndWriteInterfaceToken);
            }

            @Override // com.google.vr.vrcore.library.api.IGvrLayout
            public void shutdown() throws RemoteException {
                transactAndReadExceptionReturnVoid(7, obtainAndWriteInterfaceToken());
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IGvrLayout asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface instanceof IGvrLayout) {
                return (IGvrLayout) queryLocalInterface;
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
                    long nativeGvrContext = getNativeGvrContext();
                    parcel2.writeNoException();
                    parcel2.writeLong(nativeGvrContext);
                    break;
                case 3:
                    IObjectWrapper rootView = getRootView();
                    parcel2.writeNoException();
                    Codecs.writeStrongBinder(parcel2, rootView);
                    break;
                case 4:
                    IGvrUiLayout uiLayout = getUiLayout();
                    parcel2.writeNoException();
                    Codecs.writeStrongBinder(parcel2, uiLayout);
                    break;
                case 5:
                    onPause();
                    parcel2.writeNoException();
                    break;
                case 6:
                    onResume();
                    parcel2.writeNoException();
                    break;
                case 7:
                    shutdown();
                    parcel2.writeNoException();
                    break;
                case 8:
                    setPresentationView(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    break;
                case 9:
                    boolean enableAsyncReprojection = enableAsyncReprojection(parcel.readInt());
                    parcel2.writeNoException();
                    Codecs.writeBoolean(parcel2, enableAsyncReprojection);
                    break;
                case 10:
                    boolean enableCardboardTriggerEmulation = enableCardboardTriggerEmulation(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    Codecs.writeBoolean(parcel2, enableCardboardTriggerEmulation);
                    break;
                case 11:
                    setStereoModeEnabled(Codecs.createBoolean(parcel));
                    parcel2.writeNoException();
                    break;
                case 12:
                    onBackPressed();
                    parcel2.writeNoException();
                    break;
                case 13:
                    setReentryIntent(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    break;
                default:
                    return false;
            }
            return true;
        }
    }

    boolean enableAsyncReprojection(int i) throws RemoteException;

    boolean enableCardboardTriggerEmulation(IObjectWrapper iObjectWrapper) throws RemoteException;

    long getNativeGvrContext() throws RemoteException;

    IObjectWrapper getRootView() throws RemoteException;

    IGvrUiLayout getUiLayout() throws RemoteException;

    void onBackPressed() throws RemoteException;

    void onPause() throws RemoteException;

    void onResume() throws RemoteException;

    void setPresentationView(IObjectWrapper iObjectWrapper) throws RemoteException;

    void setReentryIntent(IObjectWrapper iObjectWrapper) throws RemoteException;

    void setStereoModeEnabled(boolean z) throws RemoteException;

    void shutdown() throws RemoteException;
}
