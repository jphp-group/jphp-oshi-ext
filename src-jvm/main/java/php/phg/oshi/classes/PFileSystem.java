package php.phg.oshi.classes;

import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;
import php.phg.oshi.OSHIExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;

import java.util.List;

@Reflection.Name("FileSystem")
@Reflection.Namespace(OSHIExtension.NS)
public class PFileSystem extends BaseWrapper<FileSystem> {
    public PFileSystem(Environment env, FileSystem wrappedObject) {
        super(env, wrappedObject);
    }

    public PFileSystem(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    interface WrappedInterface {
        List<OSFileStore> getFileStores();
        List<OSFileStore> getFileStores(boolean localOnly);
        long getOpenFileDescriptors();
        long getMaxFileDescriptors();
    }
}
