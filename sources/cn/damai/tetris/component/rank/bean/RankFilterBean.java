package cn.damai.tetris.component.rank.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import tb.cb2;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class RankFilterBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public List<CategoryTabBean> categoryTabs;
    private boolean isFormat = false;
    public List<TypeTabBean> subTypeTabs;

    public void ensureFormatBeanOneTime() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-710766358")) {
            ipChange.ipc$dispatch("-710766358", new Object[]{this});
        } else if (!this.isFormat) {
            this.isFormat = true;
            if (cb2.d(this.categoryTabs)) {
                return;
            }
            int size = this.categoryTabs.size();
            for (int i = 0; i < size; i++) {
                CategoryTabBean categoryTabBean = this.categoryTabs.get(i);
                categoryTabBean.pos = i;
                List<TypeTabBean> list = categoryTabBean.subTypeList;
                if (!cb2.d(this.subTypeTabs)) {
                    int size2 = this.subTypeTabs.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        TypeTabBean typeTabBean = this.subTypeTabs.get(i2);
                        if (!cb2.d(typeTabBean.parentId) && typeTabBean.parentId.contains(categoryTabBean.id)) {
                            TypeTabBean typeTabBean2 = (TypeTabBean) typeTabBean.clone();
                            typeTabBean2.pos = list.size();
                            list.add(typeTabBean2);
                        }
                    }
                }
            }
        }
    }
}
