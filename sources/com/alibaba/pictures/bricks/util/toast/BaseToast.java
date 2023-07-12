package com.alibaba.pictures.bricks.util.toast;

import android.app.Application;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class BaseToast extends Toast {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    @Nullable
    private View mMessageView;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        private final TextView b(ViewGroup viewGroup) {
            TextView b;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1196149110")) {
                return (TextView) ipChange.ipc$dispatch("-1196149110", new Object[]{this, viewGroup});
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof TextView) {
                    return (TextView) childAt;
                }
                if ((childAt instanceof ViewGroup) && (b = b((ViewGroup) childAt)) != null) {
                    return b;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final View c(View view) {
            TextView b;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1844697560")) {
                return (View) ipChange.ipc$dispatch("-1844697560", new Object[]{this, view});
            }
            if (view instanceof TextView) {
                return view;
            }
            if (!(view.findViewById(16908299) instanceof TextView)) {
                return (!(view instanceof ViewGroup) || (b = b((ViewGroup) view)) == null) ? view : b;
            }
            View findViewById = view.findViewById(16908299);
            b41.g(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            return (TextView) findViewById;
        }
    }

    public BaseToast(@Nullable Application application) {
        super(application);
    }

    @Override // android.widget.Toast
    public void setText(@NotNull CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1445419877")) {
            ipChange.ipc$dispatch("1445419877", new Object[]{this, charSequence});
            return;
        }
        b41.i(charSequence, "s");
        if (!(this.mMessageView instanceof TextView) || TextUtils.isEmpty(charSequence)) {
            return;
        }
        View view = this.mMessageView;
        b41.g(view, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) view).setText(charSequence);
    }

    @Override // android.widget.Toast
    public void setView(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2038867735")) {
            ipChange.ipc$dispatch("-2038867735", new Object[]{this, view});
            return;
        }
        b41.i(view, "view");
        super.setView(view);
        this.mMessageView = Companion.c(view);
    }
}
