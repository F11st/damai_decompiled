package com.youku.arch.beast.apas.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.beast.apas.remote.IApasUpdateListenerInterface;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface IApasApiInterface extends IInterface {

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class Default implements IApasApiInterface {
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1770139726")) {
                return (IBinder) ipChange.ipc$dispatch("1770139726", new Object[]{this});
            }
            return null;
        }

        @Override // com.youku.arch.beast.apas.remote.IApasApiInterface
        public boolean containsNamespace(String str) throws RemoteException {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2015454769")) {
                return ((Boolean) ipChange.ipc$dispatch("2015454769", new Object[]{this, str})).booleanValue();
            }
            return false;
        }

        @Override // com.youku.arch.beast.apas.remote.IApasApiInterface
        public String getConfig(String str, String str2, String str3) throws RemoteException {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1737282875")) {
                return (String) ipChange.ipc$dispatch("1737282875", new Object[]{this, str, str2, str3});
            }
            return null;
        }

        @Override // com.youku.arch.beast.apas.remote.IApasApiInterface
        public Map getConfigs(String str) throws RemoteException {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "577114863")) {
                return (Map) ipChange.ipc$dispatch("577114863", new Object[]{this, str});
            }
            return null;
        }

        @Override // com.youku.arch.beast.apas.remote.IApasApiInterface
        public void registerListener(String str, IApasUpdateListenerInterface iApasUpdateListenerInterface) throws RemoteException {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-507452447")) {
                ipChange.ipc$dispatch("-507452447", new Object[]{this, str, iApasUpdateListenerInterface});
            }
        }

        @Override // com.youku.arch.beast.apas.remote.IApasApiInterface
        public void setRequestExtraInfo(String str, String str2) throws RemoteException {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1817174274")) {
                ipChange.ipc$dispatch("1817174274", new Object[]{this, str, str2});
            }
        }

        @Override // com.youku.arch.beast.apas.remote.IApasApiInterface
        public void unregisterListener(String str, IApasUpdateListenerInterface iApasUpdateListenerInterface) throws RemoteException {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "184938362")) {
                ipChange.ipc$dispatch("184938362", new Object[]{this, str, iApasUpdateListenerInterface});
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements IApasApiInterface {
        private static transient /* synthetic */ IpChange $ipChange = null;
        private static final String DESCRIPTOR = "com.youku.arch.beast.apas.remote.IApasApiInterface";
        static final int TRANSACTION_containsNamespace = 3;
        static final int TRANSACTION_getConfig = 1;
        static final int TRANSACTION_getConfigs = 2;
        static final int TRANSACTION_registerListener = 4;
        static final int TRANSACTION_setRequestExtraInfo = 6;
        static final int TRANSACTION_unregisterListener = 5;

        /* compiled from: Taobao */
        /* loaded from: classes2.dex */
        public static class Proxy implements IApasApiInterface {
            private static transient /* synthetic */ IpChange $ipChange;
            public static IApasApiInterface sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "982905081") ? (IBinder) ipChange.ipc$dispatch("982905081", new Object[]{this}) : this.mRemote;
            }

            @Override // com.youku.arch.beast.apas.remote.IApasApiInterface
            public boolean containsNamespace(String str) throws RemoteException {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-483701796")) {
                    return ((Boolean) ipChange.ipc$dispatch("-483701796", new Object[]{this, str})).booleanValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().containsNamespace(str);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.arch.beast.apas.remote.IApasApiInterface
            public String getConfig(String str, String str2, String str3) throws RemoteException {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1414616720")) {
                    return (String) ipChange.ipc$dispatch("-1414616720", new Object[]{this, str, str2, str3});
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getConfig(str, str2, str3);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.arch.beast.apas.remote.IApasApiInterface
            public Map getConfigs(String str) throws RemoteException {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1144420636")) {
                    return (Map) ipChange.ipc$dispatch("-1144420636", new Object[]{this, str});
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getConfigs(str);
                    }
                    obtain2.readException();
                    return obtain2.readHashMap(getClass().getClassLoader());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-459686158") ? (String) ipChange.ipc$dispatch("-459686158", new Object[]{this}) : Stub.DESCRIPTOR;
            }

            @Override // com.youku.arch.beast.apas.remote.IApasApiInterface
            public void registerListener(String str, IApasUpdateListenerInterface iApasUpdateListenerInterface) throws RemoteException {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-986357684")) {
                    ipChange.ipc$dispatch("-986357684", new Object[]{this, str, iApasUpdateListenerInterface});
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iApasUpdateListenerInterface != null ? iApasUpdateListenerInterface.asBinder() : null);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerListener(str, iApasUpdateListenerInterface);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.arch.beast.apas.remote.IApasApiInterface
            public void setRequestExtraInfo(String str, String str2) throws RemoteException {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "916538157")) {
                    ipChange.ipc$dispatch("916538157", new Object[]{this, str, str2});
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setRequestExtraInfo(str, str2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.arch.beast.apas.remote.IApasApiInterface
            public void unregisterListener(String str, IApasUpdateListenerInterface iApasUpdateListenerInterface) throws RemoteException {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-481493723")) {
                    ipChange.ipc$dispatch("-481493723", new Object[]{this, str, iApasUpdateListenerInterface});
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iApasUpdateListenerInterface != null ? iApasUpdateListenerInterface.asBinder() : null);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterListener(str, iApasUpdateListenerInterface);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IApasApiInterface asInterface(IBinder iBinder) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "749994840")) {
                return (IApasApiInterface) ipChange.ipc$dispatch("749994840", new Object[]{iBinder});
            }
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IApasApiInterface)) {
                return (IApasApiInterface) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IApasApiInterface getDefaultImpl() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1401013663") ? (IApasApiInterface) ipChange.ipc$dispatch("-1401013663", new Object[0]) : Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IApasApiInterface iApasApiInterface) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1943143569")) {
                return ((Boolean) ipChange.ipc$dispatch("1943143569", new Object[]{iApasApiInterface})).booleanValue();
            }
            if (Proxy.sDefaultImpl != null || iApasApiInterface == null) {
                return false;
            }
            Proxy.sDefaultImpl = iApasApiInterface;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "657174179") ? (IBinder) ipChange.ipc$dispatch("657174179", new Object[]{this}) : this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-448105775")) {
                return ((Boolean) ipChange.ipc$dispatch("-448105775", new Object[]{this, Integer.valueOf(i), parcel, parcel2, Integer.valueOf(i2)})).booleanValue();
            }
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        String config = getConfig(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(config);
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        Map configs = getConfigs(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeMap(configs);
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean containsNamespace = containsNamespace(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(containsNamespace ? 1 : 0);
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        registerListener(parcel.readString(), IApasUpdateListenerInterface.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        unregisterListener(parcel.readString(), IApasUpdateListenerInterface.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        setRequestExtraInfo(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString(DESCRIPTOR);
            return true;
        }
    }

    boolean containsNamespace(String str) throws RemoteException;

    String getConfig(String str, String str2, String str3) throws RemoteException;

    Map getConfigs(String str) throws RemoteException;

    void registerListener(String str, IApasUpdateListenerInterface iApasUpdateListenerInterface) throws RemoteException;

    void setRequestExtraInfo(String str, String str2) throws RemoteException;

    void unregisterListener(String str, IApasUpdateListenerInterface iApasUpdateListenerInterface) throws RemoteException;
}
