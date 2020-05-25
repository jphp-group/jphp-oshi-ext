<?php

namespace php\oshi;

class FileSystem
{
    /**
     * @param bool $localOnly
     * @return OSFileStore[]
     */
    public function getFileStores(bool $localOnly = false): array {
        return [];
    }

    public function getOpenFileDescriptors(): int {
        return 0;
    }

    public function getMaxFileDescriptors(): int {
        return 0;
    }
}
