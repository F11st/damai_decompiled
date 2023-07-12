package cn.damai.commonbusiness.discover.bean;

import cn.damai.tetris.component.drama.bean.CardTitleBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class HeadFixedWrapBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public List<HeadFixedBean> circleList = new ArrayList();
    public List<HeadFixedBean> commentList = new ArrayList();
    public CardTitleBean mTitleBean;
    public List<HeadFixedBean> markets;
    public int pos;

    private boolean isComment(HeadFixedBean headFixedBean) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1574754441") ? ((Boolean) ipChange.ipc$dispatch("-1574754441", new Object[]{this, headFixedBean})).booleanValue() : headFixedBean.type != 0;
    }

    public void handleData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1231105687")) {
            ipChange.ipc$dispatch("1231105687", new Object[]{this});
            return;
        }
        List<HeadFixedBean> list = this.markets;
        if (list == null || list.size() == 0) {
            return;
        }
        for (int i = 0; i < this.markets.size(); i++) {
            if (isComment(this.markets.get(i))) {
                this.commentList.add(this.markets.get(i));
            } else {
                this.circleList.add(this.markets.get(i));
            }
        }
    }
}
