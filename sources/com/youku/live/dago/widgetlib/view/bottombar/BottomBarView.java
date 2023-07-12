package com.youku.live.dago.widgetlib.view.bottombar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.view.bottombar.BaseBottomBarBtn;
import com.youku.live.livesdk.model.mtop.data.LiveFullInfoData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class BottomBarView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TAG = "BottomBarView";
    private BottomBarChatBtn mChatBtn;
    private List<BaseBottomBarBtn> mChilds;

    public BottomBarView(@NonNull Context context) {
        this(context, null);
    }

    private void updateChildView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "190540184")) {
            ipChange.ipc$dispatch("190540184", new Object[]{this});
            return;
        }
        Collections.sort(this.mChilds, new Comparator<BaseBottomBarBtn>() { // from class: com.youku.live.dago.widgetlib.view.bottombar.BottomBarView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.util.Comparator
            public int compare(BaseBottomBarBtn baseBottomBarBtn, BaseBottomBarBtn baseBottomBarBtn2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "719722865")) {
                    return ((Integer) ipChange2.ipc$dispatch("719722865", new Object[]{this, baseBottomBarBtn, baseBottomBarBtn2})).intValue();
                }
                if (baseBottomBarBtn.getType() > baseBottomBarBtn2.getType()) {
                    return 1;
                }
                return baseBottomBarBtn.getType() == baseBottomBarBtn2.getType() ? 0 : -1;
            }
        });
        removeAllViews();
        for (BaseBottomBarBtn baseBottomBarBtn : this.mChilds) {
            addView(baseBottomBarBtn);
        }
    }

    public void initChilds(BaseBottomBarBtn.OnBtnClickListener onBtnClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-112198388")) {
            ipChange.ipc$dispatch("-112198388", new Object[]{this, onBtnClickListener});
            return;
        }
        this.mChilds.clear();
        BottomBarChatBtn bottomBarChatBtn = new BottomBarChatBtn(getContext(), onBtnClickListener);
        this.mChatBtn = bottomBarChatBtn;
        bottomBarChatBtn.setId(R.id.dago_bottombar_edittext);
        this.mChilds.add(this.mChatBtn);
        updateChildView();
    }

    public void reset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1921713727")) {
            ipChange.ipc$dispatch("-1921713727", new Object[]{this});
        }
    }

    public void setChatPosition(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1995096851")) {
            ipChange.ipc$dispatch("-1995096851", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        BottomBarChatBtn bottomBarChatBtn = this.mChatBtn;
        if (bottomBarChatBtn != null) {
            bottomBarChatBtn.setChatPosition(i, i2, i3, i4);
        }
    }

    public void setChatWidth(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1215732277")) {
            ipChange.ipc$dispatch("1215732277", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        BottomBarChatBtn bottomBarChatBtn = this.mChatBtn;
        if (bottomBarChatBtn != null) {
            bottomBarChatBtn.setChatWidth(i);
        }
    }

    public void setOpenChat(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1757071639")) {
            ipChange.ipc$dispatch("1757071639", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        BottomBarChatBtn bottomBarChatBtn = this.mChatBtn;
        if (bottomBarChatBtn != null) {
            bottomBarChatBtn.setOpenChat(i);
        }
    }

    public void setParams(LiveFullInfoData liveFullInfoData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-901998670")) {
            ipChange.ipc$dispatch("-901998670", new Object[]{this, liveFullInfoData});
            return;
        }
        String str = liveFullInfoData.liveId + "";
        String str2 = liveFullInfoData.screenId + "";
        String str3 = liveFullInfoData.anchorYtid + "";
        BottomBarChatBtn bottomBarChatBtn = this.mChatBtn;
        if (bottomBarChatBtn != null) {
            bottomBarChatBtn.setParams(str, str2, str3);
        }
    }

    public BottomBarView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomBarView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mChilds = new ArrayList();
        setOrientation(0);
    }
}
