package com.youku.arch.solid;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.youku.arch.solid.lifecycle.OnSoGroupStatusChangeListener;
import com.youku.arch.solid.lifecycle.SolidListener;
import com.youku.arch.solid.lifecycle.SolidRequest;
import com.youku.arch.solid.lifecycle.SolidResponse;
import com.youku.arch.solid.log.SLog;
import com.youku.arch.solid.monitor.SolidMonitor;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class SolidServer {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "Server";

    public static Status checkLibStatus(Context context, String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2017751331") ? (Status) ipChange.ipc$dispatch("-2017751331", new Object[]{context, str}) : checkLibStatus(context, str, Solid.getInstance().getElapseSinceLaunch());
    }

    public static SolidResponse checkSoFilePath(SolidRequest solidRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2145047453")) {
            return (SolidResponse) ipChange.ipc$dispatch("-2145047453", new Object[]{solidRequest});
        }
        SolidResponse solidResponse = new SolidResponse();
        solidResponse.soFilePath = "";
        if (solidRequest == null) {
            return solidResponse;
        }
        if (Solid.getInstance().isLocal()) {
            solidResponse.soFilePath = new File(Solid.getInstance().getApplication().getApplicationInfo().nativeLibraryDir, solidRequest.name).getPath();
            SLog.e(TAG, "isLocal: " + Solid.getInstance().isLocal() + AVFSCacheConstants.COMMA_SEP + solidRequest.name + " path = " + solidResponse.soFilePath);
        } else {
            SoInfoWrapper soInfoWithSoName = Solid.getInstance().getSoInfoWithSoName(solidRequest.name);
            if (soInfoWithSoName != null && soInfoWithSoName.localFile() != null && soInfoWithSoName.localFile().exists()) {
                solidResponse.soFilePath = soInfoWithSoName.localFile().getPath();
            }
        }
        return solidResponse;
    }

    public static Status checkSoGroupStatus(SolidRequest solidRequest) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "362351064")) {
            return (Status) ipChange.ipc$dispatch("362351064", new Object[]{solidRequest});
        }
        if (Solid.getInstance().isLocal()) {
            SLog.e(TAG, "isLocal: " + Solid.getInstance().isLocal() + AVFSCacheConstants.COMMA_SEP + solidRequest.name + " return DOWNLOADED");
            return Status.DOWNLOADED;
        } else if (solidRequest != null && !TextUtils.isEmpty(solidRequest.name)) {
            SoGroupWrapper soGroupWithName = Solid.getInstance().getSoGroupWithName(solidRequest.name);
            if (soGroupWithName == null) {
                return Status.UN_KNOW;
            }
            if (soGroupWithName.status() == Status.DOWNLOADED && Solid.getInstance().getApplication() != null) {
                for (SoInfoWrapper soInfoWrapper : soGroupWithName.getSoInfoList()) {
                    if (checkSoStatusWithFile(Solid.getInstance().getApplication(), soInfoWrapper.soFileName()) != Status.DOWNLOADED) {
                        soInfoWrapper.updateStatus(Status.WAIT_TO_DOWNLOAD);
                        z = false;
                    }
                }
                if (!z) {
                    soGroupWithName.updateStatus(Status.WAIT_TO_DOWNLOAD);
                }
            }
            SolidMonitor.reportCheck(soGroupWithName.name(), soGroupWithName.status(), SolidMonitor.CHECK_TYPE_GROUP, Solid.getInstance().getElapseSinceLaunch());
            if (soGroupWithName.status() != Status.DOWNLOADED) {
                Solid.getInstance().driveDownload(soGroupWithName);
            }
            return soGroupWithName.status();
        } else {
            return Status.UN_KNOW;
        }
    }

    private static Status checkSoStatusWithFile(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1653453968")) {
            return (Status) ipChange.ipc$dispatch("-1653453968", new Object[]{context, str});
        }
        if (new File(context.getApplicationInfo().nativeLibraryDir, str).exists()) {
            return Status.DOWNLOADED;
        }
        File nativeLibPath = nativeLibPath(str);
        if (nativeLibPath != null && nativeLibPath.exists()) {
            return Status.DOWNLOADED;
        }
        return Status.WAIT_TO_DOWNLOAD;
    }

    @Deprecated
    public static Status isSoGroupReady(Context context, String... strArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1571268989")) {
            return (Status) ipChange.ipc$dispatch("1571268989", new Object[]{context, strArr});
        }
        if (Solid.getInstance().isLocal()) {
            SLog.e(TAG, "isLocal: " + Solid.getInstance().isLocal() + AVFSCacheConstants.COMMA_SEP + strArr + " return DOWNLOADED");
            return Status.DOWNLOADED;
        } else if (strArr != null && strArr.length > 0) {
            Status status = Status.DOWNLOADED;
            StringBuilder sb = new StringBuilder();
            sb.append(strArr[0]);
            sb.append("->");
            sb.append(strArr[strArr.length - 1]);
            long elapseSinceLaunch = Solid.getInstance().getElapseSinceLaunch();
            for (String str : strArr) {
                if (checkLibStatus(context, str, elapseSinceLaunch) != Status.DOWNLOADED) {
                    status = Status.WAIT_TO_DOWNLOAD;
                }
            }
            if (Solid.getInstance().getConfig().isOpenLog()) {
                Log.e(TAG, "LibGroup: " + ((Object) sb) + " , status ->" + status);
            }
            SolidMonitor.reportCheck(sb.toString(), status, SolidMonitor.CHECK_TYPE_LIB_LIST, elapseSinceLaunch);
            return status;
        } else {
            return Status.UN_KNOW;
        }
    }

    private static File nativeLibPath(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1342486042")) {
            return (File) ipChange.ipc$dispatch("-1342486042", new Object[]{str});
        }
        try {
            return new File(Solid.getInstance().getConfig().getLibInstallPath() + File.separator + str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void registerListener(SolidRequest solidRequest, SolidListener solidListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1254771734")) {
            ipChange.ipc$dispatch("-1254771734", new Object[]{solidRequest, solidListener});
        } else if (solidRequest == null || solidListener == null) {
        } else {
            if (solidListener instanceof OnSoGroupStatusChangeListener) {
                registerOnSoGroupStatusChangeListener(solidRequest, (OnSoGroupStatusChangeListener) solidListener);
                return;
            }
            SolidResponse solidResponse = new SolidResponse();
            solidResponse.msg = "请勿直接传入 SolidListener 的实现，根据文档选择对应的 listener 传入";
            solidListener.onResponse(solidResponse);
        }
    }

    private static void registerOnSoGroupStatusChangeListener(SolidRequest solidRequest, final OnSoGroupStatusChangeListener onSoGroupStatusChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "468033113")) {
            ipChange.ipc$dispatch("468033113", new Object[]{solidRequest, onSoGroupStatusChangeListener});
        } else if (Solid.getInstance().isLocal()) {
            final SolidResponse solidResponse = new SolidResponse();
            solidResponse.groupName = solidRequest.name;
            solidResponse.status = Status.DOWNLOADED;
            Solid.getInstance().executeTask(new Runnable() { // from class: com.youku.arch.solid.SolidServer.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1834975416")) {
                        ipChange2.ipc$dispatch("1834975416", new Object[]{this});
                    } else {
                        OnSoGroupStatusChangeListener.this.onResponse(solidResponse);
                    }
                }
            });
            SLog.e(TAG, "isLocal: " + Solid.getInstance().isLocal() + AVFSCacheConstants.COMMA_SEP + solidRequest.name + " return DOWNLOADED");
        } else {
            long elapseSinceLaunch = Solid.getInstance().getElapseSinceLaunch();
            SoGroupWrapper soGroupWithName = Solid.getInstance().getSoGroupWithName(solidRequest.name);
            if (soGroupWithName == null) {
                final SolidResponse solidResponse2 = new SolidResponse();
                solidResponse2.groupName = solidRequest.name;
                solidResponse2.status = Status.UN_KNOW;
                Solid.getInstance().executeTask(new Runnable() { // from class: com.youku.arch.solid.SolidServer.2
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "1638461911")) {
                            ipChange2.ipc$dispatch("1638461911", new Object[]{this});
                        } else {
                            OnSoGroupStatusChangeListener.this.onResponse(solidResponse2);
                        }
                    }
                });
                SolidMonitor.reportCheck(solidResponse2.groupName, solidResponse2.status, SolidMonitor.CHECK_TYPE_GROUP, elapseSinceLaunch);
            } else if (checkSoGroupStatus(solidRequest) == Status.DOWNLOADED) {
                soGroupWithName.notifySoGroupReady(onSoGroupStatusChangeListener);
            } else {
                soGroupWithName.addOnSoGroupReadyListener(onSoGroupStatusChangeListener);
            }
        }
    }

    public static Status checkLibStatus(Context context, String str, long j) {
        Status status;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1017311117")) {
            return (Status) ipChange.ipc$dispatch("-1017311117", new Object[]{context, str, Long.valueOf(j)});
        }
        if (Solid.getInstance().isLocal()) {
            SLog.e(TAG, "isLocal: " + Solid.getInstance().isLocal() + AVFSCacheConstants.COMMA_SEP + str + " return DOWNLOADED");
            return Status.DOWNLOADED;
        } else if (TextUtils.isEmpty(str)) {
            return Status.UN_KNOW;
        } else {
            SoInfoWrapper soInfoWithSoName = Solid.getInstance().getSoInfoWithSoName(str);
            if (soInfoWithSoName == null) {
                SLog.e(TAG, str + " not in solid, check local file");
                status = checkSoStatusWithFile(context, str);
            } else {
                status = soInfoWithSoName.status();
            }
            SolidMonitor.reportCheck(str, status, SolidMonitor.CHECK_TYPE_LIB, j);
            if (Solid.getInstance().getConfig().isOpenLog()) {
                SLog.d(TAG, "lib: " + str + " , status -> " + status);
            }
            return status;
        }
    }
}
