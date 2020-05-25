package php.phg.oshi.bind;

import oshi.software.os.OSFileStore;
import oshi.software.os.linux.LinuxOSFileStore;
import oshi.software.os.mac.MacOSFileStore;
import oshi.software.os.unix.freebsd.FreeBsdOSFileStore;
import oshi.software.os.unix.solaris.SolarisOSFileStore;
import oshi.software.os.windows.WindowsOSFileStore;
import php.phg.oshi.classes.POSFileStore;
import php.runtime.Memory;
import php.runtime.env.Environment;
import php.runtime.env.TraceInfo;
import php.runtime.memory.ObjectMemory;
import php.runtime.memory.support.MemoryOperation;

public class OSFileStoreMemoryOperation extends MemoryOperation<OSFileStore> {
    @Override
    public Class<?>[] getOperationClasses() {
        return new Class[] {
                WindowsOSFileStore.class,
                LinuxOSFileStore.class,
                MacOSFileStore.class,
                FreeBsdOSFileStore.class,
                SolarisOSFileStore.class
        };
    }

    @Override
    public OSFileStore convert(Environment environment, TraceInfo traceInfo, Memory memory) throws Throwable {
        if (memory.isObject() && memory.instanceOf(POSFileStore.class)) {
            return memory.toObject(POSFileStore.class).getWrappedObject();
        }

        return null;
    }

    @Override
    public Memory unconvert(Environment environment, TraceInfo traceInfo, OSFileStore osFileStore) throws Throwable {
        return new ObjectMemory(new POSFileStore(environment, osFileStore));
    }
}
