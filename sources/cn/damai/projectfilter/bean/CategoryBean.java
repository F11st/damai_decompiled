package cn.damai.projectfilter.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class CategoryBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public boolean isSelected;
    public String name;
    public String value;

    public CategoryBean() {
        this.isSelected = false;
    }

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1208803958")) {
            return ((Boolean) ipChange.ipc$dispatch("-1208803958", new Object[]{this, obj})).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return TextUtils.equals(this.value, ((CategoryBean) obj).value);
    }

    public CategoryBean(String str, String str2) {
        this.isSelected = false;
        this.value = str;
        this.name = str2;
    }

    public CategoryBean(String str, String str2, boolean z) {
        this.isSelected = false;
        this.name = str;
        this.value = str2;
        this.isSelected = z;
    }
}
