package com.tencent.open.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class a extends RelativeLayout {
    private static final String a = a.class.getName();
    private Rect b;
    private boolean c;
    private InterfaceC0345a d;

    /* compiled from: Taobao */
    /* renamed from: com.tencent.open.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0345a {
        void a();

        void a(int i);
    }

    public a(Context context) {
        super(context);
        this.b = null;
        this.c = false;
        this.d = null;
        this.b = new Rect();
    }

    public void a(InterfaceC0345a interfaceC0345a) {
        this.d = interfaceC0345a;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.b);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.b.top) - size;
        InterfaceC0345a interfaceC0345a = this.d;
        if (interfaceC0345a != null && size != 0) {
            if (height > 100) {
                interfaceC0345a.a((Math.abs(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.b)) - getPaddingBottom()) - getPaddingTop());
            } else {
                interfaceC0345a.a();
            }
        }
        super.onMeasure(i, i2);
    }
}
