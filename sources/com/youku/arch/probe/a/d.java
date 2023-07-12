package com.youku.arch.probe.a;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.probe.plugins.b;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class d {
    private static transient /* synthetic */ IpChange $ipChange;
    private e a;
    private volatile SQLiteDatabase b;
    private volatile int c;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    private static class a {
        private static final d a = new d();
    }

    private d() {
        this.c = 0;
    }

    public static d a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-435835151") ? (d) ipChange.ipc$dispatch("-435835151", new Object[0]) : a.a;
    }

    public String a(int i, Map<Integer, Integer> map) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        IpChange ipChange = $ipChange;
        int i2 = 2;
        int i3 = 1;
        int i4 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-2079952356")) {
            return (String) ipChange.ipc$dispatch("-2079952356", new Object[]{this, Integer.valueOf(i), map});
        }
        StringBuilder sb = new StringBuilder();
        if (this.b != null) {
            SQLiteDatabase sQLiteDatabase2 = this.b;
            String[] strArr = null;
            Cursor rawQuery = sQLiteDatabase2.rawQuery("select hh,sum(flag) from(select strftime(\"%d\",time,'unixepoch','localtime'),strftime(\"%H\",time,'unixepoch','localtime') as hh,1 as flag from speed_history_table where mac = '4G' group by strftime(\"%d\",time,'unixepoch','localtime'),strftime(\"%H\",time,'unixepoch','localtime'))group by hh order by sum(flag) DESC limit 4", null);
            int i5 = 0;
            while (rawQuery.moveToNext()) {
                int i6 = rawQuery.getInt(i4);
                int i7 = rawQuery.getInt(i3);
                i5 += i3;
                Cursor rawQuery2 = sQLiteDatabase2.rawQuery("select avg(s10),avg(s50),avg(s90) from speed_history_table where mac = '4G' and strftime(\"%H\",time,'unixepoch','localtime') = '" + i6 + "'", strArr);
                while (rawQuery2.moveToNext()) {
                    double d = rawQuery2.getDouble(i4);
                    if (d > 0.0d) {
                        double d2 = rawQuery2.getDouble(i3);
                        double d3 = rawQuery2.getDouble(i2);
                        if (i5 <= i2) {
                            sb.append(i6);
                            sb.append("/");
                            sb.append(i7);
                            sb.append("/");
                            Object[] objArr = new Object[i3];
                            objArr[0] = Double.valueOf(d);
                            sb.append(String.format("%.2f", objArr));
                            sb.append("/");
                            Object[] objArr2 = new Object[i3];
                            objArr2[0] = Double.valueOf(d2);
                            sb.append(String.format("%.2f", objArr2));
                            sb.append("/");
                            Object[] objArr3 = new Object[i3];
                            objArr3[0] = Double.valueOf(d3);
                            sb.append(String.format("%.2f", objArr3));
                            sb.append("-");
                        }
                        if (i7 >= 3 && i > 0) {
                            sQLiteDatabase = sQLiteDatabase2;
                            cursor = rawQuery;
                            if (i7 / Double.valueOf(i).doubleValue() >= 0.5d) {
                                map.put(Integer.valueOf(i6), Integer.valueOf(i7));
                                if (i5 > 2) {
                                    sb.append(i6);
                                    sb.append("/");
                                    sb.append(i7);
                                    sb.append("/");
                                    sb.append(String.format("%.2f", Double.valueOf(d)));
                                    sb.append("/");
                                    sb.append(String.format("%.2f", Double.valueOf(d2)));
                                    sb.append("/");
                                    sb.append(String.format("%.2f", Double.valueOf(d3)));
                                    sb.append("-");
                                    sQLiteDatabase2 = sQLiteDatabase;
                                    rawQuery = cursor;
                                    i2 = 2;
                                    i3 = 1;
                                    i4 = 0;
                                }
                                sQLiteDatabase2 = sQLiteDatabase;
                                rawQuery = cursor;
                                i2 = 2;
                                i3 = 1;
                                i4 = 0;
                            }
                            sQLiteDatabase2 = sQLiteDatabase;
                            rawQuery = cursor;
                            i2 = 2;
                            i3 = 1;
                            i4 = 0;
                        }
                    }
                    sQLiteDatabase = sQLiteDatabase2;
                    cursor = rawQuery;
                    sQLiteDatabase2 = sQLiteDatabase;
                    rawQuery = cursor;
                    i2 = 2;
                    i3 = 1;
                    i4 = 0;
                }
                rawQuery2.close();
                sQLiteDatabase2 = sQLiteDatabase2;
                rawQuery = rawQuery;
                i2 = 2;
                i3 = 1;
                i4 = 0;
                strArr = null;
            }
            rawQuery.close();
        }
        return sb.toString();
    }

    public String a(String str) {
        StringBuilder sb;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1121374196")) {
            return (String) ipChange.ipc$dispatch("1121374196", new Object[]{this, str});
        }
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(11);
        calendar.get(7);
        StringBuilder sb2 = new StringBuilder(i);
        if (this.b != null) {
            SQLiteDatabase sQLiteDatabase = this.b;
            if (str == null) {
                sb = new StringBuilder();
                sb.append("select count(*) from speed_history_table where strftime(\"%H\",time,'unixepoch','localtime') = '");
                sb.append(i);
            } else {
                sb = new StringBuilder();
                sb.append("select count(*) from speed_history_table where strftime(\"%H\",time,'unixepoch','localtime') = '");
                sb.append(i);
                sb.append("'");
                sb.append(" and mac = ");
                sb.append("'");
                sb.append(str);
            }
            sb.append("'");
            Cursor rawQuery = sQLiteDatabase.rawQuery(sb.toString(), null);
            int i2 = 0;
            while (rawQuery.moveToNext()) {
                i2 = rawQuery.getInt(0);
                if (i2 > 0) {
                    sb2.append(i2);
                    sb2.append("/");
                }
            }
            rawQuery.close();
            if (i2 > 0) {
                ArrayList<Double> a2 = a(str, i);
                Collections.sort(a2);
                String a3 = com.youku.arch.probe.plugins.b.a(a2, 10.0d);
                String a4 = com.youku.arch.probe.plugins.b.a(a2, 50.0d);
                String a5 = com.youku.arch.probe.plugins.b.a(a2, 90.0d);
                sb2.append(a3);
                sb2.append("/");
                sb2.append(a4);
                sb2.append("/");
                sb2.append(a5);
                sb2.append("/");
            }
        }
        Log.d("dbtest", str + " curHourBW:" + sb2.toString());
        return sb2.toString();
    }

    public ArrayList<Double> a(String str, int i) {
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1470773071")) {
            return (ArrayList) ipChange.ipc$dispatch("-1470773071", new Object[]{this, str, Integer.valueOf(i)});
        }
        ArrayList<Double> arrayList = new ArrayList<>();
        if (this.b != null) {
            SQLiteDatabase sQLiteDatabase = this.b;
            if (i <= 0) {
                str2 = "select speedArray from speed_history_table where mac =\"" + str + "\"";
            } else if (str != null) {
                str2 = "select speedArray from speed_history_table where strftime(\"%H\",time,'unixepoch','localtime')= '" + i + "' and mac =\"" + str + "\"";
            } else {
                str2 = "select speedArray from speed_history_table where strftime(\"%H\",time,'unixepoch','localtime')= '" + i + "'";
            }
            Cursor rawQuery = sQLiteDatabase.rawQuery(str2, null);
            while (rawQuery.moveToNext()) {
                if (arrayList.size() < 100000) {
                    String string = rawQuery.getString(0);
                    if (string.length() > 2) {
                        for (String str3 : string.substring(1, string.length() - 1).split(",")) {
                            arrayList.add(Double.valueOf(Double.parseDouble(str3.trim())));
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public void a(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1880649315")) {
            ipChange.ipc$dispatch("1880649315", new Object[]{this, map});
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.b != null) {
            SQLiteDatabase sQLiteDatabase = this.b;
            for (String str : map.keySet()) {
                sQLiteDatabase.execSQL("REPLACE INTO general_speed_table values(?,?,?)", new Object[]{str, Long.valueOf(currentTimeMillis), map.get(str)});
            }
        }
    }

    public boolean a(List<b.a> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1811568087")) {
            return ((Boolean) ipChange.ipc$dispatch("1811568087", new Object[]{this, list})).booleanValue();
        }
        if (this.b != null) {
            SQLiteDatabase sQLiteDatabase = this.b;
            for (b.a aVar : list) {
                sQLiteDatabase.execSQL("insert into speed_history_table values(?,?,?,?,?,?,?,?,?,?,?)", new Object[]{null, aVar.a, Long.valueOf(aVar.c), Long.valueOf(aVar.d), aVar.b, aVar.e, aVar.g, aVar.h, aVar.i, aVar.f, Integer.valueOf(aVar.j)});
            }
            return true;
        }
        return false;
    }

    public String b(Map<Integer, Integer> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "871690492")) {
            return (String) ipChange.ipc$dispatch("871690492", new Object[]{this, map});
        }
        StringBuilder sb = new StringBuilder();
        if (this.b != null) {
            SQLiteDatabase sQLiteDatabase = this.b;
            ArrayList arrayList = new ArrayList(map.keySet());
            Collections.sort(arrayList);
            ArrayList arrayList2 = new ArrayList();
            int i = -10;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = ((Integer) it.next()).intValue();
                if (intValue - 1 != i) {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(Integer.valueOf(intValue));
                    arrayList2.add(arrayList3);
                } else if (arrayList2.size() > 0) {
                    ((ArrayList) arrayList2.get(arrayList2.size() - 1)).add(Integer.valueOf(intValue));
                }
                i = intValue;
            }
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                ArrayList arrayList4 = (ArrayList) it2.next();
                if (arrayList4.size() > 0) {
                    String valueOf = String.valueOf(arrayList4.get(0));
                    String valueOf2 = String.valueOf(arrayList4.get(arrayList4.size() - 1));
                    Cursor rawQuery = sQLiteDatabase.rawQuery("select min(strftime(\"%H:%M\",start_time,'unixepoch','localtime')) from speed_history_table where strftime(\"%H\",time,'unixepoch','localtime') = ?", new String[]{valueOf});
                    while (rawQuery.moveToNext()) {
                        sb.append(rawQuery.getString(0));
                        sb.append("/");
                    }
                    rawQuery.close();
                    Cursor rawQuery2 = sQLiteDatabase.rawQuery("select max(strftime(\"%H:%M\",time,'unixepoch','localtime')) from speed_history_table where strftime(\"%H\",time,'unixepoch','localtime') = ?", new String[]{valueOf2});
                    while (rawQuery2.moveToNext()) {
                        sb.append(rawQuery2.getString(0));
                        sb.append("-");
                    }
                    rawQuery2.close();
                }
            }
        }
        return sb.toString();
    }

    public Map<String, String> b(List<b.a> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1955856665")) {
            return (Map) ipChange.ipc$dispatch("-1955856665", new Object[]{this, list});
        }
        HashMap hashMap = new HashMap();
        if (this.b != null) {
            for (b.a aVar : list) {
                ArrayList<Double> a2 = a(aVar.a, -1);
                Collections.sort(a2);
                String a3 = com.youku.arch.probe.plugins.b.a(a2, 10.0d);
                String a4 = com.youku.arch.probe.plugins.b.a(a2, 50.0d);
                String a5 = com.youku.arch.probe.plugins.b.a(a2, 90.0d);
                hashMap.put(aVar.a, a3 + "/" + a4 + "/" + a5);
            }
        }
        return hashMap;
    }

    public synchronized void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "674120001")) {
            ipChange.ipc$dispatch("674120001", new Object[]{this});
            return;
        }
        if (this.a != null) {
            this.c++;
            if (this.c == 1) {
                this.b = this.a.getWritableDatabase();
            }
        }
    }

    public synchronized void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "674149792")) {
            ipChange.ipc$dispatch("674149792", new Object[]{this});
            return;
        }
        this.c--;
        if (this.c == 0) {
            this.b.close();
        }
    }

    public Map<String, String> d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-986426892")) {
            return (Map) ipChange.ipc$dispatch("-986426892", new Object[]{this});
        }
        HashMap hashMap = null;
        if (this.b != null) {
            Cursor rawQuery = this.b.rawQuery("select * from general_speed_table", null);
            hashMap = new HashMap();
            while (rawQuery.moveToNext()) {
                String string = rawQuery.getString(0);
                double d = rawQuery.getDouble(1);
                String string2 = rawQuery.getString(2);
                if (string != null) {
                    hashMap.put(string, string2);
                }
                Log.d("dbtest", string + "-" + d + "-" + string2);
            }
            rawQuery.close();
        }
        return hashMap;
    }

    public boolean e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "674209378")) {
            return ((Boolean) ipChange.ipc$dispatch("674209378", new Object[]{this})).booleanValue();
        }
        if (this.b != null) {
            SQLiteDatabase sQLiteDatabase = this.b;
            sQLiteDatabase.execSQL("delete from speed_history_table where time <" + ((System.currentTimeMillis() / 1000) - 2592000));
            sQLiteDatabase.execSQL("delete from speed_history_table where id <((select max(id) from speed_history_table) - " + com.youku.arch.probe.a.a.s + jn1.BRACKET_END_STR);
            Cursor rawQuery = sQLiteDatabase.rawQuery("select count(*) from general_speed_table", null);
            int i = -1;
            while (rawQuery.moveToNext()) {
                i = rawQuery.getInt(0);
            }
            while (true) {
                rawQuery.close();
                if (i < 20) {
                    break;
                }
                sQLiteDatabase.execSQL("delete from general_speed_table where time=(select min(time) from general_speed_table)");
                rawQuery = sQLiteDatabase.rawQuery("select count(*) from general_speed_table", null);
                while (rawQuery.moveToNext()) {
                    i = rawQuery.getInt(0);
                }
            }
        }
        return false;
    }

    public int f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "674239152")) {
            return ((Integer) ipChange.ipc$dispatch("674239152", new Object[]{this})).intValue();
        }
        if (this.b != null) {
            Cursor rawQuery = this.b.rawQuery("select count(distinct strftime(\"%d\",time,'unixepoch','localtime')) from speed_history_table", null);
            int i = 0;
            while (rawQuery.moveToNext()) {
                i = rawQuery.getInt(0);
            }
            rawQuery.close();
            return i;
        }
        return 0;
    }
}
