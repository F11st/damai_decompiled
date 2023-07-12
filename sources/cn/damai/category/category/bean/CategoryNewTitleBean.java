package cn.damai.category.category.bean;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class CategoryNewTitleBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 2539644363548998118L;
    public String args;
    public String categoryId;
    public String id;
    public int index;
    public int isShowFilter;
    public String name;
    public String patternName;
    public String patternVersion;
    public int type;

    public JSONObject getObjArgs() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "655982657")) {
            return (JSONObject) ipChange.ipc$dispatch("655982657", new Object[]{this});
        }
        if (TextUtils.isEmpty(this.args)) {
            return null;
        }
        return JSON.parseObject(this.args);
    }
}
