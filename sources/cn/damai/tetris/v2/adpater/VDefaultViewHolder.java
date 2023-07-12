package cn.damai.tetris.v2.adpater;

import android.text.TextUtils;
import android.view.View;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.IContext;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IView;
import cn.damai.tetris.core.config.ComponentConfig;
import cn.damai.tetris.core.ut.TrackProxy;
import cn.damai.tetris.v2.structure.section.ISection;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.Constants;
import java.util.HashMap;
import tb.ja;
import tb.jb1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class VDefaultViewHolder extends VBaseViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    protected BasePresenter d;

    public VDefaultViewHolder(IContext iContext, View view, ComponentConfig componentConfig) {
        super(view, iContext);
        if (componentConfig == null) {
            return;
        }
        try {
            Class<?> cls = Class.forName(componentConfig.vClass);
            BasePresenter basePresenter = (BasePresenter) Class.forName(componentConfig.pClass).getConstructor(cls, String.class, ja.class).newInstance((IView) cls.getConstructor(View.class).newInstance(view), componentConfig.mClass, iContext);
            this.d = basePresenter;
            this.c = basePresenter.rebindAble();
        } catch (Exception e) {
            e.printStackTrace();
            jb1.a("VDefaultViewHolder", "Create component failed : " + e.getMessage());
            HashMap hashMap = new HashMap();
            hashMap.put("exception", e.getMessage());
            hashMap.put(Constants.CONFIG, componentConfig.toString());
            TrackProxy.c("-507", "组件配置不存在/创建异常", hashMap);
        }
    }

    private BaseNode f(ISection iSection) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1718615795")) {
            return (BaseNode) ipChange.ipc$dispatch("-1718615795", new Object[]{this, iSection});
        }
        BaseNode baseNode = new BaseNode();
        if (iSection != null && iSection.getItem() != null) {
            baseNode.setItem(iSection.getItem());
            baseNode.setOffset(iSection.getIndex());
            baseNode.setTrackInfo(iSection.getTrackInfo());
            baseNode.setStyle(iSection.getStyleInfo());
            if (iSection.getRawData() != null && !TextUtils.isEmpty(iSection.getRawData().getString("abBucket"))) {
                baseNode.setAbBucket(iSection.getRawData().getString("abBucket"));
            }
        }
        return baseNode;
    }

    @Override // cn.damai.tetris.v2.adpater.VBaseViewHolder
    protected IModel b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1717103563")) {
            return (IModel) ipChange.ipc$dispatch("-1717103563", new Object[]{this});
        }
        BasePresenter basePresenter = this.d;
        if (basePresenter != null) {
            basePresenter.setSection((ISection) this.b);
            IModel createModel = this.d.createModel(f((ISection) this.b));
            this.d.init();
            return createModel;
        }
        return null;
    }

    @Override // cn.damai.tetris.v2.adpater.VBaseViewHolder
    public void d(IModel iModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1019696429")) {
            ipChange.ipc$dispatch("-1019696429", new Object[]{this, iModel});
            return;
        }
        BasePresenter basePresenter = this.d;
        if (basePresenter != null) {
            basePresenter.setSection((ISection) this.b);
            this.d.rebindData(iModel);
        }
    }

    @Override // cn.damai.tetris.v2.adpater.VBaseViewHolder
    public boolean rebindAble() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1333782131")) {
            return ((Boolean) ipChange.ipc$dispatch("-1333782131", new Object[]{this})).booleanValue();
        }
        BasePresenter basePresenter = this.d;
        if (basePresenter != null) {
            return basePresenter.rebindAble();
        }
        return this.c;
    }
}
