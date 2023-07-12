package cn.damai.common.image.luban;

import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;

/* compiled from: Taobao */
/* renamed from: cn.damai.common.image.luban.b */
/* loaded from: classes13.dex */
public class C0517b {
    private static transient /* synthetic */ IpChange $ipChange;

    private static String a(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1672886786")) {
            return (String) ipChange.ipc$dispatch("1672886786", new Object[]{Long.valueOf(j)});
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        if (j == 0) {
            return "0B";
        }
        if (j < 1024) {
            return decimalFormat.format(j) + "B";
        } else if (j < 1048576) {
            return decimalFormat.format(j / 1024.0d) + "KB";
        } else if (j < 1073741824) {
            return decimalFormat.format(j / 1048576.0d) + "MB";
        } else {
            return decimalFormat.format(j / 1.073741824E9d) + "GB";
        }
    }

    public static String b(String str) {
        long c;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "348474864")) {
            return (String) ipChange.ipc$dispatch("348474864", new Object[]{str});
        }
        File file = new File(str);
        long j = 0;
        try {
            if (file.isDirectory()) {
                c = d(file);
            } else {
                c = c(file);
            }
            j = c;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("获取文件大小", "获取失败!");
        }
        return a(j);
    }

    public static long c(File file) throws Exception {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1321576600")) {
            return ((Long) ipChange.ipc$dispatch("-1321576600", new Object[]{file})).longValue();
        }
        if (file.exists()) {
            return new FileInputStream(file).available();
        }
        file.createNewFile();
        Log.e("获取文件大小", "文件不存在!");
        return 0L;
    }

    private static long d(File file) throws Exception {
        long c;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-16871995")) {
            return ((Long) ipChange.ipc$dispatch("-16871995", new Object[]{file})).longValue();
        }
        long j = 0;
        File[] listFiles = file.listFiles();
        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i].isDirectory()) {
                c = d(listFiles[i]);
            } else {
                c = c(listFiles[i]);
            }
            j += c;
        }
        return j;
    }
}
