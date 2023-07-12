package com.taobao.android.launcher.biz.task;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public final class Constraints {
    private boolean mRequiresBatteryNotLow;
    private boolean mRequiresStorageNotLow;
    private NetworkType requiredNetworkType;
    private boolean requiresCharging;
    private boolean requiresDeviceIdle;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static final class Builder {
        boolean requiresCharging = false;
        boolean requiresDeviceIdle = false;
        NetworkType requiredNetworkType = NetworkType.NOT_REQUIRED;
        boolean requiresBatteryNotLow = false;
        boolean requiresStorageNotLow = false;

        @NonNull
        public Constraints build() {
            return new Constraints(this);
        }

        @NonNull
        public Builder setRequiredNetworkType(@NonNull NetworkType networkType) {
            this.requiredNetworkType = networkType;
            return this;
        }

        @NonNull
        public Builder setRequiresBatteryNotLow(boolean z) {
            this.requiresBatteryNotLow = z;
            return this;
        }

        @NonNull
        public Builder setRequiresCharging(boolean z) {
            this.requiresCharging = z;
            return this;
        }

        @NonNull
        @RequiresApi(23)
        public Builder setRequiresDeviceIdle(boolean z) {
            this.requiresDeviceIdle = z;
            return this;
        }

        @NonNull
        public Builder setRequiresStorageNotLow(boolean z) {
            this.requiresStorageNotLow = z;
            return this;
        }
    }

    @NonNull
    public NetworkType getRequiredNetworkType() {
        return this.requiredNetworkType;
    }

    public boolean requiresBatteryNotLow() {
        return this.mRequiresBatteryNotLow;
    }

    public boolean requiresCharging() {
        return this.requiresCharging;
    }

    @RequiresApi(23)
    public boolean requiresDeviceIdle() {
        return this.requiresDeviceIdle;
    }

    public boolean requiresStorageNotLow() {
        return this.mRequiresStorageNotLow;
    }

    private Constraints(Builder builder) {
        this.requiresCharging = builder.requiresCharging;
        this.requiresDeviceIdle = Build.VERSION.SDK_INT >= 23 && builder.requiresDeviceIdle;
        this.requiredNetworkType = builder.requiredNetworkType;
        this.mRequiresBatteryNotLow = builder.requiresBatteryNotLow;
        this.mRequiresStorageNotLow = builder.requiresStorageNotLow;
    }
}
