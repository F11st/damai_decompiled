package com.uc.webview.export.media;

import android.content.Context;
import com.uc.webview.export.annotations.Api;

/* compiled from: Taobao */
@Api
/* loaded from: classes11.dex */
public interface MediaPlayerFactory {
    MediaPlayer create(int i, Context context, String str, boolean z, boolean z2, String str2);

    MediaController createMediaController(int i, Context context);

    void init(Context context, Settings settings, String str);

    boolean isMediaSupported(String str);

    boolean isTypeSupported(String str);

    boolean mediaControllerOnlyForSelfPlayer();

    String playerName();

    String[] typeSupports();

    boolean valid();
}
