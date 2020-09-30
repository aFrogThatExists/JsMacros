package xyz.wagyourtail.jsmacros.runscript.functions;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.MinecraftClient;

public abstract class Functions {
    public final String libName;
    public final List<String> excludeLanguages = new ArrayList<>();
    protected static final MinecraftClient mc = MinecraftClient.getInstance();
    
    public Functions(String libName) {
        this(libName, null);
    }
    
    public Functions(String libName, List<String> excludeLanguages) {
        this.libName = libName;
        if (excludeLanguages != null) this.excludeLanguages.addAll(excludeLanguages);
    }
}
