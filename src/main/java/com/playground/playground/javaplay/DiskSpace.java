package com.playground.playground.javaplay;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DiskSpace {

    public static boolean isWritable(int blockSize, int fileSize, Set<Integer> occupiedSectors) {
        // fileSize more than blockSize
        // fileSize more than total available size
        if (fileSize > blockSize || fileSize > blockSize - occupiedSectors.size()) {
            return false;
        } else if (occupiedSectors.isEmpty()) {
            // no occupied
            return true;
        } else {
            if (occupiedSectors.parallelStream().min(Integer::compareTo).orElseThrow(IllegalArgumentException::new) > fileSize) {
                // minimum occupied is greater than file size
                return true;
            } else if (blockSize - occupiedSectors.parallelStream().max(Integer::compareTo).orElseThrow(IllegalArgumentException::new) >= fileSize) {
                // maximum occupied is less than file size
                return true;
            } else {
                // find available slot enough for file size
                List<Integer> sortedOccupiedSectors = occupiedSectors.stream().sorted().collect(Collectors.toList());
                return IntStream.range(1, sortedOccupiedSectors.size())
                        .parallel()
                        .anyMatch(idx -> {
                            int availableSize = sortedOccupiedSectors.get(idx) - sortedOccupiedSectors.get(idx - 1) - 1;
                            return availableSize >= fileSize;
                        });
            }
        }
    }
}
