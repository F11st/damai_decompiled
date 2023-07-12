package com.taobao.tao.log.godeye.api.command;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.tlog.protocol.model.joint.point.JointPoint;
import com.taobao.android.tlog.protocol.model.joint.point.JointPointDefine;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class GodeyeBaseTask implements Serializable {
    private static final String KEY_JOINT_POINT_TYPE = "type";
    private static final String KEY_START_JOINT_POINT = "start";
    private static final String KEY_STOP_JOINT_POINT = "stop";
    private String sequence;
    public JointPoint start;
    public JointPoint stop;

    public GodeyeBaseTask() {
    }

    private JointPoint parseJointPoint(JSONObject jSONObject) {
        JointPointDefine fromName = JointPointDefine.fromName(jSONObject.getString("type"));
        if (fromName != null) {
            return (JointPoint) JSON.toJavaObject(jSONObject, fromName.getJointPointClass());
        }
        throw new RuntimeException("Invalid jointpoint argument");
    }

    public String getSequence() {
        return this.sequence;
    }

    public JointPoint getStart() {
        return this.start;
    }

    public JointPoint getStop() {
        return this.stop;
    }

    public boolean isEmptyTask() {
        return this.start == null;
    }

    public void setSequence(String str) {
        this.sequence = str;
    }

    public void setStart(JointPoint jointPoint) {
        this.start = jointPoint;
    }

    public void setStop(JointPoint jointPoint) {
        this.stop = jointPoint;
    }

    public GodeyeBaseTask(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject.getJSONObject("start");
        JSONObject jSONObject3 = jSONObject.getJSONObject("stop");
        if (jSONObject2 != null) {
            this.start = parseJointPoint(jSONObject2);
        }
        if (jSONObject3 != null) {
            this.stop = parseJointPoint(jSONObject3);
        }
    }
}
