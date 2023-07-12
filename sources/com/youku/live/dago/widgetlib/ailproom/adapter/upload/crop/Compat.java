package com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop;

import android.os.Build;
import android.view.View;
import androidx.core.view.MotionEventCompat;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class Compat {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int SIXTY_FPS_INTERVAL = 16;

    public static int getPointerIndex(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "300013030") ? ((Integer) ipChange.ipc$dispatch("300013030", new Object[]{Integer.valueOf(i)})).intValue() : getPointerIndexHoneyComb(i);
    }

    private static int getPointerIndexHoneyComb(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-765935944") ? ((Integer) ipChange.ipc$dispatch("-765935944", new Object[]{Integer.valueOf(i)})).intValue() : (i & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
    }

    public static void postOnAnimation(View view, Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "409087322")) {
            ipChange.ipc$dispatch("409087322", new Object[]{view, runnable});
        } else if (Build.VERSION.SDK_INT >= 16) {
            postOnAnimationJellyBean(view, runnable);
        } else {
            view.postDelayed(runnable, 16L);
        }
    }

    private static void postOnAnimationJellyBean(View view, Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1802664182")) {
            ipChange.ipc$dispatch("-1802664182", new Object[]{view, runnable});
        } else {
            view.postOnAnimation(runnable);
        }
    }
}
