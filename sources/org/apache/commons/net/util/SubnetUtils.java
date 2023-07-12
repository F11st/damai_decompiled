package org.apache.commons.net.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class SubnetUtils {
    private static final int NBITS = 32;
    private static final String IP_ADDRESS = "(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})";
    private static final Pattern addressPattern = Pattern.compile(IP_ADDRESS);
    private static final String SLASH_FORMAT = "(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})/(\\d{1,3})";
    private static final Pattern cidrPattern = Pattern.compile(SLASH_FORMAT);
    private int netmask = 0;
    private int address = 0;
    private int network = 0;
    private int broadcast = 0;
    private boolean inclusiveHostCount = false;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public final class SubnetInfo {
        private int address() {
            return SubnetUtils.this.address;
        }

        private int broadcast() {
            return SubnetUtils.this.broadcast;
        }

        private int high() {
            if (SubnetUtils.this.isInclusiveHostCount()) {
                return broadcast();
            }
            if (broadcast() - network() > 1) {
                return broadcast() - 1;
            }
            return 0;
        }

        private int low() {
            if (SubnetUtils.this.isInclusiveHostCount()) {
                return network();
            }
            if (broadcast() - network() > 1) {
                return network() + 1;
            }
            return 0;
        }

        private int netmask() {
            return SubnetUtils.this.netmask;
        }

        private int network() {
            return SubnetUtils.this.network;
        }

        public int asInteger(String str) {
            return SubnetUtils.this.toInteger(str);
        }

        public String getAddress() {
            SubnetUtils subnetUtils = SubnetUtils.this;
            return subnetUtils.format(subnetUtils.toArray(address()));
        }

        public int getAddressCount() {
            int broadcast = (broadcast() - network()) + (SubnetUtils.this.isInclusiveHostCount() ? 1 : -1);
            if (broadcast < 0) {
                return 0;
            }
            return broadcast;
        }

        public String[] getAllAddresses() {
            int addressCount = getAddressCount();
            String[] strArr = new String[addressCount];
            if (addressCount == 0) {
                return strArr;
            }
            int low = low();
            int i = 0;
            while (low <= high()) {
                SubnetUtils subnetUtils = SubnetUtils.this;
                strArr[i] = subnetUtils.format(subnetUtils.toArray(low));
                low++;
                i++;
            }
            return strArr;
        }

        public String getBroadcastAddress() {
            SubnetUtils subnetUtils = SubnetUtils.this;
            return subnetUtils.format(subnetUtils.toArray(broadcast()));
        }

        public String getCidrSignature() {
            SubnetUtils subnetUtils = SubnetUtils.this;
            String format = subnetUtils.format(subnetUtils.toArray(address()));
            SubnetUtils subnetUtils2 = SubnetUtils.this;
            return subnetUtils.toCidrNotation(format, subnetUtils2.format(subnetUtils2.toArray(netmask())));
        }

        public String getHighAddress() {
            SubnetUtils subnetUtils = SubnetUtils.this;
            return subnetUtils.format(subnetUtils.toArray(high()));
        }

        public String getLowAddress() {
            SubnetUtils subnetUtils = SubnetUtils.this;
            return subnetUtils.format(subnetUtils.toArray(low()));
        }

        public String getNetmask() {
            SubnetUtils subnetUtils = SubnetUtils.this;
            return subnetUtils.format(subnetUtils.toArray(netmask()));
        }

        public String getNetworkAddress() {
            SubnetUtils subnetUtils = SubnetUtils.this;
            return subnetUtils.format(subnetUtils.toArray(network()));
        }

        public boolean isInRange(String str) {
            return isInRange(SubnetUtils.this.toInteger(str));
        }

        public String toString() {
            return "CIDR Signature:\t[" + getCidrSignature() + jn1.ARRAY_END_STR + " Netmask: [" + getNetmask() + "]\nNetwork:\t[" + getNetworkAddress() + "]\nBroadcast:\t[" + getBroadcastAddress() + "]\nFirst Address:\t[" + getLowAddress() + "]\nLast Address:\t[" + getHighAddress() + "]\n# Addresses:\t[" + getAddressCount() + "]\n";
        }

        private SubnetInfo() {
        }

        private boolean isInRange(int i) {
            int low = i - low();
            return low >= 0 && low <= high() - low();
        }
    }

    public SubnetUtils(String str) {
        calculate(str);
    }

    private void calculate(String str) {
        Matcher matcher = cidrPattern.matcher(str);
        if (matcher.matches()) {
            this.address = matchAddress(matcher);
            int rangeCheck = rangeCheck(Integer.parseInt(matcher.group(5)), 0, 32);
            for (int i = 0; i < rangeCheck; i++) {
                this.netmask |= 1 << (31 - i);
            }
            int i2 = this.address;
            int i3 = this.netmask;
            int i4 = i2 & i3;
            this.network = i4;
            this.broadcast = i4 | (~i3);
            return;
        }
        throw new IllegalArgumentException("Could not parse [" + str + jn1.ARRAY_END_STR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String format(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iArr.length; i++) {
            sb.append(iArr[i]);
            if (i != iArr.length - 1) {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    private int matchAddress(Matcher matcher) {
        int i = 0;
        for (int i2 = 1; i2 <= 4; i2++) {
            i |= (rangeCheck(Integer.parseInt(matcher.group(i2)), -1, 255) & 255) << ((4 - i2) * 8);
        }
        return i;
    }

    private int rangeCheck(int i, int i2, int i3) {
        if (i <= i2 || i > i3) {
            throw new IllegalArgumentException("Value [" + i + "] not in range (" + i2 + "," + i3 + jn1.ARRAY_END_STR);
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] toArray(int i) {
        int[] iArr = new int[4];
        for (int i2 = 3; i2 >= 0; i2--) {
            iArr[i2] = iArr[i2] | ((i >>> ((3 - i2) * 8)) & 255);
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String toCidrNotation(String str, String str2) {
        return str + "/" + pop(toInteger(str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int toInteger(String str) {
        Matcher matcher = addressPattern.matcher(str);
        if (matcher.matches()) {
            return matchAddress(matcher);
        }
        throw new IllegalArgumentException("Could not parse [" + str + jn1.ARRAY_END_STR);
    }

    public final SubnetInfo getInfo() {
        return new SubnetInfo();
    }

    public boolean isInclusiveHostCount() {
        return this.inclusiveHostCount;
    }

    int pop(int i) {
        int i2 = i - ((i >>> 1) & 1431655765);
        int i3 = (i2 & 858993459) + ((i2 >>> 2) & 858993459);
        int i4 = 252645135 & (i3 + (i3 >>> 4));
        int i5 = i4 + (i4 >>> 8);
        return (i5 + (i5 >>> 16)) & 63;
    }

    public void setInclusiveHostCount(boolean z) {
        this.inclusiveHostCount = z;
    }

    public SubnetUtils(String str, String str2) {
        calculate(toCidrNotation(str, str2));
    }
}
