package cn.damai.discover.main.ui.model;

import android.text.TextUtils;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.home.bean.HomeContentFloatBean;
import cn.damai.commonbusiness.wannasee.bean.PageData;
import cn.damai.commonbusiness.wannasee.listener.OnBizListener;
import cn.damai.commonbusiness.wannasee.model.AbsModel;
import cn.damai.discover.main.bean.ReadBean;
import cn.damai.discover.main.bean.ReadContent;
import cn.damai.discover.main.request.BoxReadClearRequest;
import cn.damai.discover.main.request.BoxReadRequest;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.request.DiscoverRecParams;
import cn.damai.tetris.request.TetrisRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import java.util.HashMap;
import tb.C9039db;
import tb.cb1;
import tb.ir1;
import tb.m61;
import tb.mr1;
import tb.z20;
import tb.z91;
import tb.zr;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class RecommendModel extends AbsModel {
    private static transient /* synthetic */ IpChange $ipChange;
    private HomeContentFloatBean.Data mHighLightCard;
    private int pageNo = 1;

    /* JADX INFO: Access modifiers changed from: private */
    public void alarm(TetrisRequest tetrisRequest, String str, String str2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-772401125")) {
            ipChange.ipc$dispatch("-772401125", new Object[]{this, tetrisRequest, str, str2, Boolean.valueOf(z)});
        } else if (tetrisRequest != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("usercode", z20.i());
            hashMap.put("city", z20.d());
            hashMap.put("args", tetrisRequest.args);
            zr.INSTANCE.a().a(tetrisRequest.getApiName()).c(str).d(str2).e(hashMap).h(tetrisRequest.patternName).i(tetrisRequest.patternVersion).g("现场主页推荐").j("live").f(z).b();
        }
    }

    public void clearRead(ReadContent readContent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1262704483")) {
            ipChange.ipc$dispatch("1262704483", new Object[]{this, readContent});
        } else if (readContent == null) {
        } else {
            new BoxReadClearRequest(readContent.id).request(new DMMtopRequestListener<Object>(Object.class) { // from class: cn.damai.discover.main.ui.model.RecommendModel.4
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1662344769")) {
                        ipChange2.ipc$dispatch("-1662344769", new Object[]{this, str, str2});
                    }
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(Object obj) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "205925850")) {
                        ipChange2.ipc$dispatch("205925850", new Object[]{this, obj});
                    }
                }
            });
        }
    }

    public void load(final boolean z, final OnBizListener<PageData<BaseResponse>> onBizListener) {
        String str;
        HomeContentFloatBean.Data data;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1693480344")) {
            ipChange.ipc$dispatch("-1693480344", new Object[]{this, Boolean.valueOf(z), onBizListener});
            return;
        }
        String str2 = null;
        if (!z || (data = this.mHighLightCard) == null) {
            str = null;
        } else {
            str2 = data.type;
            str = data.id;
        }
        DiscoverRecParams discoverRecParams = new DiscoverRecParams(this.pageNo + "", str2, str) { // from class: cn.damai.discover.main.ui.model.RecommendModel.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.tetris.request.DiscoverRecParams, cn.damai.tetris.request.TetrisParams
            public String getVersion() {
                IpChange ipChange2 = $ipChange;
                return AndroidInstantRuntime.support(ipChange2, "10457469") ? (String) ipChange2.ipc$dispatch("10457469", new Object[]{this}) : "2.1";
            }
        };
        if (ir1.i(mr1.LOCATION)) {
            discoverRecParams.latitude = z20.n() + "";
            discoverRecParams.longitude = z20.o() + "";
        }
        final TetrisRequest tetrisRequest = new TetrisRequest(discoverRecParams);
        this.mHolder.a(tetrisRequest.request(new DMMtopRequestListener<BaseResponse>(BaseResponse.class) { // from class: cn.damai.discover.main.ui.model.RecommendModel.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str3, String str4) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1646826051")) {
                    ipChange2.ipc$dispatch("-1646826051", new Object[]{this, str3, str4});
                    return;
                }
                onBizListener.onBizFail(str3, str4);
                if (z) {
                    RecommendModel.this.alarm(tetrisRequest, str3, str4, false);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(BaseResponse baseResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1564143317")) {
                    ipChange2.ipc$dispatch("-1564143317", new Object[]{this, baseResponse});
                    return;
                }
                if (z) {
                    RecommendModel.this.mHighLightCard = null;
                }
                if (baseResponse != null) {
                    C9039db.d(baseResponse, z91.q());
                    onBizListener.onBizSuccess(PageData.success(z, C9039db.k(baseResponse), baseResponse));
                    if (z) {
                        RecommendModel.this.alarm(tetrisRequest, "2000", JSMethod.NOT_SET, true);
                        return;
                    }
                    return;
                }
                onFail("", "");
            }
        }));
    }

    public void loadRead(final OnBizListener<ReadContent> onBizListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-815437746")) {
            ipChange.ipc$dispatch("-815437746", new Object[]{this, onBizListener});
        } else {
            this.mHolder.a(new BoxReadRequest().request(new DMMtopRequestListener<ReadBean>(ReadBean.class) { // from class: cn.damai.discover.main.ui.model.RecommendModel.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1654585410")) {
                        ipChange2.ipc$dispatch("-1654585410", new Object[]{this, str, str2});
                        return;
                    }
                    cb1.c("RecModel", "code=" + str + " msg=" + str2);
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(ReadBean readBean) {
                    ReadContent firstReadCount;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "341768692")) {
                        ipChange2.ipc$dispatch("341768692", new Object[]{this, readBean});
                    } else if (readBean == null || !readBean.success() || !readBean.isNoteRecommendValid() || (firstReadCount = readBean.getFirstReadCount()) == null) {
                    } else {
                        onBizListener.onBizSuccess(firstReadCount);
                    }
                }
            }));
        }
    }

    public void setHighLightCard(String str) {
        HomeContentFloatBean.Data data;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "729921760")) {
            ipChange.ipc$dispatch("729921760", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str) || (data = (HomeContentFloatBean.Data) m61.a(str, HomeContentFloatBean.Data.class)) == null || !data.isValid()) {
        } else {
            this.mHighLightCard = data;
        }
    }
}
