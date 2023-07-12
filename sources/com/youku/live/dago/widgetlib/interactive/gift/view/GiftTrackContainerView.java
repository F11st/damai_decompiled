package com.youku.live.dago.widgetlib.interactive.gift.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftTrackBean;
import com.youku.live.dago.widgetlib.interactive.gift.callback.IGiftTrackCallback;
import com.youku.live.dago.widgetlib.interactive.gift.controller.GiftTrackCount;
import com.youku.live.dago.widgetlib.interactive.gift.controller.GiftTrackViewController;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class GiftTrackContainerView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private IGiftTrackCallback mCallback;
    private GiftTrackViewController mGiftTrackController;
    private boolean mIsLandscape;

    public GiftTrackContainerView(Context context, boolean z) {
        super(context);
        this.mIsLandscape = false;
        this.mIsLandscape = z;
        initView(context);
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1407357252")) {
            ipChange.ipc$dispatch("-1407357252", new Object[]{this, context});
            return;
        }
        LayoutInflater.from(context).inflate(R.layout.dago_pgc_ykl_gift_track_container, (ViewGroup) this, true);
        this.mGiftTrackController = new GiftTrackViewController(context, this, (LinearLayout) findViewById(R.id.top_show_gift_layout), (LinearLayout) findViewById(R.id.bottom_show_gift_layout), 0);
    }

    public void addGiftTrackData(GiftTrackBean giftTrackBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "637864527")) {
            ipChange.ipc$dispatch("637864527", new Object[]{this, giftTrackBean});
            return;
        }
        GiftTrackViewController giftTrackViewController = this.mGiftTrackController;
        if (giftTrackViewController == null || giftTrackBean == null) {
            return;
        }
        giftTrackViewController.addNewGiftMessage(giftTrackBean);
    }

    public void close() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "38094577")) {
            ipChange.ipc$dispatch("38094577", new Object[]{this});
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1872598861")) {
            ipChange.ipc$dispatch("-1872598861", new Object[]{this});
            return;
        }
        super.onAttachedToWindow();
        if (getParent() == null || !(getParent() instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) getParent()).setClipChildren(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-885760234")) {
            ipChange.ipc$dispatch("-885760234", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        GiftTrackViewController giftTrackViewController = this.mGiftTrackController;
        if (giftTrackViewController != null) {
            giftTrackViewController.release();
        }
    }

    public void resume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-154342860")) {
            ipChange.ipc$dispatch("-154342860", new Object[]{this});
            return;
        }
        GiftTrackViewController giftTrackViewController = this.mGiftTrackController;
        if (giftTrackViewController != null) {
            giftTrackViewController.onResumeScreen();
        }
    }

    public void setCallback(IGiftTrackCallback iGiftTrackCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-19962951")) {
            ipChange.ipc$dispatch("-19962951", new Object[]{this, iGiftTrackCallback});
            return;
        }
        this.mCallback = iGiftTrackCallback;
        this.mGiftTrackController.setGiftTackCallback(iGiftTrackCallback);
    }

    public void setGiftTrackCount(GiftTrackCount giftTrackCount) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2100318428")) {
            ipChange.ipc$dispatch("-2100318428", new Object[]{this, giftTrackCount});
            return;
        }
        GiftTrackViewController giftTrackViewController = this.mGiftTrackController;
        if (giftTrackViewController != null) {
            giftTrackViewController.setTrackCount(giftTrackCount);
        }
    }

    public void stop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-117296833")) {
            ipChange.ipc$dispatch("-117296833", new Object[]{this});
            return;
        }
        GiftTrackViewController giftTrackViewController = this.mGiftTrackController;
        if (giftTrackViewController != null) {
            giftTrackViewController.onClearScreen();
        }
    }

    public GiftTrackContainerView(Context context) {
        super(context);
        this.mIsLandscape = false;
        initView(context);
    }

    public GiftTrackContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsLandscape = false;
        initView(context);
    }

    public GiftTrackContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsLandscape = false;
        initView(context);
    }
}
