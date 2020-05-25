package php.phg.oshi.classes;

import oshi.software.os.OSFileStore;
import php.phg.oshi.OSHIExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("OSFileStore")
@Reflection.Namespace(OSHIExtension.NS)
public class POSFileStore extends BaseWrapper<OSFileStore> {
    public POSFileStore(Environment env, OSFileStore wrappedObject) {
        super(env, wrappedObject);
    }

    public POSFileStore(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    interface WrappedInterface {
        String getName();
        String getVolume();
        String getLabel();
        String getLogicalVolume();
        String getMount();
        String getDescription();
        String getType();
        String getOptions();
        String getUUID();
        long getFreeSpace();
        long getUsableSpace();
        long getTotalSpace();
        long getFreeInodes();
        long getTotalInodes();
        boolean updateAttributes();
    }
}
