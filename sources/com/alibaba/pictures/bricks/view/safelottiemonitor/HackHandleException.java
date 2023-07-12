package com.alibaba.pictures.bricks.view.safelottiemonitor;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class HackHandleException extends Throwable {
    private static transient /* synthetic */ IpChange $ipChange;
    private Class<?> mHackedClass;
    private String mHackedFieldName;
    private String mHackedMethodName;

    public HackHandleException(Exception exc) {
        super(exc);
    }

    public Class<?> getHackedClass() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1939356223") ? (Class) ipChange.ipc$dispatch("1939356223", new Object[]{this}) : this.mHackedClass;
    }

    public String getHackedFieldName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-596246405") ? (String) ipChange.ipc$dispatch("-596246405", new Object[]{this}) : this.mHackedFieldName;
    }

    public String getHackedMethodName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "621632428") ? (String) ipChange.ipc$dispatch("621632428", new Object[]{this}) : this.mHackedMethodName;
    }

    public void setHackedClass(Class<?> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1427828385")) {
            ipChange.ipc$dispatch("-1427828385", new Object[]{this, cls});
        } else {
            this.mHackedClass = cls;
        }
    }

    public void setHackedFieldName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1021956005")) {
            ipChange.ipc$dispatch("-1021956005", new Object[]{this, str});
        } else {
            this.mHackedFieldName = str;
        }
    }

    public void setHackedMethodName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "918941362")) {
            ipChange.ipc$dispatch("918941362", new Object[]{this, str});
        } else {
            this.mHackedMethodName = str;
        }
    }

    public HackHandleException(String str) {
        super(str);
    }
}
