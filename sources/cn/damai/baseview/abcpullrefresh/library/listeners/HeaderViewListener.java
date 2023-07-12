package cn.damai.baseview.abcpullrefresh.library.listeners;

import android.view.View;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface HeaderViewListener {
    public static final int STATE_HIDDEN = 2;
    public static final int STATE_MINIMIZED = 1;
    public static final int STATE_VISIBLE = 0;

    void onStateChanged(View view, int i);
}
