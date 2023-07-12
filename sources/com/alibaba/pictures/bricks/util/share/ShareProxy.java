package com.alibaba.pictures.bricks.util.share;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.joor.ReflectException;
import org.joor.a;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ShareProxy {
    private static transient /* synthetic */ IpChange $ipChange;
    private static IShareProxy a;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface IShareProxy {
        void share(Activity activity, Bundle bundle, View view);
    }

    public static IShareProxy a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-210778782")) {
            return (IShareProxy) ipChange.ipc$dispatch("-210778782", new Object[0]);
        }
        if (a == null) {
            try {
                a = (IShareProxy) a.j("cn.damai.launcher.DmShareImpl").b().f();
            } catch (ReflectException e) {
                e.printStackTrace();
            }
        }
        return a;
    }

    public static void b(Class cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "57214281")) {
            ipChange.ipc$dispatch("57214281", new Object[]{cls});
        } else if (a == null && IShareProxy.class.isAssignableFrom(cls)) {
            try {
                a = (IShareProxy) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
