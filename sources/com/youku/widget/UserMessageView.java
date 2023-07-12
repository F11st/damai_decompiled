package com.youku.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;
import com.baseproject.ui.R$id;
import com.baseproject.ui.R$layout;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class UserMessageView extends LinearLayout {
    private ViewFlipper mFlipper;
    private View mTopMargin;

    public UserMessageView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R$layout.message_view_layout, this);
        this.mFlipper = (ViewFlipper) inflate.findViewById(R$id.home_msg_flipper);
        this.mTopMargin = inflate.findViewById(R$id.user_msg_top_margin_line);
    }

    public ViewFlipper getFlipper() {
        return this.mFlipper;
    }

    public void setTopMarginVisible(boolean z) {
        if (!z) {
            this.mTopMargin.setVisibility(8);
        } else {
            this.mTopMargin.setVisibility(0);
        }
    }

    public UserMessageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public UserMessageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }
}
