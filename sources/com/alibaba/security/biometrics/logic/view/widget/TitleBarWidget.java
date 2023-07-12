package com.alibaba.security.biometrics.logic.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.security.biometrics.R;
import com.alibaba.security.biometrics.c.c.C3755b;
import com.alibaba.security.biometrics.skin.model.NavigatorSkinData;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class TitleBarWidget extends BaseWidget {
    private static final String b = "TitleBarWidget";
    private ImageView c;
    private LinearLayout d;
    private TextView e;
    private boolean f;
    private View.OnClickListener g;

    public TitleBarWidget(Context context) {
        super(context);
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    protected final void b() {
        NavigatorSkinData b2 = b("navigator");
        if (b2 != null) {
            C3788b.a(this.c, b2.getCloseImageView(), R.C3735drawable.rp_face_top_back);
        } else {
            this.c.setImageResource(R.C3735drawable.rp_face_top_back);
        }
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public final void c() {
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public final void d() {
        RelativeLayout.LayoutParams layoutParams;
        if (C3755b.a(getContext()) <= 0 || (layoutParams = (RelativeLayout.LayoutParams) getLayoutParams()) == null) {
            return;
        }
        layoutParams.setMargins(0, C3755b.a(getContext()), 0, 0);
        setLayoutParams(layoutParams);
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    protected String getSkinParentKey() {
        return "navigator";
    }

    public void setOnCloseListener(View.OnClickListener onClickListener) {
        this.g = onClickListener;
    }

    public void setTitle(String str) {
        TextView textView = this.e;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public TitleBarWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    protected final void a() {
        this.c = (ImageView) findViewById(R.id.abfl_widget_tb_close);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.abfl_widget_tb_close_parent);
        this.d = linearLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.security.biometrics.logic.view.widget.TitleBarWidget.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (TitleBarWidget.this.g != null) {
                    TitleBarWidget.this.g.onClick(view);
                }
            }
        });
        this.e = (TextView) findViewById(R.id.tvTitle);
    }

    public TitleBarWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
