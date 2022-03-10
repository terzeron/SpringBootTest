package java.com.terzeron.springboot;

import com.terzeron.springboot.Item;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemUnitTest {
    @Test
    void itemBasicShouldWork() {
        Item sampleItem = new Item("item1", "TV tray", "Alf TV tray", 19.99);
        assertThat(sampleItem.getId()).isEqualTo("item1");
        assertThat(sampleItem.getName()).isEqualTo("TV tray");
        assertThat(sampleItem.getDescription()).isEqualTo("Alf TV tray");
        assertThat(sampleItem.getPrice()).isEqualTo(19.99);
        assertThat(sampleItem.toString())
                .isEqualTo("Item(id=item1, name=TV tray, description=Alf TV tray, price=19.99)");
        Item sampelItem2 = new Item("item1", "TV tray", "Alf TV tray", 19.99);
        assertThat(sampleItem).isEqualTo(sampelItem2);
    }
}
