package com.youku.live.dago.widgetlib.ailpbaselib.image;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DagoImageLoader {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "DagoImageLoader";
    private static DagoBaseImageLoader mImageLoader;

    public static DagoBaseImageLoader getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1115432218")) {
            return (DagoBaseImageLoader) ipChange.ipc$dispatch("1115432218", new Object[0]);
        }
        if (mImageLoader == null) {
            mImageLoader = new DagoBaseImageLoader() { // from class: com.youku.live.dago.widgetlib.ailpbaselib.image.DagoImageLoader.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.DagoBaseImageLoader
                public void load(Context context, String str, ImageLoadListener imageLoadListener) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1907221671")) {
                        ipChange2.ipc$dispatch("1907221671", new Object[]{this, context, str, imageLoadListener});
                    }
                }

                @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.DagoBaseImageLoader
                public void load(Context context, String str, ImageLoadListener imageLoadListener, int i) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1005640900")) {
                        ipChange2.ipc$dispatch("-1005640900", new Object[]{this, context, str, imageLoadListener, Integer.valueOf(i)});
                    }
                }

                @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.DagoBaseImageLoader
                public void loadCircle(Context context, String str, ImageLoadListener imageLoadListener) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-563643721")) {
                        ipChange2.ipc$dispatch("-563643721", new Object[]{this, context, str, imageLoadListener});
                    }
                }

                @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.DagoBaseImageLoader
                public void loadCircle(Context context, String str, ImageLoadListener imageLoadListener, int i) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-293056724")) {
                        ipChange2.ipc$dispatch("-293056724", new Object[]{this, context, str, imageLoadListener, Integer.valueOf(i)});
                    }
                }

                @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.DagoBaseImageLoader
                public void show(Context context, String str, ImageView imageView, int i, int i2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-224983718")) {
                        ipChange2.ipc$dispatch("-224983718", new Object[]{this, context, str, imageView, Integer.valueOf(i), Integer.valueOf(i2)});
                    }
                }

                @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.DagoBaseImageLoader
                public void showCircle(Context context, String str, ImageView imageView) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1809725910")) {
                        ipChange2.ipc$dispatch("-1809725910", new Object[]{this, context, str, imageView});
                    }
                }

                @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.DagoBaseImageLoader
                public void showCircle(Context context, String str, ImageView imageView, int i) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-266898919")) {
                        ipChange2.ipc$dispatch("-266898919", new Object[]{this, context, str, imageView, Integer.valueOf(i)});
                    }
                }

                @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.DagoBaseImageLoader
                public void showDefault(Context context, String str, ImageView imageView) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "866137397")) {
                        ipChange2.ipc$dispatch("866137397", new Object[]{this, context, str, imageView});
                    }
                }

                @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.DagoBaseImageLoader
                public void showGif(Context context, String str, ImageView imageView) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1806669256")) {
                        ipChange2.ipc$dispatch("-1806669256", new Object[]{this, context, str, imageView});
                    }
                }

                @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.DagoBaseImageLoader
                public void showRoundCorner(Context context, String str, int i, ImageView imageView) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "432730208")) {
                        ipChange2.ipc$dispatch("432730208", new Object[]{this, context, str, Integer.valueOf(i), imageView});
                    }
                }
            };
            Log.e(TAG, "未设置ImageLoader的实现");
        }
        return mImageLoader;
    }

    public static synchronized void setImageLoader(DagoBaseImageLoader dagoBaseImageLoader) {
        synchronized (DagoImageLoader.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "111464279")) {
                ipChange.ipc$dispatch("111464279", new Object[]{dagoBaseImageLoader});
            } else {
                mImageLoader = dagoBaseImageLoader;
            }
        }
    }
}
