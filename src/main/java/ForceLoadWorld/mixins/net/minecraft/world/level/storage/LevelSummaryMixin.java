package ForceLoadWorld.mixins.net.minecraft.world.level.storage;

import net.minecraft.world.level.storage.LevelSummary;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LevelSummary.class)
public class LevelSummaryMixin {
    @Inject(
        method = "isPreWorldHeightChangeVersion",
        at = @At(
            value = "RETURN"
        ),
        cancellable = true
    )
    private void unlockWorldHeightBlock(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }
}
