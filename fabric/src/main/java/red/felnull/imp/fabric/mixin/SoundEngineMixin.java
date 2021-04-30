package red.felnull.imp.fabric.mixin;

import net.minecraft.client.sounds.SoundEngine;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import red.felnull.imp.client.music.MusicEngine;

@Mixin(SoundEngine.class)
public class SoundEngineMixin {
    @Inject(method = "tick", at = @At("HEAD"))
    private void tick(boolean bl, CallbackInfo ci) {
        MusicEngine.getInstance().tick(bl);
    }

    @Inject(method = "tickNonPaused", at = @At("HEAD"))
    private void tickNonPaused(CallbackInfo ci) {
        MusicEngine.getInstance().tickNonPaused();
    }
}
