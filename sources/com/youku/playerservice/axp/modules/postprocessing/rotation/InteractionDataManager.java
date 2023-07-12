package com.youku.playerservice.axp.modules.postprocessing.rotation;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alimm.xadsdk.base.constant.AdType;
import com.youku.alixplayer.ExtraID;
import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.middlewareservice.provider.task.TaskRunnerProviderProxy;
import com.youku.playerservice.axp.item.BitStream;
import com.youku.playerservice.axp.modules.postprocessing.rotation.Data;
import com.youku.playerservice.axp.playinfo.PlayInfo;
import com.youku.playerservice.axp.playinfo.PlayInfoResponse;
import com.youku.playerservice.axp.playinfo.PlayInfoUpsResponse;
import com.youku.playerservice.axp.playparams.PlayParams;
import com.youku.playerservice.axp.utils.BinaryUtil;
import com.youku.playerservice.axp.utils.TLogUtil;
import com.youku.vpm.proxy.VpmCommit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.internal.a;
import okhttp3.o;
import okhttp3.q;
import org.apache.commons.lang3.StringUtils;
import tb.m80;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class InteractionDataManager implements Runnable {
    private static final String INTERACTION_DIR = "i_data";
    private static final int MAX_SUPPORT_CONFIG_VERSION = 3;
    private static final int MIN_SUPPORT_CONFIG_VERSION = 2;
    private static final int ROUND_BIT = 2;
    private static final String TAG = "InteractionDataManager";
    private static File cacheDir;
    private static Boolean isRegisterByPassDataDownload;
    private List<IndexItem> indexList;
    private BitStream mBitStream;
    private TreeMap<Double, InteractionData> mDataMap;
    private Runnable mFailCallback;
    private Map<Double, Data.Frame> mFrameMap;
    private String mIndexUrl;
    private Map<String, Data.Person> mPersonMap;
    private PlayInfo mPlayInfo;
    private Runnable mSuccessCallback;
    private String mUrl;
    private String requestVid;
    private double timeOffset;
    private int requestState = -2;
    private int mStartTimeMs = 0;
    private String versionStr = null;
    boolean callbackCalled = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class IndexItem {
        int length;
        int offset;
        double startTime;

        IndexItem() {
        }
    }

    public InteractionDataManager(Context context) {
        this.timeOffset = 0.001d;
        if (context != null) {
            try {
                File file = new File(context.getExternalCacheDir(), INTERACTION_DIR);
                cacheDir = file;
                file.mkdirs();
            } catch (Exception unused) {
                cacheDir = null;
            }
        }
        TaskRunnerProviderProxy.initTaskGroup(TAG, 1);
        TLogUtil.loge(TAG, "create InteractionDataManager " + toString());
        try {
            this.timeOffset = Integer.parseInt(ConfigFetcher.getInstance().getConfig("interaction_config", "time_offset_ms", "1")) / 1000.0d;
        } catch (Exception unused2) {
        }
    }

    private boolean checkDstFile(File file, String str) {
        boolean exists = file.exists();
        String str2 = null;
        if (exists && !TextUtils.isEmpty(str)) {
            try {
                str2 = BinaryUtil.toBase64String(BinaryUtil.calculateMd5(file));
                exists = TextUtils.equals(str, str2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        TLogUtil.loge(TAG, "checkDstFile File=" + file + " fileMD5=" + str2 + " checkMD5=" + str + " result=" + exists);
        return exists;
    }

    public static void commitByPassDataDownload(Map<String, String> map, Map<String, Double> map2) {
        isRegisterByPassDataDownload = Boolean.valueOf(VpmCommit.commitStatistics("byPassDataDownload", isRegisterByPassDataDownload.booleanValue(), map, map2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void commitVpm(String str, String str2, String str3, Double d, Double d2, Double d3, String str4) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (isValid()) {
            hashMap.put("vid", this.requestVid);
            hashMap.put("downloadType", str);
            hashMap.put("downloadSuccess", str2);
            hashMap.put("downloadUrl", str3);
            hashMap.put("version", this.versionStr);
            hashMap.put("errorCode", str4);
            hashMap2.put("downloadTime", d);
            hashMap2.put("rangeStart", d2);
            hashMap2.put("rangeSize", d3);
            commitByPassDataDownload(hashMap, hashMap2);
            TLogUtil.loge(TAG, "算法数据下载统计 " + hashMap + " " + hashMap2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void commitVpm(String str, String str2, String str3, Double d, String str4) {
        commitVpm(str, str2, str3, d, Double.valueOf(0.0d), Double.valueOf(-1.0d), str4);
    }

    private String convertStreamToString(InputStream inputStream) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        } catch (Throwable th) {
            th = th;
        }
        try {
            StringBuilder sb = new StringBuilder();
            Boolean bool = Boolean.TRUE;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                } else if (bool.booleanValue()) {
                    sb.append(readLine);
                    bool = Boolean.FALSE;
                } else {
                    sb.append(StringUtils.LF);
                    sb.append(readLine);
                }
            }
            String sb2 = sb.toString();
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sb2;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            throw th;
        }
    }

    private boolean enableData(PlayInfoUpsResponse playInfoUpsResponse, BitStream bitStream) {
        StringBuilder sb;
        String str;
        String config = ConfigFetcher.getInstance().getConfig("dk_config", "enable_rotation_data", "1");
        boolean hasVideoFeature = playInfoUpsResponse.hasVideoFeature("AUTOORNT");
        String config2 = ConfigFetcher.getInstance().getConfig("interaction_config", "enable_pick", "1");
        boolean hasVideoFeature2 = playInfoUpsResponse.hasVideoFeature("RETARGET");
        String config3 = ConfigFetcher.getInstance().getConfig("interaction_config", "enable_data", "1");
        TLogUtil.loge(TAG, "enableData aps:" + config3);
        boolean z = (bitStream == null || bitStream.getHlsPlayConf() == null) ? false : true;
        try {
            sb = new StringBuilder();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (bitStream != null) {
            str = bitStream.getHlsPlayConf() == null ? "&& getHlsPlayConf() is null" : "&& getHlsPlayConf() is null";
            TLogUtil.loge(TAG, "enableData hasPlayConf:" + sb.toString());
            if ("1".equals(config) || !hasVideoFeature) {
                if ("1".equals(config2) || !hasVideoFeature2) {
                    return !"1".equals(config3) && z;
                }
                return true;
            }
            return true;
        }
        str = "bitstream is null";
        sb.append(str);
        TLogUtil.loge(TAG, "enableData hasPlayConf:" + sb.toString());
        if ("1".equals(config)) {
        }
        if ("1".equals(config2)) {
        }
        if ("1".equals(config3)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isValid() {
        return false;
    }

    private void parseFrameData(String str) {
        Data.Frame[] frameArr;
        this.mFrameMap = new HashMap();
        this.mPersonMap = new HashMap();
        Data data = (Data) JSON.parseObject(str, Data.class);
        for (Data.Frame frame : data.frames) {
            this.mFrameMap.put(Double.valueOf(new BigDecimal(frame.t).setScale(2, 4).doubleValue()), frame);
        }
        Data.Person[] personArr = data.persons;
        if (personArr != null) {
            for (Data.Person person : personArr) {
                this.mPersonMap.put(person.id, person);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean parseIndex(q qVar, String str, int i) {
        Throwable th;
        BufferedReader bufferedReader = null;
        IndexItem indexItem = null;
        bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(qVar.a().c()));
                boolean z = false;
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        String[] split = readLine.split(",", 0);
                        if (split.length == 3) {
                            IndexItem indexItem2 = new IndexItem();
                            indexItem2.startTime = Double.parseDouble(split[0].trim());
                            indexItem2.offset = Integer.parseInt(split[1].trim());
                            indexItem2.length = Integer.parseInt(split[2].trim());
                            this.indexList.add(indexItem2);
                            if (!z) {
                                if (indexItem2.startTime > i / 1000.0d) {
                                    parseRangeDataByIndexItem(str, indexItem, i);
                                    z = true;
                                } else {
                                    indexItem = indexItem2;
                                }
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        bufferedReader = bufferedReader2;
                        e.printStackTrace();
                        TLogUtil.loge(TAG, "parseIndex Exception " + e.toString());
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        a.g(qVar);
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        a.g(qVar);
                        throw th;
                    }
                }
                if (!z && indexItem.startTime <= i / 1000.0d) {
                    parseRangeDataByIndexItem(str, indexItem, i);
                }
                try {
                    bufferedReader2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                a.g(qVar);
                return true;
            } catch (Exception e5) {
                e = e5;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean parseInteractionData(java.lang.String r17, java.lang.String r18, int r19) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.playerservice.axp.modules.postprocessing.rotation.InteractionDataManager.parseInteractionData(java.lang.String, java.lang.String, int):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean parseInteractionDataImpl(InputStream inputStream, int i) {
        return parseInteractionDataImpl(inputStream, i, false, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:142:0x0130 A[EDGE_INSN: B:142:0x0130->B:95:0x0130 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean parseInteractionDataImpl(java.io.InputStream r26, int r27, boolean r28, java.io.File r29) {
        /*
            Method dump skipped, instructions count: 403
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.playerservice.axp.modules.postprocessing.rotation.InteractionDataManager.parseInteractionDataImpl(java.io.InputStream, int, boolean, java.io.File):boolean");
    }

    private void parseRangeData(final String str, final String str2, final int i) {
        TLogUtil.loge(TAG, "算法Index数据开始请求 " + str2);
        final long currentTimeMillis = System.currentTimeMillis();
        new OkHttpClient().newCall(new o.a().k(str2).c().b()).enqueue(new Callback() { // from class: com.youku.playerservice.axp.modules.postprocessing.rotation.InteractionDataManager.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                InteractionDataManager.this.commitVpm("2", "0", str2, Double.valueOf(System.currentTimeMillis() - currentTimeMillis), String.valueOf(iOException instanceof SocketTimeoutException ? AdType.NATIVE_EXPRESS : ExtraID.ERRCODE_PARSER_SEEK_BUFFER_ERR));
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, q qVar) {
                int e;
                boolean z;
                if (qVar.isSuccessful()) {
                    z = InteractionDataManager.this.parseIndex(qVar, str, i);
                    e = !z ? 20000 : -1;
                } else {
                    e = qVar.e() + 10000;
                    z = false;
                }
                InteractionDataManager.this.commitVpm("2", z ? "1" : "0", str2, Double.valueOf(System.currentTimeMillis() - currentTimeMillis), String.valueOf(e));
            }
        });
    }

    private void parseRangeDataByIndexItem(final String str, final IndexItem indexItem, final int i) {
        if (indexItem == null || this.callbackCalled) {
            return;
        }
        TLogUtil.loge(TAG, "算法Range数据开始请求 " + str);
        String format = String.format(Locale.CHINESE, "bytes=%d-%d", Integer.valueOf(indexItem.offset), Integer.valueOf((indexItem.offset + indexItem.length) - 1));
        final long currentTimeMillis = System.currentTimeMillis();
        new OkHttpClient().newCall(new o.a().k(str).a("Range", format).c().b()).enqueue(new Callback() { // from class: com.youku.playerservice.axp.modules.postprocessing.rotation.InteractionDataManager.2
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                InteractionDataManager.this.commitVpm("1", "0", str, Double.valueOf(System.currentTimeMillis() - currentTimeMillis), Double.valueOf(indexItem.offset), Double.valueOf(indexItem.length), String.valueOf(iOException instanceof SocketTimeoutException ? AdType.NATIVE_EXPRESS : ExtraID.ERRCODE_PARSER_SEEK_BUFFER_ERR));
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, q qVar) {
                int e;
                boolean z;
                try {
                    if (qVar.isSuccessful()) {
                        z = InteractionDataManager.this.parseInteractionDataImpl(qVar.a().c(), i);
                        if (z) {
                            TLogUtil.loge(InteractionDataManager.TAG, "算法Range数据请求成功");
                            InteractionDataManager.this.requestState = 1;
                            if (InteractionDataManager.this.isValid() && InteractionDataManager.this.mSuccessCallback != null) {
                                InteractionDataManager interactionDataManager = InteractionDataManager.this;
                                if (!interactionDataManager.callbackCalled) {
                                    interactionDataManager.callbackCalled = true;
                                    interactionDataManager.mSuccessCallback.run();
                                }
                            }
                            e = -1;
                        } else {
                            e = 20000;
                        }
                    } else {
                        e = qVar.e() + 10000;
                        z = false;
                    }
                    InteractionDataManager.this.commitVpm("1", z ? "1" : "0", str, Double.valueOf(System.currentTimeMillis() - currentTimeMillis), Double.valueOf(indexItem.offset), Double.valueOf(indexItem.length), String.valueOf(e));
                } finally {
                    a.g(qVar);
                }
            }
        });
    }

    private String request(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        r0 = null;
        String str = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                str = convertStreamToString(fileInputStream);
            } catch (IOException unused) {
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                a.g(fileInputStream2);
                throw th;
            }
        } catch (IOException unused2) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
        a.g(fileInputStream);
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String request(java.lang.String r5) {
        /*
            r4 = this;
            okhttp3.OkHttpClient r0 = new okhttp3.OkHttpClient
            r0.<init>()
            okhttp3.o$a r1 = new okhttp3.o$a
            r1.<init>()
            okhttp3.o$a r5 = r1.k(r5)
            okhttp3.o$a r5 = r5.c()
            okhttp3.o r5 = r5.b()
            okhttp3.Call r5 = r0.newCall(r5)
            okhttp3.q r5 = r5.execute()
            java.lang.String r0 = "Content-MD5"
            java.lang.String r0 = r5.g(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L4e
            java.io.File r1 = com.youku.playerservice.axp.modules.postprocessing.rotation.InteractionDataManager.cacheDir
            if (r1 == 0) goto L4e
            boolean r1 = r1.exists()
            if (r1 == 0) goto L4e
            java.io.File r1 = new java.io.File
            java.io.File r2 = com.youku.playerservice.axp.modules.postprocessing.rotation.InteractionDataManager.cacheDir
            byte[] r3 = com.youku.playerservice.axp.utils.BinaryUtil.fromBase64String(r0)
            java.lang.String r3 = com.youku.playerservice.axp.utils.BinaryUtil.bytesToHexString(r3)
            r1.<init>(r2, r3)
            boolean r2 = r4.checkDstFile(r1, r0)
            if (r2 == 0) goto L4e
            java.lang.String r1 = r4.request(r1)
            goto L4f
        L4e:
            r1 = 0
        L4f:
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L70
            okhttp3.r r5 = r5.a()
            java.lang.String r1 = r5.k()
            boolean r5 = android.text.TextUtils.isEmpty(r0)
            if (r5 != 0) goto L70
            java.io.File r5 = com.youku.playerservice.axp.modules.postprocessing.rotation.InteractionDataManager.cacheDir
            if (r5 == 0) goto L70
            boolean r5 = r5.exists()
            if (r5 == 0) goto L70
            r4.saveString2File(r1, r0)
        L70:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.playerservice.axp.modules.postprocessing.rotation.InteractionDataManager.request(java.lang.String):java.lang.String");
    }

    private void requestPlayConf(JSONObject jSONObject) {
        int i;
        TLogUtil.loge(TAG, "InteractionDataManager playConf" + jSONObject);
        String string = jSONObject.getString("version");
        this.versionStr = string;
        if (string.contains(".")) {
            string = string.substring(0, string.indexOf("."));
        }
        try {
            i = Integer.parseInt(string);
        } catch (Exception unused) {
            i = 1;
        }
        if (i < 2 || i >= 3) {
            return;
        }
        this.mUrl = jSONObject.getString("configFile");
        this.mIndexUrl = jSONObject.getString("indexFile");
        if (TextUtils.isEmpty(this.mUrl)) {
            return;
        }
        TaskRunnerProviderProxy.execute(this);
    }

    private void saveString2File(String str, String str2) {
        FileWriter fileWriter = null;
        try {
            try {
                try {
                    FileWriter fileWriter2 = new FileWriter(new File(cacheDir, BinaryUtil.bytesToHexString(BinaryUtil.fromBase64String(str2))));
                    try {
                        fileWriter2.write(str);
                        fileWriter2.close();
                    } catch (Exception e) {
                        e = e;
                        fileWriter = fileWriter2;
                        e.printStackTrace();
                        if (fileWriter != null) {
                            fileWriter.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileWriter = fileWriter2;
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        }
    }

    public Map<Integer, String> getData(double d) {
        Map.Entry<Double, InteractionData> higherEntry;
        try {
            TreeMap<Double, InteractionData> treeMap = this.mDataMap;
            if (treeMap == null || (higherEntry = treeMap.higherEntry(Double.valueOf(d))) == null) {
                return null;
            }
            InteractionData value = higherEntry.getValue();
            if (value.startTime <= d) {
                return value.data;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public Data.Frame getFrame(double d) {
        try {
            Map<Double, Data.Frame> map = this.mFrameMap;
            if (map != null) {
                return map.get(Double.valueOf(new BigDecimal(d).setScale(2, 4).doubleValue()));
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public Map<String, Data.Person> getPersons() {
        return this.mPersonMap;
    }

    public PlayParams getPlayParams() {
        PlayInfo playInfo = this.mPlayInfo;
        if (playInfo != null) {
            return playInfo.getPlayParams();
        }
        return null;
    }

    public int getRequestState() {
        return this.requestState;
    }

    public String request(URI uri) {
        String scheme = uri.getScheme();
        if (!TextUtils.isEmpty(scheme)) {
            String lowerCase = scheme.toLowerCase();
            if (TextUtils.equals(lowerCase, "http") || TextUtils.equals(lowerCase, "https")) {
                return request(uri.toString());
            }
        }
        return request(new File(uri.toString()));
    }

    public void request(PlayInfo playInfo, BitStream bitStream) {
        PlayInfoResponse playInfoResponse;
        if (playInfo == null || bitStream == null || (playInfoResponse = playInfo.getPlayInfoResponse()) == null) {
            return;
        }
        this.mPlayInfo = playInfo;
        this.requestVid = playInfo.getPlayId();
        boolean enableData = enableData((PlayInfoUpsResponse) playInfoResponse, bitStream);
        TLogUtil.loge(TAG, "enableData " + enableData);
        if (!enableData) {
            this.requestState = -2;
            return;
        }
        this.requestState = -1;
        this.mBitStream = bitStream;
        JSONObject hlsPlayConf = bitStream.getHlsPlayConf();
        if (hlsPlayConf != null) {
            requestPlayConf(hlsPlayConf);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Runnable runnable;
        Runnable runnable2;
        try {
            TLogUtil.loge(TAG, "算法数据开始请求：" + toString() + " " + this.mUrl);
            z = parseInteractionData(this.mUrl, this.mIndexUrl, this.mStartTimeMs);
        } catch (Exception e) {
            e.printStackTrace();
            z = false;
        }
        if (!z) {
            TLogUtil.loge(TAG, "算法数据请求失败！！！ " + toString());
            this.requestState = 0;
            if (!isValid() || (runnable = this.mFailCallback) == null) {
                return;
            }
            runnable.run();
            return;
        }
        TLogUtil.loge(TAG, "算法数据请求成功 " + toString());
        this.requestState = 1;
        if (!isValid() || (runnable2 = this.mSuccessCallback) == null || this.callbackCalled) {
            return;
        }
        this.callbackCalled = true;
        runnable2.run();
    }

    public InteractionDataManager setOnFailCallback(Runnable runnable) {
        this.mFailCallback = runnable;
        return this;
    }

    public InteractionDataManager setOnSuccessCallback(Runnable runnable) {
        this.mSuccessCallback = runnable;
        return this;
    }

    public InteractionDataManager setStartTimeMs(int i) {
        this.mStartTimeMs = i;
        return this;
    }

    public String toString() {
        return getClass().getName() + m80.DINAMIC_PREFIX_AT + Integer.toHexString(hashCode()) + " " + super.toString();
    }
}
