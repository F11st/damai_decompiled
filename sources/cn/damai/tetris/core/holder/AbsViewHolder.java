package cn.damai.tetris.core.holder;

import android.view.LayoutInflater;
import android.view.View;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.IView;
import cn.damai.tetris.core.config.ComponentConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.a1;
import tb.ja;
import tb.jb1;
import tb.om;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public abstract class AbsViewHolder<T extends a1, P extends BasePresenter, L extends BaseLayer> extends BaseViewHolder {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TAG = "AbsViewHolder";
    protected P a;
    protected T b;
    IView c;

    public AbsViewHolder(T t, ja jaVar) {
        super(t.d());
        jb1.a(TAG, "AbsViewHolder start. ");
        if (jaVar == null || jaVar.getActivity() == null) {
            return;
        }
        this.b = t;
        int a = t.a();
        ComponentConfig a2 = om.c(jaVar.getActivity()).a(a);
        jb1.a(TAG, "AbsViewHolder get config . type: " + a + " , config " + a2);
        if (a2 == null) {
            return;
        }
        View inflate = LayoutInflater.from(jaVar.getActivity()).inflate(jaVar.getActivity().getResources().getIdentifier(a2.layoutXml, "layout", jaVar.getActivity().getPackageName()), t.d(), false);
        try {
            Class<?> cls = Class.forName(a2.vClass);
            IView iView = (IView) cls.getConstructor(View.class).newInstance(inflate);
            this.c = iView;
            a(t, iView);
            this.a = (P) Class.forName(a2.pClass).getConstructor(cls, String.class, ja.class).newInstance(this.c, a2.mClass, jaVar);
        } catch (Exception e) {
            e.printStackTrace();
            jb1.b(TAG, "AbsViewHolder Class.forName :" + e);
        }
    }

    public abstract void a(T t, IView iView);

    public P b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-439638794") ? (P) ipChange.ipc$dispatch("-439638794", new Object[]{this}) : this.a;
    }

    public void c(L l) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-598750757")) {
            ipChange.ipc$dispatch("-598750757", new Object[]{this, l});
        } else {
            this.b.e(l);
        }
    }
}
