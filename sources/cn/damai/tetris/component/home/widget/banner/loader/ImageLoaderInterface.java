package cn.damai.tetris.component.home.widget.banner.loader;

import android.content.Context;
import android.view.View;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface ImageLoaderInterface<T extends View> extends Serializable {
    T createImageView(Context context);

    void displayImage(Context context, int i, Object obj, T t);
}
