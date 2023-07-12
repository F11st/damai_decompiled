package com.alimm.xadsdk.info;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.NonNull;
import com.alimm.xadsdk.base.utils.LogUtils;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class AdvertisingIdClient {
    private static final String TAG = "AdvertisingIdClient";

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static final class AdInfo {
        private final String mAdvertisingId;
        private final boolean mLimitAdTrackingEnabled;

        AdInfo(String str, boolean z) {
            this.mAdvertisingId = str;
            this.mLimitAdTrackingEnabled = z;
        }

        public String getId() {
            return this.mAdvertisingId;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.mLimitAdTrackingEnabled;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    private static final class AdvertisingConnection implements ServiceConnection {
        private final LinkedBlockingQueue<IBinder> mBlockingQueue;
        boolean mRetrieved;

        private AdvertisingConnection() {
            this.mBlockingQueue = new LinkedBlockingQueue<>(1);
            this.mRetrieved = false;
        }

        public IBinder getBinder() {
            if (this.mRetrieved) {
                throw new IllegalStateException();
            }
            this.mRetrieved = true;
            return this.mBlockingQueue.take();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.mBlockingQueue.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    private static final class AdvertisingInterface implements IInterface {
        private IBinder mBinder;

        public AdvertisingInterface(IBinder iBinder) {
            this.mBinder = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.mBinder;
        }

        public String getId() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.mBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                LogUtils.d(AdvertisingIdClient.TAG, "getId: id = " + readString);
                return readString;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public boolean isLimitAdTrackingEnabled(boolean z) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean z2 = true;
                obtain.writeInt(z ? 1 : 0);
                this.mBinder.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z2 = false;
                }
                LogUtils.d(AdvertisingIdClient.TAG, "isLimitAdTrackingEnabled: limitAdTracking = " + z2);
                return z2;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public static AdInfo getAdvertisingIdInfo(@NonNull Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            AdvertisingConnection advertisingConnection = new AdvertisingConnection();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            if (context.bindService(intent, advertisingConnection, 1)) {
                try {
                    AdvertisingInterface advertisingInterface = new AdvertisingInterface(advertisingConnection.getBinder());
                    return new AdInfo(advertisingInterface.getId(), advertisingInterface.isLimitAdTrackingEnabled(true));
                } catch (Throwable th) {
                    try {
                        LogUtils.d(TAG, "getAdvertisingIdInfo fail.", th);
                        return null;
                    } finally {
                        context.unbindService(advertisingConnection);
                    }
                }
            }
            return null;
        } catch (Exception e) {
            LogUtils.d(TAG, "getAdvertisingIdInfo fail.", e);
            return null;
        }
    }
}
