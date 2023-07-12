package cn.damai.commonbusiness.home.bean;

import android.text.TextUtils;
import cn.damai.uikit.snake.ScrollTitleBean;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.m61;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class HomeTabBean extends ScrollTitleBean {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = -7339062201853406814L;
    public String args;
    public String categoryId;
    public int distance;
    public String groupId;
    public HomeHeaderBg homeHeaderBg;
    public int isShowFilter;
    public String patternName;
    public String patternVersion;
    public String spmb;
    public int type;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public static class Args implements Serializable {
        public String categoryId;
        public String groupId;
    }

    public JSONObject getObjArgs() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2139339021") ? (JSONObject) ipChange.ipc$dispatch("2139339021", new Object[]{this}) : m61.c(this.args);
    }

    public Args parseArgs() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "442329475")) {
            return (Args) ipChange.ipc$dispatch("442329475", new Object[]{this});
        }
        if (!TextUtils.isEmpty(this.args)) {
            return (Args) m61.a(this.args, Args.class);
        }
        return new Args();
    }

    public void putArgs(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "438833479")) {
            ipChange.ipc$dispatch("438833479", new Object[]{this, str, str2});
            return;
        }
        try {
            JSONObject objArgs = getObjArgs();
            if (objArgs == null) {
                objArgs = new JSONObject();
            }
            objArgs.put(str, (Object) str2);
            this.args = objArgs.toJSONString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
