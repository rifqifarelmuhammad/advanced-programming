package id.ac.ui.cs.advprog.tutorial2.template.core;

public class RegularCinema extends Cinema {
    @Override
    protected String turnOnAC() {
        return String.format("AC turned on with %s speed", ACSpeed.LOW);
    }

    @Override
    protected String turnOnSoundSystem() {
        return String.format("Turned on %s Sound System", soundSysType.STEREO);
    }

    @Override
    protected String playAds() {
        return """
                <div id="iklanRegular" class="modal fade" tabindex="-1" data-bs-backdrop="static" data-bs-keyboard="false">
                  <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                      <div class="modal-header">
                        <h5 class="modal-title">This is an ad</h5>
                      </div>
                      <div class="modal-body">
                        <p class="text-center fw-bold">AD SPACE AVAILABLE<br><br>081234567890</p>
                      </div>
                      <div class="modal-footer" style="justify-content: center;">
                        <p>Ad will be closed in <span id="CDRegular">10</span></p>
                      </div>
                    </div>
                  </div>
                </div>""";
    }

    @Override
    protected String playMovie() {
        return String.format("Playing movie in %s", movieQuality.QHD);
    }
}
