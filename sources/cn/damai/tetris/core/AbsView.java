package cn.damai.tetris.core;

import android.view.View;
import cn.damai.tetris.core.IPresenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.gi2;
import tb.ja;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class AbsView<P extends IPresenter> implements IView<P>, Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private P mPresenter;
    private View mView;
    private gi2 styleType;

    public AbsView(View view) {
        this.mView = view;
    }

    public ja getContext() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1799896894")) {
            return (ja) ipChange.ipc$dispatch("1799896894", new Object[]{this});
        }
        P p = this.mPresenter;
        if (p != null) {
            return p.getContext();
        }
        return null;
    }

    public P getPresenter() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1275800254") ? (P) ipChange.ipc$dispatch("-1275800254", new Object[]{this}) : this.mPresenter;
    }

    @Override // cn.damai.tetris.core.IView
    public View getRootView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1504962616") ? (View) ipChange.ipc$dispatch("1504962616", new Object[]{this}) : this.mView;
    }

    public gi2 getStyleType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-965841760") ? (gi2) ipChange.ipc$dispatch("-965841760", new Object[]{this}) : this.styleType;
    }

    public View getView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1167387386") ? (View) ipChange.ipc$dispatch("1167387386", new Object[]{this}) : this.mView;
    }

    @Override // cn.damai.tetris.core.IView
    public void setPresenter(P p) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1307608228")) {
            ipChange.ipc$dispatch("-1307608228", new Object[]{this, p});
        } else {
            this.mPresenter = p;
        }
    }

    @Override // cn.damai.tetris.core.IView
    public void setStyle(gi2 gi2Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2137968378")) {
            ipChange.ipc$dispatch("-2137968378", new Object[]{this, gi2Var});
        } else {
            this.styleType = gi2Var;
        }
    }

    public void setStyleType(gi2 gi2Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1271224992")) {
            ipChange.ipc$dispatch("-1271224992", new Object[]{this, gi2Var});
        } else {
            this.styleType = gi2Var;
        }
    }

    public void setView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-550407386")) {
            ipChange.ipc$dispatch("-550407386", new Object[]{this, view});
        } else {
            this.mView = this.mView;
        }
    }
}
