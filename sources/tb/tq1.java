package tb;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.NinePatchDrawable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class tq1 extends BitmapDrawable {
    private Rect mBitmapPadding;
    private int mDiskCacheCatalog;
    private String mDiskCacheKey;
    private int mDiskPriority;
    private boolean mFromDisk;
    private boolean mFromMemory;
    private boolean mFromSecondary;
    private boolean mIsNinePatch;
    private String mMemoryCacheKey;

    public tq1(Resources resources, Bitmap bitmap, Rect rect, String str, String str2, int i, int i2) {
        super(resources, bitmap);
        this.mBitmapPadding = rect;
        this.mIsNinePatch = (bitmap == null || bitmap.getNinePatchChunk() == null || !NinePatch.isNinePatchChunk(bitmap.getNinePatchChunk())) ? false : true;
        init(str, str2, i, i2);
    }

    private void init(String str, String str2, int i, int i2) {
        this.mMemoryCacheKey = str;
        this.mDiskCacheKey = str2;
        this.mDiskCacheCatalog = i;
        this.mDiskPriority = i2;
    }

    public NinePatchDrawable convert2NinePatchDrawable() {
        if (this.mIsNinePatch) {
            Bitmap bitmap = getBitmap();
            byte[] ninePatchChunk = bitmap.getNinePatchChunk();
            Rect rect = this.mBitmapPadding;
            if (rect == null) {
                rect = new Rect();
            }
            return new NinePatchDrawable(bitmap, ninePatchChunk, rect, null);
        }
        return null;
    }

    public void fromDisk(boolean z) {
        this.mFromDisk = z;
    }

    public void fromMemory(boolean z) {
        this.mFromMemory = z;
    }

    public void fromSecondary(boolean z) {
        this.mFromSecondary = z;
    }

    public int getDiskCacheCatalog() {
        return this.mDiskCacheCatalog;
    }

    public String getDiskCacheKey() {
        return this.mDiskCacheKey;
    }

    public int getDiskPriority() {
        return this.mDiskPriority;
    }

    public String getMemoryCacheKey() {
        return this.mMemoryCacheKey;
    }

    public boolean isFromDisk() {
        return this.mFromDisk;
    }

    public boolean isFromMemory() {
        return this.mFromMemory;
    }

    public boolean isFromSecondary() {
        return this.mFromSecondary;
    }

    public String toString() {
        return getClass().getSimpleName() + jn1.BRACKET_START_STR + Integer.toHexString(hashCode()) + ", key@" + this.mMemoryCacheKey + jn1.BRACKET_END_STR;
    }

    public tq1(String str, String str2, int i, int i2) {
        init(str, str2, i, i2);
    }
}
