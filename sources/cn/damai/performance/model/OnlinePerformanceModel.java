package cn.damai.performance.model;

import android.text.TextUtils;
import android.util.Pair;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.performance.bean.HeadAtmosphere;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.request.TetrisRequest;
import cn.damai.tetris.v2.common.ContainerArg;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tb.cb2;
import tb.xl2;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class OnlinePerformanceModel {
    private static transient /* synthetic */ IpChange $ipChange;
    private ContainerArg mArg;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface OnResListener<T> {
        void onFail(String str, String str2);

        void onSuccess(T t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HeadAtmosphere getAtmosphere(BaseResponse baseResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1906206294")) {
            return (HeadAtmosphere) ipChange.ipc$dispatch("-1906206294", new Object[]{this, baseResponse});
        }
        if (baseResponse != null) {
            ArrayList<BaseLayer> arrayList = baseResponse.layers;
            if (!cb2.d(arrayList)) {
                Iterator<BaseLayer> it = arrayList.iterator();
                loop0: while (it.hasNext()) {
                    List<BaseSection> sections = it.next().getSections();
                    if (!cb2.d(sections)) {
                        for (BaseSection baseSection : sections) {
                            if (TextUtils.equals(xl2.MUSIC_FESTIVAL_MAP_COMPONENT_ID, baseSection.getComponentId())) {
                                break loop0;
                            }
                        }
                        continue;
                    }
                }
            }
        }
        return null;
    }

    public void load(final OnResListener<Pair<BaseResponse, HeadAtmosphere>> onResListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-103839743")) {
            ipChange.ipc$dispatch("-103839743", new Object[]{this, onResListener});
            return;
        }
        TetrisRequest tetrisRequest = new TetrisRequest(new OnlinePerformanceParams(1));
        TetrisRequest.overrideParams(tetrisRequest, this.mArg);
        tetrisRequest.request(new DMMtopRequestListener<BaseResponse>(BaseResponse.class) { // from class: cn.damai.performance.model.OnlinePerformanceModel.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "755860749")) {
                    ipChange2.ipc$dispatch("755860749", new Object[]{this, str, str2});
                } else {
                    onResListener.onFail(str, str2);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(BaseResponse baseResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1546985435")) {
                    ipChange2.ipc$dispatch("1546985435", new Object[]{this, baseResponse});
                } else {
                    onResListener.onSuccess(new Pair(baseResponse, OnlinePerformanceModel.this.getAtmosphere(baseResponse)));
                }
            }
        });
    }

    public void setArg(ContainerArg containerArg) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "114686307")) {
            ipChange.ipc$dispatch("114686307", new Object[]{this, containerArg});
        } else {
            this.mArg = containerArg;
        }
    }
}
