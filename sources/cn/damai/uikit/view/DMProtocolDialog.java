package cn.damai.uikit.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import cn.damai.commonbusiness.discover.bean.GridBean;
import cn.damai.uikit.R$drawable;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import cn.damai.uikit.R$style;
import cn.damai.uikit.view.DMProtocolDialog;
import com.alipay.sdk.m.u.C4318n;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.ya0;
import tb.yr2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class DMProtocolDialog extends Dialog {
    private static transient /* synthetic */ IpChange $ipChange;
    private ImageView a;
    private LinearLayout b;
    private DMProtocolDialogTextItemView c;
    private DMProtocolDialogTextItemView d;
    private DMProtocolDialogTextItemView e;
    private DMProtocolDialogTextItemView f;
    private FrameLayout g;
    private FrameLayout h;
    private OnClickListener i;
    private OnDialogShowTimeListener j;
    public long k;
    public long l;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public enum DMDialogTheme {
        THEME_DNA
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnClickListener {
        void onClickNegative();

        void onClickPositive(DialogInterface dialogInterface, boolean z);

        void onProtocolClick(String str);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnDialogShowTimeListener {
        void exposureTime(long j);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.view.DMProtocolDialog$a */
    /* loaded from: classes8.dex */
    public class ViewTreeObserver$OnGlobalLayoutListenerC2572a implements ViewTreeObserver.OnGlobalLayoutListener {
        private static transient /* synthetic */ IpChange $ipChange;

        ViewTreeObserver$OnGlobalLayoutListenerC2572a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1902932289")) {
                ipChange.ipc$dispatch("1902932289", new Object[]{this});
            } else if (DMProtocolDialog.this.c.getDataLine() == 2) {
                DMProtocolDialog.this.f.setVisibility(8);
            } else if (DMProtocolDialog.this.d.getDataLine() == 2 || DMProtocolDialog.this.e.getDataLine() == 2 || DMProtocolDialog.this.f.getDataLine() == 2) {
                DMProtocolDialog.this.c.setVisibility(8);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.view.DMProtocolDialog$b */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC2573b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2573b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "469228255")) {
                ipChange.ipc$dispatch("469228255", new Object[]{this, view});
            } else if (TextUtils.isEmpty(DMProtocolDialog.this.c.getProtocolLink())) {
            } else {
                DMProtocolDialog.this.i.onProtocolClick(DMProtocolDialog.this.c.getProtocolLink());
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.view.DMProtocolDialog$c */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC2574c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2574c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1714448672")) {
                ipChange.ipc$dispatch("-1714448672", new Object[]{this, view});
            } else if (TextUtils.isEmpty(DMProtocolDialog.this.d.getProtocolLink())) {
            } else {
                DMProtocolDialog.this.i.onProtocolClick(DMProtocolDialog.this.d.getProtocolLink());
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.view.DMProtocolDialog$d */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC2575d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2575d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "396841697")) {
                ipChange.ipc$dispatch("396841697", new Object[]{this, view});
            } else if (TextUtils.isEmpty(DMProtocolDialog.this.e.getProtocolLink())) {
            } else {
                DMProtocolDialog.this.i.onProtocolClick(DMProtocolDialog.this.e.getProtocolLink());
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.view.DMProtocolDialog$e */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC2576e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2576e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1786835230")) {
                ipChange.ipc$dispatch("-1786835230", new Object[]{this, view});
            } else if (TextUtils.isEmpty(DMProtocolDialog.this.f.getProtocolLink())) {
            } else {
                DMProtocolDialog.this.i.onProtocolClick(DMProtocolDialog.this.f.getProtocolLink());
            }
        }
    }

    public DMProtocolDialog(@NonNull Context context) {
        this(context, R$style.DMDialogStyle);
    }

    private boolean h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1864451189")) {
            return ((Boolean) ipChange.ipc$dispatch("1864451189", new Object[]{this})).booleanValue();
        }
        if (this.c.getIsCheck() == null || this.c.getIsCheck().booleanValue()) {
            if (this.d.getIsCheck() == null || this.d.getIsCheck().booleanValue()) {
                if (this.e.getIsCheck() == null || this.e.getIsCheck().booleanValue()) {
                    return this.f.getIsCheck() == null || this.f.getIsCheck().booleanValue();
                }
                return false;
            }
            return false;
        }
        return false;
    }

    private void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-362454293")) {
            ipChange.ipc$dispatch("-362454293", new Object[]{this});
            return;
        }
        View inflate = getLayoutInflater().inflate(R$layout.damai_protocol_dialog, (ViewGroup) null);
        MaxHeightLinearLayout maxHeightLinearLayout = (MaxHeightLinearLayout) inflate.findViewById(R$id.damai_protocol_dialog_layout);
        int c = yr2.c(getContext(), maxHeightLinearLayout.getMaxHeight(), 50, C4318n.g, GridBean.TYPE_PIC_URL);
        this.a = (ImageView) inflate.findViewById(R$id.iv_background);
        int i = (c * C4318n.g) / GridBean.TYPE_PIC_URL;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) maxHeightLinearLayout.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.a.getLayoutParams();
        layoutParams.width = c;
        layoutParams.height = i;
        layoutParams2.width = c;
        layoutParams2.height = i;
        this.a.setLayoutParams(layoutParams2);
        maxHeightLinearLayout.setLayoutParams(layoutParams);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R$id.fl_cancel_btn);
        this.h = frameLayout;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) frameLayout.getLayoutParams();
        double d = i;
        double d2 = 0.1087d * d;
        layoutParams3.height = Double.valueOf(d2).intValue();
        this.h.setLayoutParams(layoutParams3);
        FrameLayout frameLayout2 = (FrameLayout) inflate.findViewById(R$id.fl_ok_btn);
        this.g = frameLayout2;
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) frameLayout2.getLayoutParams();
        layoutParams4.height = Double.valueOf(d2).intValue();
        this.g.setLayoutParams(layoutParams4);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R$id.ll_text_content);
        this.b = linearLayout;
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams5.height = Double.valueOf(d * 0.2174d).intValue();
        this.b.setLayoutParams(layoutParams5);
        this.c = (DMProtocolDialogTextItemView) inflate.findViewById(R$id.tips1);
        this.d = (DMProtocolDialogTextItemView) inflate.findViewById(R$id.tips2);
        this.e = (DMProtocolDialogTextItemView) inflate.findViewById(R$id.tips3);
        this.f = (DMProtocolDialogTextItemView) inflate.findViewById(R$id.tips4);
        setContentView(inflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(OnClickListener onClickListener, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "58161177")) {
            ipChange.ipc$dispatch("58161177", new Object[]{this, onClickListener, view});
        } else if (onClickListener != null) {
            onClickListener.onClickPositive(this, h());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(OnClickListener onClickListener, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "71693978")) {
            ipChange.ipc$dispatch("71693978", new Object[]{this, onClickListener, view});
        } else if (onClickListener != null) {
            onClickListener.onClickNegative();
            dismiss();
        }
    }

    private DMProtocolDialog l(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1474765908")) {
            return (DMProtocolDialog) ipChange.ipc$dispatch("-1474765908", new Object[]{this, Integer.valueOf(i)});
        }
        ImageView imageView = this.a;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
        return this;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "25324512")) {
            ipChange.ipc$dispatch("25324512", new Object[]{this});
        } else if (isShowing()) {
            super.dismiss();
            long currentTimeMillis = System.currentTimeMillis();
            this.l = currentTimeMillis;
            OnDialogShowTimeListener onDialogShowTimeListener = this.j;
            if (onDialogShowTimeListener != null) {
                onDialogShowTimeListener.exposureTime(currentTimeMillis - this.k);
            }
        }
    }

    public DMProtocolDialog m(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1418204257")) {
            return (DMProtocolDialog) ipChange.ipc$dispatch("1418204257", new Object[]{this, bitmap});
        }
        ImageView imageView = this.a;
        if (imageView != null && bitmap != null) {
            imageView.setImageBitmap(bitmap);
        }
        return this;
    }

    public DMProtocolDialog n(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1868731924")) {
            return (DMProtocolDialog) ipChange.ipc$dispatch("-1868731924", new Object[]{this, Boolean.valueOf(z)});
        }
        setCancelable(z);
        setCanceledOnTouchOutside(z);
        return this;
    }

    public DMProtocolDialog o(List<ya0> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-726604750")) {
            return (DMProtocolDialog) ipChange.ipc$dispatch("-726604750", new Object[]{this, list});
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 4 - list.size(); i++) {
            arrayList.add(new ya0());
        }
        arrayList.addAll(list);
        ya0 ya0Var = (ya0) arrayList.get(0);
        this.c.setData(ya0Var.a(), ya0Var.b(), ya0Var.f(), ya0Var.e(), ya0Var.c(), ya0Var.d());
        ya0 ya0Var2 = (ya0) arrayList.get(1);
        this.d.setData(ya0Var2.a(), ya0Var2.b(), ya0Var2.f(), ya0Var2.e(), ya0Var2.c(), ya0Var2.d());
        ya0 ya0Var3 = (ya0) arrayList.get(2);
        this.e.setData(ya0Var3.a(), ya0Var3.b(), ya0Var3.f(), ya0Var3.e(), ya0Var3.c(), ya0Var3.d());
        ya0 ya0Var4 = (ya0) arrayList.get(3);
        this.f.setData(ya0Var4.a(), ya0Var4.b(), ya0Var4.f(), ya0Var4.e(), ya0Var4.c(), ya0Var4.d());
        this.b.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver$OnGlobalLayoutListenerC2572a());
        return this;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-126523537")) {
            ipChange.ipc$dispatch("-126523537", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public DMProtocolDialog p(final OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1727810463")) {
            return (DMProtocolDialog) ipChange.ipc$dispatch("-1727810463", new Object[]{this, onClickListener});
        }
        this.i = onClickListener;
        FrameLayout frameLayout = this.g;
        if (frameLayout != null) {
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: tb.es
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DMProtocolDialog.this.j(onClickListener, view);
                }
            });
        }
        FrameLayout frameLayout2 = this.h;
        if (frameLayout2 != null) {
            frameLayout2.setOnClickListener(new View.OnClickListener() { // from class: tb.fs
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DMProtocolDialog.this.k(onClickListener, view);
                }
            });
        }
        if (this.c.getIsCheck() != null) {
            this.c.setProtocolClick(new View$OnClickListenerC2573b());
        }
        if (this.d.getIsCheck() != null) {
            this.d.setProtocolClick(new View$OnClickListenerC2574c());
        }
        if (this.e.getIsCheck() != null) {
            this.e.setProtocolClick(new View$OnClickListenerC2575d());
        }
        if (this.f.getIsCheck() != null) {
            this.f.setProtocolClick(new View$OnClickListenerC2576e());
        }
        return this;
    }

    public void q(OnDialogShowTimeListener onDialogShowTimeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "749239798")) {
            ipChange.ipc$dispatch("749239798", new Object[]{this, onDialogShowTimeListener});
        } else {
            this.j = onDialogShowTimeListener;
        }
    }

    public DMProtocolDialog r(DMDialogTheme dMDialogTheme) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-352032629")) {
            return (DMProtocolDialog) ipChange.ipc$dispatch("-352032629", new Object[]{this, dMDialogTheme});
        }
        int i = R$drawable.damai_protocol_dialog_dna;
        DMDialogTheme dMDialogTheme2 = DMDialogTheme.THEME_DNA;
        l(i);
        return this;
    }

    @Override // android.app.Dialog
    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1433587779")) {
            ipChange.ipc$dispatch("1433587779", new Object[]{this});
            return;
        }
        super.show();
        this.k = System.currentTimeMillis();
    }

    public DMProtocolDialog(@NonNull Context context, int i) {
        super(context, i);
        i();
    }
}
