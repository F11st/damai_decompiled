package com.taobao.uikit.extend.feature.features;

import com.taobao.phenix.bitmap.BitmapProcessor;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class PhenixOptions {
    static final int ONLY_CACHE = 8;
    static final int PRELOAD_WITH_SMALL = 1;
    static final int SCALE_FROM_LARGE = 2;
    static final int SKIP_CACHE = 4;
    static final int USE_ORIGIN_IF_THUMB_NOT_EXIST = 16;
    BitmapProcessor[] bitmapProcessors;
    int mSwitchFlags;
    String priorityModuleName;
    int thumbnailType;
    int schedulePriority = 2;
    int memoryCachePriority = 17;
    int diskCachePriority = 17;

    public static boolean isSame(PhenixOptions phenixOptions, PhenixOptions phenixOptions2) {
        if (phenixOptions == phenixOptions2) {
            return true;
        }
        if (phenixOptions == null || phenixOptions2 == null) {
            return false;
        }
        String str = phenixOptions.priorityModuleName;
        if (str != null || phenixOptions2.priorityModuleName == null) {
            if ((str == null || str.equals(phenixOptions2.priorityModuleName)) && phenixOptions.thumbnailType == phenixOptions2.thumbnailType && phenixOptions.schedulePriority == phenixOptions2.schedulePriority && phenixOptions.diskCachePriority == phenixOptions2.diskCachePriority && phenixOptions.mSwitchFlags == phenixOptions2.mSwitchFlags) {
                BitmapProcessor[] bitmapProcessorArr = phenixOptions.bitmapProcessors;
                if (bitmapProcessorArr != null || phenixOptions2.bitmapProcessors == null) {
                    if (bitmapProcessorArr != null) {
                        BitmapProcessor[] bitmapProcessorArr2 = phenixOptions2.bitmapProcessors;
                        if (bitmapProcessorArr2 == null || bitmapProcessorArr.length != bitmapProcessorArr2.length) {
                            return false;
                        }
                        int i = 0;
                        while (true) {
                            BitmapProcessor[] bitmapProcessorArr3 = phenixOptions.bitmapProcessors;
                            if (i >= bitmapProcessorArr3.length) {
                                break;
                            }
                            BitmapProcessor bitmapProcessor = bitmapProcessorArr3[i];
                            BitmapProcessor bitmapProcessor2 = phenixOptions2.bitmapProcessors[i];
                            if (bitmapProcessor.getClass() != bitmapProcessor2.getClass()) {
                                return false;
                            }
                            String id = bitmapProcessor.getId();
                            String id2 = bitmapProcessor2.getId();
                            if (id == null && id2 != null) {
                                return false;
                            }
                            if (id != null && !id.equals(id2)) {
                                return false;
                            }
                            i++;
                        }
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public PhenixOptions asThumbnail(int i, boolean z) {
        this.thumbnailType = i;
        if (z) {
            this.mSwitchFlags |= 16;
        } else {
            this.mSwitchFlags &= -17;
        }
        return this;
    }

    public PhenixOptions bitmapProcessors(BitmapProcessor... bitmapProcessorArr) {
        this.bitmapProcessors = bitmapProcessorArr;
        return this;
    }

    public PhenixOptions diskCachePriority(int i) {
        this.diskCachePriority = i;
        return this;
    }

    public boolean isOpened(int i) {
        return (i & this.mSwitchFlags) > 0;
    }

    public PhenixOptions memoryCachePriority(int i) {
        this.memoryCachePriority = i;
        return this;
    }

    public PhenixOptions onlyCache(boolean z) {
        if (z) {
            this.mSwitchFlags |= 8;
        } else {
            this.mSwitchFlags &= -9;
        }
        return this;
    }

    public PhenixOptions preloadWithSmall(boolean z) {
        if (z) {
            this.mSwitchFlags |= 1;
        } else {
            this.mSwitchFlags &= -2;
        }
        return this;
    }

    public PhenixOptions priorityModuleName(String str) {
        this.priorityModuleName = str;
        return this;
    }

    public PhenixOptions scaleFromLarge(boolean z) {
        if (z) {
            this.mSwitchFlags |= 2;
        } else {
            this.mSwitchFlags &= -3;
        }
        return this;
    }

    public PhenixOptions schedulePriority(int i) {
        this.schedulePriority = i;
        return this;
    }

    public PhenixOptions skipCache(boolean z) {
        if (z) {
            this.mSwitchFlags |= 4;
        } else {
            this.mSwitchFlags &= -5;
        }
        return this;
    }
}
