package com.youku.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.baseproject.ui.R$drawable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class Loading extends ImageView {
    private AnimationDrawable frameAnim;

    public Loading(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        if (isShown()) {
            startAnimation();
        } else {
            stopAnimation();
        }
    }

    public void startAnimation() {
        post(new Runnable() { // from class: com.youku.widget.Loading.1
            @Override // java.lang.Runnable
            public void run() {
                if (Loading.this.frameAnim == null || Loading.this.frameAnim.isRunning()) {
                    return;
                }
                Loading.this.frameAnim.start();
            }
        });
    }

    public void stopAnimation() {
        post(new Runnable() { // from class: com.youku.widget.Loading.2
            @Override // java.lang.Runnable
            public void run() {
                if (Loading.this.frameAnim == null || !Loading.this.frameAnim.isRunning()) {
                    return;
                }
                Loading.this.frameAnim.stop();
            }
        });
    }

    public Loading(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackgroundResource(R$drawable.youku_loading_anim);
        this.frameAnim = (AnimationDrawable) getBackground();
        startAnimation();
    }

    public Loading(Context context) {
        super(context);
    }
}
