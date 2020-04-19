package net.teamfruit.emojicord.gui.config;

import com.google.common.collect.Lists;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.ConfigElement;
import net.teamfruit.emojicord.EmojicordConfig;
import net.teamfruit.emojicord.Reference;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class ConfigGui extends GuiConfig {
	public ConfigGui(final @Nullable GuiScreen parent) {
		super(parent, getConfigElements(), Reference.MODID, false, false, GuiConfig.getAbridgedConfigPath(EmojicordConfig.spec.getConfigFile().getName()));
	}

	private static @Nonnull
	List<IConfigElement> getConfigElements() {
		final List<IConfigElement> list = Lists.newArrayList();

		for (final String cat : EmojicordConfig.spec.getConfiguration().getCategoryNames()) {
			final ConfigCategory cc = EmojicordConfig.spec.getConfiguration().getCategory(cat);

			if (cc.isChild())
				continue;

			list.add(new ConfigElement(cc));
		}

		return list;
	}
}