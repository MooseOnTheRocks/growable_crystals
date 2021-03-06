package dev.foltz.growablecrystals.client;

import dev.foltz.growablecrystals.GrowableCrystalsMod;
import dev.foltz.growablecrystals.block.CrystalBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.ItemEntityRenderer;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Environment(EnvType.CLIENT)
public class GrowableCrystalsModClient implements ClientModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger(GrowableCrystalsMod.MODID);

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(GrowableCrystalsMod.CRYSTAL_POWDER_ENTITY_TYPE, ItemEntityRenderer::new);

        putBlockInRenderLayer(CrystalBlocks.REDSTONE_CRYSTAL_BLOCK, RenderLayer.getCutout());
        putBlockInRenderLayer(CrystalBlocks.COAL_CRYSTAL_BLOCK, RenderLayer.getCutout());
        putBlockInRenderLayer(CrystalBlocks.IRON_CRYSTAL_BLOCK, RenderLayer.getCutout());
        putBlockInRenderLayer(CrystalBlocks.GOLD_CRYSTAL_BLOCK, RenderLayer.getCutout());
        putBlockInRenderLayer(CrystalBlocks.LAPIS_CRYSTAL_BLOCK, RenderLayer.getCutout());
        putBlockInRenderLayer(CrystalBlocks.DIAMOND_CRYSTAL_BLOCK, RenderLayer.getCutout());
        putBlockInRenderLayer(CrystalBlocks.COPPER_CRYSTAL_BLOCK, RenderLayer.getCutout());
        putBlockInRenderLayer(CrystalBlocks.EMERALD_CRYSTAL_BLOCK, RenderLayer.getCutout());

        registerParticle(GrowableCrystalsMod.REDSTONE_CRYSTAL_PARTICLE, CrystalParticle.Factory.withColor(1f, 0f, 0f));
        registerParticle(GrowableCrystalsMod.COAL_CRYSTAL_PARTICLE, CrystalParticle.Factory.withColor(0.2f, 0.2f, 0.2f));
        registerParticle(GrowableCrystalsMod.IRON_CRYSTAL_PARTICLE, CrystalParticle.Factory.withColor(0.85f, 0.70f, 0.60f));
        registerParticle(GrowableCrystalsMod.GOLD_CRYSTAL_PARTICLE, CrystalParticle.Factory.withColor(1f, 0.9f, 0.2f));
        registerParticle(GrowableCrystalsMod.LAPIS_CRYSTAL_PARTICLE, CrystalParticle.Factory.withColor(0.3f, 0.5f, 0.95f));
        registerParticle(GrowableCrystalsMod.DIAMOND_CRYSTAL_PARTICLE, CrystalParticle.Factory.withColor(0.55f, 0.95f, 0.92f));
        registerParticle(GrowableCrystalsMod.COPPER_CRYSTAL_PARTICLE, CrystalParticle.Factory.withColor(0.6f, 0.45f, 0.25f));
        registerParticle(GrowableCrystalsMod.EMERALD_CRYSTAL_PARTICLE, CrystalParticle.Factory.withColor(0.25f, 1f, 0.5f));
    }

    public static <T extends ParticleEffect> void registerParticle(ParticleType<T> particleType, ParticleFactoryRegistry.PendingParticleFactory<T> particleFactory) {
        ParticleFactoryRegistry.getInstance().register(particleType, particleFactory);
    }

    public static void putBlockInRenderLayer(Block block, RenderLayer layer) {
        BlockRenderLayerMap.INSTANCE.putBlock(block, layer);
    }
}
