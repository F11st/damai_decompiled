package com.alibaba.android.ultron.trade.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.ultron.trade.dinamicX.constructor.TradePriceViewConstructor;
import com.alibaba.android.ultron.trade.dinamicX.constructor.TradeRichTextViewConstructor;
import com.alibaba.android.ultron.trade.dinamicX.constructor.TradeTextInputConstructor;
import com.alibaba.android.ultron.trade.event.base.ISubscriber;
import com.alibaba.android.ultron.trade.extplugin.ExtPlugInfo;
import com.alibaba.android.ultron.trade.theme.IConfiguration;
import com.alibaba.android.ultron.vfw.viewholder.IViewHolderCreator;
import com.alibaba.android.ultron.vfw.web.IWebEventBridge;
import com.alibaba.fastjson.JSON;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.datamodel.IDMContext;
import java.util.List;
import java.util.Map;
import tb.bg0;
import tb.ch0;
import tb.ck2;
import tb.co2;
import tb.dk2;
import tb.ek2;
import tb.fk2;
import tb.gk2;
import tb.iz;
import tb.jm2;
import tb.km2;
import tb.lp2;
import tb.np2;
import tb.op2;
import tb.pu0;
import tb.qs1;
import tb.ri0;
import tb.vj;
import tb.vt2;
import tb.yt0;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public abstract class a implements IPresenter {
    public static final String DINAMIC_CONTEXT_KEY_PRESENTER = "dianmicContextKeyPresenter";
    private String mBizName = "default";
    protected Activity mContext;
    protected BaseDataManager mDataManager;
    protected km2 mThemeManager;
    protected op2 mTradeEventHandler;
    protected b mViewManager;

    public a(Activity activity) {
        this.mContext = activity;
        co2.c(co2.KEY_ULTRON_PROFILE, "BasePresenter start");
    }

    public np2 buildTradeEvent() {
        return this.mTradeEventHandler.d();
    }

    @Override // com.alibaba.android.ultron.trade.presenter.IPresenter
    public Activity getContext() {
        return this.mContext;
    }

    @Override // com.alibaba.android.ultron.trade.presenter.IPresenter
    public IDMContext getDataContext() {
        return this.mDataManager.getDataContext();
    }

    @Override // com.alibaba.android.ultron.trade.presenter.IPresenter
    public BaseDataManager getDataManager() {
        return this.mDataManager;
    }

    @Override // com.alibaba.android.ultron.trade.presenter.IPresenter
    public km2 getThemeManager() {
        return this.mThemeManager;
    }

    @Override // com.alibaba.android.ultron.trade.presenter.IPresenter
    public op2 getTradeEventHandler() {
        return this.mTradeEventHandler;
    }

    @Override // com.alibaba.android.ultron.trade.presenter.IPresenter
    public b getViewManager() {
        return this.mViewManager;
    }

    public boolean hasRenderContent() {
        List<IDMComponent> components;
        IDMContext dataContext = this.mDataManager.getDataContext();
        return (dataContext == null || (components = dataContext.getComponents()) == null || components.size() <= 0) ? false : true;
    }

    public void init(BaseDataManager baseDataManager, b bVar) {
        this.mDataManager = baseDataManager;
        this.mViewManager = bVar;
        this.mThemeManager = new km2(this.mContext);
        op2 op2Var = new op2(this);
        this.mTradeEventHandler = op2Var;
        this.mViewManager.registerDynamicEventListener(op2Var);
        registerDinamicXView();
        registerDinamicXParser();
        initEventSubscriber();
        registerBridge();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initEventSubscriber() {
        Map<String, Class<? extends ISubscriber>> a = bg0.a();
        if (a == null || a.isEmpty()) {
            return;
        }
        try {
            for (Map.Entry<String, Class<? extends ISubscriber>> entry : a.entrySet()) {
                this.mTradeEventHandler.a(entry.getKey(), entry.getValue().newInstance());
            }
        } catch (Throwable unused) {
        }
    }

    public void initExtPlugin(Context context, String str) {
        List<ExtPlugInfo> list;
        try {
            list = JSON.parseArray(new String(ri0.a(context, str)), ExtPlugInfo.class);
        } catch (Exception unused) {
            list = null;
        }
        initExtPlugin(list);
    }

    public void initView(LinearLayout linearLayout, @NonNull RecyclerView recyclerView, LinearLayout linearLayout2) {
        this.mViewManager.initView(linearLayout, recyclerView, linearLayout2);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.mTradeEventHandler.k(i, i2, intent);
    }

    public void onCreate(Bundle bundle) {
    }

    public void onDestroy() {
        op2 op2Var = this.mTradeEventHandler;
        if (op2Var != null) {
            op2Var.f();
        }
        b bVar = this.mViewManager;
        if (bVar != null) {
            bVar.destroy();
        }
    }

    public void onPause() {
    }

    public void onResume() {
        vt2.f(this.mBizName);
    }

    public void rebuild(lp2 lp2Var) {
        this.mTradeEventHandler.e(lp2Var);
        this.mViewManager.rebuild(lp2Var);
    }

    protected void registerBridge() {
        registerWebEventListener(vj.BRIDGE_TAG, new vj(this));
        registerWebEventListener(yt0.BRIDGE_TAG, new yt0(this));
    }

    protected void registerDinamicXParser() {
        this.mViewManager.v2RegisterDinamicXParser("gradient", new pu0());
        this.mViewManager.v2RegisterDinamicXParser("theme", new jm2());
        this.mViewManager.v2RegisterDinamicXParser("platform", new qs1());
        this.mViewManager.v3RegisterDinamicXParser(iz.a(dk2.PARSER_TAG), new dk2());
        this.mViewManager.v3RegisterDinamicXParser(iz.a(ck2.PARSER_TAG), new ck2());
        this.mViewManager.v3RegisterDinamicXParser(iz.a("theme"), new fk2());
    }

    protected void registerDinamicXView() {
        this.mViewManager.v2registerDinamicXView(TradePriceViewConstructor.VIEW_TAG, new TradePriceViewConstructor());
        this.mViewManager.v2registerDinamicXView(TradeRichTextViewConstructor.VIEW_TAG, new TradeRichTextViewConstructor());
        this.mViewManager.v2registerDinamicXView(TradeTextInputConstructor.VIEW_TAG, new TradeTextInputConstructor());
        this.mViewManager.v3RegisterDinamicXView(ek2.DX_WIDGET_ID, new ek2.a());
        this.mViewManager.v3RegisterDinamicXView(gk2.DX_WIDGET_ID, new gk2.a());
    }

    public void registerViewHolderCreator(String str, IViewHolderCreator iViewHolderCreator) {
        this.mViewManager.registerViewHolderCreator(str, iViewHolderCreator);
    }

    public void registerWebEventListener(String str, IWebEventBridge iWebEventBridge) {
        this.mViewManager.registerWebEventListener(str, iWebEventBridge);
    }

    @Override // com.alibaba.android.ultron.trade.presenter.IPresenter
    public void respondToLinkage(IDMComponent iDMComponent) {
        this.mDataManager.respondToLinkage(iDMComponent);
    }

    public void setBizName(String str) {
        this.mBizName = str;
    }

    public void setCurrentAutoJump(IDMComponent iDMComponent, String str) {
        this.mTradeEventHandler.m(iDMComponent, str);
    }

    public void setMarkType(int i) {
        this.mViewManager.setMarkType(i);
    }

    public void setThemeConfig(IConfiguration iConfiguration) {
        this.mThemeManager.g(iConfiguration);
    }

    public void initExtPlugin(List<ExtPlugInfo> list) {
        if (list == null) {
            return;
        }
        ch0 ch0Var = new ch0();
        ch0Var.a(list, this);
        this.mTradeEventHandler.b(ch0Var.getSubscribers());
    }
}
