package cn.damai.commonbusiness.lazyimg.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.animate.AnimatedImageDrawable;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class GifCareImageView extends ImageView {
    private static transient /* synthetic */ IpChange $ipChange;
    private int mParentScrollState;

    public GifCareImageView(Context context) {
        super(context);
        this.mParentScrollState = 0;
    }

    private void tryAnimateGifOrNot() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-419629993")) {
            ipChange.ipc$dispatch("-419629993", new Object[]{this});
            return;
        }
        try {
            Drawable drawable = getDrawable();
            if (drawable instanceof AnimatedImageDrawable) {
                AnimatedImageDrawable animatedImageDrawable = (AnimatedImageDrawable) drawable;
                boolean isPlaying = animatedImageDrawable.isPlaying();
                if (this.mParentScrollState == 0) {
                    if (!isPlaying) {
                        animatedImageDrawable.start();
                    }
                } else if (isPlaying) {
                    animatedImageDrawable.pause(false);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void processParentScrollState(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "16945349")) {
            ipChange.ipc$dispatch("16945349", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mParentScrollState = i;
        tryAnimateGifOrNot();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-974290218")) {
            ipChange.ipc$dispatch("-974290218", new Object[]{this, drawable});
            return;
        }
        super.setImageDrawable(drawable);
        tryAnimateGifOrNot();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "116737025")) {
            ipChange.ipc$dispatch("116737025", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        super.setImageResource(i);
        tryAnimateGifOrNot();
    }

    @Override // android.widget.ImageView
    public void setImageURI(@Nullable Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1708861447")) {
            ipChange.ipc$dispatch("-1708861447", new Object[]{this, uri});
            return;
        }
        super.setImageURI(uri);
        tryAnimateGifOrNot();
    }

    public GifCareImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mParentScrollState = 0;
    }

    public GifCareImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mParentScrollState = 0;
    }
}
