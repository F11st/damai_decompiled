package com.youku.tinywindow.pip;

import android.content.Context;
import android.util.Rational;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.youku.tinywindow.R;

/* compiled from: Taobao */
@RequiresApi(api = 26)
/* loaded from: classes3.dex */
public class PIPRootView extends FrameLayout {
    private FrameLayout mFrameLayout;
    private TextView mPIPErrorView;
    private Rational mRational;
    private int mReferenceCount;

    public PIPRootView(@NonNull Context context) {
        super(context);
        this.mRational = new Rational(100, 100);
        LayoutInflater.from(context).inflate(R.layout.tinywindow_pip_root_layout, this);
        TextView textView = (TextView) findViewById(R.id.tv_pip);
        this.mPIPErrorView = textView;
        textView.setContentDescription("显示PIP信息的布局");
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.content);
        this.mFrameLayout = frameLayout;
        frameLayout.setContentDescription("用来放播放器的布局");
    }

    public void addPlayerView(View view) {
        this.mFrameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
    }

    public void addReferenceCount() {
        this.mReferenceCount++;
    }

    public void clear() {
        this.mFrameLayout.removeAllViews();
        this.mPIPErrorView.setVisibility(8);
    }

    public void clearParentView() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
    }

    public Rational getRational() {
        return this.mRational;
    }

    public int getReferenceCount() {
        return this.mReferenceCount;
    }

    public void hideText() {
        post(new Runnable() { // from class: com.youku.tinywindow.pip.PIPRootView.2
            @Override // java.lang.Runnable
            public void run() {
                PIPRootView.this.mPIPErrorView.setVisibility(8);
            }
        });
    }

    public void removeReferenceCount() {
        this.mReferenceCount--;
    }

    public void setRational(Rational rational) {
        this.mRational = rational;
    }

    public void showText(final String str) {
        post(new Runnable() { // from class: com.youku.tinywindow.pip.PIPRootView.1
            @Override // java.lang.Runnable
            public void run() {
                PIPRootView.this.mPIPErrorView.setText(str);
                PIPRootView.this.mPIPErrorView.setVisibility(0);
            }
        });
    }
}
