package org.zeroturnaround.javarebel.integration.minecraft;

import org.zeroturnaround.javarebel.ClassResourceSource;
import org.zeroturnaround.javarebel.Integration;
import org.zeroturnaround.javarebel.IntegrationFactory;
import org.zeroturnaround.javarebel.Plugin;
import org.zeroturnaround.javarebel.integration.minecraft.cpb.FileResourcePackCPB;
import org.zeroturnaround.javarebel.integration.minecraft.cpb.LauncherClassLoaderCBP;
import org.zeroturnaround.javarebel.integration.minecraft.cpb.SimpleReloadableResourceManagerCBP;
import org.zeroturnaround.javarebel.integration.minecraft.cpb.TextureMapCPB;

public class MinecraftPlugin implements Plugin {

  public void preinit() {

    Integration i = IntegrationFactory.getInstance();
    ClassLoader cl = MinecraftPlugin.class.getClassLoader();
    i.addIntegrationProcessor(cl, "net.minecraft.launchwrapper.LaunchClassLoader", new LauncherClassLoaderCBP());
    i.addIntegrationProcessor(cl, "net.minecraft.client.resources.SimpleReloadableResourceManager", new SimpleReloadableResourceManagerCBP());
    i.addIntegrationProcessor(cl,"net.minecraft.client.resources.FileResourcePack", new FileResourcePackCPB());
    i.addIntegrationProcessor(cl,"net.minecraft.client.renderer.texture.TextureMap", new TextureMapCPB());
  }

  public boolean checkDependencies(ClassLoader classLoader, ClassResourceSource classResourceSource) {
    return classResourceSource.getClassResource("net.minecraft.launchwrapper.LaunchClassLoader") != null;
  }

  public String getId() {
    return "minecraft_plugin";
  }

  public String getName() {
    return "JRebel Minecraft Plugin";
  }

  public String getDescription() {
    return "Reload stuff.";
  }

  public String getAuthor() {
    return null;
  }

  public String getWebsite() {
    return null;
  }

  public String getSupportedVersions() {
    return null;
  }

  public String getTestedVersions() {
    return null;
  }
}
