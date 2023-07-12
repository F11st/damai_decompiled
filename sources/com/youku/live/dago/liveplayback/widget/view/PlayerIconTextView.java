package com.youku.live.dago.liveplayback.widget.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class PlayerIconTextView extends AppCompatTextView {
    private static transient /* synthetic */ IpChange $ipChange;
    private static Typeface iconfont;

    public PlayerIconTextView(Context context) {
        this(context, null);
        setIconFont();
    }

    private void setIconFont() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2114848683")) {
            ipChange.ipc$dispatch("2114848683", new Object[]{this});
            return;
        }
        setGravity(17);
        try {
            if (iconfont == null) {
                iconfont = Typeface.createFromAsset(getContext().getResources().getAssets(), "player_icon_font/iconfont_dago.ttf");
            }
            setTypeface(iconfont);
        } catch (Exception unused) {
        }
    }

    public PlayerIconTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
        setIconFont();
    }

    public PlayerIconTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setIconFont();
    }
}
