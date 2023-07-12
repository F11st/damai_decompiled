package tb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import cn.damai.discover.content.ut.LiveUTer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public abstract class cp2<T> implements View.OnClickListener, LiveUTer {
    private static transient /* synthetic */ IpChange $ipChange;
    public Context a;
    public View b;
    private q91 c;

    public cp2(Context context) {
        this.a = context;
        this.b = LayoutInflater.from(context).inflate(a(), (ViewGroup) null);
        b();
        c(false);
    }

    public abstract int a();

    public abstract void b();

    public void c(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1323529869")) {
            ipChange.ipc$dispatch("1323529869", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        View view = this.b;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    @Override // cn.damai.discover.content.ut.LiveUTer
    @NonNull
    public q91 getLiveUt() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1249207224")) {
            return (q91) ipChange.ipc$dispatch("-1249207224", new Object[]{this});
        }
        q91 q91Var = this.c;
        return q91Var == null ? new q91() : q91Var;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1615419704")) {
            ipChange.ipc$dispatch("-1615419704", new Object[]{this, view});
        }
    }

    public void setLiveUt(q91 q91Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-16824118")) {
            ipChange.ipc$dispatch("-16824118", new Object[]{this, q91Var});
        } else {
            this.c = q91Var;
        }
    }
}
