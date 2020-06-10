package dev.tigr.utilities;

import dev.tigr.clantags.api.ClanTags;
import dev.tigr.emoji.api.Emojis;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = UtilityMod.MODID, name = UtilityMod.NAME, version = UtilityMod.VERSION, clientSideOnly = true)
public class UtilityMod {
	public static final String MODID = "2b2t-utilities";
	public static final String NAME = "2b2t Utilities";
	public static final String VERSION = "1.0";

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);

		Emojis.load(); // load emojis

		ClanTags.load(); // load clans
		ClanTags.PREFIX = "/"; // set the prefix of the command
		ClientCommandHandler.instance.registerCommand(ClanTags.INFO_COMMAND); // register commands
		ClientCommandHandler.instance.registerCommand(ClanTags.CLANS_COMMAND); // see each command for method to run on execute
	}

	@SubscribeEvent
	public void onChatMessage(ClientChatReceivedEvent event) {
		ClanTags.handleClientChatReceivedEvent(event); // handle chat messages received
	}
}
