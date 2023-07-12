package com.youku.live.dago.widgetlib.view.bottombar;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.view.bottombar.BaseBottomBarBtn;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class BottomBarImgBtn extends BaseBottomBarBtn {
    private static transient /* synthetic */ IpChange $ipChange;

    public BottomBarImgBtn(@NonNull Context context, int i, BaseBottomBarBtn.OnBtnClickListener onBtnClickListener) {
        super(context, i, onBtnClickListener);
    }

    @Override // com.youku.live.dago.widgetlib.view.bottombar.BaseBottomBarBtn
    public LinearLayout.LayoutParams getBtnLayoutParams() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1136056685")) {
            return (LinearLayout.LayoutParams) ipChange.ipc$dispatch("-1136056685", new Object[]{this});
        }
        return null;
    }

    @Override // com.youku.live.dago.widgetlib.view.bottombar.BaseBottomBarBtn
    public ViewGroup getContentView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1700396559")) {
            return (ViewGroup) ipChange.ipc$dispatch("1700396559", new Object[]{this});
        }
        return null;
    }

    @Override // com.youku.live.dago.widgetlib.view.bottombar.BaseBottomBarBtn
    public Bitmap getIcon() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2058653237")) {
            return (Bitmap) ipChange.ipc$dispatch("-2058653237", new Object[]{this});
        }
        return null;
    }
}
