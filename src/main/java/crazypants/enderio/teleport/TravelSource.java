package crazypants.enderio.teleport;

import crazypants.enderio.config.Configs;

public enum TravelSource {

  BLOCK(0, Configs.travelAnchorMaxDistance),
  STAFF(Configs.travelStaffPowerPerBlockRF, Configs.travelStaffMaxDistance),
  STAFF_BLINK(Configs.travelStaffPowerPerBlockRF, Configs.travelStaffMaxBlinkDistance);

  public static int getMaxDistance() {
    return STAFF.maxDistanceTravelledSq;
  }

  public static int getMaxDistanceSq() {
    return STAFF.maxDistanceTravelledSq;
  }

  public final float powerCostPerBlockTraveledRF;
  public final int maxDistanceTravelled;
  public final int maxDistanceTravelledSq;

  private TravelSource(float powerCostPerBlockTraveled, int maxDistanceTravelled) {
    this.powerCostPerBlockTraveledRF = powerCostPerBlockTraveled;
    this.maxDistanceTravelled = maxDistanceTravelled;
    maxDistanceTravelledSq = maxDistanceTravelled * maxDistanceTravelled;
  }

  public boolean getConserveMomentum() {
    return this == STAFF_BLINK;
  }

}