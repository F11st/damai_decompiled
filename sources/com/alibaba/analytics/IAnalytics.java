package com.alibaba.analytics;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.alibaba.mtl.appmonitor.Transaction;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface IAnalytics extends IInterface {

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static abstract class Stub extends Binder implements IAnalytics {
        private static final String DESCRIPTOR = "com.alibaba.analytics.IAnalytics";
        static final int TRANSACTION_alarm_checkSampled = 39;
        static final int TRANSACTION_alarm_commitFail1 = 42;
        static final int TRANSACTION_alarm_commitFail2 = 43;
        static final int TRANSACTION_alarm_commitSuccess1 = 40;
        static final int TRANSACTION_alarm_commitSuccess2 = 41;
        static final int TRANSACTION_alarm_enableOfflineAgg = 54;
        static final int TRANSACTION_alarm_setSampling = 38;
        static final int TRANSACTION_alarm_setStatisticsInterval = 37;
        static final int TRANSACTION_counter_checkSampled = 30;
        static final int TRANSACTION_counter_commit1 = 31;
        static final int TRANSACTION_counter_commit2 = 32;
        static final int TRANSACTION_counter_setSampling = 29;
        static final int TRANSACTION_counter_setStatisticsInterval = 28;
        static final int TRANSACTION_destroy = 18;
        static final int TRANSACTION_disableNetworkStatusChecker = 9;
        static final int TRANSACTION_dispatchLocalHits = 10;
        static final int TRANSACTION_enableLog = 14;
        static final int TRANSACTION_getValue = 12;
        static final int TRANSACTION_init = 13;
        static final int TRANSACTION_initUT = 1;
        static final int TRANSACTION_offlinecounter_checkSampled = 35;
        static final int TRANSACTION_offlinecounter_commit = 36;
        static final int TRANSACTION_offlinecounter_setSampling = 34;
        static final int TRANSACTION_offlinecounter_setStatisticsInterval = 33;
        static final int TRANSACTION_onBackground = 59;
        static final int TRANSACTION_onForeground = 60;
        static final int TRANSACTION_register1 = 23;
        static final int TRANSACTION_register2 = 24;
        static final int TRANSACTION_register3 = 25;
        static final int TRANSACTION_register4 = 26;
        static final int TRANSACTION_removeGlobalProperty = 57;
        static final int TRANSACTION_saveCacheDataToLocal = 11;
        static final int TRANSACTION_selfCheck = 55;
        static final int TRANSACTION_sessionTimeout = 58;
        static final int TRANSACTION_setAppVersion = 3;
        static final int TRANSACTION_setChannel = 4;
        static final int TRANSACTION_setGlobalProperty = 56;
        static final int TRANSACTION_setRequestAuthInfo = 15;
        static final int TRANSACTION_setSampling = 20;
        static final int TRANSACTION_setSessionProperties = 6;
        static final int TRANSACTION_setStatisticsInterval1 = 21;
        static final int TRANSACTION_setStatisticsInterval2 = 22;
        static final int TRANSACTION_startMainProcess = 61;
        static final int TRANSACTION_stat_begin = 44;
        static final int TRANSACTION_stat_checkSampled = 48;
        static final int TRANSACTION_stat_commit1 = 49;
        static final int TRANSACTION_stat_commit2 = 50;
        static final int TRANSACTION_stat_commit3 = 51;
        static final int TRANSACTION_stat_end = 45;
        static final int TRANSACTION_stat_setSampling = 47;
        static final int TRANSACTION_stat_setStatisticsInterval = 46;
        static final int TRANSACTION_transaction_begin = 52;
        static final int TRANSACTION_transaction_end = 53;
        static final int TRANSACTION_transferLog = 8;
        static final int TRANSACTION_triggerUpload = 19;
        static final int TRANSACTION_turnOffRealTimeDebug = 17;
        static final int TRANSACTION_turnOnDebug = 7;
        static final int TRANSACTION_turnOnRealTimeDebug = 16;
        static final int TRANSACTION_updateMeasure = 27;
        static final int TRANSACTION_updateSessionProperties = 5;
        static final int TRANSACTION_updateUserAccount = 2;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: Taobao */
        /* loaded from: classes5.dex */
        public static class Proxy implements IAnalytics {
            private IBinder a;

            Proxy(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.alibaba.analytics.IAnalytics
            public boolean alarm_checkSampled(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void alarm_commitFail1(String str, String str2, String str3, String str4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    this.a.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void alarm_commitFail2(String str, String str2, String str3, String str4, String str5) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    obtain.writeString(str5);
                    this.a.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void alarm_commitSuccess1(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void alarm_commitSuccess2(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.a.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void alarm_setSampling(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.a.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void alarm_setStatisticsInterval(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.a.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.alibaba.analytics.IAnalytics
            public boolean counter_checkSampled(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void counter_commit1(String str, String str2, double d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeDouble(d);
                    this.a.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void counter_commit2(String str, String str2, String str3, double d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeDouble(d);
                    this.a.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void counter_setSampling(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.a.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void counter_setStatisticsInterval(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.a.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void destroy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.a.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void dispatchLocalHits() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void enableLog(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    this.a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public String getValue(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void init() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void initUT() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public boolean offlinecounter_checkSampled(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void offlinecounter_commit(String str, String str2, double d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeDouble(d);
                    this.a.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void offlinecounter_setSampling(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.a.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void offlinecounter_setStatisticsInterval(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.a.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void onBackground() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.a.transact(59, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void onForeground() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.a.transact(60, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void register1(String str, String str2, MeasureSet measureSet) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (measureSet != null) {
                        obtain.writeInt(1);
                        measureSet.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void register2(String str, String str2, MeasureSet measureSet, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    int i = 1;
                    if (measureSet != null) {
                        obtain.writeInt(1);
                        measureSet.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.a.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void register3(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (measureSet != null) {
                        obtain.writeInt(1);
                        measureSet.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (dimensionSet != null) {
                        obtain.writeInt(1);
                        dimensionSet.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void register4(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    int i = 1;
                    if (measureSet != null) {
                        obtain.writeInt(1);
                        measureSet.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (dimensionSet != null) {
                        obtain.writeInt(1);
                        dimensionSet.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.a.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void removeGlobalProperty(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.a.transact(57, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void saveCacheDataToLocal() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public String selfCheck(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.a.transact(55, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void sessionTimeout() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.a.transact(58, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void setAppVersion(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void setChannel(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void setGlobalProperty(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(56, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void setRequestAuthInfo(boolean z, boolean z2, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    int i = 1;
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void setSampling(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.a.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void setSessionProperties(Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeMap(map);
                    this.a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void setStatisticsInterval1(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.a.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void setStatisticsInterval2(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.a.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void startMainProcess(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    this.a.transact(61, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void stat_begin(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.a.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public boolean stat_checkSampled(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(48, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void stat_commit1(String str, String str2, double d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeDouble(d);
                    this.a.transact(49, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void stat_commit2(String str, String str2, DimensionValueSet dimensionValueSet, double d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (dimensionValueSet != null) {
                        obtain.writeInt(1);
                        dimensionValueSet.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeDouble(d);
                    this.a.transact(50, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void stat_commit3(String str, String str2, DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (dimensionValueSet != null) {
                        obtain.writeInt(1);
                        dimensionValueSet.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (measureValueSet != null) {
                        obtain.writeInt(1);
                        measureValueSet.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(51, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void stat_end(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.a.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void stat_setSampling(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.a.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void stat_setStatisticsInterval(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.a.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void transaction_begin(Transaction transaction, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (transaction != null) {
                        obtain.writeInt(1);
                        transaction.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    this.a.transact(52, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void transaction_end(Transaction transaction, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (transaction != null) {
                        obtain.writeInt(1);
                        transaction.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    this.a.transact(53, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void transferLog(Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeMap(map);
                    this.a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void triggerUpload() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.a.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void turnOffRealTimeDebug() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.a.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void turnOnDebug() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void turnOnRealTimeDebug(Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeMap(map);
                    this.a.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void updateMeasure(String str, String str2, String str3, double d, double d2, double d3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeDouble(d);
                    obtain.writeDouble(d2);
                    obtain.writeDouble(d3);
                    this.a.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void updateSessionProperties(Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeMap(map);
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void updateUserAccount(String str, String str2, String str3, String str4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    this.a.transact(2, obtain, obtain2, 0);
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

        public static IAnalytics asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IAnalytics)) {
                return (IAnalytics) queryLocalInterface;
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
                        initUT();
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        updateUserAccount(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        setAppVersion(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        setChannel(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        updateSessionProperties(parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        setSessionProperties(parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        turnOnDebug();
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        transferLog(parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    default:
                        switch (i) {
                            case 10:
                                parcel.enforceInterface(DESCRIPTOR);
                                dispatchLocalHits();
                                parcel2.writeNoException();
                                return true;
                            case 11:
                                parcel.enforceInterface(DESCRIPTOR);
                                saveCacheDataToLocal();
                                parcel2.writeNoException();
                                return true;
                            case 12:
                                parcel.enforceInterface(DESCRIPTOR);
                                String value = getValue(parcel.readString());
                                parcel2.writeNoException();
                                parcel2.writeString(value);
                                return true;
                            case 13:
                                parcel.enforceInterface(DESCRIPTOR);
                                init();
                                parcel2.writeNoException();
                                return true;
                            case 14:
                                parcel.enforceInterface(DESCRIPTOR);
                                enableLog(parcel.readInt() != 0);
                                parcel2.writeNoException();
                                return true;
                            case 15:
                                parcel.enforceInterface(DESCRIPTOR);
                                setRequestAuthInfo(parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString(), parcel.readString());
                                parcel2.writeNoException();
                                return true;
                            case 16:
                                parcel.enforceInterface(DESCRIPTOR);
                                turnOnRealTimeDebug(parcel.readHashMap(getClass().getClassLoader()));
                                parcel2.writeNoException();
                                return true;
                            case 17:
                                parcel.enforceInterface(DESCRIPTOR);
                                turnOffRealTimeDebug();
                                parcel2.writeNoException();
                                return true;
                            case 18:
                                parcel.enforceInterface(DESCRIPTOR);
                                destroy();
                                parcel2.writeNoException();
                                return true;
                            case 19:
                                parcel.enforceInterface(DESCRIPTOR);
                                triggerUpload();
                                parcel2.writeNoException();
                                return true;
                            case 20:
                                parcel.enforceInterface(DESCRIPTOR);
                                setSampling(parcel.readInt());
                                parcel2.writeNoException();
                                return true;
                            case 21:
                                parcel.enforceInterface(DESCRIPTOR);
                                setStatisticsInterval1(parcel.readInt());
                                parcel2.writeNoException();
                                return true;
                            case 22:
                                parcel.enforceInterface(DESCRIPTOR);
                                setStatisticsInterval2(parcel.readInt(), parcel.readInt());
                                parcel2.writeNoException();
                                return true;
                            case 23:
                                parcel.enforceInterface(DESCRIPTOR);
                                register1(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? MeasureSet.CREATOR.createFromParcel(parcel) : null);
                                parcel2.writeNoException();
                                return true;
                            case 24:
                                parcel.enforceInterface(DESCRIPTOR);
                                register2(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? MeasureSet.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
                                parcel2.writeNoException();
                                return true;
                            case 25:
                                parcel.enforceInterface(DESCRIPTOR);
                                register3(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? MeasureSet.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? DimensionSet.CREATOR.createFromParcel(parcel) : null);
                                parcel2.writeNoException();
                                return true;
                            case 26:
                                parcel.enforceInterface(DESCRIPTOR);
                                register4(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? MeasureSet.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? DimensionSet.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
                                parcel2.writeNoException();
                                return true;
                            case 27:
                                parcel.enforceInterface(DESCRIPTOR);
                                updateMeasure(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readDouble(), parcel.readDouble(), parcel.readDouble());
                                parcel2.writeNoException();
                                return true;
                            case 28:
                                parcel.enforceInterface(DESCRIPTOR);
                                counter_setStatisticsInterval(parcel.readInt());
                                parcel2.writeNoException();
                                return true;
                            case 29:
                                parcel.enforceInterface(DESCRIPTOR);
                                counter_setSampling(parcel.readInt());
                                parcel2.writeNoException();
                                return true;
                            case 30:
                                parcel.enforceInterface(DESCRIPTOR);
                                boolean counter_checkSampled = counter_checkSampled(parcel.readString(), parcel.readString());
                                parcel2.writeNoException();
                                parcel2.writeInt(counter_checkSampled ? 1 : 0);
                                return true;
                            case 31:
                                parcel.enforceInterface(DESCRIPTOR);
                                counter_commit1(parcel.readString(), parcel.readString(), parcel.readDouble());
                                parcel2.writeNoException();
                                return true;
                            case 32:
                                parcel.enforceInterface(DESCRIPTOR);
                                counter_commit2(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readDouble());
                                parcel2.writeNoException();
                                return true;
                            case 33:
                                parcel.enforceInterface(DESCRIPTOR);
                                offlinecounter_setStatisticsInterval(parcel.readInt());
                                parcel2.writeNoException();
                                return true;
                            case 34:
                                parcel.enforceInterface(DESCRIPTOR);
                                offlinecounter_setSampling(parcel.readInt());
                                parcel2.writeNoException();
                                return true;
                            case 35:
                                parcel.enforceInterface(DESCRIPTOR);
                                boolean offlinecounter_checkSampled = offlinecounter_checkSampled(parcel.readString(), parcel.readString());
                                parcel2.writeNoException();
                                parcel2.writeInt(offlinecounter_checkSampled ? 1 : 0);
                                return true;
                            case 36:
                                parcel.enforceInterface(DESCRIPTOR);
                                offlinecounter_commit(parcel.readString(), parcel.readString(), parcel.readDouble());
                                parcel2.writeNoException();
                                return true;
                            case 37:
                                parcel.enforceInterface(DESCRIPTOR);
                                alarm_setStatisticsInterval(parcel.readInt());
                                parcel2.writeNoException();
                                return true;
                            case 38:
                                parcel.enforceInterface(DESCRIPTOR);
                                alarm_setSampling(parcel.readInt());
                                parcel2.writeNoException();
                                return true;
                            case 39:
                                parcel.enforceInterface(DESCRIPTOR);
                                boolean alarm_checkSampled = alarm_checkSampled(parcel.readString(), parcel.readString());
                                parcel2.writeNoException();
                                parcel2.writeInt(alarm_checkSampled ? 1 : 0);
                                return true;
                            case 40:
                                parcel.enforceInterface(DESCRIPTOR);
                                alarm_commitSuccess1(parcel.readString(), parcel.readString());
                                parcel2.writeNoException();
                                return true;
                            case 41:
                                parcel.enforceInterface(DESCRIPTOR);
                                alarm_commitSuccess2(parcel.readString(), parcel.readString(), parcel.readString());
                                parcel2.writeNoException();
                                return true;
                            case 42:
                                parcel.enforceInterface(DESCRIPTOR);
                                alarm_commitFail1(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                                parcel2.writeNoException();
                                return true;
                            case 43:
                                parcel.enforceInterface(DESCRIPTOR);
                                alarm_commitFail2(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                                parcel2.writeNoException();
                                return true;
                            case 44:
                                parcel.enforceInterface(DESCRIPTOR);
                                stat_begin(parcel.readString(), parcel.readString(), parcel.readString());
                                parcel2.writeNoException();
                                return true;
                            case 45:
                                parcel.enforceInterface(DESCRIPTOR);
                                stat_end(parcel.readString(), parcel.readString(), parcel.readString());
                                parcel2.writeNoException();
                                return true;
                            case 46:
                                parcel.enforceInterface(DESCRIPTOR);
                                stat_setStatisticsInterval(parcel.readInt());
                                parcel2.writeNoException();
                                return true;
                            case 47:
                                parcel.enforceInterface(DESCRIPTOR);
                                stat_setSampling(parcel.readInt());
                                parcel2.writeNoException();
                                return true;
                            case 48:
                                parcel.enforceInterface(DESCRIPTOR);
                                boolean stat_checkSampled = stat_checkSampled(parcel.readString(), parcel.readString());
                                parcel2.writeNoException();
                                parcel2.writeInt(stat_checkSampled ? 1 : 0);
                                return true;
                            case 49:
                                parcel.enforceInterface(DESCRIPTOR);
                                stat_commit1(parcel.readString(), parcel.readString(), parcel.readDouble());
                                parcel2.writeNoException();
                                return true;
                            case 50:
                                parcel.enforceInterface(DESCRIPTOR);
                                stat_commit2(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? DimensionValueSet.CREATOR.createFromParcel(parcel) : null, parcel.readDouble());
                                parcel2.writeNoException();
                                return true;
                            case 51:
                                parcel.enforceInterface(DESCRIPTOR);
                                stat_commit3(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? DimensionValueSet.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? MeasureValueSet.CREATOR.createFromParcel(parcel) : null);
                                parcel2.writeNoException();
                                return true;
                            case 52:
                                parcel.enforceInterface(DESCRIPTOR);
                                transaction_begin(parcel.readInt() != 0 ? Transaction.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                                parcel2.writeNoException();
                                return true;
                            case 53:
                                parcel.enforceInterface(DESCRIPTOR);
                                transaction_end(parcel.readInt() != 0 ? Transaction.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                                parcel2.writeNoException();
                                return true;
                            default:
                                switch (i) {
                                    case 55:
                                        parcel.enforceInterface(DESCRIPTOR);
                                        String selfCheck = selfCheck(parcel.readString());
                                        parcel2.writeNoException();
                                        parcel2.writeString(selfCheck);
                                        return true;
                                    case 56:
                                        parcel.enforceInterface(DESCRIPTOR);
                                        setGlobalProperty(parcel.readString(), parcel.readString());
                                        parcel2.writeNoException();
                                        return true;
                                    case 57:
                                        parcel.enforceInterface(DESCRIPTOR);
                                        removeGlobalProperty(parcel.readString());
                                        parcel2.writeNoException();
                                        return true;
                                    case 58:
                                        parcel.enforceInterface(DESCRIPTOR);
                                        sessionTimeout();
                                        parcel2.writeNoException();
                                        return true;
                                    case 59:
                                        parcel.enforceInterface(DESCRIPTOR);
                                        onBackground();
                                        parcel2.writeNoException();
                                        return true;
                                    case 60:
                                        parcel.enforceInterface(DESCRIPTOR);
                                        onForeground();
                                        parcel2.writeNoException();
                                        return true;
                                    case 61:
                                        parcel.enforceInterface(DESCRIPTOR);
                                        startMainProcess(parcel.readLong());
                                        parcel2.writeNoException();
                                        return true;
                                    default:
                                        return super.onTransact(i, parcel, parcel2, i2);
                                }
                        }
                }
            }
            parcel2.writeString(DESCRIPTOR);
            return true;
        }
    }

    boolean alarm_checkSampled(String str, String str2) throws RemoteException;

    void alarm_commitFail1(String str, String str2, String str3, String str4) throws RemoteException;

    void alarm_commitFail2(String str, String str2, String str3, String str4, String str5) throws RemoteException;

    void alarm_commitSuccess1(String str, String str2) throws RemoteException;

    void alarm_commitSuccess2(String str, String str2, String str3) throws RemoteException;

    void alarm_setSampling(int i) throws RemoteException;

    void alarm_setStatisticsInterval(int i) throws RemoteException;

    boolean counter_checkSampled(String str, String str2) throws RemoteException;

    void counter_commit1(String str, String str2, double d) throws RemoteException;

    void counter_commit2(String str, String str2, String str3, double d) throws RemoteException;

    void counter_setSampling(int i) throws RemoteException;

    void counter_setStatisticsInterval(int i) throws RemoteException;

    void destroy() throws RemoteException;

    void dispatchLocalHits() throws RemoteException;

    void enableLog(boolean z) throws RemoteException;

    String getValue(String str) throws RemoteException;

    void init() throws RemoteException;

    void initUT() throws RemoteException;

    boolean offlinecounter_checkSampled(String str, String str2) throws RemoteException;

    void offlinecounter_commit(String str, String str2, double d) throws RemoteException;

    void offlinecounter_setSampling(int i) throws RemoteException;

    void offlinecounter_setStatisticsInterval(int i) throws RemoteException;

    void onBackground() throws RemoteException;

    void onForeground() throws RemoteException;

    void register1(String str, String str2, MeasureSet measureSet) throws RemoteException;

    void register2(String str, String str2, MeasureSet measureSet, boolean z) throws RemoteException;

    void register3(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet) throws RemoteException;

    void register4(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) throws RemoteException;

    void removeGlobalProperty(String str) throws RemoteException;

    void saveCacheDataToLocal() throws RemoteException;

    String selfCheck(String str) throws RemoteException;

    void sessionTimeout() throws RemoteException;

    void setAppVersion(String str) throws RemoteException;

    void setChannel(String str) throws RemoteException;

    void setGlobalProperty(String str, String str2) throws RemoteException;

    void setRequestAuthInfo(boolean z, boolean z2, String str, String str2) throws RemoteException;

    void setSampling(int i) throws RemoteException;

    void setSessionProperties(Map map) throws RemoteException;

    void setStatisticsInterval1(int i) throws RemoteException;

    void setStatisticsInterval2(int i, int i2) throws RemoteException;

    void startMainProcess(long j) throws RemoteException;

    void stat_begin(String str, String str2, String str3) throws RemoteException;

    boolean stat_checkSampled(String str, String str2) throws RemoteException;

    void stat_commit1(String str, String str2, double d) throws RemoteException;

    void stat_commit2(String str, String str2, DimensionValueSet dimensionValueSet, double d) throws RemoteException;

    void stat_commit3(String str, String str2, DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet) throws RemoteException;

    void stat_end(String str, String str2, String str3) throws RemoteException;

    void stat_setSampling(int i) throws RemoteException;

    void stat_setStatisticsInterval(int i) throws RemoteException;

    void transaction_begin(Transaction transaction, String str) throws RemoteException;

    void transaction_end(Transaction transaction, String str) throws RemoteException;

    void transferLog(Map map) throws RemoteException;

    void triggerUpload() throws RemoteException;

    void turnOffRealTimeDebug() throws RemoteException;

    void turnOnDebug() throws RemoteException;

    void turnOnRealTimeDebug(Map map) throws RemoteException;

    void updateMeasure(String str, String str2, String str3, double d, double d2, double d3) throws RemoteException;

    void updateSessionProperties(Map map) throws RemoteException;

    void updateUserAccount(String str, String str2, String str3, String str4) throws RemoteException;
}
