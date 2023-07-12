package com.youku.alixplayer.middleware;

import androidx.annotation.Keep;
import com.youku.alixplayer.model.RenderExt;
import com.youku.alixplayer.util.Destructable;
import java.util.Map;

/* compiled from: Taobao */
@Keep
/* loaded from: classes.dex */
public abstract class ExtendedRenderMiddleware extends IRenderMiddleware implements Destructable {
    private native void deinit();

    @Override // com.youku.alixplayer.util.Destructable
    public void destruct() {
        deinit();
    }

    @Override // com.youku.alixplayer.middleware.IRenderMiddleware
    protected native long init();

    public abstract boolean processData(byte[] bArr, Map<Integer, String> map, long j, long j2, long j3, long j4, long j5);

    public abstract boolean processData(byte[] bArr, Map<Integer, String> map, RenderExt renderExt);

    @Keep
    public native void setEnableBuffer(boolean z);

    @Keep
    public native void setEnablePts(boolean z);
}
