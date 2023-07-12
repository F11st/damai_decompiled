package com.alibaba.android.ultron.trade.presenter;

import android.content.Context;
import com.alibaba.android.ultron.trade.data.request.AbstractC3246a;
import com.alibaba.android.ultron.trade.data.request.DataInfo;
import com.alibaba.android.ultron.trade.data.request.PageInfo;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.common.model.LinkageType;
import com.taobao.android.ultron.datamodel.IDMContext;
import java.util.ArrayList;
import java.util.List;
import tb.f1;
import tb.lp2;
import tb.np2;
import tb.vt2;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public abstract class BaseDataManager {
    private static final String TAG = "BaseDataManager";
    protected AbstractC3246a mAdjustRequester;
    protected AbstractC3246a mBuildRequester;
    protected Context mContext;
    protected AbstractC3246a mCreateRequester;
    protected IDMContext mDataContext;
    protected lp2 mDataSource;
    protected IPresenter mPresenter;
    protected List<BuildRequestPageListener> mPageListeners = new ArrayList();
    protected List<AdjustRequestPageListener> mAdjustPageListeners = new ArrayList();

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface AdjustRequestPageListener {
        void onAdjustRequestFinish();
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface BuildRequestPageListener {
        void onBuildRequestFinish(PageInfo pageInfo, DataInfo dataInfo);
    }

    public BaseDataManager(IPresenter iPresenter) {
        if (iPresenter != null) {
            this.mPresenter = iPresenter;
            this.mContext = iPresenter.getContext();
            initRequester();
            return;
        }
        throw new IllegalArgumentException("param presenter can not be null");
    }

    public List<AdjustRequestPageListener> getAdjustRequestPageListeners() {
        return this.mAdjustPageListeners;
    }

    public AbstractC3246a getAdjustRequester() {
        return this.mAdjustRequester;
    }

    public List<BuildRequestPageListener> getBuildRequestPageListeners() {
        return this.mPageListeners;
    }

    public AbstractC3246a getBuildRequester() {
        return this.mBuildRequester;
    }

    public AbstractC3246a getCreateRequester() {
        return this.mCreateRequester;
    }

    public IDMContext getDataContext() {
        return this.mDataContext;
    }

    public lp2 getDataSource() {
        return this.mDataSource;
    }

    protected abstract void initRequester();

    public void respondToLinkage(IDMComponent iDMComponent) {
        respondToLinkage(iDMComponent, null);
    }

    public abstract void sendRespondRequest(IDMComponent iDMComponent, np2 np2Var, boolean z, f1 f1Var, Object obj);

    public void setAdjustRequestPageListeners(AdjustRequestPageListener adjustRequestPageListener) {
        this.mAdjustPageListeners.add(adjustRequestPageListener);
    }

    public void setBuildRequestPageListener(BuildRequestPageListener buildRequestPageListener) {
        this.mPageListeners.add(buildRequestPageListener);
    }

    public void setDataContext(IDMContext iDMContext) {
        this.mDataContext = iDMContext;
    }

    public void setDataSource(lp2 lp2Var) {
        this.mDataSource = lp2Var;
    }

    public void respondToLinkage(IDMComponent iDMComponent, np2 np2Var) {
        respondToLinkage(iDMComponent, np2Var, true, null, null);
    }

    public void respondToLinkage(IDMComponent iDMComponent, np2 np2Var, boolean z, f1 f1Var, Object obj) {
        if (iDMComponent == null) {
            return;
        }
        if (iDMComponent.getLinkageType() == LinkageType.REFRESH) {
            this.mPresenter.getViewManager().refreshCurrentContainer();
            return;
        }
        vt2.b(TAG, "respondToLinkage", "开始请求");
        sendRespondRequest(iDMComponent, np2Var, z, f1Var, obj);
    }
}
