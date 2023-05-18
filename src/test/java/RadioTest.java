import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Radio;

public class RadioTest {
    @Test
    public void shouldInitFields() {
        Radio radio = new Radio(15);

        Assertions.assertEquals(15, radio.getNumberOfStations());
        Assertions.assertEquals(14, radio.getMaxStation());
    }

    Radio radio = new Radio(20);

    @Test
    public void shouldSetStation() {

        radio.setCurrentStation(5);

        Assertions.assertEquals(5, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetStationAboveMax() {

        radio.setCurrentStation(7);
        radio.setCurrentStation(30);

        Assertions.assertEquals(7, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetStationBelowMin() {

        radio.setCurrentStation(0);
        radio.setCurrentStation(-5);

        Assertions.assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchToNextStation() {

        radio.setCurrentStation(6);
        radio.nextStation();

        Assertions.assertEquals(7, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchToMinStationIfMax() {

        radio.setCurrentStation(19);
        radio.nextStation();

        Assertions.assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchToPrevStation() {

        radio.setCurrentStation(1);
        radio.prevStation();

        Assertions.assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchToMaxStationIfMin() {

        radio.setCurrentStation(0);
        radio.prevStation();

        Assertions.assertEquals(19, radio.getCurrentStation());
    }

    @Test
    public void shouldSetVolume() {

        radio.setCurrentVolume(1);

        Assertions.assertEquals(1, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotSetVolumeBelowMin() {

        radio.setCurrentVolume(6);
        radio.setCurrentVolume(-3);

        Assertions.assertEquals(6, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotSetVolumeAboveMax() {

        radio.setCurrentVolume(100);
        radio.setCurrentVolume(150);

        Assertions.assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void shouldIncreaseVolume() {

        radio.setCurrentVolume(4);
        radio.increaseVolume();

        Assertions.assertEquals(5, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotIncreaseVolumeAboveMax() {

        radio.setCurrentVolume(100);
        radio.increaseVolume();

        Assertions.assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void shouldLowerVolume() {

        radio.setCurrentVolume(10);
        radio.lowerVolume();

        Assertions.assertEquals(9, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotLowerVolumeBelowMin() {

        radio.setCurrentVolume(0);
        radio.lowerVolume();

        Assertions.assertEquals(0, radio.getCurrentVolume());

    }
}
