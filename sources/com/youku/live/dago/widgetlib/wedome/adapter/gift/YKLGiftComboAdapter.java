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
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftComboSendInfo;
import com.youku.live.dago.widgetlib.interactive.gift.view.RoundGiftButton;
import com.youku.live.dago.widgetlib.protocol.YKLGiftComboProtocol;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class YKLGiftComboAdapter extends FrameLayout implements YKLGiftComboProtocol {
    private static transient /* synthetic */ IpChange $ipChange;
    private int height;
    private int interval;
    private RoundGiftButton mComboGiftButton;
    private Context mContext;
    private RoundGiftButton.Listener mListener;
    private String url;
    private int width;

    public YKLGiftComboAdapter(@NonNull Context context) {
        super(context);
        this.interval = 10;
        this.width = 120;
        this.height = 120;
        init(context);
    }

    private void init(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-850908902")) {
            ipChange.ipc$dispatch("-850908902", new Object[]{this, context});
            return;
        }
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.dago_pgc_layout_gift_combo_component, this);
        RoundGiftButton roundGiftButton = (RoundGiftButton) findViewById(R.id.round_gift_bt);
        this.mComboGiftButton = roundGiftButton;
        roundGiftButton.setShowIcon(true);
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftComboProtocol
    public View getView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-107848237") ? (View) ipChange.ipc$dispatch("-107848237", new Object[]{this}) : this;
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftComboProtocol
    public void setCallback(RoundGiftButton.Listener listener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "476156491")) {
            ipChange.ipc$dispatch("476156491", new Object[]{this, listener});
            return;
        }
        this.mListener = listener;
        RoundGiftButton roundGiftButton = this.mComboGiftButton;
        if (roundGiftButton != null) {
            roundGiftButton.setListener(listener);
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftComboProtocol
    public void setComboInterval(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-757445258")) {
            ipChange.ipc$dispatch("-757445258", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (i <= 0) {
            i = 10;
        }
        RoundGiftButton roundGiftButton = this.mComboGiftButton;
        if (roundGiftButton != null) {
            roundGiftButton.setComboInterval(i);
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftComboProtocol
    public void setCountdownTime(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1869426655")) {
            ipChange.ipc$dispatch("-1869426655", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (i <= 0) {
            i = 100;
        }
        RoundGiftButton roundGiftButton = this.mComboGiftButton;
        if (roundGiftButton != null) {
            roundGiftButton.setCountDownNowNum(i);
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftComboProtocol
    public void setGiftInfo(GiftComboSendInfo giftComboSendInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1208059017")) {
            ipChange.ipc$dispatch("-1208059017", new Object[]{this, giftComboSendInfo});
            return;
        }
        String str = giftComboSendInfo.icon;
        this.url = str;
        RoundGiftButton roundGiftButton = this.mComboGiftButton;
        if (roundGiftButton != null) {
            roundGiftButton.setIconUrl(str);
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftComboProtocol
    public void setSize(float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-913697751")) {
            ipChange.ipc$dispatch("-913697751", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)});
            return;
        }
        this.width = (int) f;
        this.height = (int) f2;
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftComboProtocol
    public void start() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1550145814")) {
            ipChange.ipc$dispatch("-1550145814", new Object[]{this});
            return;
        }
        RoundGiftButton roundGiftButton = this.mComboGiftButton;
        if (roundGiftButton != null) {
            roundGiftButton.startCountDownNum();
        }
    }

    public YKLGiftComboAdapter(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.interval = 10;
        this.width = 120;
        this.height = 120;
        init(context);
    }

    public YKLGiftComboAdapter(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.interval = 10;
        this.width = 120;
        this.height = 120;
        init(context);
    }
}
