package com.alibaba.security.biometrics.logic.view.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.security.biometrics.R;
import com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView;
import com.alibaba.security.common.track.model.C3834a;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class GuideWidget extends AbsGuideWidget {
    private static final String b = "GuideWidget";
    private ImageView c;
    private TextView d;
    private LinearLayout e;
    private TextView f;
    private TextView g;
    private TextView h;
    private Button i;
    private TextView j;

    public GuideWidget(Context context) {
        super(context);
    }

    private void f(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.e.setVisibility(0);
            this.g.setText(str);
        } else {
            this.e.setVisibility(8);
        }
        setVisibility(0);
    }

    private static void g() {
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    protected final void a() {
        this.c = (ImageView) findViewById(R.id.abfl_widget_guide_icon);
        this.e = (LinearLayout) findViewById(R.id.abfl_widget_guide_subtext_parent);
        this.d = (TextView) findViewById(R.id.abfl_widget_guide_text);
        this.f = (TextView) findViewById(R.id.abfl_widget_guide_subtext_left);
        this.g = (TextView) findViewById(R.id.abfl_widget_guide_subtext_center);
        this.h = (TextView) findViewById(R.id.abfl_widget_guide_subtext_right);
        Button button = (Button) findViewById(R.id.abfl_widget_guide_btn);
        this.i = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.security.biometrics.logic.view.widget.GuideWidget.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuideWidget.this.setVisibility(8);
                ALBiometricsActivityParentView.InterfaceC3778a interfaceC3778a = GuideWidget.this.a;
                if (interfaceC3778a != null) {
                    interfaceC3778a.d();
                }
            }
        });
        this.j = (TextView) findViewById(R.id.abfl_widget_guide_copyright);
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    protected final void b() {
        C3788b.a(this.d, d("titleText"));
        C3788b.a(this.f, d("messageText"));
        C3788b.a(this.h, d("messageText"));
        C3788b.a(this.g, d("markMessageText"));
        C3788b.a(this.i, c("mainButton"));
        C3788b.a(this.j, d("privacyTipText"));
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public final void c() {
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    protected String getSkinParentKey() {
        return C3834a.C3836b.m;
    }

    public GuideWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GuideWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget, com.alibaba.security.biometrics.logic.view.widget.InterfaceC3789c
    public final void a(String... strArr) {
        String str = strArr.length > 0 ? strArr[0] : null;
        if (!TextUtils.isEmpty(str)) {
            this.e.setVisibility(0);
            this.g.setText(str);
        } else {
            this.e.setVisibility(8);
        }
        setVisibility(0);
    }
}
