package cn.damai.solid;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import cn.damai.common.AppConfig;
import cn.damai.common.nav.DMNav;
import cn.damai.solid.SoLibInstallActivity;
import cn.damai.solid.bean.SoGroupEnum;
import cn.damai.solid.bean.SoInstallResult;
import cn.damai.solid.bean.SoRecord;
import cn.damai.solid.listener.SoInstallListener;
import cn.damai.solid.util.Constant;
import com.alibaba.wireless.security.SecExceptionCode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.solid.Solid;
import com.youku.arch.solid.SolidConfig;
import com.youku.arch.solid.SolidServer;
import com.youku.arch.solid.Status;
import com.youku.arch.solid.download.XcdnDownloaderImpl;
import com.youku.arch.solid.lifecycle.SolidRequest;
import com.youku.arch.solid.util.LibPathUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tb.cb2;
import tb.ce2;
import tb.de2;
import tb.fd;
import tb.ih1;
import tb.re2;

/* compiled from: Taobao */
/* renamed from: cn.damai.solid.a */
/* loaded from: classes16.dex */
public class C1768a {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String LIB_APP_SO = "libapp.so";
    public static final String TAG = "Solid";
    public static boolean d = true;
    private static C1768a e;
    private final HashMap<SoGroupEnum, List<SoRecord>> a;
    private final HashMap<Integer, re2> b;
    private volatile boolean c;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.solid.a$a */
    /* loaded from: classes7.dex */
    public class C1769a implements Solid.OnInitFinishCallback {
        private static transient /* synthetic */ IpChange $ipChange;

        C1769a() {
        }

        @Override // com.youku.arch.solid.Solid.OnInitFinishCallback
        public void onFinish(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "66137371")) {
                ipChange.ipc$dispatch("66137371", new Object[]{this, Boolean.valueOf(z)});
            } else if (z) {
                C1768a.this.c = true;
                C1768a.f("init success");
                Solid.getInstance().start();
            }
        }
    }

    private C1768a() {
        HashMap<SoGroupEnum, List<SoRecord>> hashMap = new HashMap<>();
        this.a = hashMap;
        this.b = new HashMap<>();
        this.c = false;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SoRecord("libpanorenderer.so"));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new SoRecord("libflutter.so"));
        if (!AppConfig.v()) {
            SoRecord soRecord = new SoRecord(LIB_APP_SO);
            soRecord.isSkipAppSystemLoad = true;
            arrayList2.add(soRecord);
        }
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(new SoRecord("libweexcore.so"));
        arrayList3.add(new SoRecord("libWTF.so"));
        arrayList3.add(new SoRecord("libJavaScriptCore.so"));
        hashMap.put(SoGroupEnum.VR, arrayList);
        hashMap.put(SoGroupEnum.FLUTTER, arrayList2);
        hashMap.put(SoGroupEnum.WEEX, arrayList3);
    }

    public static C1768a d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1040704729")) {
            return (C1768a) ipChange.ipc$dispatch("1040704729", new Object[0]);
        }
        if (e == null) {
            synchronized (C1768a.class) {
                if (e == null) {
                    e = new C1768a();
                }
            }
        }
        return e;
    }

    public static void f(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-707782866")) {
            ipChange.ipc$dispatch("-707782866", new Object[]{str});
        } else if (d) {
            Log.e(TAG, str);
        }
    }

    private void h(Application application, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-997657208")) {
            ipChange.ipc$dispatch("-997657208", new Object[]{this, application, Long.valueOf(j)});
            return;
        }
        fd.e(SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR);
        DMNav.registerStickPreprocessor(new ce2());
        DMNav.registerStickPreprocessor(new de2());
        Solid.getInstance().init(new SolidConfig.Builder(application).openLog(AppConfig.v()).useCompress(true).setLibPath(LibPathUtil.getDefaultLibPath(application)).setLaunchTimeMillions(j).setVersionName(AppConfig.q()).setDownloader(new XcdnDownloaderImpl("1")).setMonitor(new ih1()).build(), new C1769a());
        fd.a("SolidInit", SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR);
    }

    public void b(Context context, SoGroupEnum soGroupEnum, SoInstallListener soInstallListener) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "160196183")) {
            ipChange.ipc$dispatch("160196183", new Object[]{this, context, soGroupEnum, soInstallListener});
            return;
        }
        re2 re2Var = new re2(soGroupEnum, soInstallListener);
        if (!this.c) {
            re2Var.onInstallFail(Constant.CODE_SOLID_NOT_INIT, Constant.MSG_SOLID_NOT_INIT);
            return;
        }
        List<SoRecord> list = this.a.get(soGroupEnum);
        if (cb2.d(list)) {
            re2Var.onInstallFail(Constant.CODE_SOLID_NONE_SO_GROUP, Constant.MSG_SOLID_NONE_SO_GROUP);
            return;
        }
        Iterator<SoRecord> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            SoRecord next = it.next();
            if (!next.isSkipAppSystemLoad && !next.isSystemLoaded) {
                z = false;
                break;
            }
        }
        if (z) {
            f("dependOnRemoteSoInstall: GN:" + soGroupEnum.soGroupName + " onInstallSuccess already install");
            re2Var.onInstallSuccess();
            return;
        }
        SolidRequest solidRequest = new SolidRequest();
        solidRequest.name = soGroupEnum.soGroupName;
        Status checkSoGroupStatus = SolidServer.checkSoGroupStatus(solidRequest);
        f("dependOnRemoteSoInstall: not install GN:" + soGroupEnum.soGroupName + " status:" + checkSoGroupStatus.name());
        if (Status.DOWNLOADED == checkSoGroupStatus && c(soGroupEnum).isSoInstallSuccess) {
            f("dependOnRemoteSoInstall: downloaded and install success GN:" + soGroupEnum.soGroupName);
            re2Var.onInstallSuccess();
            return;
        }
        int uniqueKey = re2Var.getUniqueKey();
        this.b.put(Integer.valueOf(uniqueKey), re2Var);
        Intent intent = new Intent(context, SoLibInstallActivity.class);
        intent.putExtra("extra_key", new SoLibInstallActivity.Extra(soGroupEnum.name(), uniqueKey));
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public SoInstallResult c(SoGroupEnum soGroupEnum) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "515444028")) {
            return (SoInstallResult) ipChange.ipc$dispatch("515444028", new Object[]{this, soGroupEnum});
        }
        SoRecord soRecord = null;
        try {
            List<SoRecord> list = this.a.get(soGroupEnum);
            if (cb2.d(list)) {
                return SoInstallResult.noSoGroupResult();
            }
            for (SoRecord soRecord2 : list) {
                try {
                    SolidRequest solidRequest = new SolidRequest();
                    solidRequest.name = soRecord2.soLibName;
                    String str = SolidServer.checkSoFilePath(solidRequest).soFilePath;
                    if (!TextUtils.isEmpty(str)) {
                        if (soRecord2.isSkipAppSystemLoad) {
                            if (d) {
                                f("isSkipAppSystemLoad = true ,Skip system.load() install single soName:" + soRecord2.soLibName + " belong GN:" + soGroupEnum.soGroupName);
                            }
                        } else {
                            if (d) {
                                f("installSoGroup start install single soName:" + soRecord2.soLibName + " belong GN:" + soGroupEnum.soGroupName);
                            }
                            System.load(str);
                            if (d) {
                                f("installSoGroup install success single soName:" + soRecord2.soLibName + " belong GN:" + soGroupEnum.soGroupName);
                            }
                            soRecord2.isSystemLoaded = true;
                        }
                    } else {
                        if (d) {
                            f("installSoGroup single so install fail soName:" + soRecord2.soLibName);
                        }
                        throw new IllegalStateException(soGroupEnum.soGroupName + " downloaded,but none " + soRecord2.soLibName + "file path");
                    }
                } catch (Exception e2) {
                    e = e2;
                    soRecord = soRecord2;
                    e.printStackTrace();
                    String str2 = soRecord != null ? soRecord.soLibName : "unknown.so";
                    return new SoInstallResult(false, Constant.CODE_SOLID_SYSTEM_LOAD_FAIL, str2 + " System.load fail:" + e.getMessage());
                }
            }
            return SoInstallResult.success();
        } catch (Exception e3) {
            e = e3;
        }
    }

    public SoInstallListener e(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "931845699") ? (SoInstallListener) ipChange.ipc$dispatch("931845699", new Object[]{this, Integer.valueOf(i)}) : this.b.remove(Integer.valueOf(i));
    }

    public void g(Application application, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-189494410")) {
            ipChange.ipc$dispatch("-189494410", new Object[]{this, application, Long.valueOf(j)});
            return;
        }
        try {
            h(application, j);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
