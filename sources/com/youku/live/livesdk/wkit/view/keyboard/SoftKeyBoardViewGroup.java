package com.youku.live.livesdk.wkit.view.keyboard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class SoftKeyBoardViewGroup extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private SoftKeyBoardVisiablityChangedListener mListener;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface SoftKeyBoardVisiablityChangedListener {
        void onSoftKeyBoardHide(int i);

        void onSoftKeyBoardShow(int i);
    }

    public SoftKeyBoardViewGroup(Context context) {
        this(context, null);
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-398192424")) {
            ipChange.ipc$dispatch("-398192424", new Object[]{this});
        } else {
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.youku.live.livesdk.wkit.view.keyboard.SoftKeyBoardViewGroup.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-594686775")) {
                        ipChange2.ipc$dispatch("-594686775", new Object[]{this});
                        return;
                    }
                    int height = SoftKeyBoardViewGroup.this.getRootView().getHeight() - SoftKeyBoardViewGroup.this.getHeight();
                    if (height > 150) {
                        if (SoftKeyBoardViewGroup.this.mListener != null) {
                            SoftKeyBoardViewGroup.this.mListener.onSoftKeyBoardShow(height);
                        }
                    } else if (SoftKeyBoardViewGroup.this.mListener != null) {
                        SoftKeyBoardViewGroup.this.mListener.onSoftKeyBoardHide(height);
                    }
                }
            });
        }
    }

    public void setSoftKeyBoardVisiablityChangedListener(SoftKeyBoardVisiablityChangedListener softKeyBoardVisiablityChangedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1694830032")) {
            ipChange.ipc$dispatch("-1694830032", new Object[]{this, softKeyBoardVisiablityChangedListener});
        } else {
            this.mListener = softKeyBoardVisiablityChangedListener;
        }
    }

    public SoftKeyBoardViewGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public SoftKeyBoardViewGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
