package cn.damai.login.authlogin.ui;

import android.content.Context;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;
import androidx.annotation.NonNull;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.ref.WeakReference;
import tb.cs;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class DMUrlSpan extends URLSpan {
    private static transient /* synthetic */ IpChange $ipChange;
    WeakReference<Context> mContextRef;
    private View.OnClickListener mOnClickListener;

    public DMUrlSpan(Context context, String str) {
        this(str);
        this.mContextRef = new WeakReference<>(context);
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-305198894")) {
            ipChange.ipc$dispatch("-305198894", new Object[]{this, view});
            return;
        }
        WeakReference<Context> weakReference = this.mContextRef;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        String url = getURL();
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        DMNav.from(this.mContextRef.get()).withExtras(bundle).toUri(NavUri.b(cs.t));
        View.OnClickListener onClickListener = this.mOnClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1443818355")) {
            ipChange.ipc$dispatch("1443818355", new Object[]{this, onClickListener});
        } else {
            this.mOnClickListener = onClickListener;
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(@NonNull TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2018084389")) {
            ipChange.ipc$dispatch("2018084389", new Object[]{this, textPaint});
            return;
        }
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
    }

    public DMUrlSpan(String str) {
        super(str);
    }
}
