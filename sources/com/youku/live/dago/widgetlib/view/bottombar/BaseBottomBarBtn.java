package com.youku.live.dago.widgetlib.view.bottombar;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.util.UIUtil;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class BaseBottomBarBtn extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "BottomBarBtn";
    private int mType;
    private OnBtnClickListener onBtnClickListener;
    public static final int SIZE = UIUtil.dip2px(36);
    public static final int ICON = UIUtil.dip2px(24);
    public static final int MARGIN = UIUtil.dip2px(9);
    public static final int PADDING = UIUtil.dip2px(12);

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface OnBtnClickListener {
        void onClick(BaseBottomBarBtn baseBottomBarBtn);
    }

    public BaseBottomBarBtn(@NonNull Context context, int i, OnBtnClickListener onBtnClickListener) {
        super(context);
        this.mType = i;
        this.onBtnClickListener = onBtnClickListener;
        setBackgroundResource(R.C7941drawable.dago_pgc_bg_bottom_btn);
        setLayoutParams(getBtnLayoutParams());
        addView(getContentView());
        setOnClickListener(new CustomClickListener() { // from class: com.youku.live.dago.widgetlib.view.bottombar.BaseBottomBarBtn.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.view.bottombar.CustomClickListener
            protected void onFastClick() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1526318630")) {
                    ipChange.ipc$dispatch("1526318630", new Object[]{this});
                }
            }

            @Override // com.youku.live.dago.widgetlib.view.bottombar.CustomClickListener
            protected void onSingleClick() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1013549778")) {
                    ipChange.ipc$dispatch("1013549778", new Object[]{this});
                } else if (BaseBottomBarBtn.this.onBtnClickListener != null) {
                    BaseBottomBarBtn.this.onBtnClickListener.onClick(BaseBottomBarBtn.this);
                }
            }
        });
    }

    public abstract LinearLayout.LayoutParams getBtnLayoutParams();

    public abstract ViewGroup getContentView();

    public abstract Bitmap getIcon();

    public int getType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "858288419") ? ((Integer) ipChange.ipc$dispatch("858288419", new Object[]{this})).intValue() : this.mType;
    }
}
