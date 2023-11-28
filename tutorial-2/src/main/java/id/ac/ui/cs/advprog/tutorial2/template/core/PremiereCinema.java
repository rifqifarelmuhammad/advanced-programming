package id.ac.ui.cs.advprog.tutorial2.template.core;

public class PremiereCinema extends Cinema {
    @Override
    protected String turnOnAC() {
        return String.format("AC turned on with %s speed", ACSpeed.HIGH);
    }

    @Override
    protected String turnOnSoundSystem() {
        return String.format("Turned on %s Sound System", soundSysType.SURROUND);
    }

    @Override
    protected String playAds() {
        return null;
    }

    @Override
    protected String playMovie() {
        return String.format("Playing movie in %s", movieQuality.UHD);
    }
}
