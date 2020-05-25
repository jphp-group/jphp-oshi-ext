package php.phg.oshi;

import oshi.SystemInfo;
import oshi.software.os.*;
import php.phg.oshi.bind.FileSystemMemoryOperation;
import php.phg.oshi.bind.OSFileStoreMemoryOperation;
import php.phg.oshi.classes.*;
import php.phg.oshi.bind.OSProcessMemoryOperation;
import php.runtime.env.CompileScope;
import php.runtime.ext.support.Extension;

public class OSHIExtension extends Extension {
    public static final String NS = "php\\oshi";
    
    @Override
    public Status getStatus() {
        return Status.STABLE;
    }
    
    @Override
    public void onRegister(CompileScope scope) {
        registerWrapperClass(scope, SystemInfo.class, PSystemInfo.class);
        registerWrapperClass(scope, OperatingSystem.class, POperatingSystem.class);
        registerWrapperClass(scope, OSProcess.class, POSProcess.class);
        registerWrapperClass(scope, FileSystem.class, PFileSystem.class);
        registerWrapperClass(scope, OSFileStore.class, POSFileStore.class);

        registerMemoryOperation(OSProcessMemoryOperation.class);
        registerMemoryOperation(FileSystemMemoryOperation.class);
        registerMemoryOperation(OSFileStoreMemoryOperation.class);
    }
}
