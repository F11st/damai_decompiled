package com.youku.live.dago.widgetlib.ailpbaselib.utils;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class UriUtils {
    private static transient /* synthetic */ IpChange $ipChange;

    public static Uri formatImageUri(Context context, File file) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1972424330")) {
            return (Uri) ipChange.ipc$dispatch("-1972424330", new Object[]{context, file});
        }
        String absolutePath = file.getAbsolutePath();
        Cursor cursor = null;
        try {
            Cursor query = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=? ", new String[]{absolutePath}, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        int i = query.getInt(query.getColumnIndex("_id"));
                        Uri parse = Uri.parse("content://media/external/images/media");
                        Uri withAppendedPath = Uri.withAppendedPath(parse, "" + i);
                        try {
                            query.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return withAppendedPath;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = query;
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            if (!file.exists()) {
                if (query != null) {
                    try {
                        query.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("_data", absolutePath);
            Uri insert = context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            if (query != null) {
                try {
                    query.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            return insert;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String formatUri(Context context, Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-180187116")) {
            return (String) ipChange.ipc$dispatch("-180187116", new Object[]{context, uri});
        }
        Uri uri2 = null;
        if (Build.VERSION.SDK_INT >= 19 && DocumentsContract.isDocumentUri(context, uri)) {
            if (isExternalStorageDocumentsUri(uri)) {
                String[] split = DocumentsContract.getDocumentId(uri).split(":");
                if ("primary".equalsIgnoreCase(split[0])) {
                    return AppContextUtils.getApp().getFilesDir().getAbsolutePath() + "/" + split[1];
                }
            } else if (isDownloadsDocumentsUri(uri)) {
                return getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
            } else {
                if (isMediaDocumentsUri(uri)) {
                    String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                    String str = split2[0];
                    if ("image".equals(str)) {
                        uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equals(str)) {
                        uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if ("audio".equals(str)) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    return getDataColumn(context, uri2, "_id=?", new String[]{split2[1]});
                }
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            if (isGooglePhotosContentUri(uri)) {
                return uri.getLastPathSegment();
            }
            return getDataColumn(context, uri, null, null);
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }
        return null;
    }

    private static String getDataColumn(Context context, Uri uri, String str, String[] strArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1626105994")) {
            return (String) ipChange.ipc$dispatch("-1626105994", new Object[]{context, uri, str, strArr});
        }
        Cursor cursor = null;
        try {
            Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(query.getColumnIndexOrThrow("_data"));
                        try {
                            query.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return string;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = query;
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            if (query != null) {
                try {
                    query.close();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean isDownloadsDocumentsUri(Uri uri) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "27434750") ? ((Boolean) ipChange.ipc$dispatch("27434750", new Object[]{uri})).booleanValue() : "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    private static boolean isExternalStorageDocumentsUri(Uri uri) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1704928381") ? ((Boolean) ipChange.ipc$dispatch("-1704928381", new Object[]{uri})).booleanValue() : "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    private static boolean isGooglePhotosContentUri(Uri uri) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1356391654") ? ((Boolean) ipChange.ipc$dispatch("-1356391654", new Object[]{uri})).booleanValue() : "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    private static boolean isMediaDocumentsUri(Uri uri) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1117323657") ? ((Boolean) ipChange.ipc$dispatch("-1117323657", new Object[]{uri})).booleanValue() : "com.android.providers.media.documents".equals(uri.getAuthority());
    }
}
