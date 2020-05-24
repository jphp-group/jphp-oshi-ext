package php.phg.oshi;

import oshi.SystemInfo;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;
import php.phg.oshi.classes.POSProcess;
import php.phg.oshi.classes.POperatingSystem;
import php.phg.oshi.classes.PSystemInfo;
import php.phg.oshi.support.OSProcessMemoryOperation;
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

        registerMemoryOperation(OSProcessMemoryOperation.class);
    }
}
