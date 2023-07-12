package com.taobao.update.datasource.local;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.taobao.update.datasource.UpdateDataSource;
import com.taobao.update.datasource.local.UpdateInfo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* renamed from: com.taobao.update.datasource.local.a */
/* loaded from: classes11.dex */
public class C6922a {
    private static C6922a d;
    private SharedPreferences a;
    private String b;
    private UpdateInfo c;

    private C6922a(Context context) {
        this.a = PreferenceManager.getDefaultSharedPreferences(context);
        File file = new File(context.getCacheDir().getPath(), "mtl_update.json");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.b = file.getAbsolutePath();
    }

    private String a(InputStream inputStream) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb.append(readLine);
                sb.append(StringUtils.LF);
            } else {
                bufferedReader.close();
                return sb.toString();
            }
        }
    }

    private String b(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                String a = a(fileInputStream);
                fileInputStream.close();
                return a;
            }
            return "";
        } catch (Throwable th) {
            Log.e("Exception", "File read failed: " + th.toString());
            return "";
        }
    }

    private void c(String str, String str2) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(new File(str2)));
            outputStreamWriter.write(str);
            outputStreamWriter.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    public static C6922a getInstance(Context context) {
        if (d == null) {
            if (context == null) {
                context = UpdateDataSource.sContext;
            }
            d = new C6922a(context);
        }
        return d;
    }

    public void clearCache() {
        this.c = null;
        c("", this.b);
    }

    public UpdateInfo getCacheData() {
        return this.c;
    }

    public UpdateInfo getData() {
        if (this.c == null) {
            String b = b(this.b);
            if (!TextUtils.isEmpty(b)) {
                try {
                    this.c = (UpdateInfo) JSON.parseObject(b, UpdateInfo.class);
                } catch (Throwable unused) {
                }
            }
        }
        return this.c;
    }

    public String getSP(String str) {
        return this.a.getString(str, "");
    }

    public void resetData(UpdateInfo updateInfo) {
        this.c = updateInfo;
        updateInfo.lastUpdateTime = System.currentTimeMillis();
        c(JSON.toJSONString(this.c), this.b);
    }

    public void resetMemoryData(UpdateInfo updateInfo) {
        this.c = updateInfo;
        updateInfo.lastUpdateTime = System.currentTimeMillis();
    }

    public void updateData(UpdateInfo updateInfo) {
        Map<String, UpdateInfo.UpdateData> map;
        if (updateInfo == null || (map = updateInfo.updateList) == null) {
            return;
        }
        UpdateInfo updateInfo2 = this.c;
        if (updateInfo2 == null) {
            this.c = updateInfo;
        } else {
            updateInfo2.updateList.putAll(map);
        }
        this.c.updateList.remove("cmd");
        this.c.lastUpdateTime = System.currentTimeMillis();
        c(JSON.toJSONString(this.c), this.b);
    }

    public void updateSP(String str, String str2) {
        SharedPreferences.Editor edit = this.a.edit();
        edit.putString(str, str2);
        edit.apply();
    }
}
