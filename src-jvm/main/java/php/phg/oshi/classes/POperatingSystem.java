package php.phg.oshi.classes;

import oshi.software.os.*;
import php.phg.oshi.OSHIExtension;
import php.runtime.Memory;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseWrapper;
import php.runtime.memory.ArrayMemory;
import php.runtime.memory.LongMemory;
import php.runtime.memory.StringMemory;
import php.runtime.reflection.ClassEntity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Reflection.Abstract
@Reflection.Name("OperatingSystem")
@Reflection.Namespace(OSHIExtension.NS)
public class POperatingSystem extends BaseWrapper<OperatingSystem> {
    public POperatingSystem(Environment env, OperatingSystem wrappedObject) {
        super(env, wrappedObject);
    }

    public POperatingSystem(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public Map<String, String> getVersionInfo() {
        OperatingSystem.OSVersionInfo versionInfo
                = getWrappedObject().getVersionInfo();

        return new HashMap<String, String>() {{
            put("buildNumber", versionInfo.getBuildNumber());
            put("codeName", versionInfo.getCodeName());
            put("version", versionInfo.getVersion());
        }};
    }

    @Reflection.Signature
    public List<OSProcess> getProcesses(int limit, String sort) {
        return getWrappedObject().getProcesses(limit, OperatingSystem.ProcessSort.valueOf(sort.toUpperCase()));
    }

    @Reflection.Signature
    public List<OSProcess> getProcesses(int limit) {
        return getWrappedObject().getProcesses(limit, OperatingSystem.ProcessSort.NAME);
    }

    @Reflection.Signature
    public List<OSProcess> getProcesses() {
        return getWrappedObject().getProcesses();
    }

    @Reflection.Signature
    public List<OSProcess> getChildProcesses(int parentPid, int limit, String sort) {
        return getWrappedObject().getChildProcesses(parentPid, limit, OperatingSystem.ProcessSort.valueOf(sort.toUpperCase()));
    }

    @Reflection.Signature
    public List<OSProcess> getChildProcesses(int parentPid, int limit) {
        return getChildProcesses(parentPid, limit, "NAME");
    }

    @Reflection.Signature
    public List<OSProcess> getChildProcesses(int parentPid) {
        return getChildProcesses(parentPid, 0);
    }

    @Reflection.Signature
    public FileSystem getFileSystem() {
        return getWrappedObject().getFileSystem();
    }

    @Reflection.Signature
    public InternetProtocolStats getInternetProtocolStats() {
        return getWrappedObject().getInternetProtocolStats();
    }

    @Reflection.Signature
    public List<Map<String, Memory>> getServices() {
        List<OSService> list = Arrays.asList(getWrappedObject().getServices());
        return list.stream().map(this::osServiceToMap).collect(Collectors.toList());
    }

    @Reflection.Signature
    public Map<String, Memory> getNetworkParams() {
        NetworkParams networkParams = getWrappedObject().getNetworkParams();

        return new HashMap<String, Memory>() {{
            put("hostName", new StringMemory(networkParams.getHostName()));
            put("domainName", new StringMemory(networkParams.getDomainName()));
            put("ipv4DefaultGateway", new StringMemory(networkParams.getIpv4DefaultGateway()));
            put("ipv6DefaultGateway", new StringMemory(networkParams.getIpv6DefaultGateway()));
            put("dnsServers", new ArrayMemory(networkParams.getDnsServers()));
        }};
    }

    protected Map<String, Memory> osServiceToMap(OSService service) {
        return new HashMap<String, Memory>() {{
            put("name", new StringMemory(service.getName()));
            put("processID", new LongMemory(service.getProcessID()));
            put("state", new StringMemory(service.getState().name()));
        }};
    }

    interface WrapperInterface {
        String getFamily();
        String getManufacturer();
        int getProcessId();
        int getProcessCount();
        int getThreadCount();
        int getBitness();
        long getSystemUptime();
        long getSystemBootTime();
        boolean isElevated();
        OSProcess getProcess(int pid);
    }
}
