package tb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.ultron.R$layout;
import com.alibaba.android.ultron.vfw.viewholder.IViewHolderCreator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.ultron.common.model.IDMComponent;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class sa0 extends j1 {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final IViewHolderCreator CREATOR = new C9689a();

    /* compiled from: Taobao */
    /* renamed from: tb.sa0$a */
    /* loaded from: classes9.dex */
    public static final class C9689a implements IViewHolderCreator {
        private static transient /* synthetic */ IpChange $ipChange;

        C9689a() {
        }

        @Override // com.alibaba.android.ultron.vfw.viewholder.IViewHolderCreator
        public j1 create(ay2 ay2Var) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-748883092") ? (j1) ipChange.ipc$dispatch("-748883092", new Object[]{this, ay2Var}) : new sa0(ay2Var);
        }
    }

    public sa0(ay2 ay2Var) {
        super(ay2Var);
    }

    @Override // tb.j1
    protected void d(@NonNull IDMComponent iDMComponent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "428417859")) {
            ipChange.ipc$dispatch("428417859", new Object[]{this, iDMComponent});
        }
    }

    @Override // tb.j1
    protected View e(@Nullable ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "980085624") ? (View) ipChange.ipc$dispatch("980085624", new Object[]{this, viewGroup}) : LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.ultron_line_layout, viewGroup, false);
    }
}
