package com.youku.playerservice.axp.dof;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.playerservice.axp.item.BitStream;
import com.youku.playerservice.axp.playinfo.PlayInfoUpsResponse;
import com.youku.playerservice.axp.utils.ApsUtil;
import com.youku.playerservice.axp.utils.BinaryUtil;
import com.youku.playerservice.axp.utils.TLogUtil;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.o;
import okhttp3.q;
import tb.d01;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class DoFConfigManager {
    public static final String META_FILE_NAME = "dof_meta";
    private static final String TAG = "DoFConfigManager";

    private static OkHttpClient buildClient() {
        if (!dofHttpDnsEnable()) {
            Log.d(TAG, "Unuse HttpDns");
            return new OkHttpClient();
        }
        Log.d(TAG, "Use HttpDns");
        OkHttpClient.b bVar = new OkHttpClient.b();
        bVar.f(new Dns() { // from class: com.youku.playerservice.axp.dof.DoFConfigManager.1
            @Override // okhttp3.Dns
            public List<InetAddress> lookup(String str) {
                Log.d(DoFConfigManager.TAG, "lookup:" + str);
                ArrayList<d01.a> b = d01.b(DoFConfigManager.dofConfigDomainName(), true);
                if (b != null && b.size() > 0) {
                    String b2 = b.get(0).b();
                    String d = b.get(0).d();
                    Log.d(DoFConfigManager.TAG, "ip:[" + b2 + "],protocol:[" + d + jn1.ARRAY_END_STR);
                    if (b2 != null && !b2.equals("")) {
                        List<InetAddress> asList = Arrays.asList(InetAddress.getAllByName(b2));
                        Log.d(DoFConfigManager.TAG, "inetAddresses:" + asList);
                        return asList;
                    }
                }
                return Dns.SYSTEM.lookup(str);
            }
        });
        return bVar.b();
    }

    private static boolean checkDstFile(File file, String str) {
        return TextUtils.isEmpty(str) ? file.exists() : file.exists() && TextUtils.equals(str, BinaryUtil.toBase64String(BinaryUtil.calculateMd5(file)));
    }

    public static String dofConfigDomainName() {
        String config = ConfigFetcher.getInstance().getConfig("fvv_config", "config_domain_name", "sf.ykimg.com");
        Log.d(ApsUtil.TAG, "dofConfigDomainName: config" + config);
        return config;
    }

    public static boolean dofHttpDnsEnable() {
        String config = ConfigFetcher.getInstance().getConfig("fvv_config", "httpdns_enable", "1");
        Log.d(ApsUtil.TAG, "dofHttpDnsEnable: config" + config);
        return "1".equalsIgnoreCase(config);
    }

    public static boolean download(Context context, PlayInfoUpsResponse playInfoUpsResponse) {
        boolean z;
        List<BitStream> bitStreamList = playInfoUpsResponse.getBitStreamList();
        if (bitStreamList != null) {
            for (BitStream bitStream : bitStreamList) {
                if (bitStream != null) {
                    String dofConfigFile = bitStream.getDofConfigFile();
                    if (TextUtils.isEmpty(dofConfigFile)) {
                        continue;
                    } else {
                        String filePath = getFilePath(context, dofConfigFile);
                        if (TextUtils.isEmpty(filePath) || !new File(filePath).exists()) {
                            z = true;
                            break;
                        }
                        bitStream.putString(dofConfigFile, filePath);
                    }
                }
            }
        }
        z = false;
        return !z;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0108 A[Catch: IOException -> 0x0104, TRY_LEAVE, TryCatch #7 {IOException -> 0x0104, blocks: (B:58:0x0100, B:62:0x0108), top: B:75:0x0100 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0100 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x00ea -> B:55:0x00fc). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void downloadFile(java.io.File r12, java.lang.String r13, okhttp3.q r14) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.playerservice.axp.dof.DoFConfigManager.downloadFile(java.io.File, java.lang.String, okhttp3.q):void");
    }

    public static String getDoFDir(Context context) {
        if (context == null || context.getExternalCacheDir() == null) {
            throw new IOException("No Cache Dir");
        }
        return context.getExternalCacheDir().getAbsolutePath() + "/" + META_FILE_NAME;
    }

    public static String getFilePath(Context context, String str) {
        TLogUtil.playLog("getFilePath request " + str);
        try {
            q execute = buildClient().newCall(new o.a().k(str).c().b()).execute();
            String g = execute.g("Content-MD5");
            TLogUtil.playLog("getFilePath ossContentMD5=" + g);
            String substring = TextUtils.isEmpty(g) ? str.substring(str.lastIndexOf("/")) : BinaryUtil.bytesToHexString(BinaryUtil.fromBase64String(g));
            TLogUtil.playLog("getFilePath fileName=" + substring);
            File file = new File(getDoFDir(context));
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, substring);
            if (checkDstFile(file2, g)) {
                execute.close();
                String absolutePath = file2.getAbsolutePath();
                TLogUtil.playLog("getFilePath path=" + absolutePath);
                return absolutePath;
            }
            downloadFile(file, substring, execute);
            String absolutePath2 = checkDstFile(file2, g) ? file2.getAbsolutePath() : null;
            TLogUtil.playLog("getFilePath path=" + absolutePath2);
            return absolutePath2;
        } catch (IOException e) {
            e.printStackTrace();
            TLogUtil.playLog("IOException " + e.toString());
            return null;
        }
    }
}
