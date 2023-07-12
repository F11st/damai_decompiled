package com.youku.widget;

import android.app.Activity;
import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baseproject.ui.R$anim;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class YoukuAnimation {
    public static void activityClose(Context context) {
        ((Activity) context).overridePendingTransition(R$anim.activity_close_enter, R$anim.activity_close_exit);
    }

    public static void activityOpen(Context context) {
        ((Activity) context).overridePendingTransition(R$anim.activity_open_enter, R$anim.activity_open_exit);
    }

    public static Animation obtain(Context context, int i) {
        if (context == null) {
            return null;
        }
        return AnimationUtils.loadAnimation(context, i);
    }
}
