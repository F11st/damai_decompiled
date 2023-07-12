package com.uploader.export;

import android.content.Context;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IUploaderEnvironment {
    public static final int DAILY = 2;
    public static final int ONLINE = 0;
    public static final int PREPARED = 1;

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes11.dex */
    public @interface Definition {
    }

    byte[] decrypt(Context context, String str, byte[] bArr);

    boolean enableFlowControl();

    String getAppKey();

    String getAppVersion();

    String getDomain();

    int getEnvironment();

    int getInstanceType();

    byte[] getSslTicket(Context context, String str);

    String getUserId();

    String getUtdid();

    int putSslTicket(Context context, String str, byte[] bArr);

    String signature(String str);
}
