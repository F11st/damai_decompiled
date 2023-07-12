package com.alibaba.pictures.share.common.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.alibaba.pictures.share.R$color;
import com.alibaba.pictures.share.R$id;
import com.alibaba.pictures.share.R$layout;
import com.alibaba.pictures.share.R$style;
import com.alibaba.pictures.share.ShareManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/alibaba/pictures/share/common/ui/dialog/ReportDialog;", "Landroid/app/Dialog;", "Landroid/view/View$OnClickListener;", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "", "targetId", "", "targetType", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Integer;)V", "share_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes8.dex */
public final class ReportDialog extends Dialog implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private final String a;
    private final Integer b;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.share.common.ui.dialog.ReportDialog$a */
    /* loaded from: classes8.dex */
    public static final class DialogInterface$OnClickListenerC3642a implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int b;
        final /* synthetic */ String c;

        /* compiled from: Taobao */
        /* renamed from: com.alibaba.pictures.share.common.ui.dialog.ReportDialog$a$a */
        /* loaded from: classes8.dex */
        public static final class C3643a implements ShareManager.IReport.IReportListener {
            private static transient /* synthetic */ IpChange $ipChange;

            C3643a() {
            }

            @Override // com.alibaba.pictures.share.ShareManager.IReport.IReportListener
            public void onFailed() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-330120289")) {
                    ipChange.ipc$dispatch("-330120289", new Object[]{this});
                }
            }

            @Override // com.alibaba.pictures.share.ShareManager.IReport.IReportListener
            public void onSuccess() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1353672683")) {
                    ipChange.ipc$dispatch("1353672683", new Object[]{this});
                }
            }
        }

        DialogInterface$OnClickListenerC3642a(int i, String str) {
            this.b = i;
            this.c = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(@Nullable DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-555685552")) {
                ipChange.ipc$dispatch("-555685552", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            ShareManager.IReport q = ShareManager.INSTANCE.b().q();
            if (q != null) {
                q.report(this.b, this.c, ReportDialog.this.a, ReportDialog.this.b, new C3643a());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReportDialog(@NotNull Context context, @Nullable String str, @Nullable Integer num) {
        super(context);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.a = str;
        this.b = num;
    }

    private final void c(WindowManager.LayoutParams layoutParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-278989639")) {
            ipChange.ipc$dispatch("-278989639", new Object[]{this, layoutParams});
            return;
        }
        layoutParams.gravity = 80;
        layoutParams.width = -1;
        layoutParams.height = -2;
    }

    private final void d(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2059914840")) {
            ipChange.ipc$dispatch("-2059914840", new Object[]{this, Integer.valueOf(i), str});
        } else {
            new AlertDialog.Builder(getContext()).setMessage("确认举报该内容吗？").setNegativeButton("取消", (DialogInterface.OnClickListener) null).setPositiveButton("确定", new DialogInterface$OnClickListenerC3642a(i, str)).show();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View view) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "889888617")) {
            ipChange.ipc$dispatch("889888617", new Object[]{this, view});
            return;
        }
        b41.i(view, "v");
        String obj = view instanceof TextView ? ((TextView) view).getText().toString() : null;
        if ((obj == null || obj.length() == 0) ? true : true) {
            return;
        }
        if (view.getId() == R$id.item1) {
            d(1, obj);
        } else if (view.getId() == R$id.item2) {
            d(2, obj);
        } else if (view.getId() == R$id.item3) {
            d(3, obj);
        } else if (view.getId() == R$id.item4) {
            d(4, obj);
        }
        dismiss();
    }

    @Override // android.app.Dialog
    protected void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1555465449")) {
            ipChange.ipc$dispatch("-1555465449", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.comment_report_dialog_view, (ViewGroup) null);
        b41.h(inflate, "LayoutInflater.from(cont…report_dialog_view, null)");
        setContentView(inflate);
        inflate.findViewById(R$id.item1).setOnClickListener(this);
        inflate.findViewById(R$id.item2).setOnClickListener(this);
        inflate.findViewById(R$id.item3).setOnClickListener(this);
        inflate.findViewById(R$id.item4).setOnClickListener(this);
        inflate.findViewById(R$id.cancel).setOnClickListener(this);
    }

    @Override // android.app.Dialog
    protected void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1933146705")) {
            ipChange.ipc$dispatch("-1933146705", new Object[]{this});
            return;
        }
        super.onStart();
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R$color.transparent);
            window.setDimAmount(0.5f);
            window.setWindowAnimations(R$style.slide_in_out_bottom_anim);
            WindowManager.LayoutParams attributes = window.getAttributes();
            b41.h(attributes, "params");
            c(attributes);
            window.setAttributes(attributes);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1791769511")) {
            ipChange.ipc$dispatch("1791769511", new Object[]{this, Boolean.valueOf(z)});
        } else {
            super.onWindowFocusChanged(z);
        }
    }
}
