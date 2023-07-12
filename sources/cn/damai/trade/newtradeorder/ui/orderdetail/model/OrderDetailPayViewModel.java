package cn.damai.trade.newtradeorder.ui.orderdetail.model;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailPayInfo;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailPayList;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderPayDTO;
import cn.damai.trade.newtradeorder.ui.orderdetail.helper.OrderPayListener;
import cn.damai.trade.oldtradeorder.ui.orderdetail.detail.model.OrderParmasResult;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class OrderDetailPayViewModel extends AndroidViewModel implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isCoupon;
    private boolean isHouNiaoOrder;
    private boolean isSeatProject;
    private String mAmount;
    private String mOrderId;
    private String mProjectId;
    private List<OrderDetailPayInfo> orderDetailPayList;
    private MutableLiveData<OrderDetailPayInfo> payChangeLiveData;
    private OrderDetailPayRepository repository;
    private OrderDetailPayInfo selectPayInfo;

    public OrderDetailPayViewModel(@NonNull Application application) {
        super(application);
        this.payChangeLiveData = new MutableLiveData<>();
        this.repository = new OrderDetailPayRepository();
    }

    public String getAmount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "344028054")) {
            return (String) ipChange.ipc$dispatch("344028054", new Object[]{this});
        }
        String str = this.mAmount;
        return str == null ? "" : str;
    }

    public String getOrderId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "586819905") ? (String) ipChange.ipc$dispatch("586819905", new Object[]{this}) : this.mOrderId;
    }

    public MutableLiveData<OrderDetailPayInfo> getPayChangeLiveData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1769877318") ? (MutableLiveData) ipChange.ipc$dispatch("-1769877318", new Object[]{this}) : this.payChangeLiveData;
    }

    public List<OrderDetailPayInfo> getPayInfoList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-360824301") ? (List) ipChange.ipc$dispatch("-360824301", new Object[]{this}) : this.orderDetailPayList;
    }

    public String getProjectId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2051845004") ? (String) ipChange.ipc$dispatch("2051845004", new Object[]{this}) : this.mProjectId;
    }

    public OrderDetailPayInfo getSelectPayInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-229229559") ? (OrderDetailPayInfo) ipChange.ipc$dispatch("-229229559", new Object[]{this}) : this.selectPayInfo;
    }

    public void initParam(Intent intent) {
        Bundle extras;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-460874600")) {
            ipChange.ipc$dispatch("-460874600", new Object[]{this, intent});
        } else if (intent == null || (extras = intent.getExtras()) == null) {
        } else {
            if (extras.containsKey("payList")) {
                updatePayList(extras.getParcelableArrayList("payList"));
            }
            if (extras.containsKey("isHouNiaoOrder")) {
                this.isHouNiaoOrder = extras.getBoolean("isHouNiaoOrder", false);
            }
            if (extras.containsKey("amount")) {
                this.mAmount = extras.getString("amount", "");
            }
            if (extras.containsKey("projectId")) {
                this.mProjectId = extras.getString("projectId", "0");
            }
            if (extras.containsKey("isSeat")) {
                this.isSeatProject = extras.getBoolean("isSeat", false);
            }
            if (extras.containsKey("isCoupon")) {
                this.isCoupon = extras.getBoolean("isCoupon", false);
            }
            this.mOrderId = extras.getString("orderId", "0");
        }
    }

    public boolean isCoupon() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "130171462") ? ((Boolean) ipChange.ipc$dispatch("130171462", new Object[]{this})).booleanValue() : this.isCoupon;
    }

    public boolean isHouNiaoOrder() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2021886571") ? ((Boolean) ipChange.ipc$dispatch("-2021886571", new Object[]{this})).booleanValue() : this.isHouNiaoOrder;
    }

    public boolean isSeatProject() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "834516178") ? ((Boolean) ipChange.ipc$dispatch("834516178", new Object[]{this})).booleanValue() : this.isSeatProject;
    }

    public void requestHNOrderPay(DMMtopRequestListener<OrderPayDTO> dMMtopRequestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1022110165")) {
            ipChange.ipc$dispatch("1022110165", new Object[]{this, dMMtopRequestListener});
            return;
        }
        OrderDetailPayInfo orderDetailPayInfo = this.selectPayInfo;
        if (orderDetailPayInfo == null || dMMtopRequestListener == null) {
            return;
        }
        this.repository.requestOrderDetailPay(this.mOrderId, orderDetailPayInfo.payCode, orderDetailPayInfo.paymentInfoExt, dMMtopRequestListener);
    }

    public void requestHNOrderPayList(OrderDetailPayInfo orderDetailPayInfo, DMMtopRequestListener<OrderDetailPayList> dMMtopRequestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "97748894")) {
            ipChange.ipc$dispatch("97748894", new Object[]{this, orderDetailPayInfo, dMMtopRequestListener});
        } else if (orderDetailPayInfo == null || dMMtopRequestListener == null) {
        } else {
            this.repository.requestOrderDetailPayList(this.mOrderId, orderDetailPayInfo.payCode, orderDetailPayInfo.paymentInfoExt, dMMtopRequestListener);
        }
    }

    public void requestSelfOrderPay(OrderPayListener<OrderParmasResult> orderPayListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1752217679")) {
            ipChange.ipc$dispatch("1752217679", new Object[]{this, orderPayListener});
            return;
        }
        OrderDetailPayInfo orderDetailPayInfo = this.selectPayInfo;
        if (orderDetailPayInfo == null || orderPayListener == null) {
            return;
        }
        this.repository.requestOrderDetailSelfPay(this.mOrderId, orderDetailPayInfo.payCode, orderPayListener);
    }

    public void setZLSelectPayInfo(OrderDetailPayInfo orderDetailPayInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1650300543")) {
            ipChange.ipc$dispatch("1650300543", new Object[]{this, orderDetailPayInfo});
        } else if (orderDetailPayInfo != null) {
            this.selectPayInfo = orderDetailPayInfo;
            int e = wh2.e(this.orderDetailPayList);
            for (int i = 0; i < e; i++) {
                if (this.orderDetailPayList.get(i).payTypeId == this.selectPayInfo.payTypeId && this.orderDetailPayList.get(i).payCode.equals(this.selectPayInfo.payCode)) {
                    this.orderDetailPayList.get(i).isSelected = true;
                } else {
                    this.orderDetailPayList.get(i).isSelected = false;
                }
            }
        }
    }

    public void updatePayList(List<OrderDetailPayInfo> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1806283852")) {
            ipChange.ipc$dispatch("1806283852", new Object[]{this, list});
            return;
        }
        int e = wh2.e(list);
        if (e == 0) {
            return;
        }
        OrderDetailPayInfo orderDetailPayInfo = null;
        for (int i = 0; i < e; i++) {
            if (list.get(i).isSelected || list.get(i).selected) {
                orderDetailPayInfo = list.get(i);
                orderDetailPayInfo.isSelected = orderDetailPayInfo.selected || orderDetailPayInfo.isSelected;
            }
        }
        if (e > 0 && orderDetailPayInfo == null) {
            list.get(0).isSelected = true;
            orderDetailPayInfo = list.get(0);
        }
        this.orderDetailPayList = list;
        this.selectPayInfo = orderDetailPayInfo;
    }
}
