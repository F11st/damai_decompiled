package cn.damai.issue.bean;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class DraftExtra implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String imageUrl;
    public String privilegeType;
    public String projectName;
    public String targetId;
    public String themeName;
    public String timeAddress;

    public DraftExtra() {
    }

    @JSONField(deserialize = false, serialize = false)
    public boolean isValid() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1075139050") ? ((Boolean) ipChange.ipc$dispatch("1075139050", new Object[]{this})).booleanValue() : !TextUtils.isEmpty(this.targetId);
    }

    public DraftExtra(DraftExtra draftExtra) {
        this.targetId = draftExtra.targetId;
        this.projectName = draftExtra.projectName;
        this.imageUrl = draftExtra.imageUrl;
        this.timeAddress = draftExtra.timeAddress;
        this.privilegeType = draftExtra.privilegeType;
        this.themeName = draftExtra.themeName;
    }

    public DraftExtra(String str) {
        this.themeName = str;
    }

    public DraftExtra(String str, String str2, String str3, String str4, String str5, String str6) {
        this.targetId = str;
        this.projectName = str2;
        this.imageUrl = str3;
        this.timeAddress = str4;
        this.privilegeType = str5;
        this.themeName = str6;
    }
}
