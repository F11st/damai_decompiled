package com.alibaba.security.biometrics.logic.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.alibaba.security.biometrics.R;
import com.alibaba.security.common.track.model.C3834a;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class PrivacyWidget extends BaseWidget {
    private Button b;
    private ImageView c;

    public PrivacyWidget(Context context) {
        super(context);
    }

    private static void g() {
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    protected final void a() {
        this.b = (Button) findViewById(R.id.btnAgree);
        this.c = (ImageView) findViewById(R.id.ivLogoView);
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.security.biometrics.logic.view.widget.PrivacyWidget.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PrivacyWidget privacyWidget = PrivacyWidget.this;
                if (privacyWidget.a != null) {
                    privacyWidget.setVisibility(8);
                    PrivacyWidget.this.a.e();
                }
            }
        });
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    protected final void b() {
        C3788b.a(this.b, c("mainButton"));
        C3788b.a(this.c, a("logoImageView"), R.C3735drawable.rp_face_privacy_logo);
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public final void c() {
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    protected String getSkinParentKey() {
        return C3834a.C3836b.n;
    }

    public PrivacyWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PrivacyWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
