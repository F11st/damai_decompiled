package com.youku.live.dago.liveplayback.widget.preload;

import android.content.Context;
import com.youku.alixplayer.opensdk.IPlayerContainer;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface IPlayerPreloader {
    public static final int LAIFENG_FORCE_FRESH_TIME = 1000;
    public static final int UC_FORCE_FRESH_TIME = 2000;
    public static final int YOUKU_FORCE_FRESH_TIME = 2000;

    int getForceFreshTime(Context context);

    IPlayerContainer getPlayerContainer(Context context);

    IPlayerContainer getPlayerContainer(String str, Context context);

    String getUniqKey(IPlayerContainer iPlayerContainer);

    String initPlayContainer(Context context);

    boolean isUseFastPlay(IPlayerContainer iPlayerContainer);

    void play(String str, String str2, int i, int i2, boolean z);

    void release(IPlayerContainer iPlayerContainer);

    void setUseFastPlay(IPlayerContainer iPlayerContainer, boolean z);
}
