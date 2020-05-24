<?php

namespace php\oshi;

class OSProcess
{
    /**
     * @return string
     */
    public function getName(): string {
        return "";
    }

    /**
     * @return string
     */
    public function getPath(): string {
        return "";
    }

    /**
     * @return string
     */
    public function getCommandLine(): string {
        return "";
    }

    /**
     * @return string
     */
    public function getCurrentWorkingDirectory(): string {
        return "";
    }

    /**
     * @return string
     */
    public function getState(): string {
        return "";
    }

    /**
     * @return string
     */
    public function getUser(): string {
        return "";
    }

    /**
     * @return string
     */
    public function getUserID(): string {
        return "";
    }

    /**
     * @return string
     */
    public function getGroup(): string {
        return "";
    }

    /**
     * @return string
     */
    public function getGroupID(): string {
        return "";
    }

    /**
     * @return int
     */
    public function getProcessID(): int {
        return 0;
    }

    /**
     * @return int
     */
    public function getParentProcessID(): int {
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
    public function getPriority(): int {
        return 0;
    }

    /**
     * @return int
     */
    public function getVirtualSize(): int {
        return 0;
    }

    /**
     * @return int
     */
    public function getResidentSetSize(): int {
        return 0;
    }

    /**
     * @return int
     */
    public function getKernelTime(): int {
        return 0;
    }

    /**
     * @return int
     */
    public function getUserTime(): int {
        return 0;
    }

    /**
     * @return int
     */
    public function getUpTime(): int {
        return 0;
    }

    /**
     * @return int
     */
    public function getStartTime(): int {
        return 0;
    }

    /**
     * @return int
     */
    public function getBytesRead(): int {
        return 0;
    }

    /**
     * @return int
     */
    public function getBytesWritten(): int {
        return 0;
    }

    /**
     * @return int
     */
    public function getOpenFiles(): int {
        return 0;
    }

    /**
     * @param OSProcess|null $process
     * @return int
     */
    public function getProcessCpuLoadCumulative(OSProcess $process = null): int {
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
    public function getAffinityMask(): int {
        return 0;
    }

    /**
     * @return bool
     */
    public function updateAttributes(): bool {
        return true;
    }
}
