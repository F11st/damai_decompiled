package com.taobao.tao.log.godeye.api.control;

import com.taobao.android.tlog.protocol.model.joint.point.JointPoint;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IGodeyeJointPointCenter {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static abstract class GodeyeJointPointCallback {
        public abstract void doCallback();

        public boolean isDisposable() {
            return true;
        }
    }

    String getLastVisitedPage();

    void installJointPoints(JointPoint jointPoint, GodeyeJointPointCallback godeyeJointPointCallback, JointPoint jointPoint2, GodeyeJointPointCallback godeyeJointPointCallback2, boolean z);
}
