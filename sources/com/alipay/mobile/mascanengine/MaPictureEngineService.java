package com.alipay.mobile.mascanengine;

import android.content.Context;
import android.graphics.Bitmap;
import com.alipay.ma.strategies.MaInterceptOperation;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public abstract class MaPictureEngineService {
    public abstract void destroy();

    public abstract MaScanResult process(Bitmap bitmap);

    public abstract MaScanResult process(Bitmap bitmap, boolean z);

    public abstract MaScanResult process(String str);

    public abstract MaScanResult process(String str, boolean z);

    public abstract MaScanResult processARCode(byte[] bArr, int i, int i2, int i3);

    public abstract MaScanResult processByFd(String str, Context context);

    public abstract MaScanResult processByFd(String str, Context context, boolean z);

    public abstract MultiMaScanResult processMultiMa(Bitmap bitmap);

    public abstract MultiMaScanResult processMultiMa(Bitmap bitmap, int i, boolean z);

    public abstract MultiMaScanResult processMultiMa(String str);

    public abstract MultiMaScanResult processMultiMa(String str, int i, boolean z);

    public abstract MultiMaScanResult processMultiMa(String str, int i, boolean z, MaInterceptOperation maInterceptOperation);

    public abstract MultiMaScanResult processMultiMaByFd(String str, Context context);

    public abstract MultiMaScanResult processMultiMaByFd(String str, Context context, int i, boolean z);

    public abstract MultiMaScanResult processMultiMaByFd(String str, Context context, int i, boolean z, MaInterceptOperation maInterceptOperation);
}
