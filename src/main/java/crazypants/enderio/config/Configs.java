package crazypants.enderio.config;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import tterrag.core.common.event.ConfigFileChangedEvent;
import cpw.mods.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Optional.Method;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import crazypants.enderio.EnderIO;
import crazypants.enderio.Log;
import crazypants.enderio.machine.weather.TileWeatherObelisk.WeatherTask;
import crazypants.enderio.network.PacketHandler;
import crazypants.vecmath.VecmathUtil;

public final class Configs {

  public static final String sectionPower = "Power Settings";
  public static final String sectionRecipe = "Recipe Settings";
  public static final String sectionItems = "Item Enabling";
  public static final String sectionEfficiency = "Efficiency Settings";
  public static final String sectionPersonal = "Personal Settings";
  public static final String sectionAnchor = "Anchor Settings";
  public static final String sectionStaff = "Staff Settings";
  public static final String sectionDarkSteel = "Dark Steel";
  public static final String sectionFarm = "Farm Settings";
  public static final String sectionAesthetic = "Aesthetic Settings";
  public static final String sectionAdvanced = "Advanced Settings";
  public static final String sectionMagnet = "Magnet Settings";
  public static final String sectionFluid = "Fluid Settings";
  public static final String sectionSpawner = "PoweredSpawner Settings";
  public static final String sectionKiller = "Killer Joe Settings";
  public static final String sectionSoulBinder = "Soul Binder Settings";
  public static final String sectionAttractor = "Mob Attractor Settings";
  public static final String sectionLootConfig = "Loot Config";
  public static final String sectionMobConfig = "Mob Config";
  public static final String sectionRailConfig = "Rail";
  public static final String sectionEnchantments = "Enchantments";
  public static final String sectionWeather = "Weather";
  public static final String sectionMisc = "Misc";

  public static final double DEFAULT_CONDUIT_SCALE = 0.6;

  @Config(section = sectionItems, comment = "When set to false reinforced obsidian is not craftable.")
  public static boolean reinforcedObsidianEnabled = true;
  
  public static boolean reinforcedObsidianUseDarkSteelBlocks = false;

  public static boolean useAlternateBinderRecipe = false;

  public static boolean useAlternateTesseractModel = false;

  public static boolean photovoltaicCellEnabled = true;

  public static boolean reservoirEnabled = true;

  @Config(section = sectionAesthetic, comment = "Valid values are between 0-1, smallest conduits at 0, largest at 1.", min = 0, max = 1)
  public static double conduitScale = DEFAULT_CONDUIT_SCALE;

  public static int numConduitsPerRecipe = 8;

  public static boolean transceiverEnabled = true;
  public static double transceiverEnergyLoss = 0.1;
  public static int transceiverUpkeepCostRF = 10;
  public static int transceiverBucketTransmissionCostRF = 100;
  public static int transceiverMaxIoRF = 20480;
  public static boolean transceiverUseEasyRecipe = false;

  public static File configDirectory;

  public static boolean useHardRecipes = false;

  public static boolean useSteelInChassi = false;

  public static boolean detailedPowerTrackingEnabled = false;

  public static boolean useSneakMouseWheelYetaWrench = true;
  public static boolean useSneakRightClickYetaWrench = false;

  public static boolean itemConduitUsePhyscialDistance = false;

  public static int enderFluidConduitExtractRate = 200;
  public static int enderFluidConduitMaxIoRate = 800;
  public static int advancedFluidConduitExtractRate = 100;
  public static int advancedFluidConduitMaxIoRate = 400;
  public static int fluidConduitExtractRate = 50;
  public static int fluidConduitMaxIoRate = 200;

  public static int gasConduitExtractRate = 200;
  public static int gasConduitMaxIoRate = 800;

  public static boolean updateLightingWhenHidingFacades = false;

  public static boolean travelAnchorEnabled = true;
  public static int travelAnchorMaxDistance = 48;

  public static int travelStaffMaxDistance = 128;
  public static float travelStaffPowerPerBlockRF = 250;

  public static int travelStaffMaxBlinkDistance = 16;
  public static int travelStaffBlinkPauseTicks = 10;

  public static boolean travelStaffEnabled = true;
  public static boolean travelStaffBlinkEnabled = true;
  public static boolean travelStaffBlinkThroughSolidBlocksEnabled = true;
  public static boolean travelStaffBlinkThroughClearBlocksEnabled = true;
  public static boolean travelStaffBlinkThroughUnbreakableBlocksEnabled = false;
  public static String[] travelStaffBlinkBlackList = new String[] {
      "minecraft:bedrock",
      "Thaumcraft:blockWarded"
  };
  public static float travelAnchorZoomScale = 0.2f;

  public static int enderIoRange = 8;
  public static boolean enderIoMeAccessEnabled = true;

  public static double[] darkSteelPowerDamgeAbsorptionRatios = { 0.5, 0.6, 0.75, 0.95 };
  public static int darkSteelPowerStorageBase = 100000;
  public static int darkSteelPowerStorageLevelOne = 150000;
  public static int darkSteelPowerStorageLevelTwo = 250000;
  public static int darkSteelPowerStorageLevelThree = 1000000;

  public static float darkSteelSpeedOneWalkModifier = 0.1f;
  public static float darkSteelSpeedTwoWalkMultiplier = 0.2f;
  public static float darkSteelSpeedThreeWalkMultiplier = 0.3f;

  public static float darkSteelSpeedOneSprintModifier = 0.1f;
  public static float darkSteelSpeedTwoSprintMultiplier = 0.3f;
  public static float darkSteelSpeedThreeSprintMultiplier = 0.5f;

  public static int darkSteelSpeedOneCost = 10;
  public static int darkSteelSpeedTwoCost = 15;
  public static int darkSteelSpeedThreeCost = 20;

  public static double darkSteelBootsJumpModifier = 1.5;
  public static int darkSteelJumpOneCost = 10;
  public static int darkSteelJumpTwoCost = 15;
  public static int darkSteelJumpThreeCost = 20;

  public static boolean slotZeroPlacesEight = true;

  public static int darkSteelWalkPowerCost = darkSteelPowerStorageLevelTwo / 3000;
  public static int darkSteelSprintPowerCost = darkSteelWalkPowerCost * 4;
  public static boolean darkSteelDrainPowerFromInventory = false;
  public static int darkSteelBootsJumpPowerCost = 150;
  public static int darkSteelFallDistanceCost = 75;

  public static float darkSteelSwordWitherSkullChance = 0.05f;
  public static float darkSteelSwordWitherSkullLootingModifier = 0.05f;
  public static float darkSteelSwordSkullChance = 0.1f;
  public static float darkSteelSwordSkullLootingModifier = 0.075f;
  public static float vanillaSwordSkullLootingModifier = 0.05f;
  public static float vanillaSwordSkullChance = 0.05f;
  public static float ticCleaverSkullDropChance = 0.1f;
  public static float ticBeheadingSkullModifier = 0.075f;
  public static float fakePlayerSkullChance = 0.5f;

  public static int darkSteelSwordPowerUsePerHit = 750;
  public static double darkSteelSwordEnderPearlDropChance = 1;
  public static double darkSteelSwordEnderPearlDropChancePerLooting = 0.5;

  public static int darkSteelPickEffeciencyObsidian = 50;
  public static int darkSteelPickPowerUseObsidian = 10000;
  public static float darkSteelPickApplyObsidianEffeciencyAtHardess = 40;
  public static int darkSteelPickPowerUsePerDamagePoint = 750;
  public static float darkSteelPickEffeciencyBoostWhenPowered = 2;
  public static boolean darkSteelPickMinesTiCArdite = true;

  public static int darkSteelAxePowerUsePerDamagePoint = 750;
  public static int darkSteelAxePowerUsePerDamagePointMultiHarvest = 1500;
  public static float darkSteelAxeEffeciencyBoostWhenPowered = 2;
  public static float darkSteelAxeSpeedPenaltyMultiHarvest = 4;

  public static int darkSteelUpgradeVibrantCost = 10;
  public static int darkSteelUpgradePowerOneCost = 10;
  public static int darkSteelUpgradePowerTwoCost = 15;
  public static int darkSteelUpgradePowerThreeCost = 20;

  public static int darkSteelGliderCost = 10;
  public static double darkSteelGliderHorizontalSpeed = 0.03;
  public static double darkSteelGliderVerticalSpeed = -0.05;
  public static double darkSteelGliderVerticalSpeedSprinting = -0.15;

  public static int darkSteelGogglesOfRevealingCost = 10;

  public static int darkSteelApiaristArmorCost = 10;

  public static int darkSteelSwimCost = 10;

  public static int darkSteelNightVisionCost = 10;

  public static int darkSteelSoundLocatorCost = 10;
  public static int darkSteelSoundLocatorRange = 40;
  public static int darkSteelSoundLocatorLifespan = 40;

  public static int darkSteelTravelCost = 30;
  public static int darkSteelSpoonCost = 10;

  public static int darkSteelSolarOneGen = 10;
  public static int darkSteelSolarOneCost = 15;
  public static int darkSteelSolarTwoGen = 40;
  public static int darkSteelSolarTwoCost = 30;
  public static boolean darkSteelSolarChargeOthers = true;

  public static float darkSteelAnvilDamageChance = 0.024f;

  public static float darkSteelLadderSpeedBoost = 0.06f;

  public static int hootchPowerPerCycleRF = 60;
  public static int hootchPowerTotalBurnTime = 6000;
  public static int rocketFuelPowerPerCycleRF = 160;
  public static int rocketFuelPowerTotalBurnTime = 7000;
  public static int fireWaterPowerPerCycleRF = 80;
  public static int fireWaterPowerTotalBurnTime = 15000;
  public static int vatPowerUserPerTickRF = 20;

  public static int maxPhotovoltaicOutputRF = 10;
  public static int maxPhotovoltaicAdvancedOutputRF = 40;

  public static int zombieGeneratorRfPerTick = 80;
  public static int zombieGeneratorTicksPerBucketFuel = 10000;

  public static int stirlingGeneratorBaseRfPerTick = 20;

  public static boolean combustionGeneratorUseOpaqueModel = true;

  public static boolean addFuelTooltipsToAllFluidContainers = true;
  public static boolean addFurnaceFuelTootip = true;
  public static boolean addDurabilityTootip = true;
  public static boolean addOreDictionaryTooltips = false;
  public static boolean addRegisterdNameTooltip = false;

  public static int farmContinuousEnergyUseRF = 40;
  public static int farmActionEnergyUseRF = 500;
  public static int farmAxeActionEnergyUseRF = 1000;

  public static int farmDefaultSize = 3;
  public static boolean farmAxeDamageOnLeafBreak = false;
  public static float farmToolTakeDamageChance = 1;
  public static boolean disableFarmNotification = false;
  public static boolean farmEssenceBerriesEnabled = true;
  public static boolean farmManaBeansEnabled = false;
  public static boolean farmHarvestJungleWhenCocoa = false;
  public static String[] hoeStrings = new String[] {
      "minecraft:wooden_hoe", "minecraft:stone_hoe", "minecraft:iron_hoe", "minecraft:diamond_hoe", "minecraft:golden_hoe",
      "MekanismTools:ObsidianHoe", "MekanismTools:LapisLazuliHoe", "MekanismTools:OsmiumHoe", "MekanismTools:BronzeHoe", "MekanismTools:GlowstoneHoe",
      "MekanismTools:SteelHoe",
      "Steamcraft:hoeBrass", "Steamcraft:hoeGildedGold",
      "Railcraft:tool.steel.hoe",
      "TConstruct:mattock",
      "appliedenergistics2:item.ToolCertusQuartzHoe", "appliedenergistics2:item.ToolNetherQuartzHoe",
      "ProjRed|Exploration:projectred.exploration.hoeruby", "ProjRed|Exploration:projectred.exploration.hoesapphire",
      "ProjRed|Exploration:projectred.exploration.hoeperidot",
      "magicalcrops:magicalcrops_AccioHoe", "magicalcrops:magicalcrops_CrucioHoe", "magicalcrops:magicalcrops_ImperioHoe",
      // disabled as it is currently not unbreaking as advertised "magicalcrops:magicalcrops_ZivicioHoe",
      "BiomesOPlenty:hoeAmethyst", "BiomesOPlenty:hoeMud",
      "Eln:Eln.Copper Hoe",
      "Thaumcraft:ItemHoeThaumium", "Thaumcraft:ItemHoeElemental", "Thaumcraft:ItemHoeVoid",
      "ThermalExpansion:tool.hoeInvar"
  };
  public static List<ItemStack> farmHoes = new ArrayList<ItemStack>();

  public static int magnetPowerUsePerSecondRF = 1;
  public static int magnetPowerCapacityRF = 100000;
  public static int magnetRange = 5;

  public static boolean useCombustionGenModel = false;

  public static int crafterRfPerCraft = 2500;

  public static int capacitorBankMaxIoRF = 5000;
  public static int capacitorBankMaxStorageRF = 5000000;

  public static int capacitorBankTierOneMaxIoRF = 1000;
  public static int capacitorBankTierOneMaxStorageRF = 1000000;

  public static int capacitorBankTierTwoMaxIoRF = 5000;
  public static int capacitorBankTierTwoMaxStorageRF = 5000000;

  public static int capacitorBankTierThreeMaxIoRF = 25000;
  public static int capacitorBankTierThreeMaxStorageRF = 25000000;

  public static int poweredSpawnerMinDelayTicks = 200;
  public static int poweredSpawnerMaxDelayTicks = 800;
  public static int poweredSpawnerLevelOnePowerPerTickRF = 160;
  public static int poweredSpawnerLevelTwoPowerPerTickRF = 500;
  public static int poweredSpawnerLevelThreePowerPerTickRF = 1500;
  public static int poweredSpawnerMaxPlayerDistance = 0;
  public static boolean poweredSpawnerUseVanillaSpawChecks = false;
  public static double brokenSpawnerDropChance = 1;
  public static String[] brokenSpawnerToolBlacklist = new String[] {
      "RotaryCraft:rotarycraft_item_bedpick"
  };
  public static int powerSpawnerAddSpawnerCost = 30;

  public static int painterEnergyPerTaskRF = 2000;

  public static int vacuumChestRange = 6;

  public static boolean useModMetals = true;

  public static int wirelessChargerRange = 24;

  public static long nutrientFoodBoostDelay = 400;

  public static int enchanterBaseLevelCost = 4;

  public static boolean machineSoundsEnabled = true;

  public static float machineSoundVolume = 1.0f;

  public static int killerJoeNutrientUsePerAttackMb = 5;
  public static double killerJoeAttackHeight = 2;
  public static double killerJoeAttackWidth = 2;
  public static double killerJoeAttackLength = 4;
  public static double killerJoeHooverXpWidth = 5;
  public static double killerJoeHooverXpLength = 10;
  public static int killerJoeMaxXpLevel = Integer.MAX_VALUE;
  public static boolean killerJoeMustSee = false;

  public static boolean allowTileEntitiesAsPaintSource = true;

  public static String isGasConduitEnabled = "auto";
  public static boolean enableMEConduits = true;

  public static String[] soulVesselBlackList = new String[0];
  public static boolean soulVesselCapturesBosses = false;

  public static int soulBinderLevelOnePowerPerTickRF = 500;
  public static int soulBinderLevelTwoPowerPerTickRF = 1000;
  public static int soulBinderLevelThreePowerPerTickRF = 2000;
  public static int soulBinderBrokenSpawnerRF = 2500000;
  public static int soulBinderBrokenSpawnerLevels = 15;
  public static int soulBinderReanimationRF = 100000;
  public static int soulBinderReanimationLevels = 10;
  public static int soulBinderEnderCystalRF = 100000;
  public static int soulBinderEnderCystalLevels = 10;
  public static int soulBinderAttractorCystalRF = 100000;
  public static int soulBinderAttractorCystalLevels = 10;
  public static int soulBinderEnderRailRF = 100000;
  public static int soulBinderEnderRailLevels = 10;
  public static int soulBinderMaxXpLevel = 40;

  public static boolean powerConduitCanDifferentTiersConnect = false;
  public static int powerConduitTierOneRF = 640;
  public static int powerConduitTierTwoRF = 5120;
  public static int powerConduitTierThreeRF = 20480;
  public static boolean powerConduitOutputMJ = true;

  public static int sliceAndSpliceLevelOnePowerPerTickRF = 80;
  public static int sliceAndSpliceLevelTwoPowerPerTickRF = 160;
  public static int sliceAndSpliceLevelThreePowerPerTickRF = 320;

  public static boolean soulBinderRequiresEndermanSkull = true;

  public static int attractorRangeLevelOne = 16;
  public static int attractorPowerPerTickLevelOne = 20;
  public static int attractorRangeLevelTwo = 32;
  public static int attractorPowerPerTickLevelTwo = 40;
  public static int attractorRangeLevelThree = 64;
  public static int attractorPowerPerTickLevelThree = 80;

  public static int spawnGuardRangeLevelOne = 64;
  public static int spawnGuardPowerPerTickLevelOne = 80;
  public static int spawnGuardRangeLevelTwo = 96;
  public static int spawnGuardPowerPerTickLevelTwo = 300;
  public static int spawnGuardRangeLevelThree = 160;
  public static int spawnGuardPowerPerTickLevelThree = 800;
  public static boolean spawnGuardStopAllSlimesDebug = false;
  public static boolean spawnGuardStopAllSquidSpawning = false;

  public static String weatherObeliskClearItem = "minecraft:cake";
  public static String weatherObeliskRainItem = "minecraft:water_bucket";
  public static String weatherObeliskThunderItem = "minecraft:lava_bucket";
  public static int weatherObeliskClearPower = 1000000;
  public static int weatherObeliskRainPower = 250000;
  public static int weatherObeliskThunderPower = 500000;

  //Loot Defaults
  public static boolean lootDarkSteel = true;
  public static boolean lootItemConduitProbe = true;
  public static boolean lootQuartz = true;
  public static boolean lootNetherWart = true;
  public static boolean lootEnderPearl = true;
  public static boolean lootElectricSteel = true;
  public static boolean lootRedstoneAlloy = true;
  public static boolean lootPhasedIron = true;
  public static boolean lootPhasedGold = true;
  public static boolean lootTravelStaff = true;
  public static boolean lootTheEnder = true;
  public static boolean lootDarkSteelBoots = true;

  public static boolean dumpMobNames = false;

  public static boolean enderRailEnabled = true;
  public static int enderRailPowerRequireCrossDimensions = 10000;
  public static int enderRailPowerRequiredPerBlock = 10;
  public static boolean enderRailCapSameDimensionPowerAtCrossDimensionCost = true;
  public static int enderRailTicksBeforeForceSpawningLinkedCarts = 60;
  public static boolean enderRailTeleportPlayers = false;

  public static int xpObeliskMaxXpLevel = Integer.MAX_VALUE;
  public static String xpJuiceName = "xpjuice";

  public static boolean clearGlassSameTexture = false;
  public static boolean clearGlassConnectToFusedQuartz = false;

  public static int enchantmentSoulBoundId = -1;
  public static int enchantmentSoulBoundWeight = 1;
  public static boolean enchantmentSoulBoundEnabled = true;

  public static boolean replaceWitherSkeletons = true;

  private static ConfigProcessor processor;

  public static void load(FMLPreInitializationEvent event) {

    FMLCommonHandler.instance().bus().register(new Configs());
    PacketHandler.INSTANCE.registerMessage(PacketConfigSync.class, PacketConfigSync.class, PacketHandler.nextID(), Side.CLIENT);
    PacketHandler.INSTANCE.registerMessage(PacketConfigSync.class, PacketConfigSync.class, PacketHandler.nextID(), Side.SERVER);

    configDirectory = new File(event.getModConfigurationDirectory(), EnderIO.MODID.toLowerCase());
    if(!configDirectory.exists()) {
      configDirectory.mkdir();
    }

    File configFile = new File(configDirectory, "EnderIO.cfg");
    processor = new ConfigProcessor(Configs.class, configFile);
    processor.process(false);
  }

  @SubscribeEvent
  public void onConfigChanged(OnConfigChangedEvent event) {
    if(event.modID.equals(EnderIO.MODID)) {
      Log.info("Updating config...");
      processor.process(false);
      postInit();
    }
  }

  @SubscribeEvent
  @Method(modid = "ttCore")
  public void onConfigFileChanged(ConfigFileChangedEvent event) {
    if(event.modID.equals(EnderIO.MODID)) {
      Log.info("Updating config...");
      processor.process(true);
      event.setSuccessful();
      postInit();
    }
  }
  
  @SubscribeEvent
  public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
    PacketHandler.INSTANCE.sendTo(new PacketConfigSync(processor), (EntityPlayerMP) event.player);
  }

  public static void processConfig(Configuration config) {

    capacitorBankMaxIoRF = config.get(sectionPower, "capacitorBankMaxIoRF", capacitorBankMaxIoRF, "The maximum IO for a single capacitor in RF/t")
        .getInt(capacitorBankMaxIoRF);
    capacitorBankMaxStorageRF = config.get(sectionPower, "capacitorBankMaxStorageRF", capacitorBankMaxStorageRF,
        "The maximum storage for a single capacitor in RF")
        .getInt(capacitorBankMaxStorageRF);

    capacitorBankTierOneMaxIoRF = config.get(sectionPower, "capacitorBankTierOneMaxIoRF", capacitorBankTierOneMaxIoRF,
        "The maximum IO for a single tier one capacitor in RF/t")
        .getInt(capacitorBankTierOneMaxIoRF);
    capacitorBankTierOneMaxStorageRF = config.get(sectionPower, "capacitorBankTierOneMaxStorageRF", capacitorBankTierOneMaxStorageRF,
        "The maximum storage for a single tier one capacitor in RF")
        .getInt(capacitorBankTierOneMaxStorageRF);

    capacitorBankTierTwoMaxIoRF = config.get(sectionPower, "capacitorBankTierTwoMaxIoRF", capacitorBankTierTwoMaxIoRF,
        "The maximum IO for a single tier two capacitor in RF/t")
        .getInt(capacitorBankTierTwoMaxIoRF);
    capacitorBankTierTwoMaxStorageRF = config.get(sectionPower, "capacitorBankTierTwoMaxStorageRF", capacitorBankTierTwoMaxStorageRF,
        "The maximum storage for a single tier two capacitor in RF")
        .getInt(capacitorBankTierTwoMaxStorageRF);

    capacitorBankTierThreeMaxIoRF = config.get(sectionPower, "capacitorBankTierThreeMaxIoRF", capacitorBankTierThreeMaxIoRF,
        "The maximum IO for a single tier three capacitor in RF/t")
        .getInt(capacitorBankTierThreeMaxIoRF);
    capacitorBankTierThreeMaxStorageRF = config.get(sectionPower, "capacitorBankTierThreeMaxStorageRF", capacitorBankTierThreeMaxStorageRF,
        "The maximum storage for a single tier three capacitor in RF")
        .getInt(capacitorBankTierThreeMaxStorageRF);

    powerConduitTierOneRF = config.get(sectionPower, "powerConduitTierOneRF", powerConduitTierOneRF, "The maximum IO for the tier 1 power conduit")
        .getInt(powerConduitTierOneRF);
    powerConduitTierTwoRF = config.get(sectionPower, "powerConduitTierTwoRF", powerConduitTierTwoRF, "The maximum IO for the tier 2 power conduit")
        .getInt(powerConduitTierTwoRF);
    powerConduitTierThreeRF = config.get(sectionPower, "powerConduitTierThreeRF", powerConduitTierThreeRF, "The maximum IO for the tier 3 power conduit")
        .getInt(powerConduitTierThreeRF);
    powerConduitCanDifferentTiersConnect = config
        .getBoolean("powerConduitCanDifferentTiersConnect", sectionPower, powerConduitCanDifferentTiersConnect,
            "If set to false power conduits of different tiers cannot be connected. in this case a block such as a cap. bank is needed to bridge different tiered networks");
    powerConduitOutputMJ = config.getBoolean("powerConduitOutputMJ", sectionPower, powerConduitOutputMJ, "When set to true power conduits will output MJ if RF is not supported");
    
    
    painterEnergyPerTaskRF = config.get(sectionPower, "painterEnergyPerTaskRF", painterEnergyPerTaskRF,
        "The total amount of RF required to paint one block")
        .getInt(painterEnergyPerTaskRF);

    useHardRecipes = config.get(sectionRecipe, "useHardRecipes", useHardRecipes, "When enabled machines cost significantly more.")
        .getBoolean(useHardRecipes);
    soulBinderRequiresEndermanSkull = config.getBoolean("soulBinderRequiresEndermanSkull", sectionRecipe, soulBinderRequiresEndermanSkull, 
        "When true the Soul Binder requires an Enderman Skull to craft");
    allowTileEntitiesAsPaintSource = config.get(sectionRecipe, "allowTileEntitiesAsPaintSource", allowTileEntitiesAsPaintSource,
        "When enabled blocks with tile entities (e.g. machines) can be used as paint targets.")
        .getBoolean(allowTileEntitiesAsPaintSource);
    useSteelInChassi = config.get(sectionRecipe, "useSteelInChassi", useSteelInChassi, "When enabled machine chassis will require steel instead of iron.")
        .getBoolean(useSteelInChassi);
    numConduitsPerRecipe = config.get(sectionRecipe, "numConduitsPerRecipe", numConduitsPerRecipe,
        "The number of conduits crafted per recipe.").getInt(numConduitsPerRecipe);
    transceiverUseEasyRecipe= config.get(sectionRecipe, "transceiverUseEasyRecipe", transceiverUseEasyRecipe, "When enabled the dim trans. will use a cheaper recipe")
        .getBoolean(useHardRecipes);

    enchanterBaseLevelCost = config.get(sectionRecipe, "enchanterBaseLevelCost", enchanterBaseLevelCost,
        "Base level cost added to all recipes in the enchanter.").getInt(enchanterBaseLevelCost);

    photovoltaicCellEnabled = config.get(sectionItems, "photovoltaicCellEnabled", photovoltaicCellEnabled,
        "If set to false: Photovoltaic Cells will not be craftable.")
        .getBoolean(photovoltaicCellEnabled);

    reservoirEnabled= config.get(sectionItems, "reservoirEnabled", reservoirEnabled,
        "If set to false reservoirs will not be craftable.")
        .getBoolean(reservoirEnabled);
    
    transceiverEnabled = config.get(sectionItems, "transceiverEnabled", transceiverEnabled,
        "If set to false: Dimensional Transceivers will not be craftable.")
        .getBoolean(transceiverEnabled);

    maxPhotovoltaicOutputRF = config.get(sectionPower, "maxPhotovoltaicOutputRF", maxPhotovoltaicOutputRF,
        "Maximum output in RF/t of the Photovoltaic Panels.").getInt(maxPhotovoltaicOutputRF);
    maxPhotovoltaicAdvancedOutputRF = config.get(sectionPower, "maxPhotovoltaicAdvancedOutputRF", maxPhotovoltaicAdvancedOutputRF,
        "Maximum output in RF/t of the Advanced Photovoltaic Panels.").getInt(maxPhotovoltaicAdvancedOutputRF);

    useAlternateBinderRecipe = config.get(sectionRecipe, "useAlternateBinderRecipe", false, "Create conduit binder in crafting table instead of furnace")
        .getBoolean(useAlternateBinderRecipe);

    wirelessChargerRange = config.get(sectionEfficiency, "wirelessChargerRange", wirelessChargerRange,
        "The range of the wireless charger").getInt(wirelessChargerRange);

    fluidConduitExtractRate = config.get(sectionEfficiency, "fluidConduitExtractRate", fluidConduitExtractRate,
        "Number of millibuckets per tick extracted by a fluid conduits auto extracting").getInt(fluidConduitExtractRate);

    fluidConduitMaxIoRate = config.get(sectionEfficiency, "fluidConduitMaxIoRate", fluidConduitMaxIoRate,
        "Number of millibuckets per tick that can pass through a single connection to a fluid conduit.").getInt(fluidConduitMaxIoRate);

    advancedFluidConduitExtractRate = config.get(sectionEfficiency, "advancedFluidConduitExtractRate", advancedFluidConduitExtractRate,
        "Number of millibuckets per tick extracted by pressurised fluid conduits auto extracting").getInt(advancedFluidConduitExtractRate);

    advancedFluidConduitMaxIoRate = config.get(sectionEfficiency, "advancedFluidConduitMaxIoRate", advancedFluidConduitMaxIoRate,
        "Number of millibuckets per tick that can pass through a single connection to an pressurised fluid conduit.").getInt(advancedFluidConduitMaxIoRate);

    enderFluidConduitExtractRate = config.get(sectionEfficiency, "enderFluidConduitExtractRate", enderFluidConduitExtractRate,
        "Number of millibuckets per tick extracted by ender fluid conduits auto extracting").getInt(enderFluidConduitExtractRate);

    enderFluidConduitMaxIoRate = config.get(sectionEfficiency, "enderFluidConduitMaxIoRate", enderFluidConduitMaxIoRate,
        "Number of millibuckets per tick that can pass through a single connection to an ender fluid conduit.").getInt(enderFluidConduitMaxIoRate);

    gasConduitExtractRate = config.get(sectionEfficiency, "gasConduitExtractRate", gasConduitExtractRate,
        "Amount of gas per tick extracted by gas conduits auto extracting").getInt(gasConduitExtractRate);

    gasConduitMaxIoRate = config.get(sectionEfficiency, "gasConduitMaxIoRate", gasConduitMaxIoRate,
        "Amount of gas per tick that can pass through a single connection to a gas conduit.").getInt(gasConduitMaxIoRate);

    useAlternateTesseractModel = config.get(sectionAesthetic, "useAlternateTransceiverModel", useAlternateTesseractModel,
        "Use TheKazador's alternative model for the Dimensional Transceiver")
        .getBoolean(false);
    transceiverEnergyLoss = config.get(sectionPower, "transceiverEnergyLoss", transceiverEnergyLoss,
        "Amount of energy lost when transfered by Dimensional Transceiver; 0 is no loss, 1 is 100% loss").getDouble(transceiverEnergyLoss);
    transceiverUpkeepCostRF = config.get(sectionPower, "transceiverUpkeepCostRF", transceiverUpkeepCostRF,
        "Number of RF/t required to keep a Dimensional Transceiver connection open").getInt(transceiverUpkeepCostRF);
    transceiverMaxIoRF = config.get(sectionPower, "transceiverMaxIoRF", transceiverMaxIoRF,
        "Maximum RF/t sent and received by a Dimensional Transceiver per tick. Input and output limits are not cumulative").getInt(transceiverMaxIoRF);
    transceiverBucketTransmissionCostRF = config.get(sectionEfficiency, "transceiverBucketTransmissionCostRF", transceiverBucketTransmissionCostRF,
        "The cost in RF of transporting a bucket of fluid via a Dimensional Transceiver.").getInt(transceiverBucketTransmissionCostRF);

    vatPowerUserPerTickRF = config.get(sectionPower, "vatPowerUserPerTickRF", vatPowerUserPerTickRF,
        "Power use (RF/t) used by the vat.").getInt(vatPowerUserPerTickRF);

    detailedPowerTrackingEnabled = config
        .get(
            sectionAdvanced,
            "perInterfacePowerTrackingEnabled",
            detailedPowerTrackingEnabled,
            "Enable per tick sampling on individual power inputs and outputs. This allows slightly more detailed messages from the RF Reader but has a negative impact on server performance.")
        .getBoolean(detailedPowerTrackingEnabled);

    useSneakMouseWheelYetaWrench = config.get(sectionPersonal, "useSneakMouseWheelYetaWrench", useSneakMouseWheelYetaWrench,
        "If true, shift-mouse wheel will change the conduit display mode when the YetaWrench is equipped.")
        .getBoolean(useSneakMouseWheelYetaWrench);

    useSneakRightClickYetaWrench = config.get(sectionPersonal, "useSneakRightClickYetaWrench", useSneakRightClickYetaWrench,
        "If true, shift-clicking the YetaWrench on a null or non wrenchable object will change the conduit display mode.")
        .getBoolean(useSneakRightClickYetaWrench);

    machineSoundsEnabled = config.get(sectionPersonal, "useMachineSounds", machineSoundsEnabled,
        "If true, machines will make sounds.")
        .getBoolean(machineSoundsEnabled);

    machineSoundVolume = (float) config.get(sectionPersonal, "machineSoundVolume", machineSoundVolume, "Volume of machine sounds.").getDouble(
        machineSoundVolume);

    itemConduitUsePhyscialDistance = config.get(sectionEfficiency, "itemConduitUsePhyscialDistance", itemConduitUsePhyscialDistance, "If true, " +
        "'line of sight' distance rather than conduit path distance is used to calculate priorities.")
        .getBoolean(itemConduitUsePhyscialDistance);

    vacuumChestRange = config.get(sectionEfficiency, "vacumChestRange", vacuumChestRange, "The range of the vacuum chest").getInt(vacuumChestRange);

    if(!useSneakMouseWheelYetaWrench && !useSneakRightClickYetaWrench) {
      Log.warn("Both useSneakMouseWheelYetaWrench and useSneakRightClickYetaWrench are set to false. Enabling mouse wheel.");
      useSneakMouseWheelYetaWrench = true;
    }

    reinforcedObsidianUseDarkSteelBlocks = config.get(sectionRecipe, "reinforcedObsidianUseDarkSteelBlocks", reinforcedObsidianUseDarkSteelBlocks,
        "When set to true four dark steel blocks are required instead of ingots when making reinforced obsidian.").getBoolean(reinforcedObsidianUseDarkSteelBlocks);

    travelAnchorEnabled = config.get(sectionItems, "travelAnchorEnabled", travelAnchorEnabled,
        "When set to false: the travel anchor will not be craftable.").getBoolean(travelAnchorEnabled);

    travelAnchorMaxDistance = config.get(sectionAnchor, "travelAnchorMaxDistance", travelAnchorMaxDistance,
        "Maximum number of blocks that can be traveled from one travel anchor to another.").getInt(travelAnchorMaxDistance);

    travelStaffMaxDistance = config.get(sectionStaff, "travelStaffMaxDistance", travelStaffMaxDistance,
        "Maximum number of blocks that can be traveled using the Staff of the Traveling.").getInt(travelStaffMaxDistance);
    travelStaffPowerPerBlockRF = (float) config.get(sectionStaff, "travelStaffPowerPerBlockRF", travelStaffPowerPerBlockRF,
        "Number of RF required per block travelled using the Staff of the Traveling.").getDouble(travelStaffPowerPerBlockRF);

    travelStaffMaxBlinkDistance = config.get(sectionStaff, "travelStaffMaxBlinkDistance", travelStaffMaxBlinkDistance,
        "Max number of blocks teleported when shift clicking the staff.").getInt(travelStaffMaxBlinkDistance);

    travelStaffBlinkPauseTicks = config.get(sectionStaff, "travelStaffBlinkPauseTicks", travelStaffBlinkPauseTicks,
        "Minimum number of ticks between 'blinks'. Values of 10 or less allow a limited sort of flight.").getInt(travelStaffBlinkPauseTicks);

    travelStaffEnabled = config.get(sectionStaff, "travelStaffEnabled", travelAnchorEnabled,
        "If set to false: the travel staff will not be craftable.").getBoolean(travelStaffEnabled);
    travelStaffBlinkEnabled = config.get(sectionStaff, "travelStaffBlinkEnabled", travelStaffBlinkEnabled,
        "If set to false: the travel staff can not be used to shift-right click teleport, or blink.").getBoolean(travelStaffBlinkEnabled);
    travelStaffBlinkThroughSolidBlocksEnabled = config.get(sectionStaff, "travelStaffBlinkThroughSolidBlocksEnabled",
        travelStaffBlinkThroughSolidBlocksEnabled,
        "If set to false: the travel staff can be used to blink through any block.").getBoolean(travelStaffBlinkThroughSolidBlocksEnabled);
    travelStaffBlinkThroughClearBlocksEnabled = config
        .get(sectionItems, "travelStaffBlinkThroughClearBlocksEnabled", travelStaffBlinkThroughClearBlocksEnabled,
            "If travelStaffBlinkThroughSolidBlocksEnabled is set to false and this is true: the travel " +
                "staff can only be used to blink through transparent or partial blocks (e.g. torches). " +
                "If both are false: only air blocks may be teleported through.")
        .getBoolean(travelStaffBlinkThroughClearBlocksEnabled);
    travelStaffBlinkThroughUnbreakableBlocksEnabled = config.get(sectionItems, "travelStaffBlinkThroughUnbreakableBlocksEnabled",
        travelStaffBlinkThroughUnbreakableBlocksEnabled, "Allows the travel staff to blink through unbreakable blocks such as warded blocks and bedrock.")
        .getBoolean();
    travelStaffBlinkBlackList = config.getStringList("travelStaffBlinkBlackList", sectionStaff, travelStaffBlinkBlackList,
        "Lists the blocks that cannot be teleported through in the form 'modID:blockName'");
    travelAnchorZoomScale = config.getFloat("travelAnchorZoomScale", sectionStaff, travelAnchorZoomScale, 0, 1, 
        "Set the max zoomed size of a travel anchor as an aprox. percentage of screen height");
    

    enderIoRange = config.get(sectionEfficiency, "enderIoRange", enderIoRange,
        "Range accessible (in blocks) when using the Ender IO.").getInt(enderIoRange);

    enderIoMeAccessEnabled = config.get(sectionPersonal, "enderIoMeAccessEnabled", enderIoMeAccessEnabled,
        "If false: you will not be able to access a ME access or crafting terminal using the Ender IO.").getBoolean(enderIoMeAccessEnabled);

    updateLightingWhenHidingFacades = config.get(sectionEfficiency, "updateLightingWhenHidingFacades", updateLightingWhenHidingFacades,
        "When true: correct lighting is recalculated (client side) for conduit bundles when transitioning to"
            + " from being hidden behind a facade. This produces "
            + "better quality rendering but can result in frame stutters when switching to/from a wrench.")
        .getBoolean(updateLightingWhenHidingFacades);

    darkSteelPowerDamgeAbsorptionRatios = config
        .get(sectionDarkSteel, "darkSteelPowerDamgeAbsorptionRatios", darkSteelPowerDamgeAbsorptionRatios,
            "A list of the amount of durability damage absorbed when items are powered. In order of upgrade level. 1=100% so items take no durability damage when powered.")
        .getDoubleList();
    darkSteelPowerStorageBase = config.get(sectionDarkSteel, "darkSteelPowerStorageBase", darkSteelPowerStorageBase,
        "Base amount of power stored by dark steel items.").getInt(darkSteelPowerStorageBase);
    darkSteelPowerStorageLevelOne = config.get(sectionDarkSteel, "darkSteelPowerStorageLevelOne", darkSteelPowerStorageLevelOne,
        "Amount of power stored by dark steel items with a level 1 upgrade.").getInt(darkSteelPowerStorageLevelOne);
    darkSteelPowerStorageLevelTwo = config.get(sectionDarkSteel, "darkSteelPowerStorageLevelTwo", darkSteelPowerStorageLevelTwo,
        "Amount of power stored by dark steel items with a level 2 upgrade.").getInt(darkSteelPowerStorageLevelTwo);
    darkSteelPowerStorageLevelThree = config.get(sectionDarkSteel, "darkSteelPowerStorageLevelThree", darkSteelPowerStorageLevelThree,
        "Amount of power stored by dark steel items with a level 3 upgrade.").getInt(darkSteelPowerStorageLevelThree);

    darkSteelUpgradeVibrantCost = config.get(sectionDarkSteel, "darkSteelUpgradeVibrantCost", darkSteelUpgradeVibrantCost,
        "Number of levels required for the 'Empowered.").getInt(darkSteelUpgradeVibrantCost);
    darkSteelUpgradePowerOneCost = config.get(sectionDarkSteel, "darkSteelUpgradePowerOneCost", darkSteelUpgradePowerOneCost,
        "Number of levels required for the 'Power 1.").getInt(darkSteelUpgradePowerOneCost);
    darkSteelUpgradePowerTwoCost = config.get(sectionDarkSteel, "darkSteelUpgradePowerTwoCost", darkSteelUpgradePowerTwoCost,
        "Number of levels required for the 'Power 2.").getInt(darkSteelUpgradePowerTwoCost);
    darkSteelUpgradePowerThreeCost = config.get(sectionDarkSteel, "darkSteelUpgradePowerThreeCost", darkSteelUpgradePowerThreeCost,
        "Number of levels required for the 'Power 3' upgrade.").getInt(darkSteelUpgradePowerThreeCost);

    darkSteelJumpOneCost = config.get(sectionDarkSteel, "darkSteelJumpOneCost", darkSteelJumpOneCost,
        "Number of levels required for the 'Jump 1' upgrade.").getInt(darkSteelJumpOneCost);
    darkSteelJumpTwoCost = config.get(sectionDarkSteel, "darkSteelJumpTwoCost", darkSteelJumpTwoCost,
        "Number of levels required for the 'Jump 2' upgrade.").getInt(darkSteelJumpTwoCost);
    darkSteelJumpThreeCost = config.get(sectionDarkSteel, "darkSteelJumpThreeCost", darkSteelJumpThreeCost,
        "Number of levels required for the 'Jump 3' upgrade.").getInt(darkSteelJumpThreeCost);
    
    darkSteelSpeedOneCost = config.get(sectionDarkSteel, "darkSteelSpeedOneCost", darkSteelSpeedOneCost,
        "Number of levels required for the 'Speed 1' upgrade.").getInt(darkSteelSpeedOneCost);
    darkSteelSpeedTwoCost = config.get(sectionDarkSteel, "darkSteelSpeedTwoCost", darkSteelSpeedTwoCost,
        "Number of levels required for the 'Speed 2' upgrade.").getInt(darkSteelSpeedTwoCost);
    darkSteelSpeedThreeCost = config.get(sectionDarkSteel, "darkSteelSpeedThreeCost", darkSteelSpeedThreeCost,
        "Number of levels required for the 'Speed 3' upgrade.").getInt(darkSteelSpeedThreeCost);
    
    slotZeroPlacesEight = config.get(sectionDarkSteel, "shouldSlotZeroWrap", slotZeroPlacesEight, "Should the dark steel placement, when in the first (0th) slot, place the item in the last slot. If false, will place what's in the second slot.").getBoolean();
    
    darkSteelSpeedOneWalkModifier = (float) config.get(sectionDarkSteel, "darkSteelSpeedOneWalkModifier", darkSteelSpeedOneWalkModifier,
        "Speed modifier applied when walking in the Dark Steel Boots with Speed I.").getDouble(darkSteelSpeedOneWalkModifier);
    darkSteelSpeedTwoWalkMultiplier = (float) config.get(sectionDarkSteel, "darkSteelSpeedTwoWalkMultiplier", darkSteelSpeedTwoWalkMultiplier,
        "Speed modifier applied when walking in the Dark Steel Boots with Speed I.").getDouble(darkSteelSpeedTwoWalkMultiplier);
    darkSteelSpeedThreeWalkMultiplier = (float) config.get(sectionDarkSteel, "darkSteelSpeedThreeWalkMultiplier", darkSteelSpeedThreeWalkMultiplier,
        "Speed modifier applied when walking in the Dark Steel Boots with Speed I.").getDouble(darkSteelSpeedThreeWalkMultiplier);

    darkSteelSpeedOneSprintModifier = (float) config.get(sectionDarkSteel, "darkSteelSpeedOneSprintModifier", darkSteelSpeedOneSprintModifier,
        "Speed modifier applied when walking in the Dark Steel Boots with Speed I.").getDouble(darkSteelSpeedOneSprintModifier);
    darkSteelSpeedTwoSprintMultiplier = (float) config.get(sectionDarkSteel, "darkSteelSpeedTwoSprintMultiplier", darkSteelSpeedTwoSprintMultiplier,
        "Speed modifier applied when walking in the Dark Steel Boots with Speed I.").getDouble(darkSteelSpeedTwoSprintMultiplier);
    darkSteelSpeedThreeSprintMultiplier = (float) config.get(sectionDarkSteel, "darkSteelSpeedThreeSprintMultiplier", darkSteelSpeedThreeSprintMultiplier,
        "Speed modifier applied when walking in the Dark Steel Boots with Speed I.").getDouble(darkSteelSpeedThreeSprintMultiplier);

    darkSteelBootsJumpModifier = config.get(sectionDarkSteel, "darkSteelBootsJumpModifier", darkSteelBootsJumpModifier,
        "Jump height modifier applied when jumping with Dark Steel Boots equipped").getDouble(darkSteelBootsJumpModifier);

    darkSteelPowerStorageBase = config.get(sectionDarkSteel, "darkSteelPowerStorage", darkSteelPowerStorageBase,
        "Amount of power stored (RF) per crystal in the armor items recipe.").getInt(darkSteelPowerStorageBase);
    darkSteelWalkPowerCost = config.get(sectionDarkSteel, "darkSteelWalkPowerCost", darkSteelWalkPowerCost,
        "Amount of power stored (RF) per block walked when wearing the dark steel boots.").getInt(darkSteelWalkPowerCost);
    darkSteelSprintPowerCost = config.get(sectionDarkSteel, "darkSteelSprintPowerCost", darkSteelWalkPowerCost,
        "Amount of power stored (RF) per block walked when wearing the dark steel boots.").getInt(darkSteelSprintPowerCost);
    darkSteelDrainPowerFromInventory = config.get(sectionDarkSteel, "darkSteelDrainPowerFromInventory", darkSteelDrainPowerFromInventory,
        "If true, dark steel armor will drain power stored (RF) in power containers in the players inventory.").getBoolean(darkSteelDrainPowerFromInventory);

    darkSteelBootsJumpPowerCost = config.get(sectionDarkSteel, "darkSteelBootsJumpPowerCost", darkSteelBootsJumpPowerCost,
        "Base amount of power used per jump (RF) dark steel boots. The second jump in a 'double jump' uses 2x this etc").getInt(darkSteelBootsJumpPowerCost);

    darkSteelFallDistanceCost = config.get(sectionDarkSteel, "darkSteelFallDistanceCost", darkSteelFallDistanceCost,
        "Amount of power used (RF) per block height of fall distance damage negated.").getInt(darkSteelFallDistanceCost);

    darkSteelSwimCost = config.get(sectionDarkSteel, "darkSteelSwimCost", darkSteelSwimCost,
        "Number of levels required for the 'Swim' upgrade.").getInt(darkSteelSwimCost);

    darkSteelNightVisionCost = config.get(sectionDarkSteel, "darkSteelNightVisionCost", darkSteelNightVisionCost,
        "Number of levels required for the 'Night Vision' upgrade.").getInt(darkSteelNightVisionCost);

    darkSteelGliderCost = config.get(sectionDarkSteel, "darkSteelGliderCost", darkSteelGliderCost,
        "Number of levels required for the 'Glider' upgrade.").getInt(darkSteelGliderCost);
    darkSteelGliderHorizontalSpeed = config.get(sectionDarkSteel, "darkSteelGliderHorizontalSpeed", darkSteelGliderHorizontalSpeed,
        "Horizontal movement speed modifier when gliding.").getDouble(darkSteelGliderHorizontalSpeed);
    darkSteelGliderVerticalSpeed = config.get(sectionDarkSteel, "darkSteelGliderVerticalSpeed", darkSteelGliderVerticalSpeed,
        "Rate of altitude loss when gliding.").getDouble(darkSteelGliderVerticalSpeed);
    darkSteelGliderVerticalSpeedSprinting = config.get(sectionDarkSteel, "darkSteelGliderVerticalSpeedSprinting", darkSteelGliderVerticalSpeedSprinting,
        "Rate of altitude loss when sprinting and gliding.").getDouble(darkSteelGliderVerticalSpeedSprinting);

    darkSteelSoundLocatorCost = config.get(sectionDarkSteel, "darkSteelSoundLocatorCost", darkSteelSoundLocatorCost,
        "Number of levels required for the 'Sound Locator' upgrade.").getInt(darkSteelSoundLocatorCost);
    darkSteelSoundLocatorRange = config.get(sectionDarkSteel, "darkSteelSoundLocatorRange", darkSteelSoundLocatorRange,
        "Range of the 'Sound Locator' upgrade.").getInt(darkSteelSoundLocatorRange);
    darkSteelSoundLocatorLifespan = config.get(sectionDarkSteel, "darkSteelSoundLocatorLifespan", darkSteelSoundLocatorLifespan,
        "Number of ticks the 'Sound Locator' icons are displayed for.").getInt(darkSteelSoundLocatorLifespan);
    
    darkSteelGogglesOfRevealingCost= config.get(sectionDarkSteel, "darkSteelGogglesOfRevealingCost", darkSteelGogglesOfRevealingCost,
        "Number of levels required for the Goggles of Revealing upgrade.").getInt(darkSteelGogglesOfRevealingCost);
    
    darkSteelApiaristArmorCost= config.get(sectionDarkSteel, "darkSteelApiaristArmorCost", darkSteelApiaristArmorCost,
        "Number of levels required for the Apiarist Armor upgrade.").getInt(darkSteelApiaristArmorCost);

    darkSteelTravelCost = config.get(sectionDarkSteel, "darkSteelTravelCost", darkSteelTravelCost,
        "Number of levels required for the 'Travel' upgrade.").getInt(darkSteelTravelCost);
    
    darkSteelSpoonCost = config.get(sectionDarkSteel, "darkSteelSpoonCost", darkSteelSpoonCost,
        "Number of levels required for the 'Spoon' upgrade.").getInt(darkSteelSpoonCost);

    darkSteelSolarOneCost = config.get(sectionDarkSteel, "darkSteelSolarOneCost", darkSteelSolarOneCost,
        "Cost in XP levels of the Solar I upgrade.").getInt();
    darkSteelSolarOneGen = config.get(sectionDarkSteel, "darkSteelSolarOneGen", darkSteelSolarOneGen,
        "RF per SECOND generated by the Solar I upgrade. Split between all equipped DS armors.").getInt();
  
    darkSteelSolarTwoCost = config.get(sectionDarkSteel, "darkSteelSolarTwoCost", darkSteelSolarTwoCost,
        "Cost in XP levels of the Solar II upgrade.").getInt();
    darkSteelSolarTwoGen = config.get(sectionDarkSteel, "darkSteelSolarTwoGen", darkSteelSolarTwoGen,
        "RF per SECOND generated by the Solar II upgrade. Split between all equipped DS armors.").getInt();
    darkSteelSolarChargeOthers = config.get(sectionDarkSteel, "darkSteelSolarChargeOthers", darkSteelSolarChargeOthers,
        "If enabled allows the solar upgrade to charge non-darksteel armors that the player is wearing.").getBoolean();

    darkSteelSwordSkullChance = (float) config.get(sectionDarkSteel, "darkSteelSwordSkullChance", darkSteelSwordSkullChance,
        "The base chance that a skull will be dropped when using a powered dark steel sword (0 = no chance, 1 = 100% chance)").getDouble(
        darkSteelSwordSkullChance);
    darkSteelSwordSkullLootingModifier = (float) config.get(sectionDarkSteel, "darkSteelSwordSkullLootingModifier", darkSteelSwordSkullLootingModifier,
        "The chance per looting level that a skull will be dropped when using a powered dark steel sword (0 = no chance, 1 = 100% chance)").getDouble(
        darkSteelSwordSkullLootingModifier);

    darkSteelSwordWitherSkullChance = (float) config.get(sectionDarkSteel, "darkSteelSwordWitherSkullChance", darkSteelSwordWitherSkullChance,
        "The base chance that a wither skull will be dropped when using a powered dark steel sword (0 = no chance, 1 = 100% chance)").getDouble(
        darkSteelSwordWitherSkullChance);
    darkSteelSwordWitherSkullLootingModifier = (float) config.get(sectionDarkSteel, "darkSteelSwordWitherSkullLootingModifie",
        darkSteelSwordWitherSkullLootingModifier,
        "The chance per looting level that a wither skull will be dropped when using a powered dark steel sword (0 = no chance, 1 = 100% chance)").getDouble(
        darkSteelSwordWitherSkullLootingModifier);

    vanillaSwordSkullChance = (float) config.get(sectionDarkSteel, "vanillaSwordSkullChance", vanillaSwordSkullChance,
        "The base chance that a skull will be dropped when using a non dark steel sword (0 = no chance, 1 = 100% chance)").getDouble(
        vanillaSwordSkullChance);
    vanillaSwordSkullLootingModifier = (float) config.get(sectionPersonal, "vanillaSwordSkullLootingModifier", vanillaSwordSkullLootingModifier,
        "The chance per looting level that a skull will be dropped when using a non-dark steel sword (0 = no chance, 1 = 100% chance)").getDouble(
        vanillaSwordSkullLootingModifier);

    ticCleaverSkullDropChance = (float) config.get(sectionDarkSteel, "ticCleaverSkullDropChance", ticCleaverSkullDropChance,
        "The base chance that an Enderman Skull will be dropped when using TiC Cleaver").getDouble(
        ticCleaverSkullDropChance);
    ticBeheadingSkullModifier = (float) config.get(sectionPersonal, "ticBeheadingSkullModifier", ticBeheadingSkullModifier,
        "The chance per level of Beheading that a skull will be dropped when using a TiC weapon").getDouble(
        ticBeheadingSkullModifier);

    fakePlayerSkullChance = (float) config
        .get(
            sectionDarkSteel,
            "fakePlayerSkullChance",
            fakePlayerSkullChance,
            "The ratio of skull drops when a mob is killed by a 'FakePlayer', such as Killer Joe. When set to 0 no skulls will drop, at 1 the rate of skull drops is not modified")
        .getDouble(
            fakePlayerSkullChance);

    darkSteelSwordPowerUsePerHit = config.get(sectionDarkSteel, "darkSteelSwordPowerUsePerHit", darkSteelSwordPowerUsePerHit,
        "The amount of power (RF) used per hit.").getInt(darkSteelSwordPowerUsePerHit);
    darkSteelSwordEnderPearlDropChance = config.get(sectionDarkSteel, "darkSteelSwordEnderPearlDropChance", darkSteelSwordEnderPearlDropChance,
        "The chance that an ender pearl will be dropped when using a dark steel sword (0 = no chance, 1 = 100% chance)").getDouble(
        darkSteelSwordEnderPearlDropChance);
    darkSteelSwordEnderPearlDropChancePerLooting = config.get(sectionDarkSteel, "darkSteelSwordEnderPearlDropChancePerLooting",
        darkSteelSwordEnderPearlDropChancePerLooting,
        "The chance for each looting level that an additional ender pearl will be dropped when using a dark steel sword (0 = no chance, 1 = 100% chance)")
        .getDouble(
            darkSteelSwordEnderPearlDropChancePerLooting);

    darkSteelPickPowerUseObsidian = config.get(sectionDarkSteel, "darkSteelPickPowerUseObsidian", darkSteelPickPowerUseObsidian,
        "The amount of power (RF) used to break an obsidian block.").getInt(darkSteelPickPowerUseObsidian);
    darkSteelPickEffeciencyObsidian = config.get(sectionDarkSteel, "darkSteelPickEffeciencyObsidian", darkSteelPickEffeciencyObsidian,
        "The efficiency when breaking obsidian with a powered Dark Pickaxe.").getInt(darkSteelPickEffeciencyObsidian);
    darkSteelPickApplyObsidianEffeciencyAtHardess = (float) config.get(sectionDarkSteel, "darkSteelPickApplyObsidianEffeciencyAtHardess",
        darkSteelPickApplyObsidianEffeciencyAtHardess,
        "If set to a value > 0, the obsidian speed and power use will be used for all blocks with hardness >= to this value.").getDouble(
        darkSteelPickApplyObsidianEffeciencyAtHardess);
    darkSteelPickPowerUsePerDamagePoint = config.get(sectionDarkSteel, "darkSteelPickPowerUsePerDamagePoint", darkSteelPickPowerUsePerDamagePoint,
        "Power use (RF) per damage/durability point avoided.").getInt(darkSteelPickPowerUsePerDamagePoint);
    darkSteelPickEffeciencyBoostWhenPowered = (float) config.get(sectionDarkSteel, "darkSteelPickEffeciencyBoostWhenPowered",
        darkSteelPickEffeciencyBoostWhenPowered, "The increase in efficiency when powered.").getDouble(darkSteelPickEffeciencyBoostWhenPowered);
    darkSteelPickMinesTiCArdite = config.getBoolean("darkSteelPickMinesTiCArdite", sectionDarkSteel, darkSteelPickMinesTiCArdite,
        "When true the dark steel pick will be able to mine TiC Ardite and Cobalt");

    darkSteelAxePowerUsePerDamagePoint = config.get(sectionDarkSteel, "darkSteelAxePowerUsePerDamagePoint", darkSteelAxePowerUsePerDamagePoint,
        "Power use (RF) per damage/durability point avoided.").getInt(darkSteelAxePowerUsePerDamagePoint);
    darkSteelAxePowerUsePerDamagePointMultiHarvest = config.get(sectionDarkSteel, "darkSteelPickAxeUsePerDamagePointMultiHarvest",
        darkSteelAxePowerUsePerDamagePointMultiHarvest,
        "Power use (RF) per damage/durability point avoided when shift-harvesting multiple logs").getInt(darkSteelAxePowerUsePerDamagePointMultiHarvest);
    darkSteelAxeSpeedPenaltyMultiHarvest = (float) config.get(sectionDarkSteel, "darkSteelAxeSpeedPenaltyMultiHarvest",
        darkSteelAxeSpeedPenaltyMultiHarvest,
        "How much slower shift-harvesting logs is.").getDouble(darkSteelAxeSpeedPenaltyMultiHarvest);
    darkSteelAxeEffeciencyBoostWhenPowered = (float) config.get(sectionDarkSteel, "darkSteelAxeEffeciencyBoostWhenPowered",
        darkSteelAxeEffeciencyBoostWhenPowered, "The increase in efficiency when powered.").getDouble(darkSteelAxeEffeciencyBoostWhenPowered);

    darkSteelAnvilDamageChance = (float) config.get(sectionDarkSteel, "darkSteelAnvilDamageChance", darkSteelAnvilDamageChance, "Chance that the dark steel anvil will take damage after repairing something.").getDouble();

    darkSteelLadderSpeedBoost = (float) config.get(sectionDarkSteel, "darkSteelLadderSpeedBoost", darkSteelLadderSpeedBoost, "Speed boost, in blocks per tick, that the DS ladder gives over the vanilla ladder.").getDouble();
    
    hootchPowerPerCycleRF = config.get(sectionPower, "hootchPowerPerCycleRF", hootchPowerPerCycleRF,
        "The amount of power generated per BC engine cycle. Examples: BC Oil = 30, BC Fuel = 60").getInt(hootchPowerPerCycleRF);
    hootchPowerTotalBurnTime = config.get(sectionPower, "hootchPowerTotalBurnTime", hootchPowerTotalBurnTime,
        "The total burn time. Examples: BC Oil = 5000, BC Fuel = 25000").getInt(hootchPowerTotalBurnTime);

    rocketFuelPowerPerCycleRF = config.get(sectionPower, "rocketFuelPowerPerCycleRF", rocketFuelPowerPerCycleRF,
        "The amount of power generated per BC engine cycle. Examples: BC Oil = 3, BC Fuel = 6").getInt(rocketFuelPowerPerCycleRF);
    rocketFuelPowerTotalBurnTime = config.get(sectionPower, "rocketFuelPowerTotalBurnTime", rocketFuelPowerTotalBurnTime,
        "The total burn time. Examples: BC Oil = 5000, BC Fuel = 25000").getInt(rocketFuelPowerTotalBurnTime);

    fireWaterPowerPerCycleRF = config.get(sectionPower, "fireWaterPowerPerCycleRF", fireWaterPowerPerCycleRF,
        "The amount of power generated per BC engine cycle. Examples: BC Oil = 30, BC Fuel = 60").getInt(fireWaterPowerPerCycleRF);
    fireWaterPowerTotalBurnTime = config.get(sectionPower, "fireWaterPowerTotalBurnTime", fireWaterPowerTotalBurnTime,
        "The total burn time. Examples: BC Oil = 5000, BC Fuel = 25000").getInt(fireWaterPowerTotalBurnTime);

    zombieGeneratorRfPerTick = config.get(sectionPower, "zombieGeneratorRfPerTick", zombieGeneratorRfPerTick,
        "The amount of power generated per tick.").getInt(zombieGeneratorRfPerTick);
    zombieGeneratorTicksPerBucketFuel = config.get(sectionPower, "zombieGeneratorTicksPerMbFuel", zombieGeneratorTicksPerBucketFuel,
        "The number of ticks one bucket of fuel lasts.").getInt(zombieGeneratorTicksPerBucketFuel);

    stirlingGeneratorBaseRfPerTick = config.get(sectionPower, "stirlingGeneratorBaseRfPerTick", stirlingGeneratorBaseRfPerTick,
        "The amount of power generated per tick.").getInt(stirlingGeneratorBaseRfPerTick);

    addFuelTooltipsToAllFluidContainers = config.get(sectionPersonal, "addFuelTooltipsToAllFluidContainers", addFuelTooltipsToAllFluidContainers,
        "If true, the RF/t and burn time of the fuel will be displayed in all tooltips for fluid containers with fuel.").getBoolean(
        addFuelTooltipsToAllFluidContainers);
    addDurabilityTootip = config.get(sectionPersonal, "addDurabilityTootip", addFuelTooltipsToAllFluidContainers,
        "If true, adds durability tooltips to tools and armor").getBoolean(
        addDurabilityTootip);
    addFurnaceFuelTootip = config.get(sectionPersonal, "addFurnaceFuelTootip", addFuelTooltipsToAllFluidContainers,
        "If true, adds burn duration tooltips to furnace fuels").getBoolean(addFurnaceFuelTootip);
    addOreDictionaryTooltips = config.get(sectionPersonal, "addOreDictionaryTooltips", addOreDictionaryTooltips,
        "If true, adds ore dictionary registrations to tooltips").getBoolean(addOreDictionaryTooltips);
    addRegisterdNameTooltip = config.get(sectionPersonal, "addRegisterdNameTooltip", addRegisterdNameTooltip,
        "If true, adds the registered for the item").getBoolean(addRegisterdNameTooltip);

    farmContinuousEnergyUseRF = config.get(sectionFarm, "farmContinuousEnergyUseRF", farmContinuousEnergyUseRF,
        "The amount of power used by a farm per tick ").getInt(farmContinuousEnergyUseRF);
    farmActionEnergyUseRF = config.get(sectionFarm, "farmActionEnergyUseRF", farmActionEnergyUseRF,
        "The amount of power used by a farm per action (eg plant, till, harvest) ").getInt(farmActionEnergyUseRF);
    farmAxeActionEnergyUseRF = config.get(sectionFarm, "farmAxeActionEnergyUseRF", farmAxeActionEnergyUseRF,
        "The amount of power used by a farm per wood block 'chopped'").getInt(farmAxeActionEnergyUseRF);

    farmDefaultSize = config.get(sectionFarm, "farmDefaultSize", farmDefaultSize,
        "The number of blocks a farm will extend from its center").getInt(farmDefaultSize);

    farmAxeDamageOnLeafBreak = config.get(sectionFarm, "farmAxeDamageOnLeafBreak", farmAxeDamageOnLeafBreak,
        "Should axes in a farm take damage when breaking leaves?").getBoolean(farmAxeDamageOnLeafBreak);
    farmToolTakeDamageChance = (float) config.get(sectionFarm, "farmToolTakeDamageChance", farmToolTakeDamageChance,
        "The chance that a tool in the farm will take damage.").getDouble(farmToolTakeDamageChance);

    disableFarmNotification = config.get(sectionFarm, "disableFarmNotifications", disableFarmNotification,
        "Disable the notification text above the farm block.").getBoolean();
    
    farmEssenceBerriesEnabled = config.get(sectionFarm, "farmEssenceBerriesEnabled", farmEssenceBerriesEnabled,
        "This setting controls whether essence berry bushes from TiC can be harvested by the farm.").getBoolean();

    farmManaBeansEnabled = config.get(sectionFarm, "farmManaBeansEnabled", farmManaBeansEnabled,
            "This setting controls whether mana beans from Thaumcraft can be harvested by the farm.").getBoolean();
    
    farmHarvestJungleWhenCocoa = config.get(sectionFarm, "farmHarvestJungleWhenCocoa", farmHarvestJungleWhenCocoa,
        "If this is enabled the farm will harvest jungle wood even if it has cocoa beans in its inventory.").getBoolean();    

    hoeStrings = config.get(sectionFarm, "farmHoes", hoeStrings,
        "Use this to specify items that can be hoes in the farming station. Use the registry (eg. modid).").getStringList();

    combustionGeneratorUseOpaqueModel = config.get(sectionAesthetic, "combustionGeneratorUseOpaqueModel", combustionGeneratorUseOpaqueModel,
        "If set to true: fluid will not be shown in combustion generator tanks. Improves FPS. ").getBoolean(combustionGeneratorUseOpaqueModel);

    magnetPowerUsePerSecondRF = config.get(sectionMagnet, "magnetPowerUsePerTickRF", magnetPowerUsePerSecondRF,
        "The amount of RF power used per tick when the magnet is active").getInt(magnetPowerUsePerSecondRF);
    magnetPowerCapacityRF = config.get(sectionMagnet, "magnetPowerCapacityRF", magnetPowerCapacityRF,
        "Amount of RF power stored in a fully charged magnet").getInt(magnetPowerCapacityRF);
    magnetRange = config.get(sectionMagnet, "magnetRange", magnetRange,
        "Range of the magnet in blocks.").getInt(magnetRange);

    useCombustionGenModel = config.get(sectionAesthetic, "useCombustionGenModel", useCombustionGenModel,
        "If set to true: WIP Combustion Generator model will be used").getBoolean(useCombustionGenModel);

    crafterRfPerCraft = config.get("AutoCrafter Settings", "crafterRfPerCraft", crafterRfPerCraft,
        "RF used per autocrafted recipe").getInt(crafterRfPerCraft);

    poweredSpawnerMinDelayTicks = config.get(sectionSpawner, "poweredSpawnerMinDelayTicks", poweredSpawnerMinDelayTicks,
        "Min tick delay between spawns for a non-upgraded spawner").getInt(poweredSpawnerMinDelayTicks);
    poweredSpawnerMaxDelayTicks = config.get(sectionSpawner, "poweredSpawnerMaxDelayTicks", poweredSpawnerMaxDelayTicks,
        "Min tick delay between spawns for a non-upgraded spawner").getInt(poweredSpawnerMaxDelayTicks);
    poweredSpawnerLevelOnePowerPerTickRF = config.get(sectionSpawner, "poweredSpawnerLevelOnePowerPerTickRF", poweredSpawnerLevelOnePowerPerTickRF,
        "RF per tick for a level 1 (non-upgraded) spawner. See PoweredSpanerConfig_Core.json for mob type multipliers").getInt(poweredSpawnerLevelOnePowerPerTickRF);
    poweredSpawnerLevelTwoPowerPerTickRF = config.get(sectionSpawner, "poweredSpawnerLevelTwoPowerPerTickRF", poweredSpawnerLevelTwoPowerPerTickRF,
        "RF per tick for a level 2 spawner").getInt(poweredSpawnerLevelTwoPowerPerTickRF);
    poweredSpawnerLevelThreePowerPerTickRF = config.get(sectionSpawner, "poweredSpawnerLevelThreePowerPerTickRF",
        poweredSpawnerLevelThreePowerPerTickRF,
        "RF per tick for a level 3 spawner").getInt(poweredSpawnerLevelThreePowerPerTickRF);
    poweredSpawnerMaxPlayerDistance = config.get(sectionSpawner, "poweredSpawnerMaxPlayerDistance", poweredSpawnerMaxPlayerDistance,
        "Max distance of the closest player for the spawner to be active. A zero value will remove the player check").getInt(poweredSpawnerMaxPlayerDistance);
    poweredSpawnerUseVanillaSpawChecks = config.get(sectionSpawner, "poweredSpawnerUseVanillaSpawChecks", poweredSpawnerUseVanillaSpawChecks,
        "If true, regular spawn checks such as lighting level and dimension will be made before spawning mobs").getBoolean(poweredSpawnerUseVanillaSpawChecks);
    brokenSpawnerDropChance = (float) config.get(sectionSpawner, "brokenSpawnerDropChance", brokenSpawnerDropChance,
        "The chance a broken spawner will be dropped when a spawner is broken. 1 = 100% chance, 0 = 0% chance").getDouble(brokenSpawnerDropChance);    
    brokenSpawnerToolBlacklist = config.getStringList("brokenSpawnerToolBlacklist", sectionSpawner, brokenSpawnerToolBlacklist, 
        "When a spawner is broken with these tools they will not drop a broken spawner");
    
    powerSpawnerAddSpawnerCost = config.get(sectionSpawner, "powerSpawnerAddSpawnerCost", powerSpawnerAddSpawnerCost,
        "The number of levels it costs to add a broken spawner").getInt(powerSpawnerAddSpawnerCost);    

    useModMetals = config.get(sectionRecipe, "useModMetals", useModMetals,
        "If true copper and tin will be used in recipes when registered in the ore dictionary").getBoolean(useModMetals);

    nutrientFoodBoostDelay = config.get(sectionFluid, "nutrientFluidFoodBoostDelay", nutrientFoodBoostDelay,
        "The delay in ticks between when nutrient distillation boosts your food value.").getInt((int) nutrientFoodBoostDelay);

    killerJoeNutrientUsePerAttackMb = config.get(sectionKiller, "killerJoeNutrientUsePerAttackMb", killerJoeNutrientUsePerAttackMb,
        "The number of millibuckets of nutrient fluid used per attack.").getInt(killerJoeNutrientUsePerAttackMb);

    killerJoeAttackHeight = config.get(sectionKiller, "killerJoeAttackHeight", killerJoeAttackHeight,
        "The reach of attacks above and bellow Joe.").getDouble(killerJoeAttackHeight);
    killerJoeAttackWidth = config.get(sectionKiller, "killerJoeAttackWidth", killerJoeAttackWidth,
        "The reach of attacks to each side of Joe.").getDouble(killerJoeAttackWidth);
    killerJoeAttackLength = config.get(sectionKiller, "killerJoeAttackLength", killerJoeAttackLength,
        "The reach of attacks in front of Joe.").getDouble(killerJoeAttackLength);   
    killerJoeHooverXpLength = config.get(sectionKiller, "killerJoeHooverXpLength", killerJoeHooverXpLength,
        "The distance from which XP will be gathered to each side of Joe.").getDouble(killerJoeHooverXpLength);
    killerJoeHooverXpWidth = config.get(sectionKiller, "killerJoeHooverXpWidth", killerJoeHooverXpWidth,
        "The distance from which XP will be gathered in front of Joe.").getDouble(killerJoeHooverXpWidth);
    killerJoeMaxXpLevel = config.get(sectionMisc, "killerJoeMaxXpLevel", killerJoeMaxXpLevel, "Maximum level of XP the killer joe can contain.").getInt();

    killerJoeMustSee = config.get(sectionKiller, "killerJoeMustSee", killerJoeMustSee, "Set whether the Killer Joe can attack through blocks.").getBoolean();

    isGasConduitEnabled = config.getString("isGasConduitEnabled", sectionItems, isGasConduitEnabled,
        "Can be set to 'auto', 'true' or 'false'. When set to auto the gas conduit will only be enabled when Mekanism is installed.");
    enableMEConduits = config.getBoolean("enableMEConduits", sectionItems, enableMEConduits,
        "Allows ME conduits. Only has an effect with AE2 installed.");
    
    soulVesselBlackList = config.getStringList("soulVesselBlackList", sectionSoulBinder, soulVesselBlackList,
        "Entities listed here will can not be captured in a Soul Vial");

    soulVesselCapturesBosses = config.getBoolean("soulVesselCapturesBosses", sectionSoulBinder, soulVesselCapturesBosses,
        "When set to false, any mob with a 'boss bar' won't be able to be captured in the Soul Vial");

    soulBinderLevelOnePowerPerTickRF = config.get(sectionSoulBinder, "soulBinderLevelOnePowerPerTickRF", soulBinderLevelOnePowerPerTickRF,
        "The number of RF/t consumed by an unupgraded soul binder.").getInt(soulBinderLevelOnePowerPerTickRF);
    soulBinderLevelTwoPowerPerTickRF = config.get(sectionSoulBinder, "soulBinderLevelTwoPowerPerTickRF", soulBinderLevelTwoPowerPerTickRF,
        "The number of RF/t consumed by a soul binder with a double layer capacitor upgrade.").getInt(soulBinderLevelTwoPowerPerTickRF);
    soulBinderLevelThreePowerPerTickRF = config.get(sectionSoulBinder, "soulBinderLevelThreePowerPerTickRF", soulBinderLevelThreePowerPerTickRF,
        "The number of RF/t consumed by a soul binder with an octadic capacitor upgrade.").getInt(soulBinderLevelThreePowerPerTickRF);
    soulBinderBrokenSpawnerRF = config.get(sectionSoulBinder, "soulBinderBrokenSpawnerRF", soulBinderBrokenSpawnerRF,
        "The number of RF required to change the type of a broken spawner.").getInt(soulBinderBrokenSpawnerRF);
    soulBinderReanimationRF = config.get(sectionSoulBinder, "soulBinderReanimationRF", soulBinderReanimationRF,
        "The number of RF required to to re-animated a mob head.").getInt(soulBinderReanimationRF);
    soulBinderEnderCystalRF = config.get(sectionSoulBinder, "soulBinderEnderCystalRF", soulBinderEnderCystalRF,
        "The number of RF required to create an ender crystal.").getInt(soulBinderEnderCystalRF);
    soulBinderAttractorCystalRF = config.get(sectionSoulBinder, "soulBinderAttractorCystalRF", soulBinderAttractorCystalRF,
        "The number of RF required to create an attractor crystal.").getInt(soulBinderAttractorCystalRF);
    soulBinderEnderRailRF = config.get(sectionSoulBinder, "soulBinderEnderRailRF", soulBinderEnderRailRF,
        "The number of RF required to create an ender rail.").getInt(soulBinderEnderRailRF);
    
    soulBinderAttractorCystalLevels = config.get(sectionSoulBinder, "soulBinderAttractorCystalLevels", soulBinderAttractorCystalLevels,
        "The number of levels required to create an attractor crystal.").getInt(soulBinderAttractorCystalLevels);
    soulBinderEnderCystalLevels = config.get(sectionSoulBinder, "soulBinderEnderCystalLevels", soulBinderEnderCystalLevels,
        "The number of levels required to create an ender crystal.").getInt(soulBinderEnderCystalLevels);
    soulBinderReanimationLevels = config.get(sectionSoulBinder, "soulBinderReanimationLevels", soulBinderReanimationLevels,
        "The number of levels required to re-animate a mob head.").getInt(soulBinderReanimationLevels);
    soulBinderBrokenSpawnerLevels = config.get(sectionSoulBinder, "soulBinderBrokenSpawnerLevels", soulBinderBrokenSpawnerLevels,
        "The number of levels required to change the type of a broken spawner.").getInt(soulBinderBrokenSpawnerLevels);
    soulBinderEnderRailLevels = config.get(sectionSoulBinder, "soulBinderEnderRailLevels", soulBinderEnderRailLevels,
        "The number of levels required to create an ender rail.").getInt(soulBinderEnderRailLevels);    

    soulBinderMaxXpLevel = config.get(sectionSoulBinder, "soulBinderMaxXPLevel", soulBinderMaxXpLevel, "Maximum level of XP the soul binder can contain.").getInt();


    sliceAndSpliceLevelOnePowerPerTickRF = config.get(sectionPower, "sliceAndSpliceLevelOnePowerPerTickRF", sliceAndSpliceLevelOnePowerPerTickRF,
        "The number of RF/t consumed by an unupgraded Slice'N'Splice").getInt(sliceAndSpliceLevelOnePowerPerTickRF);
    sliceAndSpliceLevelTwoPowerPerTickRF = config.get(sectionPower, "sliceAndSpliceLevelTwoPowerPerTickRF", sliceAndSpliceLevelTwoPowerPerTickRF,
        "The number of RF/t consumed by a Slice'N'Splice with a double layer capacitor upgrade.").getInt(sliceAndSpliceLevelTwoPowerPerTickRF);
    sliceAndSpliceLevelThreePowerPerTickRF = config.get(sectionPower, "sliceAndSpliceLevelThreePowerPerTickRF", sliceAndSpliceLevelThreePowerPerTickRF,
        "The number of RF/t consumed by a Slice'N'Splice with an octadic capacitor upgrade.").getInt(sliceAndSpliceLevelThreePowerPerTickRF);
    
    attractorRangeLevelOne = config.get(sectionAttractor, "attractorRangeLevelOne", attractorRangeLevelOne, 
        "The range of the mob attractor with no upgrades").getInt(attractorRangeLevelOne);
    attractorRangeLevelTwo = config.get(sectionAttractor, "attractorRangeLevelTwo", attractorRangeLevelTwo, 
        "The range of the mob attractor with a double layer capacitor upgrade").getInt(attractorRangeLevelTwo);
    attractorRangeLevelThree = config.get(sectionAttractor, "attractorRangeLevelThree", attractorRangeLevelThree, 
        "The range of the mob attractor with an octadic capacitor upgrade").getInt(attractorRangeLevelThree);    
    attractorPowerPerTickLevelOne = config.get(sectionAttractor, "attractorPowerPerTickLevelOne", attractorPowerPerTickLevelOne, 
        "The RF/t  power use of a levele 1 mob attractor").getInt(attractorPowerPerTickLevelOne);
    attractorPowerPerTickLevelTwo = config.get(sectionAttractor, "attractorPowerPerTickLevelTwo", attractorPowerPerTickLevelTwo, 
        "The RF/t  power use of a levele 2 mob attractor").getInt(attractorPowerPerTickLevelTwo);
    attractorPowerPerTickLevelThree = config.get(sectionAttractor, "attractorPowerPerTickLevelThree", attractorPowerPerTickLevelThree, 
        "The RF/t  power use of a levele 3 mob attractor").getInt(attractorPowerPerTickLevelThree);
    
    
    spawnGuardRangeLevelOne = config.get(sectionAttractor, "spawnGuardRangeLevelOne", spawnGuardRangeLevelOne, 
        "The range of the spawn guard with no upgrades").getInt(spawnGuardRangeLevelOne);
    spawnGuardRangeLevelTwo = config.get(sectionAttractor, "spawnGuardRangeLevelTwo", spawnGuardRangeLevelTwo, 
        "The range of the spawn guard with a double layer capacitor upgrade").getInt(spawnGuardRangeLevelTwo);
    spawnGuardRangeLevelThree = config.get(sectionAttractor, "spawnGuardRangeLevelThree", spawnGuardRangeLevelThree, 
        "The range of the spawn guard with an octadic capacitor upgrade").getInt(spawnGuardRangeLevelThree);    
    spawnGuardPowerPerTickLevelOne = config.get(sectionAttractor, "spawnGuardPowerPerTickLevelOne", spawnGuardPowerPerTickLevelOne, 
        "The RF/t  power use of a levele 1 spawn guard").getInt(spawnGuardPowerPerTickLevelOne);
    spawnGuardPowerPerTickLevelTwo = config.get(sectionAttractor, "spawnGuardPowerPerTickLevelTwo", spawnGuardPowerPerTickLevelTwo, 
        "The RF/t  power use of a levele 2 spawn guard").getInt(spawnGuardPowerPerTickLevelTwo);
    spawnGuardPowerPerTickLevelThree = config.get(sectionAttractor, "spawnGuardPowerPerTickLevelThree", spawnGuardPowerPerTickLevelThree, 
        "The RF/t  power use of a levele 3 spawn guard").getInt(spawnGuardPowerPerTickLevelThree);
    spawnGuardStopAllSlimesDebug = config.getBoolean("spawnGuardStopAllSlimesDebug", sectionAttractor, spawnGuardStopAllSlimesDebug, 
        "When true slimes wont be allowed to spawn at all. Only added to aid testing in super flat worlds.");    
    spawnGuardStopAllSquidSpawning = config.getBoolean("spawnGuardStopAllSquidSpawning", sectionAttractor, spawnGuardStopAllSquidSpawning, 
        "When true no squid will be spawned.");

    weatherObeliskClearItem = config.get(sectionWeather, "weatherObeliskClearItem", weatherObeliskClearItem,
        "The item required to set the world to clear weather.").getString();
    weatherObeliskRainItem = config.get(sectionWeather, "weatherObeliskRainItem", weatherObeliskRainItem,
        "The item required to set the world to rainy weather.").getString();
    weatherObeliskThunderItem = config.get(sectionWeather, "weatherObeliskThunderItem", weatherObeliskThunderItem,
        "The item required to set the world to thundering weather.").getString();
    weatherObeliskClearPower = config.get(sectionWeather, "weatherObeliskClearPower", weatherObeliskClearPower,
        "The power required to set the world to clear weather").getInt();
    weatherObeliskRainPower = config.get(sectionWeather, "weatherObeliskRainPower", weatherObeliskRainPower,
        "The power required to set the world to rainy weather").getInt();
    weatherObeliskThunderPower = config.get(sectionWeather, "weatherObeliskThunderPower", weatherObeliskThunderPower,
        "The power required to set the world to thundering weather").getInt();

    // Loot Config
    lootDarkSteel = config.getBoolean("lootDarkSteel", sectionLootConfig, lootDarkSteel, "Adds Darksteel Ingots to loot tables");
    lootItemConduitProbe = config.getBoolean("lootItemConduitProbe", sectionLootConfig, lootItemConduitProbe, "Adds ItemConduitProbe to loot tables");
    lootQuartz = config.getBoolean("lootQuartz", sectionLootConfig, lootQuartz, "Adds quartz to loot tables");
    lootNetherWart = config.getBoolean("lootNetherWart", sectionLootConfig, lootNetherWart, "Adds nether wart to loot tables");
    lootEnderPearl = config.getBoolean("lootEnderPearl", sectionLootConfig, lootEnderPearl, "Adds ender pearls to loot tables");
    lootElectricSteel = config.getBoolean("lootElectricSteel", sectionLootConfig, lootElectricSteel, "Adds Electric Steel Ingots to loot tables");
    lootRedstoneAlloy = config.getBoolean("lootRedstoneAlloy", sectionLootConfig, lootRedstoneAlloy, "Adds Redstone Alloy Ingots to loot tables");
    lootPhasedIron = config.getBoolean("lootPhasedIron", sectionLootConfig, lootPhasedIron, "Adds Phased Iron Ingots to loot tables");
    lootPhasedGold = config.getBoolean("lootPhasedGold", sectionLootConfig, lootPhasedGold, "Adds Phased Gold Ingots to loot tables");
    lootTravelStaff = config.getBoolean("lootTravelStaff", sectionLootConfig, lootTravelStaff, "Adds Travel Staff to loot tables");
    lootTheEnder = config.getBoolean("lootTheEnder", sectionLootConfig, lootTheEnder, "Adds The Ender to loot tables");
    lootDarkSteelBoots = config.getBoolean("lootDarkSteelBoots", sectionLootConfig, lootDarkSteelBoots, "Adds Darksteel Boots to loot tables");
    
    enderRailEnabled = config.getBoolean("enderRailEnabled", sectionRailConfig, enderRailEnabled, "Wether Ender Rails are enabled");
    enderRailPowerRequireCrossDimensions = config.get(sectionRailConfig, "enderRailPowerRequireCrossDimensions", enderRailPowerRequireCrossDimensions, 
        "The amount of power required to transport a cart across dimensions").getInt(enderRailPowerRequireCrossDimensions);
    enderRailPowerRequiredPerBlock = config.get(sectionRailConfig, "enderRailPowerRequiredPerBlock", enderRailPowerRequiredPerBlock, 
        "The amount of power required to teleport a cart per block in the same dimension").getInt(enderRailPowerRequiredPerBlock);
    enderRailCapSameDimensionPowerAtCrossDimensionCost = config.getBoolean("enderRailCapSameDimensionPowerAtCrossDimensionCost", sectionRailConfig, enderRailCapSameDimensionPowerAtCrossDimensionCost, 
        "When set to true the RF cost of sending a cart within the same dimension will be capped to the cross dimension cost");
    enderRailTicksBeforeForceSpawningLinkedCarts = config.get(sectionRailConfig, "enderRailTicksBeforeForceSpawningLinkedCarts", enderRailTicksBeforeForceSpawningLinkedCarts, 
        "The number of ticks to wait for the track to clear before force spawning the next cart in a (RailCraft) linked set").getInt(enderRailTicksBeforeForceSpawningLinkedCarts);
    enderRailTeleportPlayers = config.getBoolean("enderRailTeleportPlayers", sectionRailConfig, enderRailTeleportPlayers, "If true player in minecarts will be teleported. WARN: WIP, seems to cause a memory leak.");
    
    dumpMobNames = config.getBoolean("dumpMobNames", sectionMobConfig, dumpMobNames, 
        "When set to true a list of all registered mobs will be dumped to config/enderio/mobTypes.txt Thes are in the format required by EIOs mob blacklists.");
    
    xpObeliskMaxXpLevel = config.get(sectionMisc, "xpObeliskMaxXpLevel", xpObeliskMaxXpLevel, "Maximum level of XP the xp obelisk can contain.").getInt();
    xpJuiceName = config.getString("xpJuiceName", sectionMisc, xpJuiceName, "Id of liquid XP fluid (WARNING: only for users who know what they are doing - changing this id can break worlds) - this should match the with OpenBlocks when installed");
    
    clearGlassSameTexture = config.getBoolean("clearGlassSameTexture", sectionMisc, clearGlassSameTexture, "If true, quite clear glass will use the fused quartz border texture for the block instead of the white border.");
    clearGlassConnectToFusedQuartz = config.getBoolean("clearGlassConnectToFusedQuartz", sectionMisc, clearGlassConnectToFusedQuartz, "If true, quite clear glass will connect textures with fused quartz.");

    enchantmentSoulBoundEnabled = config.getBoolean("enchantmentSoulBoundEnabled", sectionEnchantments, enchantmentSoulBoundEnabled,
        "If false the soul bound enchantment will not be available");
    enchantmentSoulBoundId = config.get(sectionEnchantments, "enchantmentSoulBoundId", enchantmentSoulBoundId,
        "The id of the enchantment. If set to -1 the lowest unassigned id will be used.").getInt(enchantmentSoulBoundId);
    enchantmentSoulBoundWeight = config.get("enchantmentSoulBoundWeight", sectionEnchantments, enchantmentSoulBoundWeight,
        "The chance of getting this enchantment in the enchantment table").getInt(enchantmentSoulBoundWeight);


    replaceWitherSkeletons = config.get("replaceWitherSkeletons", sectionMisc, replaceWitherSkeletons,
            "Separates wither and normal skeletons into different entities, enables the powered spawner to treat them differently [EXPERIMENTAL - MAY CAUSE ISSUES WITH OTHER MODS]").getBoolean();
  }

  public static void init() {
    WeatherTask.CLEAR.setRequiredItem(getStackForString(weatherObeliskClearItem));
    WeatherTask.RAIN.setRequiredItem(getStackForString(weatherObeliskRainItem));
    WeatherTask.STORM.setRequiredItem(getStackForString(weatherObeliskThunderItem));
  }

  public static void postInit() {
    for (String s : hoeStrings) {
      ItemStack hoe = getStackForString(s);
      if(hoe != null) {
        farmHoes.add(hoe);
      }
    }
  }

  public static ItemStack getStackForString(String s) {
    String[] nameAndMeta = s.split(";");
    int meta = nameAndMeta.length == 1 ? 0 : Integer.parseInt(nameAndMeta[1]);
    String[] data = nameAndMeta[0].split(":");
    ItemStack stack = GameRegistry.findItemStack(data[0], data[1], 1);
    if(stack == null) {
      return null;
    }
    stack.setItemDamage(meta);
    return stack;
  }

  public static ConfigProcessor getProcessor() {
    return processor;
  }

  private Configs() {
  }
}
