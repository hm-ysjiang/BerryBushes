package hmysjiang.berrybushes.proxy;

import java.util.HashMap;
import java.util.Map;

import hmysjiang.berrybushes.ModRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;

public class ClientProxy implements IProxy {
	
	@Override
	public void setupBlockRenderTypes() {
		Map<Block, RenderType> bushRenders = new HashMap<>();
		ModRegistry.Blocks.bushes.forEach(block -> bushRenders.put(block, RenderType.getCutoutMipped()));
		bushRenders.forEach(RenderTypeLookup::setRenderLayer);
	}
	
}
