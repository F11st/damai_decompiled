package tb;

import android.view.ViewGroup;
import cn.damai.tetris.core.holder.AbsViewHolder;
import cn.damai.tetris.core.holder.IViewHolderFactory;
import cn.damai.tetris.core.holder.LayerViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ox2 implements IViewHolderFactory {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.tetris.core.holder.IViewHolderFactory
    /* renamed from: a */
    public AbsViewHolder createHolder(int i, ViewGroup viewGroup, ja jaVar) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1680352731") ? (AbsViewHolder) ipChange.ipc$dispatch("1680352731", new Object[]{this, Integer.valueOf(i), viewGroup, jaVar}) : new LayerViewHolder(new w50(viewGroup, i), jaVar);
    }
}
