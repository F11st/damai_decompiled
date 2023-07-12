package com.real.android.nativehtml.android;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Base64;
import android.view.View;
import com.real.android.nativehtml.common.dom.Element;
import com.real.android.nativehtml.common.dom.ElementType;
import com.real.android.nativehtml.common.dom.Platform;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import tb.qb0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class AndroidPlatform implements Platform {
    HashMap<URI, a> a = new HashMap<>();
    final Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static class a {
        Bitmap a;
        ArrayList<Element> b;

        a() {
        }
    }

    public AndroidPlatform(Context context) {
        this.b = context;
    }

    public Bitmap a(Element element, final URI uri) {
        ArrayList<Element> arrayList;
        a aVar = this.a.get(uri);
        if (aVar == null) {
            aVar = new a();
            this.a.put(uri, aVar);
            String uri2 = uri.toString();
            if (uri2.startsWith("data:")) {
                byte[] decode = Base64.decode(uri2.substring(uri2.indexOf(",") + 1), 0);
                aVar.a = BitmapFactory.decodeByteArray(decode, 0, decode.length);
            } else {
                ArrayList<Element> arrayList2 = new ArrayList<>();
                aVar.b = arrayList2;
                arrayList2.add(element);
                new AsyncTask<a, a, Void>() { // from class: com.real.android.nativehtml.android.AndroidPlatform.1
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // android.os.AsyncTask
                    /* renamed from: a */
                    public Void doInBackground(a... aVarArr) {
                        for (a aVar2 : aVarArr) {
                            try {
                                aVar2.a = BitmapFactory.decodeStream(AndroidPlatform.this.openInputStream(uri));
                                synchronized (aVar2.b) {
                                    Iterator<Element> it = aVar2.b.iterator();
                                    while (it.hasNext()) {
                                        Element next = it.next();
                                        while (next != null && !(next instanceof View)) {
                                            next = next.getParentElement();
                                        }
                                        if (next != null) {
                                            final View view = (View) next;
                                            view.post(new Runnable() { // from class: com.real.android.nativehtml.android.AndroidPlatform.1.1
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    view.requestLayout();
                                                }
                                            });
                                        }
                                    }
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        return null;
                    }
                }.execute(aVar);
            }
        } else if (aVar.a == null && (arrayList = aVar.b) != null) {
            synchronized (arrayList) {
                aVar.b.add(element);
            }
        }
        return aVar.a;
    }

    @Override // com.real.android.nativehtml.common.dom.Platform
    public Element createElement(qb0 qb0Var, ElementType elementType, String str) {
        if (elementType != ElementType.COMPONENT) {
            return null;
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -906021636:
                if (str.equals("select")) {
                    c = 0;
                    break;
                }
                break;
            case 100358090:
                if (str.equals("input")) {
                    c = 1;
                    break;
                }
                break;
            case 579825757:
                if (str.equals("text-component")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return new AndroidSelectElement(this.b, qb0Var);
            case 1:
                return new AndroidInputElement(this.b, qb0Var);
            case 2:
                return new AndroidTextComponent(this.b, qb0Var);
            default:
                return new AndroidContainerElement(this.b, qb0Var, str);
        }
    }

    @Override // com.real.android.nativehtml.common.dom.Platform
    public float getPixelPerDp() {
        return this.b.getResources().getDisplayMetrics().density;
    }

    @Override // com.real.android.nativehtml.common.dom.Platform
    public void openInBrowser(URI uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(uri.toString()));
        this.b.startActivity(intent);
    }

    @Override // com.real.android.nativehtml.common.dom.Platform
    public InputStream openInputStream(URI uri) throws IOException {
        String uri2 = uri.toString();
        if (uri2.startsWith("file:/") && uri2.indexOf("/android_asset/") <= 8) {
            int indexOf = uri2.indexOf(47, 15) + 1;
            int indexOf2 = uri2.indexOf(35, indexOf);
            AssetManager assets = this.b.getAssets();
            if (indexOf2 == -1) {
                indexOf2 = uri2.length();
            }
            return assets.open(uri2.substring(indexOf, indexOf2));
        }
        return uri.toURL().openStream();
    }
}
