package cn.damai.ultron.secondpage.notice.net;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.ultron.secondpage.notice.bean.DmNoteListBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class DmPurchaseNoticeViewModel extends AndroidViewModel implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private String currentIndex;
    private String isConform;
    private String mItemId;
    private MutableLiveData<DmNoteListBean> mPayResultLiveData;
    private DmPurchaseNoticeRepository mRepository;

    public DmPurchaseNoticeViewModel(@NonNull Application application) {
        super(application);
        this.isConform = "false";
        this.mPayResultLiveData = new MutableLiveData<>();
        this.mRepository = new DmPurchaseNoticeRepository();
    }

    public int getCurrentIndex() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-159836148")) {
            return ((Integer) ipChange.ipc$dispatch("-159836148", new Object[]{this})).intValue();
        }
        try {
            return Integer.valueOf(this.currentIndex).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    public String getItemId(Intent intent) {
        Bundle extras;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "656459263")) {
            return (String) ipChange.ipc$dispatch("656459263", new Object[]{this, intent});
        }
        if (intent != null && (extras = intent.getExtras()) != null) {
            this.mItemId = extras.getString("itemId", "");
            this.currentIndex = extras.getString("index", "0");
            this.isConform = extras.getString("conform", "true");
        }
        return this.mItemId;
    }

    public MutableLiveData<DmNoteListBean> getNoticeLiveData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1194166704") ? (MutableLiveData) ipChange.ipc$dispatch("1194166704", new Object[]{this}) : this.mPayResultLiveData;
    }

    public boolean isConform() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1398901712") ? ((Boolean) ipChange.ipc$dispatch("1398901712", new Object[]{this})).booleanValue() : !TextUtils.isEmpty(this.isConform) && this.isConform.equals("true");
    }

    public void queryNoticeData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1569910274")) {
            ipChange.ipc$dispatch("-1569910274", new Object[]{this});
        } else {
            this.mRepository.queryPurchaseNoticeInfo(this.mItemId, new DMMtopRequestListener<DmNoteListBean>(DmNoteListBean.class) { // from class: cn.damai.ultron.secondpage.notice.net.DmPurchaseNoticeViewModel.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "971390438")) {
                        ipChange2.ipc$dispatch("971390438", new Object[]{this, str, str2});
                        return;
                    }
                    DmNoteListBean dmNoteListBean = new DmNoteListBean();
                    dmNoteListBean.requestSuccess = false;
                    dmNoteListBean.requestFailMsg = str2;
                    DmPurchaseNoticeViewModel.this.mPayResultLiveData.setValue(dmNoteListBean);
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(DmNoteListBean dmNoteListBean) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "51861101")) {
                        ipChange2.ipc$dispatch("51861101", new Object[]{this, dmNoteListBean});
                        return;
                    }
                    DmNoteListBean dmNoteListBean2 = new DmNoteListBean();
                    if (dmNoteListBean == null) {
                        dmNoteListBean2.requestSuccess = false;
                    } else {
                        dmNoteListBean2.requestSuccess = true;
                        dmNoteListBean2.noticeList = dmNoteListBean.noticeList;
                    }
                    DmPurchaseNoticeViewModel.this.mPayResultLiveData.setValue(dmNoteListBean2);
                }
            });
        }
    }

    public String getItemId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1641730020") ? (String) ipChange.ipc$dispatch("-1641730020", new Object[]{this}) : this.mItemId;
    }
}
