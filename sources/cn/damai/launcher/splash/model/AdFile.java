package cn.damai.launcher.splash.model;

import android.content.Context;
import cn.damai.commonbusiness.wannasee.listener.OnBizListener;
import cn.damai.launcher.splash.model.bean.AdFileResult;
import cn.damai.launcher.splash.model.listener.OnAdMainThreadFileListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;
import tb.a92;
import tb.qc0;
import tb.sc0;
import tb.td1;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class AdFile {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String AD_DIR = "ad_dir";

    private AdFile() {
    }

    public static void downloadIfNoneCache(Context context, String str, final OnBizListener<File> onBizListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1963997849")) {
            ipChange.ipc$dispatch("-1963997849", new Object[]{context, str, onBizListener});
            return;
        }
        AdFileResult isHasCacheAdFile = isHasCacheAdFile(context, str);
        if (isHasCacheAdFile.isHasCacheAdFile) {
            onBizListener.onBizSuccess(isHasCacheAdFile.cacheAdFile);
            return;
        }
        qc0 qc0Var = new qc0(str);
        a92.d(getAdDir(context));
        qc0Var.b.f = getAdDir(context).getAbsolutePath();
        qc0Var.a.get(0).d = getAdFileName(str);
        qc0Var.b.m = true;
        sc0.c().b(qc0Var, new OnAdMainThreadFileListener(new OnBizListener<String>() { // from class: cn.damai.launcher.splash.model.AdFile.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.commonbusiness.wannasee.listener.OnBizListener
            public void onBizFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1318405993")) {
                    ipChange2.ipc$dispatch("1318405993", new Object[]{this, str2, str3});
                } else {
                    OnBizListener.this.onBizFail(str2, str3);
                }
            }

            @Override // cn.damai.commonbusiness.wannasee.listener.OnBizListener
            public void onBizSuccess(String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-616602786")) {
                    ipChange2.ipc$dispatch("-616602786", new Object[]{this, str2});
                } else {
                    OnBizListener.this.onBizSuccess(new File(str2));
                }
            }
        }));
    }

    private static File getAdDir(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "359087271")) {
            return (File) ipChange.ipc$dispatch("359087271", new Object[]{context});
        }
        File file = new File(context.getFilesDir(), AD_DIR);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File getAdFile(Context context, String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2081823398") ? (File) ipChange.ipc$dispatch("-2081823398", new Object[]{context, str}) : new File(getAdDir(context), getAdFileName(str));
    }

    public static String getAdFileName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-481110142")) {
            return (String) ipChange.ipc$dispatch("-481110142", new Object[]{str});
        }
        return td1.b(str) + "_temp";
    }

    public static AdFileResult isHasCacheAdFile(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1263140855")) {
            return (AdFileResult) ipChange.ipc$dispatch("1263140855", new Object[]{context, str});
        }
        File adFile = getAdFile(context, str);
        if (adFile.exists() && adFile.isFile()) {
            return new AdFileResult(true, adFile);
        }
        return new AdFileResult(false, null);
    }
}
