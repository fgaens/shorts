package be.codesolutions.airhacks.colored_system_out_logger;

public class ColoredSystemOutLoggerDemo {

    public static void main(String[] args) {
        Log.TRACE.out("Trace message");
        Log.DEBUG.out("Debug message");
        Log.INFO.out("Info message");
        Log.WARN.out("Warning message");
        Log.ERROR.out("Error message");
        Log.FATAL.out("Fatal message");
    }
}
