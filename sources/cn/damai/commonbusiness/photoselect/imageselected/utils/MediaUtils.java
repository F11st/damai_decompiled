package cn.damai.commonbusiness.photoselect.imageselected.utils;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.text.TextUtils;
import cn.damai.commonbusiness.photoselect.imageselected.entry.Image;
import cn.damai.commonbusiness.photoselect.imageselected.model.ImageModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import tb.vo0;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class MediaUtils {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static MediaUtils a = null;
    public static int b = 1000;
    public static int c = (1000 * 500) * 1000;
    public static int d = 5;
    public static int e = 4;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.photoselect.imageselected.utils.MediaUtils$a */
    /* loaded from: classes4.dex */
    public class C0761a {
        boolean a;
        String b;

        public C0761a(MediaUtils mediaUtils) {
        }
    }

    public static MediaUtils c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1994698981")) {
            return (MediaUtils) ipChange.ipc$dispatch("-1994698981", new Object[0]);
        }
        if (a == null) {
            a = new MediaUtils();
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C0761a g(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1306050946")) {
            return (C0761a) ipChange.ipc$dispatch("-1306050946", new Object[]{this, Long.valueOf(j)});
        }
        C0761a c0761a = new C0761a(this);
        int i = b;
        if (j < i) {
            c0761a.b = j + "B";
            c0761a.a = false;
        } else if (j < i * i) {
            c0761a.b = (((int) j) / i) + "K";
            c0761a.a = false;
        } else {
            int i2 = (((int) j) / i) / i;
            int i3 = ((int) (j - ((i2 * i) * i))) / i;
            String valueOf = String.valueOf(i3);
            if (i3 < 9) {
                valueOf = "00" + i3;
            } else if (i3 < 99) {
                valueOf = "0" + i3;
            }
            try {
                double doubleValue = new BigDecimal(Float.valueOf(i2 + "." + valueOf).floatValue()).setScale(1, 4).doubleValue();
                StringBuilder sb = new StringBuilder();
                sb.append(doubleValue);
                sb.append("M");
                c0761a.b = sb.toString();
            } catch (Exception unused) {
                c0761a.b = i2 + "." + valueOf + "M";
            }
            int i4 = b;
            c0761a.a = ((i2 * i4) * i4) + (i3 * i4) > c;
        }
        return c0761a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C0761a h(long j) {
        long floor;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1561541070")) {
            return (C0761a) ipChange.ipc$dispatch("-1561541070", new Object[]{this, Long.valueOf(j)});
        }
        C0761a c0761a = new C0761a(this);
        int i = (((int) j) / 1000) / 60;
        if (i > 0) {
            floor = (int) Math.floor((j - ((i * 60) * 1000)) / 1000);
            String valueOf = String.valueOf(floor);
            if (floor < 10) {
                valueOf = "0" + floor;
            }
            c0761a.b = i + ":" + valueOf;
        } else {
            floor = (int) Math.floor(j / 1000);
            String valueOf2 = String.valueOf(floor);
            if (floor < 10) {
                valueOf2 = "0" + String.valueOf(floor);
            }
            c0761a.b = "0:" + valueOf2;
        }
        c0761a.a = ((long) (i * 60)) + floor < ((long) d);
        return c0761a;
    }

    public Bitmap d(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1348200887")) {
            return (Bitmap) ipChange.ipc$dispatch("1348200887", new Object[]{this, str});
        }
        Bitmap bitmap = null;
        if (Build.VERSION.SDK_INT >= 14) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                try {
                    mediaMetadataRetriever.setDataSource(str);
                    bitmap = mediaMetadataRetriever.getFrameAtTime();
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                }
            } finally {
                mediaMetadataRetriever.release();
            }
        }
        return bitmap;
    }

    public Bitmap e(String str, int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1484068873")) {
            return (Bitmap) ipChange.ipc$dispatch("-1484068873", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        }
        if (TextUtils.isEmpty(str) || Build.VERSION.SDK_INT < 8) {
            return null;
        }
        Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, i);
        return (i2 <= 0 || i3 <= 0) ? createVideoThumbnail : ThumbnailUtils.extractThumbnail(createVideoThumbnail, i2, i3, 2);
    }

    public ArrayList<Image> f(final Context context, final ImageModel.DataCallback dataCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-46299568")) {
            return (ArrayList) ipChange.ipc$dispatch("-46299568", new Object[]{this, context, dataCallback});
        }
        if (context == null) {
            return null;
        }
        final ArrayList<Image> arrayList = new ArrayList<>();
        new Thread(new Runnable() { // from class: cn.damai.commonbusiness.photoselect.imageselected.utils.MediaUtils.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                AnonymousClass1 anonymousClass1 = this;
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1179370287")) {
                    ipChange2.ipc$dispatch("1179370287", new Object[]{anonymousClass1});
                    return;
                }
                Cursor query = context.getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "title", "_display_name", "_data", "date_added", "_size", "duration", "bucket_id", "bucket_display_name"}, null, null, null);
                if (query != null && query.getCount() != 0) {
                    while (query.moveToNext()) {
                        String string = query.getString(query.getColumnIndex("title"));
                        String string2 = query.getString(query.getColumnIndex("_display_name"));
                        String string3 = query.getString(query.getColumnIndex("_data"));
                        long j = query.getLong(query.getColumnIndex("date_added"));
                        long j2 = query.getLong(query.getColumnIndex("_size"));
                        long j3 = query.getLong(query.getColumnIndex("duration"));
                        String string4 = query.getString(query.getColumnIndex("bucket_id"));
                        String string5 = query.getString(query.getColumnIndex("bucket_display_name"));
                        C0761a h = MediaUtils.this.h(j3);
                        String str = h.b;
                        boolean z = h.a;
                        C0761a g = MediaUtils.this.g(j2);
                        String str2 = g.b;
                        boolean z2 = g.a;
                        int indexOf = string3.indexOf(".");
                        Uri withAppendedId = ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, query.getLong(query.getColumnIndexOrThrow("_id")));
                        if (indexOf != -1) {
                            String substring = string3.substring(indexOf);
                            Image image = new Image();
                            image.setTitle(string);
                            image.setName(string2);
                            image.setType("2");
                            if (Build.VERSION.SDK_INT >= 29) {
                                image.setPath(withAppendedId.toString());
                            } else {
                                image.setPath(string3);
                            }
                            image.setAddDate(j);
                            image.setSize(j2);
                            image.setSizeShow(str2);
                            image.setLimitSize(z2);
                            image.setDuration(j3);
                            image.setDurationShow(str);
                            image.setLimitDur(z);
                            image.setBucketId(string4);
                            image.setBucketName(string5);
                            image.setSuffixType(substring);
                            anonymousClass1 = this;
                            arrayList.add(image);
                        } else {
                            anonymousClass1 = this;
                        }
                    }
                }
                query.close();
                Collections.reverse(arrayList);
                ArrayList<vo0> arrayList2 = new ArrayList<>();
                arrayList2.add(new vo0("所有视频", arrayList));
                dataCallback.onSuccess(arrayList2);
            }
        }).start();
        return arrayList;
    }
}
