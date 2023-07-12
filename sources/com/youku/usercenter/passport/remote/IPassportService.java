package com.youku.usercenter.passport.remote;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.youku.usercenter.passport.remote.ICallback;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface IPassportService extends IInterface {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IPassportService {
        private static final String DESCRIPTOR = "com.youku.usercenter.passport.remote.IPassportService";
        static final int TRANSACTION_SNSAddBind = 14;
        static final int TRANSACTION_SNSDeleteBind = 15;
        static final int TRANSACTION_addRelation = 34;
        static final int TRANSACTION_bindMobile = 23;
        static final int TRANSACTION_bindSNS = 29;
        static final int TRANSACTION_checkAndLoginTaobao = 40;
        static final int TRANSACTION_getCookie = 8;
        static final int TRANSACTION_getEncryptedYtId = 7;
        static final int TRANSACTION_getLoginRecord = 39;
        static final int TRANSACTION_getSNSBindInfo = 28;
        static final int TRANSACTION_getSNSBindInfos = 13;
        static final int TRANSACTION_getSToken = 5;
        static final int TRANSACTION_getUnionToken = 42;
        static final int TRANSACTION_getUnionTokenByUnit = 43;
        static final int TRANSACTION_getUpdatedUserInfo = 30;
        static final int TRANSACTION_getUserInfo = 10;
        static final int TRANSACTION_getUserTags = 21;
        static final int TRANSACTION_getYktk = 6;
        static final int TRANSACTION_h5ToNativeLogin = 17;
        static final int TRANSACTION_handleCookieError = 19;
        static final int TRANSACTION_handleMMAuth = 12;
        static final int TRANSACTION_handleMMAuthFail = 31;
        static final int TRANSACTION_handleSchema = 37;
        static final int TRANSACTION_init = 1;
        static final int TRANSACTION_initWithCallback = 2;
        static final int TRANSACTION_isBoundMobile = 22;
        static final int TRANSACTION_isFingerprintAuthEnabled = 26;
        static final int TRANSACTION_isFingerprintAvailable = 25;
        static final int TRANSACTION_isLogin = 4;
        static final int TRANSACTION_isLogining = 20;
        static final int TRANSACTION_isQuickLoginAvailable = 33;
        static final int TRANSACTION_logout = 9;
        static final int TRANSACTION_onActivityResult = 11;
        static final int TRANSACTION_pullLoginDialog = 44;
        static final int TRANSACTION_pullNicknameModify = 45;
        static final int TRANSACTION_pullRelation = 35;
        static final int TRANSACTION_queryDeviceUserInfo = 38;
        static final int TRANSACTION_refreshSToken = 18;
        static final int TRANSACTION_sendLoginInvitation = 36;
        static final int TRANSACTION_setFingerprintAuthEnabled = 27;
        static final int TRANSACTION_shouldOverrideUrlLoading = 16;
        static final int TRANSACTION_uccTrustLogin = 41;
        static final int TRANSACTION_unbindSNS = 32;
        static final int TRANSACTION_validatePassport = 3;
        static final int TRANSACTION_verifyMobile = 24;

        /* compiled from: Taobao */
        /* loaded from: classes3.dex */
        private static class Proxy implements IPassportService {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public void SNSAddBind(ICallback iCallback, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCallback != null ? iCallback.asBinder() : null);
                    obtain.writeString(str);
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public void SNSDeleteBind(ICallback iCallback, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCallback != null ? iCallback.asBinder() : null);
                    obtain.writeString(str);
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public void addRelation(ICallback iCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCallback != null ? iCallback.asBinder() : null);
                    this.mRemote.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public void bindMobile(String str, String str2, ICallback iCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(iCallback != null ? iCallback.asBinder() : null);
                    this.mRemote.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public void bindSNS(ICallback iCallback, String str, String str2, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCallback != null ? iCallback.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public void checkAndLoginTaobao(ICallback iCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCallback != null ? iCallback.asBinder() : null);
                    this.mRemote.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public String getCookie() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public String getEncryptedYtId() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public String getLoginRecord() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public void getSNSBindInfo(ICallback iCallback, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCallback != null ? iCallback.asBinder() : null);
                    obtain.writeString(str);
                    this.mRemote.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public void getSNSBindInfos(ICallback iCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCallback != null ? iCallback.asBinder() : null);
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public String getSToken() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public void getUnionToken(ICallback iCallback, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCallback != null ? iCallback.asBinder() : null);
                    obtain.writeString(str);
                    this.mRemote.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public void getUnionTokenByUnit(ICallback iCallback, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCallback != null ? iCallback.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public void getUpdatedUserInfo(ICallback iCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCallback != null ? iCallback.asBinder() : null);
                    this.mRemote.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public UserInfo getUserInfo() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? UserInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public void getUserTags(ICallback iCallback, String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCallback != null ? iCallback.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.mRemote.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public String getYktk() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public void h5ToNativeLogin(ICallback iCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCallback != null ? iCallback.asBinder() : null);
                    this.mRemote.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public boolean handleCookieError(int i, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    this.mRemote.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public void handleMMAuth(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public void handleMMAuthFail() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public boolean handleSchema(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public void init(PassportConfig passportConfig) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (passportConfig != null) {
                        obtain.writeInt(1);
                        passportConfig.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public void initWithCallback(ICallback iCallback, PassportConfig passportConfig) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCallback != null ? iCallback.asBinder() : null);
                    if (passportConfig != null) {
                        obtain.writeInt(1);
                        passportConfig.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public boolean isBoundMobile() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public boolean isFingerprintAuthEnabled() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public boolean isFingerprintAvailable() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public boolean isLogin() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public boolean isLogining() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public boolean isQuickLoginAvailable() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public void logout() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public void onActivityResult(int i, int i2, Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public void pullLoginDialog(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public void pullNicknameModify(String str, String str2, ICallback iCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(iCallback != null ? iCallback.asBinder() : null);
                    this.mRemote.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public void pullRelation(ICallback iCallback, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCallback != null ? iCallback.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public void queryDeviceUserInfo(ICallback iCallback, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCallback != null ? iCallback.asBinder() : null);
                    obtain.writeString(str);
                    this.mRemote.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public void refreshSToken() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public void sendLoginInvitation(ICallback iCallback, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCallback != null ? iCallback.asBinder() : null);
                    obtain.writeString(str);
                    this.mRemote.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public void setFingerprintAuthEnabled(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public boolean shouldOverrideUrlLoading(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public void uccTrustLogin(String str, String str2, Map map, ICallback iCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeMap(map);
                    obtain.writeStrongBinder(iCallback != null ? iCallback.asBinder() : null);
                    this.mRemote.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public void unbindSNS(ICallback iCallback, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCallback != null ? iCallback.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public void validatePassport(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.youku.usercenter.passport.remote.IPassportService
            public void verifyMobile(String str, String str2, String str3, ICallback iCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeStrongBinder(iCallback != null ? iCallback.asBinder() : null);
                    this.mRemote.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IPassportService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IPassportService)) {
                return (IPassportService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        init(parcel.readInt() != 0 ? PassportConfig.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        initWithCallback(ICallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? PassportConfig.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        validatePassport(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean isLogin = isLogin();
                        parcel2.writeNoException();
                        parcel2.writeInt(isLogin ? 1 : 0);
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        String sToken = getSToken();
                        parcel2.writeNoException();
                        parcel2.writeString(sToken);
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        String yktk = getYktk();
                        parcel2.writeNoException();
                        parcel2.writeString(yktk);
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        String encryptedYtId = getEncryptedYtId();
                        parcel2.writeNoException();
                        parcel2.writeString(encryptedYtId);
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        String cookie = getCookie();
                        parcel2.writeNoException();
                        parcel2.writeString(cookie);
                        return true;
                    case 9:
                        parcel.enforceInterface(DESCRIPTOR);
                        logout();
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface(DESCRIPTOR);
                        UserInfo userInfo = getUserInfo();
                        parcel2.writeNoException();
                        if (userInfo != null) {
                            parcel2.writeInt(1);
                            userInfo.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 11:
                        parcel.enforceInterface(DESCRIPTOR);
                        onActivityResult(parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 12:
                        parcel.enforceInterface(DESCRIPTOR);
                        handleMMAuth(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 13:
                        parcel.enforceInterface(DESCRIPTOR);
                        getSNSBindInfos(ICallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 14:
                        parcel.enforceInterface(DESCRIPTOR);
                        SNSAddBind(ICallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 15:
                        parcel.enforceInterface(DESCRIPTOR);
                        SNSDeleteBind(ICallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 16:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean shouldOverrideUrlLoading = shouldOverrideUrlLoading(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(shouldOverrideUrlLoading ? 1 : 0);
                        return true;
                    case 17:
                        parcel.enforceInterface(DESCRIPTOR);
                        h5ToNativeLogin(ICallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 18:
                        parcel.enforceInterface(DESCRIPTOR);
                        refreshSToken();
                        parcel2.writeNoException();
                        return true;
                    case 19:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean handleCookieError = handleCookieError(parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        parcel2.writeInt(handleCookieError ? 1 : 0);
                        return true;
                    case 20:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean isLogining = isLogining();
                        parcel2.writeNoException();
                        parcel2.writeInt(isLogining ? 1 : 0);
                        return true;
                    case 21:
                        parcel.enforceInterface(DESCRIPTOR);
                        getUserTags(ICallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 22:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean isBoundMobile = isBoundMobile();
                        parcel2.writeNoException();
                        parcel2.writeInt(isBoundMobile ? 1 : 0);
                        return true;
                    case 23:
                        parcel.enforceInterface(DESCRIPTOR);
                        bindMobile(parcel.readString(), parcel.readString(), ICallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 24:
                        parcel.enforceInterface(DESCRIPTOR);
                        verifyMobile(parcel.readString(), parcel.readString(), parcel.readString(), ICallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 25:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean isFingerprintAvailable = isFingerprintAvailable();
                        parcel2.writeNoException();
                        parcel2.writeInt(isFingerprintAvailable ? 1 : 0);
                        return true;
                    case 26:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean isFingerprintAuthEnabled = isFingerprintAuthEnabled();
                        parcel2.writeNoException();
                        parcel2.writeInt(isFingerprintAuthEnabled ? 1 : 0);
                        return true;
                    case 27:
                        parcel.enforceInterface(DESCRIPTOR);
                        setFingerprintAuthEnabled(parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 28:
                        parcel.enforceInterface(DESCRIPTOR);
                        getSNSBindInfo(ICallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 29:
                        parcel.enforceInterface(DESCRIPTOR);
                        bindSNS(ICallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 30:
                        parcel.enforceInterface(DESCRIPTOR);
                        getUpdatedUserInfo(ICallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 31:
                        parcel.enforceInterface(DESCRIPTOR);
                        handleMMAuthFail();
                        parcel2.writeNoException();
                        return true;
                    case 32:
                        parcel.enforceInterface(DESCRIPTOR);
                        unbindSNS(ICallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 33:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean isQuickLoginAvailable = isQuickLoginAvailable();
                        parcel2.writeNoException();
                        parcel2.writeInt(isQuickLoginAvailable ? 1 : 0);
                        return true;
                    case 34:
                        parcel.enforceInterface(DESCRIPTOR);
                        addRelation(ICallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 35:
                        parcel.enforceInterface(DESCRIPTOR);
                        pullRelation(ICallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 36:
                        parcel.enforceInterface(DESCRIPTOR);
                        sendLoginInvitation(ICallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 37:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean handleSchema = handleSchema(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(handleSchema ? 1 : 0);
                        return true;
                    case 38:
                        parcel.enforceInterface(DESCRIPTOR);
                        queryDeviceUserInfo(ICallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 39:
                        parcel.enforceInterface(DESCRIPTOR);
                        String loginRecord = getLoginRecord();
                        parcel2.writeNoException();
                        parcel2.writeString(loginRecord);
                        return true;
                    case 40:
                        parcel.enforceInterface(DESCRIPTOR);
                        checkAndLoginTaobao(ICallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 41:
                        parcel.enforceInterface(DESCRIPTOR);
                        uccTrustLogin(parcel.readString(), parcel.readString(), parcel.readHashMap(getClass().getClassLoader()), ICallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 42:
                        parcel.enforceInterface(DESCRIPTOR);
                        getUnionToken(ICallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 43:
                        parcel.enforceInterface(DESCRIPTOR);
                        getUnionTokenByUnit(ICallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 44:
                        parcel.enforceInterface(DESCRIPTOR);
                        pullLoginDialog(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 45:
                        parcel.enforceInterface(DESCRIPTOR);
                        pullNicknameModify(parcel.readString(), parcel.readString(), ICallback.Stub.asInterface(parcel.readStrongBinder()));
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

    void SNSAddBind(ICallback iCallback, String str) throws RemoteException;

    void SNSDeleteBind(ICallback iCallback, String str) throws RemoteException;

    void addRelation(ICallback iCallback) throws RemoteException;

    void bindMobile(String str, String str2, ICallback iCallback) throws RemoteException;

    void bindSNS(ICallback iCallback, String str, String str2, boolean z) throws RemoteException;

    void checkAndLoginTaobao(ICallback iCallback) throws RemoteException;

    String getCookie() throws RemoteException;

    String getEncryptedYtId() throws RemoteException;

    String getLoginRecord() throws RemoteException;

    void getSNSBindInfo(ICallback iCallback, String str) throws RemoteException;

    void getSNSBindInfos(ICallback iCallback) throws RemoteException;

    String getSToken() throws RemoteException;

    void getUnionToken(ICallback iCallback, String str) throws RemoteException;

    void getUnionTokenByUnit(ICallback iCallback, String str, String str2) throws RemoteException;

    void getUpdatedUserInfo(ICallback iCallback) throws RemoteException;

    UserInfo getUserInfo() throws RemoteException;

    void getUserTags(ICallback iCallback, String str, String str2, String str3) throws RemoteException;

    String getYktk() throws RemoteException;

    void h5ToNativeLogin(ICallback iCallback) throws RemoteException;

    boolean handleCookieError(int i, long j) throws RemoteException;

    void handleMMAuth(String str) throws RemoteException;

    void handleMMAuthFail() throws RemoteException;

    boolean handleSchema(String str) throws RemoteException;

    void init(PassportConfig passportConfig) throws RemoteException;

    void initWithCallback(ICallback iCallback, PassportConfig passportConfig) throws RemoteException;

    boolean isBoundMobile() throws RemoteException;

    boolean isFingerprintAuthEnabled() throws RemoteException;

    boolean isFingerprintAvailable() throws RemoteException;

    boolean isLogin() throws RemoteException;

    boolean isLogining() throws RemoteException;

    boolean isQuickLoginAvailable() throws RemoteException;

    void logout() throws RemoteException;

    void onActivityResult(int i, int i2, Intent intent) throws RemoteException;

    void pullLoginDialog(String str) throws RemoteException;

    void pullNicknameModify(String str, String str2, ICallback iCallback) throws RemoteException;

    void pullRelation(ICallback iCallback, String str, String str2) throws RemoteException;

    void queryDeviceUserInfo(ICallback iCallback, String str) throws RemoteException;

    void refreshSToken() throws RemoteException;

    void sendLoginInvitation(ICallback iCallback, String str) throws RemoteException;

    void setFingerprintAuthEnabled(boolean z) throws RemoteException;

    boolean shouldOverrideUrlLoading(String str) throws RemoteException;

    void uccTrustLogin(String str, String str2, Map map, ICallback iCallback) throws RemoteException;

    void unbindSNS(ICallback iCallback, String str, String str2) throws RemoteException;

    void validatePassport(String str, String str2) throws RemoteException;

    void verifyMobile(String str, String str2, String str3, ICallback iCallback) throws RemoteException;
}
