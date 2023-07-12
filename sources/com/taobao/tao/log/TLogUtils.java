package com.taobao.tao.log;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.alipay.android.phone.mobilesdk.socketcraft.monitor.MonitorItemConstants;
import com.taobao.weex.annotation.JSMethod;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tb.kh1;
import tb.m80;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TLogUtils {
    public static String DATE_TO_STRING_SHORT_PATTERN = "yyyyMMdd";

    public static boolean checkNetworkIsWifi(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED;
    }

    public static boolean cleanDir(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                boolean z = true;
                if (listFiles != null && listFiles.length > 0) {
                    for (File file2 : listFiles) {
                        z &= cleanDir(file2);
                    }
                }
                return z;
            }
            return file.delete();
        }
        return false;
    }

    public static LogLevel convertLogLevel(String str) {
        LogLevel logLevel = LogLevel.L;
        if ("ERROR".equalsIgnoreCase(str)) {
            return LogLevel.E;
        }
        if ("WARN".equalsIgnoreCase(str)) {
            return LogLevel.W;
        }
        if (MonitorItemConstants.LEVEL_INFO.equalsIgnoreCase(str)) {
            return LogLevel.I;
        }
        if ("DEBUG".equalsIgnoreCase(str)) {
            return LogLevel.D;
        }
        return "VERBOSE".equalsIgnoreCase(str) ? LogLevel.V : logLevel;
    }

    public static boolean deleteDir(File file) {
        if (cleanDir(file) && file.exists()) {
            return file.delete();
        }
        return false;
    }

    private static List<File> getAllFile() {
        File[] listFiles;
        ArrayList arrayList = new ArrayList();
        File file = new File(TLogInitializer.getInstance().getFileDir());
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            arrayList.addAll(Arrays.asList(listFiles));
        }
        return arrayList;
    }

    public static String[] getDays(Integer num) {
        if (num.intValue() == 0) {
            return null;
        }
        Long l = 86400000L;
        try {
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            int intValue = num.intValue();
            Long[] lArr = new Long[intValue];
            String[] strArr = new String[num.intValue()];
            for (int i = 0; i < num.intValue(); i++) {
                long longValue = valueOf.longValue();
                long j = i;
                long longValue2 = l.longValue();
                Long.signum(j);
                lArr[i] = Long.valueOf(longValue - (j * longValue2));
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_TO_STRING_SHORT_PATTERN);
            for (int i2 = 0; i2 < intValue; i2++) {
                strArr[i2] = simpleDateFormat.format(new Date(lArr[i2].longValue()));
            }
            return strArr;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<String> getFilePath(String str, Integer num) {
        ArrayList arrayList = null;
        if (TextUtils.isEmpty(str) || TLogInitializer.getInstance().getFileDir() == null) {
            return null;
        }
        File file = new File(TLogInitializer.getInstance().getFileDir());
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                return null;
            }
            arrayList = new ArrayList();
            for (int i = 0; i < listFiles.length; i++) {
                String name = listFiles[i].getName();
                if (!TextUtils.isEmpty(name) && !name.endsWith("mmap2") && !name.equals(kh1.CACHE_MMAP)) {
                    if (name.equals(str)) {
                        arrayList.add(listFiles[i].getAbsolutePath());
                    } else if (name.endsWith(str)) {
                        String parseDataInName = parseDataInName(name);
                        if (parseDataInName != null && arrayList.size() > 0) {
                            int size = arrayList.size();
                            int i2 = 0;
                            while (true) {
                                if (i2 >= size) {
                                    break;
                                }
                                String parseDataInName2 = parseDataInName(new File((String) arrayList.get(i2)).getName());
                                if (parseDataInName2 != null) {
                                    if (parseDataInName.compareTo(parseDataInName2) <= 0) {
                                        arrayList.add(i2, listFiles[i].getAbsolutePath());
                                        break;
                                    } else if (i2 == size - 1) {
                                        arrayList.add(listFiles[i].getAbsolutePath());
                                        break;
                                    }
                                }
                                i2++;
                            }
                        } else {
                            arrayList.add(listFiles[i].getAbsolutePath());
                        }
                    }
                }
            }
        }
        if (num.intValue() > 0 && arrayList != null && arrayList.size() > num.intValue()) {
            int size2 = arrayList.size() - num.intValue();
            for (int i3 = 0; i3 < size2; i3++) {
                arrayList.remove(0);
            }
        }
        return arrayList;
    }

    public static List<String> getFilePathAll(String str, Integer num) {
        ArrayList arrayList = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List<File> allFile = getAllFile();
        if (!allFile.isEmpty()) {
            arrayList = new ArrayList();
            Iterator<File> it = allFile.iterator();
            while (true) {
                int i = 0;
                if (!it.hasNext()) {
                    break;
                }
                File next = it.next();
                String name = next.getName();
                if (!TextUtils.isEmpty(name) && !name.endsWith("mmap2") && !name.equals(kh1.CACHE_MMAP)) {
                    if (name.equals(str)) {
                        arrayList.add(next.getAbsolutePath());
                    } else if (name.endsWith(str)) {
                        String parseDataInName = parseDataInName(name);
                        if (parseDataInName != null && arrayList.size() > 0) {
                            int size = arrayList.size();
                            while (true) {
                                if (i >= size) {
                                    break;
                                }
                                String parseDataInName2 = parseDataInName(new File((String) arrayList.get(i)).getName());
                                if (parseDataInName2 != null) {
                                    if (parseDataInName.compareTo(parseDataInName2) <= 0) {
                                        arrayList.add(i, next.getAbsolutePath());
                                        break;
                                    } else if (i == size - 1) {
                                        arrayList.add(next.getAbsolutePath());
                                        break;
                                    }
                                }
                                i++;
                            }
                        } else {
                            arrayList.add(next.getAbsolutePath());
                        }
                    }
                }
            }
            if (num.intValue() > 0 && arrayList.size() > num.intValue()) {
                int size2 = arrayList.size() - num.intValue();
                for (int i2 = 0; i2 < size2; i2++) {
                    arrayList.remove(0);
                }
            }
        }
        return arrayList;
    }

    public static String getNetWorkType(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return "NOT_NETWORK";
        }
        int type = activeNetworkInfo.getType();
        if (type == 1) {
            return "WIFI";
        }
        if (type == 0) {
            switch (activeNetworkInfo.getSubtype()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return "2G";
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return "3G";
                case 13:
                    return "4G";
                default:
                    return null;
            }
        }
        return null;
    }

    public static Map<String, LogLevel> makeModule(String str) {
        HashMap hashMap = null;
        if (TextUtils.isEmpty(str) || str.equalsIgnoreCase("off")) {
            return null;
        }
        String[] split = str.split(",");
        if (split != null) {
            hashMap = new HashMap();
            for (String str2 : split) {
                String[] split2 = str2.split(m80.DINAMIC_PREFIX_AT);
                if (split2 != null && split2.length > 0) {
                    if (split2.length == 1) {
                        hashMap.put(split2[0], LogLevel.N);
                    } else if (split2.length == 2) {
                        hashMap.put(split2[0], convertLogLevel(split2[1]));
                    }
                }
            }
        }
        return hashMap;
    }

    public static String parseDataInName(String str) {
        String str2;
        int indexOf;
        String[] split = str.split(JSMethod.NOT_SET);
        if (split != null && split.length == 3) {
            return split[1];
        }
        if (split == null || split.length != 2 || (indexOf = (str2 = split[1]).indexOf(".")) == -1) {
            return null;
        }
        return str2.substring(0, indexOf);
    }

    public static List<String> getFilePathAll(String str, int i, String[] strArr) {
        ArrayList arrayList = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List<File> allFile = getAllFile();
        if (!allFile.isEmpty()) {
            arrayList = new ArrayList();
            Iterator<File> it = allFile.iterator();
            while (true) {
                int i2 = 0;
                if (!it.hasNext()) {
                    break;
                }
                File next = it.next();
                String name = next.getName();
                if (!TextUtils.isEmpty(name) && !name.endsWith("mmap2") && !name.equals(kh1.CACHE_MMAP)) {
                    if (name.equals(str)) {
                        arrayList.add(next.getAbsolutePath());
                    } else if (name.startsWith(str)) {
                        if (strArr != null) {
                            int length = strArr.length;
                            while (i2 < length) {
                                if (name.contains(strArr[i2])) {
                                    arrayList.add(next.getAbsolutePath());
                                }
                                i2++;
                            }
                        } else {
                            String parseDataInName = parseDataInName(name);
                            if (parseDataInName != null && arrayList.size() > 0) {
                                int size = arrayList.size();
                                while (true) {
                                    if (i2 >= size) {
                                        break;
                                    }
                                    String parseDataInName2 = parseDataInName(new File((String) arrayList.get(i2)).getName());
                                    if (parseDataInName2 != null) {
                                        if (parseDataInName.compareTo(parseDataInName2) <= 0) {
                                            arrayList.add(i2, next.getAbsolutePath());
                                            break;
                                        } else if (i2 == size - 1) {
                                            arrayList.add(next.getAbsolutePath());
                                            break;
                                        }
                                    }
                                    i2++;
                                }
                            } else {
                                arrayList.add(next.getAbsolutePath());
                            }
                        }
                    }
                }
            }
            if (i > 0 && arrayList.size() > i) {
                int size2 = arrayList.size() - i;
                for (int i3 = 0; i3 < size2; i3++) {
                    arrayList.remove(0);
                }
            }
        }
        return arrayList;
    }

    public static List<String> getFilePath(String str, int i, String[] strArr) {
        ArrayList arrayList = null;
        if (TextUtils.isEmpty(str) || TLogInitializer.getInstance().getFileDir() == null) {
            return null;
        }
        File file = new File(TLogInitializer.getInstance().getFileDir());
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                return null;
            }
            arrayList = new ArrayList();
            for (int i2 = 0; i2 < listFiles.length; i2++) {
                String name = listFiles[i2].getName();
                if (!TextUtils.isEmpty(name) && !name.endsWith("mmap2") && !name.endsWith(kh1.CACHE_MMAP)) {
                    if (name.equals(str)) {
                        arrayList.add(listFiles[i2].getAbsolutePath());
                    } else if (name.startsWith(str)) {
                        if (strArr != null) {
                            for (String str2 : strArr) {
                                if (name.contains(str2)) {
                                    arrayList.add(listFiles[i2].getAbsolutePath());
                                }
                            }
                        } else {
                            String parseDataInName = parseDataInName(name);
                            if (parseDataInName != null && arrayList.size() > 0) {
                                int size = arrayList.size();
                                int i3 = 0;
                                while (true) {
                                    if (i3 >= size) {
                                        break;
                                    }
                                    String parseDataInName2 = parseDataInName(new File((String) arrayList.get(i3)).getName());
                                    if (parseDataInName2 != null) {
                                        if (parseDataInName.compareTo(parseDataInName2) <= 0) {
                                            arrayList.add(i3, listFiles[i2].getAbsolutePath());
                                            break;
                                        } else if (i3 == size - 1) {
                                            arrayList.add(listFiles[i2].getAbsolutePath());
                                            break;
                                        }
                                    }
                                    i3++;
                                }
                            } else {
                                arrayList.add(listFiles[i2].getAbsolutePath());
                            }
                        }
                    }
                }
            }
        }
        if (i > 0 && arrayList != null && arrayList.size() > i) {
            int size2 = arrayList.size() - i;
            for (int i4 = 0; i4 < size2; i4++) {
                arrayList.remove(0);
            }
        }
        return arrayList;
    }
}
