<?php

namespace php\oshi;

abstract class OperatingSystem
{
    /**
     * @return string
     */
    public function getFamily(): string {
        return "Linux";
    }

    /**
     * @return string
     */
    public function getManufacturer(): string {
        return "GNU";
    }

    /**
     * @return array
     */
    public function getVersionInfo(): array {
        return [
            "buildNumber" => 228,
            "codeName" => "tux",
            "version" => 1337
        ];
    }

    /**
     * @return int
     */
    public function getProcessId(): int {
        return 0;
    }

    /**
     * @return int
     */
    public function getProcessCount(): int {
        return 0;
    }

    /**
     * @return int
     */
    public function getThreadCount(): int {
        return 0;
    }

    /**
     * @return int
     */
    public function getBitness(): int {
        return 64;
    }

    /**
     * @return int
     */
    public function getSystemUptime(): int {
        return 0;
    }

    /**
     * @return bool
     */
    public function isElevated(): bool {
        return true;
    }

    /**
     * @param int $pid
     * @return OSProcess
     */
    public function getProcess(int $pid): OSProcess {
        // Some java code ...
    }

    /**
     * @param int $limit
     * @param string $sort CPU, MEMORY, OLDEST, NEWEST, PID, PARENTPID, NAME
     * @return OSProcess[]
     */
    public function getProcesses(int $limit = 0, string $sort = "NAME"): array {
        return [];
    }

    /**
     * @param int $parentPid
     * @param int $limit
     * @param string $sort CPU, MEMORY, OLDEST, NEWEST, PID, PARENTPID, NAME
     * @return OSProcess[]
     */
    public function getChildProcesses(int $parentPid, int $limit = 0, string $sort = "NAME"): array {
        return [];
    }

    /**
     * @return FileSystem
     */
    public function getFileSystem(): FileSystem {
        // Some java code ...
    }

    /**
     * @return InternetProtocolStats
     */
    public function getInternetProtocolStats(): InternetProtocolStats {
        // Some java code ...
    }

    /**
     * @return array
     */
    public function getNetworkParams(): array {
        return [];
    }

    /**
     * @return array
     */
    public function getServices(): array {
        return [];
    }
}
