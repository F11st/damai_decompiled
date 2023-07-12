package cn.damai.ticklet.ui.activity;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import cn.damai.ticklet.bean.TicketDeatilResult;
import cn.damai.ticklet.bean.TicketSouvenirDetail;
import cn.damai.ticklet.bean.TicketSouvenirInfo;
import cn.damai.ticklet.bean.TicketSouvenirPaperBean;
import cn.damai.ticklet.bean.TicketSouvenirParams;
import cn.damai.ticklet.inteface.SimpleCallBack;
import cn.damai.ticklet.model.TicketSouvenirModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.xn2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TicketSouvenirViewModel extends ViewModel implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private final TicketSouvenirModel mSouvenirModel;
    private TicketSouvenirParams mTicketSouvenirParams;
    public final MutableLiveData<TicketSouvenirDetail> mSouvenirLiveData = new MutableLiveData<>();
    public final MutableLiveData<String> mNetLiveData = new MutableLiveData<>();

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements SimpleCallBack<TicketSouvenirPaperBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.ticklet.inteface.SimpleCallBack
        /* renamed from: a */
        public void onSuccess(TicketSouvenirPaperBean ticketSouvenirPaperBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1852258425")) {
                ipChange.ipc$dispatch("-1852258425", new Object[]{this, ticketSouvenirPaperBean});
            } else if (ticketSouvenirPaperBean == null) {
                TicketSouvenirViewModel.this.mNetLiveData.setValue("");
            } else {
                TicketSouvenirViewModel.this.mSouvenirLiveData.setValue(ticketSouvenirPaperBean.result);
            }
        }

        @Override // cn.damai.ticklet.inteface.SimpleCallBack
        public void onFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2071664687")) {
                ipChange.ipc$dispatch("-2071664687", new Object[]{this, str, str2});
                return;
            }
            TicketSouvenirViewModel.this.reportSouvenirDetailInterfaceXFlushErro(str, str2);
            TicketSouvenirViewModel.this.mNetLiveData.setValue(str2);
        }
    }

    public TicketSouvenirViewModel(@NonNull TicketSouvenirParams ticketSouvenirParams) {
        this.mTicketSouvenirParams = ticketSouvenirParams;
        this.mSouvenirModel = new TicketSouvenirModel(ticketSouvenirParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportSouvenirDetailInterfaceXFlushErro(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-418866666")) {
            ipChange.ipc$dispatch("-418866666", new Object[]{this, str, str2});
            return;
        }
        TicketSouvenirParams ticketSouvenirParams = this.mTicketSouvenirParams;
        if (ticketSouvenirParams != null) {
            xn2.d(xn2.i(xn2.TICKLET_SOUVENIR_DETAIL_API, "mtop.damai.wireless.ticklet2.souvenir.detail.get", str, str2, ticketSouvenirParams.performId), xn2.TICKLET_SOUVENIR_DETAIL_ERROR_CODE, str, xn2.TICKLET_SOUVENIR_DETAIL_ERROR_MSG);
        }
    }

    public TicketSouvenirParams getParams() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-853738160") ? (TicketSouvenirParams) ipChange.ipc$dispatch("-853738160", new Object[]{this}) : this.mSouvenirModel.getResult();
    }

    public TicketSouvenirInfo getSouvenirInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "680395711")) {
            return (TicketSouvenirInfo) ipChange.ipc$dispatch("680395711", new Object[]{this});
        }
        TicketSouvenirDetail value = this.mSouvenirLiveData.getValue();
        if (value == null) {
            return null;
        }
        return value.souvenirVO;
    }

    public boolean isNormalState() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-207063135") ? ((Boolean) ipChange.ipc$dispatch("-207063135", new Object[]{this})).booleanValue() : this.mSouvenirModel.isNormalState();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "683266064")) {
            ipChange.ipc$dispatch("683266064", new Object[]{this});
        } else {
            super.onCleared();
        }
    }

    public void start() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1167282267")) {
            ipChange.ipc$dispatch("1167282267", new Object[]{this});
        } else {
            this.mSouvenirModel.loadSouvenirDetail(new a());
        }
    }

    public TicketDeatilResult transferDetailResult4Layer() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1830141381") ? (TicketDeatilResult) ipChange.ipc$dispatch("-1830141381", new Object[]{this}) : this.mSouvenirModel.transferDetailResult4Layer();
    }
}
