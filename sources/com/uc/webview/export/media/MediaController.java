package com.uc.webview.export.media;

import android.view.View;
import com.uc.webview.export.annotations.Api;

/* compiled from: Taobao */
@Api
/* loaded from: classes11.dex */
public interface MediaController {

    /* compiled from: Taobao */
    @Api
    /* loaded from: classes11.dex */
    public interface MediaPlayerControl {
        Object execute(String str, int i, int i2, Object obj);
    }

    View asView();

    void onMessage(String str, long j, long j2, Object obj);

    void setMediaPlayerControl(MediaPlayerControl mediaPlayerControl);
}
