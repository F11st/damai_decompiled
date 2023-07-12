package com.youku.widget;

import android.text.SpannableStringBuilder;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface BaseRefreshHeader {
    public static final int STATE_DONE = 4;
    public static final int STATE_FULLSCREEN = 3;
    public static final int STATE_NORMAL = 0;
    public static final int STATE_REFRESHING = 2;
    public static final int STATE_RELEASE_TO_REFRESH = 1;

    int getInitHeight();

    int getRefreshingHeight();

    int getState();

    int getVisibleHeight();

    void onMove(float f);

    void refreshComplete();

    void refreshComplete(SpannableStringBuilder spannableStringBuilder);

    boolean releaseAction();

    void setState(int i, SpannableStringBuilder spannableStringBuilder);

    void setVisibleHeight(int i);
}
