package php.phg.oshi.classes;

import oshi.PlatformEnum;
import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;
import php.phg.oshi.OSHIExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("SystemInfo")
@Reflection.Namespace(OSHIExtension.NS)
public class PSystemInfo extends BaseWrapper<SystemInfo> {
    public static final String WINDOWS = PlatformEnum.WINDOWS.name();
    public static final String LINUX = PlatformEnum.LINUX.name();
    public static final String MACOSX = PlatformEnum.MACOSX.name();
    public static final String FREEBSD = PlatformEnum.FREEBSD.name();
    public static final String SOLARIS = PlatformEnum.SOLARIS.name();
    public static final String UNKNOWN = PlatformEnum.UNKNOWN.name();

    public PSystemInfo(Environment env, SystemInfo wrappedObject) {
        super(env, wrappedObject);
    }

    public PSystemInfo(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public static String getCurrentPlatform() {
        return SystemInfo.getCurrentPlatformEnum().name();
    }

    @Reflection.Signature
    public void __construct() {
        __wrappedObject = new SystemInfo();
    }

    interface WrappedInterface {
        OperatingSystem getOperatingSystem();
    }

    // TODO: make getOperatingSystem and getHardware functions...
}
