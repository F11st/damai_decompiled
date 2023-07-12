package com.youku.live.dago.liveplayback.widget.plugins.toptip;

import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.liveplayback.widget.plugins.tipsview.TipsConfig;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class TopTipInfo {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "TopTipInfo";
    public boolean anim;
    public String backImgUrl;
    public DismissCallback dismissCallback;
    public String featureId;
    public int frequency;
    public TipsConfig.FrequencyType frequencyType;
    public boolean isNextSticky;
    public boolean isSticky;
    public long lastCancelTime;
    public long lastShowTime;
    public int leftVipIconRes;
    public String leftVipIconUrl;
    public int level;
    public boolean needFullScreen;
    public View.OnClickListener onClickListener;
    public String playIdUsingFrequency;
    public boolean quickDismiss;
    public int rightIconRes;
    public int showCount;
    public int style;
    public CharSequence text;
    public int textSize;
    public int time;
    public String tipName;
    public int tipSeq;
    public int tipType;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface DismissCallback {
        void onDismiss();
    }

    public TopTipInfo() {
        this.tipType = 1000;
        this.rightIconRes = -1;
        this.time = 0;
        this.isSticky = false;
        this.isNextSticky = false;
        this.anim = true;
        this.needFullScreen = false;
        this.level = -1;
        this.lastShowTime = -1L;
        this.lastCancelTime = -1L;
        this.showCount = 0;
        this.quickDismiss = false;
        this.tipSeq = -1;
        this.leftVipIconUrl = null;
        this.leftVipIconRes = -1;
        this.backImgUrl = null;
        this.textSize = -1;
        this.dismissCallback = null;
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1142116449")) {
            return (String) ipChange.ipc$dispatch("-1142116449", new Object[]{this});
        }
        return "TopTipInfo() called with: tipName = [" + this.tipName + "], style = [" + this.style + "], time = [" + this.time + "], text = [" + ((Object) this.text) + "], rightIconRes = [" + this.rightIconRes + jn1.ARRAY_END_STR + ", level = [" + this.level + jn1.ARRAY_END_STR + "， isSticky = [" + this.isSticky + "], isNextSticky = [" + this.isNextSticky + "], lastShowTime = [" + this.lastShowTime + jn1.ARRAY_END_STR + ", lastCancelTime = [" + this.lastCancelTime + "], showCount = [" + this.showCount + "], quickDismiss = [" + this.quickDismiss + "], tipSeq=[" + this.tipSeq + "], leftIconUrl = [" + this.leftVipIconUrl + jn1.ARRAY_END_STR;
    }

    public TopTipInfo(String str, int i, CharSequence charSequence) {
        this.tipType = 1000;
        this.rightIconRes = -1;
        this.time = 0;
        this.isSticky = false;
        this.isNextSticky = false;
        this.anim = true;
        this.needFullScreen = false;
        this.level = -1;
        this.lastShowTime = -1L;
        this.lastCancelTime = -1L;
        this.showCount = 0;
        this.quickDismiss = false;
        this.tipSeq = -1;
        this.leftVipIconUrl = null;
        this.leftVipIconRes = -1;
        this.backImgUrl = null;
        this.textSize = -1;
        this.dismissCallback = null;
        this.tipName = str;
        this.style = i;
        this.text = charSequence;
    }

    public TopTipInfo(String str, int i, int i2, CharSequence charSequence) {
        this.tipType = 1000;
        this.rightIconRes = -1;
        this.time = 0;
        this.isSticky = false;
        this.isNextSticky = false;
        this.anim = true;
        this.needFullScreen = false;
        this.level = -1;
        this.lastShowTime = -1L;
        this.lastCancelTime = -1L;
        this.showCount = 0;
        this.quickDismiss = false;
        this.tipSeq = -1;
        this.leftVipIconUrl = null;
        this.leftVipIconRes = -1;
        this.backImgUrl = null;
        this.textSize = -1;
        this.dismissCallback = null;
        this.tipName = str;
        this.style = i;
        this.time = i2;
        this.text = charSequence;
    }

    public TopTipInfo(String str, int i, CharSequence charSequence, View.OnClickListener onClickListener) {
        this.tipType = 1000;
        this.rightIconRes = -1;
        this.time = 0;
        this.isSticky = false;
        this.isNextSticky = false;
        this.anim = true;
        this.needFullScreen = false;
        this.level = -1;
        this.lastShowTime = -1L;
        this.lastCancelTime = -1L;
        this.showCount = 0;
        this.quickDismiss = false;
        this.tipSeq = -1;
        this.leftVipIconUrl = null;
        this.leftVipIconRes = -1;
        this.backImgUrl = null;
        this.textSize = -1;
        this.dismissCallback = null;
        this.tipName = str;
        this.style = i;
        this.text = this.text;
        this.onClickListener = onClickListener;
    }
}
