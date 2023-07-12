package cn.damai.tetris.request;

import android.text.TextUtils;
import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import cn.damai.tetris.v2.common.ContainerArg;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import java.util.Map;
import tb.cb2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TetrisRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String args;
    public String dr;
    public String patternName;
    public String patternVersion;

    public TetrisRequest(TetrisParams tetrisParams) {
        this.patternVersion = "1.0";
        if (tetrisParams != null) {
            this.patternName = tetrisParams.getPatternName();
            this.args = JSON.toJSONString(tetrisParams);
            this.patternVersion = tetrisParams.getVersion();
            try {
                setTakePrivateParams(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void overrideParams(TetrisRequest tetrisRequest, ContainerArg containerArg) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2007057042")) {
            ipChange.ipc$dispatch("-2007057042", new Object[]{tetrisRequest, containerArg});
        } else {
            overrideParams(tetrisRequest, containerArg, null);
        }
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1584829047") ? (String) ipChange.ipc$dispatch("1584829047", new Object[]{this}) : "mtop.damai.mec.aristotle.get";
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "446900886")) {
            return ((Boolean) ipChange.ipc$dispatch("446900886", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1189914002")) {
            return ((Boolean) ipChange.ipc$dispatch("1189914002", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-542401526") ? (String) ipChange.ipc$dispatch("-542401526", new Object[]{this}) : "1.0";
    }

    public String toJsonString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-36541668")) {
            return (String) ipChange.ipc$dispatch("-36541668", new Object[]{this});
        }
        return "TetrisRequest:jsondata={patternName:" + this.patternName + ",patternVersion:" + this.patternVersion + ",args:" + this.args + "}";
    }

    public static void overrideParams(TetrisRequest tetrisRequest, ContainerArg containerArg, List<String> list) {
        JSONObject parseObject;
        Map<String, Object> innerMap;
        JSONObject parseObject2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-919556513")) {
            ipChange.ipc$dispatch("-919556513", new Object[]{tetrisRequest, containerArg, list});
        } else if (containerArg != null && tetrisRequest != null) {
            String str = tetrisRequest.args;
            String str2 = containerArg.args;
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(str) && (parseObject2 = JSON.parseObject(str)) != null && parseObject2.getInnerMap() != null) {
                    jSONObject.putAll(parseObject2.getInnerMap());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (!TextUtils.isEmpty(str2) && (parseObject = JSON.parseObject(str2)) != null && (innerMap = parseObject.getInnerMap()) != null) {
                    if (!cb2.d(list)) {
                        for (String str3 : list) {
                            innerMap.remove(str3);
                        }
                    }
                    jSONObject.putAll(innerMap);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (!TextUtils.isEmpty(containerArg.patternName)) {
                tetrisRequest.patternName = containerArg.patternName;
            }
            if (!TextUtils.isEmpty(containerArg.patternVersion)) {
                tetrisRequest.patternVersion = containerArg.patternVersion;
            }
            tetrisRequest.args = jSONObject.toJSONString();
        }
    }

    public TetrisRequest() {
        this.patternVersion = "1.0";
    }
}
