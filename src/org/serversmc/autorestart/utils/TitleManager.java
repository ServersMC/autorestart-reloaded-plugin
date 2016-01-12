package org.serversmc.autorestart.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class TitleManager {
	private static boolean initialized;
	private static Class<?> nmsChatSerializer;
	private static Class<?> nmsPacketTitle;
	private static Class<?> nmsTitleAction;
	private static Class<?> nmsPlayerConnection;
	private static Class<?> nmsEntityPlayer;
	private static Class<?> nmsChatBaseComponent;
	private static Class<?> ioNettyChannel;
	private static Class<?> packetTitle;
	private static Class<?> packetTitleAction;
	private static Method nmsSendPacket;
	private static Method nmsChatSerializerA;
	private static Method nmsNetworkGetVersion;
	private static Field nmsFieldPlayerConnection;
	private static Field nmsFieldNetworkManager;
	private static Field nmsFieldNetworkManagerI;
	private static Field nmsFieldNetworkManagerM;
	private static double serverVersion = 1.7D;
	private static int VERSION = 47;

	public static void sendTitle(Player p, String title) {
		if ((p == null) || (title == null)) {
			throw new NullPointerException();
		}
		if (getVersion(p) < VERSION) {
			return;
		}
		try {
			Object handle = Reflection.getHandle(p);
			Object connection = nmsFieldPlayerConnection.get(handle);
			Object serialized = nmsChatSerializerA.invoke(null, title);
			Object packet = nmsPacketTitle.getConstructor(nmsTitleAction, nmsChatBaseComponent).newInstance(nmsTitleAction.getEnumConstants()[0], serialized);
			nmsSendPacket.invoke(connection, packet);
		}
		catch (Exception e) {
			System.err.println("[TitleManager] Error while sending title to Player " + p.getName() + ": " + e.getMessage());
			e.printStackTrace(System.err);
		}
	}

	public static void sendTitle(Player p, int fadeIn, int stay, int fadeOut, String title) {
		sendTimings(p, fadeIn, stay, fadeOut);
		sendTitle(p, title);
	}

	public static void sendSubTitle(Player p, String subtitle) {
		if ((p == null) || (subtitle == null)) {
			throw new NullPointerException();
		}
		if (getVersion(p) < VERSION) {
			return;
		}
		try {
			Object handle = Reflection.getHandle(p);
			Object connection = nmsFieldPlayerConnection.get(handle);
			Object serialized = nmsChatSerializerA.invoke(null, subtitle);
			Object packet = nmsPacketTitle.getConstructor(nmsTitleAction, nmsChatBaseComponent).newInstance(nmsTitleAction.getEnumConstants()[1], serialized);
			nmsSendPacket.invoke(connection, packet);
		}
		catch (Exception e) {
			System.err.println("[TitleManager] Error while sending subtitle to Player " + p.getName() + ": " + e.getMessage());
			e.printStackTrace(System.err);
		}
	}

	public static void sendSubTitle(Player p, int fadeIn, int stay, int fadeOut, String subtitle) {
		sendTimings(p, fadeIn, stay, fadeOut);
		sendSubTitle(p, subtitle);
	}

	public static void sendTimings(Player p, int fadeIn, int stay, int fadeOut) {
		if (p == null) {
			throw new NullPointerException();
		}
		if (getVersion(p) < VERSION) {
			return;
		}
		try {
			Object handle = Reflection.getHandle(p);
			Object connection = nmsFieldPlayerConnection.get(handle);
			Object packet = nmsPacketTitle.getConstructor(nmsTitleAction, nmsChatBaseComponent, Integer.TYPE, Integer.TYPE, Integer.TYPE).newInstance(nmsTitleAction.getEnumConstants()[2], null, (int) fadeIn, (int) stay, (int) fadeOut);
			nmsSendPacket.invoke(connection, packet);
		}
		catch (Exception e) {
			System.err.println("[TitleManager] Error while sending timings to Player " + p.getName() + ": " + e.getMessage());
			e.printStackTrace(System.err);
		}
	}

	public static void clear(Player p) {
		if (p == null) {
			throw new NullPointerException();
		}
		if (getVersion(p) < VERSION) {
			return;
		}
		try {
			Object handle = Reflection.getHandle(p);
			Object connection = nmsFieldPlayerConnection.get(handle);
			Object packet = nmsPacketTitle.getConstructor(nmsTitleAction, nmsChatBaseComponent).newInstance(nmsTitleAction.getEnumConstants()[3], null);
			nmsSendPacket.invoke(connection, packet);
		}
		catch (Exception e) {
			System.err.println("[TitleManager] Error while sending clear to Player " + p.getName() + ": " + e.getMessage());
			e.printStackTrace(System.err);
		}
	}

	public static void reset(Player p) {
		if (p == null) {
			throw new NullPointerException();
		}
		if (getVersion(p) < VERSION) {
			return;
		}
		try {
			Object handle = Reflection.getHandle(p);
			Object connection = nmsFieldPlayerConnection.get(handle);
			Object packet;
			if (serverVersion == 1.7D) {
				packet = packetTitle.getConstructor(packetTitleAction).newInstance(packetTitleAction.getEnumConstants()[4]);
			}
			else {
				packet = nmsPacketTitle.getConstructor(nmsTitleAction, nmsChatBaseComponent).newInstance(nmsTitleAction.getEnumConstants()[4], null);
			}
			nmsSendPacket.invoke(connection, new Object[] { packet });
		}
		catch (Exception e) {
			System.err.println("[TitleManager] Error while sending reset to Player " + p.getName() + ": " + e.getMessage());
			e.printStackTrace(System.err);
		}
	}

	public static int getVersion(Player p) {
		try {
			Object handle = Reflection.getHandle(p);
			Object connection = nmsFieldPlayerConnection.get(handle);
			Object network = nmsFieldNetworkManager.get(connection);
			Object channel;
			if (serverVersion == 1.7D) {
				channel = nmsFieldNetworkManagerM.get(network);
			}
			else {
				channel = nmsFieldNetworkManagerI.get(network);
			}
			Object version = serverVersion == 1.7D ? nmsNetworkGetVersion.invoke(network, new Object[] { channel }) : 47;
			return (int) version;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return 180;
	}

	static {
		if (!initialized) {
			String ver = Reflection.getVersion();
			if (ver.contains("1_7")) {
				serverVersion = 1.7D;
			}
			if (ver.contains("1_8")) {
				serverVersion = 1.8D;
			}
			if (ver.contains("1_8_R2")) {
				serverVersion = 1.83D;
			}
			if (ver.contains("1_8_R3")) {
				serverVersion = 1.85D;
			}
			try {
				nmsChatBaseComponent = Reflection.getNMSClass("IChatBaseComponent");
				nmsChatSerializer = Reflection.getNMSClass((Reflection.getVersion().contains("1_7")) || (Reflection.getVersion().contains("1_8_R1")) ? "ChatSerializer" : "IChatBaseComponent$ChatSerializer");
				if (serverVersion >= 1.8D) {
					nmsPacketTitle = Reflection.getNMSClass("PacketPlayOutTitle");
					if (serverVersion >= 1.83D) {
						nmsTitleAction = Reflection.getNMSClass("PacketPlayOutTitle$EnumTitleAction");
					}
					else {
						nmsTitleAction = Reflection.getNMSClass("EnumTitleAction");
					}
				}
				else {
					try {
						packetTitle = Class.forName("org.spigotmc.ProtocolInjector$PacketTitle");
						packetTitleAction = Class.forName("org.spigotmc.ProtocolInjector$PacketTitle$Action");
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}
				nmsPlayerConnection = Reflection.getNMSClass("PlayerConnection");
				nmsEntityPlayer = Reflection.getNMSClass("EntityPlayer");
				ioNettyChannel = serverVersion == 1.7D ? Class.forName("net.minecraft.util.io.netty.channel.Channel") : Class.forName("io.netty.channel.Channel");

				nmsFieldPlayerConnection = Reflection.getField(nmsEntityPlayer, "playerConnection");
				nmsFieldNetworkManager = Reflection.getField(nmsPlayerConnection, "networkManager");
				nmsFieldNetworkManagerI = Reflection.getField(nmsFieldNetworkManager.getType(), "i");
				nmsFieldNetworkManagerM = Reflection.getField(nmsFieldNetworkManager.getType(), "m");

				nmsSendPacket = Reflection.getMethod(nmsPlayerConnection, "sendPacket", new Class[0]);
				nmsChatSerializerA = Reflection.getMethod(nmsChatSerializer, "a", String.class);
				nmsNetworkGetVersion = Reflection.getMethod(nmsFieldNetworkManager.getType(), "getVersion", ioNettyChannel);

				initialized = true;
			}
			catch (Exception e) {
				System.err.println("[TitleManager] Error while loading: " + e.getMessage());
				e.printStackTrace(System.err);
				Bukkit.getPluginManager().disablePlugin(Bukkit.getPluginManager().getPlugin("TitleManager"));
			}
		}
	}
}
