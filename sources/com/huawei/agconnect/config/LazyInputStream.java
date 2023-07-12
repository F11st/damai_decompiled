package com.huawei.agconnect.config;

import android.content.Context;
import com.huawei.agconnect.config.a.C5480j;
import java.io.InputStream;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes10.dex */
public abstract class LazyInputStream {
    private final Context mContext;
    private InputStream mInput;

    public LazyInputStream(Context context) {
        this.mContext = context;
    }

    public final void close() {
        C5480j.a(this.mInput);
    }

    public abstract InputStream get(Context context);

    public InputStream loadInputStream() {
        if (this.mInput == null) {
            this.mInput = get(this.mContext);
        }
        return this.mInput;
    }
}
