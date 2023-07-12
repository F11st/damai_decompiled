package cn.damai.common.util.toastutil;

import android.app.Application;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class BaseToast extends Toast {
    private static transient /* synthetic */ IpChange $ipChange;
    private View mMessageView;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseToast(Application application) {
        super(application);
    }

    private static TextView findTextView(ViewGroup viewGroup) {
        TextView findTextView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "4282761")) {
            return (TextView) ipChange.ipc$dispatch("4282761", new Object[]{viewGroup});
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof TextView) {
                return (TextView) childAt;
            }
            if ((childAt instanceof ViewGroup) && (findTextView = findTextView((ViewGroup) childAt)) != null) {
                return findTextView;
            }
        }
        return null;
    }

    private static View getMessageView(View view) {
        TextView findTextView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-455157687")) {
            return (View) ipChange.ipc$dispatch("-455157687", new Object[]{view});
        }
        if (view instanceof TextView) {
            return (TextView) view;
        }
        if (view.findViewById(16908299) instanceof TextView) {
            return (TextView) view.findViewById(16908299);
        }
        return (!(view instanceof ViewGroup) || (findTextView = findTextView((ViewGroup) view)) == null) ? view : findTextView;
    }

    @Override // android.widget.Toast
    public void setText(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "709524222")) {
            ipChange.ipc$dispatch("709524222", new Object[]{this, charSequence});
        } else if (!(this.mMessageView instanceof TextView) || TextUtils.isEmpty(charSequence)) {
        } else {
            ((TextView) this.mMessageView).setText(charSequence);
        }
    }

    @Override // android.widget.Toast
    public void setView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-559604304")) {
            ipChange.ipc$dispatch("-559604304", new Object[]{this, view});
            return;
        }
        super.setView(view);
        this.mMessageView = getMessageView(view);
    }
}
