package com.meizu.cloud.pushsdk.notification;

import android.content.Context;
import android.graphics.Bitmap;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class PushNotificationBuilder {
    private String appLabel;
    private Bitmap appLargeIcon;
    private String clickPackageName;
    private Context context;
    private int mLargeIcon;
    private int mNotificationDefaults;
    private int mNotificationFlags;
    private String mNotificationSound;
    private int mStatusBarIcon;
    private long[] mVibratePattern;

    public PushNotificationBuilder() {
    }

    public PushNotificationBuilder(Context context) {
        this.context = context;
    }

    public String getAppLabel() {
        return this.appLabel;
    }

    public Bitmap getAppLargeIcon() {
        return this.appLargeIcon;
    }

    public String getClickPackageName() {
        return this.clickPackageName;
    }

    public Context getContext() {
        return this.context;
    }

    public int getLargeIcon() {
        return this.mLargeIcon;
    }

    public int getNotificationDefaults() {
        return this.mNotificationDefaults;
    }

    public int getNotificationFlags() {
        return this.mNotificationFlags;
    }

    public String getNotificationSound() {
        return this.mNotificationSound;
    }

    public int getStatusBarIcon() {
        return this.mStatusBarIcon;
    }

    public long[] getVibratePattern() {
        return this.mVibratePattern;
    }

    public void setAppLabel(String str) {
        this.appLabel = str;
    }

    public void setAppLargeIcon(Bitmap bitmap) {
        this.appLargeIcon = bitmap;
    }

    public void setClickPackageName(String str) {
        this.clickPackageName = str;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setLargeIcon(int i) {
        this.mLargeIcon = i;
    }

    public void setNotificationDefaults(int i) {
        this.mNotificationDefaults = i;
    }

    public void setNotificationFlags(int i) {
        this.mNotificationFlags = i;
    }

    public void setNotificationSound(String str) {
        this.mNotificationSound = str;
    }

    public void setStatusBarIcon(int i) {
        this.mStatusBarIcon = i;
    }

    public void setVibratePattern(long[] jArr) {
        this.mVibratePattern = jArr;
    }
}
