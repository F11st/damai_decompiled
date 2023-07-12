package cn.damai.common.net.mtop.netfit;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import mtopsdk.mtop.domain.BaseOutDo;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class DMMtopResultBaseData {

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public static class BaseMtopResponseData extends BaseOutDo {
        private static transient /* synthetic */ IpChange $ipChange;
        private ResultData data;

        public void setData(ResultData resultData) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1505151811")) {
                ipChange.ipc$dispatch("-1505151811", new Object[]{this, resultData});
            } else {
                this.data = resultData;
            }
        }

        @Override // mtopsdk.mtop.domain.BaseOutDo
        public ResultData getData() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-638683077") ? (ResultData) ipChange.ipc$dispatch("-638683077", new Object[]{this}) : this.data;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public static class ResultData implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange;
        public String result;

        public String getResult() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-56275335") ? (String) ipChange.ipc$dispatch("-56275335", new Object[]{this}) : this.result;
        }

        public void setResult(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1155339909")) {
                ipChange.ipc$dispatch("1155339909", new Object[]{this, str});
            } else {
                this.result = str;
            }
        }
    }
}
