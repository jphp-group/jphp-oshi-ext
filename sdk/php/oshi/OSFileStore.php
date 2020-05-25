<?php


namespace php\oshi;


class OSFileStore
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
    public function getVolume(): string {
        return "";
    }

    /**
     * @return string
     */
    public function getLabel(): string {
        return "";
    }

    /**
     * @return string
     */
    public function getLogicalVolume(): string {
        return "";
    }

    /**
     * @return string
     */
    public function getMount(): string {
        return "";
    }

    /**
     * @return string
     */
    public function getDescription(): string {
        return "";
    }

    /**
     * @return string
     */
    public function getType(): string {
        return "";
    }

    /**
     * @return string
     */
    public function getOptions(): string {
        return "";
    }

    /**
     * @return string
     */
    public function getUUID(): string {
        return "";
    }

    /**
     * @return int
     */
    public function getFreeSpace(): int {
        return 0;
    }

    /**
     * @return int
     */
    public function getUsableSpace(): int {
        return 0;
    }

    /**
     * @return int
     */
    public function getTotalSpace(): int {
        return 0;
    }

    /**
     * @return int
     */
    public function getFreeInodes(): int {
        return 0;
    }

    /**
     * @return int
     */
    public function getTotalInodes(): int {
        return 0;
    }

    /**
     * @return bool
     */
    public function updateAttributes(): bool {
        return true;
    }
}
