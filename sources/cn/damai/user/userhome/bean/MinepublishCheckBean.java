package cn.damai.user.userhome.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.HashSet;
import tb.nm1;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class MinepublishCheckBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TYPE_SHOW_PRIVILEGE_AND_PENDING_VALUATION = "3";
    public static final String TYPE_SHOW_PUBLISH_HAS_PENDING_VALUATION = "2";
    public static final String TYPE_SHOW_PUBLISH_PRIVILEGE = "1";
    public String appPublishHint;
    public String headerImage;
    public boolean login;
    public String publishType;

    private HashSet<String> getTypeCanShowPublish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "665203457")) {
            return (HashSet) ipChange.ipc$dispatch("665203457", new Object[]{this});
        }
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("1");
        hashSet.add("2");
        hashSet.add("3");
        return hashSet;
    }

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1592596939")) {
            return ((Boolean) ipChange.ipc$dispatch("-1592596939", new Object[]{this, obj})).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MinepublishCheckBean minepublishCheckBean = (MinepublishCheckBean) obj;
        return this.login == minepublishCheckBean.login && nm1.a(this.publishType, minepublishCheckBean.publishType) && nm1.a(this.headerImage, minepublishCheckBean.headerImage) && nm1.a(this.appPublishHint, minepublishCheckBean.appPublishHint);
    }

    public int hashCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1470897172") ? ((Integer) ipChange.ipc$dispatch("-1470897172", new Object[]{this})).intValue() : nm1.b(this.publishType, this.headerImage, this.appPublishHint, Boolean.valueOf(this.login));
    }

    public boolean isNeedShowPublishBtn() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1987373198")) {
            return ((Boolean) ipChange.ipc$dispatch("1987373198", new Object[]{this})).booleanValue();
        }
        if (TextUtils.isEmpty(this.publishType)) {
            return false;
        }
        return getTypeCanShowPublish().contains(this.publishType);
    }
}
