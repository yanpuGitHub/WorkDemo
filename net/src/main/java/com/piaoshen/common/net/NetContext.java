package com.piaoshen.common.net;

import dc.android.common.BridgeContext;

/**
 * @author senrsl
 * @ClassName: NetContext
 * @Package: com.piaos.common.net
 * @CreateTime: 2019/7/31 7:39 PM
 */
public class NetContext extends BridgeContext {

    public static long TIMEOUT_CONNECT = 10;
    public static long TIMEOUT_READ = 15;
    public static long TIMEOUT_WRITE = 30;

    public static final String DOMAIN_BASE = "https://www.android.com/";

    public static final String HEADER_COOKIE_SET = "Set-Cookie";

    public static final String KEY_COOKIE = "cookie";
    public static final String NAME_PREFERCE = "net";

}
