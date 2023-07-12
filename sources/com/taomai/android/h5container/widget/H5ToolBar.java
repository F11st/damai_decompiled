package com.taomai.android.h5container.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.Toolbar;
import androidx.annotation.Nullable;
import com.taomai.android.h5container.R$id;
import com.taomai.android.h5container.R$layout;
import tb.ea0;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class H5ToolBar extends Toolbar {
    public static final int IMMERSION = 1;
    public static final int IMMERSION_OVERLAY = 2;
    public static final int NORMAL = 0;
    private boolean preventTouch;
    protected TitleBar titleBar;

    public H5ToolBar(Context context) {
        this(context, null, 0);
    }

    public TitleBar getTitleBar() {
        return this.titleBar;
    }

    protected void initToolbar(Context context) {
        LayoutInflater.from(context).inflate(R$layout.h5_toolbar, (ViewGroup) this, true);
        this.titleBar = (TitleBar) findViewById(R$id.titlebar);
        setBackgroundColor(-1);
    }

    public boolean isPreventTouch() {
        return this.preventTouch;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override // android.widget.Toolbar, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.preventTouch;
    }

    public void setPreventTouch(boolean z) {
        this.preventTouch = z;
        TitleBar titleBar = this.titleBar;
        if (titleBar != null) {
            titleBar.setPreventTouch(z);
        }
    }

    public void setType(int i) {
        if (i == 1 || i == 2) {
            setPadding(0, ea0.g(), 0, 0);
        }
        TitleBar titleBar = this.titleBar;
        if (titleBar != null) {
            titleBar.setType(i);
        }
    }

    public H5ToolBar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public H5ToolBar(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.preventTouch = true;
        setContentInsetsRelative(0, 0);
        initToolbar(context);
    }
}
