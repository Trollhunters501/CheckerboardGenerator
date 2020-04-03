package cn.wode490390.nukkit.checkergen.util;

public class BlockEntry {

    private final int id;
    private final int meta;

    public BlockEntry(int id, int meta) {
        this.id = id;
        this.meta = meta;
    }

    public int getId() {
        return this.id;
    }

    public int getMeta() {
        return this.meta;
    }
}
