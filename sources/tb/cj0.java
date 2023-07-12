package tb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.damai.projectfiltercopy.bean.Type;
import cn.damai.projectfiltercopy.filterbtn.BtnInfoProvider;
import cn.damai.projectfiltercopy.filterbtn.FilterBtn;
import com.alibaba.pictures.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class cj0 implements FilterBtn {
    private static transient /* synthetic */ IpChange $ipChange;
    private final Type a;
    private final BtnInfoProvider b;
    private final View c;

    public cj0(Context context, Type type, BtnInfoProvider btnInfoProvider) {
        this.a = type;
        this.b = btnInfoProvider;
        this.c = LayoutInflater.from(context).inflate(R$layout.bricks_filter_single_date_hor_btn, (ViewGroup) null);
    }

    @Override // cn.damai.projectfiltercopy.filterbtn.FilterBtn
    public Type getType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "80266202") ? (Type) ipChange.ipc$dispatch("80266202", new Object[]{this}) : this.a;
    }

    @Override // cn.damai.projectfiltercopy.filterbtn.FilterBtn
    public View getView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "623949549") ? (View) ipChange.ipc$dispatch("623949549", new Object[]{this}) : this.c;
    }

    @Override // cn.damai.projectfiltercopy.filterbtn.FilterBtn
    public void setState(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "876214399")) {
            ipChange.ipc$dispatch("876214399", new Object[]{this, Boolean.valueOf(z)});
        }
    }
}
