package studio.icecraft.emotecraftrecording;

import io.github.kosmx.emotes.arch.network.NetworkPlatformTools;
import com.replaymod.recording.ReplayModRecording;

import io.github.kosmx.emotes.common.network.EmotePacket.Builder;

public class EmotecraftReplayAddonClient {
	public static void recordPacket(Builder builder) {
		if (ReplayModRecording.instance == null) {
			return;
		}
		Builder safeBuilder = builder.copy();
		EmotePacketVersionFix.ensureVersions(safeBuilder);
		ReplayModRecording.instance.getConnectionEventHandler().getPacketListener().save(
			NetworkPlatformTools.playPacket(safeBuilder.build())
		);
	}
}