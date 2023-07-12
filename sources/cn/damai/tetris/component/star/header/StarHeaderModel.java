package cn.damai.tetris.component.star.header;

import cn.damai.tetris.component.star.bean.StarHeaderData;
import cn.damai.tetris.component.star.header.StarHeaderContract;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class StarHeaderModel extends AbsModel implements StarHeaderContract.Model<BaseNode> {
    private static transient /* synthetic */ IpChange $ipChange;
    StarHeaderData headerData;
    int innerFragmentType;

    @Override // cn.damai.tetris.component.star.header.StarHeaderContract.Model
    public StarHeaderData getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-245576040") ? (StarHeaderData) ipChange.ipc$dispatch("-245576040", new Object[]{this}) : this.headerData;
    }

    @Override // cn.damai.tetris.component.star.header.StarHeaderContract.Model
    public int getFragmentType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1944558456") ? ((Integer) ipChange.ipc$dispatch("-1944558456", new Object[]{this})).intValue() : this.innerFragmentType;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-756051654")) {
            ipChange.ipc$dispatch("-756051654", new Object[]{this, baseNode});
            return;
        }
        try {
            this.headerData = (StarHeaderData) JSON.parseObject(baseNode.getItem().toJSONString(), StarHeaderData.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // cn.damai.tetris.component.star.header.StarHeaderContract.Model
    public void setData(StarHeaderData starHeaderData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1928609920")) {
            ipChange.ipc$dispatch("-1928609920", new Object[]{this, starHeaderData});
        } else {
            this.headerData = starHeaderData;
        }
    }

    @Override // cn.damai.tetris.component.star.header.StarHeaderContract.Model
    public void setFragmentType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1695468006")) {
            ipChange.ipc$dispatch("-1695468006", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.innerFragmentType = i;
        }
    }
}
