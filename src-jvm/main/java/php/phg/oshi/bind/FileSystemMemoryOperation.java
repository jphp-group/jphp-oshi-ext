package php.phg.oshi.bind;

import oshi.software.os.FileSystem;
import oshi.software.os.linux.LinuxFileSystem;
import oshi.software.os.mac.MacFileSystem;
import oshi.software.os.unix.freebsd.FreeBsdFileSystem;
import oshi.software.os.unix.solaris.SolarisFileSystem;
import oshi.software.os.windows.WindowsFileSystem;
import php.phg.oshi.classes.PFileSystem;
import php.runtime.Memory;
import php.runtime.env.Environment;
import php.runtime.env.TraceInfo;
import php.runtime.memory.ObjectMemory;
import php.runtime.memory.support.MemoryOperation;

public class FileSystemMemoryOperation extends MemoryOperation<FileSystem> {
    @Override
    public Class<?>[] getOperationClasses() {
        return new Class[] {
                WindowsFileSystem.class,
                LinuxFileSystem.class,
                MacFileSystem.class,
                FreeBsdFileSystem.class,
                SolarisFileSystem.class
        };
    }

    @Override
    public FileSystem convert(Environment environment, TraceInfo traceInfo, Memory memory) throws Throwable {
        if (memory.isObject() && memory.instanceOf(PFileSystem.class)) {
            return memory.toObject(PFileSystem.class).getWrappedObject();
        }

        return null;
    }

    @Override
    public Memory unconvert(Environment environment, TraceInfo traceInfo, FileSystem fileSystem) throws Throwable {
        return new ObjectMemory(new PFileSystem(environment, fileSystem));
    }
}
