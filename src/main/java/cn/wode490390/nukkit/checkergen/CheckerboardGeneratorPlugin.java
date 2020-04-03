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

        Generator.addGenerator(CheckerboardGenerator.class, "default", Generator.TYPE_INFINITE);
        Generator.addGenerator(CheckerboardGenerator.class, "normal", Generator.TYPE_INFINITE);
    }
}
