package me.codecraft.fossilsandbones.mixin;

import me.codecraft.fossilsandbones.Fossil;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * The type Fossil mixin.
 */
@Mixin(TitleScreen.class)
public class FossilMixin {
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		Fossil.LOGGER.info("This line is printed by an example mod mixin!");
	}
}
