package com.taobao.android.tlog.protocol.model.joint.point;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public enum JointPointDefine {
    LIFECYCLE("lifecycle", LifecycleJointPoint.class),
    NOTIFICATION("notification", NotificationJointPoint.class),
    STARTUP(StartupJointPoint.TYPE, StartupJointPoint.class),
    TIMER("timer", TimerJointPoint.class),
    CUSTOM_JOINT_POINT("event", EventJointPoint.class),
    BACKGROUND("background", BackgroundJointPoint.class),
    FOREGROUND(ForegroundJointPoint.TYPE, ForegroundJointPoint.class);
    
    private Class<? extends JointPoint> jointPointClass;
    private String jointPointType;

    JointPointDefine(String str, Class cls) {
        this.jointPointType = str;
        this.jointPointClass = cls;
    }

    public static JointPointDefine fromName(String str) {
        JointPointDefine[] values;
        for (JointPointDefine jointPointDefine : values()) {
            if (jointPointDefine.jointPointType.equalsIgnoreCase(str)) {
                return jointPointDefine;
            }
        }
        return null;
    }

    public Class<? extends JointPoint> getJointPointClass() {
        return this.jointPointClass;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.jointPointType;
    }
}
