package cn.damai.uikit.banner.loader;

import android.content.Context;
import android.view.View;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public interface ImageLoaderInterface<T extends View> extends Serializable {
    T createImageView(Context context);

    void displayImage(Context context, Object obj, T t);
}
