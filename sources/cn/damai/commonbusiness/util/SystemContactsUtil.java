package cn.damai.commonbusiness.util;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import cn.damai.common.util.CompliantUtUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class SystemContactsUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class ContactInfo implements Parcelable {
        private static transient /* synthetic */ IpChange $ipChange;
        public static final Parcelable.Creator<ContactInfo> CREATOR = new a();
        private String contactName;
        private String phoneNum;

        /* compiled from: Taobao */
        /* loaded from: classes.dex */
        public class a implements Parcelable.Creator<ContactInfo> {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public ContactInfo createFromParcel(Parcel parcel) {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-1634802465") ? (ContactInfo) ipChange.ipc$dispatch("-1634802465", new Object[]{this, parcel}) : new ContactInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public ContactInfo[] newArray(int i) {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-243652848") ? (ContactInfo[]) ipChange.ipc$dispatch("-243652848", new Object[]{this, Integer.valueOf(i)}) : new ContactInfo[i];
            }
        }

        public ContactInfo() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1641769341")) {
                return ((Integer) ipChange.ipc$dispatch("1641769341", new Object[]{this})).intValue();
            }
            return 0;
        }

        public String getContactName() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1959641190") ? (String) ipChange.ipc$dispatch("1959641190", new Object[]{this}) : this.contactName;
        }

        public String getPhoneNum() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1078648755") ? (String) ipChange.ipc$dispatch("1078648755", new Object[]{this}) : this.phoneNum;
        }

        public void setContactName(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1680616496")) {
                ipChange.ipc$dispatch("-1680616496", new Object[]{this, str});
            } else {
                this.contactName = str;
            }
        }

        public void setPhoneNum(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-803954805")) {
                ipChange.ipc$dispatch("-803954805", new Object[]{this, str});
            } else {
                this.phoneNum = str;
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "101410030")) {
                ipChange.ipc$dispatch("101410030", new Object[]{this, parcel, Integer.valueOf(i)});
                return;
            }
            parcel.writeString(this.contactName);
            parcel.writeString(this.phoneNum);
        }

        protected ContactInfo(Parcel parcel) {
            this.contactName = parcel.readString();
            this.phoneNum = parcel.readString();
        }
    }

    private static String a(String str) {
        int length;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-739684767")) {
            return (String) ipChange.ipc$dispatch("-739684767", new Object[]{str});
        }
        StringBuilder sb = new StringBuilder();
        if (str != null && (length = str.trim().length()) != 0) {
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (Character.isDigit(charAt)) {
                    sb.append(charAt);
                }
            }
        }
        return sb.toString();
    }

    public static String b(String str, String str2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "41742505") ? (String) ipChange.ipc$dispatch("41742505", new Object[]{str, str2}) : f(a(str), str2);
    }

    public static String c(Context context, Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-958783702")) {
            return (String) ipChange.ipc$dispatch("-958783702", new Object[]{context, uri});
        }
        if (uri == null) {
            return null;
        }
        List<String> e = e(context, uri);
        if (e == null || e.size() <= 0) {
            return "";
        }
        String a = a(f(e.get(0), "+86"));
        CompliantUtUtils.e(a);
        return a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x007a, code lost:
        if (r9 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0084, code lost:
        if (r9 == null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0086, code lost:
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0089, code lost:
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static cn.damai.commonbusiness.util.SystemContactsUtil.ContactInfo d(android.content.Context r9, android.net.Uri r10) {
        /*
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.commonbusiness.util.SystemContactsUtil.$ipChange
            java.lang.String r1 = "739614525"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            if (r2 == 0) goto L1a
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r9
            r9 = 1
            r2[r9] = r10
            java.lang.Object r9 = r0.ipc$dispatch(r1, r2)
            cn.damai.commonbusiness.util.SystemContactsUtil$ContactInfo r9 = (cn.damai.commonbusiness.util.SystemContactsUtil.ContactInfo) r9
            return r9
        L1a:
            r0 = 0
            if (r10 != 0) goto L1e
            return r0
        L1e:
            long r1 = android.content.ContentUris.parseId(r10)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
            android.content.ContentResolver r3 = r9.getContentResolver()     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
            android.net.Uri r4 = android.provider.ContactsContract.CommonDataKinds.Phone.CONTENT_URI     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
            r5 = 0
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
            r9.<init>()     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
            java.lang.String r10 = "contact_id="
            r9.append(r10)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
            r9.append(r1)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
            java.lang.String r6 = r9.toString()     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
            r7 = 0
            r8 = 0
            android.database.Cursor r9 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L7f
            if (r9 == 0) goto L7a
            int r10 = r9.getCount()     // Catch: java.lang.Exception -> L78 java.lang.Throwable -> L8a
            if (r10 <= 0) goto L7a
            boolean r10 = r9.moveToFirst()     // Catch: java.lang.Exception -> L78 java.lang.Throwable -> L8a
            if (r10 == 0) goto L7a
            java.lang.String r10 = "data1"
            int r10 = r9.getColumnIndex(r10)     // Catch: java.lang.Exception -> L78 java.lang.Throwable -> L8a
            java.lang.String r10 = r9.getString(r10)     // Catch: java.lang.Exception -> L78 java.lang.Throwable -> L8a
            java.lang.String r10 = a(r10)     // Catch: java.lang.Exception -> L78 java.lang.Throwable -> L8a
            cn.damai.common.util.CompliantUtUtils.e(r10)     // Catch: java.lang.Exception -> L78 java.lang.Throwable -> L8a
            java.lang.String r1 = "display_name"
            int r1 = r9.getColumnIndex(r1)     // Catch: java.lang.Exception -> L78 java.lang.Throwable -> L8a
            java.lang.String r1 = r9.getString(r1)     // Catch: java.lang.Exception -> L78 java.lang.Throwable -> L8a
            cn.damai.commonbusiness.util.SystemContactsUtil$ContactInfo r2 = new cn.damai.commonbusiness.util.SystemContactsUtil$ContactInfo     // Catch: java.lang.Exception -> L78 java.lang.Throwable -> L8a
            r2.<init>()     // Catch: java.lang.Exception -> L78 java.lang.Throwable -> L8a
            r2.setContactName(r1)     // Catch: java.lang.Exception -> L78 java.lang.Throwable -> L8a
            r2.setPhoneNum(r10)     // Catch: java.lang.Exception -> L78 java.lang.Throwable -> L8a
            r9.close()
            return r2
        L78:
            r10 = move-exception
            goto L81
        L7a:
            if (r9 == 0) goto L89
            goto L86
        L7d:
            r10 = move-exception
            goto L8c
        L7f:
            r10 = move-exception
            r9 = r0
        L81:
            r10.printStackTrace()     // Catch: java.lang.Throwable -> L8a
            if (r9 == 0) goto L89
        L86:
            r9.close()
        L89:
            return r0
        L8a:
            r10 = move-exception
            r0 = r9
        L8c:
            if (r0 == 0) goto L91
            r0.close()
        L91:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.commonbusiness.util.SystemContactsUtil.d(android.content.Context, android.net.Uri):cn.damai.commonbusiness.util.SystemContactsUtil$ContactInfo");
    }

    public static List<String> e(Context context, Uri uri) {
        ArrayList arrayList;
        Exception e;
        Cursor cursor;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1741237242")) {
            return (List) ipChange.ipc$dispatch("1741237242", new Object[]{context, uri});
        }
        Cursor cursor2 = null;
        ArrayList arrayList2 = null;
        try {
            long parseId = ContentUris.parseId(uri);
            cursor = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "contact_id=" + parseId, null, null);
            if (cursor != null) {
                try {
                    try {
                        arrayList = new ArrayList();
                        while (cursor.moveToNext()) {
                            try {
                                String string = cursor.getString(cursor.getColumnIndex("data1"));
                                if (!TextUtils.isEmpty(string)) {
                                    arrayList.add(string);
                                }
                            } catch (Exception e2) {
                                e = e2;
                                e.printStackTrace();
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return arrayList;
                            }
                        }
                        cursor.getString(cursor.getColumnIndex("display_name"));
                        arrayList2 = arrayList;
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    arrayList = null;
                }
            }
            if (cursor != null) {
                cursor.close();
                return arrayList2;
            }
            return arrayList2;
        } catch (Exception e4) {
            arrayList = null;
            e = e4;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static String f(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1580350283")) {
            return (String) ipChange.ipc$dispatch("-1580350283", new Object[]{str, str2});
        }
        if (TextUtils.isEmpty(str2) || str == null || str.length() == 0) {
            return str;
        }
        return str.startsWith(str2) ? f(str.substring(str2.length(), str.length()), str2) : str;
    }

    public static void g(Activity activity, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1088993622")) {
            ipChange.ipc$dispatch("-1088993622", new Object[]{activity, Integer.valueOf(i)});
            return;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.PICK");
        intent.setData(ContactsContract.Contacts.CONTENT_URI);
        try {
            if (intent.resolveActivity(activity.getPackageManager()) != null) {
                activity.startActivityForResult(intent, i);
            }
        } catch (ActivityNotFoundException e) {
            Log.d("contract", e.getMessage() + "");
        }
    }
}
