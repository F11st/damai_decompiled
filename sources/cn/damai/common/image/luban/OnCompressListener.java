package cn.damai.common.image.luban;

import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface OnCompressListener {
    void onError(Throwable th);

    void onStart();

    void onSuccess(File file);
}
