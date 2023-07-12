package com.taobao.tao.log.task;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.taobao.android.tlog.protocol.OpCode;
import com.taobao.android.tlog.protocol.model.RequestResult;
import com.taobao.android.tlog.protocol.model.reply.base.UploadTokenInfo;
import com.taobao.android.tlog.protocol.model.request.StartupRequest;
import com.taobao.tao.log.TLogConstant;
import com.taobao.tao.log.TLogInitializer;
import com.taobao.tao.log.message.SendMessage;
import com.taobao.tao.log.monitor.TLogMonitor;
import com.taobao.tao.log.monitor.TLogStage;
import com.taobao.tao.log.upload.UploaderInfo;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class StartUpRequestTask {
    private static String TAG = "TLOG.StartUpRequestTask";
    private static String dirName = "logStartUp";
    private static String fileName = "adapter.config";
    private static Integer min = 0;
    private static Integer max = 10000;
    private static Integer localSampling = 10000;

    static /* synthetic */ String access$100() {
        return getLocalIpAddress();
    }

    private static Boolean defaultConfig() {
        int intValue = getRandom().intValue();
        if (intValue > 0 && intValue <= localSampling.intValue()) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public static void execute() {
        try {
            final Long valueOf = Long.valueOf(System.currentTimeMillis());
            if (!isSendStartUp(TLogInitializer.getInstance().getContext(), TLogInitializer.getInstance().getAppVersion()).booleanValue()) {
                TLogInitializer.getInstance().gettLogMonitor().stageInfo(TLogStage.MSG_PULL, TAG, "启动事件：不发送启动事件");
                return;
            }
            new Timer().schedule(new TimerTask() { // from class: com.taobao.tao.log.task.StartUpRequestTask.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    try {
                        TLogInitializer.getInstance().gettLogMonitor().stageInfo(TLogStage.MSG_PULL, StartUpRequestTask.TAG, "启动事件：发送启动事件");
                        UploaderInfo uploadInfo = TLogInitializer.getInstance().getLogUploader().getUploadInfo();
                        StartupRequest startupRequest = new StartupRequest();
                        startupRequest.user = TLogInitializer.getInstance().getUserNick();
                        startupRequest.appVersion = TLogInitializer.getInstance().getAppVersion();
                        startupRequest.appKey = TLogInitializer.getInstance().getAppkey();
                        startupRequest.appId = TLogInitializer.getInstance().getAppId();
                        startupRequest.utdid = TLogInitializer.getUTDID();
                        startupRequest.opCode = OpCode.STARTUP;
                        UploadTokenInfo uploadTokenInfo = new UploadTokenInfo();
                        String str = uploadInfo.type;
                        startupRequest.tokenType = str;
                        if (str.equals(TLogConstant.TOKEN_TYPE_OSS) || uploadInfo.type.equals(TLogConstant.TOKEN_TYPE_ARUP) || uploadInfo.type.equals(TLogConstant.TOKEN_TYPE_CEPH)) {
                            uploadTokenInfo.put(TLogConstant.TOKEN_OSS_BUCKET_NAME_KEY, TLogInitializer.getInstance().ossBucketName);
                        }
                        startupRequest.tokenInfo = uploadTokenInfo;
                        startupRequest.osPlatform = "android";
                        startupRequest.osVersion = Build.VERSION.RELEASE;
                        startupRequest.brand = Build.BRAND;
                        startupRequest.deviceModel = Build.MODEL;
                        startupRequest.ip = StartUpRequestTask.access$100();
                        startupRequest.clientTime = valueOf;
                        RequestResult build = startupRequest.build();
                        if (build != null) {
                            SendMessage.send(TLogInitializer.getInstance().getContext(), build, Boolean.TRUE);
                        }
                    } catch (Exception e) {
                        Log.e(StartUpRequestTask.TAG, "start up request build error", e);
                        TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_HANDLE, StartUpRequestTask.TAG, e);
                    }
                }
            }, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
        } catch (Exception e) {
            Log.e(TAG, "send startUpRequest error", e);
            TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_HANDLE, TAG, e);
        }
    }

    private static String getLocalConfig(Context context) {
        String storePath = getStorePath(context);
        String read = read(storePath + File.separator + fileName);
        if (read == null || read.length() <= 0) {
            return null;
        }
        return read;
    }

    private static String getLocalIpAddress() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress()) {
                        return nextElement.getHostAddress().toString();
                    }
                }
            }
            return "-";
        } catch (Exception e) {
            TLogMonitor tLogMonitor = TLogInitializer.getInstance().gettLogMonitor();
            String str = TLogStage.MSG_SEND;
            String str2 = TAG;
            tLogMonitor.stageError(str, str2, "启动事件：getLocalIpAddress 异常:" + e.getMessage());
            return "-";
        }
    }

    private static Integer getRandom() {
        return Integer.valueOf((new Random().nextInt(max.intValue()) % ((max.intValue() - min.intValue()) + 1)) + min.intValue());
    }

    private static String getStorePath(Context context) {
        String str = context.getDir("tombstone", 0).getAbsolutePath() + File.separator + dirName;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdir();
        }
        return str;
    }

    private static Boolean isSendStartUp(Context context, String str) {
        String localConfig = getLocalConfig(context);
        if (localConfig == null) {
            TLogInitializer.getInstance().gettLogMonitor().stageInfo(TLogStage.MSG_PULL, TAG, "启动事件：文件内容不存在，执行随机采样");
            return updateConfig(str, context, defaultConfig());
        }
        TLogMonitor tLogMonitor = TLogInitializer.getInstance().gettLogMonitor();
        String str2 = TLogStage.MSG_PULL;
        String str3 = TAG;
        tLogMonitor.stageInfo(str2, str3, "启动事件：采样内容存在：" + localConfig);
        String[] split = localConfig.split("\\^");
        if (split.length <= 1) {
            return Boolean.FALSE;
        }
        String str4 = split[0];
        try {
            Boolean valueOf = Boolean.valueOf(split[1]);
            if (str4.equals(str)) {
                return valueOf;
            }
            TLogMonitor tLogMonitor2 = TLogInitializer.getInstance().gettLogMonitor();
            String str5 = TLogStage.MSG_PULL;
            String str6 = TAG;
            tLogMonitor2.stageInfo(str5, str6, "启动事件：版本号变更了，更新采样：" + localConfig);
            return updateConfig(str, context, defaultConfig());
        } catch (Exception unused) {
            return Boolean.FALSE;
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0045: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:23:0x0045 */
    private static String read(String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        File file = new File(str);
        BufferedReader bufferedReader3 = null;
        try {
            if (!file.exists()) {
                return null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (Exception unused) {
                            }
                        }
                        return null;
                    }
                }
                String sb2 = sb.toString();
                try {
                    bufferedReader2.close();
                } catch (Exception unused2) {
                }
                return sb2;
            } catch (Exception e2) {
                e = e2;
                bufferedReader2 = null;
            } catch (Throwable th) {
                th = th;
                if (bufferedReader3 != null) {
                    try {
                        bufferedReader3.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader3 = bufferedReader;
        }
    }

    private static Boolean serverConfig(Integer num) {
        Integer random = getRandom();
        if (num != null) {
            if (num.equals(0)) {
                return Boolean.FALSE;
            }
            if (random.intValue() > 0 && random.intValue() <= num.intValue()) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }
        return defaultConfig();
    }

    private static synchronized Boolean updateConfig(String str, Context context, Boolean bool) {
        synchronized (StartUpRequestTask.class) {
            writeToLocalConfig(context, str + "^" + bool);
        }
        return bool;
    }

    public static void updateSample(Integer num) {
        if (num == null) {
            return;
        }
        localSampling = num;
        TLogMonitor tLogMonitor = TLogInitializer.getInstance().gettLogMonitor();
        String str = TLogStage.MSG_PULL;
        String str2 = TAG;
        tLogMonitor.stageInfo(str, str2, "启动事件：收到服务端采样配置,更新采样：" + num);
        updateConfig(TLogInitializer.getInstance().getAppVersion(), TLogInitializer.getInstance().getContext(), serverConfig(num));
    }

    private static void write(String str, String str2) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            fileOutputStream.write(str2.getBytes("UTF-8"));
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void writeToLocalConfig(Context context, String str) {
        String storePath = getStorePath(context);
        write(storePath + File.separator + fileName, str);
    }
}
