package com.tencent.open.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;

/* compiled from: Taobao */
/* renamed from: com.tencent.open.c.a */
/* loaded from: classes11.dex */
public class C7089a extends RelativeLayout {
    private static final String a = C7089a.class.getName();
    private Rect b;
    private boolean c;
    private InterfaceC7090a d;

    /* compiled from: Taobao */
    /* renamed from: com.tencent.open.c.a$a */
    /* loaded from: classes11.dex */
    public interface InterfaceC7090a {
        void a();

        void a(int i);
    }

    public C7089a(Context context) {
        super(context);
        this.b = null;
        this.c = false;
        this.d = null;
        this.b = new Rect();
    }

    public void a(InterfaceC7090a interfaceC7090a) {
        this.d = interfaceC7090a;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.b);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.b.top) - size;
        InterfaceC7090a interfaceC7090a = this.d;
        if (interfaceC7090a != null && size != 0) {
            if (height > 100) {
                interfaceC7090a.a((Math.abs(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.b)) - getPaddingBottom()) - getPaddingTop());
            } else {
                interfaceC7090a.a();
            }
        }
        super.onMeasure(i, i2);
    }
}
