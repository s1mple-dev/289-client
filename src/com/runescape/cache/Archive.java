package com.runescape.cache;

import com.runescape.cache.bzip.BZip2Decompressor;
import com.runescape.net.Buffer;

public class Archive {

    private byte[] outputData;
    private int fileCount;
    private int[] hashes;
    private int[] decompressedSizes;
    private int[] compressedSizes;
    private int[] initialOffsets;
    private boolean decompressed;

    public Archive(byte[] data) {
        decompress(data);
    }

    private void decompress(byte[] data) {
        Buffer buffer = new Buffer(data);
        int compressedLength = buffer.readUnsignedTriByte();
        int decompressedLength = buffer.readUnsignedTriByte();
        if (decompressedLength != compressedLength) {
            byte[] output = new byte[compressedLength];
            BZip2Decompressor.decompress(output, compressedLength, data, decompressedLength, 6);
            outputData = output;
            buffer = new Buffer(outputData);
            decompressed = true;
        } else {
            outputData = data;
            decompressed = false;
        }
        fileCount = buffer.readUnsignedShort();
        hashes = new int[fileCount];
        decompressedSizes = new int[fileCount];
        compressedSizes = new int[fileCount];
        initialOffsets = new int[fileCount];
        int offset = buffer.offset + fileCount * 10;
        for (int index = 0; index < fileCount; index++) {
            hashes[index] = buffer.readUnsignedInt();
            decompressedSizes[index] = buffer.readUnsignedTriByte();
            compressedSizes[index] = buffer.readUnsignedTriByte();
            initialOffsets[index] = offset;
            offset += compressedSizes[index];
        }
    }

    public byte[] decompressFile(String name) {
        int hash = 0;
        name = name.toUpperCase();
        for (int j = 0; j < name.length(); j++) {
            hash = (hash * 61 + name.charAt(j)) - 32;
        }
        for (int file = 0; file < fileCount; file++) {
            if (hashes[file] == hash) {
                byte[] output = new byte[this.decompressedSizes[file]];
                if (!decompressed) {
                    BZip2Decompressor.decompress(output, decompressedSizes[file], outputData, compressedSizes[file], initialOffsets[file]);
                } else {
                    for (int l = 0; l < decompressedSizes[file]; l++) {
                        output[l] = outputData[initialOffsets[file] + l];
                    }
                }
                return output;
            }
        }
        return null;
    }
}
