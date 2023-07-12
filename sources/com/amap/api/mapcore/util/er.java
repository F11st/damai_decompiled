package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.amap.api.mapcore.util.dc;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileProvider;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class er extends es {
    private TileProvider e;

    public er(Context context, int i, int i2) {
        super(context, i, i2);
        this.e = null;
        a(context);
    }

    private void a(Context context) {
        b(context);
    }

    private void b(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager)) == null) {
            return;
        }
        activeNetworkInfo.isConnectedOrConnecting();
    }

    private Bitmap c(dc.C4503a c4503a) {
        try {
            Tile tile = this.e.getTile(c4503a.a, c4503a.b, c4503a.c);
            if (tile == null || tile == TileProvider.NO_TILE) {
                return null;
            }
            byte[] bArr = tile.data;
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a(TileProvider tileProvider) {
        this.e = tileProvider;
    }

    @Override // com.amap.api.mapcore.util.es, com.amap.api.mapcore.util.et
    protected Bitmap a(Object obj) {
        return c((dc.C4503a) obj);
    }
}
