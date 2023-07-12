package cn.damai.tetris.componentplugin;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.seatbiz.utils.RequestHolder;
import cn.damai.projectfilter.bean.FilterReqParamBean;
import cn.damai.projectfilter.listener.RequestParamProvider;
import cn.damai.tetris.component.drama.bean.CategoryItemListInfo;
import cn.damai.tetris.componentplugin.bean.CategoryRequestNewParams;
import cn.damai.tetris.componentplugin.bean.LoadData;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.request.DrObj;
import cn.damai.tetris.request.TetrisRequest;
import cn.damai.tetris.v2.common.ContainerArg;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.db;
import tb.jn1;
import tb.pg;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ProjectFilterModel {
    private static transient /* synthetic */ IpChange $ipChange;
    private RequestParamProvider b;
    @Nullable
    private ContainerArg c;
    private int e;
    private int f;
    private final String h;
    private final String i;
    private RequestHolder a = new RequestHolder();
    private int d = 1;
    private int g = 0;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface OnModelBizListener {
        void onLoadProjectFail(boolean z, String str, String str2);

        void onLoadProjectSuccess(LoadData loadData);
    }

    public ProjectFilterModel(RequestParamProvider requestParamProvider, @Nullable ContainerArg containerArg, CategoryItemListInfo categoryItemListInfo) {
        this.e = -1;
        this.f = 0;
        this.b = requestParamProvider;
        this.c = containerArg;
        categoryItemListInfo = categoryItemListInfo == null ? CategoryItemListInfo.defaultItem() : categoryItemListInfo;
        k();
        this.h = categoryItemListInfo.targetLayerId;
        this.i = categoryItemListInfo.targetSectionId;
        boolean isCurrentCityEnd = categoryItemListInfo.isCurrentCityEnd(this.g);
        this.d++;
        this.g += categoryItemListInfo.currentCitySize;
        if (isCurrentCityEnd) {
            this.e = categoryItemListInfo.nearByCitySize > 0 ? 2 : 1;
        } else {
            this.e = -1;
        }
        this.f = categoryItemListInfo.nearByCitySize;
    }

    static /* synthetic */ int b(ProjectFilterModel projectFilterModel, int i) {
        int i2 = projectFilterModel.f + i;
        projectFilterModel.f = i2;
        return i2;
    }

    static /* synthetic */ int d(ProjectFilterModel projectFilterModel) {
        int i = projectFilterModel.d;
        projectFilterModel.d = i + 1;
        return i;
    }

    static /* synthetic */ int f(ProjectFilterModel projectFilterModel, int i) {
        int i2 = projectFilterModel.g + i;
        projectFilterModel.g = i2;
        return i2;
    }

    static /* synthetic */ int h(ProjectFilterModel projectFilterModel) {
        int i = projectFilterModel.e;
        projectFilterModel.e = i + 1;
        return i;
    }

    private void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-491277")) {
            ipChange.ipc$dispatch("-491277", new Object[]{this});
            return;
        }
        this.d = 1;
        this.e = -1;
        this.f = 0;
        this.g = 0;
    }

    public void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-479022555")) {
            ipChange.ipc$dispatch("-479022555", new Object[]{this});
        } else {
            this.a.c();
        }
    }

    public void j(final boolean z, final OnModelBizListener onModelBizListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1305984654")) {
            ipChange.ipc$dispatch("-1305984654", new Object[]{this, Boolean.valueOf(z), onModelBizListener});
            return;
        }
        if (z) {
            k();
        }
        FilterReqParamBean obtainRequestParam = this.b.obtainRequestParam();
        final boolean z2 = this.e < 1;
        final boolean equals = TextUtils.equals("4", obtainRequestParam.sortType);
        CategoryRequestNewParams createReqParams = obtainRequestParam.createReqParams();
        if (z2) {
            createReqParams.pageIndex = this.d;
            createReqParams.cityOption = 0;
        } else {
            createReqParams.pageIndex = this.e;
            createReqParams.cityOption = 1;
        }
        TetrisRequest tetrisRequest = new TetrisRequest(createReqParams);
        TetrisRequest.overrideParams(tetrisRequest, this.c, obtainRequestParam.skipOverrideKeyList);
        DrObj drObj = new DrObj(this.h, this.i, tetrisRequest.args);
        tetrisRequest.dr = jn1.ARRAY_START_STR + JSON.toJSONString(drObj) + jn1.ARRAY_END_STR;
        this.a.a(tetrisRequest.request(new DMMtopRequestListener<BaseResponse>(BaseResponse.class) { // from class: cn.damai.tetris.componentplugin.ProjectFilterModel.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-987035957")) {
                    ipChange2.ipc$dispatch("-987035957", new Object[]{this, str, str2});
                } else {
                    onModelBizListener.onLoadProjectFail(z, str, str2);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(BaseResponse baseResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1781779549")) {
                    ipChange2.ipc$dispatch("1781779549", new Object[]{this, baseResponse});
                } else if (baseResponse == null) {
                    onFail("", "");
                } else {
                    baseResponse.isShowJuli = equals;
                    CategoryItemListInfo a = pg.a(baseResponse);
                    baseResponse.nearByCityListSize = ProjectFilterModel.this.f;
                    ProjectFilterModel.b(ProjectFilterModel.this, a.nearByCitySize);
                    boolean isCanRequestNextPage = a.isCanRequestNextPage(z2, ProjectFilterModel.this.d);
                    if (z2) {
                        boolean isCurrentCityEnd = a.isCurrentCityEnd(ProjectFilterModel.this.g);
                        ProjectFilterModel.d(ProjectFilterModel.this);
                        ProjectFilterModel.f(ProjectFilterModel.this, a.currentCitySize);
                        if (isCurrentCityEnd) {
                            ProjectFilterModel.this.e = a.nearByCitySize > 0 ? 2 : 1;
                        }
                    } else {
                        ProjectFilterModel.h(ProjectFilterModel.this);
                    }
                    onModelBizListener.onLoadProjectSuccess(new LoadData(z, isCanRequestNextPage, new db().f(baseResponse)));
                }
            }
        }));
    }
}
