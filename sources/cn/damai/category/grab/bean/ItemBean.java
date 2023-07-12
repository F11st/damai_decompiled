package cn.damai.category.grab.bean;

import android.text.TextUtils;
import cn.damai.commonbusiness.search.bean.MarketTabBase;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ItemBean extends MarketTabBase {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 5875813656692633576L;
    public String categoryName;
    public String cityName;
    public long countdownTime;
    public String groupTip;
    public String groupTitle;
    public String guideSubCategoryName;
    public int index;
    public String ipvuv;
    public String itemId;
    public String name;
    public String onSaleTime;
    public String priceLow;
    public String schema;
    public String showTime;
    public int status;
    public int tabChecked;
    public List<String> tabs;
    public String title;
    public String venueName;
    public String verticalPic;
    public int group = 0;
    public int groupIndex = 0;
    public int groupType = 0;

    public String getCategoryNameCompat() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1564139169")) {
            return (String) ipChange.ipc$dispatch("1564139169", new Object[]{this});
        }
        if (!TextUtils.isEmpty(this.guideSubCategoryName)) {
            return this.guideSubCategoryName;
        }
        return this.categoryName;
    }
}
