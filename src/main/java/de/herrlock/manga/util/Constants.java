package de.herrlock.manga.util;

public final class Constants {
    public static final String SETTINGS_FILE = "./downloader.properties";
    public static final String PARAM_URL = "url";
    public static final String PARAM_PATTERN = "pattern";
    public static final String PARAM_LOGLEVEL = "loglevel";
    public static final String PARAM_FILEPATH = "filepath";
    public static final String PARAM_TIMEOUT = "timeout";
    public static final int PARAM_TIMEOUT_DEFAULT = 5_000;

    public static final String PARAM_PROXY_HOST = "proxyHost";
    public static final String PARAM_PROXY_PORT = "proxyPort";
    public static final String PARAM_PROXY_USER = "proxyUser";
    public static final String PARAM_PROXY_PASS = "proxyPassword";

    public static final String TARGET_FOLDER = "./download";

    private Constants() {
        // not called
    }
}
