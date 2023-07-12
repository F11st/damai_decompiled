package com.google.vr.ndk.base;

import android.util.Log;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class Version {
    public static final Version CURRENT = parse("1.80.0");
    public static final Version MIN = parse("1.80.0");
    public static final String TAG = "Version";
    public final int majorVersion;
    public final int minorVersion;
    public final int patchVersion;

    public Version(int i, int i2, int i3) {
        this.majorVersion = i;
        this.minorVersion = i2;
        this.patchVersion = i3;
    }

    public static Version parse(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)\\.(\\d+)").matcher(str);
        if (!matcher.matches()) {
            Log.w("Version", str.length() != 0 ? "Failed to parse version from: ".concat(str) : new String("Failed to parse version from: "));
            return null;
        }
        return new Version(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Version) {
            Version version = (Version) obj;
            return this.majorVersion == version.majorVersion && this.minorVersion == version.minorVersion && this.patchVersion == version.patchVersion;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.majorVersion), Integer.valueOf(this.minorVersion), Integer.valueOf(this.patchVersion));
    }

    public final boolean isAtLeast(Version version) {
        int i = this.majorVersion;
        int i2 = version.majorVersion;
        if (i > i2) {
            return true;
        }
        if (i < i2) {
            return false;
        }
        int i3 = this.minorVersion;
        int i4 = version.minorVersion;
        if (i3 > i4) {
            return true;
        }
        if (i3 < i4) {
            return false;
        }
        int i5 = this.patchVersion;
        int i6 = version.patchVersion;
        return i5 > i6 || i5 >= i6;
    }

    public final String toString() {
        return String.format("%d.%d.%d", Integer.valueOf(this.majorVersion), Integer.valueOf(this.minorVersion), Integer.valueOf(this.patchVersion));
    }
}
