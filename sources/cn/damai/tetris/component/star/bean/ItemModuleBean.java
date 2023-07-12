package cn.damai.tetris.component.star.bean;

import android.text.TextUtils;
import cn.damai.tetris.component.star.bean.ModuleTitleModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ItemModuleBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int ID_PRODUCT_MODULE = 2;
    public String detailUrl;
    public List<GoodBean> goods;
    public String myOrderUrl;
    public String shopUrl;
    public String title;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class GoodBean implements Serializable {
        public String desc;
        public long goodId;
        public String goodName;
        public String goodUrl;
        public String pic;
        public String price;

        public GoodBean() {
        }
    }

    public List<ModuleTitleModel.OperationBean> getOptionList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1906893017")) {
            return (List) ipChange.ipc$dispatch("1906893017", new Object[]{this});
        }
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(this.myOrderUrl)) {
            ModuleTitleModel.OperationBean operationBean = new ModuleTitleModel.OperationBean();
            operationBean.opName = "我的订单";
            operationBean.opUrl = this.myOrderUrl;
            operationBean.moduleId = 2;
            arrayList.add(operationBean);
        }
        if (!TextUtils.isEmpty(this.shopUrl)) {
            ModuleTitleModel.OperationBean operationBean2 = new ModuleTitleModel.OperationBean();
            operationBean2.opName = "全部";
            operationBean2.opUrl = this.shopUrl;
            operationBean2.moduleId = 2;
            arrayList.add(operationBean2);
        }
        return arrayList;
    }
}
