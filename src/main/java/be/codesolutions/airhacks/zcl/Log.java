package be.codesolutions.airhacks.zcl;

import java.io.PrintStream;

public enum Log {

    TRACE(Color.PURPLE, System.out),
    DEBUG(Color.BLUE, System.out),
    INFO(Color.GREEN, System.out),
    WARN(Color.YELLOW, System.out),
    ERROR(Color.LIGHT_RED, System.err),
    FATAL(Color.DARK_RED, System.err);
    PrintStream out;

    enum Color {
        PURPLE("\033[0;35m"),
        BLUE("\033[0;34m"),
        GREEN("\033[0;32m"),
        YELLOW("\033[0;33m"),
        LIGHT_RED("\033[1;31m"),
        DARK_RED("\033[0;31m");

        String code;

        Color(String code) {
            this.code = code;
        }
    }

    private final String value;
    private final static String RESET = "\u001B[0m";

    private Log(Color color, PrintStream out) {
        this.value = (color.code + "%s" + RESET);
        this.out = out;
    }

    public String formatted(String raw) {
        return this.value.formatted(raw);
    }

    public void out(String message) {
        var colored = formatted(message);
        this.out.println(colored);
    }

    public static void debug(String message) {
        Log.DEBUG.out(message);
    }

    public static void error(String message) {
        Log.ERROR.out(message);
    }

    public static void error(String message, Exception e) {
        Log.ERROR.out(message + ": " + e.getMessage());
        e.printStackTrace(System.err);
    }

    public static void user(String message) {
        Log.INFO.out(message);
    }

    public static void warning(String message) {
        Log.WARN.out(message);
    }

    public static void stop(String message) {
        error(message);
        System.exit(0);
    }
}