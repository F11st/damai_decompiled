package tb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.ultron.R$id;
import cn.damai.ultron.R$layout;
import cn.damai.ultron.custom.view.PayTypeView;
import com.alibaba.android.ultron.vfw.viewholder.IViewHolderCreator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.ultron.common.model.IDMComponent;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class wa0 extends j1 {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final IViewHolderCreator CREATOR = new a();
    private PayTypeView c;

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public static final class a implements IViewHolderCreator {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // com.alibaba.android.ultron.vfw.viewholder.IViewHolderCreator
        public j1 create(ay2 ay2Var) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1779248760") ? (j1) ipChange.ipc$dispatch("-1779248760", new Object[]{this, ay2Var}) : new wa0(ay2Var);
        }
    }

    public wa0(ay2 ay2Var) {
        super(ay2Var);
    }

    @Override // tb.j1
    protected void d(@NonNull IDMComponent iDMComponent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-954930777")) {
            ipChange.ipc$dispatch("-954930777", new Object[]{this, iDMComponent});
        } else if (iDMComponent == null) {
        } else {
            try {
                this.c.setDmPayTypeComponent(new va0(iDMComponent));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // tb.j1
    protected View e(@Nullable ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1797760148")) {
            return (View) ipChange.ipc$dispatch("1797760148", new Object[]{this, viewGroup});
        }
        View inflate = LayoutInflater.from(this.a.l()).inflate(R$layout.ultron_pay_type, viewGroup, false);
        this.c = (PayTypeView) inflate.findViewById(R$id.tv_pay);
        return inflate;
    }
}
