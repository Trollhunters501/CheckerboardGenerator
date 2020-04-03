package cn.wode490390.nukkit.checkergen;

import cn.nukkit.level.ChunkManager;
import cn.nukkit.level.biome.EnumBiome;
import cn.nukkit.level.format.generic.BaseFullChunk;
import cn.nukkit.level.generator.Generator;
import cn.nukkit.math.NukkitRandom;
import cn.nukkit.math.Vector3;
import cn.wode490390.nukkit.checkergen.util.BlockEntry;
import cn.wode490390.nukkit.checkergen.util.ColoredBlocks;

import java.util.Collections;
import java.util.Map;

public class CheckerboardGenerator extends Generator {

    protected ChunkManager level;

    public CheckerboardGenerator() {

    }

    public CheckerboardGenerator(Map<String, Object> options) {

    }

    @Override
    public int getId() {
        return TYPE_INFINITE;
    }

    @Override
    public String getName() {
        return "normal";
    }

    @Override
    public ChunkManager getChunkManager() {
        return this.level;
    }

    @Override
    public Map<String, Object> getSettings() {
        return Collections.emptyMap();
    }

    @Override
    public void init(ChunkManager level, NukkitRandom random) {
        this.level = level;
    }

    @Override
    public void generateChunk(int chunkX, int chunkZ) {
        BaseFullChunk chunk = this.level.getChunk(chunkX, chunkZ);

        for (int chunkY = 0; chunkY < 8; ++chunkY) {
            BlockEntry[] entries = ColoredBlocks.COLORED_BLOCKS[(clearSign(chunkX) ^ chunkY ^ clearSign(chunkZ)) % ColoredBlocks.COLORED_BLOCKS.length];

            int baseY = chunkY << 4;
            for (int x = 0; x < 16; ++x) {
                for (int z = 0; z < 16; ++z) {
                    for (int cy = 0; cy < 16; ++cy) {
                        int y = baseY + cy;
                        BlockEntry block = entries[(x ^ y ^ z) % entries.length];
                        chunk.setBlock(x, y, z, block.getId(), block.getMeta());
                    }
                    if (chunkY == 0) {
                        chunk.setBiome(x, z, EnumBiome.DESERT.biome);
                    }
                }
            }
        }
    }

    @Override
    public void populateChunk(int chunkX, int chunkZ) {

    }

    @Override
    public Vector3 getSpawn() {
        return new Vector3(0.5, 128.5, 0.5);
    }

    protected static int clearSign(int value) {
        return value & Integer.MAX_VALUE;
    }
}
