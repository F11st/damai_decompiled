package com.youku.alixplayer.middleware;

import androidx.annotation.Keep;
import com.youku.alixplayer.util.Destructable;
import com.youku.alixplayer.util.SystemSoLoader;
import java.util.Map;

/* compiled from: Taobao */
@Keep
/* loaded from: classes.dex */
public abstract class DefaultRenderMiddleware extends IRenderMiddleware implements Destructable {
    static {
        SystemSoLoader.load("alixplayer");
    }

    private native void deinit();

    @Override // com.youku.alixplayer.util.Destructable
    public void destruct() {
        deinit();
    }

    @Override // com.youku.alixplayer.middleware.IRenderMiddleware
    protected native long init();

    public abstract boolean processData(byte[] bArr, Map<Integer, String> map, long j, long j2, long j3, long j4, long j5);
}
