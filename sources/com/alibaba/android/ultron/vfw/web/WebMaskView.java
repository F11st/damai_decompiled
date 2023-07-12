package com.alibaba.android.ultron.vfw.web;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.android.ultron.vfw.R$id;
import com.alibaba.android.ultron.vfw.R$layout;
import com.taobao.vessel.VesselView;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class WebMaskView extends RelativeLayout {
    public static final String TAG = "WebMaskView";
    private RelativeLayout mRlErrView;
    private RelativeLayout mRlLoading;
    private TextView mTextViewRefresh;
    private VesselView mVesselView;
    private String mWebUrl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (WebMaskView.this.mVesselView != null) {
                WebMaskView.this.mVesselView.loadUrl(WebMaskView.this.mWebUrl);
            }
        }
    }

    public WebMaskView(VesselView vesselView, String str) {
        super(vesselView.getContext());
        init();
        this.mWebUrl = str;
        this.mVesselView = vesselView;
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        setTag(TAG);
        this.mVesselView.addView(this);
    }

    private void init() {
        loadView();
    }

    private void loadView() {
        View inflate = View.inflate(getContext(), R$layout.ultron_mask_view_state, this);
        if (inflate != null) {
            this.mRlLoading = (RelativeLayout) inflate.findViewById(R$id.rl_loading);
            this.mRlErrView = (RelativeLayout) inflate.findViewById(R$id.rl_err);
            TextView textView = (TextView) inflate.findViewById(R$id.mask_view_refresh);
            this.mTextViewRefresh = textView;
            textView.setOnClickListener(new a());
        }
    }

    public void finish() {
        setProgressBarVisible(true);
        setErrorTextVisible(false);
        setVisibility(8);
    }

    public VesselView getVesselView() {
        return this.mVesselView;
    }

    public boolean isRetry() {
        return this.mRlErrView.getVisibility() == 0;
    }

    public void setErrorTextVisible(boolean z) {
        if (getVisibility() == 8) {
            setVisibility(0);
        }
        if (z) {
            setProgressBarVisible(false);
            this.mRlErrView.setVisibility(0);
            return;
        }
        this.mRlErrView.setVisibility(8);
    }

    public void setProgressBarVisible(boolean z) {
        if (z) {
            this.mRlLoading.setVisibility(0);
        } else {
            this.mRlLoading.setVisibility(8);
        }
    }

    public void startLoading() {
        if (getVisibility() == 8) {
            setVisibility(0);
        }
        RelativeLayout relativeLayout = this.mRlLoading;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        setErrorTextVisible(false);
    }
}
