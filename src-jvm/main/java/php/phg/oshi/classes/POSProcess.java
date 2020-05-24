package php.phg.oshi.classes;

import oshi.software.os.OSProcess;
import php.phg.oshi.OSHIExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;

@Reflection.Abstract
@Reflection.Name("OSProcess")
@Reflection.Namespace(OSHIExtension.NS)
public class POSProcess extends BaseWrapper<OSProcess> {
    public POSProcess(Environment env, OSProcess wrappedObject) {
        super(env, wrappedObject);
    }

    public POSProcess(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public String getState() {
        return getWrappedObject().getState().name();
    }

    interface WrappedInterface {
        String getName();
        String getPath();
        String getCommandLine();
        String getCurrentWorkingDirectory();
        String getUser();
        String getUserID();
        String getGroup();
        String getGroupID();
        int getProcessID();
        int getParentProcessID();
        int getThreadCount();
        int getPriority();
        long getVirtualSize();
        long getResidentSetSize();
        long getKernelTime();
        long getUserTime();
        long getUpTime();
        long getStartTime();
        long getBytesRead();
        long getBytesWritten();
        long getOpenFiles();
        double getProcessCpuLoadCumulative();
        double getProcessCpuLoadBetweenTicks(OSProcess proc);
        int getBitness();
        long getAffinityMask();
        boolean updateAttributes();
    }
}
