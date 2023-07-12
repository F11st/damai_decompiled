package com.taobao.phenix.loader.file;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.util.TypedValue;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import tb.h62;
import tb.p22;
import tb.ur1;

/* compiled from: Taobao */
/* renamed from: com.taobao.phenix.loader.file.a */
/* loaded from: classes11.dex */
public class C6860a implements FileLoader {
    private static boolean a;

    public String a(Context context, String str, int i, boolean z) {
        Uri uri;
        Cursor queryMiniThumbnail;
        if (z) {
            uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        } else {
            uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        }
        ContentResolver contentResolver = context.getContentResolver();
        Cursor query = contentResolver.query(uri, new String[]{"_id"}, "_data=?", new String[]{str}, null);
        if (query != null) {
            r1 = query.moveToFirst() ? query.getInt(query.getColumnIndex("_id")) : -1L;
            query.close();
        }
        if (r1 > 0) {
            if (z) {
                queryMiniThumbnail = contentResolver.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, new String[]{"_data"}, "video_id=" + r1 + " AND kind=" + i, null, null);
            } else {
                queryMiniThumbnail = MediaStore.Images.Thumbnails.queryMiniThumbnail(contentResolver, r1, i, null);
            }
            if (queryMiniThumbnail != null) {
                r11 = queryMiniThumbnail.moveToFirst() ? queryMiniThumbnail.getString(queryMiniThumbnail.getColumnIndexOrThrow("_data")) : null;
                queryMiniThumbnail.close();
            }
        }
        return r11;
    }

    @Override // com.taobao.phenix.loader.file.FileLoader
    public p22 load(h62 h62Var, String str, Map<String, String> map) throws IOException, Resources.NotFoundException, UnSupportedSchemeException {
        int i;
        int i2 = h62Var.a;
        if (i2 != 33) {
            if (i2 == 34) {
                Context applicationContext = ur1.o().applicationContext();
                if (applicationContext != null) {
                    InputStream open = applicationContext.getResources().getAssets().open(h62Var.h);
                    return new p22(open, open.available());
                }
                throw new IOException("Phenix.with(Context) hasn't been called before FileLoader(asset) loading");
            } else if (i2 == 36) {
                Context applicationContext2 = ur1.o().applicationContext();
                if (applicationContext2 != null) {
                    TypedValue typedValue = new TypedValue();
                    InputStream openRawResource = applicationContext2.getResources().openRawResource(h62Var.i, typedValue);
                    return new p22(openRawResource, openRawResource.available(), typedValue);
                }
                throw new IOException("Phenix.with(Context) hasn't been called before FileLoader(resource) loading");
            } else if (i2 == 40) {
                byte[] decode = Base64.decode(h62Var.j, 0);
                return new p22(decode, 0, decode.length);
            } else if (i2 == 48) {
                try {
                    return ur1.o().i().get(h62Var.k).handleScheme(str);
                } catch (IndexOutOfBoundsException unused) {
                    throw new UnSupportedSchemeException(i2);
                }
            } else {
                throw new UnSupportedSchemeException(i2);
            }
        } else if (str.startsWith("content://")) {
            Context applicationContext3 = ur1.o().applicationContext();
            if (applicationContext3 != null) {
                InputStream openInputStream = applicationContext3.getContentResolver().openInputStream(Uri.parse(str));
                if (a && Build.VERSION.SDK_INT >= 29 && ((i = h62Var.l) == 1 || i == 3)) {
                    byte[] thumbnail = new ExifInterface(openInputStream).getThumbnail();
                    openInputStream.close();
                    openInputStream = (thumbnail == null || thumbnail.length <= 0) ? applicationContext3.getContentResolver().openInputStream(Uri.parse(str)) : new ByteArrayInputStream(thumbnail);
                }
                return new p22(openInputStream, openInputStream.available());
            }
            throw new IOException("Phenix.with(Context) hasn't been called before FileLoader UriContent loading");
        } else {
            String str2 = h62Var.h;
            int i3 = h62Var.l;
            if (i3 == 1 || i3 == 3) {
                Context applicationContext4 = ur1.o().applicationContext();
                if (applicationContext4 != null) {
                    String a2 = a(applicationContext4, str2, h62Var.l, false);
                    str2 = TextUtils.isEmpty(a2) ? a(applicationContext4, str2, h62Var.l, true) : a2;
                    if (TextUtils.isEmpty(str2) || !new File(str2).exists()) {
                        if (h62Var.m) {
                            str2 = h62Var.h;
                        } else {
                            throw new IOException("Retrieved thumbnail(type:" + h62Var.l + ") failed from local path");
                        }
                    }
                } else {
                    throw new IOException("Phenix.with(Context) hasn't been called before FileLoader(thumbnail) loading");
                }
            }
            File file = new File(str2);
            return new p22(new FileInputStream(file), (int) file.length());
        }
    }
}
