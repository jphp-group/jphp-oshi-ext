package php.phg.oshi.support;

import oshi.software.os.OSProcess;
import oshi.software.os.linux.LinuxOSProcess;
import oshi.software.os.mac.MacOSProcess;
import oshi.software.os.unix.freebsd.FreeBsdOSProcess;
import oshi.software.os.unix.solaris.SolarisOSProcess;
import oshi.software.os.windows.WindowsOSProcess;
import php.phg.oshi.classes.POSProcess;
import php.runtime.Memory;
import php.runtime.env.Environment;
import php.runtime.env.TraceInfo;
import php.runtime.memory.ObjectMemory;
import php.runtime.memory.support.MemoryOperation;

public class OSProcessMemoryOperation extends MemoryOperation<OSProcess> {
    @Override
    public Class<?>[] getOperationClasses() {
        return new Class[] {
                WindowsOSProcess.class,
                LinuxOSProcess.class,
                MacOSProcess.class,
                FreeBsdOSProcess.class,
                SolarisOSProcess.class
        };
    }

    @Override
    public OSProcess convert(Environment environment, TraceInfo traceInfo, Memory memory) throws Throwable {
        if (memory.isObject() && memory.instanceOf(POSProcess.class)) {
            return (OSProcess) memory.toObject(POSProcess.class);
        }

        return null;
    }

    @Override
    public Memory unconvert(Environment environment, TraceInfo traceInfo, OSProcess osProcess) throws Throwable {
        return new ObjectMemory(new POSProcess(environment, osProcess));
    }
}
