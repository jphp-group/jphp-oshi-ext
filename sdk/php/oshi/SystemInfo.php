<?php

namespace php\oshi;

class SystemInfo
{
    const WINDOWS = "WINDOWS"; // Microsoft Windows
    const LINUX = "LINUX"; // A flavor of Linux
    const MACOSX = "MACOSX"; // macOS (OS X)
    const FREEBSD = "FREEBSD"; // FreeBSD
    const SOLARIS = "SOLARIS"; // Solaris (SunOS)
    const UNKNOWN = "UNKNOWN"; // OpenBSD, WindowsCE, or an unspecified system

    /**
     * Getting current platform
     *
     * @return string
     */
    public static function getCurrentPlatform(): string {
        return self::LINUX;
    }

    /**
     * SystemInfo constructor.
     */
    public function __construct() {
        // Some java code ...
    }

    /**
     * @return OperatingSystem
     */
    public function getOperatingSystem(): OperatingSystem {
        // Some java code ...
    }
}
