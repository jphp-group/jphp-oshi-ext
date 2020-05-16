package php.phg.hi;

import oshi.SystemInfo;
import php.phg.hi.classes.PSystemInfo;
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
    }
}
