package cn.wode490390.nukkit.checkergen;

import cn.nukkit.level.generator.Generator;
import cn.nukkit.plugin.PluginBase;
import cn.wode490390.nukkit.checkergen.util.MetricsLite;

public class CheckerboardGeneratorPlugin extends PluginBase {

    @Override
    public void onEnable() {
        try {
            new MetricsLite(this, 6990);
        } catch (Throwable ignore) {

        }

        Generator.addGenerator(CheckerboardGenerator.class, "checkerbor", Generator.TYPE_INFINITE);
    }
}
