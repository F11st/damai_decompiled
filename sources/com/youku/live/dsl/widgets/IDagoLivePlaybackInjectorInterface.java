package com.youku.live.dsl.widgets;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IDagoLivePlaybackInjectorInterface {
    public static final int POSITION_BOTTOM_RIGHT = 3;
    public static final int POSITION_TOP_LEFT = 0;
    public static final int POSITION_TOP_MIDDLE = 1;
    public static final int POSITION_TOP_RIGHT = 2;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface IResultListener {
        void onResult(Map<String, Object> map);
    }

    void injectorChangeMoreView();

    void injectorClearDanmu();

    void injectorInsertDanmu(List<Map<String, Object>> list);

    void injectorInsertView2ControlPlugin(View view, LinearLayout.LayoutParams layoutParams, int i);

    void injectorInsertView2DanmuPlugin(View view, RelativeLayout.LayoutParams layoutParams);

    void injectorPlayerAction(String str, List<Map<String, Object>> list);

    void injectorPlayerAction(String str, Map<String, Object> map);

    void injectorSetProgressListener(IResultListener iResultListener);

    void injectorSetPtsEventListener(IResultListener iResultListener);

    void injectorSetRotateEventListener(IResultListener iResultListener);

    void injectorSetSeiEventListener(IResultListener iResultListener);

    void injectorSupplyTopLayer(FrameLayout frameLayout);

    void injectorUpdateDanmuConfig(Map<String, Object> map);

    void injectorUpdateProgram(Map<String, Object> map, IResultListener iResultListener, IResultListener iResultListener2);
}
