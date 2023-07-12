package com.ali.user.open.core.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.taobao.windvane.util.NetWork;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import android.widget.Toast;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.broadcast.LoginAction;
import com.ali.user.open.core.callback.FailureCallback;
import com.ali.user.open.core.config.ConfigManager;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.model.ResultCode;
import com.ali.user.open.core.service.UserTrackerService;
import com.ali.user.open.core.trace.SDKLogger;
import com.taobao.weex.annotation.JSMethod;
import java.io.File;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.nio.channels.FileLock;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class CommonUtils {
    public static final String BAICHUAN_TAG = "baichuan_mp";
    public static final String TAG = "ucc.CommonUtils";
    public static String mAppVersion;
    private static String sProcessName;

    public static void addExt(Map<String, String> map) {
        if (!ConfigManager.getInstance().isMiniProgram() || map == null) {
            return;
        }
        map.put("sdkPlatform", BAICHUAN_TAG);
    }

    private static void createFile(File file, boolean z) {
        if (z) {
            try {
                if (file.exists()) {
                    return;
                }
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String getAndroidAppVersion() {
        return "android_" + getAppVersion();
    }

    public static String getAppVersion() {
        if (mAppVersion == null) {
            try {
                PackageInfo packageInfo = KernelContext.getApplicationContext().getPackageManager().getPackageInfo(KernelContext.getApplicationContext().getPackageName(), 0);
                if (packageInfo != null) {
                    mAppVersion = packageInfo.versionName;
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return mAppVersion;
    }

    public static boolean getDarkModeStatus(Context context) {
        if (ConfigManager.getInstance().getThemeDataProvider() != null) {
            return ConfigManager.getInstance().getThemeDataProvider().isDark();
        }
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static String getHashString(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(Integer.toHexString((b >> 4) & 15));
            sb.append(Integer.toHexString(b & 15));
        }
        return sb.toString();
    }

    public static String getLocalIPAddress() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                        return nextElement.getHostAddress();
                    }
                }
            }
            return null;
        } catch (SocketException unused) {
            return null;
        }
    }

    public static String getNetworkType(Context context) {
        ConnectivityManager connectivityManager;
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (connectivityManager == null) {
            SDKLogger.w(TAG, "can not get Context.CONNECTIVITY_SERVICE");
            return "none";
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        if (networkInfo != null) {
            if (NetworkInfo.State.CONNECTED == networkInfo.getState()) {
                return "wifi";
            }
        } else {
            SDKLogger.w(TAG, "can not get ConnectivityManager.TYPE_WIFI");
        }
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
        if (networkInfo2 != null) {
            if (NetworkInfo.State.CONNECTED == networkInfo2.getState()) {
                return NetWork.CONN_TYPE_GPRS;
            }
        } else {
            SDKLogger.w(TAG, "can not get ConnectivityManager.TYPE_MOBILE");
        }
        return "none";
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getProcessName(android.content.Context r7) {
        /*
            java.lang.String r0 = com.ali.user.open.core.util.CommonUtils.sProcessName
            if (r0 == 0) goto L5
            return r0
        L5:
            java.lang.Class<com.ali.user.open.core.util.CommonUtils> r0 = com.ali.user.open.core.util.CommonUtils.class
            monitor-enter(r0)
            java.lang.String r1 = com.ali.user.open.core.util.CommonUtils.sProcessName     // Catch: java.lang.Throwable -> L9b
            if (r1 == 0) goto Le
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L9b
            return r1
        Le:
            int r1 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L9b
            r2 = 0
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            r5.<init>()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            java.lang.String r6 = "/proc/"
            r5.append(r6)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            r5.append(r1)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            java.lang.String r6 = "/cmdline"
            r5.append(r6)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L8e
            r4.<init>()     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L8e
        L38:
            int r5 = r3.read()     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L8e
            if (r5 <= 0) goto L43
            char r5 = (char) r5     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L8e
            r4.append(r5)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L8e
            goto L38
        L43:
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L8e
            com.ali.user.open.core.util.CommonUtils.sProcessName = r4     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L8e
            r3.close()     // Catch: java.lang.Exception -> L4d java.lang.Throwable -> L9b
            goto L51
        L4d:
            r7 = move-exception
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L9b
        L51:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L9b
            return r4
        L53:
            r4 = move-exception
            goto L59
        L55:
            r7 = move-exception
            goto L90
        L57:
            r4 = move-exception
            r3 = r2
        L59:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L8e
            if (r3 == 0) goto L66
            r3.close()     // Catch: java.lang.Exception -> L62 java.lang.Throwable -> L9b
            goto L66
        L62:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L9b
        L66:
            java.lang.String r3 = "activity"
            java.lang.Object r7 = r7.getSystemService(r3)     // Catch: java.lang.Throwable -> L9b
            android.app.ActivityManager r7 = (android.app.ActivityManager) r7     // Catch: java.lang.Throwable -> L9b
            java.util.List r7 = r7.getRunningAppProcesses()     // Catch: java.lang.Throwable -> L9b
            java.util.Iterator r7 = r7.iterator()     // Catch: java.lang.Throwable -> L9b
        L76:
            boolean r3 = r7.hasNext()     // Catch: java.lang.Throwable -> L9b
            if (r3 == 0) goto L8c
            java.lang.Object r3 = r7.next()     // Catch: java.lang.Throwable -> L9b
            android.app.ActivityManager$RunningAppProcessInfo r3 = (android.app.ActivityManager.RunningAppProcessInfo) r3     // Catch: java.lang.Throwable -> L9b
            int r4 = r3.pid     // Catch: java.lang.Throwable -> L9b
            if (r4 != r1) goto L76
            java.lang.String r7 = r3.processName     // Catch: java.lang.Throwable -> L9b
            com.ali.user.open.core.util.CommonUtils.sProcessName = r7     // Catch: java.lang.Throwable -> L9b
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L9b
            return r7
        L8c:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L9b
            return r2
        L8e:
            r7 = move-exception
            r2 = r3
        L90:
            if (r2 == 0) goto L9a
            r2.close()     // Catch: java.lang.Exception -> L96 java.lang.Throwable -> L9b
            goto L9a
        L96:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L9b
        L9a:
            throw r7     // Catch: java.lang.Throwable -> L9b
        L9b:
            r7 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L9b
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ali.user.open.core.util.CommonUtils.getProcessName(android.content.Context):java.lang.String");
    }

    public static void handleWebviewDir(Context context) {
        if (Build.VERSION.SDK_INT < 29) {
            return;
        }
        try {
            Log.d(TAG, "handleWebviewDir");
            HashSet<String> hashSet = new HashSet();
            String absolutePath = context.getDataDir().getAbsolutePath();
            String processName = getProcessName(context);
            if (!TextUtils.equals(context.getPackageName(), processName)) {
                if (TextUtils.isEmpty(processName)) {
                    processName = context.getPackageName();
                }
                WebView.setDataDirectorySuffix(processName);
                String str = JSMethod.NOT_SET + processName;
                hashSet.add(absolutePath + "/app_webview" + str + "/webview_data.lock");
                if (isHuaweiRom()) {
                    hashSet.add(absolutePath + "/app_hws_webview" + str + "/webview_data.lock");
                }
            } else {
                String str2 = JSMethod.NOT_SET + processName;
                hashSet.add(absolutePath + "/app_webview/webview_data.lock");
                hashSet.add(absolutePath + "/app_webview" + str2 + "/webview_data.lock");
                if (isHuaweiRom()) {
                    hashSet.add(absolutePath + "/app_hws_webview/webview_data.lock");
                    hashSet.add(absolutePath + "/app_hws_webview" + str2 + "/webview_data.lock");
                }
            }
            for (String str3 : hashSet) {
                File file = new File(str3);
                if (file.exists()) {
                    tryLockOrRecreateFile(file);
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isHuaweiRom() {
        try {
            return com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER().toUpperCase().contains("HUAWEI");
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isNetworkAvailable() {
        if (KernelContext.getApplicationContext() == null) {
            return true;
        }
        return isNetworkAvailable(KernelContext.getApplicationContext());
    }

    public static void onFailure(final FailureCallback failureCallback, final ResultCode resultCode) {
        KernelContext.executorService.postUITask(new Runnable() { // from class: com.ali.user.open.core.util.CommonUtils.1
            @Override // java.lang.Runnable
            public void run() {
                FailureCallback failureCallback2 = FailureCallback.this;
                if (failureCallback2 != null) {
                    ResultCode resultCode2 = resultCode;
                    failureCallback2.onFailure(resultCode2.code, resultCode2.message);
                }
            }
        });
    }

    public static void sendBroadcast(LoginAction loginAction, Map<String, String> map) {
        Intent intent = new Intent();
        intent.setAction(loginAction.name());
        intent.setPackage(KernelContext.getApplicationContext().getPackageName());
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (key != null && value != null) {
                    intent.putExtra(entry.getKey(), entry.getValue());
                }
            }
        }
        KernelContext.getApplicationContext().sendBroadcast(intent);
    }

    public static void sendUT(String str) {
        sendUT(str, null);
    }

    public static String toString(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static void toast(final String str) {
        KernelContext.executorService.postUITask(new Runnable() { // from class: com.ali.user.open.core.util.CommonUtils.3
            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(KernelContext.getApplicationContext(), ResourceUtils.getString(str), 0).show();
            }
        });
    }

    public static void toastSystemException() {
        toast("member_sdk_system_exception");
    }

    @TargetApi(28)
    private static void tryLockOrRecreateFile(File file) {
        try {
            FileLock tryLock = new RandomAccessFile(file, "rw").getChannel().tryLock();
            if (tryLock != null) {
                tryLock.close();
            } else {
                createFile(file, file.delete());
            }
        } catch (Exception e) {
            e.printStackTrace();
            createFile(file, file.exists() ? file.delete() : false);
        }
    }

    public static void onFailure(final FailureCallback failureCallback, final int i, final String str) {
        KernelContext.executorService.postUITask(new Runnable() { // from class: com.ali.user.open.core.util.CommonUtils.2
            @Override // java.lang.Runnable
            public void run() {
                FailureCallback failureCallback2 = FailureCallback.this;
                if (failureCallback2 != null) {
                    failureCallback2.onFailure(i, str);
                }
            }
        });
    }

    public static void sendUT(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str) || AliMemberSDK.getService(UserTrackerService.class) == null) {
            return;
        }
        ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send(str, map);
    }

    public static void addExt(JSONObject jSONObject) {
        if (!ConfigManager.getInstance().isMiniProgram() || jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("sdkPlatform", BAICHUAN_TAG);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo[] allNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (allNetworkInfo = connectivityManager.getAllNetworkInfo()) == null) {
            return false;
        }
        for (NetworkInfo networkInfo : allNetworkInfo) {
            if (networkInfo != null && (networkInfo.getState() == NetworkInfo.State.CONNECTED || networkInfo.getState() == NetworkInfo.State.CONNECTING)) {
                return true;
            }
        }
        return false;
    }
}
