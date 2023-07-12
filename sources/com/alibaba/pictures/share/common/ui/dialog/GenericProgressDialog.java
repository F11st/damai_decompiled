package com.alibaba.pictures.share.common.ui.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.alibaba.pictures.share.R$id;
import com.alibaba.pictures.share.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/alibaba/pictures/share/common/ui/dialog/GenericProgressDialog;", "Landroidx/appcompat/app/AlertDialog;", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "", "theme", "<init>", "(Landroid/content/Context;I)V", "share_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes8.dex */
public final class GenericProgressDialog extends AlertDialog {
    private static transient /* synthetic */ IpChange $ipChange;
    private ProgressBar a;
    private TextView b;
    private CharSequence c;
    private boolean d;
    private boolean e;
    private int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenericProgressDialog(@NotNull Context context, int i) {
        super(context, i);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    private final void b() {
        TextView textView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1574415823")) {
            ipChange.ipc$dispatch("-1574415823", new Object[]{this});
            return;
        }
        TextView textView2 = this.b;
        if (textView2 != null) {
            textView2.setText(this.c);
        }
        if (TextUtils.isEmpty(this.c) && (textView = this.b) != null) {
            textView.setVisibility(8);
        }
        ProgressBar progressBar = this.a;
        if (progressBar != null) {
            progressBar.setVisibility(this.e ? 0 : 8);
        }
    }

    public final void a(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1647599403")) {
            ipChange.ipc$dispatch("1647599403", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        ProgressBar progressBar = this.a;
        if (progressBar != null) {
            progressBar.setIndeterminate(z);
            return;
        }
        this.d = z;
        wt2 wt2Var = wt2.INSTANCE;
    }

    public final void c(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1412573406")) {
            ipChange.ipc$dispatch("1412573406", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.e = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AlertDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(@Nullable Bundle bundle) {
        TextView textView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "562714413")) {
            ipChange.ipc$dispatch("562714413", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setContentView(R$layout.generic_progress_dialog);
        this.a = (ProgressBar) findViewById(R$id.progress);
        this.b = (TextView) findViewById(R$id.message);
        b();
        a(this.d);
        int i = this.f;
        if (i == 0 || (textView = this.b) == null) {
            return;
        }
        textView.setTextColor(i);
    }

    @Override // androidx.appcompat.app.AlertDialog
    public void setMessage(@NotNull CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1731714335")) {
            ipChange.ipc$dispatch("-1731714335", new Object[]{this, charSequence});
            return;
        }
        b41.i(charSequence, "message");
        this.c = charSequence;
    }
}
