package cn.damai.tetris.component.brand;

import cn.damai.tetris.component.brand.BrandIpContract;
import cn.damai.tetris.component.brand.bean.BrandInfoBean;
import cn.damai.tetris.component.brand.bean.IpBean;
import cn.damai.tetris.component.brand.bean.IpBrandResult;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class BrandIpModel extends AbsModel implements BrandIpContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    BrandInfoBean brand;
    ArrayList<IpBean> ipBeanList;

    @Override // cn.damai.tetris.component.brand.BrandIpContract.Model
    public ArrayList<IpBean> getBeanList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1831610971") ? (ArrayList) ipChange.ipc$dispatch("1831610971", new Object[]{this}) : this.ipBeanList;
    }

    @Override // cn.damai.tetris.component.brand.BrandIpContract.Model
    public BrandInfoBean getBrandInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-987105692") ? (BrandInfoBean) ipChange.ipc$dispatch("-987105692", new Object[]{this}) : this.brand;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-427270678")) {
            ipChange.ipc$dispatch("-427270678", new Object[]{this, baseNode});
            return;
        }
        try {
            IpBrandResult ipBrandResult = (IpBrandResult) JSON.parseObject(baseNode.getItem().toJSONString(), IpBrandResult.class);
            this.brand = ipBrandResult.brand;
            this.ipBeanList = ipBrandResult.ipLists;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
