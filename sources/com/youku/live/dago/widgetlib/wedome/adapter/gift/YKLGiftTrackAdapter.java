package com.youku.live.dago.widgetlib.wedome.adapter.gift;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftTrackBean;
import com.youku.live.dago.widgetlib.interactive.gift.callback.IGiftTrackCallback;
import com.youku.live.dago.widgetlib.interactive.gift.controller.GiftTrackCount;
import com.youku.live.dago.widgetlib.interactive.gift.view.GiftTrackContainerView;
import com.youku.live.dago.widgetlib.protocol.YKLGiftTrackProtocol;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class YKLGiftTrackAdapter extends FrameLayout implements YKLGiftTrackProtocol {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isLandscape;
    private IGiftTrackCallback mCallback;
    private GiftTrackContainerView mContainerView;
    private Context mContext;

    public YKLGiftTrackAdapter(@NonNull Context context) {
        super(context);
        this.isLandscape = false;
        init(context);
    }

    private void init(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1255609193")) {
            ipChange.ipc$dispatch("-1255609193", new Object[]{this, context});
            return;
        }
        setClipChildren(false);
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.C7942layout.dago_pgc_layout_gift_track_component, this);
        this.mContainerView = (GiftTrackContainerView) findViewById(R.id.track_container);
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftTrackProtocol
    public View getView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-458070064") ? (View) ipChange.ipc$dispatch("-458070064", new Object[]{this}) : this;
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftTrackProtocol
    public void insertGiftTrackInfo(GiftTrackBean giftTrackBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-440895821")) {
            ipChange.ipc$dispatch("-440895821", new Object[]{this, giftTrackBean});
            return;
        }
        GiftTrackContainerView giftTrackContainerView = this.mContainerView;
        if (giftTrackContainerView != null) {
            giftTrackContainerView.addGiftTrackData(giftTrackBean);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1576470026")) {
            ipChange.ipc$dispatch("-1576470026", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        IGiftTrackCallback iGiftTrackCallback = this.mCallback;
        if (iGiftTrackCallback != null) {
            iGiftTrackCallback.onEnd();
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftTrackProtocol
    public void resume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1664611052")) {
            ipChange.ipc$dispatch("-1664611052", new Object[]{this});
            return;
        }
        GiftTrackContainerView giftTrackContainerView = this.mContainerView;
        if (giftTrackContainerView != null) {
            giftTrackContainerView.resume();
            this.mContainerView.setVisibility(0);
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftTrackProtocol
    public void setCallback(IGiftTrackCallback iGiftTrackCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1904827609")) {
            ipChange.ipc$dispatch("1904827609", new Object[]{this, iGiftTrackCallback});
            return;
        }
        this.mCallback = iGiftTrackCallback;
        GiftTrackContainerView giftTrackContainerView = this.mContainerView;
        if (giftTrackContainerView != null) {
            giftTrackContainerView.setCallback(iGiftTrackCallback);
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftTrackProtocol
    public void setSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1047601286")) {
            ipChange.ipc$dispatch("1047601286", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftTrackProtocol
    public void setTrackCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1089390432")) {
            ipChange.ipc$dispatch("-1089390432", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        GiftTrackContainerView giftTrackContainerView = this.mContainerView;
        if (giftTrackContainerView == null || i != 1) {
            return;
        }
        giftTrackContainerView.setGiftTrackCount(GiftTrackCount.SINGLE);
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftTrackProtocol
    public void stop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1893168097")) {
            ipChange.ipc$dispatch("-1893168097", new Object[]{this});
            return;
        }
        GiftTrackContainerView giftTrackContainerView = this.mContainerView;
        if (giftTrackContainerView != null) {
            giftTrackContainerView.stop();
            this.mContainerView.setVisibility(8);
        }
    }

    public YKLGiftTrackAdapter(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isLandscape = false;
        init(context);
    }

    public YKLGiftTrackAdapter(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isLandscape = false;
        init(context);
    }
}
