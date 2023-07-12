package cn.damai.tetris.component.rank;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.common.nav.DMNav;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.city.CitySelectActivity;
import cn.damai.commonbusiness.city.bean.CityParam;
import cn.damai.rank.RankSquareCMSActivity;
import cn.damai.tetris.component.rank.RankFilterViewManager;
import cn.damai.tetris.component.rank.bean.CategoryTabBean;
import cn.damai.tetris.component.rank.bean.PresetBean;
import cn.damai.tetris.component.rank.bean.RankCityIdTarget;
import cn.damai.tetris.component.rank.bean.RankCityValue;
import cn.damai.tetris.component.rank.bean.RankFilterBean;
import cn.damai.tetris.component.rank.bean.RankFilterExtraInfo;
import cn.damai.tetris.component.rank.bean.RankFilterValue;
import cn.damai.tetris.component.rank.bean.RankProjectParams;
import cn.damai.tetris.component.rank.bean.TypeTabBean;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.page.AbsFragment;
import cn.damai.tetris.request.DrObj;
import cn.damai.tetris.request.TetrisRequest;
import cn.damai.tetris.v2.adpater.VBaseViewHolder;
import cn.damai.tetris.v2.common.Node;
import cn.damai.tetris.v2.componentplugin.ComponentPageUi;
import cn.damai.tetris.v2.componentplugin.ComponentPlugin;
import cn.damai.tetris.v2.structure.container.IContainer;
import cn.damai.tetris.v2.structure.container.ValueKey;
import cn.damai.tetris.v2.structure.layer.ILayer;
import cn.damai.tetris.v2.structure.section.ISection;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import tb.bz1;
import tb.cb2;
import tb.db;
import tb.ja;
import tb.jn1;
import tb.m61;
import tb.mu0;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class RankFilterPlugin extends ComponentPlugin implements RankFilterViewManager.OnRankActionListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private String mCityName;
    private String mFirstSelectCategoryId;
    private RankFilterBean mRankFilterBean;
    private RankFilterViewManager mRankManager;
    private bz1 mRankUt;
    private String mSpmB;
    private String mTargetLayerId;
    private String mTargetSectionId;

    public RankFilterPlugin(ComponentPageUi componentPageUi) {
        super(componentPageUi);
    }

    private bz1 getNoneRankUt() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2077098477")) {
            return (bz1) ipChange.ipc$dispatch("2077098477", new Object[]{this});
        }
        if (this.mRankUt == null) {
            String d = TextUtils.isEmpty(this.mCityName) ? z20.d() : this.mCityName;
            if (TextUtils.isEmpty(this.mSpmB)) {
                this.mRankUt = new bz1("ranklist_square", d);
            } else {
                this.mRankUt = new bz1(this.mSpmB, d);
            }
        }
        return this.mRankUt;
    }

    private int getRoundColor(ISection iSection) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-663711835")) {
            return ((Integer) ipChange.ipc$dispatch("-663711835", new Object[]{this, iSection})).intValue();
        }
        if (iSection != null) {
            try {
                if (iSection.getStyleInfo() != null) {
                    String string = iSection.getStyleInfo().getString("color");
                    if (!TextUtils.isEmpty(string) && string.startsWith(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
                        return Color.parseColor(string);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Color.parseColor("#FFFFFF");
    }

    private boolean isComponentUiOk() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1766101119")) {
            return ((Boolean) ipChange.ipc$dispatch("-1766101119", new Object[]{this})).booleanValue();
        }
        ja baseContext = this.mComponentUi.getBaseContext();
        return (baseContext == null || this.mComponentUi.getPageContainer() == null || this.mComponentUi.getRecycler() == null || baseContext.getActivity() == null) ? false : true;
    }

    private void load(CategoryTabBean categoryTabBean, TypeTabBean typeTabBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "759267648")) {
            ipChange.ipc$dispatch("759267648", new Object[]{this, categoryTabBean, typeTabBean});
            return;
        }
        this.mComponentUi.startProgressDialog();
        IContainer pageContainer = this.mComponentUi.getPageContainer();
        RankProjectParams rankProjectParams = new RankProjectParams(pageContainer.getContainerArg());
        rankProjectParams.categoryId = categoryTabBean.id;
        rankProjectParams.subType = typeTabBean.id;
        String str = ((RankCityValue) pageContainer.getContainerValue(ValueKey.KEY_RANK_SQUARE_INPUT_CITY_ID, new RankCityIdTarget())).cityId;
        rankProjectParams.comboDamaiCityId = str;
        rankProjectParams.cityId = str;
        rankProjectParams.currentCityId = z20.c();
        TetrisRequest tetrisRequest = new TetrisRequest(rankProjectParams);
        DrObj drObj = new DrObj(this.mTargetLayerId, this.mTargetSectionId, tetrisRequest.args);
        tetrisRequest.dr = jn1.ARRAY_START_STR + JSON.toJSONString(drObj) + jn1.ARRAY_END_STR;
        tetrisRequest.request(new DMMtopRequestListener<BaseResponse>(BaseResponse.class) { // from class: cn.damai.tetris.component.rank.RankFilterPlugin.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1436529362")) {
                    ipChange2.ipc$dispatch("-1436529362", new Object[]{this, str2, str3});
                    return;
                }
                ((ComponentPlugin) RankFilterPlugin.this).mComponentUi.stopProgressDialog();
                ToastUtil.a().j(mu0.a(), str3);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(BaseResponse baseResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-306700134")) {
                    ipChange2.ipc$dispatch("-306700134", new Object[]{this, baseResponse});
                    return;
                }
                ((ComponentPlugin) RankFilterPlugin.this).mComponentUi.stopProgressDialog();
                List<ILayer> layerList = ((ComponentPlugin) RankFilterPlugin.this).mComponentUi.getPageContainer().getLayerList();
                RankFilterExtraInfo obtainFromBaseRes = RankFilterExtraInfo.obtainFromBaseRes(baseResponse);
                RankFilterPlugin.this.mRankManager.q(!obtainFromBaseRes.hasProject);
                RankFilterPlugin.this.mRankManager.s(obtainFromBaseRes.shouldShowOtherCityTip);
                if (obtainFromBaseRes.hasProject) {
                    ((ComponentPlugin) RankFilterPlugin.this).mComponentUi.showNoMoreV2(AbsFragment.TAG_SHOW_RANK_FOOT_UI);
                } else {
                    ((ComponentPlugin) RankFilterPlugin.this).mComponentUi.hideNoMoreV2();
                }
                ILayer iLayer = null;
                if (!cb2.d(layerList)) {
                    Iterator<ILayer> it = layerList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ILayer next = it.next();
                        if (TextUtils.equals(next.getLayerId(), RankFilterPlugin.this.mTargetLayerId)) {
                            iLayer = next;
                            break;
                        }
                    }
                }
                if (iLayer != null) {
                    List<Node> f = new db().f(baseResponse);
                    iLayer.clearSectionList();
                    iLayer.createSectionList(f, true);
                }
            }
        });
    }

    private void saveContainerValue(@Nullable CategoryTabBean categoryTabBean, @Nullable TypeTabBean typeTabBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1364096775")) {
            ipChange.ipc$dispatch("-1364096775", new Object[]{this, categoryTabBean, typeTabBean});
            return;
        }
        ja baseContext = this.mComponentUi.getBaseContext();
        if (baseContext == null || baseContext.getContainer() == null) {
            return;
        }
        baseContext.getContainer().saveContainerValue(ValueKey.KEY_RANK_SQUARE_FILTER_INFO, RankFilterValue.class, new RankFilterValue(categoryTabBean, typeTabBean));
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public void onBindViewHolder(ISection iSection, VBaseViewHolder vBaseViewHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1442249605")) {
            ipChange.ipc$dispatch("-1442249605", new Object[]{this, iSection, vBaseViewHolder});
        } else if (this.mRankManager != null || !isComponentUiOk() || this.mRankFilterBean == null || vBaseViewHolder.itemView.findViewById(R$id.id_tetris_rank_layout) == null) {
        } else {
            RankFilterExtraInfo obtainFromSection = RankFilterExtraInfo.obtainFromSection(iSection);
            this.mTargetLayerId = obtainFromSection.rankProjectLayerId;
            this.mTargetSectionId = obtainFromSection.rankProjectSectionId;
            RankFilterViewManager rankFilterViewManager = new RankFilterViewManager(this.mComponentUi.getBaseContext().getActivity(), vBaseViewHolder.itemView, this);
            this.mRankManager = rankFilterViewManager;
            rankFilterViewManager.m(this.mRankFilterBean, this.mFirstSelectCategoryId);
            this.mRankManager.q(!obtainFromSection.hasProject);
            this.mRankManager.r(getRoundColor(iSection));
            this.mRankManager.s(obtainFromSection.shouldShowOtherCityTip);
        }
    }

    @Override // cn.damai.tetris.component.rank.RankFilterViewManager.OnRankActionListener
    public void onChangeCityClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-796650286")) {
            ipChange.ipc$dispatch("-796650286", new Object[]{this});
        } else if (isComponentUiOk()) {
            Activity activity = this.mComponentUi.getBaseContext().getActivity();
            Bundle bundle = new Bundle();
            bundle.putParcelable(CitySelectActivity.OBTAIN_CITY_PARAM, CityParam.onlyObtainCity(TextUtils.isEmpty(this.mCityName) ? z20.d() : this.mCityName));
            DMNav.from(activity).withExtras(bundle).forResult(RankSquareCMSActivity.CITY_OBTAIN_REQUEST_CODE).toHost("home_cityselect");
        }
    }

    @Override // cn.damai.tetris.component.rank.RankFilterViewManager.OnRankActionListener
    public void onFilterChanged(@NonNull CategoryTabBean categoryTabBean, @NonNull TypeTabBean typeTabBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1895003711")) {
            ipChange.ipc$dispatch("1895003711", new Object[]{this, categoryTabBean, typeTabBean});
        } else if (isComponentUiOk()) {
            saveContainerValue(categoryTabBean, typeTabBean);
            load(categoryTabBean, typeTabBean);
        }
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public boolean onLoadMore() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1019495924")) {
            return ((Boolean) ipChange.ipc$dispatch("1019495924", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.tetris.component.rank.RankFilterViewManager.OnRankActionListener
    public void onMainBtnClick(@NonNull CategoryTabBean categoryTabBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "152723686")) {
            ipChange.ipc$dispatch("152723686", new Object[]{this, categoryTabBean, Integer.valueOf(i)});
        } else {
            getNoneRankUt().h(categoryTabBean, i);
        }
    }

    @Override // cn.damai.tetris.component.rank.RankFilterViewManager.OnRankActionListener
    public void onMainBtnExpose(View view, @NonNull CategoryTabBean categoryTabBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-256808326")) {
            ipChange.ipc$dispatch("-256808326", new Object[]{this, view, categoryTabBean, Integer.valueOf(i)});
        } else {
            getNoneRankUt().f(view, categoryTabBean);
        }
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public boolean onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "717239179")) {
            return ((Boolean) ipChange.ipc$dispatch("717239179", new Object[]{this, Integer.valueOf(i), obj})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public boolean onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-312456632")) {
            return ((Boolean) ipChange.ipc$dispatch("-312456632", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public void onSectionBind(ISection iSection) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-479430486")) {
            ipChange.ipc$dispatch("-479430486", new Object[]{this, iSection});
            return;
        }
        RankFilterExtraInfo obtainFromSection = RankFilterExtraInfo.obtainFromSection(iSection);
        if (obtainFromSection.hasProject) {
            this.mComponentUi.showNoMoreV2(AbsFragment.TAG_SHOW_RANK_FOOT_UI);
        }
        this.mSpmB = obtainFromSection.spmB;
        this.mRankFilterBean = (RankFilterBean) m61.d(iSection.getItem(), RankFilterBean.class);
        IContainer pageContainer = this.mComponentUi.getPageContainer();
        if (pageContainer != null) {
            RankCityValue rankCityValue = (RankCityValue) pageContainer.getContainerValue(ValueKey.KEY_RANK_SQUARE_INPUT_CITY_ID, new RankCityIdTarget());
            this.mFirstSelectCategoryId = rankCityValue.categoryId;
            this.mCityName = rankCityValue.cityName;
        }
        RankFilterBean rankFilterBean = this.mRankFilterBean;
        TypeTabBean typeTabBean = null;
        if (rankFilterBean != null && !cb2.d(rankFilterBean.categoryTabs)) {
            this.mRankFilterBean.ensureFormatBeanOneTime();
            try {
                CategoryTabBean obtainSelected = PresetBean.obtainSelected(this.mRankFilterBean.categoryTabs, this.mFirstSelectCategoryId);
                if (obtainSelected != null && !cb2.d(obtainSelected.subTypeList)) {
                    typeTabBean = obtainSelected.subTypeList.get(0);
                }
                saveContainerValue(obtainSelected, typeTabBean);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        saveContainerValue(null, null);
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public void onSectionRemoved(@Nullable ISection iSection) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1510548791")) {
            ipChange.ipc$dispatch("1510548791", new Object[]{this, iSection});
        }
    }

    @Override // cn.damai.tetris.component.rank.RankFilterViewManager.OnRankActionListener
    public void onSubBtnClick(@NotNull CategoryTabBean categoryTabBean, @NotNull TypeTabBean typeTabBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-470650636")) {
            ipChange.ipc$dispatch("-470650636", new Object[]{this, categoryTabBean, typeTabBean, Integer.valueOf(i)});
        } else {
            getNoneRankUt().i(categoryTabBean, typeTabBean);
        }
    }

    @Override // cn.damai.tetris.component.rank.RankFilterViewManager.OnRankActionListener
    public void onSubBtnExpose(View view, CategoryTabBean categoryTabBean, TypeTabBean typeTabBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1619928480")) {
            ipChange.ipc$dispatch("-1619928480", new Object[]{this, view, categoryTabBean, typeTabBean, Integer.valueOf(i)});
        } else if (categoryTabBean == null || typeTabBean == null) {
        } else {
            getNoneRankUt().g(view, categoryTabBean.pos, typeTabBean);
        }
    }
}
