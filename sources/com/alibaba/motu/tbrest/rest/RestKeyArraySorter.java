package com.alibaba.motu.tbrest.rest;

import com.alibaba.motu.tbrest.utils.StringUtils;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class RestKeyArraySorter {
    private static RestKeyArraySorter s_instance;
    private ResourcesDESCComparator mDESCComparator = new ResourcesDESCComparator();
    private ResourcesASCComparator mASCComparator = new ResourcesASCComparator();

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    private class ResourcesASCComparator implements Comparator<String> {
        private ResourcesASCComparator() {
        }

        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            if (StringUtils.isEmpty(str) || StringUtils.isEmpty(str2)) {
                return 0;
            }
            return str.compareTo(str2);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    private class ResourcesDESCComparator implements Comparator<String> {
        private ResourcesDESCComparator() {
        }

        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            if (StringUtils.isEmpty(str) || StringUtils.isEmpty(str2)) {
                return 0;
            }
            return str.compareTo(str2) * (-1);
        }
    }

    private RestKeyArraySorter() {
    }

    public static synchronized RestKeyArraySorter getInstance() {
        RestKeyArraySorter restKeyArraySorter;
        synchronized (RestKeyArraySorter.class) {
            if (s_instance == null) {
                s_instance = new RestKeyArraySorter();
            }
            restKeyArraySorter = s_instance;
        }
        return restKeyArraySorter;
    }

    public String[] sortResourcesList(String[] strArr, boolean z) {
        Comparator comparator;
        if (z) {
            comparator = this.mASCComparator;
        } else {
            comparator = this.mDESCComparator;
        }
        if (comparator == null || strArr == null || strArr.length <= 0) {
            return null;
        }
        Arrays.sort(strArr, comparator);
        return strArr;
    }
}
