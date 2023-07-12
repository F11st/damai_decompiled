package com.alibaba.yymidservice.popup.popupcenter.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.js1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class PicDialog extends Dialog {
    @Nullable
    private OnDialogShowTimeListener a;
    private long b;
    private long c;
    @Nullable
    private Activity d;
    private boolean e;
    @NotNull
    private final js1.AbstractC9321b f;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnDialogShowTimeListener {
        void exposureTime(long j);
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.yymidservice.popup.popupcenter.view.PicDialog$a */
    /* loaded from: classes8.dex */
    public static final class C4029a extends js1.AbstractC9321b {
        C4029a() {
        }

        @Override // tb.js1.AbstractC9321b
        public boolean a(@NotNull Activity activity) {
            b41.i(activity, "activity");
            return PicDialog.this.d != null && PicDialog.this.d == activity;
        }

        @Override // tb.js1.AbstractC9321b
        public void b(@NotNull Activity activity) {
            b41.i(activity, "activity");
            if (PicDialog.this.e) {
                PicDialog.this.g(System.currentTimeMillis());
                PicDialog.this.d();
            }
        }

        @Override // tb.js1.AbstractC9321b
        public void c(@NotNull Activity activity) {
            b41.i(activity, "activity");
            if (PicDialog.this.e) {
                PicDialog.this.h(System.currentTimeMillis());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PicDialog(@NotNull Context context) {
        super(context);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        C4029a c4029a = new C4029a();
        this.f = c4029a;
        if (getContext() instanceof Activity) {
            Context context2 = getContext();
            b41.g(context2, "null cannot be cast to non-null type android.app.Activity");
            this.d = (Activity) context2;
            js1.Companion.a().c(c4029a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        OnDialogShowTimeListener onDialogShowTimeListener = this.a;
        if (onDialogShowTimeListener != null) {
            onDialogShowTimeListener.exposureTime(this.c - this.b);
        }
    }

    private final void e() {
        js1.Companion.a().e(this.f);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.e = false;
        this.c = System.currentTimeMillis();
        super.dismiss();
        d();
        e();
    }

    public final void f(@Nullable OnDialogShowTimeListener onDialogShowTimeListener) {
        this.a = onDialogShowTimeListener;
    }

    public final void g(long j) {
        this.c = j;
    }

    public final void h(long j) {
        this.b = j;
    }

    @Override // android.app.Dialog
    public void hide() {
        this.e = false;
        super.hide();
        d();
    }

    @Override // android.app.Dialog
    public void show() {
        this.e = true;
        this.b = System.currentTimeMillis();
        super.show();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PicDialog(@NotNull Context context, int i) {
        super(context, i);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        C4029a c4029a = new C4029a();
        this.f = c4029a;
        if (getContext() instanceof Activity) {
            Context context2 = getContext();
            b41.g(context2, "null cannot be cast to non-null type android.app.Activity");
            this.d = (Activity) context2;
            js1.Companion.a().c(c4029a);
        }
    }
}
