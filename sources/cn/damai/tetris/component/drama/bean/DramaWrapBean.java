package cn.damai.tetris.component.drama.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tb.cb2;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class DramaWrapBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public CardTitleBean mTitleBean;
    public List<DramaMonthBean> result;

    public void computeScrollPos() {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1694875228")) {
            ipChange.ipc$dispatch("1694875228", new Object[]{this});
        } else if (!cb2.d(this.result)) {
            for (DramaMonthBean dramaMonthBean : this.result) {
                dramaMonthBean.headPosInTotalList = i;
                i += wh2.e(dramaMonthBean.content);
            }
        }
    }

    public List<DramaV1Bean> getTotalList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "416303975")) {
            return (List) ipChange.ipc$dispatch("416303975", new Object[]{this});
        }
        ArrayList arrayList = new ArrayList();
        if (!cb2.d(this.result)) {
            for (DramaMonthBean dramaMonthBean : this.result) {
                if (!cb2.d(dramaMonthBean.content)) {
                    arrayList.addAll(dramaMonthBean.content);
                }
            }
        }
        return arrayList;
    }

    public boolean itemListHasIpvuv() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "424551113")) {
            return ((Boolean) ipChange.ipc$dispatch("424551113", new Object[]{this})).booleanValue();
        }
        if (!cb2.d(this.result)) {
            for (DramaMonthBean dramaMonthBean : this.result) {
                List<DramaV1Bean> list = dramaMonthBean.content;
                if (!cb2.d(list)) {
                    for (DramaV1Bean dramaV1Bean : list) {
                        if (!TextUtils.isEmpty(dramaV1Bean.ipvuv)) {
                            return true;
                        }
                    }
                    continue;
                }
            }
        }
        return false;
    }

    public void utParamsInset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1422258682")) {
            ipChange.ipc$dispatch("-1422258682", new Object[]{this});
        } else if (!cb2.d(this.result)) {
            int i = 0;
            for (DramaMonthBean dramaMonthBean : this.result) {
                String str = dramaMonthBean.labelName;
                List<DramaV1Bean> list = dramaMonthBean.content;
                if (!cb2.d(list)) {
                    int i2 = 0;
                    for (DramaV1Bean dramaV1Bean : list) {
                        dramaV1Bean.tempLabelName = str;
                        dramaV1Bean.tabIndex = i;
                        dramaV1Bean.indexInTab = i2;
                        i2++;
                    }
                }
                i++;
            }
        }
    }
}
