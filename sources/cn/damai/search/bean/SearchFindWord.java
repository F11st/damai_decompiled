package cn.damai.search.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class SearchFindWord {
    private static transient /* synthetic */ IpChange $ipChange;
    public int action;
    public String alg;
    public String keyword;
    public String pic;
    public int pos;
    public String reason;
    public String type;
    public String url;
    public String wordType;

    public int getLabelType() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-215571626")) {
            return ((Integer) ipChange.ipc$dispatch("-215571626", new Object[]{this})).intValue();
        }
        if (TextUtils.isEmpty(this.reason)) {
            return 0;
        }
        if ("新".equals(this.reason)) {
            return 1;
        }
        if ("热".equals(this.reason)) {
            return 2;
        }
        return "爆".equals(this.reason) ? 3 : 0;
    }

    public boolean isOperate() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1367754105") ? ((Boolean) ipChange.ipc$dispatch("1367754105", new Object[]{this})).booleanValue() : !TextUtils.isEmpty(this.wordType) && "1".equals(this.wordType);
    }

    public boolean isPicItem() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "250293408") ? ((Boolean) ipChange.ipc$dispatch("250293408", new Object[]{this})).booleanValue() : TextUtils.equals("2", this.type) && !TextUtils.isEmpty(this.pic);
    }

    public boolean isUrlWord() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1905329724") ? ((Boolean) ipChange.ipc$dispatch("-1905329724", new Object[]{this})).booleanValue() : this.action == 2;
    }
}
