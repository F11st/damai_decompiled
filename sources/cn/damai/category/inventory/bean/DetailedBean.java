package cn.damai.category.inventory.bean;

import android.text.TextUtils;
import cn.damai.category.ranking.bean.ItemBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class DetailedBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String bgPic;
    public String followStatus;
    public List<ItemBean> items;
    public String shareIcon;
    public String shareUrl;
    public String subTitle;
    public String title;
    public List<ItemBean> topItems;

    public boolean isFollow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "891771996")) {
            return ((Boolean) ipChange.ipc$dispatch("891771996", new Object[]{this})).booleanValue();
        }
        if (TextUtils.isEmpty(this.followStatus)) {
            return false;
        }
        return this.followStatus.equals("1") || this.followStatus.equals("2");
    }
}
