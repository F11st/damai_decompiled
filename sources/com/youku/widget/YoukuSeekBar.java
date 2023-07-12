package com.youku.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.baseproject.ui.R$drawable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class YoukuSeekBar extends SeekBar {
    private static final int MAX = 200;
    private AutoSeek mAutoSeek;
    private int seekPositon;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public class AutoSeek implements Runnable {
        private boolean alive;

        private AutoSeek() {
            this.alive = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            YoukuSeekBar youkuSeekBar = YoukuSeekBar.this;
            youkuSeekBar.setProgress(youkuSeekBar.seekPositon);
            if (YoukuSeekBar.this.seekPositon >= 200) {
                YoukuSeekBar.this.seekPositon = 0;
            } else {
                YoukuSeekBar.access$108(YoukuSeekBar.this);
            }
            if (this.alive) {
                YoukuSeekBar.this.postDelayed(this, 50L);
            }
        }

        public void stop() {
            this.alive = false;
        }
    }

    public YoukuSeekBar(Context context) {
        super(context);
    }

    static /* synthetic */ int access$108(YoukuSeekBar youkuSeekBar) {
        int i = youkuSeekBar.seekPositon;
        youkuSeekBar.seekPositon = i + 1;
        return i;
    }

    public void clear() {
        dismiss();
        if (this.mAutoSeek != null) {
            this.mAutoSeek = null;
        }
    }

    public void dismiss() {
        setVisibility(8);
        AutoSeek autoSeek = this.mAutoSeek;
        if (autoSeek != null) {
            autoSeek.stop();
            removeCallbacks(this.mAutoSeek);
            this.mAutoSeek = null;
        }
    }

    public boolean isVisible() {
        return 8 != getVisibility();
    }

    public void show() {
        if (this.mAutoSeek == null) {
            AutoSeek autoSeek = new AutoSeek();
            this.mAutoSeek = autoSeek;
            post(autoSeek);
        }
        setVisibility(0);
    }

    public YoukuSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setThumb(context.getResources().getDrawable(R$drawable.progressthumbstyle));
        setProgressDrawable(context.getResources().getDrawable(R$drawable.progressbarstyle));
        setMax(200);
        setThumbOffset(-10);
        show();
    }
}
