package php.phg.oshi.bind;

import oshi.software.os.InternetProtocolStats;
import oshi.software.os.linux.LinuxInternetProtocolStats;
import oshi.software.os.mac.MacInternetProtocolStats;
import oshi.software.os.unix.freebsd.FreeBsdInternetProtocolStats;
import oshi.software.os.unix.solaris.SolarisInternetProtocolStats;
import oshi.software.os.windows.WindowsInternetProtocolStats;
import php.phg.oshi.classes.PFileSystem;
import php.phg.oshi.classes.PInternetProtocolStats;
import php.runtime.Memory;
import php.runtime.env.Environment;
import php.runtime.env.TraceInfo;
import php.runtime.memory.ObjectMemory;
import php.runtime.memory.support.MemoryOperation;

public class InternetProtocolStatsMemoryOperation extends MemoryOperation<InternetProtocolStats> {
    @Override
    public Class<?>[] getOperationClasses() {
        return new Class[] {
                WindowsInternetProtocolStats.class,
                LinuxInternetProtocolStats.class,
                MacInternetProtocolStats.class,
                FreeBsdInternetProtocolStats.class,
                SolarisInternetProtocolStats.class
        };
    }

    @Override
    public InternetProtocolStats convert(Environment environment, TraceInfo traceInfo, Memory memory) throws Throwable {
        if (memory.isObject() && memory.instanceOf(PInternetProtocolStats.class)) {
            return memory.toObject(PInternetProtocolStats.class).getWrappedObject();
        }

        return null;
    }

    @Override
    public Memory unconvert(Environment environment, TraceInfo traceInfo, InternetProtocolStats internetProtocolStats) throws Throwable {
        return new ObjectMemory(new PInternetProtocolStats(environment, internetProtocolStats));
    }
}
